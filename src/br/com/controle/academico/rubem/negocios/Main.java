package br.com.controle.academico.rubem.negocios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.controle.academico.rubem.dao.AlunoDao;
import br.com.controle.academico.rubem.dao.BancoProway;
import br.com.controle.academico.rubem.model.Aluno;
import br.com.controle.academico.rubem.model.Professor;

public class Main {

	static Scanner scan;
	static Professor professor;

	public static void main(String[] args) {

		System.out.println("Bem vindo - Controle academico");

		//UtilizarModuloAcademico();
		UtilizarBancoDeDados();

	}

	private static void UtilizarBancoDeDados() {
		TesteBanco.Testar();
	}

	private static void UtilizarModuloAcademico() {
		InicializarVariaveisGlobais();
		InicializarListaAlunos();
		professor.ApresentacaoDetalhada();
		professor.ControlarPresencaAlunos();
		professor.InformarNotasAlunos();
		professor.ListarAlunos();
	}

	private static void InicializarVariaveisGlobais() {
		scan = new Scanner(System.in);
		professor = new Professor("rubem", "Rubem Oliota", "Java fundamentos");

	}

	private static void InicializarListaAlunos() {

		professor.getAlunos().add(new Aluno("001", "Guilherme", professor.getDisciplina()));
		professor.getAlunos().add(new Aluno("002", "Vinicius", professor.getDisciplina()));
		professor.getAlunos().add(new Aluno("003", "Eliane", professor.getDisciplina()));
		professor.getAlunos().add(new Aluno("004", "Vinicius", professor.getDisciplina()));
		professor.getAlunos().add(new Aluno("004", "Eduardo", professor.getDisciplina()));

	}

}
