package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import Dao.MemberDao;
import Dao.ProductDao;
import Domain.Member;
import Domain.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;

public class MemberController implements Initializable {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	private static Member member = new Member();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		membertableload(0);
		
		lblemail.setText(member.getM_email());
		lblname.setText(member.getM_name());
		lblphone.setText(member.getM_pw());
		lblsex.setText(member.getSex());
		lblpw.setText(member.getM_pw());
		

	}

	@FXML
	private Label lblemail;

	@FXML
	private Label lblname;

	@FXML
	private Label lblphone;

	@FXML
	private Label lblpw;

	@FXML
	private Label lblsex;

	@FXML
	private Button btnback;

	@FXML
	private Button btndelete;


	@FXML
	private Button btnupdate;

	@FXML
	private TableView<Member> memberlist;

	@FXML
	private TextField txtmemail;

	@FXML
	private TextField txtmname;

	@FXML
	private TextField txtmphone;

	@FXML
	private TextField txtmpw;

	@FXML
	private TextField txtmsex;
	
    @FXML
    private Button btnsearch;

    @FXML
    private TextField txtsearch;
    
    @FXML
    void search(ActionEvent event) {
    	
    	membertableload(1);
    }

	

	@FXML
	void delete(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("회원을 삭제하시겠습니까?");
		Optional<ButtonType> optional = alert.showAndWait();
		if (optional.get() == ButtonType.OK) {
			MemberDao.getMemberDao().delete(member.getM_no());
			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setHeaderText("삭제되었습니다.");
			alert2.showAndWait();
			SystemController.getinstance().loadpage("a_member");
		}
	}

	public void membertableload(int type) {
		ObservableList<Member> members ;
		if(type==0) {
			members = MemberDao.getMemberDao().memberlist(0,null);
			memberlist.setItems(members);
			TableColumn tc = memberlist.getColumns().get(0);
			tc.setCellValueFactory(new PropertyValueFactory<>("m_no"));
			tc = memberlist.getColumns().get(1);
			tc.setCellValueFactory(new PropertyValueFactory<>("m_id"));
			tc = memberlist.getColumns().get(2);
			tc.setCellValueFactory(new PropertyValueFactory<>("m_pw"));
			tc = memberlist.getColumns().get(3);
			tc.setCellValueFactory(new PropertyValueFactory<>("m_name"));
			tc = memberlist.getColumns().get(4);
			tc.setCellValueFactory(new PropertyValueFactory<>("m_email"));
			tc = memberlist.getColumns().get(5);
			tc.setCellValueFactory(new PropertyValueFactory<>("m_phone"));
			tc = memberlist.getColumns().get(6);
			tc.setCellValueFactory(new PropertyValueFactory<>("sex"));
			
			memberlist.setOnMouseClicked(e -> {
			
				if (e.getButton().equals(MouseButton.PRIMARY)) {
				
					member = memberlist.getSelectionModel().getSelectedItem();
					
					lblphone.setText(member.getM_phone());
					lblname.setText(member.getM_name());
					lblsex.setText(member.getSex());
					
					lblemail.setText(member.getM_email());
					lblpw.setText(member.getM_pw());
					
				}
			});
			
		} else if(type==1) {
			if(txtsearch.getText().equals("")) {
				members = MemberDao.getMemberDao().memberlist(0,null);
			} else {
				members = MemberDao.getMemberDao().memberlist(1,txtsearch.getText());
			}
			
			memberlist.setItems(members);
			TableColumn tc = memberlist.getColumns().get(0);
			tc.setCellValueFactory(new PropertyValueFactory<>("m_no"));
			tc = memberlist.getColumns().get(1);
			tc.setCellValueFactory(new PropertyValueFactory<>("m_id"));
			tc = memberlist.getColumns().get(2);
			tc.setCellValueFactory(new PropertyValueFactory<>("m_pw"));
			tc = memberlist.getColumns().get(3);
			tc.setCellValueFactory(new PropertyValueFactory<>("m_name"));
			tc = memberlist.getColumns().get(4);
			tc.setCellValueFactory(new PropertyValueFactory<>("m_email"));
			tc = memberlist.getColumns().get(5);
			tc.setCellValueFactory(new PropertyValueFactory<>("m_phone"));
			tc = memberlist.getColumns().get(6);
			tc.setCellValueFactory(new PropertyValueFactory<>("sex"));
			
			memberlist.setOnMouseClicked(e -> {
			
				if (e.getButton().equals(MouseButton.PRIMARY)) {
				
					member = memberlist.getSelectionModel().getSelectedItem();
				
					lblname.setText(member.getM_name());
					lblsex.setText(member.getSex());
					lblphone.setText(member.getM_phone());
					lblemail.setText(member.getM_email());
					lblpw.setText(member.getM_pw());
					
				}
			});
		}



	}

	private static String mid;
	
	@FXML
	void update(ActionEvent event) {
		
		
		String mname = txtmname.getText();
		if(txtmname.getText().equals("")) {
			mname =	member.getM_name();
		}
		String mpw = txtmpw.getText();
		if(txtmpw.getText().equals("")) {
			mpw =member.getM_pw();
		}
		String memail = txtmemail.getText();
		if(txtmemail.getText().equals("")) {
			memail =member.getM_email();
		}
		String mphone = txtmphone.getText();
		if(txtmphone.getText().equals("")) {
			mphone =member.getM_phone();
		}
		
		
		
		int msex=0;
		if( txtmsex.getText().equals("") ) {
			msex =	member.getM_sex();
		}else if(Integer.parseInt(txtmsex.getText())>2){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("성별을 다시 입력해주세요");
			alert.showAndWait();
			return; 	
		} else {
			msex = Integer.parseInt(txtmsex.getText());
			
		}
		
	
			
		Member member2 = new Member(member.getM_no(), mid, mpw, mname, memail, mphone, msex);

		boolean result = MemberDao.getMemberDao().update(member2);
		if (result) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("회원 수정 완료");
			alert.showAndWait();
			SystemController.getinstance().loadpage("a_member");

		}
	}

	@FXML
	void back(ActionEvent event) {
		SystemController.getinstance().loadpage("a_system");
	}

}
