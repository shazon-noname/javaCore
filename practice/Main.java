package practice;

public class Main {
    public static void main(String[] args) {
        CardAccount cardAccount = new CardAccount();
        DepositAccount depositAccount = new DepositAccount();

        // Робота з депозитним рахунком
        System.out.println("=== Депозитний рахунок ===");
        depositAccount.deposit(100);
        System.out.println("Баланс після поповнення: " + depositAccount.getBalance());
        depositAccount.withdraw(50); // Спроба зняти до завершення місяця
        System.out.println("Баланс після спроби зняття: " + depositAccount.getBalance());

        // Робота з картковим рахунком
        System.out.println("\n=== Картковий рахунок ===");
        cardAccount.deposit(100);
        System.out.println("Баланс після поповнення: " + cardAccount.getBalance());
        cardAccount.withdraw(50); // Зняття з комісією
        System.out.println("Баланс після зняття: " + cardAccount.getBalance());
    }
}
