package JDBCConect;

import java.sql.SQLException;

public class DeleteData {
    public static void main(String[] args) throws SQLException {
        Main connect = new Main();
        connect.deleteElementDataBase("DELETE FROM user WHERE id = ?", 3);
        connect.closeConnection();
    }

}
