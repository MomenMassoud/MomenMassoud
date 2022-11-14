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
public class ADDStuff_Controller implements Initializable{
    
    private DBHandler db=new DBHandler();
    Staff st=new Staff();

    @FXML
    TextField firstname;
    @FXML
    TextField lastname;
    @FXML
    TextField email;
    @FXML
    PasswordField password;
    @FXML
    TextField id;
    @FXML
    TextField NID;
    @FXML
    TextField NIDP;
    @FXML
    TextField gender;
    @FXML
    TextField salary;
    @FXML
    TextField age;
    @FXML
    TextField address;
    @FXML
    TextField phonenumber;
    @FXML
    TextField jop;
    @FXML
    Label ferror;
    @FXML
    Label lerror;
    @FXML
    Label eerror;
    @FXML
    Label perror;
    @FXML
    Label iderror;
    @FXML
    Label NIDerror;
    @FXML
    Label NIDPerror;
    @FXML
    Label gerror;
    @FXML
    Label salaryerror;
    @FXML
    Label ageerror;
    @FXML
    Label adderror;
    @FXML
    Label phoneerror;
    @FXML
    Label joperror;
    @FXML
    Button save;
    @FXML
    Button back;
    
    @FXML
    private void BACK_BUTTON(ActionEvent event) throws IOException{
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("adminCon.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hotel System");
        stage.show();
    }
    
    @FXML
    private void saveData(ActionEvent event) throws SQLException, IOException{
        int c=0;
        if(firstname.getText().equals("")){
            ferror.setText("First Name Is Empty");
            c++;
        }
        if(!(firstname.getText().equals(""))){
            ferror.setText("");
        }
        if(lastname.getText().equalsIgnoreCase("")){
            c++;
         lerror.setText("Last Name Is Empty");
        }
        if(!(lastname.getText().equalsIgnoreCase(""))){
            lerror.setText("");
        }
        if(email.getText().equals("")){
            c++;
            eerror.setText("Email Is Empty");
        }
        if(!(email.getText().equals(""))){
            eerror.setText("");
        }
        if(password.getText().equals("")){
            c++;
            perror.setText("Password Is Empty");
        }
        if(!(password.getText().equals(""))){
            perror.setText("");
        }
        if(id.getText().equals("")){
            c++;
            iderror.setText("Id Is Empty");
        }
        if(!(id.getText().equals(""))){
            iderror.setText("");
        }
        if(NID.getText().equals("")){
            c++;
            NIDerror.setText("National ID Is Empty");
        }
        if(!(NID.getText().equals(""))){
            
            NIDerror.setText("");
        }
        if(NIDP.getText().equals("")){
            c++;
            NIDPerror.setText("National ID Picture Is Empty");
        }
        if(!(NIDP.getText().equals(""))){
            NIDPerror.setText("");
        }
        if(gender.getText().equals("")){
            c++;
            gerror.setText("Gender Is Empty");
        }
        if(!(gender.getText().equals(""))){
            gerror.setText("");
        }
        if(salary.getText().equals("")){
            c++;
            salaryerror.setText("Salary Is Empty");
        }
        if(!(salary.getText().equals(""))){
            salaryerror.setText("");
        }
        if(age.getText().equals("")){
            c++;
            ageerror.setText("Age Is Empty");
        }
        if(!(age.getText().equals(""))){
            ageerror.setText("");
        }
        if(address.getText().equals("")){
            c++;
            adderror.setText("Address Is Empty");
        }
        if(!(address.getText().equals(""))){
            adderror.setText("");
        }
        if(phonenumber.getText().equals("")){
            c++;
            phoneerror.setText("Phone Number Is Empty");
        }
        if(!(phonenumber.getText().equals(""))){
            phoneerror.setText("");
        }
        if(jop.getText().equals("")){
            c++;
            joperror.setText("Jop Is Empty");
        }
        if(!(jop.getText().equals(""))){
            joperror.setText("");
        }
        if(c==0){
            db.getConnection();
            st.setFirstName(firstname.getText());
            st.setLastName(lastname.getText());
            st.setEmail(email.getText());
            st.setPassword(password.getText());
            st.setNationalID(NID.getText());
            st.setNationalID_picutre(NIDP.getText());
            st.setGender(gender.getText());
            st.setSalary(salary.getText());
            st.setAge(age.getText());
            st.setAddress(address.getText());
            st.setPhoneNumber(phonenumber.getText());
            st.setJop(jop.getText());
            st.setID(id.getText());
            db.insert_stuff(firstname.getText(), lastname.getText(), email.getText(), password.getText(), id.getText(), NID.getText(), NIDP.getText(), gender.getText(), salary.getText(), age.getText(), address.getText(), phonenumber.getText(), jop.getText());
            Stage stage = (Stage) save.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("adminCon.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Hotel System");
        stage.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
