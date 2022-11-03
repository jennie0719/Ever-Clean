import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.io.*;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.TableRow;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;



public class EditDeleteCleanerController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField search_data;

    @FXML
    private Button search_but;

    @FXML
    private TextField id;

    @FXML
    private TextField email;

    @FXML
    private TextField name;

    @FXML
    private TextField phone;

    @FXML
    private TextField salary;

    @FXML
    private Button edit_but;

    @FXML
    private Button delete_but;

    @FXML
    private Button back_but;

    @FXML
    private TableView < Cleaner > cleaner_tableview;//table view for display

    @FXML
    private TableColumn < Cleaner, String > id_col;

    @FXML
    private TableColumn < Cleaner, String > name_col;

    @FXML
    private TableColumn < Cleaner, String > phone_col;

    @FXML
    private TableColumn < Cleaner, String > email_col;

    @FXML
    private TableColumn < Cleaner, String > salary_col;

    @FXML
    private Text message;


    @FXML
    void back(ActionEvent event) throws IOException {
        ReadData.switchScene("ManageCleaner");
    }

    @FXML

    void delete(ActionEvent event) throws IOException {
      
        try {
            Cleaner c = cleaner_tableview.getSelectionModel().getSelectedItem();
            for (int j = 0; j < ReadData.cleanerArrayList.size(); j++) {
                if (ReadData.cleanerArrayList.get(j).getCleanerID().equals(c.getCleanerID())) {
                    ReadData.cleanerArrayList.remove(j);//remove from cleaner list
                    break;
                }
            }
            ReadData.updateCleanerCSV();

            ObservableList < Cleaner > list = FXCollections.observableArrayList();//observable list for display
            for (int j = 0; j < ReadData.cleanerArrayList.size(); j++) {
                list.add(ReadData.cleanerArrayList.get(j));
            }
            cleaner_tableview.setItems(list);
            ReadData.switchScene("DeleteCleanerSuccessfully");//notify user

        } catch (Exception e) {//catch exception of non-fill input
            message.setText("Please choose what to edit/delete");
            message.setFill(Color.FIREBRICK);
        }
    }

    @FXML
    void edit(ActionEvent event) throws IOException {
        try {
            Cleaner c = cleaner_tableview.getSelectionModel().getSelectedItem();
            for (int j = 0; j < ReadData.cleanerArrayList.size(); j++) {
                if (c.getCleanerID().equals(ReadData.cleanerArrayList.get(j).getCleanerID())) {
                    ReadData.cleanerArrayList.get(j).setCleanerID(id.getText());//show all properties when a cleaner is chosen
                    ReadData.cleanerArrayList.get(j).setCleanerName(name.getText());
                    ReadData.cleanerArrayList.get(j).setCleanerPhone(phone.getText());
                    ReadData.cleanerArrayList.get(j).setCleanerEmail(email.getText());
                    ReadData.cleanerArrayList.get(j).setCleanerSalary(salary.getText());
                    break;
                }
            }
            ReadData.updateCleanerCSV();

            ObservableList < Cleaner > list = FXCollections.observableArrayList();//observable list for display

            for (int j = 0; j < ReadData.cleanerArrayList.size(); j++) {//add cleaner to the list
                list.add(ReadData.cleanerArrayList.get(j));
            }

            ReadData.switchScene("EditCleanerSuccessfully");

        } catch (Exception e) {
            message.setText("Please choose what to edit/delete");
            message.setFill(Color.FIREBRICK);
        }

    }

    @FXML
    void search(ActionEvent event) {

        ObservableList < Cleaner > list = FXCollections.observableArrayList();//observable list for display

        for (int j = 0; j < ReadData.cleanerArrayList.size(); j++) {
            if (ReadData.cleanerArrayList.get(j).getCleanerTeam().equals(ReadData.userteam) 
                  && search_data.getText().equals(ReadData.cleanerArrayList.get(j).getCleanerID()))//Make sure user input all required items
            {
                list.add(ReadData.cleanerArrayList.get(j));
                id.setText(Cleaner.search(search_data.getText()).get(0));
                name.setText(Cleaner.search(search_data.getText()).get(1));
                phone.setText(Cleaner.search(search_data.getText()).get(2));
                email.setText(Cleaner.search(search_data.getText()).get(3));
                salary.setText(Cleaner.search(search_data.getText()).get(4));
            } else {
                continue;
            }
        }

        id_col.setCellValueFactory(new PropertyValueFactory < Cleaner, String > ("cleanerID"));//initialise all tableview items

        name_col.setCellValueFactory(new PropertyValueFactory < Cleaner, String > ("cleanerName"));

        phone_col.setCellValueFactory(new PropertyValueFactory < Cleaner, String > ("cleanerPhone"));

        email_col.setCellValueFactory(new PropertyValueFactory < Cleaner, String > ("cleanerEmail"));

        salary_col.setCellValueFactory(new PropertyValueFactory < Cleaner, String > ("cleanerSalary"));

        cleaner_tableview.setItems(list);

    }

    ObservableList < Cleaner > list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {//initialise all tableview items
        for (int j = 0; j < ReadData.cleanerArrayList.size(); j++) {
            if (ReadData.cleanerArrayList.get(j).getCleanerTeam().equals(ReadData.userteam)) {
                list.add(ReadData.cleanerArrayList.get(j));
            } else {
                continue;
            }
        }

        id_col.setCellValueFactory(new PropertyValueFactory < Cleaner, String > ("cleanerID"));

        name_col.setCellValueFactory(new PropertyValueFactory < Cleaner, String > ("cleanerName"));

        phone_col.setCellValueFactory(new PropertyValueFactory < Cleaner, String > ("cleanerPhone"));

        email_col.setCellValueFactory(new PropertyValueFactory < Cleaner, String > ("cleanerEmail"));

        salary_col.setCellValueFactory(new PropertyValueFactory < Cleaner, String > ("cleanerSalary"));

        cleaner_tableview.setItems(list);

        cleaner_tableview.setRowFactory(tv -> {
            TableRow < Cleaner > row = new TableRow < > ();
            row.setOnMouseClicked(event -> {//Set up mouse click event
                if (event.getClickCount() == 1 && (!row.isEmpty())) {
                    Cleaner rowData = row.getItem();
                    id.setText(rowData.getCleanerID());
                    name.setText(rowData.getCleanerName());
                    phone.setText(rowData.getCleanerPhone());
                    email.setText(rowData.getCleanerEmail());
                    salary.setText(rowData.getCleanerSalary());
                }
            });
            return row;
        });
    }
}