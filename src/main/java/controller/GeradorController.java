package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import filtros.Filtro;
import filtros.GerarTodasCombinacoes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import utils.Caminho;

public class GeradorController implements Initializable {

	private List<String> listSaida = new ArrayList<String>();

	private @FXML TextField txtJogo;
	private @FXML TextField txtDigitosPorJogo;
	private @FXML TextField txtValordoJogo;
	private @FXML Button btnIniciar;
	private @FXML ListView<String> ListViewJogos;
	private @FXML Label labelQntJogo;
	private @FXML Label labelQntCombinacoes;
	private @FXML Label labelValorDoJogo;
	private @FXML Button btnSalvarCombinacoes;
	private @FXML RadioButton rbSemNumeroSequenciado;
	private @FXML RadioButton rbSemFamiliaComTres;

	public void preencrerLista(List<String> list) {
		ObservableList<String> ObsList = FXCollections.observableArrayList(list);
		ListViewJogos.setItems(ObsList);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML
	private void onActionIniciar(ActionEvent event) {
		// Entrada.
		String[] numeros = txtJogo.getText().split(Pattern.quote("-"));

		int r = Integer.parseInt(txtDigitosPorJogo.getText());
		listSaida = GerarTodasCombinacoes.gerarTodasCombinacoes(numeros.length, r, numeros);

		if (rbSemNumeroSequenciado.isSelected()) {
			listSaida = Filtro.tiraSequenciaSeguida(listSaida);
		}
		if (rbSemFamiliaComTres.isSelected()) {
			listSaida = Filtro.tiraSequenciaFamilia(listSaida);
		}

		preencrerLista(listSaida);
		labelQntJogo.setText(numeros.length + " Números jogados");
		labelQntCombinacoes.setText(listSaida.size() + " combinações de jogos");

		if (!txtValordoJogo.getText().isBlank()) {
			double valorDoJogo = Double.parseDouble(txtValordoJogo.getText().replaceAll((","), (".")));
			NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
			String resultadoFormatado = formatter.format(listSaida.size() * valorDoJogo);

			labelValorDoJogo.setText(resultadoFormatado + " Valor total do jogo");
		}
	}

	@FXML
	private void onActionSalvar(ActionEvent event) {

		String path = Caminho.salvar() + "\\gerar-combinacoes.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

			for (String string : listSaida) {

				bw.write(string);
				bw.newLine();
			}
		} catch (Exception e) {
			System.out.println("error" + e.getMessage());
		}
	}
}
