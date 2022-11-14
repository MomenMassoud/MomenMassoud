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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TableView_Controller implements Initializable {

    DBHandler db = new DBHandler();
    int len;
    @FXML
    Button back;
    @FXML
    Button add;
    @FXML
    private TableView<ItemsView> tab;
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
    private void Action(ActionEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("con_page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Freska Super Market");
        stage.show();
    }
    
    @FXML
    Label TotalCash;

    @FXML
    private void Add_item(ActionEvent event) throws IOException {
        Stage stage = (Stage) add.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("add_item_page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Freska Super Market");
        stage.show();
    }
    ItemsView it[];
    final ObservableList<ItemsView> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Double cash=0.0;
        db.getConnection();
        try {
            len = db.counter();
            it = new ItemsView[len];
            it = db.get_Allitem();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TableView_Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TableView_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        id.setCellValueFactory(new PropertyValueFactory<ItemsView, String>("id"));
        name.setCellValueFactory(new PropertyValueFactory<ItemsView, String>("name"));
        qty.setCellValueFactory(new PropertyValueFactory<ItemsView, String>("qty"));
        price.setCellValueFactory(new PropertyValueFactory<ItemsView, String>("price"));
        total.setCellValueFactory(new PropertyValueFactory<ItemsView, String>("total"));
        tab.setItems(data);
        for (int i = 0; i < len; i++) {
            tab.getItems().add(it[i]);
            cash+=Double.parseDouble(it[i].getTotal());
        }
        TotalCash.setText(String.valueOf(cash));
    }

}
