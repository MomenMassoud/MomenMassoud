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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
public class ViewClient_Controller implements Initializable{
    Client cl[];
    int len;int target=0;
    DBHandler db=new DBHandler();
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
    
    @FXML
    TextArea data;
    
    @FXML
    private void viewall(ActionEvent event) throws ClassNotFoundException, SQLException{
        int i=0;
            len=counter();
            cl=new Client[len];
            try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/hotel", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from client ");
            System.out.println("Done");
            while (rs.next()) {
                cl[i]=new Client();
                cl[i].setFrist_Name(rs.getString("firstname"));
                cl[i].setLast_Name(rs.getString("lastname"));
                cl[i].setEndDate(rs.getString("enddate"));
                cl[i].setGender(rs.getString("gender"));
                cl[i].setNationalID(rs.getString("nationaltyID"));
                cl[i].setNationalty(rs.getString("nationalty"));
                cl[i].setPhoneNumber(rs.getString("phonenumber"));
                cl[i].setStratDate(rs.getString("startdate"));
                cl[i].setTime(rs.getString("time"));
                i++;
            }
            System.out.println("I="+i);
        } catch (SQLException e) {
            System.out.println("No");
        }
        data.setText("Client Name:"+cl[target].getFrist_Name()+cl[target].getLast_Name()+"\n"+"Gender:"+cl[target].getGender()+"\n"+"NationalID:"+cl[target].getNationalID()+"\n"+"nationalty:"+cl[target].getNationalty()+"\n"+"Start Date:"+cl[target].getStratDate()+"  End Date:"+cl[target].getEndDate());
    }
    
    @FXML
    Label error;
    
    @FXML
    private void nextall(ActionEvent event){
        if((target+1)>=len){
            error.setText("No More");
        }
        else{
            error.setText("");
            target++;
            data.setText("Client Name:"+cl[target].getFrist_Name()+cl[target].getLast_Name()+"\n"+"Gender:"+cl[target].getGender()+"\n"+"NationalID:"+cl[target].getNationalID()+"\n"+"nationalty:"+cl[target].getNationalty()+"\n"+"Start Date:"+cl[target].getStratDate()+"  End Date:"+cl[target].getEndDate());
        }
    }
    @FXML
    private void prevall(ActionEvent event){
        if((target-1)<0){
            error.setText("No More");
        }
        else{
            error.setText("");
            target--;
            data.setText("Client Name:"+cl[target].getFrist_Name()+cl[target].getLast_Name()+"\n"+"Gender:"+cl[target].getGender()+"\n"+"NationalID:"+cl[target].getNationalID()+"\n"+"nationalty:"+cl[target].getNationalty()+"\n"+"Start Date:"+cl[target].getStratDate()+"  End Date:"+cl[target].getEndDate());
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
