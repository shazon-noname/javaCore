package practice;

public class CardAccount extends BankAccount {
    @Override
    public double getBalance() {
        return super.getBalance();
    }

    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount * 1.01);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }

    public CardAccount() {
        super();
    }
}

