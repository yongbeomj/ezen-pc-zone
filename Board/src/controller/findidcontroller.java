package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.memberdao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class findidcontroller implements Initializable{
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}
	
    @FXML
    private Label btnback;

    @FXML
    private Button btnfindid;

    @FXML
    private AnchorPane findidpane;

    @FXML
    private Label lblconfirm;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtname; 

    @FXML
    void back(MouseEvent event) {
    	logincontroller.getinstance().loadpage("login");
    }

    @FXML
    void findid(ActionEvent event) {
    
    	String result =	memberdao.getmemberdao().findid(txtname.getText(), txtemail.getText());
    	
    }
}
