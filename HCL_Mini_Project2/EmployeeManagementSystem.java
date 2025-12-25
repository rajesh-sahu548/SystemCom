package HCL_Mini_Project2;



import java.io.*;
import java.util.*;

/*
 * Employee Management System
 * Uses Collection + File Handling
 */
public class EmployeeManagementSystem {

    // Collection to store employees
    static ArrayList<Employee> employees = new ArrayList<>();

    // File name
    static final String FILE_NAME = "employees.dat";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Login first
        if (!Login.login()) {
            return;
        }

        // Load data from file
        loadFromFile();

        while (true) {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Display Sorted Employees");
            System.out.println("7. Display Departments");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> displayEmployees();
                case 3 -> searchEmployee();
                case 4 -> updateSalary();
                case 5 -> deleteEmployee();
                case 6 -> sortEmployees();
                case 7 -> showDepartments();
                case 8 -> {
                    saveToFile();
                    System.out.println("✅ Data saved. Exit.");
                    System.exit(0);
                }
                default -> System.out.println("❌ Invalid Choice");
            }
        }
    }

    // Add new employee
    static void addEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            // Check unique ID
            for (Employee e : employees) {
                if (e.id == id) {
                    throw new Exception("Employee ID must be unique!");
                }
            }

            sc.nextLine(); // clear buffer

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();
            if (dept.isEmpty()) {
                throw new Exception("Department cannot be empty!");
            }

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            if (salary <= 0) {
                throw new Exception("Salary must be positive!");
            }

            employees.add(new Employee(id, name, dept, salary));
            saveToFile();

            System.out.println("✅ Employee Added Successfully");

        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    // Display all employees
    static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("❌ No employee data available");
            return;
        }
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    // Search employee by ID
    static void searchEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println(e);
                return;
            }
        }
        System.out.println("❌ Employee not found");
    }

    // Update salary
    static void updateSalary() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee e : employees) {
            if (e.id == id) {
                System.out.print("Enter New Salary: ");
                double sal = sc.nextDouble();

                if (sal <= 0) {
                    System.out.println("❌ Salary must be positive");
                    return;
                }

                e.salary = sal;
                saveToFile();
                System.out.println("✅ Salary Updated");
                return;
            }
        }
        System.out.println("❌ Employee not found");
    }

    // Delete employee
    static void deleteEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        boolean removed = employees.removeIf(e -> e.id == id);

        if (removed) {
            saveToFile();
            System.out.println("✅ Employee Deleted");
        } else {
            System.out.println("❌ Employee not found");
        }
    }

    // Sort employees by name
    static void sortEmployees() {
        employees.sort(Comparator.comparing(e -> e.name));
        displayEmployees();
    }

    // Display unique departments
    static void showDepartments() {
        HashSet<String> departments = new HashSet<>();

        for (Employee e : employees) {
            departments.add(e.department);
        }

        System.out.println("Departments:");
        for (String d : departments) {
            System.out.println(d);
        }
    }

    // Save data to file
    static void saveToFile() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            System.out.println("❌ Error saving file");
        }
    }

    // Load data from file
    static void loadFromFile() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (ArrayList<Employee>) ois.readObject();
        } catch (Exception e) {
            // File not found first time – ignore
        }
    }
}
