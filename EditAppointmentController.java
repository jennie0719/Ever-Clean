import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import java.io.*;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.Initializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.layout.HBox;

//Edit appointment
public class EditAppointmentController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField cus_name;

    @FXML
    private TextField cus_phonenum;

    @FXML
    private TextField cus_address;

    @FXML
    private Button edit_but;

    @FXML
    private Button back_but;

    @FXML
    private Text reminder;

    @FXML
    private TextField apm_amount;

    @FXML
    private DatePicker date_picker;

    @FXML
    private MenuButton time_hour;

    @FXML
    private MenuButton time_minute;

    @FXML
    private MenuButton duration;

    @FXML
    private MenuButton status;

    @FXML
    private HBox cleaner_box;

    @FXML
    private Text cleaner_reminder;

    private String hour;
    private String min;
    private String dur;
    private String status_string;
    private String cleaner_string;
    private MenuButton cleaner = new MenuButton();

    //back to previous page
    @FXML
    void Back(ActionEvent event) throws IOException {
        ReadData.switchScene("EditDeleteAppointment");
    }

    @FXML
    void Edit(ActionEvent event) throws IOException {
          
        boolean isValid = false;
        for (Cleaner c: ReadData.cleanerArrayList) {
            if (c.getCleanerID().equals(ReadData.selectedAppointment.getAppointmentStaff())) {
                isValid = true;
            }
        }

        if (isValid) {
          //update edited information
            ObservableList < Appointment > list = FXCollections.observableArrayList();
            for (int j = 0; j < ReadData.appointmentArrayList.size(); j++) {
                if (ReadData.selectedAppointment.getAppointmentID().equals(ReadData.appointmentArrayList.get(j).getAppointmentID())) {
                    ReadData.appointmentArrayList.get(j).setCustomerName(cus_name.getText());            
                    ReadData.appointmentArrayList.get(j).setCustomerPhone(cus_phonenum.getText());
                    ReadData.appointmentArrayList.get(j).setCustomerAddress(cus_address.getText());
                    ReadData.appointmentArrayList.get(j).setAppointmentStatus(status.getText());
                    String[] date_temp_array = date_picker.getValue().toString().split("-");
                    String date_temp_str = "";
                    for (int i = 2; i > 0; i--) {
                        date_temp_str += date_temp_array[i];
                        date_temp_str += "/";
                    }
                    date_temp_str += date_temp_array[0];
                    ReadData.appointmentArrayList.get(j).setAppointmentDate(date_temp_str);
                    ReadData.appointmentArrayList.get(j).setAppointmentTime(hour + ":" + min);

                    ReadData.appointmentArrayList.get(j).setAppointmentStaff(cleaner.getText());
                    ReadData.appointmentArrayList.get(j).setAppointmentAmount(apm_amount.getText());

                    if (ReadData.appointmentArrayList.get(j).getAppointmentStaff().equals(cleaner.getText())) {
                        ReadData.appointmentArrayList.get(j).setAppointmentDuration(dur);
                    } else {
                        ReadData.appointmentArrayList.get(j).getAppointmentStaff();

                    }

                    ReadData.updateAppointmentCSV();

                }
            }
            //switch to display success message
            ReadData.switchScene("EditAppointmentSuccessfully");
        } else {
          //display reminder if any field is empty
            reminder.setText("You have to fill in all information");
            reminder.setFill(Color.FIREBRICK);
        }
    }



    //drop down menu options
    @FXML
    void apm_00min(ActionEvent event) {
        min = "00";
        time_minute.setText(min);
    }

    @FXML
    void apm_06hr(ActionEvent event) {
        hour = "06";
        time_hour.setText(hour);
    }

    @FXML
    void apm_07hr(ActionEvent event) {
        hour = "07";
        time_hour.setText(hour);
    }

    @FXML
    void apm_08hr(ActionEvent event) {
        hour = "08";
        time_hour.setText(hour);
    }

    @FXML
    void apm_09hr(ActionEvent event) {
        hour = "09";
        time_hour.setText(hour);
    }

    @FXML
    void apm_10dur(ActionEvent event) {
        dur = "10";
        duration.setText(dur);
    }

    @FXML
    void apm_10hr(ActionEvent event) {
        hour = "10";
        time_hour.setText(hour);
    }

    @FXML
    void apm_11hr(ActionEvent event) {
        hour = "11";
        time_hour.setText(hour);
    }

    @FXML
    void apm_12hr(ActionEvent event) {
        hour = "12";
        time_hour.setText(hour);
    }

    @FXML
    void apm_13hr(ActionEvent event) {
        hour = "13";
        time_hour.setText(hour);
    }

    @FXML
    void apm_14hr(ActionEvent event) {
        hour = "14";
        time_hour.setText(hour);
    }

    @FXML
    void apm_15hr(ActionEvent event) {
        hour = "15";
        time_hour.setText(hour);
    }

    @FXML
    void apm_15min(ActionEvent event) {
        min = "15";
        time_minute.setText(min);
    }

    @FXML
    void apm_16hr(ActionEvent event) {
        hour = "16";
        time_hour.setText(hour);
    }

    @FXML
    void apm_17hr(ActionEvent event) {
        hour = "17";
        time_hour.setText(hour);
    }

    @FXML
    void apm_18hr(ActionEvent event) {
        hour = "18";
        time_hour.setText(hour);
    }

    @FXML
    void apm_19hr(ActionEvent event) {
        hour = "19";
        time_hour.setText(hour);
    }

    @FXML
    void apm_1dur(ActionEvent event) {
        dur = "1";
        duration.setText(dur);
    }

    @FXML
    void apm_20hr(ActionEvent event) {
        hour = "20";
        time_hour.setText(hour);
    }

    @FXML
    void apm_21hr(ActionEvent event) {
        hour = "21";
        time_hour.setText(hour);
    }

    @FXML
    void apm_22hr(ActionEvent event) {
        hour = "22";
        time_hour.setText(hour);
    }

    @FXML
    void apm_2dur(ActionEvent event) {
        dur = "2";
        duration.setText(dur);
    }

    @FXML
    void apm_30min(ActionEvent event) {
        min = "30";
        time_minute.setText(min);
    }

    @FXML
    void apm_3dur(ActionEvent event) {
        dur = "3";
        duration.setText(dur);
    }

    @FXML
    void apm_45min(ActionEvent event) {
        min = "45";
        time_minute.setText(min);
    }

    @FXML
    void apm_4dur(ActionEvent event) {
        dur = "4";
        duration.setText(dur);
    }

    @FXML
    void apm_5dur(ActionEvent event) {
        dur = "5";
        duration.setText(dur);
    }


    @FXML
    void status_complete(ActionEvent event) {
        status_string = "completed";
        status.setText(status_string);
    }

    @FXML
    void status_incomplete(ActionEvent event) {
        status_string = "incomplete";
        status.setText(status_string);
    }


    @FXML
    public void initialize(URL url, ResourceBundle rb) {

        cleaner_reminder.setFill(Color.FIREBRICK);

        cus_name.setText(ReadData.selectedAppointment.getCustomerName());
        cus_phonenum.setText(ReadData.selectedAppointment.getCustomerPhone());
        cus_address.setText(ReadData.selectedAppointment.getCustomerAddress());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(ReadData.selectedAppointment.getAppointmentDate(), formatter);
        date_picker.setValue(localDate);


        time_hour.setText(ReadData.selectedAppointment.getAppointmentTime().substring(0, 2));
        hour = ReadData.selectedAppointment.getAppointmentTime().substring(0, 2);
        time_minute.setText(ReadData.selectedAppointment.getAppointmentTime().substring(3));
        min = ReadData.selectedAppointment.getAppointmentTime().substring(3);
        duration.setText(ReadData.selectedAppointment.getAppointmentDuration());
        dur = ReadData.selectedAppointment.getAppointmentDuration();
        cleaner.setText(ReadData.selectedAppointment.getAppointmentStaff());
        apm_amount.setText(ReadData.selectedAppointment.getAppointmentAmount());
        status.setText(ReadData.selectedAppointment.getAppointmentStatus());

        EventHandler < ActionEvent > action = changeTabPlacement();
        for (Cleaner c: ReadData.cleanerArrayList) {
            if (c.getCleanerTeam().equals(ReadData.userteam)) {
                MenuItem item = new MenuItem(c.getCleanerID());
                item.setOnAction(action);
                cleaner.getItems().add(item);
            } else {
                continue;
            }
        }
        cleaner_box.getChildren().add(cleaner);
    }

    private EventHandler < ActionEvent > changeTabPlacement() {
        return new EventHandler < ActionEvent > () {

            public void handle(ActionEvent event) {
                MenuItem mItem = (MenuItem) event.getSource();
                String cleaner_chosen = mItem.getText();
                String[] date_temp_array = date_picker.getValue().toString().split("-");
                String date_temp_str = "";
                for (int i = 2; i > 0; i--) {
                    date_temp_str += date_temp_array[i];
                    date_temp_str += "/";
                }
                date_temp_str += date_temp_array[0];
                boolean available = true;
                for (Appointment a: ReadData.appointmentArrayList) {
                    if (a.getAppointmentStaff().equals(cleaner_chosen) && date_temp_str.equals(a.getAppointmentDate())) {
                        int time1 = (Integer.parseInt(a.getAppointmentTime().substring(0, 2)) * 100) + Integer.parseInt(a.getAppointmentTime().substring(3, 5)) - 30;
                        int time2 = (Integer.parseInt(a.getAppointmentTime().substring(0, 2)) * 100) + Integer.parseInt(a.getAppointmentTime().substring(3, 5)) + (Integer.parseInt(a.getAppointmentDuration()) * 100) + 30;
                        if ((((Integer.parseInt(hour) + Integer.parseInt(dur)) * 100) + Integer.parseInt(min)) <= time1 || ((Integer.parseInt(hour) * 100) + Integer.parseInt(min)) >= time2) {
                            continue;
                        } else {
                            available = false;
                            break;
                        }
                    } else {
                        continue;
                    }
                }
                if (available) {
                    cleaner.setText(cleaner_chosen);
                    reminder.setText("");
                } else {
                    reminder.setText("This cleaner is unavailable, please choose again.");
                    reminder.setFill(Color.FIREBRICK);
                }



            }
        };
    }


}