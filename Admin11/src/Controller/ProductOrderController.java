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
		// 1. DB���� ��ǰ��� ��������
		ObservableList<OrderDetail> orderDetails = OrderDetailDao.getOrderDetailDao().orderDetails(ProductListController.productorder.getPo_no());
		// 2. ��ǰ����� ���̺� �信 �־��ֱ�
		
		txtorderdetail.setItems(orderDetails);
		// 3. ���̺� �信 ���� �ϳ��� �����ͼ� ����Ʈ�� ��ü�� �ʵ�� ����
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
