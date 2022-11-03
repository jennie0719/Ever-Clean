import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.*;

public class ManageCleanerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add_cleaner_but;

    @FXML
    private Button edit_del_cleaner_but;

    @FXML
    private Button back_but;

    @FXML
    void addCleaner(ActionEvent event) throws IOException {
      ReadData.switchScene("AddCleaner");//Swtich scene to "AddCleaner" interaface

    }

    @FXML
    void back(ActionEvent event) throws IOException {
      ReadData.switchScene("Manager");//Swtich scene to "Manager" interaface

    }

    @FXML
    void editDeleteCleaner(ActionEvent event) throws IOException{
      ReadData.switchScene("EditDeleteCleaner");//Swtich scene to "EditDeleteCleaner" interaface

    }

    @FXML
    void initialize() {
        
    }
}
