package br.com.lucasmdev.exploringApp.model.user;

public enum UserTableLabels {
	ID    (1),
	NAME  (2),
	TEL   (3),
	AGE   (4);

	private Integer valor; 

	UserTableLabels(int valor) {
		// TODO Auto-generated constructor stub
		this.valor = valor;
	}
	public Integer getValor() {
		return valor;
	}
	public Integer get() {
		return getValor();
	}
 
}
