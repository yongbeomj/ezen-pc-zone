package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ProductUpdateController {
	
	 @FXML
	    private Button btnback;

	    @FXML
	    void back(ActionEvent event) {
	    	SystemController.getinstance().loadpage("a_system1");
	    }

}
