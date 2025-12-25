package HCL_Mini_Project2;

import java.util.Scanner;

/*
 * Login class
 * Validates username and password
 */
public class Login {

    public static boolean login() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        // Hardcoded login (as per mini project)
        if (username.equals("admin") && password.equals("admin123")) {
            System.out.println("✅ Login Successful\n");
            return true;
        } else {
            System.out.println("❌ Invalid Username or Password");
            return false;
        }
    }
}
