package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.MemberDao;
import dao.PcDao;
import dao.TimeDao;
import domain.Pc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MoveController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 로그인 id 조회
		String loginid = LoginController.getinstance().getloginid();
		// m_no 조회
		int m_no = MemberDao.getMemberDao().mnocheck(loginid);
		// m_no의 pc_no 조회
		int pc_no = PcDao.getPcDao().pcnocheck(m_no);
		lblprepc.setText("No." + p_no);
		lblafterpc.setText("");
		
		// 사용 중 pc 확인
		Button[] pcbuttons = {  null, btnpc_1 ,btnpc_2 ,btnpc_3 ,btnpc_4 ,btnpc_5 ,btnpc_6 ,btnpc_7 ,btnpc_8 ,btnpc_9 ,btnpc_10 
				,btnpc_11  ,btnpc_12  ,btnpc_13,btnpc_14,btnpc_15,btnpc_16,btnpc_17,btnpc_18,btnpc_19,btnpc_20};
		Label[] pcids = { null,lblid_1,lblid_2,lblid_3,lblid_4,lblid_5,lblid_6,lblid_7,lblid_8,lblid_9,lblid_10
				,lblid_11,lblid_12,lblid_13,lblid_14,lblid_15,lblid_16,lblid_17,lblid_18,lblid_19,lblid_20};
		Label[] lbltimes = { null,lbltimeremaining_1,lbltimeremaining_2,lbltimeremaining_3,lbltimeremaining_4,lbltimeremaining_5,lbltimeremaining_6,lbltimeremaining_7
				,lbltimeremaining_8,lbltimeremaining_9,lbltimeremaining_10,lbltimeremaining_11,lbltimeremaining_12,lbltimeremaining_13,lbltimeremaining_14,lbltimeremaining_15
				,lbltimeremaining_16,lbltimeremaining_17,lbltimeremaining_18,lbltimeremaining_19,lbltimeremaining_20};
		ArrayList<Pc> pcactlist = PcDao.getPcDao().pcactivation_List();
		
		for(Pc temp : pcactlist) {
			// 색 변경
			pcbuttons[temp.getP_no()].setStyle("-fx-background-color: #ff0000; ");
			// id 표시
			pcids[temp.getP_no()].setText(MemberDao.getMemberDao().midcheck(temp.getM_no()));
			// pc사용여부 표시
			lbltimes[temp.getP_no()].setText("사용 중");
		}
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
    // 로그인 id 조회
 		String loginid = LoginController.getinstance().getloginid();
 		// m_no 조회
 		int m_no = MemberDao.getMemberDao().mnocheck(loginid);
 		// m_no의 pc_no 조회
 		int p_no = PcDao.getPcDao().pcnocheck(m_no);
 		int pc = 0;
 		
    @FXML
    void move(ActionEvent event) {
    	PcDao.getPcDao().pclogout(p_no, m_no);
    	PcDao.getPcDao().pclogin(pc, m_no);
    	
    	Alert alert = new Alert( AlertType.CONFIRMATION );
    	alert.setHeaderText(" 자리이동 되었습니다 ");
    	alert.setTitle("자리이동");
    	alert.showAndWait();
    	
    	btnmove.getScene().getWindow().hide();
    	loadpage("c_login");
    }
    
    @FXML
    private BorderPane borderpane;

    @FXML
    private Button btnmove;

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
    private Group g1;

    @FXML
    private Group g10;

    @FXML
    private Group g11;

    @FXML
    private Group g12;

    @FXML
    private Group g13;

    @FXML
    private Group g14;

    @FXML
    private Group g15;

    @FXML
    private Group g16;

    @FXML
    private Group g17;

    @FXML
    private Group g18;

    @FXML
    private Group g19;

    @FXML
    private Group g2;

    @FXML
    private Group g20;

    @FXML
    private Group g3;

    @FXML
    private Group g4;

    @FXML
    private Group g5;

    @FXML
    private Group g6;

    @FXML
    private Group g7;

    @FXML
    private Group g8;

    @FXML
    private Group g9;

    @FXML
    private Label lblafterpc;

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
    private Label lblprepc;

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
    void mcg1(MouseEvent event) {
    	lblafterpc.setText("No.1");
    	pc = 1;
    }

    @FXML
    void mcg10(MouseEvent event) {
    	lblafterpc.setText("No.10");
    	pc = 10;
    }

    @FXML
    void mcg11(MouseEvent event) {
    	lblafterpc.setText("No.11");
    	pc = 11;
    }

    @FXML
    void mcg12(MouseEvent event) {
    	lblafterpc.setText("No.12");
    	pc = 12;
    }

    @FXML
    void mcg13(MouseEvent event) {
    	lblafterpc.setText("No.13");
    	pc = 13;
    }

    @FXML
    void mcg14(MouseEvent event) {
    	lblafterpc.setText("No.14");
    	pc = 14;
    }

    @FXML
    void mcg15(MouseEvent event) {
    	lblafterpc.setText("No.15");
    	pc = 15;
    }

    @FXML
    void mcg16(MouseEvent event) {
    	lblafterpc.setText("No.16");
    	pc = 16;
    }

    @FXML
    void mcg17(MouseEvent event) {
    	lblafterpc.setText("No.17");
    	pc = 17;
    }

    @FXML
    void mcg18(MouseEvent event) {
    	lblafterpc.setText("No.18");
    	pc = 18;
    }

    @FXML
    void mcg19(MouseEvent event) {
    	lblafterpc.setText("No.19");
    	pc = 19;
    }

    @FXML
    void mcg2(MouseEvent event) {
    	lblafterpc.setText("No.2");
    	pc = 2;
    }

    @FXML
    void mcg20(MouseEvent event) {
    	lblafterpc.setText("No.20");
    	pc = 20;
    }

    @FXML
    void mcg3(MouseEvent event) {
    	lblafterpc.setText("No.3");
    	pc = 3;
    }

    @FXML
    void mcg4(MouseEvent event) {
    	lblafterpc.setText("No.4");
    	pc = 4;
    }

    @FXML
    void mcg5(MouseEvent event) {
    	lblafterpc.setText("No.5");
    	pc = 5;
    }

    @FXML
    void mcg6(MouseEvent event) {
    	lblafterpc.setText("No.6");
    	pc = 6;
    }

    @FXML
    void mcg7(MouseEvent event) {
    	lblafterpc.setText("No.7");
    	pc = 7;
    }

    @FXML
    void mcg8(MouseEvent event) {
    	lblafterpc.setText("No.8");
    	pc = 8;
    }

    @FXML
    void mcg9(MouseEvent event) {
    	lblafterpc.setText("No.9");
    	pc = 9;
    }

    

    
}
