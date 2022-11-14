package carstore_soft4u;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class Admin_Controller_Page implements Initializable {

    private DBHandler db;
    private Admin ad;
    @FXML
    private Button addST;
    @FXML
    private Button LogoutBT;
    @FXML
    private Button AddBT;
    @FXML
    private Label Name;
    @FXML
    private Label updatePassword;
    @FXML
    private Label currentError;
    @FXML
    private Label NewError;
    @FXML
    private Label ConfirmError;
    @FXML
    private PasswordField current_password;
    @FXML
    private PasswordField new_password;
    @FXML
    private PasswordField confirm_new_password;

    @FXML
    private void Change_Password(ActionEvent event) throws SQLException {
        if (current_password.getText().equals("")) {
            ConfirmError.setText("");
            currentError.setText("كلمة السر الحالية فارغة!");
            NewError.setText("");
            updatePassword.setText("");
        } else {
            if (!(current_password.getText().equals(ad.getPassword()))) {
                ConfirmError.setText("");
                currentError.setText("كلمة السر الحالية خاطئة");
                NewError.setText("");
                updatePassword.setText("");
            } else {
                if (new_password.getText().equals("")) {
                    ConfirmError.setText("");
                    currentError.setText("");
                    NewError.setText("كلمة السر الجديدة فارغة!");
                    updatePassword.setText("");
                } else {
                    if (confirm_new_password.getText().equals("")) {
                        ConfirmError.setText("برجاء تاكيد كلمة السر");
                        currentError.setText("");
                        NewError.setText("");
                        updatePassword.setText("");
                    } else {
                        if (!(confirm_new_password.getText().equals(new_password.getText()))) {
                            ConfirmError.setText("غير متطابقة");
                            currentError.setText("");
                            NewError.setText("غير متطابقة");
                            updatePassword.setText("");
                        } else {
                            ConfirmError.setText("");
                            currentError.setText("");
                            NewError.setText("");
                            db.update_Admin_Password(confirm_new_password.getText(), ad.getEmail());
                            ad.setPassword(confirm_new_password.getText());
                            confirm_new_password.setText("");
                            new_password.setText("");
                            current_password.setText("");
                            updatePassword.setText("تم تحديث كلمة السر!");
                        }
                    }
                }
            }
        }
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        System.out.println("LogOut From Admin!");
        Stage stage = (Stage) LogoutBT.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("login_page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Car Store");
        stage.show();
    }
    
    @FXML
    private void Add_Car(ActionEvent event) throws IOException{
        System.out.println("Load Add Car!");
        Stage stage = (Stage) LogoutBT.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("AddCar_page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Car Store");
        stage.show();
    }
    @FXML
    private void Add_Stuff(ActionEvent event) throws IOException{
        System.out.println("Load Add Stuff Page!");
        Stage stage = (Stage) LogoutBT.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("AddStuff_page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Car Store");
        stage.show();
    }
    @FXML
    private Button delBT;
    @FXML
    private void Delete(ActionEvent event) throws IOException{
        System.out.println("Load Delete Stuff Page!");
        Stage stage = (Stage) delBT.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("del_Stuff.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Car Store");
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = new DBHandler();
        db.getConnection();
        try {
            ad = db.Get_Admin();
            Name.setText(ad.getName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin_Controller_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
