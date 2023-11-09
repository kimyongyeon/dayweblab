package main.java.bank;

public class BankApp {

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("John Doe", "123456", 1000);
        BankAccount account2 = new BankAccount("Jane Smith", "654321", 1500);

        account1.deposit(500);
        account2.deposit(700);

        tryWithdraw(account1, 1499);
        tryWithdraw(account2, 2201);

        account1.getAccountInfo();
        account2.getAccountInfo();

    }

    private static void tryWithdraw(BankAccount account, int amount) {
        try {
            account.withdraw(amount);
        } catch (NotEnoughBalance e) {
            System.out.println(e.getMessage());
        }
    }

}
