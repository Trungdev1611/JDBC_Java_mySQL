package JDBCConect;

import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) throws SQLException {
        Main connect1 = new Main();
        connect1.insertDataBase("INSERT INTO user (name, age, address) VALUES (?, ?, ?)", "trung", 18,"thai binh");
        connect1.closeConnection();
    }
}
