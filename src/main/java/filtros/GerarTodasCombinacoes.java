package filtros;

import java.util.ArrayList;
import java.util.List;

public class GerarTodasCombinacoes {

	private static void Ajudante(List<String[]> combinacoes, String dados[], int inicio, int fim, int indice,
			String[] numeros) {

		if (indice == dados.length) {
			String[] combinacao = dados.clone();
			combinacoes.add(combinacao);
		} else if (inicio <= fim) {
			dados[indice] = numeros[inicio];
			Ajudante(combinacoes, dados, inicio + 1, fim, indice + 1, numeros);
			Ajudante(combinacoes, dados, inicio + 1, fim, indice, numeros);
		}
	}

	private static List<String[]> gerado(int n, int r, String[] numeros) {
		List<String[]> combinacoes = new ArrayList<>();
		Ajudante(combinacoes, new String[r], 0, n - 1, 0, numeros);
		return combinacoes;
	}

	public static List<String> gerarTodasCombinacoes(int n, int r, String[] numeros) {

		List<String[]> combinacoes = gerado(numeros.length, r, numeros);
		List<String> saida = new ArrayList<>();
		for (String[] combinacao : combinacoes) {

			String junta = "";
			for (int i = 0; i < combinacao.length; i++) {
				
				if(i == combinacao.length-1) {
					junta += combinacao[i];
				}else {
					junta += combinacao[i]+"-";
				}
				
			}
			saida.add(junta);
		}
		return saida;
	}
}
