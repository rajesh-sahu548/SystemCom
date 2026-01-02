package HCL_training_assignment_4;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateInsertStudent {

    public static void main(String[] args) {

        try {
            // 1. Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Database details
            String url = "jdbc:mysql://localhost:3306/testdb";
            String user = "root";
            String password = "1234";

            // 3. Establish connection
            Connection con = DriverManager.getConnection(url, user, password);

            // 4. Create Statement
            Statement stmt = con.createStatement();

            // 5. Create table
            String createTable =
                "CREATE TABLE IF NOT EXISTS Students ("
              + "id INT PRIMARY KEY, "
              + "name VARCHAR(50), "
              + "age INT, "
              + "course VARCHAR(50))";

            stmt.executeUpdate(createTable);
            System.out.println("Table created successfully");

            // 6. Insert records (SAFE WAY)
            String insert1 =
                "INSERT INTO Students (id, name, age, course) VALUES (1, 'Rajesh', 20, 'Selenium')";
            String insert2 =
                "INSERT INTO Students (id, name, age, course) VALUES (2, 'Rahul', 22, 'Selenium')";

            stmt.executeUpdate(insert1);
            stmt.executeUpdate(insert2);

            System.out.println("Records inserted successfully");

            con.close();

        } catch (Exception e) {
            System.out.println("Error occurred");
            e.printStackTrace();
        }
        
        
        
    }
}

