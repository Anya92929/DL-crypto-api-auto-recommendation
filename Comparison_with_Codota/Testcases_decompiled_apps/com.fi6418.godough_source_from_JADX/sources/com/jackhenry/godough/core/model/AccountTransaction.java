package com.jackhenry.godough.core.model;

import com.jackhenry.godough.core.p038e.C1580i;
import java.util.ArrayList;
import java.util.Calendar;

public class AccountTransaction implements GoDoughType {
    private String accountName;
    private long amount;
    private String description;
    private ArrayList<CheckImageData> images;
    private boolean isCheck;
    private boolean isCredit;
    private Calendar postDate;
    private String referenceNumber;
    private long runningBalance;

    public AccountTransaction() {
    }

    public AccountTransaction(String str, long j, String str2, Calendar calendar, boolean z, boolean z2) {
        this.accountName = str;
        this.amount = j;
        this.description = str2;
        this.postDate = calendar;
        this.isCredit = z;
        this.isCheck = z2;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public long getAmount() {
        return this.amount;
    }

    public String getAmountFormatted() {
        return C1580i.m6153a(this.amount, this.isCredit);
    }

    public String getDescription() {
        return this.description;
    }

    public ArrayList<CheckImageData> getImages() {
        return this.images;
    }

    public Calendar getPostDate() {
        return this.postDate;
    }

    public String getPostDateFormatted() {
        return C1580i.m6154a(this.postDate);
    }

    public String getReferenceNumber() {
        return this.referenceNumber;
    }

    public long getRunningBalance() {
        return this.runningBalance;
    }

    public String getRunningBalanceFormatted() {
        return C1580i.m6152a(this.runningBalance);
    }

    public boolean isCheck() {
        return this.isCheck;
    }

    public boolean isCredit() {
        return this.isCredit;
    }

    public void setAccountName(String str) {
        this.accountName = str;
    }

    public void setAmount(long j) {
        this.amount = j;
    }

    public void setCheck(boolean z) {
        this.isCheck = z;
    }

    public void setCredit(boolean z) {
        this.isCredit = z;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setImages(ArrayList<CheckImageData> arrayList) {
        this.images = arrayList;
    }

    public void setIsCheck(boolean z) {
        this.isCheck = z;
    }

    public void setIsCredit(boolean z) {
        this.isCredit = z;
    }

    public void setPostDate(Calendar calendar) {
        this.postDate = calendar;
    }

    public void setReferenceNumber(String str) {
        this.referenceNumber = str;
    }

    public void setRunningBalance(long j) {
        this.runningBalance = j;
    }

    public String toString() {
        return this.accountName;
    }
}
