package supermarket;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class invoice_Controller implements Initializable {

    DBHandler db = new DBHandler();
    @FXML
    TextField inNumber;
    @FXML
    private TableView<ItemsView> tab;
    @FXML
    private TableView<pay> tab2;
    @FXML
    private TableColumn<ItemsView, String> id;
    @FXML
    private TableColumn<ItemsView, String> name;
    @FXML
    private TableColumn<ItemsView, String> qty;
    @FXML
    private TableColumn<ItemsView, String> price;
    @FXML
    private TableColumn<ItemsView, String> total;
    @FXML
    private TableColumn<pay, String> id2;
    @FXML
    private TableColumn<pay, String> payment;
    @FXML
    private TableColumn<pay, String> balance;
    @FXML
    private TableColumn<pay, String> totalDATE;
    @FXML
    private TableColumn<pay, String> DATETABLE;
    @FXML
    DatePicker date;
    @FXML
    Label Error;
    @FXML
    Button back;

    @FXML
    private void Action_Back(ActionEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("con_page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Freska Super Market");
        stage.show();
    }

    @FXML
    private void Action(ActionEvent event) throws ClassNotFoundException, SQLException {
        if (inNumber.getText().equals("")) {
            Error.setText("فارغ");
        } else {
            Error.setText("");
            int lens = db.counter_Item_Pay();
            ItemsView it[] = new ItemsView[lens];
            it = db.get_item_pay(inNumber.getText());
            for (int i = 0; i < lens; i++) {
                if (it[i].invoic.equals(inNumber.getText())) {
                    tab.getItems().add(it[i]);
                }
            }
        }
    }
    int len;
    final ObservableList<ItemsView> data = FXCollections.observableArrayList();
    final ObservableList<pay> data2 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db.getConnection();

        try {
            len = db.counterPay();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(invoice_Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(invoice_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        pay hh[] = new pay[len];
        try {
            hh = db.getALLINVOICE();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(invoice_Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(invoice_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Conf Table 1
        id.setCellValueFactory(new PropertyValueFactory<ItemsView, String>("id"));
        name.setCellValueFactory(new PropertyValueFactory<ItemsView, String>("name"));
        qty.setCellValueFactory(new PropertyValueFactory<ItemsView, String>("qty"));
        price.setCellValueFactory(new PropertyValueFactory<ItemsView, String>("price"));
        total.setCellValueFactory(new PropertyValueFactory<ItemsView, String>("total"));
        tab.setItems(data);
        //Conf Table2
        id2.setCellValueFactory(new PropertyValueFactory<pay, String>("id"));
        payment.setCellValueFactory(new PropertyValueFactory<pay, String>("Pay"));
        balance.setCellValueFactory(new PropertyValueFactory<pay, String>("Balance"));
        totalDATE.setCellValueFactory(new PropertyValueFactory<pay, String>("Total"));
        DATETABLE.setCellValueFactory(new PropertyValueFactory<pay, String>("Date"));
        tab2.setItems(data2);
        for (int i = 0; i < len; i++) {
            tab2.getItems().add(hh[i]);
        }

    }

}
