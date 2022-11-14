package carstore_soft4u;

import java.io.File;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Add_Stuff_Controller implements Initializable {

    private DBHandler db;
    private Stuff st;
    private File pic=new File("");;

    @FXML
    private TextField id;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private TextField name;
    @FXML
    private TextField age;
    @FXML
    private TextField salary;
    @FXML
    private TextField address;
    @FXML
    private TextField NID;
    @FXML
    private Button backBT;
    @FXML
    private Button uploadBT;

    @FXML
    private Label idError;
    @FXML
    private Label emailError;
    @FXML
    private Label passwordError;
    @FXML
    private Label nameError;
    @FXML
    private Label ageError;
    @FXML
    private Label salaryError;
    @FXML
    private Label addressError;
    @FXML
    private Label NIDError;
    @FXML
    private Label PicError;
    @FXML
    private Label msg;

    @FXML
    private void Add(ActionEvent event) throws ClassNotFoundException, SQLException {
        if (id.getText().equals("")) {
            idError.setText("برجاء ادخال كود للموظف");
            emailError.setText("");
            passwordError.setText("");
            nameError.setText("");
            ageError.setText("");
            salaryError.setText("");
            addressError.setText("");
            NIDError.setText("");
            PicError.setText("");
            msg.setText("");
        } else {
            if (email.getText().equals("")) {
                idError.setText("");
                emailError.setText("برجاء ادخال البريد الالكتروني للموظف");
                passwordError.setText("");
                nameError.setText("");
                ageError.setText("");
                salaryError.setText("");
                addressError.setText("");
                NIDError.setText("");
                PicError.setText("");
                msg.setText("");
            } else {
                if (password.getText().equals("")) {
                    idError.setText("");
                    emailError.setText("");
                    passwordError.setText("برجاء ادخال كلمة السر للموظف");
                    nameError.setText("");
                    ageError.setText("");
                    salaryError.setText("");
                    addressError.setText("");
                    NIDError.setText("");
                    PicError.setText("");
                    msg.setText("");
                } else {
                    if (name.getText().equals("")) {
                        idError.setText("");
                        emailError.setText("");
                        passwordError.setText("");
                        nameError.setText("برجاء ادخال اسم الموظف");
                        ageError.setText("");
                        salaryError.setText("");
                        addressError.setText("");
                        NIDError.setText("");
                        PicError.setText("");
                        msg.setText("");
                    } else {
                        if (age.getText().equals("")) {
                            idError.setText("");
                            emailError.setText("");
                            passwordError.setText("");
                            nameError.setText("");
                            ageError.setText("برجاء ادخال عمر الموظف");
                            salaryError.setText("");
                            addressError.setText("");
                            NIDError.setText("");
                            PicError.setText("");
                            msg.setText("");
                        } else {
                            if (salary.getText().equals("")) {
                                idError.setText("");
                                emailError.setText("");
                                passwordError.setText("");
                                nameError.setText("");
                                ageError.setText("");
                                salaryError.setText("برجاء ادخال الراتب");
                                addressError.setText("");
                                NIDError.setText("");
                                PicError.setText("");
                                msg.setText("");
                            } else {
                                if (address.getText().equals("")) {
                                    idError.setText("");
                                    emailError.setText("");
                                    passwordError.setText("");
                                    nameError.setText("");
                                    ageError.setText("");
                                    salaryError.setText("");
                                    addressError.setText("برجاء ادخال عنوان الموظف");
                                    NIDError.setText("");
                                    PicError.setText("");
                                    msg.setText("");
                                } else {
                                    if (NID.getText().equals("")) {
                                        idError.setText("");
                                        emailError.setText("");
                                        passwordError.setText("");
                                        nameError.setText("");
                                        ageError.setText("");
                                        salaryError.setText("");
                                        addressError.setText("");
                                        NIDError.setText("برجاء ادخال الرقم القومي الخاص بالموظف");
                                        PicError.setText("");
                                        msg.setText("");
                                    } else {
                                        if (pic.getPath().equals("")) {
                                            idError.setText("");
                                            emailError.setText("");
                                            passwordError.setText("");
                                            nameError.setText("");
                                            ageError.setText("");
                                            salaryError.setText("");
                                            addressError.setText("");
                                            NIDError.setText("");
                                            PicError.setText("برجاء رفع صورة الموظف");
                                            msg.setText("");
                                        } else {
                                            //db
                                            if (db.cheeck_ID_Stuff(id.getText())) {
                                                if (db.cheeck_NID_Stuff(NID.getText())) {
                                                    idError.setText("");
                                                    emailError.setText("");
                                                    passwordError.setText("");
                                                    nameError.setText("");
                                                    ageError.setText("");
                                                    salaryError.setText("");
                                                    addressError.setText("");
                                                    NIDError.setText("");
                                                    PicError.setText("");
                                                    msg.setText("تم اضافة الموظف بنجاح");
                                                    st.setId(id.getText());
                                                    st.setEmail(email.getText());
                                                    st.setPassword(password.getText());
                                                    st.setName(name.getText());
                                                    st.setAge(age.getText());
                                                    st.setSalary(salary.getText());
                                                    st.setAddress(address.getText());
                                                    st.setNID(NID.getText());
                                                    st.setPic(pic.getPath());
                                                    
                                                    db.Insert_Stuff(st);
                                                    
                                                    id.setText("");
                                                    email.setText("");
                                                    password.setText("");
                                                    name.setText("");
                                                    age.setText("");
                                                    salary.setText("");
                                                    address.setText("");
                                                    NID.setText("");

                                                } else {
                                                    idError.setText("");
                                                    emailError.setText("");
                                                    passwordError.setText("");
                                                    nameError.setText("");
                                                    ageError.setText("");
                                                    salaryError.setText("");
                                                    addressError.setText("");
                                                    NIDError.setText("هذا الموظف مسجل بالفعل");
                                                    PicError.setText("");
                                                    msg.setText("");
                                                }
                                            } else {
                                                idError.setText("هذا الكود مستخدم لموظف اخر اختر كود اخر");
                                                emailError.setText("");
                                                passwordError.setText("");
                                                nameError.setText("");
                                                ageError.setText("");
                                                salaryError.setText("");
                                                addressError.setText("");
                                                NIDError.setText("");
                                                PicError.setText("");
                                                msg.setText("");
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

    @FXML
    private void Back_Page(ActionEvent event) throws IOException {
        System.out.println("Back to Admin Page!");
        Stage stage = (Stage) backBT.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("Admin_Page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Car Store");
        stage.show();
    }
    
    @FXML
    private void Upload(ActionEvent event){
        FileChooser fc = new FileChooser();
        Stage stage = (Stage) uploadBT.getScene().getWindow();
        pic = fc.showOpenDialog(stage);
        st.setPic(pic.getPath());
        System.out.println(pic);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = new DBHandler();
        db.getConnection();
        st = new Stuff();
    }

}
