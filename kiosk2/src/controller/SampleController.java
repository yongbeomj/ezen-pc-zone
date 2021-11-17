package controller;



import dao.TimeDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SampleController {

	@FXML
    private Button btnstart;

    @FXML
    private Button btnstop;

    @FXML
    private Label lblm_id;

    @FXML
    private Label lblpc_no;

    @FXML
    private Label lbltime;

    @FXML
    void start(ActionEvent event) {
    	thread.start();

    }
    Runnable runnable = new Runnable() {
		
		@Override
		public void run() {
			while(true) {
				int t_remaintime = TimeDao.gettimDao().time_remaintime( 3);
				TimeDao.gettimDao().timeupdate(3, -1, t_remaintime);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	};
	Thread thread =new Thread(runnable);

    @FXML
    void stop(ActionEvent event) {
//    	try {
//			thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	thread.interrupt();
    	thread.stop();
    }
}
