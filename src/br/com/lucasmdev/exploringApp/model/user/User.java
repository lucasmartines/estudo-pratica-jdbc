package br.com.lucasmdev.exploringApp.model.user;

import java.util.Date;

/**
 * @author Lucas
 *
 */
public class User {
	private Integer id;
	private String nome;
	private String telefone;
	private Date idade;
	
	public User() {
		
	}
	
	
	/**
	 * @param nome
	 * @param telefone
	 * @param idade
	 */
	public User(String nome, String telefone, Date idade) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.idade = idade;
	}
	

	
	/**
	 * @param id
	 * @param nome
	 * @param telefone
	 * @param idade
	 */
	public User(Integer id, String nome, String telefone, Date idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.idade = idade;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getIdade() {
		return idade;
	}
	public void setIdade(Date idade) {
		this.idade = idade;
	}

	public String toString() {
		return "[Usuario"  
			+ " id: "       + id 
			+ " nome: "     + nome
			+ " telefone: " + telefone
			+ " idade: "    + idade
			+ "] "; 
	}
	
}
