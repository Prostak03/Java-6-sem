package bank;

import account.Account;

public abstract class BankWorker {

    final int COMMISSION_REQUEST = 0;
    final int PERCENT_REQUEST = 1;

    private BankWorker next;

    public BankWorker setNextWorker(BankWorker worker) {
        this.next = worker;
        return this.next;
    }

    public abstract void processRequest(int requestNumber, Account account);

    void processNext(int requestNumber, Account account) {
        if (next != null) {
            next.processRequest(requestNumber, account);
        }
    }
}
