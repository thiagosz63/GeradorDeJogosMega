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

			boolean controledeSaida = true;
			for (int j = 0; j < vet.length; j++) {
				Integer num = Integer.parseInt(vet[j]);

				for (int k = 0; k < vet.length - 1; k++) {
					Integer numComparar = Integer.parseInt(vet[k + 1]);
					if ((num + 1) == numComparar) {
						controledeSaida = false;
						break;
					}
				}

				if (controledeSaida == false) {
					break;
				}
			}
			if (controledeSaida == true) {
				listOutput.add(input);
			}
		}
		return listOutput;
	}

	public static List<String> tiraSequenciaFamilia(List<String> listInput) {
		List<String> listOutput = new ArrayList<String>();
		boolean resultado = false;

		for (String input : listInput) {
			String[] vet = input.split(Pattern.quote("-"));

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
}
