import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    // URL, username, password of MySQL server
    private static final String url = "jdbc:mysql://127.0.0.1/:3306/mysql";
    private static final String username = "root";
    private static final String password = "zarad22zarad1293";

    // variables for opening and managing connection
    private static Connection connection;
    private static ResultSet resultSet;
    private static Statement statement;

    protected DatabaseConnection () {
        String query = "select count(*) from passenger";
        // select * from passenger where name = %SearchString%
        try {
            // connecting to database server

            // что-то не так с подключением к URL !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

            connection = DriverManager.getConnection(url, username, password);
            // getting statement object to execute query
            statement = connection.createStatement();
            // executing query
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int count = resultSet.getInt(1);
                System.out.println("Total number of passengers: " + count);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { connection.close();} catch (SQLException e){}
            try { statement.close();} catch (SQLException e){}
            try { resultSet.close();} catch (SQLException e){}
        }
    }
}
