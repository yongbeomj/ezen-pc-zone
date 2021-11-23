package Controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import Dao.MemberDao;
import Dao.ProductDao;
import Dao.ProductOrderDao;
import Dao.SalesDao;
import Dao.TimeOrderDao;

import Domain.SalesDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SalesController implements Initializable {

	String[] cates = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
	String[] year = { "2017", "2018", "2019", "2020", "2021" };
	String[] month = new String[12];

	private ObservableList<String> xLabels = FXCollections.observableArrayList();
	private ObservableList<String> linexLabels = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		totsales();
		comboyear.getItems().addAll(Arrays.asList(year));

		xLabels.addAll(Arrays.asList(cates));
		barxAxis.setCategories(xLabels);

		lblmember.setText(MemberDao.getMemberDao().membercount() + "");
		lblmember.setAlignment(Pos.CENTER);
		lbldppay.setAlignment(Pos.CENTER);

	}

	// 일간 매출
	@FXML
	void ddp(ActionEvent event) {
		String date = ddp.getValue().toString();
		String[] day = date.split("-", 2);

		ObservableList<PieChart.Data> totalprices = FXCollections.observableArrayList();

		int productprice = ProductOrderDao.getProductOrderDao().productorderdate1(day[1]); // 제품가격
		int timeprice = TimeOrderDao.getTimeOrderDao().timeorderdate1(day[1]); // 시간가격
		int totalprice2 = productprice + timeprice;
		PieChart.Data data = new PieChart.Data("제품 매출액 : " + productprice, productprice);
		PieChart.Data data2 = new PieChart.Data("시간 매출액 : " + timeprice, timeprice);

		totalprices.add(data);
		totalprices.add(data2);

		lbldppay.setText(totalprice2 + "");
		pc.setData(totalprices);
	}

	int[] totprice = new int[12];

	DecimalFormat decimalFormat = new DecimalFormat("###,###"); // 금액 표기 규격
	
	// 연간 월 매출
	   @FXML
	   void cbyear(ActionEvent event) {
	      int sum = 0;
	      XYChart.Series<String, Number> series1 = new XYChart.Series<>();
	      
	      // 내용 삭제
	      barChart.getData().clear();

	      String year = comboyear.getValue();
	      for (int i = 0; i < month.length; i++) {
	         month[i] = year + "-" + cates[i];
	         int productsales = ProductOrderDao.getProductOrderDao().monproductsales(month[i]);
	         int timesales = TimeOrderDao.getTimeOrderDao().montimesales(month[i]);
	         totprice[i] = productsales + timesales;
	         sum += totprice[i];
	         series1.getData().add(new XYChart.Data<String, Number>(xLabels.get(i), totprice[i]));
	      }
	      
	      series1.setName("총 매출 : " + decimalFormat.format(sum) + "원");
	      barChart.setTitle(year + "년 월별 총 매출");
	      barChart.getData().add(series1);
	   }
	   
	   // 전체 매출
	   public void totsales() {
	      int sum1 = 0;
	      XYChart.Series<String, Integer> series2 = new XYChart.Series<>();
	      
	      linexLabels.addAll(Arrays.asList(year));

	      for (int i = 0; i < year.length; i++) {
	         int productsales = ProductOrderDao.getProductOrderDao().totproductsales(year[i]);
	         int timesales = TimeOrderDao.getTimeOrderDao().tottimesales(year[i]);
	         totprice[i] = productsales + timesales;
	         sum1 += totprice[i];
	         series2.getData().add(new XYChart.Data<String, Integer>(linexLabels.get(i), totprice[i]));
	      }
	      System.out.println(sum1);
	      series2.setName("총 매출 : " + decimalFormat.format(sum1) + "원");
	      ylc.setTitle("연도별 매출");
	      ylc.getData().add(series2);
	   }
	   
	@FXML
	private BarChart<String, Number> barChart;

	@FXML
	private CategoryAxis barxAxis;

	@FXML
	private Button btnback;

	@FXML
	private ComboBox<String> comboyear;

	@FXML
	private DatePicker ddp;

	@FXML
	private Label lbldppay;

	@FXML
	private Label lblmember;

	@FXML
	private PieChart pc;

	@FXML
	private LineChart<String, Integer> ylc;

	@FXML
	void back(ActionEvent event) {
		SystemController.getinstance().loadpage("a_system");
	}

}
