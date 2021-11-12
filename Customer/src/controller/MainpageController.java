package controller;

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
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainpageController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	// �ν��Ͻ�ȭ
	public static MainpageController instance;
	public MainpageController() {
		instance = this;
	}
	public static MainpageController getinstance() {
		return instance;
	}
	
    @FXML
    private Button btnchatting;

    @FXML
    private Button btnlogout;

    @FXML
    private Button btnmove;

    @FXML
    private Button btnpause;

    @FXML
    private Button btnproductorder;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private Label lblpcno;

    @FXML
    private Label lblprice;

    @FXML
    private Label lblremaintime;

    @FXML
    private Label lblusetime;

    @FXML
    void chatting(ActionEvent event) {
    	loadpage("c_chatting");
    }

    @FXML
    void logout(ActionEvent event) {
    	Alert alert = new Alert( AlertType.CONFIRMATION );
    	alert.setContentText(" �α׾ƿ� ");
    	alert.setHeaderText(" �α׾ƿ� �Ͻðڽ��ϱ�? ");
    	alert.setTitle("�α׾ƿ�");
    	// �˸�â�� ���� �� �ɼ�(Ȯ��, ���)�� ���� ��� �ٸ�
    	Optional<ButtonType> optional = alert.showAndWait();
    	if( optional.get() == ButtonType.OK ) { // Ȯ���� ������
    		btnlogout.getScene().getWindow().hide(); // ����â�� ����
        	LoginController.getinstance().loadpage("c_login"); // �α��� â Ȱ��ȭ
    	}
    }

    @FXML
    void move(ActionEvent event) {
    	Alert alert = new Alert( AlertType.CONFIRMATION );
    	alert.setContentText(" �ڸ��̵� ");
    	alert.setHeaderText(" �ڸ��̵� �Ͻðڽ��ϱ�? ");
    	alert.setTitle("�ڸ��̵�");
    	// �˸�â�� ���� �� �ɼ�(Ȯ��, ���)�� ���� ��� �ٸ�
    	Optional<ButtonType> optional = alert.showAndWait();
    	if( optional.get() == ButtonType.OK ) {
    		
    	}
    }

    @FXML
    void pause(ActionEvent event) {
    	Alert alert = new Alert( AlertType.CONFIRMATION );
    	alert.setContentText(" �Ͻ����� ");
    	alert.setHeaderText(" �Ͻ����� �Ͻðڽ��ϱ�? ");
    	alert.setTitle("�Ͻ�����");
    	
    	Optional<ButtonType> optional = alert.showAndWait();
    	if( optional.get() == ButtonType.OK ) {
    		btnlogout.getScene().getWindow().hide();
        	LoginController.getinstance().loadpage("c_login");
    	}
    }

    @FXML
    void productorder(ActionEvent event) {
    	loadpage("c_productorder");
    }
    
    public void loadpage(String page) {
		Stage stage = new Stage();
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/fxml/"+page+".fxml"));
			Scene scene = new Scene( parent );
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("EZEN PC ZONE");
			stage.show();
		}
		catch (Exception e) {}
	}
	
	
}
