import java.lang.ClassNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler extends DatabaseConfigs{

    Connection dbconnection;
    DatabaseConfigs configs = new DatabaseConfigs();

    public Connection getConnection() throws ClassNotFoundException,SQLException{
        String dbstore = "jdbc:mysql://"+configs.dbhost+":"+configs.dbport+"/"+configs.dbname;
            Class.forName("com.mysql.jdbc.Driver");
            dbconnection = DriverManager.getConnection(dbstore,configs.dbuser,configs.dbpassword);    
        
            return dbconnection;

    }

}