package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import Dao.MemberDao;
import Dao.PcDao;
import Dao.ProductDao;
import Dao.ProductOrderDao;
import Dao.TimeDao;
import Domain.Pc;
import Domain.Product;
import Domain.ProductOrder;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

public class ProductListController implements Initializable{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
		Thread thread = new Thread(new Runnable() {
            
			@Override
	            public void run() {
	                Runnable updater = new Runnable() {

	                    @Override
	                    public void run() {
	                    	producttableload(0);
	                		productordertableload();
	                    	productlist.refresh();
	                    	productorderlist.refresh();
	                    	
	                    }
	                };

	                while (true) {
	                    try {
	                        Thread.sleep(1000);
	                    } catch (InterruptedException ex) {
	                    }
	                    // UI update is run on the Application thread
	                    Platform.runLater(updater);
	                }
	            }
	        });
	     thread.start();
		
//		while(true) {
//			productlist.refresh();
//        	productorderlist.refresh();
//		}

	}
	
	@FXML
    private Button btnactivation;
	

    @FXML
    private Button btnback;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnregister;

    @FXML
    private Button btnupdate;

    @FXML
    private Label lblpcategory;

    @FXML
    private Label lblpcount;

    @FXML
    private Label lblpdate;

    @FXML
    private Label lblpname;

    @FXML
    private Label lblpprice;

    @FXML
    private TableView<ProductOrder> productorderlist;

    @FXML
    private ImageView pimg;

    @FXML
    private TableView<Product> productlist;

    @FXML
    private Button btnsearch;
    
    @FXML
    private TextField txtsearch;

    @FXML
    void search(ActionEvent event) {
    	producttableload(1);
    }
    
    
    
    public static Product product;
    
	@FXML
	void activation(ActionEvent event) {

		btnactivation.setText(product.getActivation()); // 선택된 제품의 상태가 버튼 텍스트에 표시
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("알림");
		alert.setContentText("상태변경");
		alert.setHeaderText("상태를 변경하시겠습니까?");
		alert.showAndWait();

		int pa = product.getP_activation();
		
		int ch = pa + 1; 
		if (ch > 2) {
			ch = 1;
		}
		
		if (ch == 1) { 
			ProductDao.getProductDao().activationupdate(1, product.getP_no()); 
			producttableload(0); 
			btnactivation.setText("판매중"); 
		}
		
		if (ch == 2) { 
			ProductDao.getProductDao().activationupdate(2, product.getP_no()); 
			producttableload(0);
			btnactivation.setText("품절"); 

		}
	}
	
	@FXML
	void delete(ActionEvent event) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("제품을 삭제하시겠습니까?");
		Optional<ButtonType> optional = alert.showAndWait();
		if (optional.get() == ButtonType.OK) {
			ProductDao.getProductDao().delete(product.getP_no());
			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setHeaderText("삭제되었습니다.");
			alert2.showAndWait();
			SystemController.getinstance().loadpage("a_productlist");
		}
		
	
	}
	
	
	
	public void producttableload(int type) {
		ObservableList<Product> products = ProductDao.getProductDao().productlist(0,null);
		if(type==0) {
			productlist.setItems(products);
			TableColumn tc = productlist.getColumns().get(0);
			tc.setCellValueFactory(new PropertyValueFactory<>("p_no"));
			tc = productlist.getColumns().get(1);
			tc.setCellValueFactory(new PropertyValueFactory<>("p_name"));
			tc = productlist.getColumns().get(2);
			tc.setCellValueFactory(new PropertyValueFactory<>("p_count"));
			tc = productlist.getColumns().get(3);
			tc.setCellValueFactory(new PropertyValueFactory<>("p_category"));
			tc = productlist.getColumns().get(4);
			tc.setCellValueFactory(new PropertyValueFactory<>("p_price"));
			tc = productlist.getColumns().get(5);
			tc.setCellValueFactory(new PropertyValueFactory<>("activation"));
			tc = productlist.getColumns().get(6);
			tc.setCellValueFactory(new PropertyValueFactory<>("p_date"));

			productlist.setOnMouseClicked(e -> {
				// 2. 클릭 이벤트가 마우스 클릭과 같으면
				if (e.getButton().equals(MouseButton.PRIMARY)) {
					// 3. 테이블 뷰에서 클릭한 모델의 아이템[객체]
					product = productlist.getSelectionModel().getSelectedItem();
					// 4. 선택된 객체내 이미지 경로 가져오기
					Image image = new Image(product.getP_img());
					pimg.setImage(image);
					// 5. 그 외
					lblpname.setText("제품명 : " +product.getP_name());
					lblpcount.setText("제품재고 : " + String.format("%,d",product.getP_count()));
					lblpcategory.setText("제품분류 : " +product.getP_category());
					lblpdate.setText("등록일 : " + product.getP_date().split(" ")[0]);
					lblpprice.setText("제품가격 : " + String.format("%,d", product.getP_price()));
					
					btnactivation.setText(product.getActivation());
				}
			});
		} else if(type==1) {
			if(txtsearch.getText().equals("")) {
				products = ProductDao.getProductDao().productlist(0,null);
			} else {
				products = ProductDao.getProductDao().productlist(1,txtsearch.getText());
			}

			productlist.setItems(products);
			TableColumn tc = productlist.getColumns().get(0);
			tc.setCellValueFactory(new PropertyValueFactory<>("p_no"));
			tc = productlist.getColumns().get(1);
			tc.setCellValueFactory(new PropertyValueFactory<>("p_name"));
			tc = productlist.getColumns().get(2);
			tc.setCellValueFactory(new PropertyValueFactory<>("p_count"));
			tc = productlist.getColumns().get(3);
			tc.setCellValueFactory(new PropertyValueFactory<>("p_category"));
			tc = productlist.getColumns().get(4);
			tc.setCellValueFactory(new PropertyValueFactory<>("p_price"));
			tc = productlist.getColumns().get(5);
			tc.setCellValueFactory(new PropertyValueFactory<>("activation"));
			tc = productlist.getColumns().get(6);
			tc.setCellValueFactory(new PropertyValueFactory<>("p_date"));
	
			productlist.setOnMouseClicked(e -> {
				// 2. 클릭 이벤트가 마우스 클릭과 같으면
				if (e.getButton().equals(MouseButton.PRIMARY)) {
					// 3. 테이블 뷰에서 클릭한 모델의 아이템[객체]
					product = productlist.getSelectionModel().getSelectedItem();
					// 4. 선택된 객체내 이미지 경로 가져오기
					Image image = new Image(product.getP_img());
					pimg.setImage(image);
					// 5. 그 외
					lblpname.setText("제품명 : " +product.getP_name());
					lblpcount.setText("제품재고 : " + String.format("%,d",product.getP_count()));
					lblpcategory.setText("제품분류 : " +product.getP_category());
					lblpdate.setText("등록일 : " + product.getP_date().split(" ")[0]);
					lblpprice.setText("제품가격 : " + String.format("%,d", product.getP_price()));
					
					btnactivation.setText(product.getActivation());
				}
			});
		}
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public static ProductOrder productorder;
	
	public void productordertableload() {
		// 1. DB에서 제품목록 가져오기
		ObservableList<ProductOrder> productorders = ProductOrderDao.getProductOrderDao().productorderlist();
		// 2. 제품목록을 테이블 뷰에 넣어주기
		
		productorderlist.setItems(productorders);
		// 3. 테이블 뷰에 열을 하나씩 가져와서 리스트내 객체에 필드와 연결
		TableColumn tc = productorderlist.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("po_no"));
		tc = productorderlist.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("po_date"));
		tc = productorderlist.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("po_contents"));
		tc = productorderlist.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("po_count"));
		tc = productorderlist.getColumns().get(4);
		tc.setCellValueFactory(new PropertyValueFactory<>("pc_no"));
		tc = productorderlist.getColumns().get(5);
		tc.setCellValueFactory(new PropertyValueFactory<>("m_id"));
		tc = productorderlist.getColumns().get(6);
		tc.setCellValueFactory(new PropertyValueFactory<>("po_price"));
		tc = productorderlist.getColumns().get(7);
		tc.setCellValueFactory(new PropertyValueFactory<>("activation1"));
		
		productorderlist.setOnMouseClicked(e -> {
			// 2. 클릭 이벤트가 마우스 클릭과 같으면
			if (e.getButton().equals(MouseButton.PRIMARY)) {
				// 3. 테이블 뷰에서 클릭한 모델의 아이템[객체]
				productorder = productorderlist.getSelectionModel().getSelectedItem();
			
			
				btnactivation1.setText(productorder.getActivation1());
			}
		});
		
		
	}	
	
	@FXML
    private Button btnactivation1;
	
	
	@FXML
	void activation1(ActionEvent event) {

		btnactivation1.setText(productorder.getActivation1());
		System.out.println( productorder.getActivation1() );
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("알림");
		alert.setContentText("주문처리");
		alert.setHeaderText("상태를 변경하시겠습니까?");
		alert.showAndWait();

		int poa = productorder.getPo_activation();
		
		int ch1 = poa + 1; 
		if (ch1 > 2) {
			ch1 = 1;
		}
		
		if (ch1 == 1) { 
			ProductOrderDao.getProductOrderDao().activationupdate1(1, productorder.getPo_no()); 
			productordertableload(); 
			btnactivation1.setText("주문처리중"); 
		}
		
		if (ch1 == 2) { 
			ProductOrderDao.getProductOrderDao().activationupdate1(2, productorder.getPo_no()); 
			productordertableload();
			btnactivation1.setText("주문처리완료"); 

		}
	}
	
	
    @FXML
    private Button btnorderdetail;	
    
    @FXML
    void orderdetail(ActionEvent event) {
    
    	Stage stage = new Stage();
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/fxml/a_productorderdetail.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} catch (Exception e) {
		}
    	
    }

	

	@FXML
	void back(ActionEvent event) {
		SystemController.getinstance().loadpage("a_system");
	}

	

	@FXML
	void register(ActionEvent event) {
		SystemController.getinstance().loadpage("a_productregister");
	}

	@FXML
	void update(ActionEvent event) {
		SystemController.getinstance().loadpage("a_productupdate");
	}

}
