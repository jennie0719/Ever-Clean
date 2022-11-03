import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import java.io.*;

//Login Controller
public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button login_button;

    @FXML
    public TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Text reminder;

    @FXML
    void login(ActionEvent event) throws IOException {
      //Validate the username and password input by user
        if (Manager.login(username.getText(), password.getText()) || Cleaner.login(username.getText(), password.getText())) {
            if (Manager.login(username.getText(), password.getText())) {
                ReadData.userid = username.getText();
                for (int i = 0; i < ReadData.managerArrayList.size(); i++) {
                    if (ReadData.managerArrayList.get(i).getManagerID().equals(username.getText())) {
                        ReadData.userteam = ReadData.managerArrayList.get(i).getManagerTeam();

                    } else {
                        continue;
                    }
                }
                //if validated as a manager, switch to manager menu
                ReadData.switchScene("Manager");

            } else {
              //if validated as a cleaner, switch to cleaner menu
                ReadData.userid = username.getText();
                ReadData.switchScene("Cleaner");
            }
        } else {
          //if neither validated as manager nor cleaner, display "invalid" warning message
            reminder.setText("Invalid Username/Password");
            reminder.setFill(Color.FIREBRICK);
        }

    }
    

    @FXML
    void initialize() {

    }
}