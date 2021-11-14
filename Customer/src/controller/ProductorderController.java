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
//		// �α��� id ��ȸ
//		String loginid = LoginController.getinstance().getloginid();
//		// m_no ��ȸ
//		int m_no = MemberDao.getMemberDao().mnocheck(loginid);
//		// ���� ����� ��ǰ ��������
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
//		// ���̺� �信 ����Ʈ ����
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
    	alert.setContentText(" �޴����� ");
    	alert.setHeaderText(" �޴��� �����Ͻðڽ��ϱ�? ");
    	alert.setTitle("�޴�����");
    	// �˸�â�� ���� �� �ɼ�(Ȯ��, ���)�� ���� ��� �ٸ�
    	Optional<ButtonType> optional = alert.showAndWait();
    	if( optional.get() == ButtonType.OK ) { // Ȯ���� ������
    		
    	}
	}

	@FXML
	void order(ActionEvent event) {
		Alert alert = new Alert( AlertType.CONFIRMATION );
    	alert.setContentText(" �ֹ��ϱ� ");
    	alert.setHeaderText(" �ֹ��Ͻðڴϱ�? ");
    	alert.setTitle(" �ֹ��ϱ� ");
    	// �˸�â�� ���� �� �ɼ�(Ȯ��, ���)�� ���� ��� �ٸ�
    	Optional<ButtonType> optional = alert.showAndWait();
    	if( optional.get() == ButtonType.OK ) { // Ȯ���� ������
    		btndelete.getScene().getWindow().hide(); // ����â�� ����
        	LoginController.getinstance().loadpage("c_mainpage"); // �α��� â Ȱ��ȭ
    	}
	}

	@FXML
	void productcount(ActionEvent event) {

	}

}
