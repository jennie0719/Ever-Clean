import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import java.io.*;
import java.util.*;

public class AddCleanerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name;

    @FXML
    private TextField phone_no;

    @FXML
    private TextField email;

    @FXML
    private Button add_but;

    @FXML
    private Button back_but;

    @FXML
    private TextField password;

    @FXML
    private TextField team;

    @FXML
    private Text reminder;

    @FXML
    private Text phone_no_error;
 
    @FXML
    void Add(ActionEvent event) throws IOException {
        boolean allCorrect = true;
        while (allCorrect) {
            //initialise properties of cleaner
            String temp_id = "C" + String.valueOf(ReadData.cleanerArrayList.size() + 1);
            String temp_salary = "50";//hourly salary for all cleaner
            String temp_Working_Hour = "0";
            String temp_Total_Salary = "0";
            if (!name.getText().isEmpty() && !password.getText().isEmpty() &&
                !team.getText().isEmpty() && !phone_no.getText().isEmpty() &&
                !email.getText().isEmpty() && !temp_salary.isEmpty()) {
              //Catch exception of non-number input
                try {
                    Float temp = Float.parseFloat(phone_no.getText());

                } catch (Exception e) {
                    phone_no_error.setText("This should be number only");
                    phone_no_error.setFill(Color.FIREBRICK);
                    break;
                }
                //Create cleaner
                Cleaner c = new Cleaner(temp_id, name.getText(), password.getText(),
                    team.getText(), phone_no.getText(), email.getText(),
                    temp_salary, temp_Working_Hour, temp_Total_Salary);
                ReadData.cleanerArrayList.add(c);
                ReadData.updateCleanerCSV();
                ReadData.switchScene("AddCleanerSuccessfully");
            } else {
                reminder.setText("You have to fill in all the boxes");//remind user 
                reminder.setFill(Color.FIREBRICK);
            }
            allCorrect = false;//exit the loop 
        }
    }

    @FXML
    void Back(ActionEvent event) throws IOException {
        ReadData.switchScene("ManageCleaner");
    }

    @FXML
    void initialize() {
        team.setText(ReadData.userteam);//default team as one manager can only in charge of his team

    }
}