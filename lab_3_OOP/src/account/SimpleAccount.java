package account;

import client.Client;


public class SimpleAccount extends AbstractAccount implements Account {

    public SimpleAccount(Client client, double balance) {
        super(client, balance);
    }

    @Override
    public void withdrawal(double value) {
        if (this.balance < value) {
            System.out.println("[Default] Недостаточно средств.");
        } else {
            this.balance -= value;
            System.out.println("[Default] Успешное снятие наличных.");
        }
    }

    @Override
    public void applyPercent() { }

    @Override
    public void applyCommission() { }
}
