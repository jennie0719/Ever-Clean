import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.*;
public class EditCleanerSuccessfullyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_but;

    @FXML
    void back(ActionEvent event) throws IOException{
      ReadData.switchScene("EditDeleteCleaner");

    }

    @FXML
    void initialize() {
        
    }
}
