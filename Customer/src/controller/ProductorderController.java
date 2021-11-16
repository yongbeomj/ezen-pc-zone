package controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.MemberDao;
import dao.ProductDao;
import domain.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class ProductorderController implements Initializable {


	
	// 로그인 id 조회
	String loginid = LoginController.getinstance().getloginid();
	// m_no 조회
	int m_no = MemberDao.getMemberDao().mnocheck(loginid);

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 로그인 id 조회
		String loginid = LoginController.getinstance().getloginid();
		System.out.println("login : " + loginid);
		// m_no 조회
		int m_no = MemberDao.getMemberDao().mnocheck(loginid);
		System.out.println("no : " + m_no);

		Button[] buttons = new Button[25];

		int x = 0;
		int y = 0;

		for (int i = 0; i < buttons.length; i++) {
			
			File file = new File("src/image/1.png");
			Image image = new Image( file.toURI().toString() );
			
			buttons[i] = new Button(); // 메모리 할당
			buttons[i].setGraphic(new ImageView(image));
			buttons[i].setWrapText(true);

			if (i == 0) {
				buttons[i].setLayoutX(40);
				buttons[i].setLayoutY(50);
			}
			if (i > 0 && i % 5 == 0) {
				x = 0;
				y++;
			}
			
			buttons[i].setLayoutX(40 + (x * 135));
			buttons[i].setLayoutY(50 + (y * 100));
			
			buttons[i].setOnAction(e -> {
				System.out.println(e.toString() + "제품이 선택 되었습니다 ");
			});
				
			cp.getChildren().add(buttons[i]); // 배치
			x++;
		}
				
		
	}
	
	

	@FXML
	private Button btncountchange;

	@FXML
	private Button btndelete;

	@FXML
	private Button btnorder;

	@FXML
	private ComboBox<?> cbproductcount;

	@FXML
	private AnchorPane cp;

	@FXML
	private AnchorPane lp;

	@FXML
	private TableView<Product> productlist;

	@FXML
	private BorderPane productorderpane;

	@FXML
	private AnchorPane tp;

	@FXML
	private TextField txtprice;

	@FXML
	void countchange(ActionEvent event) {

	}

	@FXML
	void delete(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(" 메뉴삭제 ");
		alert.setHeaderText(" 메뉴를 삭제하시겠습니까? ");
		alert.setTitle("메뉴삭제");
		// 알림창이 떴을 때 옵션(확인, 취소)에 따라 기능 다름
		Optional<ButtonType> optional = alert.showAndWait();
		if (optional.get() == ButtonType.OK) { // 확인을 누르면

		}
	}

	@FXML
	void order(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(" 주문하기 ");
		alert.setHeaderText(" 주문하시겠니까? ");
		alert.setTitle(" 주문하기 ");
		// 알림창이 떴을 때 옵션(확인, 취소)에 따라 기능 다름
		Optional<ButtonType> optional = alert.showAndWait();
		if (optional.get() == ButtonType.OK) { // 확인을 누르면
			btndelete.getScene().getWindow().hide(); // 메인창을 끄고
			LoginController.getinstance().loadpage("c_mainpage"); // 로그인 창 활성화
		}
	}

	@FXML
	void productcount(ActionEvent event) {

	}
}
