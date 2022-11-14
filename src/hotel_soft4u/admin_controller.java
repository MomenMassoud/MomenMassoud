package hotel_soft4u;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javafx.stage.Stage;

public class admin_controller implements Initializable {

    String password;
    String email;
    private DBHandler db = new DBHandler();
    @FXML
    Label currentpass;
    @FXML
    Label newpass;
    @FXML
    Label cnewpass;
    @FXML
    PasswordField cpass;
    @FXML
    PasswordField npass;
    @FXML
    PasswordField cnpass;
    @FXML
    private void Update_pass(ActionEvent event) throws ClassNotFoundException, IOException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/hotel", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from admin ");
            System.out.println("Done");
            while (rs.next()) {
                email = (rs.getString("email"));
                password = (rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("No");
        }
        if (cpass.getText().equals("")) {
            currentpass.setText("Current Password Empty!");
            newpass.setText("");
            cnewpass.setText("");
        } else if (!(cpass.getText().equalsIgnoreCase(password))) {
            currentpass.setText("Current Password Vaild!");
            newpass.setText("");
            cnewpass.setText("");
        } else if (npass.getText().equals("")) {
            newpass.setText("New Password Is Empty!");
            currentpass.setText("");
        } else if (cnpass.getText().equals("")) {
            cnewpass.setText("Confirm New Password if Empty!");
            currentpass.setText("");
        } else if (!(cnpass.getText().equals(npass.getText()))) {
            newpass.setText("Not Equl");
            cnewpass.setText("Not Equl");
            currentpass.setText("");
        } else {
            currentpass.setText("");
            newpass.setText("");
            cnewpass.setText("");
            db.getConnection();
            db.con(cnpass.getText(), email);
        }
    }

    @FXML
    Button logout;
    @FXML
    Button adds;
    @FXML
    Button del;
    @FXML
    Button viewroom;

    @FXML
    private void log(ActionEvent event) throws IOException {
        Stage stage = (Stage) logout.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hotel System");
        stage.show();
    }
    
    
    @FXML
    private void addSt(ActionEvent event) throws IOException{
        Stage stage = (Stage) adds.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("add_stuff.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hotel System");
        stage.show();
    }
    
    @FXML
    private void removeSt(ActionEvent event) throws IOException{
        Stage stage = (Stage) del.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("delete_stuff.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hotel System");
        stage.show();
    }
    
    @FXML
    private void viewRoom(ActionEvent event) throws IOException{
        Stage stage = (Stage) viewroom.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("empty_room.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hotel System");
        stage.show();
    }
    
    @FXML
    private void viewClient(ActionEvent event) throws IOException{
        Stage stage = (Stage) viewroom.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("viewClient.fxml"));
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
