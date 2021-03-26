package br.com.controle.academico.rubem;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner scan;
	static Professor professor;

	public static void main(String[] args) {

		System.out.println("Bem vindo - Controle academico");

		InicializarVariaveisGlobais();
		InicializarListaAlunos();
		professor.ApresentacaoDetalhada();
		professor.ControlarPresencaAlunos();
		professor.InformarNotasAlunos();
		professor.ListarAlunos();
	}

	private static void InicializarVariaveisGlobais() {
		scan = new Scanner(System.in);
		professor = new Professor("000Java", "Rubem Oliota", "Java fundamentos");

	}

	private static void InicializarListaAlunos() {
		professor.getAlunos().add(new Aluno("001", "Guilherme"));
		professor.getAlunos().add(new Aluno("002", "Vinicius"));
		professor.getAlunos().add(new Aluno("003", "Eliane"));
		professor.getAlunos().add(new Aluno("004", "Vinicius"));
		professor.getAlunos().add(new Aluno("004", "Eduardo"));
	}

	  

	

}
