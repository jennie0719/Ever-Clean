import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.*;

//display message of "Edited Appointment Successfully"
public class EditAppointmentSuccessfullyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_but;

    @FXML
    void back(ActionEvent event) throws IOException {
      ReadData.switchScene("EditDeleteAppointment");
    }

    @FXML
    void initialize() {
        
    }
}
