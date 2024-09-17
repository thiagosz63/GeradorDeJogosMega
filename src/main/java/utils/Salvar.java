package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class Salvar {

	public static void salvar(String path, List<String> input) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

			for (String string : input) {

				bw.write(string);
				bw.newLine();
			}
		} catch (Exception e) {
			System.out.println("error" + e.getMessage());
		}
	}
}
