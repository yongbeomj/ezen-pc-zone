package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Dao.OrderDetailDao;
import Dao.ProductOrderDao;
import Domain.OrderDetail;
import Domain.ProductOrder;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;

public class ProductOrderController implements Initializable  {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		productorderdetailtableload();	
	}
	
    @FXML
    private TableView<OrderDetail> txtorderdetail;

    public static OrderDetail orderDetail;
	
	public void productorderdetailtableload() {
		// 1. DB에서 제품목록 가져오기
		ObservableList<OrderDetail> orderDetails = OrderDetailDao.getOrderDetailDao().orderDetails(ProductListController.productorder.getPo_no());
		// 2. 제품목록을 테이블 뷰에 넣어주기
		
		txtorderdetail.setItems(orderDetails);
		// 3. 테이블 뷰에 열을 하나씩 가져와서 리스트내 객체에 필드와 연결
		TableColumn tc = txtorderdetail.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("od_no"));
		tc = txtorderdetail.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("p_name"));
		tc = txtorderdetail.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("od_category"));
		tc = txtorderdetail.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("od_count"));
		tc = txtorderdetail.getColumns().get(4);
		tc.setCellValueFactory(new PropertyValueFactory<>("od_price"));
	}
	
		
}
