package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.MemberDao;
import dao.PcDao;
import dao.TimeDao;
import dao.TimeorderDao;
import domain.Pc;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class MainController implements Initializable {
	
	

	@Override
	public  void initialize(URL arg0, ResourceBundle arg1) {
		Button[] pcbuttons = {  null, btnpc_1 ,btnpc_2 ,btnpc_3 ,btnpc_4 ,btnpc_5 ,btnpc_6 ,btnpc_7 ,btnpc_8 ,btnpc_9 ,btnpc_10 
				,btnpc_11  ,btnpc_12  ,btnpc_13,btnpc_14,btnpc_15,btnpc_16,btnpc_17,btnpc_18,btnpc_19,btnpc_20};
		
		Label[] pcids = { null,lblid_1,lblid_2,lblid_3,lblid_4,lblid_5,lblid_6,lblid_7,lblid_8,lblid_9,lblid_10
				,lblid_11,lblid_12,lblid_13,lblid_14,lblid_15,lblid_16,lblid_17,lblid_18,lblid_19,lblid_20};
		
		Label[] lbltimes = { null,lbltimeremaining_1,lbltimeremaining_2,lbltimeremaining_3,lbltimeremaining_4,lbltimeremaining_5,lbltimeremaining_6,lbltimeremaining_7
				,lbltimeremaining_8,lbltimeremaining_9,lbltimeremaining_10,lbltimeremaining_11,lbltimeremaining_12,lbltimeremaining_13,lbltimeremaining_14,lbltimeremaining_15
				,lbltimeremaining_16,lbltimeremaining_17,lbltimeremaining_18,lbltimeremaining_19,lbltimeremaining_20};
		
		int pccheck = PcDao.getPcDao().pcnocheck(m_no);
		if(pccheck!=0) {
			lblseat_ch.setText(pccheck+"�� pc ����");
			btnpayment.setText("��� �߰�");
			for(int i = 0; i<pcbuttons.length; i++) {
				if(pcbuttons[i]!=null) {
				pcbuttons[i].setDisable(true);
			
			}
			}
		}
		
		//�ǽð� db �ҷ����� 
		Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                      
                    	
                    	ArrayList<Pc> pcactlist = PcDao.getPcDao().pcactivation_List();
                    	for(Pc temp : pcactlist) {
                    		
    						if(temp.getP_activation()==1) {
    							pcbuttons[temp.getP_no()].setStyle("-fx-background-color: #66b2ff; ");	
    							pcids[temp.getP_no()].setText("");
    							lbltimes[temp.getP_no()].setText("��밡��");
    							
    						}
    						if(temp.getP_activation()==2) {
    							//�� ����
    							pcbuttons[temp.getP_no()].setStyle("-fx-background-color: #FF3333; ");
    							lbltimes[temp.getP_no()].setText("���Ұ�");
    							pcids[temp.getP_no()].setText("");
        						if(temp.getM_no()!=0) {
        							//id ����
	        						pcids[temp.getP_no()].setText(MemberDao.getMemberDao().find_m_id(temp.getM_no()));
	        						//�ð� ����
	        						int time = TimeDao.gettimDao().time_remaintime(temp.getM_no());
	        						int hour = time/(60*60);
	        					    int minute = time/60-(hour*60);
	        					    int second = time%60;
	        						lbltimes[temp.getP_no()].setText("�����ð� "+hour+":"+String.format("%02d", minute)+":"+String.format("%02d", second));
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
	public static void pcset() {
	
	}
	int pc_no = 0;
	int price = 0;
	int time = 0;
    @FXML
    private Button btncancel;
    @FXML
    private Button btnpayment;
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
    private Button btnprice_1000;
    @FXML
    private Button btnprice_2000;
    @FXML
    private Button btnprice_3000;
    @FXML
    private Button btnprice_5000;
    @FXML
    private Label lblprice_ch;
    @FXML
    private Label lblseat_ch;
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
    void cancel(ActionEvent event) {
    	LoginController.getinstance().loadpage("k_login");
    }
    int m_no = LoginController.getinstance().m_no;
    @FXML
    void payment(ActionEvent event) {
    	int t_remaintime = TimeDao.gettimDao().time_remaintime( m_no);
    	//
    	if(PcDao.getPcDao().pc_act_check(pc_no)) {
    		Alert alert =new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("�ٸ� �ڸ��� �������ּ���");
    		alert.showAndWait();
    		return;
    	}
    	//�ð� ���� ��������
    	if(time == 0 && t_remaintime==0) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("�ð��� �������ּ���");
    		alert.showAndWait();
    		return;
    	}
    	//pc������� �մ��� ����� �߰��Ҷ�
    	int pccheck = PcDao.getPcDao().pcnocheck( m_no);
    	if(pccheck!=0) {
    		TimeDao.gettimDao().timeupdate( m_no, time ,t_remaintime);
    		//�ð� �ֹ� ����
    		TimeorderDao.getTimeorderDao().timeorder(price,  m_no);
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("���� �Ǿ����ϴ�");
    		alert.showAndWait();
    		LoginController.getinstance().loadpage("k_login");
    		return;
    	}
    	
    	//pc ��å ��������
    	if(pc_no==0) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("�ڸ��� �������ּ���");
    		alert.showAndWait();
    		return;
    	}
    	// ����� �ð� ����
    	boolean payment = TimeDao.gettimDao().timeupdate( m_no, time ,t_remaintime);
    	
    	if(payment) {
    		//�ڸ�����
    		PcDao.getPcDao().pcset(pc_no, LoginController.getinstance().m_no);
    		//�ð� �ֹ� ����
    		TimeorderDao.getTimeorderDao().timeorder(price,  m_no);
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("���� �Ǿ����ϴ�");
    		alert.showAndWait();
    		LoginController.getinstance().loadpage("k_login");		
    	}
    }

    @FXML
    void pc_1(ActionEvent event) {
    	pc_no=1;
    	lblseat_ch.setText("1�� pc ����");
    }

    @FXML
    void pc_10(ActionEvent event) {
    	pc_no=10;
    	lblseat_ch.setText("10�� pc ����");
    }

    @FXML
    void pc_11(ActionEvent event) {
    	pc_no=11;
    	lblseat_ch.setText("11�� pc ����");
    }

    @FXML
    void pc_12(ActionEvent event) {
    	pc_no=12;
    	lblseat_ch.setText("12�� pc ����");
    }

    @FXML
    void pc_13(ActionEvent event) {
    	pc_no=13;
    	lblseat_ch.setText("13�� pc ����");
    }

    @FXML
    void pc_14(ActionEvent event) {
    	pc_no=14;
    	lblseat_ch.setText("14�� pc ����");
    }

    @FXML
    void pc_15(ActionEvent event) {
    	pc_no=15;
    	lblseat_ch.setText("15�� pc ����");
    }

    @FXML
    void pc_16(ActionEvent event) {
    	pc_no=16;
    	lblseat_ch.setText("16�� pc ����");
    }

    @FXML
    void pc_17(ActionEvent event) {
    	pc_no=17;
    	lblseat_ch.setText("17�� pc ����");
    }

    @FXML
    void pc_18(ActionEvent event) {
    	pc_no=18;
    	lblseat_ch.setText("18�� pc ����");
    }

    @FXML
    void pc_19(ActionEvent event) {
    	pc_no=19;
    	lblseat_ch.setText("19�� pc ����");
    }

    @FXML
    void pc_2(ActionEvent event) {
    	pc_no=2;
    	lblseat_ch.setText("2�� pc ����");
    }

    @FXML
    void pc_20(ActionEvent event) {
    	pc_no=20;
    	lblseat_ch.setText("20�� pc ����");
    }

    @FXML
    void pc_3(ActionEvent event) {
    	pc_no=3;
    	lblseat_ch.setText("3�� pc ����");
    }

    @FXML
    void pc_4(ActionEvent event) {
    	pc_no=4;
    	lblseat_ch.setText("4�� pc ����");
    }

    @FXML
    void pc_5(ActionEvent event) {
    	pc_no=5;
    	lblseat_ch.setText("5�� pc ����");
    }

    @FXML
    void pc_6(ActionEvent event) {
    	pc_no=6;
    	lblseat_ch.setText("6�� pc ����");
    }

    @FXML
    void pc_7(ActionEvent event) {
    	pc_no=7;
    	lblseat_ch.setText("7�� pc ����");
    }

    @FXML
    void pc_8(ActionEvent event) {
    	pc_no=8;
    	lblseat_ch.setText("8�� pc ����");
    }

    @FXML
    void pc_9(ActionEvent event) {
    	pc_no=9;
    	lblseat_ch.setText("9�� pc ����");
    }

    @FXML
    void price_1000(ActionEvent event) {
    	price = 1000;
    	time = 3600;
    	lblprice_ch.setText("1000��");
    }

    @FXML
    void price_2000(ActionEvent event) {
    	price = 2000;
    	time = 7200;
    	lblprice_ch.setText("2000��");
    }

    @FXML
    void price_3000(ActionEvent event) {
    	price = 3000;
    	time = 9800;
    	lblprice_ch.setText("3000��");
    }

    @FXML
    void price_5000(ActionEvent event) {
    	price = 5000;
    	time = 17000;
    	lblprice_ch.setText("4000��");
    }
  
}
