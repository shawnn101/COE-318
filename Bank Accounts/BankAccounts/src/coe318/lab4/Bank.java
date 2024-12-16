package coe318.lab4;

/**
 * Bank class that manages multiple accounts.
 * 
 * @author afsa nuyeri
 */
public class Bank {
    private String name;
    /**
     * An array of Accounts managed by this bank.
     */
    private Account[] accounts;
    private int numAccounts; // Number of active accounts

    public Bank(String name, int maxNumberAccounts) {
        this.name = name;
        accounts = new Account[maxNumberAccounts]; // Initialize accounts array
        numAccounts = 0;
    }

    /**
     * @return the name of the bank
     */
    public String getName() {
        return this.name;  // Returns the bank's name
    }

    /**
     * @return the number of active accounts
     */
    public int getNumAccounts() {
        return this.numAccounts; // Returns the number of active accounts
    }

    /**
     * @return the array of accounts managed by this bank
     */
    public Account[] getAccounts() {
        return this.accounts; // Returns the accounts array
    }

    /**
     * Return true if the Bank already has an account with this number; otherwise, false.
     * @param accountNumber the account number to check
     * @return true if an account with the given number exists
     */
    public boolean hasAccountNumber(int accountNumber) {
        for (int i = 0; i < numAccounts; i++) {  // Iterate over the active accounts only
            if (accounts[i] != null && accounts[i].getNumber() == accountNumber) {
                return true; // Account with matching number found
            }
        }
        return false; // No account with this number exists
    }

    /**
     * Adds the specified account to the Bank if possible. If the account number
     * already exists or the Bank has reached its maximum number of accounts,
     * return false and do not add it; otherwise, add it and return true.
     * @param account the account to add
     * @return true if the account is added successfully
     */
    public boolean add(Account account) {
        if (hasAccountNumber(account.getNumber())) {
            return false; // Account with the same number already exists
        }
        if (numAccounts < accounts.length) { // Ensure there's room for more accounts
            accounts[numAccounts] = account; // Add the account
            numAccounts++; // Increment the count of active accounts
            return true;
        }
        return false; // Bank has reached the maximum number of accounts
    }

    @Override
    public String toString() {
        // DO NOT MODIFY THIS CODE
        String s = getName() + ": " + getNumAccounts() +
                " of " + getAccounts().length +
                " accounts open";
        for (Account account : getAccounts()) {
            if (account == null) break;
            s += "\n  " + account;
        }
        return s;
    }
}
