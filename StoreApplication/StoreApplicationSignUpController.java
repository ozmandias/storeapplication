import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StoreApplicationSignUpController implements Initializable{
    
    Scene originalscene;
    Scene newscene;
    Stage originalappwindow;
    Connection storeconnection;
    DatabaseHandler storedbhandler = new DatabaseHandler();
    PreparedStatement prestatement;

    @FXML
    Button btnsignup;
    @FXML
    Button btncancel;
    @FXML
    RadioButton rbtnmale;
    @FXML
    RadioButton rbtnfemale;
    @FXML
    ToggleGroup gender;
    @FXML
    TextField txtfielduser;
    @FXML
    TextField txtfieldemail;
    @FXML
    PasswordField passfieldpassword;

    @FXML
    public void btnsignupclick(ActionEvent btnsignupaction) throws IOException,ClassNotFoundException,SQLException{
        System.out.println("btnsignupclick");
        
        // saving data
        String insert="INSERT INTO storeapplicationusers(username,email,password,gender) VALUES (?,?,?,?)";
        storeconnection = storedbhandler.getConnection();
        prestatement = storeconnection.prepareStatement(insert);
        // prestatement.setInt(1, 3);
        prestatement.setString(1,txtfielduser.getText());
        prestatement.setString(2, txtfieldemail.getText());
        prestatement.setString(3, passfieldpassword.getText());
        prestatement.setString(4, gender());
        prestatement.executeUpdate();

        System.out.println("signupcomplete");
        if(btnsignupaction.getSource()==btnsignup){
            originalscene = btnsignup.getScene();
            originalappwindow = (Stage)originalscene.getWindow();
        }
        Parent layoutroot = FXMLLoader.load(getClass().getResource("storeapplicationsignupcomplete.fxml"));
        newscene = new Scene(layoutroot);
        originalappwindow.setScene(newscene);
        originalappwindow.show();
    }
    @FXML
    public void btncancelclick(ActionEvent btncancelaction) throws IOException{
        System.out.println("btncancelclick");
        if(btncancelaction.getSource()==btncancel){
            originalscene=btncancel.getScene();
            originalappwindow=(Stage)originalscene.getWindow();
        }
        Parent layoutroot = FXMLLoader.load(getClass().getResource("storeapplicationlogin.fxml"));
        Scene newscene = new Scene(layoutroot);
        originalappwindow.setScene(newscene);
        originalappwindow.show();
    }
    
    public void initialize(URL location,ResourceBundle resource){

    }

    public String gender(){
        String gen="";
        if(rbtnmale.isSelected()){
            gen="Male";
        }else{
            gen="Female";
        }
        return gen;
    }

}