package filtros;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Filtro {
	public static List<String> tiraSequenciaSeguida(List<String>list){
		List<String> saida = new ArrayList<String>();
		
		// remove numeros seguidos 
		for (int i = 0; i < list.size(); i++) {
			String[] vet = list.get(i).split(Pattern.quote("-")); // lendo_o_campo_0_do_txt

			boolean controledeSaida = true;
			for (int j = 0; j < vet.length; j++) {
				Integer num = Integer.parseInt(vet[j]);
				
				for (int k = 0; k < vet.length - 1; k++) {
					Integer numComparar = Integer.parseInt(vet[k + 1]);
					if((num + 1) == numComparar) {
						controledeSaida = false;
						break;
					}
				}
				
				if(controledeSaida == false) {
					break;
				}
			}
			if(controledeSaida == true) {
				saida.add(list.get(i));
			}
		}
		return saida;
	}
	
	public static List<String> tiraSequenciaFamilia(List<String>listInput){
		List<String> saida = new ArrayList<String>();
		
		for (String input : listInput) {
			String[] vet = input.split(Pattern.quote("-"));
						
			for (int j = 0; j < vet.length; j++) {
				String posicao1Vetor = vet[j].substring(0,1);
				
				for (int k = 0; k < vet.length - 1; k++) {
					String posicao2Vetor = vet[j+1].substring(0,1);
				}
			}
		}
		return saida;
	}
}
