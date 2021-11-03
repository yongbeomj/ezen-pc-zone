module asdasdasd {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
	opens app to javafx.graphics, javafx.fxml;
	opens controller to javafx.graphics, javafx.fxml;
	opens domain to javafx.graphics, javafx.fxml;
	opens dao to javafx.graphics, javafx.fxml;
}
