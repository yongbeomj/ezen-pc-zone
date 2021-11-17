package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.geometry.Insets;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ProductorderController implements Initializable {

	private static double columns = 3;
	private static double rows = 10;

//	// 로그인 id 조회
//	String loginid = LoginController.getinstance().getloginid();
//	// m_no 조회
//	int m_no = MemberDao.getMemberDao().mnocheck(loginid);

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		// 로그인 id 조회
//		String loginid = LoginController.getinstance().getloginid();
//		System.out.println("login : " + loginid);
//		// m_no 조회
//		int m_no = MemberDao.getMemberDao().mnocheck(loginid);
//		System.out.println("no : " + m_no);

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

		// 메뉴 버튼
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20));
		grid.setHgap(20);
		grid.setVgap(20);

		// 버튼 생성
		int num = (int) (columns * rows);
		Button[] buttons = new Button[num];

		Label label = new Label("Menu");
		label.setFont(Font.font(18));
		grid.add(label, 0, 0);

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				File file = new File("src/image/1.png");
				Image image = new Image(file.toURI().toString());

				buttons[i] = new Button(); // 메모리 할당
				buttons[i].setGraphic(new ImageView(image));
				buttons[i].setWrapText(true);

				grid.add(buttons[i], j, i + 1);
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
