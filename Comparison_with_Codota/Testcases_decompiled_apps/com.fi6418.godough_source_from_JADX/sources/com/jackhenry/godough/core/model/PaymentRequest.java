package com.jackhenry.godough.core.model;

import com.jackhenry.godough.core.p038e.C1580i;
import java.util.Calendar;

public class PaymentRequest implements GoDoughType {
    private String accountName;
    private long amount;
    private String memo;
    private String payeeId;
    private Calendar paymentDate;
    private String requestToken;

    public PaymentRequest() {
    }

    public PaymentRequest(Payment payment) {
        this.accountName = payment.getAccount().getName();
        this.payeeId = payment.getPayee().getId();
        this.paymentDate = payment.getPaymentDate();
        this.amount = payment.getAmount();
        this.memo = payment.getMemo();
    }

    public String getAccountName() {
        return this.accountName;
    }

    public long getAmount() {
        return this.amount;
    }

    public String getFormattedPaymentDate() {
        return C1580i.m6155b(this.paymentDate);
    }

    public String getMemo() {
        return this.memo;
    }

    public String getPayeeId() {
        return this.payeeId;
    }

    public Calendar getPaymentDate() {
        return this.paymentDate;
    }

    public String getRequestToken() {
        return this.requestToken;
    }

    public void setAccountName(String str) {
        this.accountName = str;
    }

    public void setAmount(long j) {
        this.amount = j;
    }

    public void setMemo(String str) {
        this.memo = str;
    }

    public void setPayeeId(String str) {
        this.payeeId = str;
    }

    public void setPaymentDate(Calendar calendar) {
        this.paymentDate = calendar;
    }

    public void setRequestToken(String str) {
        this.requestToken = str;
    }
}
