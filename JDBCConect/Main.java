package JDBCConect;
import java.sql.*;
public class Main {
      final String url = "jdbc:mysql://localhost:3306/";
      final String schemaName = "schema_con_java";
      final String username = "root";
      final String password = "16111994";
      Connection con;

      public Main() {
          //sử dụng khối try-with-resource (try()) này để tự động đóng kết nối - try{} bình thường không được
          System.out.println("start connection");
          try {
              this.con = DriverManager.getConnection(url+schemaName, username, password);
          }
          catch ( SQLException e) {
              throw new RuntimeException(e);
          }
      }
      //get data from database
      public ResultSet getResult(String query) {
        try {
            Statement stmt = con.createStatement();
            return stmt.executeQuery(query);  //apply with select data => có return
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
      }
      public void insertDataBase(String insertQuery, Object... values) {
          try (PreparedStatement pstmt = con.prepareStatement(insertQuery)) {
              //có thể dùng cách này
              for (int i = 0; i < values.length; i++) {
                  pstmt.setObject(i + 1, values[i]);
              }
              //hoặc thủ công
             //pstmt.setObject(i + 1, values[i]);

              int rowsInserted = pstmt.executeUpdate();  //apply with delete, insert, update
              if (rowsInserted > 0) {
                  System.out.println("Data inserted successfully.");
              } else {
                  System.out.println("Failed to insert data.");
              }
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
      }
      public void deleteElementDataBase(String deleteQuery, Object... values) {
          try(PreparedStatement pstmt = con.prepareStatement(deleteQuery)){
              for (int i = 0; i < values.length; i++) {
                  pstmt.setObject(i + 1, values[i]);
              }
              int rowDeleted = pstmt.executeUpdate();
              if (rowDeleted > 0) {
                  System.out.println("Deleted data successfully.");
              } else {
                  System.out.println("Failed to Delete data.");
              }
          }
          catch (SQLException e) {
              throw new RuntimeException(e);
          }

      }
    public void updateData(String updateQuery) {
        try(PreparedStatement pstmt = con.prepareStatement(updateQuery)){
            int rowUpdate = pstmt.executeUpdate();
            if (rowUpdate > 0) {
                System.out.println("updated data successfully.");
            } else {
                System.out.println("Failed to update data.");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
      public void closeConnection() throws SQLException {
          con.close();
          System.out.println("close connection");
      }
}
