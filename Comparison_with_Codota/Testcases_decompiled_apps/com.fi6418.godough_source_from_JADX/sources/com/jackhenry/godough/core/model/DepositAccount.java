package com.jackhenry.godough.core.model;

public class DepositAccount implements GoDoughType {
    private String accountNumber;
    private String name;
    private String referenceId;
    private String routingNumber;

    public DepositAccount() {
    }

    public DepositAccount(String str, String str2, String str3, String str4) {
        this.name = str;
        this.accountNumber = str2;
        this.referenceId = str3;
        this.routingNumber = str4;
    }

    public static String getFormattedAccount(String str, int i) {
        if (str == null || i >= str.length()) {
            return str == null ? "" : str;
        }
        return String.format("(%1$s)", new Object[]{str.substring(str.length() - i)});
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getReferenceId() {
        return this.referenceId;
    }

    public String getRoutingNumber() {
        return this.routingNumber;
    }

    public void setAccountNumber(String str) {
        this.accountNumber = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setReferenceId(String str) {
        this.referenceId = str;
    }

    public void setRoutingNumber(String str) {
        this.routingNumber = str;
    }

    public String toString() {
        return this.name + " " + getFormattedAccount(getAccountNumber(), 4);
    }
}
