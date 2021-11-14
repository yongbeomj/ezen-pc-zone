package controller;

import java.net.URL;
import java.util.ResourceBundle;

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
		lblprepc.setText("1");
		lblafterpc.setText("");
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
    @FXML
    void pc_1(ActionEvent event) {
    	lblafterpc.setText("PC1");
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
    }

    @FXML
    void mcg10(MouseEvent event) {
    	lblafterpc.setText("No.10");
    }

    @FXML
    void mcg11(MouseEvent event) {
    	lblafterpc.setText("No.11");
    }

    @FXML
    void mcg12(MouseEvent event) {
    	lblafterpc.setText("No.12");
    }

    @FXML
    void mcg13(MouseEvent event) {
    	lblafterpc.setText("No.13");
    }

    @FXML
    void mcg14(MouseEvent event) {
    	lblafterpc.setText("No.14");
    }

    @FXML
    void mcg15(MouseEvent event) {
    	lblafterpc.setText("No.15");
    }

    @FXML
    void mcg16(MouseEvent event) {
    	lblafterpc.setText("No.16");
    }

    @FXML
    void mcg17(MouseEvent event) {
    	lblafterpc.setText("No.17");
    }

    @FXML
    void mcg18(MouseEvent event) {
    	lblafterpc.setText("No.18");
    }

    @FXML
    void mcg19(MouseEvent event) {
    	lblafterpc.setText("No.19");
    }

    @FXML
    void mcg2(MouseEvent event) {
    	lblafterpc.setText("No.2");
    }

    @FXML
    void mcg20(MouseEvent event) {
    	lblafterpc.setText("No.20");
    }

    @FXML
    void mcg3(MouseEvent event) {
    	lblafterpc.setText("No.3");
    }

    @FXML
    void mcg4(MouseEvent event) {
    	lblafterpc.setText("No.4");
    }

    @FXML
    void mcg5(MouseEvent event) {
    	lblafterpc.setText("No.5");
    }

    @FXML
    void mcg6(MouseEvent event) {
    	lblafterpc.setText("No.6");
    }

    @FXML
    void mcg7(MouseEvent event) {
    	lblafterpc.setText("No.7");
    }

    @FXML
    void mcg8(MouseEvent event) {
    	lblafterpc.setText("No.8");
    }

    @FXML
    void mcg9(MouseEvent event) {
    	lblafterpc.setText("No.9");
    }

    @FXML
    void move(ActionEvent event) {
    	Alert alert = new Alert( AlertType.CONFIRMATION );
    	alert.setHeaderText(" 자리이동 되었습니다 ");
    	alert.setTitle("자리이동");
    	alert.showAndWait();
    	
    	btnmove.getScene().getWindow().hide();
    	loadpage("c_login");
    }

    
}
