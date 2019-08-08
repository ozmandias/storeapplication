import java.io.IOException;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StoreApplicationMain extends Application{

    public void start(Stage appwindow)throws IOException{
        Parent layoutroot = FXMLLoader.load(getClass().getResource("storeapplicationlogin.fxml"));
        Scene sc = new Scene(layoutroot);
        appwindow.setTitle("StoreAppliaction");
        appwindow.setScene(sc);
        appwindow.show();
    }
    
    public static void main(String args[]){
        Application.launch(args);
    }

}