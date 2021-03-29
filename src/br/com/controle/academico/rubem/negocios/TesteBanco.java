package br.com.controle.academico.rubem.negocios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controle.academico.rubem.dao.AlunoDao;
import br.com.controle.academico.rubem.dao.BancoProway;
import br.com.controle.academico.rubem.model.Aluno;

public class TesteBanco {
	static Aluno aluno;
	public static void Testar() {
		BancoProway.ConectarBd();

		InicializarAluno();
		ExibirDadosAluno(aluno);
		
 
		AlunoDao alunoDao = new AlunoDao();
		

		Aluno aluno2 = (Aluno) alunoDao.Adicionar(aluno); 
		ExibirDadosAluno(aluno2);
		

		Aluno aluno3 = (Aluno) alunoDao.Buscar(aluno);
		ExibirDadosAluno(aluno3);
 

		ArrayList<Aluno> alunos = (ArrayList<Aluno>) alunoDao.Listar(null);
		for (int i = 0; i < alunos.size(); i++) {
			System.out.println("Nome = " + alunos.get(i).getNome());
		}
		
		ListarSimples();
		 

	}
	private static void ListarSimples() {
		System.out.println("Busca simples");
		ResultSet resultSet = BancoProway.ConsultarBD("SELECT Nome from Usuario");

		try {
			while (resultSet.next()) {
				System.out.println("Nome="+resultSet.getString(resultSet.findColumn("Nome")));

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
	}
	private static void ExibirDadosAluno(Aluno aluno) {
		System.out.println("Nome:" + aluno.getNome() + " ID:" + aluno.getIdUsuario());		
	}
	private static void InicializarAluno() {
		aluno = new Aluno();
		aluno.setNome("Rubem");
		aluno.setEmail("rdo@gmail.com");
		aluno.setDisciplinaId(1);
		aluno.setLogon("rub");
		aluno.setSenha("123");
		aluno.setPerfilId(1);		
	}

}
