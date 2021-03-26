package br.com.controle.academico.rubem;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Utils {

	static public boolean Perguntar(String pergunta) {
		System.out.println(pergunta + " (S/N)");
		return new Scanner(System.in).next().equalsIgnoreCase("S");
	}

	static public String FormatarDecimal(double numero, int casasDecimais) {
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setMaximumFractionDigits(2);
		return decimalFormat.format(numero);
	}
}
