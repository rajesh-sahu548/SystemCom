package HCL_training_assignment_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayStudents {

    public static void main(String[] args) {

        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    "root",
                    "1234"
            );

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // 4. SELECT query
            String selectQuery =
                "SELECT * FROM Students " +
                "WHERE semester = 7 AND branch = 'EC'";

            // 5. Execute query
            ResultSet rs = stmt.executeQuery(selectQuery);

            // 6. Display records
            System.out.println("ID  Name     Branch  Semester  Percentage");
            System.out.println("-----------------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "   " +
                        rs.getString("name") + "   " +
                        rs.getString("branch") + "      " +
                        rs.getInt("semester") + "        " +
                        rs.getDouble("percentage")
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error occurred");
            e.printStackTrace();
        }
    }
}
