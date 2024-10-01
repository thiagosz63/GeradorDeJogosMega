package controller;

import java.util.List;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import utils.GerarTodasCombinacoes;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;

public class GeradorController {

	String input = "C:\\Users\\TSA\\Desktop\\gerar-combinacoes";
	private @FXML TextField txtJogo;
	private @FXML TextField txtDigitosPorJogo;
	private @FXML TextField txtValordoJogo;
	private @FXML ComboBox<String> cbFiltro;
	private @FXML Button btnIniciar;
	private @FXML ListView<String> ListViewJogos;
	private @FXML Label labelQntJogo;
	private @FXML Label labelQntCombinacoes;
	private @FXML Label labelValorDoJogo;
	private @FXML Button btnSalvarCombinacoes;

	public void preencrerLista(List<String> list) {
		ObservableList<String> ObsList = FXCollections.observableArrayList(list);
		ListViewJogos.setItems(ObsList);
	}

	@FXML
	private void onActionIniciar(ActionEvent event) {
		// Entrada.
		 String[] numeros = txtJogo.getText().split(Pattern.quote("-"));

		int r = Integer.parseInt(txtDigitosPorJogo.getText());
		List<String> listEntrada = GerarTodasCombinacoes.gerarTodasCombinacoes(numeros.length, r, numeros);
		
		preencrerLista(listEntrada);
		labelQntJogo.setText(numeros.length + " Números jogados");
		labelQntCombinacoes.setText(listEntrada.size() + " combinações de jogos");
		labelValorDoJogo.setText("R$" + (listEntrada.size() * 4.50) + " Valor total do jogo" );
	}

	@FXML
	private void onActionSalvar(ActionEvent event) {
	}
}
