package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ProductListController {
    @FXML
    private Button btnback;

    @FXML
    void back(ActionEvent event) {
    	SystemController.getinstance().loadpage("a_system1");
    }
    
    @FXML
    private Button btnproductregister;
    
    @FXML
    private Button btnproductupdate;

    @FXML
    void productregister(ActionEvent event) {
    	SystemController.getinstance().loadpage("a_productregister");
    }


    @FXML
    void productupdate(ActionEvent event) {
    	SystemController.getinstance().loadpage("a_productupdate");
    }
    
}
