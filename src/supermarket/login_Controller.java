package supermarket;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class login_Controller implements Initializable {
    private String password;
    private String Email;
    @FXML
    TextField email;
    @FXML
    PasswordField pass;
    @FXML
    Button login;
    @FXML
    Label error;
    @FXML
    private void Login_Method(ActionEvent event) throws IOException{
        if(email.getText().equals("")){
            error.setText("ناسف برجاء ادخال البريد الالكتروني");
        }
        else if(pass.getText().equals("")){
            error.setText("ناسف برجاء ادخال كلمة السر");
        }
        else if(!(email.getText().equals(Email))){
            error.setText("ناسف البريد الالكتروني خاطء");
        }
        else if(!(pass.getText().equals(password))){
            error.setText("ناسف كلمة السر المدخلة خاطئة");
        }else{
            Stage stage = (Stage) login.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("con_page.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Freska Super Market");
            stage.show();
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DBHandler db=new DBHandler();
        db.getConnection();
        Admin ad=new Admin();
        try {
            ad=db.get_admin();
            Email=ad.getEmail();
            password=ad.getPass();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
