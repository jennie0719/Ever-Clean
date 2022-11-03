import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.*;
import javafx.scene.text.Text;

//Cleaner menu after a cleaner log in
public class CleanerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button checkAndMarkAppointment_button;

    @FXML
    private Button top3cleaner_button;

    @FXML
    private Button logout_button;
    
    @FXML
    private Text welcome_message;

    @FXML
    void checkAndMarkAppointment(ActionEvent event) throws IOException{
      ReadData.switchScene("CleanerUpdate");//switch to cleaner update (status) interface
    }

    
    @FXML
    void logout(ActionEvent event) throws IOException{
      ReadData.switchScene("Login");//switch to login interface
    }

    @FXML
    void top3cleaner(ActionEvent event) throws IOException{
      ReadData.switchScene("TopThreeCleaner");//switch to top three cleaner interface
    }

    @FXML
    void initialize() {
      for (int i = 0; i<ReadData.cleanerArrayList.size(); i++){
        if(ReadData.userid.equals(ReadData.cleanerArrayList.get(i).getCleanerID())){
        welcome_message.setText("Welcome, " + ReadData.cleanerArrayList.get(i).getCleanerName());//welcome message
        }
      }
    }
}
        
 

