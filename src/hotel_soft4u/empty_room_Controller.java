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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class empty_room_Controller  implements Initializable{
     Room rom[];
     Room Classrom[];
    DBHandler db=new DBHandler();
    int len;
    
    @FXML
    TextField size;
    @FXML
    Label sizeerror;
    
    int target=0;
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
        //SELECT COUNT(id) as count_pet FROM pet;
        return count;
    }
    
    private void classfication(int s){
        int j=0;
        for(int i=0;i<len;i++){
            if(rom[i].getSize()==s && rom[i].getEmpty()==0){
                Classrom[j]=new Room();
                Classrom[j].setEmpty(rom[i].getEmpty());
                Classrom[j].setNumber_room(rom[i].getNumber_room());
                Classrom[j].setSalary(rom[i].getSalary());
                Classrom[j].setSize(rom[i].getSize());
                j++;
            }
        }
    }
    
    @FXML
    Label data;
    
    @FXML
    private void viewSize(ActionEvent event) throws ClassNotFoundException, SQLException{
        if(size.getText().equals("")){
            sizeerror.setText("Size Is Empty");
        }
        else{
            int i=0;int c=Integer.parseInt(size.getText());
            len=counter();
            rom=new Room[len];
            Classrom=new Room[len];
            sizeerror.setText("");
            try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/hotel", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from room ");
            System.out.println("Done");
            while (rs.next()) {
                rom[i]=new Room();
                rom[i].setNumber_room(Integer.parseInt(rs.getString("id")));
                rom[i].setSize(Integer.parseInt(rs.getString("size")));
                rom[i].setEmpty(Integer.parseInt(rs.getString("empty")));
                rom[i].setSalary(Double.parseDouble(rs.getString("salary")));
                i++;
            }
            System.out.println("I="+i);
        } catch (SQLException e) {
            System.out.println("No");
        }
            classfication(c);
            data.setText("Room ID ="+Classrom[target].getNumber_room());
        }
    }
    
    @FXML
    Label error;
    
    @FXML
    private void next(ActionEvent event){
        if((target+1)>=len){
            error.setText("No More");
        }
        else{
            error.setText("");
            target++;
            data.setText("Room ID ="+Classrom[target].getNumber_room());
        }
    }
    
    @FXML
    private void prev(ActionEvent event){
        if((target+1)<0){
            error.setText("No More");
        }
        else{
            error.setText("");
            target--;
            data.setText("Room ID ="+Classrom[target].getNumber_room());
        }
    }

    
    @FXML
    Label dataAll;
    
    @FXML
    private void viewall(ActionEvent event) throws ClassNotFoundException, SQLException{
        int i=0;
            len=counter();
            rom=new Room[len];
            Classrom=new Room[len];
            sizeerror.setText("");
            try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/hotel", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from room ");
            System.out.println("Done");
            while (rs.next()) {
                rom[i]=new Room();
                rom[i].setNumber_room(Integer.parseInt(rs.getString("id")));
                rom[i].setSize(Integer.parseInt(rs.getString("size")));
                rom[i].setEmpty(Integer.parseInt(rs.getString("empty")));
                rom[i].setSalary(Double.parseDouble(rs.getString("salary")));
                i++;
            }
            System.out.println("I="+i);
        } catch (SQLException e) {
            System.out.println("No");
        }
        dataAll.setText("Room ID"+rom[target].getNumber_room());
    }
    
    
    @FXML
    Label errorall;
    
    
    
    @FXML
    private void nextall(ActionEvent event){
        if((target+1)>=len){
            errorall.setText("No More");
        }
        else{
            errorall.setText("");
            target++;
            dataAll.setText("Room ID ="+rom[target].getNumber_room());
        }
    }
    
    @FXML
    private void prevall(ActionEvent event){
        if((target-1)<0){
            errorall.setText("No More");
        }
        else{
            errorall.setText("");
            target--;
            dataAll.setText("Room ID ="+rom[target].getNumber_room());
        }
    }
    @FXML
    Button back;
    
    @FXML
    private void back_Page(ActionEvent event) throws IOException{
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
