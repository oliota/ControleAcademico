package br.com.controle.academico.rubem;

public class Usuario {
	private String Nome;
	private String Matricula;

	public Usuario() {
	}

	public Usuario( String matricula,String nome) {
		Matricula = matricula;
		Nome = nome;
	}

	public String getNome() {
		return Nome;
	}


	public String getMatricula() {
		return Matricula;
	}

	


}
