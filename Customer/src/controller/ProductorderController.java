package controller;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ProductorderController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		// 로그인 id 조회
//		String loginid = LoginController.getinstance().getloginid();
//		// m_no 조회
//		int m_no = MemberDao.getMemberDao().mnocheck(loginid);
//		// 내가 등록한 제품 가져오기
//		ObservableList<Product> products = ProductDao.getProductDao().productlist();
//		TableColumn tc = productlist.getColumns().get(0);
//			tc.setCellValueFactory(new PropertyValueFactory<>("p_no"));
//		tc = productlist.getColumns().get(1);
//			tc.setCellValueFactory(new PropertyValueFactory<>("p_name"));
//		tc = productlist.getColumns().get(2);
//			tc.setCellValueFactory(new PropertyValueFactory<>("p_count"));
//		tc = productlist.getColumns().get(3);
//			tc.setCellValueFactory(new PropertyValueFactory<>("p_price"));
//		
//		// 테이블 뷰에 리스트 삽입
//		productlist.setItems(products);
//		
		
	}
	@FXML
	private AnchorPane bmpane;

	@FXML
	private ImageView imgproductbm;

	@FXML
	private AnchorPane menupane;

	@FXML
	private ImageView imgproductmenu;

	@FXML
	private Button btncountchange;

	@FXML
	private Button btndelete;

	@FXML
	private Button btnorder;

	@FXML
	private ComboBox<?> cbproductcount;

	@FXML
	private TableView<?> productlist;

	@FXML
	private AnchorPane productorderpane;

	@FXML
	private TextField txtprice;

	@FXML
	void countchange(ActionEvent event) {

	}

	@FXML
	void delete(ActionEvent event) {
		Alert alert = new Alert( AlertType.CONFIRMATION );
    	alert.setContentText(" 메뉴삭제 ");
    	alert.setHeaderText(" 메뉴를 삭제하시겠습니까? ");
    	alert.setTitle("메뉴삭제");
    	// 알림창이 떴을 때 옵션(확인, 취소)에 따라 기능 다름
    	Optional<ButtonType> optional = alert.showAndWait();
    	if( optional.get() == ButtonType.OK ) { // 확인을 누르면
    		
    	}
	}

	@FXML
	void order(ActionEvent event) {
		Alert alert = new Alert( AlertType.CONFIRMATION );
    	alert.setContentText(" 주문하기 ");
    	alert.setHeaderText(" 주문하시겠니까? ");
    	alert.setTitle(" 주문하기 ");
    	// 알림창이 떴을 때 옵션(확인, 취소)에 따라 기능 다름
    	Optional<ButtonType> optional = alert.showAndWait();
    	if( optional.get() == ButtonType.OK ) { // 확인을 누르면
    		btndelete.getScene().getWindow().hide(); // 메인창을 끄고
        	LoginController.getinstance().loadpage("c_mainpage"); // 로그인 창 활성화
    	}
	}

	@FXML
	void productcount(ActionEvent event) {

	}

}
