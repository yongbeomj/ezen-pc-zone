package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {
	
		Parent parent = FXMLLoader.load(getClass().getResource("/fxml/a_system1.fxml"));
		Scene scene = new Scene(parent);
	
		stage.setScene(scene);
		stage.setResizable(false); // 스테이지 크기값 고정
		stage.show();
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
