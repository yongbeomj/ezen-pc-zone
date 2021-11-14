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
import javafx.scene.control.RadioButton;
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
		// 로그인 id 조회
		String loginid = LoginController.getinstance().getloginid();
		System.out.println(loginid);
		// m_no 조회
		int m_no = MemberDao.getMemberDao().mnocheck(loginid);
		System.out.println(m_no);
		// 내가 등록한 제품 가져오기
		ObservableList<Product> products = ProductDao.getProductDao().productlist();
		System.out.println("가져오기 성공");
		// 테이블 뷰에 리스트 삽입
		productlist.setItems(products);
		TableColumn tc = productlist.getColumns().get(0);
			tc.setCellValueFactory(new PropertyValueFactory<>("p_no"));
		tc = productlist.getColumns().get(1);
			tc.setCellValueFactory(new PropertyValueFactory<>("p_name"));
		tc = productlist.getColumns().get(2);
			tc.setCellValueFactory(new PropertyValueFactory<>("p_count"));
		tc = productlist.getColumns().get(3);
			tc.setCellValueFactory(new PropertyValueFactory<>("p_price"));
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
    private ImageView imgbm1;

    @FXML
    private ImageView imgbm2;

    @FXML
    private ImageView imgbm3;

    @FXML
    private ImageView imgbm4;

    @FXML
    private ImageView imgbm5;

    @FXML
    private ImageView imgbm6;

    @FXML
    private ImageView imgmenu1;

    @FXML
    private ImageView imgmenu10;

    @FXML
    private ImageView imgmenu11;

    @FXML
    private ImageView imgmenu12;

    @FXML
    private ImageView imgmenu13;

    @FXML
    private ImageView imgmenu14;

    @FXML
    private ImageView imgmenu15;

    @FXML
    private ImageView imgmenu2;

    @FXML
    private ImageView imgmenu3;

    @FXML
    private ImageView imgmenu4;

    @FXML
    private ImageView imgmenu5;

    @FXML
    private ImageView imgmenu6;

    @FXML
    private ImageView imgmenu7;

    @FXML
    private ImageView imgmenu8;

    @FXML
    private ImageView imgmenu9;

    @FXML
    private RadioButton lblmenu1;

    @FXML
    private RadioButton lblmenu10;

    @FXML
    private RadioButton lblmenu11;

    @FXML
    private RadioButton lblmenu12;

    @FXML
    private RadioButton lblmenu13;

    @FXML
    private RadioButton lblmenu14;

    @FXML
    private RadioButton lblmenu15;

    @FXML
    private RadioButton lblmenu2;

    @FXML
    private RadioButton lblmenu3;

    @FXML
    private RadioButton lblmenu4;

    @FXML
    private RadioButton lblmenu5;

    @FXML
    private RadioButton lblmenu6;

    @FXML
    private RadioButton lblmenu7;

    @FXML
    private RadioButton lblmenu8;

    @FXML
    private RadioButton lblmenu9;

    @FXML
    private TableView<Product> productlist;

    @FXML
    private AnchorPane productorderpane;

    @FXML
    private TextField txtprice;

    @FXML
    void countchange(ActionEvent event) {

    }

    @FXML
    void memu1(ActionEvent event) {

    }

    @FXML
    void memu10(ActionEvent event) {

    }

    @FXML
    void memu11(ActionEvent event) {

    }

    @FXML
    void memu12(ActionEvent event) {

    }

    @FXML
    void memu13(ActionEvent event) {

    }

    @FXML
    void memu14(ActionEvent event) {

    }

    @FXML
    void memu15(ActionEvent event) {

    }

    @FXML
    void memu2(ActionEvent event) {

    }

    @FXML
    void memu3(ActionEvent event) {

    }

    @FXML
    void memu4(ActionEvent event) {

    }

    @FXML
    void memu5(ActionEvent event) {

    }

    @FXML
    void memu6(ActionEvent event) {

    }

    @FXML
    void memu7(ActionEvent event) {

    }

    @FXML
    void memu8(ActionEvent event) {

    }

    @FXML
    void memu9(ActionEvent event) {

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
    void productcount(ActionEvent event) {

    }

}
