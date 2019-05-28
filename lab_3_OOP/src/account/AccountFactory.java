package account;

import client.Client;
import java.util.Date;

public class AccountFactory {

    private double creditCommission;
    private double depositPercent;
    private double maxSuspiciousAmount;

    public AccountFactory(double creditCommission, double depositPercent, double maxSuspiciousAmount) {
        this.creditCommission = creditCommission;
        this.maxSuspiciousAmount = maxSuspiciousAmount;
        this.depositPercent = depositPercent;
    }

    public Account newSimpleAccount(Client client, double balance) {
        return verifyAccount(new SimpleAccount(client, balance));
    }

    public Account newDepositAccount(Client client, double balance, Date depositDate) {
        return verifyAccount(new DepositAccount(client, balance, depositDate, this.depositPercent));
    }

    public Account newCreditAccount(Client client, double balance, double limit) {
        return verifyAccount(new CreditAccount(client, balance, limit, this.creditCommission));
    }

    public Account verifyAccount(Account account) {
        return account.getAccountOwner().isSuspicious() ? new SuspiciousAccount(account, this.maxSuspiciousAmount) : account;
    }
}
