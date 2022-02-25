package br.senai.sp.cotia.quiosque.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.senai.sp.cotia.quiosque.model.Cliente;



public class DaoCliente {
	
private Connection conexao;
	
	public DaoCliente() {
		conexao = ConnectionFactory.conectar();
	}
	
	public void inserir(Cliente cliente) {
		String sql = "insert into tb_cliente(nome, endereco, telefone, email, data_nascimento, genero, data_cadastro)" 
					+ "values(?,?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setInt(3, cliente.getTelefone());
			stmt.setString(4, cliente.getEmail());
			stmt.setDate(5, new Date(cliente.getDataNascimento().getTimeInMillis()));
			stmt.setString(6, cliente.getGenero());
			Calendar agora = Calendar.getInstance();
			cliente.setDataCadastro(agora);
			stmt.setTimestamp(7, new Timestamp(cliente.getDataCadastro().getTimeInMillis()));
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void atualizar(Cliente cliente) {
		String sql = "update tb_cliente set nome = ?, endereco = ?, telefone = ?, email = ?, data_nascimento = ?, genero = ? where id = ?";
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setInt(3, cliente.getTelefone());
			stmt.setString(4, cliente.getEmail());
			stmt.setDate(5, new Date(cliente.getDataNascimento().getTimeInMillis()));
			stmt.setString(6, cliente.getGenero());
			stmt.setLong(7, cliente.getId());
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Cliente> listar() {
		String sql = "select * from tb_cliente order by nome asc";
		List<Cliente> lista = new ArrayList<>();
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Cliente c = new Cliente();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setEndereco(rs.getString("endereco"));
				c.setTelefone(rs.getInt("telefone"));
				c.setEmail(rs.getString("email"));
				
				// cria um Calendar
				Calendar nascimento = Calendar.getInstance();
				// extrair o Date do resultset
				Date dataBd = rs.getDate("data_nascimento");
				// "setar" a data do calendar pela data do date
				nascimento.setTimeInMillis(dataBd.getTime());
				// "setar" a validade no produto
				c.setDataNascimento(nascimento);
				
				c.setGenero(rs.getString("genero"));
				
				Calendar cad = Calendar.getInstance();
				Timestamp dataCadastro = rs.getTimestamp("data_cadastro");
				cad.setTimeInMillis(dataCadastro.getTime());
				c.setDataCadastro(cad);
				
				
				
				lista.add(c);
				
				
				
			}
			rs.close();
			stmt.close();
			conexao.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Cliente buscar(long idCliente) {
		String sql = "select * from tb_cliente where id = ?";
		Cliente c = null;
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, idCliente);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				c = new Cliente();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setEndereco(rs.getString("endereco"));
				c.setTelefone(rs.getInt("telefone"));
				c.setEmail(rs.getString("email"));
				// cria um Calendar
				Calendar nascimento = Calendar.getInstance();
				// extrair o Date do resultset
				Date dataBd = rs.getDate("data_nascimento");
				// "setar" a data do calendar pela data do date
				nascimento.setTimeInMillis(dataBd.getTime());
				// "setar" o nascimento do cliente
				c.setDataNascimento(nascimento);
				
				Calendar cad = Calendar.getInstance();
				Timestamp dataCadastro = rs.getTimestamp("data_cadastro");
				cad.setTimeInMillis(dataCadastro.getTime());
				c.setDataCadastro(cad);
				c.setGenero(rs.getString("genero"));
				
			
				
			}
			rs.close();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return c;
	}
	
	public void excluir(long id) {
		String sql = "delete from tb_cliente where id = ?";
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	

}
