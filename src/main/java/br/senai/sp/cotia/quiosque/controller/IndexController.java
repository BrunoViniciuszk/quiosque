package br.senai.sp.cotia.quiosque.controller;

import java.util.Calendar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import br.senai.sp.cotia.quiosque.dao.ConnectionFactory;
import br.senai.sp.cotia.quiosque.dao.DaoCliente;
import br.senai.sp.cotia.quiosque.model.Cliente;

@Controller
public class IndexController {
	@RequestMapping("index")
	public String index() {
		System.out.println("Passou aqui"+ConnectionFactory.conectar());
		return "index";
	}
	
	@RequestMapping("listarEstatisticas")
	public String diaSemana(Model model) {
		int manha=0, tarde=0, noite=0, masc=0, fem=0, contJovem=0, contAdulto=0, contIdoso=0, dom = 0, seg = 0, ter = 0, qua = 0, qui = 0, sex = 0, sab = 0;
		
		
		DaoCliente dao = new DaoCliente();
		
		for (Cliente cliente : dao.listar()) {
		
		// contador dia da semana
			cliente.getDataCadastro();
			switch(Calendar.DAY_OF_WEEK) {
	            case Calendar.SUNDAY:
	            	dom += 1;
	                break;
	            case Calendar.MONDAY:
	            	seg += 1;
	            	break;
	            case Calendar.TUESDAY:
	            	ter += 1;
	            	break;
	            case Calendar.WEDNESDAY:
	            	qua += 1;
	            	break;
	            case Calendar.THURSDAY:
	            	qui += 1;
	            	break;
	            case Calendar.FRIDAY:
	            	sex += 1;
	            	break;
	            case Calendar.SATURDAY:
	            	
	            	sab += 1;
	            	break;
	            default:
	                
	        }
			
			
			
			// contador periodo
			
			cliente.getDataCadastro();
			int hora = Calendar.HOUR_OF_DAY;
			
			if(hora < 12) {
				manha++;
			}else if(hora < 18) {
				tarde++;
			}else {
				noite++;
			}	
			
			
			
			// contador genero
			
			if(cliente.getGenero().equals("masculino")) {
				masc++;
			}else {
				fem++;
			}
			
			
			
			// contador faixa etária
			Calendar agora = Calendar.getInstance();
			
			int ano = agora.get(Calendar.YEAR);
			int clienteNasc = cliente.getDataNascimento().get(Calendar.YEAR);
			
			int idade = ano - clienteNasc;
			
			if(idade < 18) {
				contJovem++;
			}else if(idade > 20 && idade < 60) {
				contAdulto++;
			}else {
				contIdoso++;
			}
			
			}
		
		
		model.addAttribute("dom", dom);
		model.addAttribute("seg", seg);
		model.addAttribute("ter", ter);
		model.addAttribute("qua", qua);
		model.addAttribute("qui", qui);
		model.addAttribute("sex", sex);
		model.addAttribute("sab", sab);

		model.addAttribute("manha", manha);
		model.addAttribute("tarde", tarde);
		model.addAttribute("noite", noite);

		model.addAttribute("masc", masc);
		model.addAttribute("fem", fem);


		model.addAttribute("contJovem", contJovem);
		model.addAttribute("contAdulto", contAdulto);
		model.addAttribute("contIdoso", contIdoso);
		
		return "listarestatisticas";
	    }
	}
		


