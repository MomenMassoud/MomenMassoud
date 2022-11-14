package supermarket;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class home_page_Controller implements Initializable {
    Double countPrice=0.0;
    String cItem="0";
    DBHandler db = new DBHandler();
    String qr;
    String namepd;
    String Pricepd;
    String QTYpd;
    String totalpd;
    @FXML
    TextField pdCode;
    @FXML
    TextField pdName;
    @FXML
    TextField pdQty;
    @FXML
    TextField pdPrice;
    @FXML
    TextField pdTotal;
    @FXML
    TextField Total;
    @FXML
    TextField Pay;
    @FXML
    TextField Balance;
    @FXML
    Button Add;
    @FXML
    Button PrintBill;
    @FXML
    Button exitBT;
    @FXML
    private TableView<TabelData> tab;
    @FXML
    private TableColumn<TabelData, String> id;
    @FXML
    private TableColumn<TabelData, String> couItem;
    @FXML
    private TableColumn<TabelData, String> name;
    @FXML
    private TableColumn<TabelData, String> qty;
    @FXML
    private TableColumn<TabelData, String> price;
    @FXML
    private TableColumn<TabelData, String> totalTB;

    @FXML
    private void Add_item(ActionEvent event) throws ClassNotFoundException, SQLException {
        db.getConnection();
        Item it = new Item();
        it = db.get_item(pdCode.getText());
        pdName.setText(it.getProductName());
        pdPrice.setText(it.getProductPrice());
        double total;
        pdQty.setText("1");
        total = Double.parseDouble(pdQty.getText()) * Double.parseDouble(pdPrice.getText());
        String txt = String.valueOf(total);
        pdTotal.setText(txt);
        
        
    }
    final ObservableList<TabelData> data = FXCollections.observableArrayList();
    String last[]=new String[100];
    int COUtReturn=0;
    @FXML
    private void save_Table(ActionEvent event) {
        int it=Integer.parseInt(cItem);
        it++;
        cItem=String.valueOf(it);
        TabelData hh = new TabelData(cItem,pdCode.getText(), pdName.getText(), pdQty.getText(), pdPrice.getText(), pdTotal.getText());
        System.out.println("Add");
        System.out.println(pdPrice.getText());
        tab.getItems().add(hh);
        countPrice+=Double.parseDouble(pdTotal.getText());
        Total.setText(String.valueOf(countPrice));
        last[it]=pdTotal.getText();
        System.out.println(last[it]);
        pdName.setText("");
        pdCode.setText("");
        pdPrice.setText("");
        pdQty.setText("");
        pdTotal.setText("");

    }
    
    
    @FXML
    private void del(ActionEvent event){
        int c=Integer.parseInt(cItem);
        System.out.println(last[c]);
        String txt=last[c];
        c--;
        tab.getItems().remove(c);
        cItem=String.valueOf(c);
        Double priceReturn=Double.parseDouble(Total.getText())-Double.parseDouble(txt);
        COUtReturn--;
        Total.setText(String.valueOf(priceReturn));
        countPrice=Double.parseDouble(Total.getText());
    }

    @FXML
    private void Add_qty(ActionEvent event) throws ClassNotFoundException {
        double total;
        total = Double.parseDouble(pdQty.getText()) * Double.parseDouble(pdPrice.getText());
        String txt = String.valueOf(total);
        pdTotal.setText(txt);
    }

    @FXML
    private void print_item(ActionEvent event) {
        
    }

    @FXML
    private void EXIT(ActionEvent event) throws IOException {
        Stage stage = (Stage) exitBT.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("con_page.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Freska Super Market");
            stage.show();
    }

    @FXML
    private void Calc(ActionEvent event) {
        Double p = Double.parseDouble(Pay.getText());
        p = p - Double.parseDouble(Total.getText());
        Balance.setText(String.valueOf(p));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setCellValueFactory(new PropertyValueFactory<TabelData, String>("ID"));
        couItem.setCellValueFactory(new PropertyValueFactory<TabelData, String>("cou"));
        name.setCellValueFactory(new PropertyValueFactory<TabelData, String>("Name"));
        qty.setCellValueFactory(new PropertyValueFactory<TabelData, String>("QTY"));
        price.setCellValueFactory(new PropertyValueFactory<TabelData, String>("Salary"));
        totalTB.setCellValueFactory(new PropertyValueFactory<TabelData, String>("total"));
        tab.setItems(data);
    }

}
