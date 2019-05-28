package account;

import client.Client;

public interface Account {
    void withdrawal(double value);
    void deposit(double value);
    void transfer(Account account, double value);

    void applyPercent();
    void applyCommission();

    double getBalance();
    Client getAccountOwner();
}
