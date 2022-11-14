package carstore_soft4u;

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;

public class Login_Controller implements Initializable {

    private DBHandler db;
    @FXML
    private Button loginAd;
    @FXML
    private TextField email;
    @FXML
    private PasswordField pass;
    @FXML
    private Label emailError;
    @FXML
    private Label passError;

    @FXML
    private void Admin_Login(ActionEvent event) throws ClassNotFoundException, IOException {
        if (email.getText().equals("")) {
            emailError.setText("البريد الالكتروني فارغ!");
            passError.setText("");
        } else {
            if (pass.getText().equals("")) {
                passError.setText("كلمة السر فارغة!");
                emailError.setText("");
            } else {
                emailError.setText("");
                passError.setText("");
                if (db.cheeckEmail_Admin(email.getText())) {
                    if (db.cheeckPassword_Admin(email.getText(), pass.getText())) {
                        System.out.println("Welcome Admin!");
                        Stage stage = (Stage) loginAd.getScene().getWindow();
                        stage.close();
                        Parent root = FXMLLoader.load(getClass().getResource("Admin_Page.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setTitle("Car Store");
                        stage.show();
                    } else {
                        passError.setText("كلمة السر خاطئة");
                    }

                } else {
                    emailError.setText("البريد الالكتروني غير موجود");
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        db = new DBHandler();
        db.getConnection();
    }

}
