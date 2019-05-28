package bank;

import account.Account;

public class CashWorker extends BankWorker{

    @Override
    public void processRequest(int requestNumber, Account account) {
        if (requestNumber == COMMISSION_REQUEST) {
            account.applyCommission();
            System.out.println("Назначена комиссия для счета с владельцем: " + account.getAccountOwner().getFirstName());
        } else if (requestNumber == PERCENT_REQUEST) {
            System.out.println("Выплачены проценты счету с владельцем: " + account.getAccountOwner().getFirstName());
        }

        processNext(requestNumber, account);
    }
}
