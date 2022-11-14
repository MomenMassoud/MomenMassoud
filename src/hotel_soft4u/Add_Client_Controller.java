package hotel_soft4u;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Add_Client_Controller implements Initializable {

    public static Room rm[];
    int len;
    private int counter() throws ClassNotFoundException, SQLException {
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/hotel", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(id) as count_stuff FROM room");
            System.out.println("Done");
            while (rs.next()) {
                count = Integer.parseInt(rs.getString("count_stuff"));
                System.out.println("Count = " + count);
            }
        } catch (SQLException e) {

        }
        len=count;
        //SELECT COUNT(id) as count_pet FROM pet;
        return count;
    }

    private void getrooms() throws ClassNotFoundException, SQLException {
        int i = 0;
        int c = counter();
        rm = new Room[c];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/hotel", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from room");
            System.out.println("Done");
            while (rs.next()) {
                rm[i] = new Room();
                rm[i].setNumber_room(Integer.parseInt(rs.getString("id")));
                rm[i].setEmpty(Integer.parseInt(rs.getString("empty")));
                rm[i].setSize(Integer.parseInt(rs.getString("size")));
                rm[i].setSalary(Double.parseDouble(rs.getString("salary")));
                i++;
            }
            System.out.println("Rooms="+i);
        } catch (SQLException e) {
            System.out.println("No");
        }
    }

    @FXML
    TextField firstname;
    @FXML
    TextField lastname;
    @FXML
    TextField phone;
    @FXML
    TextField gender;
    @FXML
    TextField nat;
    @FXML
    TextField NID;
    @FXML
    TextField time;
    @FXML
    TextField start;
    @FXML
    TextField end;
    @FXML
    TextField room;
    @FXML
    Button save;
    @FXML
    Label ferror;
    @FXML
    Label lerror;
    @FXML
    Label phoneerror;
    @FXML
    Label genderError;
    @FXML
    Label natError;
    @FXML
    Label NIDerror;
    @FXML
    Label timeerror;
    @FXML
    Label startError;
    @FXML
    Label endError;
    @FXML
    Label roomError;

    @FXML
    private void Action(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        if (firstname.getText().equals("")) {
            ferror.setText("First Name Is Empty!");
        } else {
            ferror.setText("");
            if (lastname.getText().equals("")) {
                lerror.setText("Last Name Is Empty");
            } else {
                lerror.setText("");
                if (phone.getText().equals("")) {
                    phoneerror.setText("Phone Number Is Empty!");
                } else {
                    phoneerror.setText("");
                    if (gender.getText().equals("")) {
                        genderError.setText("Gender Is Empty!");
                    } else {
                        genderError.setText("");
                        if (nat.getText().equals("")) {
                            natError.setText("Natonalty Is Empty!");
                        } else {
                            natError.setText("");
                            if (NID.getText().equals("")) {
                                NIDerror.setText("Natonal ID Is Empty!");
                            } else {
                                NIDerror.setText("");
                                if (time.getText().equals("")) {
                                    timeerror.setText("Time Is Empty!");
                                } else {
                                    timeerror.setText("");
                                    if (start.getText().equals("")) {
                                        startError.setText("Start Time Is Empty!");
                                    } else {
                                        startError.setText("");
                                        if (end.getText().equals("")) {
                                            endError.setText("End Date Is Empty!");
                                        } else {
                                            endError.setText("");
                                            if (room.getText().equals("")) {
                                                roomError.setText("Room Id is Empty!");
                                            } else {
                                                roomError.setText("");
                                                    DBHandler db = new DBHandler();
                                                    db.getConnection();
                                                    String out="0";
                                                    db.insert_client(firstname.getText(), lastname.getText(), phone.getText(), nat.getText(), NID.getText(), gender.getText(), time.getText(), start.getText(), end.getText(), room.getText(),out);
                                                    Stage stage = (Stage) save.getScene().getWindow();
                                                    stage.close();
                                                    Parent root = FXMLLoader.load(getClass().getResource("stuffCon.fxml"));
                                                    Scene scene = new Scene(root);
                                                    stage.setScene(scene);
                                                    stage.setTitle("Hotel System");
                                                    stage.show();
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
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //To change body of generated methods, choose Tools | Templates.
    }

}
