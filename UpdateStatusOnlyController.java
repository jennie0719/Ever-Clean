import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import java.util.Date;

//For a cleaner to update appointment status only (after he completes an appointment)
public class UpdateStatusOnlyController implements Initializable {

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
    private MenuButton cleaner;

    @FXML
    private Text status_reminder;

    private String hour;
    private String min;
    private String dur;
    private String status_string;
    private String cleaner_string;

    @FXML
    void Back(ActionEvent event) throws IOException {
        ReadData.switchScene("CleanerUpdate");
    }

    @FXML
    void Edit(ActionEvent event) throws IOException, ParseException {
        boolean allCorrect = true;

        if (status_string == "completed") {
            SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yyyy");
            Date d1 = new Date();


            Date d2 = sdformat.parse(ReadData.selectedAppointment.getAppointmentDate());



            //the cleaner can only update after the end time of the appointment is passed
            if (d1.compareTo(d2) > 0) {
                for (int b = 0; b < ReadData.cleanerArrayList.size(); b++) {
                    if (ReadData.cleanerArrayList.get(b).getCleanerID().equals(ReadData.selectedAppointment.getAppointmentStaff())) {
                        float c_totalSalary = Float.parseFloat(ReadData.cleanerArrayList.get(b).getCleanerTotalSalary());
                        float c_salary = Float.parseFloat(ReadData.cleanerArrayList.get(b).getCleanerSalary());
                        float c_hour = Float.parseFloat(ReadData.cleanerArrayList.get(b).getCleanerWorkingHour());
                        float appointmentDuration = Float.parseFloat(dur);

                        ReadData.cleanerArrayList.get(b).setCleanerTotalSalary(Float.toString(c_totalSalary + c_salary * appointmentDuration));
                        ReadData.cleanerArrayList.get(b).setCleanerWorkingHour(Float.toString(c_hour + appointmentDuration));

                        ReadData.updateCleanerCSV();

                        break;

                    }
                }
                for (int j = 0; j < ReadData.appointmentArrayList.size(); j++) {
                    if (ReadData.selectedAppointment.getAppointmentID().equals(ReadData.appointmentArrayList.get(j).getAppointmentID())) {
                        ReadData.appointmentArrayList.get(j).setAppointmentStatus(status.getText());
                    }
                }
                ReadData.updateAppointmentCSV();
                //switch scene to show update status successfully message
                ReadData.switchScene("UpdateSuccess");


            } else if (d1.compareTo(d2) < 0 || d1.compareTo(d2) == 0) {
                status_reminder.setText("You can only update status after appointment");
                status_reminder.setFill(Color.FIREBRICK);

            }



        }
    }





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
    void cleaner_1(ActionEvent event) {
        cleaner_string = "C1";
        cleaner.setText(cleaner_string);
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

    }
}