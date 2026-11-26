/** Day 22 - Custom Exceptions */

// Checked exception: extends Exception - callers MUST handle or declare it
class InsufficientFundsException extends Exception {
    private final double shortfall;

    InsufficientFundsException(String message, double shortfall) {
        super(message);
        this.shortfall = shortfall;
    }

    double getShortfall() { return shortfall; }
}

// Unchecked exception: extends RuntimeException
class AccountNotFoundException extends RuntimeException {
    AccountNotFoundException(String accountId) {
        super("Account not found: " + accountId);
    }
}

class Account {
    private final String id;
    private double balance;

    Account(String id, double balance) { this.id = id; this.balance = balance; }

    void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(
                "Cannot withdraw " + amount + ", balance is " + balance, amount - balance);
        }
        balance -= amount;
    }

    double getBalance() { return balance; }
    String getId() { return id; }
}

class Bank {
    private final java.util.Map<String, Account> accounts = new java.util.HashMap<>();

    void open(Account a) { accounts.put(a.getId(), a); }

    Account find(String id) {
        Account a = accounts.get(id);
        if (a == null) throw new AccountNotFoundException(id);
        return a;
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.open(new Account("A1", 500));

        try {
            Account acc = bank.find("A1");
            acc.withdraw(200);
            System.out.println("Balance: " + acc.getBalance());
            acc.withdraw(1000);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("You need " + e.getShortfall() + " more.");
        }

        try {
            bank.find("ZZZ");
        } catch (AccountNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Exception chaining
        try {
            try {
                Integer.parseInt("xyz");
            } catch (NumberFormatException e) {
                throw new IllegalStateException("Config value is invalid", e);
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage() + " <- caused by: " + e.getCause().getClass().getSimpleName());
        }
    }
}
