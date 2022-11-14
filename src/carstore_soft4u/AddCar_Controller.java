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

public class AddCar_Controller implements Initializable {

    private DBHandler db;
    private CarData car;

    @FXML
    private TextField carnumber;
    @FXML
    private TextField carowner;
    @FXML
    private TextField ownerID;
    @FXML
    private TextField carmodel;
    @FXML
    private TextField caryear;
    @FXML
    private TextField carcolor;
    @FXML
    private TextArea carnote;
    @FXML
    private TextField pay;

    @FXML
    private Label Error_carnumber;
    @FXML
    private Label Error_carowner;
    @FXML
    private Label Error_ownerID;
    @FXML
    private Label Error_carmodel;
    @FXML
    private Label Error_caryear;
    @FXML
    private Label Error_carcolor;
    @FXML
    private Label Error_carnote;
    @FXML
    private Label Error_pay;
    
    @FXML
    private Button backBT;

    @FXML
    private void Add_Car(ActionEvent event) throws ClassNotFoundException, SQLException {
        if (carnumber.getText().equals("")) {
            Error_carnumber.setText("رقم السيارة فارغ");
            Error_carowner.setText("");
            Error_ownerID.setText("");
            Error_carmodel.setText("");
            Error_caryear.setText("");
            Error_carcolor.setText("");
            Error_carnote.setText("");
            Error_pay.setText("");
        } else {
            if (carowner.getText().equals("")) {
                Error_carnumber.setText("");
                Error_carowner.setText("برجاء ادخال اسم صاحب السيارة");
                Error_ownerID.setText("");
                Error_carmodel.setText("");
                Error_caryear.setText("");
                Error_carcolor.setText("");
                Error_carnote.setText("");
                Error_pay.setText("");
            } else {
                if (ownerID.getText().equals("")) {
                    Error_carnumber.setText("");
                    Error_carowner.setText("");
                    Error_ownerID.setText("برجاء ادخال الرقم القومي");
                    Error_carmodel.setText("");
                    Error_caryear.setText("");
                    Error_carcolor.setText("");
                    Error_carnote.setText("");
                    Error_pay.setText("");
                } else {
                    if (carmodel.getText().equals("")) {
                        Error_carnumber.setText("");
                        Error_carowner.setText("");
                        Error_ownerID.setText("");
                        Error_carmodel.setText("برجاء ادخال موديل السيارة");
                        Error_caryear.setText("");
                        Error_carcolor.setText("");
                        Error_carnote.setText("");
                        Error_pay.setText("");
                    } else {
                        if (caryear.getText().equals("")) {
                            Error_carnumber.setText("");
                            Error_carowner.setText("");
                            Error_ownerID.setText("");
                            Error_carmodel.setText("");
                            Error_caryear.setText("برجاء ادخال عام السيارة");
                            Error_carcolor.setText("");
                            Error_carnote.setText("");
                            Error_pay.setText("");
                        } else {
                            if (carcolor.getText().equals("")) {
                                Error_carnumber.setText("");
                                Error_carowner.setText("");
                                Error_ownerID.setText("");
                                Error_carmodel.setText("");
                                Error_caryear.setText("");
                                Error_carcolor.setText("برجاء ادخال لون السيارة");
                                Error_carnote.setText("");
                                Error_pay.setText("");
                            } else {
                                if (carnote.getText().equals("")) {
                                    Error_carnumber.setText("");
                                    Error_carowner.setText("");
                                    Error_ownerID.setText("");
                                    Error_carmodel.setText("");
                                    Error_caryear.setText("");
                                    Error_carcolor.setText("");
                                    Error_carnote.setText("برجاء ادخال الملاحظات");
                                    Error_pay.setText("");
                                } else {
                                    if (pay.getText().equals("")) {
                                        Error_carnumber.setText("");
                                        Error_carowner.setText("");
                                        Error_ownerID.setText("");
                                        Error_carmodel.setText("");
                                        Error_caryear.setText("");
                                        Error_carcolor.setText("");
                                        Error_carnote.setText("");
                                        Error_pay.setText("برجاء ادخال سعر السيارة");
                                    } else {
                                        if (db.cheeck_car(carnumber.getText())) {
                                            //Reset All Errors
                                            Error_carnumber.setText("");
                                            Error_carowner.setText("");
                                            Error_ownerID.setText("");
                                            Error_carmodel.setText("");
                                            Error_caryear.setText("");
                                            Error_carcolor.setText("");
                                            Error_carnote.setText("");
                                            Error_pay.setText("");
                                            //Sava Data In Class
                                            car.setCarNumber(carnumber.getText());
                                            car.setCarOwner(carowner.getText());
                                            car.setOwnerNationalID(ownerID.getText());
                                            car.setCarModel(carmodel.getText());
                                            car.setCarYear(caryear.getText());
                                            car.setCarColor(carcolor.getText());
                                            car.setCarNotes(carnote.getText());
                                            car.setCarPay(pay.getText());
                                            //Send Data To Data Base
                                            db.Insert_Car(car);
                                            //Reset All Text Failed
                                            carnumber.setText("");
                                            carowner.setText("");
                                            ownerID.setText("");
                                            carmodel.setText("");
                                            caryear.setText("");
                                            carcolor.setText("");
                                            carnote.setText("");
                                            pay.setText("");
                                            
                                        } else {
                                            Error_carnumber.setText("هذه السيارة موجودة بالفعل يمكنك تعديلها من صفحة التعديل");
                                            Error_carowner.setText("");
                                            Error_ownerID.setText("");
                                            Error_carmodel.setText("");
                                            Error_caryear.setText("");
                                            Error_carcolor.setText("");
                                            Error_carnote.setText("");
                                            Error_pay.setText("");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    @FXML
    private void back_Page(ActionEvent event) throws IOException {
        System.out.println("Load Add Car!");
        Stage stage = (Stage) backBT.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Admin_Page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Car Store");
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = new DBHandler();
        db.getConnection();
        car = new CarData();
    }

}
