import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class StoreApplicationSignUpComplete implements Initializable{
    
    Scene originalscene;
    Scene newscene;
    Stage originalappwindow;

    @FXML
    Button btnmain;

    @FXML
    public void btnmainclick(ActionEvent btnmainaction) throws IOException{
        if(btnmainaction.getSource()==btnmain){
            originalscene = btnmain.getScene();
            originalappwindow = (Stage)originalscene.getWindow();
        }
        Parent layoutroot = FXMLLoader.load(getClass().getResource("storeapplicationlogin.fxml"));
        newscene = new Scene(layoutroot);
        originalappwindow.setScene(newscene);
        originalappwindow.show();
    }
    
    public void initialize(URL location,ResourceBundle resource){

    }
}