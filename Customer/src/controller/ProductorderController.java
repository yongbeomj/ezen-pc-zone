package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ProductorderController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		ImageView[] imageViews = new ImageView[6];
//		int z = 0;
//		for( int i = 0 ; i < 6 ; i++ ) {
//			imageViews[i] = new ImageView("�̹���" + String.format("%02d", i) );      // �޸� �Ҵ� 
//			imageViews[i].setLayoutX( 30 );
//	        productorderpane.getChildren().add(imageViews[i] ); // ��ġ 
//	        z++;
//		}
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

    }

    @FXML
    void order(ActionEvent event) {

    }

    @FXML
    void productcount(ActionEvent event) {

    }
    
}
