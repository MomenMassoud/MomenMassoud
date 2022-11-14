package supermarket;

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

public class ControllerPage implements Initializable {

    Admin admin = new Admin();
    DBHandler db;
    @FXML
    PasswordField password;
    @FXML
    PasswordField Newpassword;
    @FXML
    PasswordField ConfirmNewpassword;
    @FXML
    Label Name;
    @FXML
    Label Errorpass;
    @FXML
    Label ErrorNewpass;
    @FXML
    Label ErrorConfirmNewpass;
    @FXML
    Label mas;

    @FXML
    private void change_Pass(ActionEvent event) throws SQLException {
        if (password.getText().equals("")) {
            Errorpass.setText("كلمة السر فارغة");
            ErrorNewpass.setText("");
            ErrorConfirmNewpass.setText("");
        } else {
            if (!(password.getText().equals(admin.getPass()))) {
                Errorpass.setText("كلمة السر غير صحيحة");
                ErrorNewpass.setText("");
                ErrorConfirmNewpass.setText("");
            } else {
                if (Newpassword.getText().equals("")) {
                    Errorpass.setText("");
                    ErrorNewpass.setText("كلمة السر الجديدة فارغة");
                    ErrorConfirmNewpass.setText("");
                } else {
                    if (ConfirmNewpassword.getText().equals("")) {
                        Errorpass.setText("");
                        ErrorNewpass.setText("");
                        ErrorConfirmNewpass.setText("تاكيد كلمة السر فارغ");
                    } else {
                        if (!(Newpassword.getText().equals(ConfirmNewpassword.getText()))) {
                            Errorpass.setText("");
                            ErrorNewpass.setText("كلمة السر الجديدة غير متساوية");
                            ErrorConfirmNewpass.setText("كلمة السر الجديدة لا تساويها");
                        } else {
                            db.getConnection();
                            db.con(ConfirmNewpassword.getText(), admin.getEmail());
                            admin.setPass(ConfirmNewpassword.getText());
                            mas.setText("تم تحديث كلمة السر بنجاح");
                            Errorpass.setText("");
                            ErrorNewpass.setText("");
                            ErrorConfirmNewpass.setText("");
                            password.setText("");
                            Newpassword.setText("");
                            ConfirmNewpassword.setText("");
                        }
                    }
                }
            }
        }
    }
    @FXML
    Button log;
    @FXML
    Button casher;
    @FXML
    private void Chash(ActionEvent event) throws IOException {
        Stage stage = (Stage) log.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("home_page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Freska Super Market");
        stage.show();
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Stage stage = (Stage) log.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Freska Super Market");
        stage.show();
    }
    @FXML
    Button add;
    @FXML
    private void addNew(ActionEvent event) throws IOException {
        Stage stage = (Stage) add.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("add_item_page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Freska Super Market");
        stage.show();
    }
    
    @FXML
    Button view;
    @FXML
    private void view_Items(ActionEvent event) throws IOException{
        Stage stage = (Stage) view.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("tableview_page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Freska Super Market");
        stage.show();
    }
    @FXML
    Button viewIN;
    @FXML
    private void View_INvoic(ActionEvent event) throws IOException{
        Stage stage = (Stage) viewIN.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("reset_page.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Freska Super Market");
            stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = new DBHandler();
        db.getConnection();
        try {
            admin = db.get_admin();
            Name.setText("مرحبا" + ":" + admin.getName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerPage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
