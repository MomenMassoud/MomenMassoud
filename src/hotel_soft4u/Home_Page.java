package hotel_soft4u;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Home_Page implements Initializable {
    public static String LoginEmail;
    public static String LoginPassword;
    private PreparedStatement pst;
    DBHandler db = new DBHandler();
    @FXML
    TextField email;
    @FXML
    PasswordField password;
    @FXML
    Label error;

    Admin adminstrator = new Admin();
    public static Staff staff[];

    @FXML
    Button logAdmin;
    @FXML
    Button logoutStuff;
    @FXML
    Label name;
    @FXML
    private void loginASAdmin(ActionEvent event) throws ClassNotFoundException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/hotel", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from admin ");
            System.out.println("Done");
            while (rs.next()) {
                adminstrator.setEmail(rs.getString("email"));
                adminstrator.setPassword(rs.getString("password"));
                adminstrator.setName(rs.getString("Name"));

            }
        } catch (SQLException e) {
            System.out.println("No");
        }
        if (email.getText().equalsIgnoreCase(adminstrator.getEmail()) && password.getText().equalsIgnoreCase(adminstrator.getPassword())) {
            System.out.println("Welcome Admin");
            Stage stage = (Stage) logAdmin.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("adminCon.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Hotel System");
            stage.show();
        } else {
            error.setText("Email Or Password Wrong");
        }
    }

    private int counter() throws ClassNotFoundException, SQLException {
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/hotel", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(email) as count_stuff FROM stuff");
            System.out.println("Done");
            while (rs.next()) {
                count = Integer.parseInt(rs.getString("count_stuff"));
                System.out.println("Count = " + count);
            }
        } catch (SQLException e) {

        }
        //SELECT COUNT(id) as count_pet FROM pet;
        return count;
    }

    @FXML
    private void loginASstuff(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        int i = 0;
        int c = counter();
        staff = new Staff[c];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/hotel", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from stuff");
            System.out.println("Done");
            while (rs.next()) {
                staff[i] = new Staff();
                staff[i].setEmail(rs.getString("email"));
                staff[i].setPassword(rs.getString("password"));
                staff[i].setFirstName(rs.getString("firstname"));
                staff[i].setLastName(rs.getString("lastname"));
                staff[i].setID(rs.getString("id"));
                staff[i].setNationalID(rs.getString("NationalID"));
                staff[i].setNationalID_picutre(rs.getString("NationalID_picutre"));
                staff[i].setGender(rs.getString("Gender"));
                staff[i].setSalary(rs.getString("Salary"));
                staff[i].setAge(rs.getString("Age"));
                staff[i].setAddress(rs.getString("Address"));
                staff[i].setPhoneNumber(rs.getString("PhoneNumber"));
                staff[i].setJop(rs.getString("Jop"));
                i++;
            }
        } catch (SQLException e) {
            System.out.println("No");
        }
        for (int j = 0; j < i; j++) {
            if (email.getText().equalsIgnoreCase(staff[j].getEmail())) {
                if (password.getText().equalsIgnoreCase(staff[j].getPassword())) {
                    if (staff[j].getJop().equalsIgnoreCase("resepshen")) {
                        LoginEmail=staff[j].getEmail();
                        LoginPassword=staff[j].getPassword();
                        Stage stage = (Stage) logoutStuff.getScene().getWindow();
                        stage.close();
                        Parent root = FXMLLoader.load(getClass().getResource("stuffCon.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setTitle("Hotel System");
                        stage.show();
                    }

                }
            }
        }
    }

    @FXML
    Button logStuff;

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Stage stage = (Stage) logStuff.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hotel System");
        stage.show();
    }
    @FXML
    Label Serror;
    @FXML
    Label nSerror;
    @FXML
    Label cnSerror;
    @FXML
    PasswordField Spass;
    @FXML
    PasswordField nSpass;
    @FXML
    PasswordField cnSpass;
    @FXML
    Button updatepass;
    
    @FXML
    Button close;
    
    @FXML
    private void closeChangePassword(ActionEvent event) throws IOException{
         Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("pass_stuff.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hotel System");
        stage.show();
    }
    
    @FXML
    private void changePassword(ActionEvent event) throws SQLException, IOException{
        if(Spass.getText().equals("")){
            Serror.setText("Current Password Is Empty!");
            nSerror.setText("");
            cnSerror.setText("");
        }
        else if(!(Spass.getText().equals(LoginPassword))){
            System.out.println(LoginPassword);
            Serror.setText("Current Password Is Valid!");
            nSerror.setText("");
            cnSerror.setText("");
        }
        else if(nSpass.getText().equals("")){
            nSerror.setText("New Password Is Empty!");
            Serror.setText("");
        }
        else if(cnSpass.getText().equals("")){
            cnSerror.setText("Confirm New Password Is Empty!");
            Serror.setText("");
        }
        else if(!(nSpass.getText().equals(cnSpass.getText()))){
            nSerror.setText("Not Equl");
            cnSerror.setText("Not Equl");
            Serror.setText("");
        }
        else{
            db.getConnection();
            db.conStuff(cnSpass.getText(), LoginEmail);
            Stage stage = (Stage) updatepass.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("stuffCon.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hotel System");
        stage.show();
        }
    }
    
    @FXML
    Button cout;
    //"cheeck_out_client"
    
    
    @FXML
    private void cheeckOUT(ActionEvent event) throws IOException{
        Stage stage = (Stage) cout.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("cheeck_out.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hotel System");
        stage.show();
    }
    
    @FXML
    Button add_client;
    
    
    @FXML
    private void cheeckIN(ActionEvent event) throws IOException{
        Stage stage = (Stage) add_client.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("add_client.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hotel System");
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
