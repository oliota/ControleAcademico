package br.com.controle.academico.rubem;

import java.util.ArrayList;

public class Aluno extends Usuario implements Apresentacao{

	private boolean Presente;
	private ArrayList<Double> Notas;

	public Aluno() {
	}

	public Aluno(String matricula, String nome) {
		super(matricula, nome);
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

		System.out.println(getNome() + " - " + getMatricula() + " - " + isPresente() + " - "
				+ Utils.FormatarDecimal(CalcularMedia(), 2));
	}


}
