package filtros;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Filtro {
	public static List<String> tiraSequenciaSeguida(List<String> listInput) {
		List<String> listOutput = new ArrayList<String>();

		// remove numeros seguidos
		for (String input : listInput) {
			String[] vet = input.split(Pattern.quote("-"));

			boolean resultado = true;
			for (int j = 0; j < vet.length; j++) {
				Integer num = Integer.parseInt(vet[j]);

				for (int k = 0; k < vet.length - 1; k++) {
					Integer numComparar = Integer.parseInt(vet[k + 1]);
					if ((num + 1) == numComparar) {
						resultado = false;
						break;
					}
				}

				if (resultado == false) {
					break;
				}
			}
			if (resultado == true) {
				listOutput.add(input);
			}
		}
		return listOutput;
	}

	public static List<String> tiraSequenciaFamilia(List<String> listInput) {
		List<String> listOutput = new ArrayList<String>();

		for (String input : listInput) {
			String[] vet = input.split(Pattern.quote("-"));

			boolean resultado = false;
			for (int j = 0; j < vet.length; j++) {
				String posicao1Vetor = vet[j].substring(0, 1);

				for (int k = 0; k < vet.length - 1 - j; k++) {
					String posicao2Vetor = vet[k + 1 + j].substring(0, 1);

					if (posicao1Vetor.equals(posicao2Vetor)) {

						for (int i = 0; i < vet.length - 2 - k - j; i++) {
							String posicao3Vetor = vet[i + 2 + k + j].substring(0, 1);

							if (posicao2Vetor.equals(posicao3Vetor)) {
								resultado = true;
							}
						}
					}
				}
			}
			if (resultado == false) {
				listOutput.add(input);
			}
		}
		return listOutput;
	}

	public static List<String> restricaoCasas(List<String> listInput) {
		List<String> listOutput = new ArrayList<String>();

		for (String input : listInput) {
			String[] vet = input.split(Pattern.quote("-"));

			boolean resultado = false;
			
			for (int j = 0; j < vet.length; j++) {
				
				String posicao0Vetor = vet[0].substring(0, 1);
				String posicao1Vetor = vet[1].substring(0, 1);
				String posicao2Vetor = vet[2].substring(0, 1);
				String posicao3Vetor = vet[3].substring(0, 1);
				String posicao4Vetor = vet[4].substring(0, 1);
				String posicao5Vetor = vet[5].substring(0, 1);

					if ((posicao1Vetor.equals("0")) || (posicao2Vetor.equals("0"))
							|| (posicao3Vetor.equals("0")) || (posicao4Vetor.equals("0"))
							|| (posicao5Vetor.equals("0"))) {
						resultado = true;
					}
					
					if ((posicao3Vetor.equals("1")) || (posicao4Vetor.equals("1")) || (posicao1Vetor.equals("1"))
							|| (posicao5Vetor.equals("1"))) {
						resultado = true;
					}
					
					if ((posicao0Vetor.equals("2")) || (posicao4Vetor.equals("2"))
							|| (posicao5Vetor.equals("2"))) {
						resultado = true;
					}
					
					if ((posicao0Vetor.equals("3")) || (posicao1Vetor.equals("3"))
							|| (posicao5Vetor.equals("3"))) {
						resultado = true;
					}
					
					if ((posicao0Vetor.equals("4")) || (posicao1Vetor.equals("4"))
							|| (posicao2Vetor.equals("4"))) {
						resultado = true;
					}
					
					if ((posicao0Vetor.equals("5")) || (posicao1Vetor.equals("5"))
							|| (posicao2Vetor.equals("5")) || (posicao3Vetor.equals("5")) || (posicao4Vetor.equals("5"))) {
						resultado = true;
					}
					
					if ((posicao0Vetor.equals("6")) || (posicao1Vetor.equals("6"))
							|| (posicao2Vetor.equals("6")) || (posicao3Vetor.equals("6")) 
							|| (posicao4Vetor.equals("6"))) {
						resultado = true;
					}
					
			}
			
			if (resultado == false) {
				listOutput.add(input);
			}
		}
		return listOutput;
	}
}
