package br.senai.sp.cotia.quiosque.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;

import br.senai.sp.cotia.quiosque.dao.DaoCliente;
import br.senai.sp.cotia.quiosque.model.Cliente;
import br.senai.sp.cotia.quiosque.model.ProdutoInteresse;

@Controller
public class ClienteController {
	@RequestMapping("formCliente")
	public String form(Model model) {
		model.addAttribute("tipos", ProdutoInteresse.values());
		return "formcliente";
	}
	
	@RequestMapping("SalvarCliente")
	public String salvarCliente(Cliente cliente) {
		System.out.println(cliente.getNome());
		System.out.println(cliente.getEmail());
		System.out.println(cliente.getEndereco());
		System.out.println(cliente.getTelefone());
		System.out.println(cliente.getDataNascimento());
		System.out.println(cliente.getDataCadastro());

		DaoCliente dao = new DaoCliente();
		if(cliente.getId() == null) {
			dao.inserir(cliente);
		}else{
			dao.atualizar(cliente);
		}
			
		return "redirect:listarCliente";
	}
	
	@RequestMapping("listarCliente")
	public String listarCliente(Model model) {
		DaoCliente dao = new DaoCliente();
		model.addAttribute("clientes", dao.listar());
		return "listarcliente";
	}
	
	@RequestMapping("excluirCliente")
	public String excluir(Long idCliente) {
		DaoCliente dao = new DaoCliente();
		dao.excluir(idCliente);
		return "redirect:listarCliente";
	}
	
	@RequestMapping("alterarCliente")
	public String alterar(long idCliente, Model model) {
		DaoCliente dao = new DaoCliente();
		model.addAttribute("cliente", dao.buscar(idCliente));
		return "forward:formCliente";
	}
	
	
	
}
