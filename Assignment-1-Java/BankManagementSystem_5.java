
import java.util.Scanner;

// Custom Exception for Insufficient Balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Bank Account Class
class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(int accNo, String name, double initialBalance) {
        this.accountNumber = accNo;
        this.accountHolderName = name;
        this.balance = initialBalance;
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
        } else {
            this.balance += amount;
            System.out.println("Amount deposited successfully.");
        }
    }

    // Withdraw Method with Exception
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > this.balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        } else {
            this.balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        }
    }

    // Balance Enquiry
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + this.balance);
    }

    // Display Account Details
    public void displayDetails() {
        System.out.println("Account Number : " + this.accountNumber);
        System.out.println("Account Holder : " + this.accountHolderName);
        System.out.println("Balance        : ₹" + this.balance);
    }
}

// Main Class
public class BankManagementSystem_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            System.out.println("\n---- BANK MANAGEMENT SYSTEM ----");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Account Number: ");
                        int accNo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Account Holder Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Initial Balance: ");
                        double bal = sc.nextDouble();

                        account = new BankAccount(accNo, name, bal);
                        System.out.println("Account created successfully.");
                        break;

                    case 2:
                        if (account == null) {
                            System.out.println("Please create an account first.");
                            break;
                        }
                        System.out.print("Enter deposit amount: ");
                        double depositAmt = sc.nextDouble();
                        account.deposit(depositAmt);
                        break;

                    case 3:
                        if (account == null) {
                            System.out.println("Please create an account first.");
                            break;
                        }
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmt = sc.nextDouble();
                        account.withdraw(withdrawAmt);
                        break;

                    case 4:
                        if (account == null) {
                            System.out.println("Please create an account first.");
                            break;
                        }
                        account.checkBalance();
                        break;

                    case 5:
                        if (account == null) {
                            System.out.println("Please create an account first.");
                            break;
                        }
                        account.displayDetails();
                        break;

                    case 6:
                        System.out.println("Thank you for using Bank Management System.");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter correct data.");
                sc.nextLine(); // clear buffer
            }
        }
    }
}

