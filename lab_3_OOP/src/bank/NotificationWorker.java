package bank;

import account.Account;

public class NotificationWorker extends BankWorker {

    @Override
    public void processRequest(int requestNumber, Account account) {
        if (account.getAccountOwner().wantsGetMessages()) {
            if (requestNumber == COMMISSION_REQUEST) {
                System.out.println("Отправлено уведомление о комисси.");
            } else if (requestNumber == PERCENT_REQUEST) {
                System.out.println("Отправлено уведомление о процентах");
            }
        }
        processNext(requestNumber, account);
    }


}
