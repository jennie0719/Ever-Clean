import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.io.*;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.Initializable;

public class TopThreeCleanerController implements Initializable{


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Cleaner> top_three_cleaner;

    @FXML
    private TableColumn<Cleaner,String > rank;

    @FXML
    private TableColumn<Cleaner, String> id;

    @FXML
    private TableColumn<Cleaner, String> name;

    @FXML
    private TableColumn<Cleaner, String> total_monthly_salary;

    @FXML
    private Button back_but;

    @FXML
    void back(ActionEvent event) throws IOException{
      char charAtZero = ReadData.userid.charAt(0);
      if (charAtZero=='M'){
        ReadData.switchScene("Manager");
      }else{
        ReadData.switchScene("Cleaner");//switch scene
      }

    }

    
    ObservableList<Cleaner> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
      ArrayList<Cleaner> cleanerList = ReadData.sortBySalary();
      int k = 1;
      for (Cleaner c: cleanerList) {
        c.setCleanerRank(Integer.toString(k++));//set rank
      }
       for (int j = 0; j<cleanerList.size(); j++){                                                              
         list.add(cleanerList.get(j));
       }
       
       rank.setCellValueFactory(new PropertyValueFactory<Cleaner,String>("cleanerRank"));
       
       id.setCellValueFactory(new PropertyValueFactory<Cleaner,String>("cleanerID"));

       name.setCellValueFactory(new PropertyValueFactory<Cleaner,String>("cleanerName"));

       total_monthly_salary.setCellValueFactory(new PropertyValueFactory<Cleaner,String>("cleanerTotalSalary"));
 
       top_three_cleaner.setItems(list);   
    }
}

