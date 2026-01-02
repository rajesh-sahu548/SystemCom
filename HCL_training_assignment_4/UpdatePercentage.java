package HCL_training_assignment_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdatePercentage {

    public static void main(String[] args) {

        try {
            // 1. Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    "root",
                    "1234"
            );

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // 4. SQL Query to increase 5% for CSE students
            String updateQuery =
                "UPDATE Students " +
                "SET percentage = percentage + 5 " +
                "WHERE branch = 'CSE'";

            int rows = stmt.executeUpdate(updateQuery);

            // 5. Output
            System.out.println("Percentage updated for CSE students");
            System.out.println("Rows affected: " + rows);

            con.close();

        } catch (Exception e) {
            System.out.println("Error occurred");
            e.printStackTrace();
        }
    }
}

