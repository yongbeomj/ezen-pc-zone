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
import javafx.scene.paint.Color;

public class ProductorderController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// �α��� id ��ȸ
		String loginid = LoginController.getinstance().getloginid();
		System.out.println(loginid);
		// m_no ��ȸ
		int m_no = MemberDao.getMemberDao().mnocheck(loginid);
		System.out.println(m_no);

//		Group root = new Group();
//		Scene scene = new Scene(root, 700,250, Color.LIGHTBLUE);
//		String add = "https://w.namu.la/s/9f15f198aab1b14c8aa47e96a91a9d03331ecb7b5b892c803159d39b0d77ab4be30e2f15f66191284d7dad8371989329cc1c80810745e980a6949ae5e3589df64d239a3ca63c5a7574a4ad2656633c8c";
//		
//		ImageView[] imageViews = new ImageView[100];
//		int z = 0;
//		
//		for (int i = 0; i < 100; i++) {
//			imageViews[i] = new ImageView(new Image(add));
//			imageViews[i].setLayoutX(30 + (z * 60));
//			imageViews[i].setFitWidth(200);
//			imageViews[i].setPreserveRatio(true);
//			
//			if (i % 3 == 0) {
//				z = 0;
//			}
//			if (i / 3 >= 1 && i % 3 == 0) {
//				imageViews[i].setLayoutX(30 + (z * 60));
//				imageViews[i].setLayoutY(50);
//			}
//			imageViews[i].setOnMouseClicked( e -> {
//	            System.out.println( e.toString() +"��ǰ�� ���� �Ǿ����ϴ� ");
//	         });
//			
//			productorderpane.getChildren().add(imageViews[i] ); // ��ġ 
//	        z++;
//		}
//		
//	      Button[] buttons = new Button[30];         // ��ư 30�� ����� 
//	      int z = 0;
//	      for( int i = 0 ; i<30 ; i++ ) {
//	         
//	         buttons[i] = new Button("�¼�" + String.format("%02d", i) );      // �޸� �Ҵ� 
//	         buttons[i].setLayoutX( 30 + (z*60) );
//	         
//	         if( i % 10 == 0 ) z = 0;
//	         if( i / 10 == 1 ) {
//	            buttons[i].setLayoutX( 30 + (z*60) );
//	            buttons[i].setLayoutY( 50 );
//	         }
//	         if( i / 20 == 1 ) {
//	            buttons[i].setLayoutX( 30 + (z*60) );
//	            buttons[i].setLayoutY( 100 );
//	         }
//	         buttons[i].setOnAction( e -> {
//	            System.out.println( e.toString() +"�¼��� ���� �Ǿ����ϴ� ");
//	         });
//	      
//	         productorderpane.getChildren().add(buttons[i] ); // ��ġ 
//	         z++;
//	      }

//	      ScrollPane scrollPane = new ScrollPane();

//	      Image[] images = new Image[30];

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
	void productcount(ActionEvent event) {

	}

}
