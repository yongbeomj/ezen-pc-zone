package controller;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.MemberDao;
import dao.ProductDao;
import domain.Product;
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
		System.out.println("login : "+loginid);
		// m_no 조회
		int m_no = MemberDao.getMemberDao().mnocheck(loginid);
		System.out.println("no : "+m_no);
		String add = "http://d20aeo683mqd6t.cloudfront.net/ko/articles/title_images/000/039/143/medium/IMG_5649%E3%81%AE%E3%82%B3%E3%83%92%E3%82%9A%E3%83%BC.jpg?2019";
		Image image = new Image(add);
        ImageView img = new ImageView(image);
        
		Button[] buttons = new Button[30]; // 버튼 30개 저장소
		int z = 0;
		for (int i = 0; i < 30; i++) {

			buttons[i].setGraphic(img);
			buttons[i].setWrapText(true);
			
			buttons[i] = new Button("좌석" + String.format("%02d", i)); // 메모리 할당
			buttons[i].setLayoutX(40 + (z * 150));
			buttons[i].setLayoutY(50);

			if (i % 5 == 0) {
				z = 0;
			}
			if (i / 5 == 1) {
				buttons[i].setLayoutX(40 + (z * 150));
				buttons[i].setLayoutY(150);
			}
			if (i / 10 == 1) {
				buttons[i].setLayoutX(40 + (z * 150));
				buttons[i].setLayoutY(250);
			}
			if (i / 15 == 1) {
				buttons[i].setLayoutX(40 + (z * 150));
				buttons[i].setLayoutY(350);
			}
			if (i / 20 == 1) {
				buttons[i].setLayoutX(40 + (z * 150));
				buttons[i].setLayoutY(450);
			}
			if (i / 25 == 1) {
				buttons[i].setLayoutX(40 + (z * 150));
				buttons[i].setLayoutY(550);
			}
			
			buttons[i].setOnAction(e -> {
				System.out.println(e.toString() + "좌석이 선택 되었습니다 ");
			});

			cp.getChildren().add(buttons[i]); // 배치
			z++;
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
    private TableView<?> productlist;

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
