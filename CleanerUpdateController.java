import java.net.URL; 
import java.util.ResourceBundle; 
import javafx.event.ActionEvent; 
import javafx.fxml.FXML; 
import javafx.scene.control.Button; 
import javafx.scene.control.TableColumn; 
import javafx.scene.control.TableView; 
import javafx.scene.control.TextField; 
import javafx.scene.text.Text; 
import javafx.scene.paint.Color; 
import java.io.*; 
import java.util.*; 
import javafx.collections.FXCollections; 
import javafx.collections.ObservableList; 
import javafx.scene.control.cell.PropertyValueFactory; 
import javafx.fxml.Initializable; 
 
//For a cleaner to view only his own upcoming appointments and to update appointment status
public class CleanerUpdateController implements Initializable{ 
   
   
    @FXML 
    private ResourceBundle resources; 
 
    @FXML 
    private URL location; 
 
    @FXML 
    private TextField search_data; 
 
    @FXML 
    private Button search_but; 
 
    @FXML 
    private Button edit_but; 
 
    @FXML 
    private Button back_but; 
 
    @FXML 
    private TableView<Appointment> appointment_tableview; 
 
    @FXML 
    private TableColumn<Appointment, String> id_col; 
 
    @FXML 
    private TableColumn<Appointment, String> name_col; 
 
    @FXML 
    private TableColumn<Appointment, String> phone_col; 
 
    @FXML 
    private TableColumn<Appointment, String> address_col; 
 
    @FXML 
    private TableColumn<Appointment, String> date_col; 
 
    @FXML 
    private TableColumn<Appointment, String> time_col; 
 
    @FXML 
    private TableColumn<Appointment, String> dur_col; 
 
    @FXML 
    private TableColumn<Appointment, String> cleaner_col; 
 
    @FXML 
    private TableColumn<Appointment, String> amount_col; 
     
    @FXML 
    private TableColumn<Appointment, String> status_col; 
         
    private static String edit_apm; 
   
    @FXML 
    void back(ActionEvent event) throws IOException{ 
      ReadData.switchScene("Cleaner"); 
       
      ObservableList<Appointment> list = FXCollections.observableArrayList(); 
       
      appointment_tableview.setItems(list); 
     
    } 
 
 
 
    @FXML 
    //go to update status of appointment from incomplete to completed
    void edit(ActionEvent event) throws IOException{ 
      ReadData.selectedAppointment = appointment_tableview.getSelectionModel().getSelectedItem(); 
      ReadData.switchScene("UpdateStatusOnly"); 
       
    } 
 
    @FXML 
    void search(ActionEvent event) { 
      edit_apm = search_data.getText(); 
       
      ObservableList<Appointment> list = FXCollections.observableArrayList(); 
       
      for (int j = 0; j<ReadData.appointmentArrayList.size(); j++){
          for (int i =0; i<ReadData.cleanerArrayList.size(); i++){
            if (ReadData.cleanerArrayList.get(i).getCleanerID().equals(ReadData.appointmentArrayList.get(j).getAppointmentStaff())){
              if (ReadData.cleanerArrayList.get(i).getCleanerTeam().equals(ReadData.userteam)&&search_data.getText().equals (ReadData.appointmentArrayList.get(j).getAppointmentID())){
                list.add(ReadData.appointmentArrayList.get(j));
            }else{
              continue;
            }
            }else{
              continue;
            }
          }
        }
      
        id_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appointmentID")); 
         
        name_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("customerName")); 
 
        phone_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("customerPhone")); 
 
        address_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("customerAddress")); 
             
        date_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appointmentDate")); 
         
        time_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appointmentTime")); 
             
        dur_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appointmentDuration")); 
         
        cleaner_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appointmentStaff")); 
             
        amount_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appointmentAmount")); 
                 
        status_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appointmentStatus")); 
         
        appointment_tableview.setItems(list); 
    } 
     
    ObservableList<Appointment> list = FXCollections.observableArrayList(); 
 
    @FXML 
    public void initialize(URL url, ResourceBundle rb) { 
        for (int j = 0; j<ReadData.appointmentArrayList.size(); j++){                                                               
          if (ReadData.appointmentArrayList.get(j).getAppointmentStaff().equals(ReadData.userid)){
            list.add(ReadData.appointmentArrayList.get(j)); 
          }else{
            continue;
          }
       } 
         
       id_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appointmentID")); 
         
        name_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("customerName")); 
 
        phone_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("customerPhone")); 
 
        address_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("customerAddress")); 
             
        date_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appointmentDate")); 
         
        time_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appointmentTime")); 
             
        dur_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appointmentDuration")); 
         
        cleaner_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appointmentStaff")); 
             
        amount_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appointmentAmount")); 
                 
        status_col.setCellValueFactory(new PropertyValueFactory<Appointment,String>("appointmentStatus")); 
         
        appointment_tableview.setItems(list);  
    } 
     
    public static String editApm(){ 
      return edit_apm; 
    } 
} 
