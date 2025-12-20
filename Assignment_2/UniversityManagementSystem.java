package Assignment_2;



import java.util.*;
import java.util.regex.Pattern;

// Interface for student operations
interface UniversityOperations {
    void addStudent();
    void displayStudents();
    void searchStudent(int id);
    void removeStudent(int id);
}

// Student class
class Student {
    int id;
    String name;
    String email;
    String course;
    int marks;

    Student(int id, String name, String email, String course, int marks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    void show() {
        System.out.println(id + "\t" + name + "\t" + course + "\t" + marks + "\t" + email);
    }
}

// Main class
public class UniversityManagementSystem implements UniversityOperations {

    // List for students
    List<Student> studentList = new ArrayList<>();

    // Maps
    Map<Integer, Student> hashMap = new HashMap<>();
    Hashtable<Integer, Student> hashtable = new Hashtable<>();
    TreeMap<Integer, Student> treeMap;

    // Set for unique courses
    Set<String> courseSet = new HashSet<>();

    // Stack demo (undo history)
    Stack<String> actionStack = new Stack<>();

    Scanner sc = new Scanner(System.in);

    // Add student
    public void addStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            // Prevent duplicate ID
            if (hashMap.containsKey(id)) {
                System.out.println("Duplicate Student ID not allowed ❌");
                return;
            }

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            // REGEX for email validation
            String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
            if (!Pattern.matches(emailRegex, email)) {
                System.out.println("Invalid Email ❌");
                return;
            }

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            Student s = new Student(id, name, email, course, marks);

            studentList.add(s);
            hashMap.put(id, s);
            hashtable.put(id, s);
            courseSet.add(course);
            actionStack.push("Added Student ID: " + id);

            System.out.println("Student Added Successfully ✔");

        } catch (Exception e) {
            System.out.println("Invalid Input! Try again.");
            sc.nextLine();
        }
    }

    // Display all students
    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\nID\tName\tCourse\tMarks\tEmail");
        for (Student s : studentList) {
            s.show();
        }
    }

    // Search student by ID
    public void searchStudent(int id) {
        Student s = hashMap.get(id);
        if (s != null) {
            System.out.println("\nStudent Found:");
            System.out.println("ID\tName\tCourse\tMarks\tEmail");
            s.show();
        } else {
            System.out.println("Student not found ❌");
        }
    }

    // Remove student by ID
    public void removeStudent(int id) {
        Student s = hashMap.remove(id);
        if (s != null) {
            studentList.remove(s);
            hashtable.remove(id);
            actionStack.push("Removed Student ID: " + id);
            System.out.println("Student Removed Successfully ✔");
        } else {
            System.out.println("Student not found ❌");
        }
    }

    // Sort students by marks
    void sortByMarks() {
        studentList.sort((a, b) -> b.marks - a.marks);
        System.out.println("Students Sorted by Marks ✔");
    }

    // Convert HashMap to TreeMap
    void convertToTreeMap() {
        treeMap = new TreeMap<>(hashMap);
        System.out.println("HashMap converted to TreeMap (Sorted by ID) ✔");
    }

    // Count students course-wise
    void countCourseWise() {
        Map<String, Integer> countMap = new HashMap<>();

        for (Student s : studentList) {
            countMap.put(s.course, countMap.getOrDefault(s.course, 0) + 1);
        }

        System.out.println("\nCourse-wise Student Count:");
        for (Map.Entry<String, Integer> e : countMap.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }

    // Display unique courses
    void displayCourses() {
        System.out.println("\nUnique Courses:");
        for (String c : courseSet) {
            System.out.println(c);
        }
    }

    // Main method
    public static void main(String[] args) {

        UniversityManagementSystem obj = new UniversityManagementSystem();
        Scanner sc = new Scanner(System.in);

        // Menu using Vector
        Vector<String> menu = new Vector<>();
        menu.add("1. Add Student");
        menu.add("2. Display Students");
        menu.add("3. Search Student");
        menu.add("4. Remove Student");
        menu.add("5. Sort Students by Marks");
        menu.add("6. Convert HashMap to TreeMap");
        menu.add("7. Count Students Course-wise");
        menu.add("8. Display All Courses");
        menu.add("9. Exit");

        while (true) {
            System.out.println("\n===== UNIVERSITY STUDENT MANAGEMENT =====");
            for (String m : menu)
                System.out.println(m);

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> obj.addStudent();
                case 2 -> obj.displayStudents();
                case 3 -> {
                    System.out.print("Enter Student ID: ");
                    obj.searchStudent(sc.nextInt());
                }
                case 4 -> {
                    System.out.print("Enter Student ID: ");
                    obj.removeStudent(sc.nextInt());
                }
                case 5 -> obj.sortByMarks();
                case 6 -> obj.convertToTreeMap();
                case 7 -> obj.countCourseWise();
                case 8 -> obj.displayCourses();
                case 9 -> {
                    System.out.println("Program Ended. Thank You!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Choice ❌");
            }
        }
    }
}
