package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/world";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    
    
//    public static void main(String[] args) throws SQLException {
//		
//    	getConnection();
//	}

    public static Connection getConnection() throws SQLException {	
    	
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
