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
			// 1. ���� ���� Ŭ����
			FileChooser fileChooser = new FileChooser(); // ���� ���ý� ��� ����
			// 2. ���� �������� ���� getExtensionFilters : ������ ���� ����
			fileChooser.getExtensionFilters().add(new ExtensionFilter("�׸����� : Image File", "*png", "*jpg", "*gif"));
			// 3. ���������� ���ϼ���Ŭ���� �ֱ�
			File file = fileChooser.showOpenDialog(stage); // �������� ����
			// * ������ ������ ��θ� ����Ŭ������ ����
			lblimgpath.setText("���� ��� : " + file.getPath()); 
			pimage = file.toURI().toString(); // ������ ����[real] ���
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
		
				
			
			// ��üȭ
			Product product2 = new Product(
					product.getP_no(), 
					pname, 
					pimage, 
					pcount, 
					pcategory, 
					pprice,
					0, 
					"0");
			
			// DB �ֱ�
			boolean result = ProductDao.getProductDao().update(product2);
			if(result) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("��ǰ ���� �Ϸ�");
				alert.showAndWait();
				SystemController.getinstance().loadpage("a_productlist");
		
			}
			
		}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
