package com.jackhenry.godough.core.model;

import com.jackhenry.godough.core.p038e.C1580i;
import java.util.Calendar;

public class Payment implements GoDoughType {
    private Account account;
    private long amount;
    private String memo;
    private Payee payee;
    private Calendar paymentDate;
    private Status status;

    public Payment() {
    }

    public Payment(Payee payee2, Account account2, Calendar calendar, long j, String str) {
        this.account = account2;
        this.payee = payee2;
        this.paymentDate = calendar;
        this.amount = j;
        this.memo = str;
    }

    public Account getAccount() {
        return this.account;
    }

    public long getAmount() {
        return this.amount;
    }

    public String getAmountFormatted() {
        return C1580i.m6152a(this.amount);
    }

    public String getMemo() {
        return this.memo;
    }

    public Payee getPayee() {
        return this.payee;
    }

    public Calendar getPaymentDate() {
        return this.paymentDate;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setAccount(Account account2) {
        this.account = account2;
    }

    public void setAmount(long j) {
        this.amount = j;
    }

    public void setMemo(String str) {
        this.memo = str;
    }

    public void setPayee(Payee payee2) {
        this.payee = payee2;
    }

    public void setPaymentDate(Calendar calendar) {
        this.paymentDate = calendar;
    }

    public void setStatus(Status status2) {
        this.status = status2;
    }
}
