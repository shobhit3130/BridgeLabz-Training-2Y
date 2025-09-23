import java.util.*;

public class BankApp {

    // Account class
    static class Account {
        private String accountNumber;
        private double balance;
        private Bank bank;

        public Account(String accountNumber, double balance, Bank bank) {
            this.accountNumber = accountNumber;
            this.balance = balance;
            this.bank = bank;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        public Bank getBank() {
            return bank;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public void withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
            } else {
                System.out.println("Insufficient funds.");
            }
        }
    }

    // Customer class
    static class Customer {
        private String name;
        private List<Account> accounts;

        public Customer(String name) {
            this.name = name;
            this.accounts = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void addAccount(Account account) {
            accounts.add(account);
        }

        public void viewBalance() {
            System.out.println("Customer: " + name);
            for (Account acc : accounts) {
                System.out.println("  Account: " + acc.getAccountNumber() +
                                   " | Bank: " + acc.getBank().getName() +
                                   " | Balance: $" + acc.getBalance());
            }
        }
    }

    // Bank class
    static class Bank {
        private String name;

        public Bank(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Account openAccount(Customer customer, String accountNumber, double initialDeposit) {
            Account account = new Account(accountNumber, initialDeposit, this);
            customer.addAccount(account);
            return account;
        }
    }

    // Main method to demonstrate association
    public static void main(String[] args) {
        Bank hdfc = new Bank("HDFC Bank");
        Bank sbi = new Bank("SBI Bank");

        Customer raj = new Customer("Raj");

        hdfc.openAccount(raj, "HDFC123", 5000);
        sbi.openAccount(raj, "SBI456", 3000);

        raj.viewBalance();
    }
}