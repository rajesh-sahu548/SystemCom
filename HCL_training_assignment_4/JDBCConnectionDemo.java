package HCL_training_assignment_4;




import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnectionDemo {

    public static void main(String[] args) {

        Connection con = null;

        try {
            // 1. Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Database details
            String url = "jdbc:mysql://localhost:3306/testdb";
            String user = "root";
            String password = "1234";

            // 3. Establish connection
            con = DriverManager.getConnection(url, user, password);

            if (con != null) {
                System.out.println("Connection Successful");
            }

        } catch (Exception e) {
            System.out.println("Unable to connect");
        }
    }
}
