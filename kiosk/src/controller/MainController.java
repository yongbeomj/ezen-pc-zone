package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

	 	@FXML
	    private Button btncancel;

	    @FXML
	    void cancel(ActionEvent event) {
	    	LoginController.getinstance().loadpage("k_login");
	    }
}
