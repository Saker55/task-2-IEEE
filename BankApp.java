/*
the bad thing in the original code:

all attributes were public which breaks encapsulation
balance could become negative because there was no validation
no methods were used to control money transfer
data should be private and accessed through methods
*/

class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public boolean transfer(BankAccount receiver, double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            receiver.balance += amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}

public class BankApp {
    public static void main(String[] args) {

        BankAccount mohamed = new BankAccount("Mohamed", 1000);
        BankAccount ahmed = new BankAccount("Ahmed", 500);

        boolean success = mohamed.transfer(ahmed, 1500);

        if (!success) {
            System.out.println("Transaction failed: Not enough balance");
        }

        System.out.println("Mohamed balance: " + mohamed.getBalance());
        System.out.println("Ahmed balance: " + ahmed.getBalance());
    }
}