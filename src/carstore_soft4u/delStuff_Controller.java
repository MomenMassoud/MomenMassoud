package carstore_soft4u;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class delStuff_Controller implements Initializable{
    private DBHandler db;
    @FXML
    private Label error;
    @FXML
    private Label mas;
    @FXML
    private TextField id;
    @FXML
    private TextArea data;
    @FXML
    private Button backBT;
    @FXML
    private void ShowData(ActionEvent event) throws ClassNotFoundException{
        if(id.getText().equals("")){
            error.setText("برجاء ادخال كود الموظف!");
            mas.setText("");
        }
        else{
            if(db.cheeckIDStuff(id.getText())){
                error.setText("");
            }
            else{
                error.setText("كود الموظف غير موجود");
                mas.setText("");
            }
        }
    }
    
    @FXML
    private void delete(ActionEvent event) throws ClassNotFoundException, SQLException{
        if(id.getText().equals("")){
            error.setText("برجاء ادخال كود الموظف!");
            mas.setText("");
        }
        else{
            if(db.cheeckIDStuff(id.getText())){
                error.setText("");
                db.del_Stuff(id.getText());
                data.setText("");
                id.setText("");
                mas.setText("تم جذف الموظف بنجاح");
            }
            else{
                error.setText("كود الموظف غير موجود");
                mas.setText("");
            }
        }
    }
    @FXML
    private void BackPage(ActionEvent event) throws IOException{
        Stage stage = (Stage) backBT.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("del_Stuff.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Car Store");
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         //To change body of generated methods, choose Tools | Templates.
    }
    
}
