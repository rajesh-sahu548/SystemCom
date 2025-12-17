import java.util.Scanner;

public class MatrixOperations_3 {

    // Matrix Addition
    static void add(int[][] a, int[][] b, int r, int c) {
        System.out.println("\nAddition:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print((a[i][j] + b[i][j]) + " ");
            }
            System.out.println();
        }
    }

    // Matrix Subtraction
    static void subtract(int[][] a, int[][] b, int r, int c) {
        System.out.println("\nSubtraction:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print((a[i][j] - b[i][j]) + " ");
            }
            System.out.println();
        }
    }

    // Matrix Multiplication
    static void multiply(int[][] a, int[][] b, int r1, int c1, int c2) {
        int[][] mul = new int[r1][c2];
        System.out.println("\nMultiplication:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                mul[i][j] = 0;
                for (int k = 0; k < c1; k++) {
                    mul[i][j] += a[i][k] * b[k][j];
                }
                System.out.print(mul[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Matrix Transpose
    static void transpose(int[][] a, int r, int c) {
        System.out.println("\nTranspose:");
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(a[j][i] + " ");
            }
            System.out.println();
        }
    }

    // Check Square Matrix
    static boolean isSquare(int r, int c) {
        return r == c;
    }

    // Check Diagonal Matrix
    static boolean isDiagonal(int[][] a, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && a[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    // Check Identity Matrix
    static boolean isIdentity(int[][] a, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j && a[i][j] != 1)
                    return false;
                if (i != j && a[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int r = sc.nextInt();
        System.out.print("Enter columns: ");
        int c = sc.nextInt();

        int[][] a = new int[r][c];
        int[][] b = new int[r][c];

        System.out.println("Enter Matrix A:");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                a[i][j] = sc.nextInt();

        System.out.println("Enter Matrix B:");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                b[i][j] = sc.nextInt();

        add(a, b, r, c);
        subtract(a, b, r, c);

        if (isSquare(r, c)) {
            multiply(a, b, r, c, c);
            transpose(a, r, c);

            System.out.println("\nMatrix is Square");

            if (isDiagonal(a, r))
                System.out.println("Matrix is Diagonal");
            else
                System.out.println("Matrix is NOT Diagonal");

            if (isIdentity(a, r))
                System.out.println("Matrix is Identity");
            else
                System.out.println("Matrix is NOT Identity");

        } else {
            System.out.println("\nMatrix is NOT Square");
            transpose(a, r, c);
        }

        sc.close();
    }
}
