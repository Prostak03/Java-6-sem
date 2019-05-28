package account;

import client.Client;


abstract class AbstractAccount implements Account{
    double balance;
    Client accountOwner;

    public AbstractAccount() { }

    public AbstractAccount(Client client, double balance) {
        this.accountOwner = client;
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public Client getAccountOwner() {
        return this.accountOwner;
    }

    public void deposit(double value) {
        balance += value;
    }

    public final void transfer(Account account, double value) {
        if (account.getAccountOwner() == this.accountOwner) {
            withdrawal(value);
            account.deposit(value);
        } else {
            System.out.println("Transfer to this account is not possible.");
        }
    }

    public abstract void withdrawal(double value);

    public abstract void applyPercent();

    public abstract void applyCommission();
}
