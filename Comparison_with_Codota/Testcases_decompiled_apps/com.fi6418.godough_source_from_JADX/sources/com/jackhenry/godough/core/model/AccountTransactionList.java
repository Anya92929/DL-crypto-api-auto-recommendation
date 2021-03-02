package com.jackhenry.godough.core.model;

import java.util.List;

public class AccountTransactionList implements GoDoughType {
    private List<AccountTransaction> accountTransactions;
    private boolean moreRecords;
    private int nextStartRecord;

    public List<AccountTransaction> getAccountTransactions() {
        return this.accountTransactions;
    }

    public int getNextStartRecord() {
        return this.nextStartRecord;
    }

    public boolean isMoreRecords() {
        return this.moreRecords;
    }

    public void setAccountTransactions(List<AccountTransaction> list) {
        this.accountTransactions = list;
    }

    public void setMoreRecords(boolean z) {
        this.moreRecords = z;
    }

    public void setNextStartRecord(int i) {
        this.nextStartRecord = i;
    }
}
