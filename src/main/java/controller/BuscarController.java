package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import utils.Caminho;

public class BuscarController {

	private List<String> listInput = new ArrayList<>();

	private @FXML Button btnDados;
	private @FXML TextField txtBuscar;
	private @FXML TextField txtDados;
	private @FXML Button btnLimpar;
	private @FXML AnchorPane ancorpricipal;
	private @FXML Button btnBuscar;
	private @FXML ListView<String> listViewTodasCombinacoes;
	private @FXML ListView<String> listView1Bola;
	private @FXML ListView<String> listView2Bola;
	private @FXML ListView<String> listView3Bola;
	private @FXML ListView<String> listView4Bola;
	private @FXML ListView<String> listView5Bola;
	private @FXML ListView<String> listView6Bola;
	private @FXML Label lbl1Acerto;
	private @FXML Label lbl2Acerto;
	private @FXML Label lbl3Acerto;
	private @FXML Label lbl4Acerto;
	private @FXML Label lbl5Acerto;
	private @FXML Label lbl6Acerto;
	private @FXML Label lblTodos;

	@FXML
	void onBtnDados(ActionEvent event) {
		File path = Caminho.abrir("txt", "csv");
		if (path != null) {
			txtDados.setText(String.valueOf(path));
			listInput = Caminho.lerTxt(path);
			lblTodos.setText("");
			preencrerLista(listInput);
		}
	}

	@FXML
	public void onBtnLimpar(ActionEvent event) {
		txtBuscar.setText("");
		listView1Bola.getItems().clear();
		listView2Bola.getItems().clear();
		listView3Bola.getItems().clear();
		listView4Bola.getItems().clear();
		listView5Bola.getItems().clear();
		listView6Bola.getItems().clear();
		lbl1Acerto.setText("");
		lbl2Acerto.setText("");
		lbl3Acerto.setText("");
		lbl4Acerto.setText("");
		lbl5Acerto.setText("");
		lbl6Acerto.setText("");
	}

	@FXML
	public void onBtnBuscar() {
		pesquisar(txtBuscar.getText());
	}

	public void preencrerLista(List<String> list) {

		ObservableList<String> ObsList = FXCollections.observableArrayList(list);
		listViewTodasCombinacoes.setItems(ObsList);
		lblTodos.setText(list.size() + " Jogos");
	}

	public void pesquisar(String combinacao) {
		String[] num = combinacao.split(Pattern.quote("-"));

		List<String> listaView1Bola = new ArrayList<>();
		List<String> listaView2Bola = new ArrayList<>();
		List<String> listaView3Bola = new ArrayList<>();
		List<String> listaView4Bola = new ArrayList<>();
		List<String> listaView5Bola = new ArrayList<>();
		List<String> listaView6Bola = new ArrayList<>();

		for (int j = 0; j < listInput.size(); j++) {

			String[] vet = listInput.get(j).split(Pattern.quote("-"));
			Integer controler = 0;

			for (int k = 0; k < num.length; k++) {

				for (int i = 0; i < vet.length; i++) {
					if (num[k].equals(vet[i])) {
						controler++;
					}
				}
			}
			if (controler.equals(1)) {
				listaView1Bola.add(listInput.get(j));
			} else if (controler.equals(2)) {
				listaView2Bola.add(listInput.get(j));
			} else if (controler.equals(3)) {
				listaView3Bola.add(listInput.get(j));
			} else if (controler.equals(4)) {
				listaView4Bola.add(listInput.get(j));
			} else if (controler.equals(5)) {
				listaView5Bola.add(listInput.get(j));
			} else if (controler.equals(6)) {
				listaView6Bola.add(listInput.get(j));
			}
		}

		listView1Bola.setItems(FXCollections.observableArrayList(listaView1Bola));
		listView2Bola.setItems(FXCollections.observableArrayList(listaView2Bola));
		listView3Bola.setItems(FXCollections.observableArrayList(listaView3Bola));
		listView4Bola.setItems(FXCollections.observableArrayList(listaView4Bola));
		listView5Bola.setItems(FXCollections.observableArrayList(listaView5Bola));
		listView6Bola.setItems(FXCollections.observableArrayList(listaView6Bola));
		lbl1Acerto.setText(listaView1Bola.size() + " Acertos");
		lbl2Acerto.setText(listaView2Bola.size() + " Acertos");
		lbl3Acerto.setText(listaView3Bola.size() + " Acertos");
		lbl4Acerto.setText(listaView4Bola.size() + " Acertos");
		lbl5Acerto.setText(listaView5Bola.size() + " Acertos");
		lbl6Acerto.setText(listaView6Bola.size() + " Acertos");
	}

}
