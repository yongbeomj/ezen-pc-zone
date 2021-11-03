package Sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class appstart extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {

		Parent parent = FXMLLoader.load(getClass().getResource("/samplefxml/login.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Á¦¸ñ");
		stage.show();
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
