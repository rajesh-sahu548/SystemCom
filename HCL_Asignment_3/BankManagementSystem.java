package HCL_Asignment_3;



import java.io.*;
import java.util.*;

// ================= ABSTRACT CLASS =================
abstract class BankAccount {
    protected int accountNumber;
    protected String accountHolder;
    protected double balance;

    public BankAccount(int accNo, String name, double bal) {
        accountNumber = accNo;
        accountHolder = name;
        balance = bal;
    }

    // Encapsulation
    public double getBalance() {
        return balance;
    }

    // Method Overloading
    public void deposit(int amount) {
        balance += amount;
        System.out.println("₹" + amount + " deposited successfully.");
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("₹" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void displayAccount() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Name      : " + accountHolder);
        System.out.println("Balance   : ₹" + balance);
    }

    // Abstract Method
    abstract void calculateInterest();
}

// ================= SAVINGS ACCOUNT =================
class SavingsAccount extends BankAccount {
    public SavingsAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    // Method Overriding
    @Override
    void calculateInterest() {
        double interest = balance * 0.04;
        balance += interest;
        System.out.println("Interest Added: ₹" + interest);
    }
}

// ================= CURRENT ACCOUNT =================
class CurrentAccount extends BankAccount {
    public CurrentAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    @Override
    void calculateInterest() {
        System.out.println("No interest for Current Account.");
    }
}

// ================= MAIN CLASS =================
public class BankManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "bankdata.txt";

    public static void saveToFile(BankAccount acc) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(acc.accountNumber + "," + acc.accountHolder + "," + acc.balance + "\n");
        } catch (IOException e) {
            System.out.println("File Error!");
        }
    }

    public static void main(String[] args) {
        System.out.println("----- BANK MANAGEMENT SYSTEM -----");

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Choose Account Type: ");
        int choice = sc.nextInt();

        // Runtime Polymorphism
        BankAccount account;
        if (choice == 1) {
            account = new SavingsAccount(accNo, name, bal);
        } else {
            account = new CurrentAccount(accNo, name, bal);
        }

        int option;
        do {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Account Details");
            System.out.println("5. Calculate Interest");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter amount: ");
                    double d = sc.nextDouble();
                    account.deposit(d);
                    break;
                case 2:
                    System.out.print("Enter amount: ");
                    double w = sc.nextDouble();
                    account.withdraw(w);
                    break;
                case 3:
                    System.out.println("Balance: ₹" + account.getBalance());
                    break;
                case 4:
                    account.displayAccount();
                    break;
                case 5:
                    account.calculateInterest();
                    break;
                case 6:
                    saveToFile(account);
                    System.out.println("Data saved. Thank you!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (option != 6);
    }
}
