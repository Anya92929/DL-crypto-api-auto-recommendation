package com.jackhenry.godough.core.model;

import com.jackhenry.godough.core.p038e.C1580i;

public class Account implements GoDoughType {
    private String accountGroup;
    private String accountType;
    private long availableBalance;
    private String availableBalanceDisclosureText;
    private String availableBalanceLabel;
    private long currentBalance;
    private String currentBalanceLabel;
    private long fiDefinedBalance;

    /* renamed from: id */
    private String f6501id;
    private String name;
    private boolean showAvailableBalance;
    private boolean showBalance;
    private boolean showCurrentBalance;

    public enum BalanceType {
        AVAILABLE,
        CURRENT,
        FIDEFINED
    }

    public Account() {
    }

    public Account(String str, String str2, long j, long j2, boolean z, String str3, long j3, boolean z2, boolean z3, String str4, String str5, String str6) {
        this.name = str;
        this.accountType = str2;
        this.fiDefinedBalance = j;
        this.availableBalance = j2;
        this.showBalance = z;
        this.f6501id = str3;
        this.currentBalance = j3;
        this.showAvailableBalance = z2;
        this.showCurrentBalance = z3;
        this.availableBalanceLabel = str4;
        this.currentBalanceLabel = str5;
        this.availableBalanceDisclosureText = str6;
    }

    public String getAccountGroup() {
        return this.accountGroup == null ? "" : this.accountGroup;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public long getAvailableBalance() {
        return this.availableBalance;
    }

    public String getAvailableBalanceDisclosureText() {
        return this.availableBalanceDisclosureText;
    }

    public String getAvailableBalanceFormatted() {
        return C1580i.m6152a(this.availableBalance);
    }

    public String getAvailableBalanceLabel() {
        return this.availableBalanceLabel;
    }

    public long getCurrentBalance() {
        return this.currentBalance;
    }

    public String getCurrentBalanceFormatted() {
        return C1580i.m6152a(this.currentBalance);
    }

    public String getCurrentBalanceLabel() {
        return this.currentBalanceLabel;
    }

    public long getFiDefinedBalance() {
        return this.fiDefinedBalance;
    }

    public String getFiDefinedBalanceFormatted() {
        return C1580i.m6152a(this.fiDefinedBalance);
    }

    public String getId() {
        return this.f6501id;
    }

    public String getName() {
        return this.name;
    }

    public boolean isShowAvailableBalance() {
        return this.showAvailableBalance;
    }

    public boolean isShowBalance() {
        return this.showBalance;
    }

    public boolean isShowCurrentBalance() {
        return this.showCurrentBalance;
    }

    public void setAccountGroup(String str) {
        this.accountGroup = str;
    }

    public void setAccountType(String str) {
        this.accountType = str;
    }

    public void setAvailableBalance(long j) {
        this.availableBalance = j;
    }

    public void setAvailableBalanceDisclosureText(String str) {
        this.availableBalanceDisclosureText = str;
    }

    public void setAvailableBalanceLabel(String str) {
        this.availableBalanceLabel = str;
    }

    public void setCurrentBalance(long j) {
        this.currentBalance = j;
    }

    public void setCurrentBalanceLabel(String str) {
        this.currentBalanceLabel = str;
    }

    public void setFiDefinedBalance(long j) {
        this.fiDefinedBalance = j;
    }

    public void setId(String str) {
        this.f6501id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setShowAvailableBalance(boolean z) {
        this.showAvailableBalance = z;
    }

    public void setShowBalance(boolean z) {
        this.showBalance = z;
    }

    public void setShowCurrentBalance(boolean z) {
        this.showCurrentBalance = z;
    }

    public String toString() {
        return this.name;
    }
}
