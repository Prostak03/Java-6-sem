import bank.*;
import account.*;
import client.*;
import java.util.Date;


public class Main {

    public static void main(String[] args) {
        final double commission = 30.0;
        final double percent = 2.1;
        final double maxSuspiciousAmount = 1000.0;

        BankWorker bankWorker = new CashWorker();
        bankWorker.setNextWorker(new NotificationWorker());

        System.out.println("\n\nСоздаем кредитный аккаунт");
        Client bankClient =  new Client.Builder()
                .withName("Oleg", "Naumov")
                .withAddress("Moscow")
                .withPassportNumber("999999")
                .withMessages(true)
                .build();

        AccountFactory accountFactory = new AccountFactory(commission, percent, maxSuspiciousAmount);
        Account creditAccount = accountFactory.newCreditAccount(bankClient, 10000.0, 1000.0);
        System.out.println("Текущий баланс: " + creditAccount.getBalance());
        creditAccount.deposit(500.0);
        creditAccount.withdrawal(11000.0);
        System.out.println("Текущий баланс: " + creditAccount.getBalance());

        bankWorker.processRequest(0, creditAccount);
        System.out.println("Текущий баланс: " + creditAccount.getBalance());

        System.out.println("\n\nСоздаем подозрительный депозитный аккаунт");
        Client suspiciousClient = new Client.Builder()
                .withFirstName("Ilya")
                .withSecondName("Markushev")
                .build();

        Account depositAccount = accountFactory.newDepositAccount(suspiciousClient, 2000.0, new Date());
        System.out.println("Текущий баланс: " + depositAccount.getBalance());
        depositAccount.withdrawal(2000);
        System.out.println("Текущий баланс: " + depositAccount.getBalance());
    }
}
