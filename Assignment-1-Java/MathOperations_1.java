



import java.util.Scanner;

class MathOperations_1 {

    // method for addition
    static int add(int a, int b) {
        int sum = a + b;
        return sum;
    }

    // method for subtraction
    static int subtract(int a, int b) {
        int result = a - b;
        return result;
    }

    // method for multiplication
    static int multiply(int a, int b) {
        int result = a * b;
        return result;
    }

    // method for division
    static double divide(int a, int b) {
        double result;
        if (b != 0) {
            result = (double) a / b;
        } else {
            System.out.println("Division not possible");
            result = 0;
        }
        return result;
    }

    // method for remainder
    static int remainder(int a, int b) {
        int rem = a % b;
        return rem;
    }

    // method for square
    static int square(int a) {
        int sq = a * a;
        return sq;
    }

    // method for cube
    static int cube(int a) {
        int cb = a * a * a;
        return cb;
    }

    // method for absolute value
    static int absolute(int a) {
        int abs = Math.abs(a);
        return abs;
    }

    // main method
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // taking input from user
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        // displaying results
        System.out.println("Addition = " + add(num1, num2));
        System.out.println("Subtraction = " + subtract(num1, num2));
        System.out.println("Multiplication = " + multiply(num1, num2));
        System.out.println("Division = " + divide(num1, num2));
        System.out.println("Remainder = " + remainder(num1, num2));
        System.out.println("Square = " + square(num1));
        System.out.println("Cube = " + cube(num1));
        System.out.println("Absolute value = " + absolute(num1));

        sc.close();



    }
}