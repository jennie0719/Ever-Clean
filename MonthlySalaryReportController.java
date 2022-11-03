
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import java.io.*;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class MonthlySalaryReportController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TableView<Cleaner> report_tableview;

    @FXML
    private TableColumn<Cleaner, String> id;

    @FXML
    private TableColumn<Cleaner, String> name;

    @FXML
    private TableColumn<Cleaner, String> hourly_salary;

    @FXML
    private TableColumn<Cleaner, String> hours_worked;

    @FXML
    private TableColumn<Cleaner, String> total_salary;

    @FXML
    private Button back_but;
    
   
    @FXML
    void back(ActionEvent event) throws IOException {
      ReadData.switchScene("Manager");
    }

    
    ObservableList<Cleaner> list = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {//initialise tableview items
      for (int j = 0; j<ReadData.cleanerArrayList.size(); j++){   
         if (ReadData.cleanerArrayList.get(j).getCleanerTeam().equals(ReadData.userteam)){
           
           list.add(ReadData.cleanerArrayList.get(j));
         }else{
           continue;
         }
       }
        id.setCellValueFactory(new PropertyValueFactory<Cleaner,String>("cleanerID"));
        
        name.setCellValueFactory(new PropertyValueFactory<Cleaner,String>("cleanerName"));

        hourly_salary.setCellValueFactory(new PropertyValueFactory<Cleaner,String>("cleanerSalary"));

        hours_worked.setCellValueFactory(new PropertyValueFactory<Cleaner,String>("cleanerWorkingHour"));
            
        total_salary.setCellValueFactory(new PropertyValueFactory<Cleaner,String>("cleanerTotalSalary"));
                
        report_tableview.setItems(list);    
    }
}
