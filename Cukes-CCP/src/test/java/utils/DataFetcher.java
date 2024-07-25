package utils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataFetcher {
	
	public static void main(String[] args) {
		
		System.out.println(fetchValue());
	}
    public static String fetchValue() {
        String query = "select *from city;";
        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                return  resultSet.getString("Name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
