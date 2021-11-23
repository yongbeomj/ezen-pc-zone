module kiosk {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml,javafx.base;
	opens controller to javafx.graphics, javafx.fxml,javafx.base;
}
