package practice;


public class Main {
    public static void main(String[] args) {
        CardAccount cardAccount = new CardAccount();
        DepositAccount depositAccount = new DepositAccount();

        depositAccount.deposit(100);
        depositAccount.withdraw(50);

        cardAccount.deposit(100);
        cardAccount.withdraw(50);
        System.out.println(cardAccount.getBalance());

    }
}
