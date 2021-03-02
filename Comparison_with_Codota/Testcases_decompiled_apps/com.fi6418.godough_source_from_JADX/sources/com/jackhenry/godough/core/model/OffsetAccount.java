package com.jackhenry.godough.core.model;

public class OffsetAccount implements GoDoughType {
    private String accountNumber;
    private String accountType;
    private String pseudoName;

    public OffsetAccount() {
    }

    public OffsetAccount(String str, String str2, String str3) {
        this.pseudoName = str;
        this.accountNumber = str2;
        this.accountType = str3;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public String getPseudoName() {
        return this.pseudoName;
    }

    public void setAccountNumber(String str) {
        this.accountNumber = str;
    }

    public void setAccountType(String str) {
        this.accountType = str;
    }

    public void setPseudoName(String str) {
        this.pseudoName = str;
    }

    public String toString() {
        return getPseudoName();
    }
}
