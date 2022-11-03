import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.*;
import javafx.scene.text.Text;

//the menu displayed after a manager logs in
public class ManagerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button manageCleaner_button;

    @FXML
    private Button manageAppointment_button;

    @FXML
    private Button report_button;

    @FXML
    private Button top3cleaner_button;

    @FXML
    private Button logout_button;
    
    @FXML
    private Text welcome_message;

    //logout
    @FXML
    void logout(ActionEvent event) throws IOException{
      ReadData.switchScene("Login");
    }
    
    //Manage Appointment
    @FXML
    void manageAppointment(ActionEvent event) throws IOException{
      ReadData.switchScene("ManageAppointment");
    }

    //Manage Cleaner
    @FXML
    void manageCleaner(ActionEvent event) throws IOException{
      ReadData.switchScene("ManageCleaner");
    }

    //Show Monthly Salary Report
    @FXML
    void report(ActionEvent event) throws IOException{
      ReadData.switchScene("MonthlySalaryReport");
    }

    //Show Top Three Cleaner
    @FXML
    void top3cleaner(ActionEvent event) throws IOException{
      ReadData.switchScene("TopThreeCleaner");
    }

    @FXML
    void initialize() {
      //display a welcome message on the menu, with the manager's name
      for (int i = 0; i<ReadData.managerArrayList.size(); i++){
        if(ReadData.userid.equals(ReadData.managerArrayList.get(i).getManagerID())){
        welcome_message.setText("Welcome, " + ReadData.managerArrayList.get(i).getManagerName());
        }
      }
   
    }
}
