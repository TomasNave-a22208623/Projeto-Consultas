import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/clinicaDB";
    private static final String USER = "root";
    private static final String PASSWORD = "tominho123";

    public static Connection getConnection() throws SQLException {
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");   
         } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found", e);  
         }
        
        
        try {  
            return DriverManager.getConnection(URL, USER, PASSWORD);  
         } catch (SQLException e) {
            throw new SQLException("Connecção com a base de dados falhou", e);  
         }


    }
}
