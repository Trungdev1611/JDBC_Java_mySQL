package JDBCConect;

import JDBCConect.Main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecuteQueryExample {
    public static void main(String[] args) throws SQLException {
        Main connect1 = new Main();
        ResultSet getData = connect1.getResult("SELECT * FROM user");
        try {
            while (getData.next()) {
                String username = getData.getString("name");
                String age = getData.getString("age");
                System.out.println("Username: " + username + ", age: " + age);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //after use connection -> close
        connect1.closeConnection();
    }
}
