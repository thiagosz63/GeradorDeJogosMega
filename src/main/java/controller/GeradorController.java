package controller;

import java.util.List;

import utils.GerarTodasCombinacoes;
import utils.Salvar;

public class GeradorController {

	String input = "C:\\Users\\TSA\\Desktop\\gerar-combinacoes";
	
	public void onBtnStart() {
		// Entrada.
		String[] numeros = new String[] { "01", "04", "12", "14", "24", "26",
				"36", "34", "48", "54", "58", "21", "41","56" };
		int r = 6;
		
		List<String> listEntrada = GerarTodasCombinacoes.gerarTodasCombinacoes(numeros.length, r, numeros);
		
		Salvar.salvar(input + "TodasPossiveis.csv", listEntrada);
	}
}
