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


	
	// �α��� id ��ȸ
	String loginid = LoginController.getinstance().getloginid();
	// m_no ��ȸ
	int m_no = MemberDao.getMemberDao().mnocheck(loginid);

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// �α��� id ��ȸ
		String loginid = LoginController.getinstance().getloginid();
		System.out.println("login : " + loginid);
		// m_no ��ȸ
		int m_no = MemberDao.getMemberDao().mnocheck(loginid);
		System.out.println("no : " + m_no);

		Button[] buttons = new Button[25];

		int x = 0;
		int y = 0;

		for (int i = 0; i < buttons.length; i++) {
			
			File file = new File("src/image/1.png");
			Image image = new Image( file.toURI().toString() );
			
			buttons[i] = new Button(); // �޸� �Ҵ�
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
				System.out.println(e.toString() + "��ǰ�� ���� �Ǿ����ϴ� ");
			});
				
			cp.getChildren().add(buttons[i]); // ��ġ
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
		alert.setContentText(" �޴����� ");
		alert.setHeaderText(" �޴��� �����Ͻðڽ��ϱ�? ");
		alert.setTitle("�޴�����");
		// �˸�â�� ���� �� �ɼ�(Ȯ��, ���)�� ���� ��� �ٸ�
		Optional<ButtonType> optional = alert.showAndWait();
		if (optional.get() == ButtonType.OK) { // Ȯ���� ������

		}
	}

	@FXML
	void order(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(" �ֹ��ϱ� ");
		alert.setHeaderText(" �ֹ��Ͻðڴϱ�? ");
		alert.setTitle(" �ֹ��ϱ� ");
		// �˸�â�� ���� �� �ɼ�(Ȯ��, ���)�� ���� ��� �ٸ�
		Optional<ButtonType> optional = alert.showAndWait();
		if (optional.get() == ButtonType.OK) { // Ȯ���� ������
			btndelete.getScene().getWindow().hide(); // ����â�� ����
			LoginController.getinstance().loadpage("c_mainpage"); // �α��� â Ȱ��ȭ
		}
	}

	@FXML
	void productcount(ActionEvent event) {

	}
}
