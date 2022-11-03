import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.*;

//Manage Appointment, can Add Appointment, or Edit or Delete Appointment
public class ManageAppointmentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add_appointment_but;

    @FXML
    private Button edit_del_appointment_but;

    @FXML
    private Button back_but;
    
    //Add Appointment
    @FXML
    void addAppointment(ActionEvent event) throws IOException {
      ReadData.switchScene("AddAppointment");

    }

    //back to Manager menu
    @FXML
    void back(ActionEvent event) throws IOException  {
      ReadData.switchScene("Manager");

    }

    //Edit or Delete Appointment
    @FXML
    void editDeleteAppointment(ActionEvent event) throws IOException  {
      ReadData.switchScene("EditDeleteAppointment");
      ReadData.selectedAppointment = null;

    }

    @FXML
    void initialize() {
        
    }
}
