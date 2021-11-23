module Admin {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	opens Dao to java.sql;
	opens Domain to mail , activation,javafx.base, javafx.fxml;
	opens Controller to javafx.graphics, javafx.fxml, javafx.base;
	
}
