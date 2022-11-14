package supermarket;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class add_item_Controller implements Initializable {

    DBHandler db;
    @FXML
    Button back;
    @FXML
    TextField NewpdID;
    @FXML
    TextField Newpdname;
    @FXML
    TextField Newpdprice;
    @FXML
    TextField NewpdQTY;
    @FXML
    TextField pdQTY;
    @FXML
    TextField pdprice;
    @FXML
    TextField pdID;
    @FXML
    Label mas1;
    @FXML
    Label mas2;
    @FXML
    Label Error1;
    @FXML
    Label Error2;
    @FXML
    Label Error3;
    @FXML
    Label Error4;
    @FXML
    Label Error5;
    @FXML
    Label Error6;
    @FXML
    Label Error7;

    @FXML
    private void Add_New(ActionEvent event) throws SQLException {
        if (NewpdID.getText().equals("")) {
            Error1.setText("برجاء ادخال رقم المنتج الجديد");
            Error2.setText("");
            Error3.setText("");
            Error4.setText("");
        } else {
            if (Newpdname.getText().equals("")) {
                Error1.setText("");
                Error2.setText("برجاء ادخال اسم المنتج الجديد");
                Error3.setText("");
                Error4.setText("");
            } else {
                if (Newpdprice.getText().equals("")) {
                    Error1.setText("");
                    Error2.setText("");
                    Error3.setText("برجاء ادخال سعر المنتج الجديد");
                    Error4.setText("");
                } else {
                    if (NewpdQTY.getText().equals("")) {
                        Error1.setText("");
                        Error2.setText("");
                        Error3.setText("");
                        Error4.setText("برجاء ادخال كمية المنتج الجديد");
                    } else {
                        Error1.setText("");
                        Error2.setText("");
                        Error3.setText("");
                        Error4.setText("");
                        db.getConnection();
                        db.insert_item(NewpdID.getText(), Newpdname.getText(), Newpdprice.getText(), NewpdQTY.getText());
                        NewpdID.setText("");
                        Newpdname.setText("");
                        Newpdprice.setText("");
                        NewpdQTY.setText("");
                        mas1.setText("تم اضافة العنصر الجديد");
                    }
                }
            }
        }
    }

    @FXML
    private void Edit_Item(ActionEvent event) throws SQLException {
        if (pdID.getText().equals("")) {
            Error5.setText("برجاء ادخال رقم المنتج المراد تعديله");
            Error6.setText("");
            Error7.setText("");
        } else {
            if (pdQTY.getText().equals("")) {

                Error5.setText("");
                Error6.setText("برجاء ادخال الكمية الجديدة للمنتج");
                Error7.setText("");
            } else {
                if (pdprice.getText().equals("")) {
                    Error5.setText("");
                    Error6.setText("");
                    Error7.setText("برجاء ادخال السعر الجديد للمنتج");
                } else {
                    Error5.setText("");
                    Error6.setText("");
                    Error7.setText("");
                    db.getConnection();
                    db.update_Item(pdID.getText(), pdprice.getText(), pdQTY.getText());
                    pdID.setText("");
                    pdQTY.setText("");
                    pdprice.setText("");
                    mas2.setText("تم تعديل المنتج بنجاح");
                }
            }
        }
    }

    @FXML
    private void set_data(ActionEvent event) throws ClassNotFoundException {
        db.getConnection();
        Item it = new Item();
        it = db.get_item(pdID.getText());
        pdQTY.setText(it.getCount());
        pdprice.setText(it.getProductPrice());
    }

    @FXML
    private void Back_Page(ActionEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("con_page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Freska Super Market");
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = new DBHandler();
        db.getConnection();
    }

}
