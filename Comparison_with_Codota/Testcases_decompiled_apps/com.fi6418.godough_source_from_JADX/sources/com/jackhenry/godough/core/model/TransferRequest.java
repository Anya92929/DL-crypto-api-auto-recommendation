package com.jackhenry.godough.core.model;

import java.util.Calendar;

public class TransferRequest implements GoDoughType {
    private String fromAccountId;
    private String fromAccountName;
    private String requestToken;
    private String toAccountId;
    private String toAccountName;
    private long transferAmount;
    private Calendar transferDate;
    private int transferOption;

    public TransferRequest() {
    }

    public TransferRequest(Transfer transfer) {
        this.fromAccountName = transfer.getFromAccount().getName();
        this.toAccountName = transfer.getToAccount().getName();
        setFromAccountId(transfer.getFromAccount().getId());
        setToAccountId(transfer.getToAccount().getId());
        this.transferAmount = transfer.getAmount();
        if (transfer.getTransferOption() != null) {
            this.transferOption = transfer.getTransferOption().getId();
        }
        this.transferDate = transfer.getTransferDate();
    }

    public String getFromAccountId() {
        return this.fromAccountId;
    }

    public String getFromAccountName() {
        return this.fromAccountName;
    }

    public String getRequestToken() {
        return this.requestToken;
    }

    public String getToAccountId() {
        return this.toAccountId;
    }

    public String getToAccountName() {
        return this.toAccountName;
    }

    public long getTransferAmount() {
        return this.transferAmount;
    }

    public Calendar getTransferDate() {
        return this.transferDate;
    }

    public int getTransferOption() {
        return this.transferOption;
    }

    public void setFromAccountId(String str) {
        this.fromAccountId = str;
    }

    public void setFromAccountName(String str) {
        this.fromAccountName = str;
    }

    public void setRequestToken(String str) {
        this.requestToken = str;
    }

    public void setToAccountId(String str) {
        this.toAccountId = str;
    }

    public void setToAccountName(String str) {
        this.toAccountName = str;
    }

    public void setTransferAmount(long j) {
        this.transferAmount = j;
    }

    public void setTransferDate(Calendar calendar) {
        this.transferDate = calendar;
    }

    public void setTransferOption(int i) {
        this.transferOption = i;
    }
}
