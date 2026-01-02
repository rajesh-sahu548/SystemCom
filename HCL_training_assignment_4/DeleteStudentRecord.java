package HCL_training_assignment_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteStudentRecord {

    public static void main(String[] args) {

        try {
            // 1. Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    "root",
                    "1234"
            );

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // 4. SQL DELETE query
            String deleteQuery =
                "DELETE FROM Students " +
                "WHERE year_of_passing = 2024 " +
                "AND branch = 'Civil'";

            // 5. Execute DELETE
            int rows = stmt.executeUpdate(deleteQuery);

            // 6. Output
            System.out.println("Records deleted successfully");
            System.out.println("Rows affected: " + rows);

            con.close();

        } catch (Exception e) {
            System.out.println("Error occurred");
            e.printStackTrace();
        }
    }
}
