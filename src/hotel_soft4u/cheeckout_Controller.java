package hotel_soft4u;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class cheeckout_Controller implements Initializable {
    Client cl[];
    int len;int target=0;
    
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
        return count;
    }
    
    private void viewall() throws ClassNotFoundException, SQLException{
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
            }//30107070202216
            System.out.println("Cheeck View");
            System.out.println("I="+i);
        } catch (SQLException e) {
            System.out.println("No");
        }
    }
    
    
    String password, user_name;//This Varibale to save who is login
    private Connection connection;//Inislaize connect
    private DBHandler handler;
    private PreparedStatement pst;
    @FXML
    TextField data;
    @FXML
    TextArea datas;
    @FXML
    Button view;
    @FXML
    Button checkout;
    @FXML
    Button back;
    @FXML
    Label error;
    
    @FXML
    private void action_back(ActionEvent event) throws IOException{
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("stuffCon.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hotel System");
        stage.show();
    }
    
    @FXML
    private void delete(ActionEvent event) throws SQLException, IOException{
        DBHandler db=new DBHandler();
        db.getConnection();
        db.del_client(data.getText());
        Stage stage = (Stage) checkout.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("stuffCon.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hotel System");
        stage.show();
    }
    
    @FXML
    private void action(ActionEvent event) throws ClassNotFoundException, SQLException{
        if(data.getText().equals("")){
            error.setText("Error Please Enter National ID!");
            
        }
        else{
            error.setText("");
            viewall();
            for(int i=0;i<cl.length;i++){
                if(cl[i].getNationalID().equals(data.getText())){
                    datas.setText("Client Name:"+cl[i].getFrist_Name()+cl[i].getLast_Name()+"\n"+"Gender:"+cl[i].getGender()+"\n"+"NationalID:"+cl[i].getNationalID()+"\n"+"nationalty:"+cl[i].getNationalty()+"\n"+"Start Date:"+cl[i].getStratDate()+"  End Date:"+cl[i].getEndDate());
                }
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         //To change body of generated methods, choose Tools | Templates.
    }
    
}
