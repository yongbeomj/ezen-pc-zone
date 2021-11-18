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
	String loginid = LoginController.getinstance().getloginid(); // 로그인 id 조회
	int m_no = MemberDao.getMemberDao().mnocheck(loginid); // m_no 조회
	int p_no = PcDao.getPcDao().pcnocheck(m_no); // p_no 조회

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 테이블 로드
		producttableload();
		
		// 베스트 메뉴 버튼
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

		// 재고있는 제품 수
//		int actcnt = ProductDao.getProductDao().actproductcount();
		int columns = 3;
		int rows = 5;

		// 메뉴 버튼
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20));
		grid.setHgap(20);
		grid.setVgap(20);
//		grid.setAlignment(Pos.CENTER);

		// 제품 내역 가져오기
		ArrayList<Product> menulist = ProductDao.getProductDao().buttonlist();

		// 버튼 생성
		int num = (int) (columns * rows);
//		Button[] buttons = new Button[num];
		Menubutton[] menubuttons = new Menubutton[num];

		Label label = new Label("Menu");
		label.setFont(Font.font(18));
		grid.add(label, 0, 0);

		for (int i = 0; i < rows; i++) {
			int t = i; // i 값 받아오기
			for (int j = 0; j < columns; j++) {

				menubuttons[i] = new Menubutton();
				// 버튼에 제품값 설정
				menubuttons[i].p_no = menulist.get(i).getP_no();
				menubuttons[i].p_name = menulist.get(i).getP_name();
				menubuttons[i].p_img = menulist.get(i).getP_img();
				menubuttons[i].p_count = menulist.get(i).getP_count();
				menubuttons[i].p_category = menulist.get(i).getP_category();
				menubuttons[i].p_price = menulist.get(i).getP_price();
				menubuttons[i].p_activation = menulist.get(i).getP_activation();
				menubuttons[i].sale_count = 1;
				
				// 이미지
				File file = new File("src/image/" + menubuttons[i].p_img);
				Image image = new Image(file.toURI().toString());
				
				// 라벨
				Label menuname = new Label(menubuttons[i].p_name);
				Label menuprice = new Label(menubuttons[i].p_price+"");
				menuname.setFont(Font.font(16));
				menuprice.setFont(Font.font(16));

				// 라벨 2개 합치기
				String temp = menuname.getText() + "      /      " + menuprice.getText();
				Label label2 = new Label(temp);

				grid.setHalignment(label2, HPos.CENTER);
				
				
				
				menubuttons[i].button.setGraphic(new ImageView(image));
				menubuttons[i].button.setWrapText(true);

				menubuttons[i].button.setOnMouseClicked(e -> {
					// 같은 제품을 다시 선택할시 장바구니 개수 오르고 리턴
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
					// 장바구니에 넣기위해 product 변수에 button 정보 담기
					Product pro = new Product(menubuttons[t].p_no, menubuttons[t].p_name, menubuttons[t].p_img,
							menubuttons[t].p_count, menubuttons[t].p_category, menubuttons[t].p_price,
							menubuttons[t].p_activation, menubuttons[t].sale_count);
					// 장바구니에 담기
					products.add(pro);
					producttableload();
					// 총합 계산
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
		// 1.장바구니를 반복문 돌려
		for (Product temp : products) {
			// 2.장바구니 안의 제품번호와 마우스 선택한 제품번호값이 같으면
			if (temp.getP_no() == product.getP_no()) {
				// 3.장바구니에 기존 제품 수량을 입력받은 값으로 변환
				temp.setSale_count(Integer.parseInt(txtproductcount.getText()));
				txtprice.setText(total_payment() + "");
				productlist.refresh();
			}
		}
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
	      alert.setContentText(" 주문하기 ");
	      alert.setHeaderText(" 주문하시겠니까? ");
	      alert.setTitle(" 주문하기 ");
	      // 알림창이 떴을 때 옵션(확인, 취소)에 따라 기능 다름
	      Optional<ButtonType> optional = alert.showAndWait();
	      if (optional.get() == ButtonType.OK) { // 확인을 누르면
	                                    // 임시로 식품
	         Productorder order = new Productorder("식품", po_count(), p_no, loginid, total_payment(), 1);
	         
	         boolean check =ProductorderDao.getProductDao().productorder(order);
	         if(check) {
	            int po_no = ProductorderDao.getProductDao().find_po_no();
	            for(Product temp : products) {
	               Orderdetail orderdetail = new Orderdetail(po_no, temp.getP_no(), temp.getP_name(), temp.getP_category(), temp.getSale_count(), temp.getP_price()*temp.getSale_count());
	               OrderdetailDao.getOrderdetailDao().orderdetail(orderdetail);
	            }
	            System.out.println(po_no);
	            Alert alert2 = new Alert(AlertType.INFORMATION);
	            alert2.setHeaderText("주문완료");
	            alert2.showAndWait();
	            btndelete.getScene().getWindow().hide(); // 메인창을 끄고
	            LoginController.getinstance().loadpage("c_mainpage"); // 로그인 창 활성화
	         }
	         
	      }
	   }

	// 장바구니 리스트
	ObservableList<Product> products = FXCollections.observableArrayList();
	// 마우스 선택한 제품값 정보
	Product product;

	public void producttableload() {
		
		// 1. DB에서 제품목록 가져오기
		// 2. 제품목록을 테이블뷰에 넣어주기
		productlist.setItems(products);
		// 3. 테이블뷰에 열 를 하나씩 가져와서 리스트내 객체에 필드와 연결
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
				// product에 선택한 제품 정보 담기
				product = productlist.getSelectionModel().getSelectedItem();
				// 클릭했을때 수량 세팅
				txtproductcount.setText(product.getSale_count() + "");
			}
		});

	}

	// 총 주문금액 구하는 메소드
	public int total_payment() {
		int total_payment = 0;
		for (Product temp : products) {
			total_payment += temp.getP_price() * temp.getSale_count();
		}
		return total_payment;
	}

	// 상품 총개수
	public int po_count() {
		int po_count = 0;
		for (Product temp : products) {
			po_count += temp.getSale_count();
		}
		return po_count;
	}

}
