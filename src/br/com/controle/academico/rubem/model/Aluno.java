package br.com.controle.academico.rubem.model;

import java.util.ArrayList;

import br.com.controle.academico.rubem.interfaces.Apresentacao;
import br.com.controle.academico.rubem.negocios.Utils;

public class Aluno extends Usuario implements Apresentacao{

	private int IdAluno;
	private boolean Presente;
	private int DisciplinaId;
	private String Disciplina;
	private ArrayList<Double> Notas;

	public Aluno() {
		setPresente(false);
		setNotas(new ArrayList<Double>());
	}
 

	public Aluno(String logon,String nome,String disciplina) {
		super(logon,nome);
		setDisciplina(disciplina);
		setPresente(false);
		setNotas(new ArrayList<Double>());
	}

	
	public boolean isPresente() {
		return Presente;
	}

	public void setPresente(boolean presente) {
		Presente = presente;
	}

	public ArrayList<Double> getNotas() {
		return Notas;
	}

	public void setNotas(ArrayList<Double> notas) {
		Notas = notas;
	}

	public double CalcularMedia() {
		double soma = 0;
		if (getNotas().size() == 0) {
			return 0;
		} else {
			for (int i = 0; i < getNotas().size(); i++) {
				soma += getNotas().get(i);
			}
			return soma / getNotas().size();
		}
	}
	

	@Override
	public void ApresentacaoDetalhada() {

		System.out.println(getNome() + " - " + getEmail() + " - " + isPresente() + " - "
				+ Utils.FormatarDecimal(CalcularMedia(), 2));
	}


	public int getDisciplinaId() {
		return DisciplinaId;
	}


	public void setDisciplinaId(int disciplinaId) {
		DisciplinaId = disciplinaId;
	}


	public int getIdAluno() {
		return IdAluno;
	}


	public void setIdAluno(int idAluno) {
		IdAluno = idAluno;
	}


	public String getDisciplina() {
		return Disciplina;
	}


	public void setDisciplina(String disciplina) {
		Disciplina = disciplina;
	}


}
