package DB;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DbConnection {
    public static Connection getConnection(){
        Connection connection;
        try (FileInputStream f = new FileInputStream("C:\\Users\\user\\Desktop\\dataDriverFramework-homework\\src\\main\\resources\\db.properties")){
            Properties properties = new Properties();
            properties.load(f);
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, username, password);

        }catch (IOException | SQLException e){
            throw new RuntimeException(e);
        }


        return connection;
    }
}
