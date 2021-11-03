package Sample;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class maincontroller implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblloginid.setText(logincontroller.getinstance().getid());
		loadpage("home");
	}

	@FXML
	private Button btnchatting;

	@FXML
	private Button btncommunity;

	@FXML
	private Button btnhome;

	@FXML
	private Button btnlogout;

	@FXML
	private Button btnmyinfo;

	@FXML
	private Button btnproduct;

	@FXML
	private Label lblloginid;

	@FXML
	private AnchorPane lp;

	@FXML
	private BorderPane mainpageboarderpane;



	// 가운데 Pane을 변경하는 메소드
	public void loadpage(String page) {


	}

	@FXML
	void chatting(ActionEvent event) {

	}

	@FXML
	void community(ActionEvent event) {

	}

	@FXML
	void home(ActionEvent event) {

	}

	@FXML
	void logout(ActionEvent event) {
	
	}

	@FXML
	void myinfo(ActionEvent event) {

	}

	@FXML
	void product(ActionEvent event) {

	}
}
