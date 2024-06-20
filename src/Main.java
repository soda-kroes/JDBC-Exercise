import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection con = ClsConnection.getConnection();
        if (con != null) {
            try {
                Statement statement = con.createStatement();
                String query = "CREATE TABLE product(Id int  PRIMARY KEY , name varchar(255), price_per_unit  float, active_for_sell bool)";
                statement.execute(query);
                System.out.println("Table created successfully.");
            } catch (SQLException ex) {
                System.out.println(ex);
            }


        }
    }
}


