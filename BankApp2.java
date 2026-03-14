/*
the bad thing in the original code:

all attributes were public which breaks encapsulation
balance could become negative because there was no validation
code repetition transfer validation was written multiple times
logic should be inside the class instead of repeated in main
*/

class BankAccount {
    private double balance;

    public BankAccount(String owner, double balance) {
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
}

public class BankApp2 {
    public static void main(String[] args) {

        BankAccount mohamed = new BankAccount("Mohamed", 1000);
        BankAccount ahmed = new BankAccount("Ahmed", 500);

        if (mohamed.transfer(ahmed, 1500)) {
            System.out.println("Transaction 1 completed");
        } else {
            System.out.println("Transaction 1 failed");
        }

        if (mohamed.transfer(ahmed, 1200)) {
            System.out.println("Transaction 2 completed");
        } else {
            System.out.println("Transaction 2 failed");
        }
    }
}
