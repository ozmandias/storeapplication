import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class StoreApplicationHomeController implements Initializable {

    StoreApplicationLoginController storelogin = new StoreApplicationLoginController();
    Scene originalsc;
    Scene newsc;
    Stage originalappwindow;
    // DatabaseHandler dbhandler = new DatabaseHandler();
    // Connection storeconnection = dbhandler.getConnection();
    
    // String storeappusername = "";

    @FXML
    public Label lblstoreappuser;
    // Label lblstoreappuser = new Label("User:"+storelogin.storeappuser);
    @FXML
    Button btnmyitems;
    @FXML
    Button btncart;
    @FXML
    Button btnhistory;
    @FXML
    Button btnsignout;

    @FXML
    public void btnmyitemsclick(){

    }
    @FXML
    public void btncartclick(){

    }
    @FXML
    public void btnhistoryclick(){

    }
    @FXML
    public void btnsignoutclick(ActionEvent btnsignoutaction) throws IOException{
        if(btnsignoutaction.getSource()==btnsignout){
            originalsc = btnsignout.getScene();
            originalappwindow = (Stage)originalsc.getWindow();
        }
        Parent layoutroot = FXMLLoader.load(getClass().getResource("storeapplicationlogin.fxml"));
        newsc = new Scene(layoutroot);
        originalappwindow.setScene(newsc);
        originalappwindow.show();
    }

    public void updateusernamelabel(String storeappusername){
        // lblstoreappuser=new Label();
        lblstoreappuser.setText("User:"+storeappusername);
    }
    
    public void initialize(URL location,ResourceBundle resource){
        // lblstoreappuser.setText(storeappusername);
        // lblstoreappuser.setText("Hello");
    }
    
    // public String getusername(){
        
    // }

}