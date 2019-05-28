package account;

import client.Client;


public class SuspiciousAccount implements Account {

    private Account delegateAccount;

    private double maxAmount;

    SuspiciousAccount(Account account, double maxAmount) {
        this.delegateAccount = account;
        this.maxAmount = maxAmount;
    }

    public double getBalance() {
        return delegateAccount.getBalance();
    }

    public Client getAccountOwner() {
        return delegateAccount.getAccountOwner();
    }

    @Override
    public void withdrawal(double value) {
        if (value > this.maxAmount) {
            System.out.println("[Suspicious] Подтвердите аккаунт для выполнения данной операции.");
        } else {
            delegateAccount.withdrawal(value);
        }
    }

    @Override
    public void deposit(double value) {
        delegateAccount.deposit(value);
    }

    @Override
    public void transfer(Account account, double value) {
        if (value > maxAmount) {
            System.out.println("[Suspicious] Подтвердите аккаунт для выполнения данной операции.");
        } else {
            delegateAccount.transfer(account, value);
        }
    }

    @Override
    public void applyPercent() {
        delegateAccount.applyPercent();
    }

    @Override
    public void applyCommission() {
        delegateAccount.applyCommission();
    }
}
