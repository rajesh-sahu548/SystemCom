package HCL_MiniProject_3;

import java.util.*;

public class MainApp {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        if (!Login.authenticate()) {
            return;
        }

        while (true) {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Eno");
            System.out.println("4. Update Student Branch");
            System.out.println("5. Delete Student by Eno");
            System.out.println("6. Display Sorted Students");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> displayStudents();
                    case 3 -> searchStudent();
                    case 4 -> updateBranch();
                    case 5 -> deleteStudent();
                    case 6 -> sortStudents();
                    case 7 -> System.exit(0);
                    default -> System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // 1. Add Student
    static void addStudent() throws Exception {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        for (Student s : students) {
            if (s.eno == eno) {
                throw new DuplicateEnoException("Student Eno must be unique");
            }
        }

        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();
        if (branch.isEmpty())
            throw new EmptyFieldException("Branch cannot be empty");

        System.out.print("Enter Semester: ");
        String sem = sc.nextLine();
        if (sem.isEmpty())
            throw new EmptyFieldException("Semester cannot be empty");

        System.out.print("Enter Percentage: ");
        double per = sc.nextDouble();
        if (per <= 0)
            throw new InvalidPercentageException("Percentage must be positive");

        students.add(new Student(eno, name, branch, sem, per));
        System.out.println("Student Added Successfully");
    }

    // 2. Display
    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No Students Found");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // 3. Search
    static void searchStudent() throws Exception {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        for (Student s : students) {
            if (s.eno == eno) {
                System.out.println(s);
                return;
            }
        }
        throw new StudentNotFoundException("Student not found");
    }

    // 4. Update Branch
    static void updateBranch() throws Exception {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.eno == eno) {
                System.out.print("Enter New Branch: ");
                String newBranch = sc.nextLine();
                if (newBranch.isEmpty())
                    throw new EmptyFieldException("Branch cannot be empty");

                s.branch = newBranch;
                System.out.println("Branch Updated Successfully");
                return;
            }
        }
        throw new StudentNotFoundException("Student not found");
    }

    // 5. Delete
    static void deleteStudent() throws Exception {
        System.out.print("Enter Eno: ");
        int eno = sc.nextInt();

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().eno == eno) {
                it.remove();
                System.out.println("Student Deleted Successfully");
                return;
            }
        }
        throw new StudentNotFoundException("Student not found");
    }

    // 6. Sort
    static void sortStudents() {
        students.sort(Comparator.comparingInt(s -> s.eno));
        System.out.println("Students Sorted by Eno");
        displayStudents();
    }
}
