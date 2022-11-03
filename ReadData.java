import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class ReadData extends Application {
    private static Stage window;
    public static String userid;
    public static String userteam;
    public static ArrayList < Manager > managerArrayList;
    public static ArrayList < Cleaner > cleanerArrayList;
    public static ArrayList < Appointment > appointmentArrayList;
    public static Appointment selectedAppointment;
    
    @Override
    public void start(Stage stage) throws FileNotFoundException, IOException {
        window = stage;
        loadData();
        switchScene("Login");
        stage.setTitle("Cleaning Company System");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    //for reading data
    public static void loadData() throws FileNotFoundException {
        String[] line;
        File managerFile = new File("Manager.csv");
        File cleanerFile = new File("Cleaner.csv");
        File appointmentFile = new File("Appointment.csv");
        managerArrayList = new ArrayList < > ();
        cleanerArrayList = new ArrayList < > ();
        appointmentArrayList = new ArrayList < > ();
        Scanner scanner0 = new Scanner(managerFile);
        Scanner scanner1 = new Scanner(cleanerFile);
        Scanner scanner2 = new Scanner(appointmentFile);
        //skip first line
        line = scanner0.nextLine().split(",");
        while (scanner0.hasNextLine()) {
            line = scanner0.nextLine().split(",");
            Manager m = new Manager(line[0], line[1], line[2], line[3]);
            managerArrayList.add(m);
        }
        scanner0.close();

        line = scanner1.nextLine().split(",");
        while (scanner1.hasNextLine()) {
            line = scanner1.nextLine().split(",");
            Cleaner c = new Cleaner(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8]);
            cleanerArrayList.add(c);
        }
        scanner1.close();

        line = scanner2.nextLine().split(",");
        while (scanner2.hasNextLine()) {
            line = scanner2.nextLine().split(",");
            Appointment a = new Appointment(line[0], line[1], line[2], convertComma(line[3], 0), line[4], line[5], line[6], line[7], line[8], line[9]);
            appointmentArrayList.add(a);
        }
        scanner2.close();

    }
    public static void updateCleanerCSV() throws IOException {
        // write back staff data 
        File file = new File("Cleaner.csv");
        // creates the file 
        file.createNewFile();
        // creates a FileWriter Object 
        try (FileWriter writer = new FileWriter(file)) {
            // Writes the content to the file 
            String cleanerHeader = "ID,Name,Password,Team,Phone,Email,Salary, Working Hour,Total Salary,Rank\n";
            writer.write(cleanerHeader);
            for (Cleaner c: cleanerArrayList) {
                writer.write(c.getCleanerID() + "," +
                    c.getCleanerName() + "," +
                    c.getCleanerPassword() + "," +
                    c.getCleanerTeam() + "," +
                    c.getCleanerPhone() + "," +
                    c.getCleanerEmail() + "," +
                    c.getCleanerSalary() + "," +
                    c.getCleanerWorkingHour() + "," +
                    c.getCleanerTotalSalary() + "," +
                    c.getCleanerRank() +
                    "\n");

            }

            writer.flush();
            writer.close();
        }
    }

    public static String convertComma(String s, int mode) {//Convert comma for input address in csv
        String f = "";
        if (mode == 1) {
            String[] temp = s.split(",");
            for (String t: temp) {
                f += t + "&";
            }
        } else {
            String[] temp = s.split("&");
            for (String t: temp) {
                f += t + ",";
            }
        }

        return f.substring(0, f.length() - 1);
    }


    public static void updateAppointmentCSV() throws IOException {
        // write back appointment data 
        File file1 = new File("Appointment.csv");
        // creates the file
        file1.createNewFile();
        // creates a FileWriter Object 
        try (FileWriter writer1 = new FileWriter(file1)) {
            // Writes the content to the file 
            String appointmentHeader = "Appointment_ID,Customer_Name,Customer_Phone,Customer_Address,Appointment_Date,Appointment_Time,Appointment_Duration,Appointment_Staff,Appointment_Amount,Appointment_Status\n";

            writer1.write(appointmentHeader);
            for (Appointment a: appointmentArrayList) {
                writer1.write(a.getAppointmentID() + "," +
                    a.getCustomerName() + "," +
                    a.getCustomerPhone() + "," +
                    convertComma(a.getCustomerAddress(), 1) + "," +
                    a.getAppointmentDate() + "," +
                    a.getAppointmentTime() + "," +
                    a.getAppointmentDuration() + "," +
                    a.getAppointmentStaff() + "," +
                    a.getAppointmentAmount() + "," +
                    a.getAppointmentStatus() +
                    "\n");

            }

            writer1.flush();
            writer1.close();

        }
    }


    public static void switchScene(String name) throws IOException {
        Parent root = FXMLLoader.load(ReadData.class.getResource(name + ".fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
    }

    public static ArrayList < Cleaner > sortBySalary() {//Sort salary to get rank
        ArrayList < Cleaner > cleaner_sorted = new ArrayList < Cleaner > ();
        for (Cleaner c: cleanerArrayList) {
            cleaner_sorted.add(new Cleaner(c));
        }

        for (int i = 1; i < cleaner_sorted.size(); i++) {
            Cleaner current = cleaner_sorted.get(i);
            int j = i - 1;
            while (j >= 0 && Float.parseFloat(current.getCleanerTotalSalary()) > Float.parseFloat(cleaner_sorted.get(j).getCleanerTotalSalary())) {
                cleaner_sorted.set(j + 1, cleaner_sorted.get(j));
                j--;
            }
            cleaner_sorted.set(j + 1, current);
        }
        return cleaner_sorted;
    }


}