package utils;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class Constraints {
	public static void numberField(TextField textField,Integer tamanhoCampo) {
		textField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

				if (newValue.length() < (tamanhoCampo + 2)) {
					Platform.runLater(() -> {
						String value = textField.getText();

						value = value.replaceAll("[^0-9]", "");
						
						value = value.replaceFirst("(\\d{1})(\\d)(\\d)(\\d)", "$1.$2$3$4");
						value = value.replaceFirst("(\\d{1}).(\\d{1})(\\d)(\\d)(\\d)", "$1$2.$3$4$5");
						value = value.replaceFirst("(\\d{1})(\\d{1}).(\\d{1})(\\d)(\\d)(\\d)", "$1$2$3.$4$5$6");
						value = value.replaceFirst("(\\d{1})(\\d{1})(\\d{1}).(\\d{1})(\\d)(\\d)(\\d)", "$1.$2$3$4.$5$6$7");
						textField.setText(value);
						textField.positionCaret(textField.getText().length());
					});

				} else {
					textField.setText(oldValue);
				}
			}
		});
	}
}
