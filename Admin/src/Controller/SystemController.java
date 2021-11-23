package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Dao.MemberDao;
import Dao.PcDao;
import Dao.ProductDao;
import Dao.SystemDao;
import Dao.TimeDao;
import Domain.Pc;
import Domain.Product;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SystemController implements Initializable {
	static int pc_no = 0;

	// 추가
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Button[] pcbuttons = { null, btnpc_1, btnpc_2, btnpc_3, btnpc_4, btnpc_5, btnpc_6, btnpc_7, btnpc_8, btnpc_9,
				btnpc_10, btnpc_11, btnpc_12, btnpc_13, btnpc_14, btnpc_15, btnpc_16, btnpc_17, btnpc_18, btnpc_19,
				btnpc_20 };

		Label[] pcids = { null, lblid_1, lblid_2, lblid_3, lblid_4, lblid_5, lblid_6, lblid_7, lblid_8, lblid_9,
				lblid_10, lblid_11, lblid_12, lblid_13, lblid_14, lblid_15, lblid_16, lblid_17, lblid_18, lblid_19,
				lblid_20 };

		Label[] lbltimes = { null, lbltimeremaining_1, lbltimeremaining_2, lbltimeremaining_3, lbltimeremaining_4,
				lbltimeremaining_5, lbltimeremaining_6, lbltimeremaining_7, lbltimeremaining_8, lbltimeremaining_9,
				lbltimeremaining_10, lbltimeremaining_11, lbltimeremaining_12, lbltimeremaining_13, lbltimeremaining_14,
				lbltimeremaining_15, lbltimeremaining_16, lbltimeremaining_17, lbltimeremaining_18, lbltimeremaining_19,
				lbltimeremaining_20 };
	
		Thread thread = new Thread(new Runnable() {
            
			@Override
	            public void run() {
	                Runnable updater = new Runnable() {

	                    @Override
	                    public void run() {
	                       
	                    	ArrayList<Pc> pcactlist = PcDao.getPcDao().pcactivation_List();
	        				
	                    	for(Pc temp : pcactlist) {						
	        						if(temp.getP_activation()==1) {
	        							pcbuttons[temp.getP_no()].setStyle("-fx-background-color: #99ffcc; ");	
	        							pcids[temp.getP_no()].setText("");
	        							lbltimes[temp.getP_no()].setText("사용가능");
	        							
	        						}
	        						if(temp.getP_activation()==2) {
	        							//색 변경
	        							pcbuttons[temp.getP_no()].setStyle("-fx-background-color: #FF3333; ");
	        							lbltimes[temp.getP_no()].setText("사용불가");
	        							pcids[temp.getP_no()].setText("");
		        						if(temp.getM_no()!=0) {
		        							//id 변경
			        						pcids[temp.getP_no()].setText(MemberDao.getMemberDao().find_m_id(temp.getM_no()));
			        						//시간 변경
			        						int time = TimeDao.gettimDao().time_remaintime(temp.getM_no());
			        						int hour = time/(60*60);
			        					    int minute = time/60-(hour*60);
			        					    int second = time%60;
			        						lbltimes[temp.getP_no()].setText("남은시간 "+hour+":"+String.format("%02d", minute)+":"+String.format("%02d", second));
		        						}
	        							
		        						
	        						}
	                    						

	        				}
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

	}

	// 객체화
	public static SystemController instance;

	public SystemController() {
		instance = this;
	}

	public static SystemController getinstance() {
		return instance;
	}

	// 로드페이지
	public void loadpage(String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/fxml/" + page + ".fxml"));
			mainpane.setCenter(parent);
		} catch (Exception e) {
		}

	}
	

   

    @FXML
    void repair(ActionEvent event) {
    	btnrepair.setText(pc_no+""); // 선택된 제품의 상태가 버튼 텍스트에 표시
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("알림");
		alert.setContentText("상태변경");
		alert.setHeaderText("상태를 변경하시겠습니까?");
		alert.showAndWait();

		int pa = PcDao.getPcDao().pcrepair(pc_no);
		
		int ch = pa + 1; 
		if (ch > 2) {
			ch = 1;
		}
		
		if (ch == 1) { 
			SystemDao.getSystemDao().repairupdate(1, pc_no); 
			System.out.println( pc_no );
			btnrepair.setText("사용불가"); 
		}
		
		if (ch == 2) { 
			SystemDao.getSystemDao().repairupdate(2, pc_no); 
			
			btnrepair.setText("사용가능"); 

		}
    }
    
    
   
    
    

    @FXML
    private Label lblpc_ch;
    
    @FXML
	private Button btnrepair;
    

	@FXML
	private Button btnchatting;

	@FXML
	private Button btnmember;

	@FXML
	private Button btnpc_1;

	@FXML
	private Button btnpc_10;

	@FXML
	private Button btnpc_11;

	@FXML
	private Button btnpc_12;

	@FXML
	private Button btnpc_13;

	@FXML
	private Button btnpc_14;

	@FXML
	private Button btnpc_15;

	@FXML
	private Button btnpc_16;

	@FXML
	private Button btnpc_17;

	@FXML
	private Button btnpc_18;

	@FXML
	private Button btnpc_19;

	@FXML
	private Button btnpc_2;

	@FXML
	private Button btnpc_20;

	@FXML
	private Button btnpc_3;

	@FXML
	private Button btnpc_4;

	@FXML
	private Button btnpc_5;

	@FXML
	private Button btnpc_6;

	@FXML
	private Button btnpc_7;

	@FXML
	private Button btnpc_8;

	@FXML
	private Button btnpc_9;

	@FXML
	private Button btnproduct;

	@FXML
	private Button btnsales;

	@FXML
	private Label lblid_1;

	@FXML
	private Label lblid_10;

	@FXML
	private Label lblid_11;

	@FXML
	private Label lblid_12;

	@FXML
	private Label lblid_13;

	@FXML
	private Label lblid_14;

	@FXML
	private Label lblid_15;

	@FXML
	private Label lblid_16;

	@FXML
	private Label lblid_17;

	@FXML
	private Label lblid_18;

	@FXML
	private Label lblid_19;

	@FXML
	private Label lblid_2;

	@FXML
	private Label lblid_20;

	@FXML
	private Label lblid_3;

	@FXML
	private Label lblid_4;

	@FXML
	private Label lblid_5;

	@FXML
	private Label lblid_6;

	@FXML
	private Label lblid_7;

	@FXML
	private Label lblid_8;

	@FXML
	private Label lblid_9;

	@FXML
	private Label lbltimeremaining_1;

	@FXML
	private Label lbltimeremaining_10;

	@FXML
	private Label lbltimeremaining_11;

	@FXML
	private Label lbltimeremaining_12;

	@FXML
	private Label lbltimeremaining_13;

	@FXML
	private Label lbltimeremaining_14;

	@FXML
	private Label lbltimeremaining_15;

	@FXML
	private Label lbltimeremaining_16;

	@FXML
	private Label lbltimeremaining_17;

	@FXML
	private Label lbltimeremaining_18;

	@FXML
	private Label lbltimeremaining_19;

	@FXML
	private Label lbltimeremaining_2;

	@FXML
	private Label lbltimeremaining_20;

	@FXML
	private Label lbltimeremaining_3;

	@FXML
	private Label lbltimeremaining_4;

	@FXML
	private Label lbltimeremaining_5;

	@FXML
	private Label lbltimeremaining_6;

	@FXML
	private Label lbltimeremaining_7;

	@FXML
	private Label lbltimeremaining_8;

	@FXML
	private Label lbltimeremaining_9;

	@FXML
	private BorderPane mainpane;

	@FXML
	void chatting(ActionEvent event) {
		if (pc_no != 0) {
			Stage stage = new Stage();
			try {
				Parent parent = FXMLLoader.load(getClass().getResource("/fxml/c_chatting.fxml"));

				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
			} catch (Exception e) {
			}
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("pc를 선택해주세요");
			alert.showAndWait();
		}

	}

	@FXML
	void member(ActionEvent event) {
		loadpage("a_member");
	}

	@FXML
	void pc_1(ActionEvent event) {
		
		pc_no = 1;
		lblpc_ch.setText("선택된 pc : "+pc_no);
		
	}

	@FXML
	void pc_10(ActionEvent event) {
		
		pc_no = 10;
		lblpc_ch.setText("선택된 pc : "+pc_no);
	}

	@FXML
	void pc_11(ActionEvent event) {
		
		pc_no = 11;
		lblpc_ch.setText("선택된 pc : "+pc_no);
	}

	@FXML
	void pc_12(ActionEvent event) {
		
		pc_no = 12;
		lblpc_ch.setText("선택된 pc : "+pc_no);
	}

	@FXML
	void pc_13(ActionEvent event) {
		pc_no = 13;
		lblpc_ch.setText("선택된 pc : "+pc_no);
	}

	@FXML
	void pc_14(ActionEvent event) {
		pc_no = 14;
		lblpc_ch.setText("선택된 pc : "+pc_no);
	}

	@FXML
	void pc_15(ActionEvent event) {
		pc_no = 15;
		lblpc_ch.setText("선택된 pc : "+pc_no);
	}

	@FXML
	void pc_16(ActionEvent event) {
		pc_no = 16;
		lblpc_ch.setText("선택된 pc : "+pc_no);
	}

	@FXML
	void pc_17(ActionEvent event) {
		pc_no = 16;
		lblpc_ch.setText("선택된 pc : "+pc_no);
	}

	@FXML
	void pc_18(ActionEvent event) {
		pc_no = 18;
		lblpc_ch.setText("선택된 pc : "+pc_no);
	}

	@FXML
	void pc_19(ActionEvent event) {
		pc_no = 19;
		lblpc_ch.setText("선택된 pc : "+pc_no);
	}

	@FXML
	void pc_2(ActionEvent event) {
		pc_no = 2;
		lblpc_ch.setText("선택된 pc : "+pc_no);
	}

	@FXML
	void pc_20(ActionEvent event) {
		pc_no = 20;
		lblpc_ch.setText("선택된 pc : "+pc_no);
	}

	@FXML
	void pc_3(ActionEvent event) {
		pc_no = 3;
		lblpc_ch.setText("선택된 pc : "+pc_no);
	}

	@FXML
	void pc_4(ActionEvent event) {
		pc_no = 4;
		lblpc_ch.setText("선택된 pc : "+pc_no);
	}

	@FXML
	void pc_5(ActionEvent event) {
		pc_no = 5;
		lblpc_ch.setText("선택된 pc : "+pc_no);
	}

	@FXML
	void pc_6(ActionEvent event) {
		pc_no = 6;
		lblpc_ch.setText("선택된 pc : "+pc_no);
	}

	@FXML
	void pc_7(ActionEvent event) {
		pc_no = 7;
		lblpc_ch.setText("선택된 pc : "+pc_no);
	}

	@FXML
	void pc_8(ActionEvent event) {
		pc_no = 8;
		lblpc_ch.setText("선택된 pc : "+pc_no);
	}

	@FXML
	void pc_9(ActionEvent event) {
		pc_no = 9;
		lblpc_ch.setText("선택된 pc : "+pc_no);
	}

	@FXML
	void product(ActionEvent event) {
		loadpage("a_productlist");
	}

	@FXML
	void sales(ActionEvent event) {
		loadpage("a_sales");
	}

}
