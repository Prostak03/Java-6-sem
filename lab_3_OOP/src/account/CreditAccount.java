package account;

import client.Client;

public class CreditAccount extends AbstractAccount implements Account {

    private double limit;
    private double commission;

    public CreditAccount(Client client, double balance, double limit, double commission) {
        super(client, balance);
        this.limit = limit * -1;
        this.commission = commission;
    }

    @Override
    public void withdrawal(double value) {
        if (this.balance - value < limit) {
            System.out.println("[Credit] Превышен кредитный лимит.");
        } else {
            this.balance -= value;
            if (this.balance < 0)
                this.balance -= commission;
            System.out.println("[Credit] Успешное снятие наличных.");
        }
    }

    @Override
    public void applyPercent() {

    }

    @Override
    public void applyCommission() {
        this.balance = this.balance - this.commission;
    }


}
