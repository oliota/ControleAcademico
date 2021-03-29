package br.com.controle.academico.rubem.model;

public class Usuario {


	private int IdUsuario;
	private int PerfilId;
	private String Perfil; 
	private String Nome;
	private String Email;
	private String Logon;
	private String Senha; 

	public Usuario() {
	}

	 
	public Usuario(String logon,String nome) {
		setNome(nome);
		setLogon(logon);
	}


	public int getIdUsuario() {
		return IdUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}


	public int getPerfilId() {
		return PerfilId;
	}


	public void setPerfilId(int perfilId) {
		PerfilId = perfilId;
	}


	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getLogon() {
		return Logon;
	}


	public void setLogon(String logon) {
		Logon = logon;
	}


	public String getSenha() {
		return Senha;
	}


	public void setSenha(String senha) {
		Senha = senha;
	}


	public String getPerfil() {
		return Perfil;
	}


	public void setPerfil(String perfil) {
		Perfil = perfil;
	}
	
	

	


}
