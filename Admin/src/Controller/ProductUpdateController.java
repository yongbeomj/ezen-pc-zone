package Controller;

import java.io.File;
import java.net.URL;
import java.util.Locale.Category;
import java.util.ResourceBundle;

import Dao.ProductDao;
import Domain.Product;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class ProductUpdateController implements Initializable{
	Product product = ProductListController.product;
  

    @FXML
    private Button btnimgadd;

    @FXML
    private Button btnupdate;

    @FXML
    private ToggleGroup category;

    @FXML
    private Label lblimgpath;

    @FXML
    private RadioButton otp1;

    @FXML
    private RadioButton otp2;

    @FXML
    private RadioButton otp3;

    @FXML
    private RadioButton otp4;

    @FXML
    private RadioButton otp5;

    @FXML
    private RadioButton otp6;

    @FXML
    private ImageView pimg;

    @FXML
    private TextField txtpcount;

    @FXML
    private TextField txtpname;

    @FXML
    private TextField txtpprice;

  

    
    private Stage stage;
	private String pimage; 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txtpname.setText(product.getP_name());
		txtpcount.setText(Integer.toString(product.getP_count()));
		txtpprice.setText(product.getP_price()+"");	
		Image image = new Image(product.getP_img());		
		pimg.setImage(image);								
		lblimgpath.setText(product.getP_img());				
		pimage = product.getP_img();
	}
	
	 @FXML
	    private Button btnback;

	    @FXML
	    void back(ActionEvent event) {
	    	SystemController.getinstance().loadpage("a_productlist");
	    }

	    @FXML
		void imgadd(ActionEvent event) {
			// 1. 파일 선택 클래스
			FileChooser fileChooser = new FileChooser(); // 파일 선택시 경로 저장
			// 2. 파일 스테이지 설정 getExtensionFilters : 선택할 파일 필터
			fileChooser.getExtensionFilters().add(new ExtensionFilter("그림파일 : Image File", "*png", "*jpg", "*gif"));
			// 3. 스테이지에 파일선택클래스 넣기
			File file = fileChooser.showOpenDialog(stage); // 스테이지 열기
			// * 선택한 파일의 경로를 파일클래스에 저장
			lblimgpath.setText("파일 경로 : " + file.getPath()); 
			pimage = file.toURI().toString(); // 파일의 실제[real] 경로
			Image image = new Image(pimage);
			pimg.setImage(image);
		} 
	    
	    
	    @FXML
		void update(ActionEvent event) {
			String pname = txtpname.getText();
			int pcount = (Integer.parseInt(txtpcount.getText()));
			int pprice = Integer.parseInt(txtpprice.getText());
			
			String pcategory = "";
			if(otp1.isSelected()) {pcategory = "Drink";};
			if(otp2.isSelected()) {pcategory = "Snack";};
			if(otp3.isSelected()) {pcategory = "Noodle";};
			if(otp4.isSelected()) {pcategory = "Rice";};
			if(otp5.isSelected()) {pcategory = "Food";};
			if(otp6.isSelected()) {pcategory = "Acc";};
			if(pcategory.equals("")) {
				pcategory = product.getP_category();
			}
		
				
			
			// 객체화
			Product product2 = new Product(
					product.getP_no(), 
					pname, 
					pimage, 
					pcount, 
					pcategory, 
					pprice,
					0, 
					"0");
			
			// DB 넣기
			boolean result = ProductDao.getProductDao().update(product2);
			if(result) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("제품 수정 완료");
				alert.showAndWait();
				SystemController.getinstance().loadpage("a_productlist");
		
			}
			
		}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
