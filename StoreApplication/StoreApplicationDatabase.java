import java.lang.ClassNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StoreApplicationDatabase{

    public static void main(String args[]) throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection databaseconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/storeapplication","root","       ");
        System.out.println("Connected to storeapplicationdatabase");
    }

}