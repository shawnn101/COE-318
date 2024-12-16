package coe318.lab4;

/**
 * Account class
 * 
 * @author afsa nuyeri
 */
public class Account {
    String accountName;
    double money;
    int id;

    // Constructor
    public Account(String a, int i, double m) {
        this.accountName = a;
        this.id = i;
        this.money = m;
    }

    // Getter for account name
    public String getName() {
        return this.accountName;
    }

    // Getter for account balance
    public double getBalance() {
        return this.money;
    }

    // Getter for account ID/number
    public int getNumber() {
        return this.id;
    }

    // Deposit method
    public boolean deposit(double amount) {
        if (amount > 0) {
            this.money += amount;
            return true;
        } else {
            return false; // If amount is zero or negative, deposit fails
        }
    }

    // Withdraw method
    public boolean withdraw(double amount) {
        if (amount > 0 && this.money >= amount) {
            this.money -= amount;
            return true; // Successful withdrawal
        } else {
            return false; // Withdrawal fails if amount is invalid or exceeds balance
        }
    }

    // toString method to display account details
    @Override
    public String toString() {
        // DO NOT MODIFY
        return "(" + getName() + ", " + getNumber() + ", " + String.format("$%.2f", getBalance()) + ")";
    }
}
