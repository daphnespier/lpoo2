package A04_jdbc.livroautor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException{

        return DriverManager.getConnection("jdbc:mysql://localhost", "root", "1234");

    }
}
