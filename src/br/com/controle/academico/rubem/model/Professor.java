package br.com.controle.academico.rubem.model;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.controle.academico.rubem.interfaces.Apresentacao;
import br.com.controle.academico.rubem.negocios.Utils;

public class Professor extends Usuario  implements Apresentacao{

	private String Disciplina;
	private ArrayList<Aluno> Alunos;

	public Professor() { 
		setAlunos(new ArrayList<Aluno>());
	}

	

	public Professor(String logon,String nome,String disciplina) {
		super(logon,nome);
		setDisciplina(disciplina);
		setAlunos(new ArrayList<Aluno>());
	}



	public String getDisciplina() {
		return Disciplina;
	}

	public void setDisciplina(String disciplina) {
		Disciplina = disciplina;
	}

	public ArrayList<Aluno> getAlunos() {
		return Alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		Alunos = alunos;
	}
	
	public void ListarAlunos() {
		System.out.println("Informações dos alunos na turma de "+getDisciplina());
		for (int i = 0; i < getAlunos().size(); i++) { 
			getAlunos().get(i).ApresentacaoDetalhada();
					
		}
	}

	public void ControlarPresencaAlunos() {
		System.out.println("Controle de presença na turma de "+getDisciplina());
		for (int i = 0; i < getAlunos().size(); i++) {
			if (Utils.Perguntar("Aluno(a) " + getAlunos().get(i).getNome() + " presente?")) {
				getAlunos().get(i).setPresente(true);
			}
		}
	}

	public void InformarNotasAlunos() {
		System.out.println("Controle de notas na turma de "+getDisciplina());
		for (int i = 0; i < getAlunos().size(); i++) {
			if (Utils.Perguntar("Deseja cadastrar as notas do aluno(a) " + getAlunos().get(i).getNome() + "?")) {
				CapturarNotas(getAlunos().get(i));
			}
		}
	}

	private static void CapturarNotas(Aluno aluno) {
		Scanner scan = new Scanner(System.in);
		int contador = 1;
		do {
			System.out.println("Informe a " + (contador++) + "º nota do aluno(a)" + aluno.getNome());
			aluno.getNotas().add(scan.nextDouble());
		} while (Utils.Perguntar("Gostaria de informar uma nova nota?"));

	}

	@Override
	public void ApresentacaoDetalhada() {
		System.out.println(getNome() + " - " + getIdUsuario() + " - " + getDisciplina() + " - quantidade de alunos "
				+ getAlunos().size());
	}

	 

}
