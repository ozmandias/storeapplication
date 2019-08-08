import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.sql.SQLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class StoreApplicationLoginController implements Initializable{
    
    Scene originalscene;
    Scene newscene;
    Stage originalappwindow;
    Connection storeconnection;
    DatabaseHandler storedbhandler = new DatabaseHandler();
    PreparedStatement prestatement;
    ResultSet result;
    boolean login = false;
    String storeappuser = "";

    @FXML
    Button btnlogin;
    @FXML
    Button btnsignup;
    @FXML
    TextField txtfielduser;
    @FXML
    PasswordField passfieldpassword;
    @FXML
    CheckBox chkboxremember;

    @FXML
    public void btnloginclick(ActionEvent btnloginaction) throws IOException,ClassNotFoundException,SQLException{
        System.out.println("btnloginclick");

        // loading data
        storeconnection = storedbhandler.getConnection();
        String select = "SELECT * FROM storeapplicationusers WHERE username=? AND password=?";
        prestatement = storeconnection.prepareStatement(select);
        prestatement.setString(1, txtfielduser.getText());
        prestatement.setString(2, passfieldpassword.getText());
        result = prestatement.executeQuery();

        int count=0;
        while(result.next()){
            count = count+1;
        }
        if(count==1){
            System.out.println("loginsuccessful");
            login = true;
            storeappuser = txtfielduser.getText();
            System.out.println(storeappuser);
            // StoreApplicationHomeController storeapphome = new StoreApplicationHomeController();
            // storeapphome.updateusernamelabel(updateusername());
        }else{
            System.out.println("loginfail");
        }
        prestatement.close();
        storeconnection.close();
        
        if(login==true){
            if(btnloginaction.getSource()==btnlogin){
                originalscene = btnlogin.getScene();
                originalappwindow = (Stage)originalscene.getWindow();
            }
            Parent layoutroot = FXMLLoader.load(getClass().getResource("storeapplicationhome.fxml"));
            newscene = new Scene(layoutroot);
            originalappwindow.setScene(newscene);
            originalappwindow.show();
        }
    }
    @FXML
    public void btnsignupclick(ActionEvent btnsignupaction) throws IOException{
        System.out.println("btnsignupclick");
        if(btnsignupaction.getSource()==btnsignup){
            originalscene=btnsignup.getScene();
            originalappwindow = (Stage)originalscene.getWindow();
        }
        Parent layoutroot = FXMLLoader.load(getClass().getResource("storeapplicationsignup.fxml"));
        newscene = new Scene(layoutroot);
        originalappwindow.setScene(newscene);
        originalappwindow.show();
    }

    public String updateusername(){
        storeappuser = txtfielduser.getText();
        return storeappuser;
    }
    
    
    public void initialize(URL location,ResourceBundle resource){

    }

}