package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable{

	private @FXML Button btnStart;
	private @FXML AnchorPane AncorPaneGerador;
	private @FXML AnchorPane AncorPaneVisualizador;
	
	private synchronized <T> void loadView(String absoluteName, AnchorPane anchorPanePai, Consumer<T> initializingAction) {
		try {
			FXMLLoader load = new FXMLLoader(getClass().getResource(absoluteName));
			AnchorPane newAnchorPane = load.load();

			newAnchorPane.prefHeightProperty().bind(anchorPanePai.heightProperty());
			newAnchorPane.prefWidthProperty().bind(anchorPanePai.widthProperty());
			anchorPanePai.getChildren().clear();
			anchorPanePai.getChildren().addAll(newAnchorPane.getChildren());

			T controller = load.getController();
			initializingAction.accept(controller);

		} catch (Exception e) {
			 e.printStackTrace();
			
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		loadView("/view/geradorView.fxml",AncorPaneGerador, (x) -> {
			
		});
		
	}
}
