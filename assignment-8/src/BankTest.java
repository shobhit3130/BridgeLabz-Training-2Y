// Superclass: BankAccount
class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayAccountType() {
        System.out.println("Generic Bank Account");
    }

    void showBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    void displayAccountType() {
        System.out.println("Savings Account with Interest Rate: " + interestRate + "%");
    }
}

// Subclass: CheckingAccount
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    void displayAccountType() {
        System.out.println("Checking Account with Withdrawal Limit: ₹" + withdrawalLimit);
    }
}

// Subclass: FixedDepositAccount
class FixedDepositAccount extends BankAccount {
    int maturityPeriod; // in months

    FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }

    @Override
    void displayAccountType() {
        System.out.println("Fixed Deposit Account with Maturity Period: " + maturityPeriod + " months");
    }
}

// Main class to test hierarchical inheritance
public class BankTest {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA123", 15000.0, 4.5);
        CheckingAccount ca = new CheckingAccount("CA456", 8000.0, 5000.0);
        FixedDepositAccount fda = new FixedDepositAccount("FD789", 50000.0, 12);

        sa.displayAccountType();
        sa.showBalance();

        System.out.println();

        ca.displayAccountType();
        ca.showBalance();

        System.out.println();

        fda.displayAccountType();
        fda.showBalance();
    }
}