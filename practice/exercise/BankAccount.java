package practice.exercise;



public class BankAccount {
    protected double balance;

    public BankAccount() {
        this.balance = 0;
    }

    // Метод для поповнення балансу
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Метод для зняття коштів
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Метод для отримання поточного балансу
    public double getBalance() {
        return balance;
    }
}

