// Interface: Loanable
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract class: BaseBankAccount (renamed to avoid duplicate "BankAccount")
abstract class BaseBankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BaseBankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation: Getters and Setters
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holderName + " deposited ₹" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(holderName + " withdrew ₹" + amount);
        } else {
            System.out.println("Insufficient balance for " + holderName);
        }
    }

    // Abstract method
    public abstract double calculateInterest();

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: ₹" + balance);
        System.out.println("Interest: ₹" + calculateInterest());
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends BaseBankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04; // 4% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println(getHolderName() + " applied for a loan of ₹" + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000;
    }
}

// Subclass: CurrentAccount
class CurrentAccount extends BaseBankAccount {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.02; // 2% interest
    }
}

// ✅ Public class for main method
public class BankingSystem {
    public static void main(String[] args) {
        BaseBankAccount acc1 = new SavingsAccount("SAV123", "Shobhit", 15000);
        BaseBankAccount acc2 = new CurrentAccount("CUR456", "Harshit", 8000);

        acc1.deposit(2000);
        acc2.withdraw(1000);

        System.out.println("\nSavings Account:");
        acc1.displayAccountDetails();

        System.out.println("\nCurrent Account:");
        acc2.displayAccountDetails();

        // Polymorphic loan check
        if (acc1 instanceof Loanable) {
            Loanable loanAcc = (Loanable) acc1;
            loanAcc.applyForLoan(50000);
            System.out.println("Loan Eligibility: " + loanAcc.calculateLoanEligibility());
        }
    }
}