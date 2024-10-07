package application;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Scene scene;
	
	@Override
	public void start(Stage primaryStage){
		try {
			URL fxmlMainView = getClass().getResource("/view/MainView.fxml");
			Parent parent = FXMLLoader.load(fxmlMainView);
			scene = new Scene(parent);
			primaryStage.setScene(scene);
			primaryStage.setMinWidth(671);
			primaryStage.setMinHeight(488);
			primaryStage.setTitle("Gerador de jogos Mega Sena");
			primaryStage.show();
			
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
