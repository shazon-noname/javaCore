package practice;

import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    LocalDate lastIncome;

    public DepositAccount() {
        super();
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            lastIncome = LocalDate.now();
            super.deposit(amount);
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (lastIncome != null && LocalDate.now().minusYears(1).isAfter(lastIncome)) {
            return super.withdraw(amount);
        }
        System.out.println("Неможна знімати гроші, не пройшов ще місяць");
        return false;
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }
}
