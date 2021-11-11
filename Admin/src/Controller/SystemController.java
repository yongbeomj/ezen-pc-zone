package Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class SystemController {


    @FXML
    private Button btnmember;

    @FXML
    private Button btnproduct;

    @FXML
    private Button btnsales;

    @FXML
    private BorderPane mainpane;

	@FXML
	void member(ActionEvent event) {
		loadpage("a_member");
	}

	@FXML
	void product(ActionEvent event) {
		loadpage("a_productlist");
	}

	@FXML
	void sales(ActionEvent event) {
		loadpage("a_sales");
	}

	public static SystemController instance;

	// 생성자
	public SystemController() {
		instance = this;
	}		

	// 객체 반환
	public static SystemController getinstance() {
		return instance;
	}

	public void loadpage(String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/fxml/" + page + ".fxml"));
			mainpane.setCenter(parent);
		} catch (Exception e) {
		}

	}

}
