package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.MemberDao;
import dao.OrderdetailDao;
import dao.PcDao;
import dao.ProductDao;
import dao.ProductorderDao;
import domain.Menubutton;
import domain.Orderdetail;
import domain.Product;
import domain.Productorder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ProductorderController implements Initializable {
//	
	String loginid = LoginController.getinstance().getloginid(); // �α��� id ��ȸ
	int m_no = MemberDao.getMemberDao().mnocheck(loginid); // m_no ��ȸ
	int p_no = PcDao.getPcDao().pcnocheck(m_no); // p_no ��ȸ

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// ���̺� �ε�
		producttableload();
		
		// ����Ʈ �޴� ��ư
		try {
			FileInputStream input1 = new FileInputStream("src/image/1.png");
			Image image1 = new Image(input1);
			imgbm1.setImage(image1);

			FileInputStream input2 = new FileInputStream("src/image/2.jpg");
			Image image2 = new Image(input2);
			imgbm2.setImage(image2);

			FileInputStream input3 = new FileInputStream("src/image/3.jpg");
			Image image3 = new Image(input3);
			imgbm3.setImage(image3);

			FileInputStream input4 = new FileInputStream("src/image/4.jpg");
			Image image4 = new Image(input4);
			imgbm4.setImage(image4);

			FileInputStream input5 = new FileInputStream("src/image/5.jpg");
			Image image5 = new Image(input5);
			imgbm5.setImage(image5);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// ����ִ� ��ǰ ��
//		int actcnt = ProductDao.getProductDao().actproductcount();
		int columns = 3;
		int rows = 5;

		// �޴� ��ư
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20));
		grid.setHgap(20);
		grid.setVgap(20);
//		grid.setAlignment(Pos.CENTER);

		// ��ǰ ���� ��������
		ArrayList<Product> menulist = ProductDao.getProductDao().buttonlist();

		// ��ư ����
		int num = (int) (columns * rows);
//		Button[] buttons = new Button[num];
		Menubutton[] menubuttons = new Menubutton[num];

		Label label = new Label("Menu");
		label.setFont(Font.font(18));
		grid.add(label, 0, 0);

		for (int i = 0; i < rows; i++) {
			int t = i; // i �� �޾ƿ���
			for (int j = 0; j < columns; j++) {

				menubuttons[i] = new Menubutton();
				// ��ư�� ��ǰ�� ����
				menubuttons[i].p_no = menulist.get(i).getP_no();
				menubuttons[i].p_name = menulist.get(i).getP_name();
				menubuttons[i].p_img = menulist.get(i).getP_img();
				menubuttons[i].p_count = menulist.get(i).getP_count();
				menubuttons[i].p_category = menulist.get(i).getP_category();
				menubuttons[i].p_price = menulist.get(i).getP_price();
				menubuttons[i].p_activation = menulist.get(i).getP_activation();
				menubuttons[i].sale_count = 1;
				
				// �̹���
				File file = new File("src/image/" + menubuttons[i].p_img);
				Image image = new Image(file.toURI().toString());
				
				// ��
				Label menuname = new Label(menubuttons[i].p_name);
				Label menuprice = new Label(menubuttons[i].p_price+"");
				menuname.setFont(Font.font(16));
				menuprice.setFont(Font.font(16));

				// �� 2�� ��ġ��
				String temp = menuname.getText() + "      /      " + menuprice.getText();
				Label label2 = new Label(temp);

				grid.setHalignment(label2, HPos.CENTER);
				
				
				
				menubuttons[i].button.setGraphic(new ImageView(image));
				menubuttons[i].button.setWrapText(true);

				menubuttons[i].button.setOnMouseClicked(e -> {
					// ���� ��ǰ�� �ٽ� �����ҽ� ��ٱ��� ���� ������ ����
					int c = 0;
					for (Product temp2 : products) {
						if (temp2.getP_no( ) == menubuttons[t].p_no) {
							products.get(c).setSale_count( products.get(c).getSale_count() + 1);
							productlist.refresh();
							txtprice.setText(total_payment() + "");
							
							return;
						}
						c++;
					}
					// ��ٱ��Ͽ� �ֱ����� product ������ button ���� ���
					Product pro = new Product(menubuttons[t].p_no, menubuttons[t].p_name, menubuttons[t].p_img,
							menubuttons[t].p_count, menubuttons[t].p_category, menubuttons[t].p_price,
							menubuttons[t].p_activation, menubuttons[t].sale_count);
					// ��ٱ��Ͽ� ���
					products.add(pro);
					producttableload();
					// ���� ���
					txtprice.setText(total_payment() + "");
				});

				grid.add(menubuttons[i].button, j, ((i + 1) * 2 - 1));
				grid.add(label2, j, ((i + 2) * 2 - 2));

			}
		}
		scrollcp.setContent(grid);

	}

	@FXML
	private Button btncountchange;

	@FXML
	private Button btndelete;

	@FXML
	private Button btnorder;

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
	private AnchorPane lp;

	@FXML
	private TableView<Product> productlist;

	@FXML
	private BorderPane productorderpane;

	@FXML
	private ScrollPane scrollcp;

	@FXML
	private AnchorPane tp;

	@FXML
	private TextField txtprice;

	@FXML
	private TextField txtproductcount;

	@FXML
	void countchange(ActionEvent event) {
		System.out.println(product.getP_name());
		// 1.��ٱ��ϸ� �ݺ��� ����
		for (Product temp : products) {
			// 2.��ٱ��� ���� ��ǰ��ȣ�� ���콺 ������ ��ǰ��ȣ���� ������
			if (temp.getP_no() == product.getP_no()) {
				// 3.��ٱ��Ͽ� ���� ��ǰ ������ �Է¹��� ������ ��ȯ
				temp.setSale_count(Integer.parseInt(txtproductcount.getText()));
				txtprice.setText(total_payment() + "");
				productlist.refresh();
			}
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
			for (int i = 0; i < products.size() + 1; i++) {
				if (products.get(i).getP_no() == product.getP_no()) {
					products.remove(i);
					txtprice.setText(total_payment() + "");
					productlist.refresh();
				}
			}
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
	                                    // �ӽ÷� ��ǰ
	         Productorder order = new Productorder("��ǰ", po_count(), p_no, loginid, total_payment(), 1);
	         
	         boolean check =ProductorderDao.getProductDao().productorder(order);
	         if(check) {
	            int po_no = ProductorderDao.getProductDao().find_po_no();
	            for(Product temp : products) {
	               Orderdetail orderdetail = new Orderdetail(po_no, temp.getP_no(), temp.getP_name(), temp.getP_category(), temp.getSale_count(), temp.getP_price()*temp.getSale_count());
	               OrderdetailDao.getOrderdetailDao().orderdetail(orderdetail);
	            }
	            System.out.println(po_no);
	            Alert alert2 = new Alert(AlertType.INFORMATION);
	            alert2.setHeaderText("�ֹ��Ϸ�");
	            alert2.showAndWait();
	            btndelete.getScene().getWindow().hide(); // ����â�� ����
	            LoginController.getinstance().loadpage("c_mainpage"); // �α��� â Ȱ��ȭ
	         }
	         
	      }
	   }

	// ��ٱ��� ����Ʈ
	ObservableList<Product> products = FXCollections.observableArrayList();
	// ���콺 ������ ��ǰ�� ����
	Product product;

	public void producttableload() {
		
		// 1. DB���� ��ǰ��� ��������
		// 2. ��ǰ����� ���̺�信 �־��ֱ�
		productlist.setItems(products);
		// 3. ���̺�信 �� �� �ϳ��� �����ͼ� ����Ʈ�� ��ü�� �ʵ�� ����
		TableColumn tc = productlist.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("p_no"));
		tc = productlist.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("p_name"));
		tc = productlist.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("sale_count"));
		tc = productlist.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("p_price"));

		productlist.setOnMouseClicked(e -> {
			if (e.getButton().equals(MouseButton.PRIMARY)) {
				// product�� ������ ��ǰ ���� ���
				product = productlist.getSelectionModel().getSelectedItem();
				// Ŭ�������� ���� ����
				txtproductcount.setText(product.getSale_count() + "");
			}
		});

	}

	// �� �ֹ��ݾ� ���ϴ� �޼ҵ�
	public int total_payment() {
		int total_payment = 0;
		for (Product temp : products) {
			total_payment += temp.getP_price() * temp.getSale_count();
		}
		return total_payment;
	}

	// ��ǰ �Ѱ���
	public int po_count() {
		int po_count = 0;
		for (Product temp : products) {
			po_count += temp.getSale_count();
		}
		return po_count;
	}

}
