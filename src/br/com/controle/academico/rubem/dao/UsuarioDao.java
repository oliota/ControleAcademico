package br.com.controle.academico.rubem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.controle.academico.rubem.model.Aluno;
import br.com.controle.academico.rubem.model.Usuario;

public class UsuarioDao implements Cadastro {

	@Override
	public Object Adicionar(Object novo) {
		Usuario usuario = (Usuario) novo;
		BancoProway.ExecutarComandoBD("insert into Usuario" + "(PerfilId,Nome,Email,Logon,Senha)" + " Values " + "("
				+ usuario.getPerfilId() + "," 
				+ "'" + usuario.getNome() + "'," 
				+ "'" + usuario.getEmail() + "',"
				+ "'" + usuario.getLogon() + "'," 
				+ "'" + usuario.getSenha() + "'" 
				+ ")");
		ResultSet resultSet = BancoProway.ConsultarBD("select max(IdUsuario) IdUsuario from Usuario");
		try {
			while (resultSet.next()) {
				usuario.setIdUsuario(resultSet.getInt(1));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return usuario;
	}

	@Override
	public Object Editar(Object atual, Object editado) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Deletar(Object item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object Listar(Object item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object Buscar(Object item) {
		Usuario usuario = (Usuario) item;
		ResultSet resultSet = BancoProway.ConsultarBD("select Logon from Usuario");
		boolean encontrado = false;
		try {
			while (resultSet.next()) {
				encontrado = true;
				usuario.setLogon(resultSet.getString(resultSet.findColumn("Logon")));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if (encontrado)
			return usuario;
		else
			return null; 
	}

}
