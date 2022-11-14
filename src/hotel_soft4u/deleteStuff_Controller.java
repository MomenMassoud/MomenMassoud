package hotel_soft4u;

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;

public class deleteStuff_Controller implements Initializable {

    DBHandler db = new DBHandler();

    @FXML
    TextField id;
    @FXML
    Label iderror;
    @FXML
    Button delete;
    @FXML
    Button back;

    @FXML
    private void action(ActionEvent event) throws SQLException, IOException {
        if (id.getText().equals("")) {
            iderror.setText("ID Is Empty");
        } else {
            iderror.setText("");
            db.getConnection();
            db.del_stuff(id.getText());
            Stage stage = (Stage) delete.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("adminCon.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Hotel System");
            stage.show();
        }
    }
    
    @FXML
    private void back_page(ActionEvent event) throws IOException{
        Stage stage = (Stage) back.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("adminCon.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Hotel System");
            stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //To change body of generated methods, choose Tools | Templates.
    }

}
