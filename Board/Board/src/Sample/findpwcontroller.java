package Sample;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class findpwcontroller implements Initializable {
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}
	
    @FXML
    private Label btnback;

    @FXML
    private Button btnfindpw;

    @FXML
    private AnchorPane findpwpane;

    @FXML
    private Label lblconfirm;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtid;
	
    @FXML
    void back(MouseEvent event) {
    	logincontroller.getinstance().loadpage("login");
    }
    
    @FXML
    void findpw(ActionEvent event) {
    	String result =	memberdao.getmemberdao().findpassword(txtid.getText(), txtemail.getText());
    	
    	

    }
	
}
