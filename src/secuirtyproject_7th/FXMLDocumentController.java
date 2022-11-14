package secuirtyproject_7th;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    public static int counter;
    public static String value[];
    @FXML
    private TextField key1;
    @FXML
    private TextField Startkey;
    @FXML
    private TextField Endkey;
    @FXML
    private Label CipherOUT;
    @FXML
    private Label PlianOUT1;
    @FXML
    private Label PlianOUT2;
    @FXML
    private TextField key2;
    @FXML
    private TextField plainText;
    @FXML
    private TextField ciphertext1;
    @FXML
    private TextField ciphertext2;

    @FXML
    private void StartEncryption(ActionEvent event) {
        char caser[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char caser2[]={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        if (key1.getText().equals("")) {

        } else {
            if (plainText.getText().equals("")) {

            } else {
                String out = " ";
                String t = plainText.getText();
                char text[] = new char[t.length()];
                text = t.toCharArray();
                for (int i = 0; i < t.length(); i++) {
                    int cou=0;
                    for (int j = 0; j < caser.length; j++) {
                        if (text[i] == caser[j]) {
                            int left = (j + Integer.parseInt(key1.getText()));
                            System.out.println("len =" + caser.length);
                            int c = Math.floorMod(left, 26);
                            System.out.println("C =" + c);
                            out += caser[c];
                            System.out.println("Caser[c] =" + caser[c]);
                            System.out.println("OUT =" + out);
                            cou++;
                        }
                        else if (text[i] == caser2[j]) {
                            int left = (j + Integer.parseInt(key1.getText()));
                            System.out.println("len =" + caser.length);
                            int c = Math.floorMod(left, 26);
                            System.out.println("C =" + c);
                            out += caser2[c];
                            System.out.println("Caser[c] =" + caser[c]);
                            System.out.println("OUT =" + out);
                            cou++;
                        }
                    }
                    if(cou==0){
                        out+=" ";
                    }
                }
                CipherOUT.setText(out);
            }
        }
    }

    @FXML
    private void StartDecryption(ActionEvent event) {
        char caser[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char caser2[]={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        if (key2.getText().equals("")) {

        } else {
            if (ciphertext1.getText().equals("")) {

            } else {
                String out = " ";
                String t = ciphertext1.getText();
                char text[] = new char[t.length()];
                text = t.toCharArray();
                 System.out.println("len  = "+t.length());
                for (int i = 0; i < t.length(); i++) {
                    int cou=0;
                    for (int j = 0; j < caser.length; j++) {
                        if (text[i] == caser[j]) {
                            int left = (j - Integer.parseInt(key2.getText()));
                            System.out.println("len =" + caser.length);
                            int c = Math.floorMod(left, 26);
                            System.out.println("C =" + c);
                            out += caser[c];
                            System.out.println("OUT =" + out);
                            cou++;
                        }
                        else if (text[i] == caser2[j]) {
                            int left = (j - Integer.parseInt(key2.getText()));
                            System.out.println("len =" + caser.length);
                            int c = Math.floorMod(left, 26);
                            System.out.println("C =" + c);
                            out += caser2[c];
                            System.out.println("OUT =" + out);
                            cou++;
                        }
                    }
                    if(cou==0){
                        out+=" ";
                    }
                }
                PlianOUT1.setText(out);
            }
        }
    }

    @FXML
    private void StartBruteForce(ActionEvent event) {
        char caser[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char caser2[]={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        if (Startkey.getText().equals("")) {

        } else {
            if (Endkey.getText().equals("")) {

            } else {
                if (ciphertext2.getText().equals("")) {

                } else {

                    int Sk = Integer.parseInt(Startkey.getText());
                    int Ek = Integer.parseInt(Endkey.getText());
                    String outs[] = new String[Ek - Sk+1];
                    String t = ciphertext2.getText();
                    char text[] = new char[t.length()];
                    String out = "";
                    int cou=0;
                    text = t.toCharArray();
                    while (Sk <= Ek) {
                        for (int i = 0; i < t.length(); i++) {
                            int count=0;
                            for (int j = 0; j < caser.length; j++) {
                                if (text[i] == caser[j]) {
                                    int left = (j - Sk);
                                    System.out.println("len =" + caser.length);
                                    int c = Math.floorMod(left, 26);
                                    System.out.println("C =" + c);
                                    out += caser[c];
                                    System.out.println("OUT =" + out);
                                    count++;
                                }
                                else if (text[i] == caser2[j]) {
                                    int left = (j - Sk);
                                    System.out.println("len =" + caser.length);
                                    int c = Math.floorMod(left, 26);
                                    System.out.println("C =" + c);
                                    out += caser2[c];
                                    System.out.println("OUT =" + out);
                                    count++;
                                }
                            }
                            if(count==0){
                                out+=" ";
                            }
                            
                        }
                        System.out.println("===========================================" );
                        outs[cou]=out;
                        cou++;
                        out="";
                        Sk++;
                    }
                    value=outs;
                    PlianOUT2.setText(value[counter]);
                }
            }
        }
    }
    
    @FXML
    private void next(ActionEvent event){
        int Sk = Integer.parseInt(Startkey.getText());
        int Ek = Integer.parseInt(Endkey.getText());
        if(counter+1 >(Ek - Sk) ){
            
        }
        else{
            counter++;
            PlianOUT2.setText(value[counter]);
        }
    }
    @FXML
    private void back(ActionEvent event){
        int Sk = Integer.parseInt(Startkey.getText());
        int Ek = Integer.parseInt(Endkey.getText());
        if(counter-1 <0 ){
            
        }
        else{
            counter--;
            PlianOUT2.setText(value[counter]);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        counter=0;
    }

}
