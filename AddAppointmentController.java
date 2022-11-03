import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

//Add Appointment
public class AddAppointmentController {

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
    private Button add_but;

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
    
    @FXML
    private Text phone_error;

    @FXML
    private Text name_error;

    @FXML
    private Text amount_error;
    

    
    private String hour;
    private String min;
    private String dur;
    private String status_string;
    private String cleaner_string;
    private MenuButton cleaner = new MenuButton();
    

    @FXML//Add action
    void Add(ActionEvent event) throws IOException{
      boolean allCorrect = true;
      while (allCorrect){   
        
      //Assign an Appointment ID for a new appointment, e.g. A3
      String temp_id = "A" + String.valueOf(ReadData.appointmentArrayList.size()+1);
      
      //Check if all textfields are filled
      if(!cus_name.getText().isEmpty() && !cus_phonenum.getText().isEmpty() 
                              && !cus_address.getText().isEmpty() && !date_picker.getValue().toString().isEmpty()
           && !hour.isEmpty() && !min.isEmpty() && !dur.isEmpty() && !cleaner.getText().isEmpty() && !apm_amount.getText().isEmpty() && !status.getText().isEmpty()){
        String[] date_temp_array = date_picker.getValue().toString().split("-");
        String date_temp_str = "";
     
        for (int i = 2; i > 0 ; i-- ) { 
          date_temp_str += date_temp_array[i];
          date_temp_str += "/";
        }
        date_temp_str += date_temp_array[0];
        
        //Catch Exception of non-number input in customer phone number
        try {
          Float temp = Float.parseFloat(cus_phonenum.getText());     
        } catch (Exception e) {
          phone_error.setText("This should contain number only.");
          phone_error.setFill(Color.FIREBRICK);
         break;
        }
        
        //Catch Exception of non-number input in appointment amount 
         try {
          Float temp = Float.parseFloat(apm_amount.getText());
        } catch (Exception e) {
          amount_error.setText("This should contain number only");
          amount_error.setFill(Color.FIREBRICK);
           break;
        }
        
        //Add appointment
        Appointment a = new Appointment(temp_id, cus_name.getText(), cus_phonenum.getText(), 
                                      cus_address.getText(), date_temp_str, hour+":"+min, 
                                      dur, cleaner.getText(), apm_amount.getText(), status.getText());
     
        ReadData.appointmentArrayList.add(a);
        
        //Update the Appointment CSV
        ReadData.updateAppointmentCSV();
        
        
        if (status_string =="completed") {
          for(int b=0; b<ReadData.cleanerArrayList.size(); b++){
         //update cleaner csv if an appointment is completed   
        if(ReadData.cleanerArrayList.get(b).getCleanerID().equals(a.getAppointmentStaff())){
          float c_totalSalary = Float.parseFloat(ReadData.cleanerArrayList.get(b).getCleanerTotalSalary());
          float c_salary = Float.parseFloat(ReadData.cleanerArrayList.get(b).getCleanerSalary());
          float c_hour = Float.parseFloat(ReadData.cleanerArrayList.get(b).getCleanerWorkingHour());
          float appointmentDuration = Float.parseFloat(dur);
          
          //update cleaner total salary and working hour
          ReadData.cleanerArrayList.get(b).setCleanerTotalSalary(Float.toString(c_totalSalary + c_salary * appointmentDuration)); 
          ReadData.cleanerArrayList.get(b).setCleanerWorkingHour(Float.toString(c_hour + appointmentDuration)); 
  
       ReadData.updateCleanerCSV();
       
        }
          }
        }
        //switch to Add Appointment Successfully to notify manager
        ReadData.switchScene("AddAppointmentSuccessfully");  
        
      }
      else{
        //reminder manager to fill in all information if manager hasn't
        reminder.setText("You have to fill in all information");
        reminder.setFill(Color.FIREBRICK);
        break;
      }
       allCorrect = false;
    }
     
    }

    //back to previous page
    @FXML
    void Back(ActionEvent event) throws IOException {
      ReadData.switchScene("ManageAppointment");

    }

    //drop down menu options
    @FXML
    void apm_00min(ActionEvent event) {
      min="00";
      time_minute.setText(min);
    }

    @FXML
    void apm_06hr(ActionEvent event) {
      hour="06";
      time_hour.setText(hour);
    }

    @FXML
    void apm_07hr(ActionEvent event) {
      hour="07";
      time_hour.setText(hour);
    }

    @FXML
    void apm_08hr(ActionEvent event) {
      hour="08";
      time_hour.setText(hour);
    }

    @FXML
    void apm_09hr(ActionEvent event) {
      hour="09";time_hour.setText(hour);
    }

    @FXML
    void apm_10hr(ActionEvent event) {
      hour="10";
      time_hour.setText(hour);
    }

    @FXML
    void apm_11hr(ActionEvent event) {
      hour="11";
      time_hour.setText(hour);
    }

    @FXML
    void apm_12hr(ActionEvent event) {
      hour="12";
      time_hour.setText(hour);
    }

    @FXML
    void apm_13hr(ActionEvent event) {
      hour="13";
      time_hour.setText(hour);
    }

    @FXML
    void apm_14hr(ActionEvent event) {
      hour="14";
      time_hour.setText(hour);
    }

    @FXML
    void apm_15hr(ActionEvent event) {
      hour="15";
      time_hour.setText(hour);
    }

    @FXML
    void apm_15min(ActionEvent event) {
      min="15";
      time_minute.setText(min);
    }

    @FXML
    void apm_16hr(ActionEvent event) {
      hour="16";
      time_hour.setText(hour);
    }

    @FXML
    void apm_17hr(ActionEvent event) {
      hour="17";
      time_hour.setText(hour);
    }

    @FXML
    void apm_18hr(ActionEvent event) {
      hour="18";
      time_hour.setText(hour);
    }

    @FXML
    void apm_19hr(ActionEvent event) {
      hour="19";
      time_hour.setText(hour);
    }

    @FXML
    void apm_1dur(ActionEvent event) {
      dur="1";
      duration.setText(dur);
    }

    @FXML
    void apm_20hr(ActionEvent event) {
      hour="20";
      time_hour.setText(hour);
    }

    @FXML
    void apm_21hr(ActionEvent event) {
      hour="21";
      time_hour.setText(hour);
    }

    @FXML
    void apm_22hr(ActionEvent event) {
      hour="22";
      time_hour.setText(hour);
    }

    @FXML
    void apm_2dur(ActionEvent event) {
      dur="2";
      duration.setText(dur);
    }

    @FXML
    void apm_30min(ActionEvent event) {
      min="30";
      time_minute.setText(min);
    }

    @FXML
    void apm_3dur(ActionEvent event) {
      dur="3";
      duration.setText(dur);
    }

    @FXML
    void apm_45min(ActionEvent event) {
      min="45";
      time_minute.setText(min);
    }

    @FXML
    void apm_4dur(ActionEvent event) {
      dur="4";
      duration.setText(dur);
    }

    @FXML
    void apm_5dur(ActionEvent event) {
      dur="5";
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
    void initialize() {
      
      //the manager should be able to add appointment only for cleaners who are under his team
      EventHandler<ActionEvent> action = changeTabPlacement();
      for (Cleaner c: ReadData.cleanerArrayList){
        if (c.getCleanerTeam().equals(ReadData.userteam)){
        MenuItem item = new MenuItem(c.getCleanerID());
        item.setOnAction(action);
        cleaner.getItems().add(item);
        }else{
          continue;
        }
      }
      cleaner_box.getChildren().add(cleaner);
    }
   
    private EventHandler<ActionEvent> changeTabPlacement() {
      
        return new EventHandler<ActionEvent>() {
          //check the availability of a cleaner in a certain time slot

            public void handle(ActionEvent event) {
              try{
                MenuItem mItem = (MenuItem) event.getSource();
                String cleaner_chosen = mItem.getText();
                String[] date_temp_array = date_picker.getValue().toString().split("-");
        String date_temp_str = "";
        for (int i = 2; i > 0 ; i-- ) { 
          date_temp_str += date_temp_array[i];
          date_temp_str += "/";
        }
        date_temp_str += date_temp_array[0];
                boolean available = true;
                
        for (Appointment a: ReadData.appointmentArrayList){
          if (a.getAppointmentStaff().equals(cleaner_chosen) && date_temp_str.equals(a.getAppointmentDate())){
            int time1 = (Integer.parseInt(a.getAppointmentTime().substring(0,2))*100)+Integer.parseInt(a.getAppointmentTime().substring(3,5))-30;
            int time2 = (Integer.parseInt(a.getAppointmentTime().substring(0,2))*100)+Integer.parseInt(a.getAppointmentTime().substring(3,5))+(Integer.parseInt(a.getAppointmentDuration())*100)+30;
            if ( (((Integer.parseInt(hour)+Integer.parseInt(dur))*100)+Integer.parseInt(min))<=time1 || ((Integer.parseInt(hour)*100)+Integer.parseInt(min))>=time2){
              continue;
            }else{
              available=false;
              break;
            }
          }else{
            continue;
          }
        }
   
        if (available){
          //if cleaner is available in a certain time slot, can assign 
          cleaner.setText(cleaner_chosen);
          reminder.setText("");
        }else{
          //if unavailable, ask manager to select another cleaner, or change appointment time
          reminder.setText("This cleaner is unavailable, please choose again.");
          reminder.setFill(Color.FIREBRICK);
        }
                }
            
            catch(Exception e){
              cleaner_reminder.setText(" Please enter date, time, and duration before choosing cleaner.");
              cleaner_reminder.setFill(Color.FIREBRICK);
            }
            }
        };
    }
}
            
 


   

    


