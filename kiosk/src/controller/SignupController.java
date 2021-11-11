package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SignupController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}
	
	   @FXML
	    private Button btnsignup;

	    @FXML
	    private Label lblback;

	    @FXML
	    private Label lblconfirm;

	    @FXML
	    private RadioButton radiobtnman;

	    @FXML
	    private RadioButton radiobtnwoman;

	    @FXML
	    private TextField txtemail;

	    @FXML
	    private TextField txtid;

	    @FXML
	    private TextField txtname;

	    @FXML
	    private PasswordField txtpassword;

	    @FXML
	    private PasswordField txtpasswordconfirm;

    @FXML
    void back(MouseEvent event) {
      	lblback.getScene().getWindow().hide();
    	
    }
    @FXML
    void man(ActionEvent event) {

    }

    @FXML
    void signup(ActionEvent event) {

    }

    @FXML
    void woman(ActionEvent event) {

    }
}
