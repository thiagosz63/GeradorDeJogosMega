package utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;

public class Caminho {
	public static File abrir(String tipoInicial1, String tipoInicial2) {

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Abrir");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*." + tipoInicial1, "*." + tipoInicial2),
												 new ExtensionFilter("Text Files", "*.txt"),
												 new ExtensionFilter("Text Files", "*.csv"),
												 new ExtensionFilter("Text Files","*.pdf"),
												 new ExtensionFilter("All Files", "*.*"));
		Window window = null;
		File file = fileChooser.showOpenDialog(window);

		return file;
	}
	
	public static File salvar() {

		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Abrir");
		Window window = null;
		File file = directoryChooser.showDialog(window);
		return file;
	}
	
	public static List<String> lerTxt(File path) {
		List<String> lines = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();

			while (line != null) {
				lines.add(line);
				// System.out.println(line);
				line = br.readLine();
			}
			return lines;

		} catch (Exception e) {
			System.out.println("error txt: " + e.getMessage());
		}
		return lines;

	}
}
