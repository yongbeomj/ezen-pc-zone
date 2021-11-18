module Customer {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires java.base;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	opens controller to javafx.graphics, javafx.fxml, activation;
	opens dao to java.sql;
	opens domain to activation , javafx.base;
}
