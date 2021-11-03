package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.memberdao;
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
import javafx.stage.Stage;

public class MyinfoController implements Initializable {

	// 초기화
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		String loginid = MainpageController.getinstance().getloginid();
//		member member = memberdao.getmemberdao().getmember(loginid);
//		
//		lblid.setText( member.getM_id() );
//		lblname.setText( member.getM_name() );
//		lblemail.setText( member.getM_email() );
//		lblpoint.setText( member.getM_point() + "" );
	}
	
	@FXML
    private Button btndelete;

    @FXML
    private Button btnupdate;

    @FXML
    private Label lblemail;

    @FXML
    private Label lblid;

    @FXML
    private Label lblname;

    @FXML
    private Label lblpoint;

    @FXML
    void delete(ActionEvent event) {
    	// 1. 메시지창 띄우기 
    	Alert alert = new Alert( AlertType.CONFIRMATION );
    	alert.setTitle("알림");
    	alert.setHeaderText("정말 회원탈퇴 하시겠습니까?");
    	
    	Optional<ButtonType> optional = alert.showAndWait();
    	if( optional.get() == ButtonType.OK) {
    		// 회원탈퇴 진행
    		boolean result =  memberdao.getmemberdao().
    				delete( lblid.getText() );
    		
    		Alert alert2 = new Alert( AlertType.INFORMATION );
  
    		if( result ) {
    			alert2.setHeaderText("회원탈퇴 되었습니다");
    			alert2.setTitle("알림");
    			alert2.showAndWait();
    	
    			// 1. main page 닫기
        		btndelete.getScene().getWindow().hide();
        		
        		// 2. login page 열기 
        		Stage stage = new Stage();
        		try {
    	    		Parent parent = FXMLLoader.load( getClass().getResource("/fxml/login.fxml"));
    	    		Scene scene = new Scene( parent );
    	    		stage.setScene(scene);
    	    			stage.setResizable(false); 
    	    			stage.setTitle("게시판"); 
    	    		stage.show();
    	    		
        		}
        		catch (Exception e) {}
        		
    		}else {
    			alert2.setHeaderText(" DB 오류 ");
    			alert2.setTitle("알림");
    			alert2.showAndWait();
    		}
    	}
    }

    @FXML
    void update(ActionEvent event) {
    	MainpageController.getinstance().loadpage("myinfoupdate");
    }
		
	
	
}
