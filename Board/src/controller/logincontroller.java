package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dao.memberdao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class logincontroller implements Initializable {
	
	private static logincontroller instance;
	
	public logincontroller() {
		instance = this;
	}
	public static logincontroller getinstance() {
		return instance;
	}
	public String getid() {
		return txtid.getText();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}

 	@FXML
    private Label btnfindid;

    @FXML
    private Label btnfindpassword;

    @FXML
    private Button btnlogin;

    @FXML
    private Label btnsignup;

    @FXML
    private Label lblconfirm;

    @FXML
    private AnchorPane loginpane;

    @FXML
    private BorderPane mainboarderpane;

    @FXML
    private TextField txtid;

    @FXML
    private PasswordField txtpassword;

    @FXML
    void findid(MouseEvent event) {
    	loadpage("findid");
    }

    @FXML
    void findpassword(MouseEvent event) {
    	loadpage("findpw");
    }

    @FXML
    void login(ActionEvent event) {
    	boolean result = memberdao.getmemberdao().login(txtid.getText(), txtpassword.getText());
    	if(result) {
    		lblconfirm.setText("로그인 성공");
    		memberdao.getmemberdao().pointupdate(txtid.getText(),10);
//   		btnlogin.getScene().getWindow().hide();
//    		Stage stage = new Stage();
//    		Parent parent;
//    		try {
//				parent = FXMLLoader.load(getClass().getResource("/samplefxml/main.fxml"));
//				Scene scene = new Scene(parent);
//				stage.setScene(scene);
//				stage.setResizable(false);
//				stage.setTitle("제목");
//			} catch (Exception e) {
//			}
    		loadpage("mainpage");
    	} else {
    		lblconfirm.setText("로그인 실패");
    	}
    }

    @FXML
    void signup(MouseEvent event) {
    	loadpage("signup");
    }
    
    public void loadpage(String page) {
    	Parent parent;
    	try {
			parent = FXMLLoader.load(getClass().getResource("/fxml/"+page+".fxml"));
			mainboarderpane.setCenter(parent);
		} catch (Exception e) {
			
		}
    }
    
	    
}
