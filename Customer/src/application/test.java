package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class test extends Application {

    @Override/*from w  w w . d e  mo 2  s. co m*/
    public void start(Stage palco) throws Exception {

        VBox vbox = new VBox(20);

        Button ideia = new Button("Tive uma ideia!");
        Button ideia1 = new Button("Tive uma ideia!");
        Button pergunta = new Button("O que eu fa?o agora?");
        String add = "http://d20aeo683mqd6t.cloudfront.net/ko/articles/title_images/000/039/143/medium/IMG_5649%E3%81%AE%E3%82%B3%E3%83%92%E3%82%9A%E3%83%BC.jpg?2019";
        ideia.setGraphic(new ImageView(add));
        ideia1.setGraphic(new ImageView(add));
        pergunta.setGraphic(new ImageView(add));

        ideia.setContentDisplay(ContentDisplay.TOP);
        vbox.getChildren().addAll(ideia, ideia1, pergunta);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 200, 200);
        palco.setScene(scene);
        palco.show();

    }

    public static void main(String[] args) {
        launch();
    }

}