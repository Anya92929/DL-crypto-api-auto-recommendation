package com.jackhenry.godough.core.model;

import com.jackhenry.godough.core.p038e.C1580i;
import java.util.Calendar;

public class DepositTransaction implements GoDoughType {
    private String accountNickname;
    private int category;
    private Calendar dateModified;
    private boolean depositSuccessful;
    private String detailedStatus;
    private long enteredAmount;
    private String errorMessage;
    private boolean iqaPassed;
    private boolean isTransactionSuccessful;
    private Calendar submittedDate;
    private String summaryStatus;
    private String transactionId;

    public DepositTransaction() {
    }

    public DepositTransaction(String str, String str2, boolean z, String str3, long j, String str4, boolean z2, Calendar calendar, Calendar calendar2, String str5, int i) {
        this.transactionId = str;
        this.accountNickname = str2;
        this.depositSuccessful = z;
        this.detailedStatus = str3;
        this.enteredAmount = j;
        this.errorMessage = str4;
        this.iqaPassed = z2;
        this.dateModified = calendar;
        this.submittedDate = calendar2;
        this.summaryStatus = str5;
        this.category = i;
    }

    public String getAccountNickname() {
        return this.accountNickname;
    }

    public int getCategory() {
        return this.category;
    }

    public Calendar getDateModified() {
        return this.dateModified;
    }

    public String getDateModifiedFormatted() {
        return C1580i.m6154a(this.dateModified);
    }

    public String getDetailedStatus() {
        return this.detailedStatus;
    }

    public long getEnteredAmount() {
        return this.enteredAmount;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public Calendar getSubmittedDate() {
        return this.submittedDate;
    }

    public String getSubmittedDateFormatted() {
        return C1580i.m6154a(this.submittedDate);
    }

    public String getSummaryStatus() {
        return this.summaryStatus;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public boolean isDepositSuccessful() {
        return this.depositSuccessful;
    }

    public boolean isIqaPassed() {
        return this.iqaPassed;
    }

    public boolean isTransactionSuccessful() {
        return this.isTransactionSuccessful;
    }

    public void setAccountNickname(String str) {
        this.accountNickname = str;
    }

    public void setCategory(int i) {
        this.category = i;
    }

    public void setDateModified(Calendar calendar) {
        this.dateModified = calendar;
    }

    public void setDepositSuccessful(boolean z) {
        this.depositSuccessful = z;
    }

    public void setDetailedStatus(String str) {
        this.detailedStatus = str;
    }

    public void setEnteredAmount(long j) {
        this.enteredAmount = j;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setIqaPassed(boolean z) {
        this.iqaPassed = z;
    }

    public void setSubmittedDate(Calendar calendar) {
        this.submittedDate = calendar;
    }

    public void setSummaryStatus(String str) {
        this.summaryStatus = str;
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }

    public void setTransactionSuccessful(boolean z) {
        this.isTransactionSuccessful = z;
    }
}
