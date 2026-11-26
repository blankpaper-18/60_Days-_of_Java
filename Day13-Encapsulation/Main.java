/** Day 13 - Encapsulation: private fields + public getters/setters with validation */
class BankAccount {
    private final String accountNumber;
    private String holderName;
    private double balance;

    BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        setHolderName(holderName);
        if (initialBalance < 0) throw new IllegalArgumentException("Initial balance cannot be negative");
        this.balance = initialBalance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName()    { return holderName; }
    public double getBalance()       { return balance; }

    public void setHolderName(String holderName) {
        if (holderName == null || holderName.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.holderName = holderName;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Account[%s, %s, balance=%.2f]", accountNumber, holderName, balance);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-1001", "Kiran", 5000);
        acc.deposit(1500);
        System.out.println(acc);

        System.out.println("Withdraw 2000: " + acc.withdraw(2000));
        System.out.println("Withdraw 99999: " + acc.withdraw(99999));
        System.out.println(acc);

        // acc.balance = 1_000_000;   // <- compile error: balance is private

        try {
            acc.deposit(-50);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
