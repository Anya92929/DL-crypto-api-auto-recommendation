package com.jackhenry.godough.core.model;

import com.jackhenry.godough.core.p038e.C1580i;

public class WireDebitAccount implements GoDoughType {
    private String debitAccountName;
    private long fiDefinedBalance;

    public WireDebitAccount() {
    }

    public WireDebitAccount(String str, long j) {
        this.debitAccountName = str;
        this.fiDefinedBalance = j;
    }

    public String getDebitAccountName() {
        return this.debitAccountName;
    }

    public long getFiDefinedBalance() {
        return this.fiDefinedBalance;
    }

    public String getFiDefinedBalanceFormatted() {
        return C1580i.m6152a(this.fiDefinedBalance);
    }

    public void setDebitAccountName(String str) {
        this.debitAccountName = str;
    }

    public void setFiDefinedBalance(long j) {
        this.fiDefinedBalance = j;
    }
}
