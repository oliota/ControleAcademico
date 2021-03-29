package br.com.controle.academico.rubem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controle.academico.rubem.model.Aluno;
import br.com.controle.academico.rubem.model.Usuario;

public class AlunoDao implements Cadastro {

	private String tabela = "Aluno";
	private String colunas = "(idAluno,UsuarioId,DisciplinaId)";

	@Override
	public Object Adicionar(Object novo) {
		Aluno aluno = (Aluno) Buscar(novo);
		if (aluno != null) {
			System.out.println("Já existe");
			return aluno;
		}
		aluno = (Aluno) novo;

		Usuario usuario = (Usuario) new UsuarioDao().Adicionar(aluno);
		
		
		BancoProway.ExecutarComandoBD("insert into Aluno" + "(UsuarioId,DisciplinaId)" + " Values " + "("
				+ usuario.getIdUsuario() + "," + aluno.getDisciplinaId() + ")");
		ResultSet resultSet = BancoProway.ConsultarBD("select max(IdUsuario) IdUsuario from Usuario");
		try {
			while (resultSet.next()) {
				usuario.setIdUsuario(resultSet.getInt(1));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return aluno;
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

		ArrayList<Aluno> alunos = new ArrayList();
		ResultSet resultSet = BancoProway.ConsultarBD("select a.idaluno,u.*,p.nome perfil,d.iddisciplina,d.nome disciplina from aluno a"
				+ " inner join usuario u on u.IdUsuario= a.UsuarioId " 
				+ " inner join perfil p on p.IdPerfil= u.PerfilId "
				+ " inner join disciplina d on d.IdDisciplina = a.DisciplinaId");

		try {
			while (resultSet.next()) {
				Aluno aluno = new Aluno();
				aluno.setIdAluno(resultSet.getInt(resultSet.findColumn("IdAluno")));
				aluno.setIdUsuario(resultSet.getInt(resultSet.findColumn("IdUsuario")));
				aluno.setDisciplinaId(resultSet.getInt(resultSet.findColumn("IdDisciplina")));
				aluno.setPerfilId(resultSet.getInt(resultSet.findColumn("PerfilId")));
				aluno.setNome(resultSet.getString(resultSet.findColumn("Nome")));
				aluno.setEmail(resultSet.getString(resultSet.findColumn("Email")));
				aluno.setLogon(resultSet.getString(resultSet.findColumn("Logon")));
				aluno.setSenha(resultSet.getString(resultSet.findColumn("Senha")));
				aluno.setDisciplina(resultSet.getString(resultSet.findColumn("Disciplina")));

				alunos.add(aluno);

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("erro aqui");
		}

		return alunos;
	}

	@Override
	public Object Buscar(Object item) {
		Aluno aluno = (Aluno) item;
		ResultSet resultSet = BancoProway.ConsultarBD("select a.idaluno,u.*,p.nome perfil,d.iddisciplina,d.nome disciplina from aluno a "
				+ " inner join usuario u on u.IdUsuario= a.UsuarioId " 
				+ " inner join perfil p on p.IdPerfil= u.PerfilId "
				+ " inner join disciplina d on d.IdDisciplina = a.DisciplinaId"
				+ " where u.email='"+aluno.getEmail()+"'");
		boolean encontrado = false;
		try {
			while (resultSet.next()) {
				encontrado = true;
				aluno.setIdAluno(resultSet.getInt(resultSet.findColumn("IdAluno")));
				aluno.setIdUsuario(resultSet.getInt(resultSet.findColumn("IdUsuario")));
				aluno.setDisciplinaId(resultSet.getInt(resultSet.findColumn("IdDisciplina")));
				aluno.setPerfilId(resultSet.getInt(resultSet.findColumn("PerfilId")));
				aluno.setNome(resultSet.getString(resultSet.findColumn("Nome")));
				aluno.setEmail(resultSet.getString(resultSet.findColumn("Email")));
				aluno.setLogon(resultSet.getString(resultSet.findColumn("Logon")));
				aluno.setSenha(resultSet.getString(resultSet.findColumn("Senha")));
				aluno.setDisciplina(resultSet.getString(resultSet.findColumn("Disciplina")));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if (encontrado)
			return aluno;
		else
			return null; 
	}

}
