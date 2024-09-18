package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class GeradorController {

	String input = "C:\\Users\\TSA\\Desktop\\gerar-combinacoes";
	private @FXML TextField txtJogo;
	private @FXML TextField txtDigitosPorJogo;
	private @FXML TextField txtValordoJogo;
	private @FXML ComboBox cbFiltro;
	private @FXML Button btnIniciar;

	@FXML
	private void onActionIniciar(ActionEvent event) {
		System.out.println("clkicou");
	}

	@FXML
	private void onActionSalvar(ActionEvent event) {
	}
}
