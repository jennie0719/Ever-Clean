import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.*;

//display "Added Appointment Successfully" message
public class AddAppointmentSuccessfullyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_but;

    //back to Manage Appointment page
    @FXML
    void back(ActionEvent event) throws IOException {
      ReadData.switchScene("ManageAppointment");

    }

    @FXML
    void initialize() {
        
    }
}
