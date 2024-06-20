import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Master {
    public static void main(String[] args) {
        Connection con = ClsConnection.getConnection();
        if (con != null) {
            try {
                Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String query = "SELECT * FROM product";
                ResultSet resultSet = statement.executeQuery(query);

                resultSet.moveToInsertRow();
                resultSet.updateInt("Id", 3);
                resultSet.updateString("name", "Product 1");
                resultSet.updateFloat("price_per_unit", 10.5f);
                resultSet.updateBoolean("active_for_sell", true);
                resultSet.insertRow();
                resultSet.moveToCurrentRow();

                resultSet.moveToInsertRow();
                resultSet.updateInt("Id", 4);
                resultSet.updateString("name", "Product 2");
                resultSet.updateFloat("price_per_unit", 15.75f);
                resultSet.updateBoolean("active_for_sell", false);
                resultSet.insertRow();
                resultSet.moveToCurrentRow();


                while (resultSet.next()) {
                    int id = resultSet.getInt("Id");
                    String name = resultSet.getString("name");
                    float price = resultSet.getFloat("price_per_unit");
                    boolean active = resultSet.getBoolean("active_for_sell");


                    System.out.println("Id: " + id + ", Name: " + name + ", Price: " + price + ", Active: " + active);
                }
                System.out.println("Data inserted and list read successfully.");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
}