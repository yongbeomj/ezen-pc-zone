package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.MemberDao;
import dao.PcDao;
import dao.TimeDao;
import domain.Pc;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	
	
   
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//showpage("sample");
		
		Button[] pcbuttons = {  null, btnpc_1 ,btnpc_2 ,btnpc_3 ,btnpc_4 ,btnpc_5 ,btnpc_6 ,btnpc_7 ,btnpc_8 ,btnpc_9 ,btnpc_10 
				,btnpc_11  ,btnpc_12  ,btnpc_13,btnpc_14,btnpc_15,btnpc_16,btnpc_17,btnpc_18,btnpc_19,btnpc_20};
		
		Label[] pcids = { null,lblid_1,lblid_2,lblid_3,lblid_4,lblid_5,lblid_6,lblid_7,lblid_8,lblid_9,lblid_10
				,lblid_11,lblid_12,lblid_13,lblid_14,lblid_15,lblid_16,lblid_17,lblid_18,lblid_19,lblid_20};
		
		Label[] lbltimes = { null,lbltimeremaining_1,lbltimeremaining_2,lbltimeremaining_3,lbltimeremaining_4,lbltimeremaining_5,lbltimeremaining_6,lbltimeremaining_7
				,lbltimeremaining_8,lbltimeremaining_9,lbltimeremaining_10,lbltimeremaining_11,lbltimeremaining_12,lbltimeremaining_13,lbltimeremaining_14,lbltimeremaining_15
				,lbltimeremaining_16,lbltimeremaining_17,lbltimeremaining_18,lbltimeremaining_19,lbltimeremaining_20};

		//* *********
		
	     Thread thread = new Thread(new Runnable() {

	            @Override
	            public void run() {
	                Runnable updater = new Runnable() {

	                    @Override
	                    public void run() {
	                       
	                    	ArrayList<Pc> pcactlist = PcDao.getPcDao().pcactivation_List();
	        				for(Pc temp : pcactlist) {						
	        						//색 변경
	        						pcbuttons[temp.getP_no()].setStyle("-fx-background-color: #ff0000; ");			
	        						//id 변경
	        						pcids[temp.getP_no()].setText(MemberDao.getMemberDao().find_m_id(temp.getM_no()));
	        						//시간 변경
	        						int time = TimeDao.gettimDao().time_remaintime(temp.getM_no());
	        						int hour = time/(60*60);
	        					    int minute = time/60-(hour*60);
	        					    int second = time%60;
	        						lbltimes[temp.getP_no()].setText("남은시간 "+hour+":"+String.format("%02d", minute)+":"+String.format("%02d", second));
	        						
	        				}
	                    	
	                    }
	                };

	                while (true) {
	                    try {
	                        Thread.sleep(1000);
	                    } catch (InterruptedException ex) {
	                    }

	                    // UI update is run on the Application thread
	                    Platform.runLater(updater);
	                }
	            }

	        });
	     thread.start();
	
	
		
		
//	//추가	
//		ArrayList<Pc> pcactlist = PcDao.getPcDao().pcactivation_List();
//		for(Pc temp : pcactlist) {						
//				//색 변경
//				pcbuttons[temp.getP_no()].setStyle("-fx-background-color: #ff0000; ");			
//				//id 변경
//				pcids[temp.getP_no()].setText(MemberDao.getMemberDao().find_m_id(temp.getM_no()));
//				//시간 변경
//				int time = TimeDao.gettimDao().time_remaintime(temp.getM_no());
//				int hour = time/(60*60);
//			    int minute = time/60-(hour*60);
//			    int second = time%60;
//				lbltimes[temp.getP_no()].setText("남은시간 "+hour+":"+String.format("%02d", minute)+":"+String.format("%02d", second));
//				
//		}
		
			
	}
	
//	public void time() {
//		for(Pc temp : initialize().pcactlist) {						
//			//색 변경
//			pcbuttons[temp.getP_no()].setStyle("-fx-background-color: #ff0000; ");			
//			//id 변경
//			pcids[temp.getP_no()].setText(MemberDao.getMemberDao().find_m_id(temp.getM_no()));
//			//시간 변경
//			int time = TimeDao.gettimDao().time_remaintime(temp.getM_no());
//			int hour = time/(60*60);
//		    int minute = time/60-(hour*60);
//		    int second = time%60;
//			lbltimes[temp.getP_no()].setText("남은시간 "+hour+":"+minute+":"+second);
//			
//	}
//		
//	}


	  	public static LoginController instance;
	  	
	  	public LoginController() {
	  		instance = this;
	  	}
	  	
	  	public static LoginController getinstance() {
	  		return instance;
	  	}
	  	
	  
	  	
	  	@FXML
	    private BorderPane borderpane;

	    @FXML
	    private Button btnsignup;
	  	
	    @FXML
	    private Button btnlogin;

	    @FXML
	    private Button btnpc_1;
	    
	    @FXML
	    private Button btnpc_10;
	    
	    @FXML
	    private Button btnpc_11;

	    @FXML
	    private Button btnpc_12;

	    @FXML
	    private Button btnpc_13;

	    @FXML
	    private Button btnpc_14;

	    @FXML
	    private Button btnpc_15;

	    @FXML
	    private Button btnpc_16;

	    @FXML
	    private Button btnpc_17;

	    @FXML
	    private Button btnpc_18;

	    @FXML
	    private Button btnpc_19;

	    @FXML
	    private Button btnpc_2;

	    @FXML
	    private Button btnpc_20;

	    @FXML
	    private Button btnpc_3;

	    @FXML
	    private Button btnpc_4;

	    @FXML
	    private Button btnpc_5;

	    @FXML
	    private Button btnpc_6;

	    @FXML
	    private Button btnpc_7;

	    @FXML
	    private Button btnpc_8;

	    @FXML
	    private Button btnpc_9;

	    @FXML
	    private Label lblid_1;

	    @FXML
	    private Label lblid_10;

	    @FXML
	    private Label lblid_11;

	    @FXML
	    private Label lblid_12;

	    @FXML
	    private Label lblid_13;

	    @FXML
	    private Label lblid_14;

	    @FXML
	    private Label lblid_15;

	    @FXML
	    private Label lblid_16;

	    @FXML
	    private Label lblid_17;

	    @FXML
	    private Label lblid_18;

	    @FXML
	    private Label lblid_19;

	    @FXML
	    private Label lblid_2;

	    @FXML
	    private Label lblid_20;

	    @FXML
	    private Label lblid_3;

	    @FXML
	    private Label lblid_4;

	    @FXML
	    private Label lblid_5;

	    @FXML
	    private Label lblid_6;

	    @FXML
	    private Label lblid_7;

	    @FXML
	    private Label lblid_8;

	    @FXML
	    private Label lblid_9;

	    @FXML
	    private Label lbltimeremaining_1;

	    @FXML
	    private Label lbltimeremaining_10;

	    @FXML
	    private Label lbltimeremaining_11;

	    @FXML
	    private Label lbltimeremaining_12;

	    @FXML
	    private Label lbltimeremaining_13;

	    @FXML
	    private Label lbltimeremaining_14;

	    @FXML
	    private Label lbltimeremaining_15;

	    @FXML
	    private Label lbltimeremaining_16;

	    @FXML
	    private Label lbltimeremaining_17;

	    @FXML
	    private Label lbltimeremaining_18;

	    @FXML
	    private Label lbltimeremaining_19;

	    @FXML
	    private Label lbltimeremaining_2;

	    @FXML
	    private Label lbltimeremaining_20;

	    @FXML
	    private Label lbltimeremaining_3;

	    @FXML
	    private Label lbltimeremaining_4;

	    @FXML
	    private Label lbltimeremaining_5;

	    @FXML
	    private Label lbltimeremaining_6;

	    @FXML
	    private Label lbltimeremaining_7;

	    @FXML
	    private Label lbltimeremaining_8;

	    @FXML
	    private Label lbltimeremaining_9;

	    @FXML
	    private AnchorPane loginanchor;

	    @FXML
	    private TextField txtid;

	    @FXML
	    private PasswordField txtpassword;

	   

//	    public Button[] getbuttonlist( ) {
//			
//		}
	    
	    @FXML
	    void signup(ActionEvent event) {	    	
	    	
	    	showpage("k_signup");
	    }
	    int m_no = 0;
	    
		@FXML
	    void login(ActionEvent event) {
	    	boolean login = MemberDao.getMemberDao().login(txtid.getText(), txtpassword.getText());
	    	Alert alert = new Alert(AlertType.INFORMATION);
	    	if(login) {
	    		m_no = MemberDao.getMemberDao().find_m_no(txtid.getText());
	    		
	    		alert.setHeaderText("로그인완료");
	    		alert.showAndWait();
	    		loadpage("k_main");
	    	}else {
	    		alert.setHeaderText("아아디 또는 비밀번호를 확인해주세요");
	    		alert.showAndWait(); 
	    	}
			
	    	
	    }
	    
	    public void loadpage( String page ) {
	    	
	    	
	    	try {
	    		Parent parent = FXMLLoader.load(
	    				getClass().getResource("/fxml/"+page+".fxml"));
	    		borderpane.setCenter(parent);
	    		
	    	}
	    	catch (Exception e) {}
	    }
	    
	    public void showpage(String page) {
			Stage stage = new Stage();
			try {
				Parent parent = FXMLLoader.load(getClass().getResource("/fxml/"+page+".fxml"));
				Scene scene = new Scene( parent );
				stage.setScene(scene);
				stage.setResizable(false); 
				stage.show();
			}
			catch (Exception e) {}
			
		}
	    
	    
}













