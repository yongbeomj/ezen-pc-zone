package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
    public void start(Stage stage) throws Exception {
		
		VBox vbox = new VBox(10);
		
//		FileInputStream input = new FileInputStream(path);
//        Image image = new Image(input);
//        ImageView img = new ImageView(image);
//        img.setFitWidth(200);
//        img.setPreserveRatio(true);

		String path1 = "sam.png";
		String path2 = "sam2.jpg";
		String path3 = "sam3.jpg";
		
        Button img1 = new Button();
        Button img2 = new Button();
        Button img3 = new Button();
        
        img1.setGraphic(new ImageView(path1));
        img2.setGraphic(new ImageView(path2));
        img3.setGraphic(new ImageView(path3));
        
        img1.setOnAction(e -> {
			System.out.println(e.toString() + "1�� ��ǰ�� ���� �Ǿ����ϴ� ");
		});
        img2.setOnAction(e -> {
        	System.out.println(e.toString() + "2�� ��ǰ�� ���� �Ǿ����ϴ� ");
        });
        img3.setOnAction(e -> {
        	System.out.println(e.toString() + "3�� ��ǰ�� ���� �Ǿ����ϴ� ");
        });
        
        img1.setContentDisplay(ContentDisplay.TOP);
        vbox.getChildren().addAll(img1, img2, img3);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);
        stage.show();

    }
	
	
    public static void main(String[] args) {
        launch();
    }
}
