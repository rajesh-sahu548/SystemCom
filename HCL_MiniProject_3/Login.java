package HCL_MiniProject_3;

import java.util.Scanner;

public class Login {

    public static boolean authenticate() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.next();

        System.out.print("Enter Password: ");
        String password = sc.next();

        if (username.equals("admin") && password.equals("admin123")) {
            System.out.println("Login Successful\n");
            return true;
        } else {
            System.out.println("Invalid Username or Password");
            return false;
        }
    }
}
