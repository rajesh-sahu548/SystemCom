package Assignment_2;

// ===== Step 1: Banking interface =====
// Isme bank se related kaam likhe gaye hain
interface BankWork {

    // paisa jama karne ka rule
    void deposit(int amount);

    // paisa nikalne ka rule
    void withdraw(int amount) throws LowBalanceException;
}


// ===== Step 2: Customer interface =====
// Isme customer details se related kaam
interface CustomerWork {

    // customer ki details dikhane ka rule
    void showDetails();
}


// ===== Step 3: Custom Exception =====
// Jab balance kam ho tab ye exception aayega
class LowBalanceException extends Exception {

    // constructor
    LowBalanceException(String message) {
        super(message);
    }
}


// ===== Step 4: BankAccount class =====
// Ye class dono interfaces ko implement kar rahi hai
class BankAccount implements BankWork, CustomerWork {

    int accountNo;
    String customerName;
    int balance;

    // constructor – starting values set karta hai
    BankAccount(int accountNo, String customerName, int balance) {
        this.accountNo = accountNo;
        this.customerName = customerName;
        this.balance = balance;
    }

    // deposit method
    public void deposit(int amount) {
        balance = balance + amount;
        System.out.println(amount + " rupees deposited");
    }

    // withdraw method
    public void withdraw(int amount) throws LowBalanceException {

        // agar balance kam hai to exception throw karo
        if (amount > balance) {
            throw new LowBalanceException("Balance kam hai!");
        }

        balance = balance - amount;
        System.out.println(amount + " rupees withdrawn");
    }

    // customer details print karne ka method
    public void showDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account No : " + accountNo);
        System.out.println("Name       : " + customerName);
        System.out.println("Balance    : " + balance);
    }
}


// ===== Step 5: Main class =====
public class BankApp {

    public static void main(String[] args) {

        // object create kiya
        BankAccount acc = new BankAccount(101, "Rajesh Sahu", 5000);

        // details dikhana
        acc.showDetails();

        // deposit paisa
        acc.deposit(2000);

        // try-catch se exception handle
        try {
            acc.withdraw(9000);   // yahan error aayega
        } catch (LowBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // sahi withdrawal
        try {
            acc.withdraw(3000);
        } catch (LowBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // final details
        acc.showDetails();
    }
}
