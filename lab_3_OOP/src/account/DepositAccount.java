package account;

import client.Client;
import java.util.Date;


public class DepositAccount extends AbstractAccount implements Account {

    private Date endDate;
    private double percent;

    public DepositAccount(Client client, double balance, Date depositDate, double percent) {
        super(client, balance);
        this.endDate = depositDate;
        this.percent = percent;
    }

    @Override
    public void withdrawal(double value) {
        if (endDate.after(new Date())) {
            System.out.println("[Deposit] Вы не можете снять деньги до наступления даты.");
        } else if (this.balance < value) {
            System.out.println("[Deposit] Недостаточно средств.");
        } else {
            this.balance -= value;
            System.out.println("[Deposit] Успешное снятие наличных.");
        }
    }

    @Override
    public void applyPercent() {
        this.balance = this.balance + this.balance * this.percent / 100;
        System.out.println("[Deposit] Примнял запрос о комиссии.");
    }

    @Override
    public void applyCommission() {

    }
}
