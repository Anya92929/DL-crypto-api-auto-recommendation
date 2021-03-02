package com.jackhenry.godough.core.model;

import java.util.Calendar;

public class Transfer implements GoDoughType {
    private long amount;
    private Account fromAccount;
    private TransferStatus status;
    private Account toAccount;
    private Calendar transferDate;
    private TransferOption transferOption;

    public Transfer() {
    }

    public Transfer(Account account, Account account2, TransferOption transferOption2, long j, Calendar calendar) {
        this.fromAccount = account;
        this.toAccount = account2;
        this.transferOption = transferOption2;
        this.amount = j;
        this.transferDate = calendar;
    }

    public long getAmount() {
        return this.amount;
    }

    public Account getFromAccount() {
        return this.fromAccount;
    }

    public TransferStatus getStatus() {
        return this.status;
    }

    public Account getToAccount() {
        return this.toAccount;
    }

    public Calendar getTransferDate() {
        return this.transferDate;
    }

    public TransferOption getTransferOption() {
        return this.transferOption;
    }

    public void setAmount(long j) {
        this.amount = j;
    }

    public void setFromAccount(Account account) {
        this.fromAccount = account;
    }

    public void setStatus(TransferStatus transferStatus) {
        this.status = transferStatus;
    }

    public void setToAccount(Account account) {
        this.toAccount = account;
    }

    public void setTransferDate(Calendar calendar) {
        this.transferDate = calendar;
    }

    public void setTransferOption(TransferOption transferOption2) {
        this.transferOption = transferOption2;
    }
}
