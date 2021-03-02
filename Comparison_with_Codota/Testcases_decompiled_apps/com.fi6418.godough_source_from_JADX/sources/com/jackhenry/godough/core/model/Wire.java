package com.jackhenry.godough.core.model;

import com.jackhenry.godough.core.p038e.C1580i;

public class Wire implements GoDoughType {
    public static final String STATUS_IS_NULL = "STATUS_IS_NULL";
    public static final String STATUS_NEED_APPROVAL = "AP";
    private long amount;
    private String creditAccountNumber;
    private String debitAccountName;
    private String name;
    private String receivingFi;
    private boolean repetitive;
    private WireStatus responseStatus;
    private long sequenceNumber;
    private String status;

    public Wire() {
    }

    public Wire(long j, String str, String str2, String str3, String str4, long j2, String str5, boolean z) {
        this.sequenceNumber = j;
        this.name = str;
        this.debitAccountName = str2;
        this.creditAccountNumber = str3;
        this.receivingFi = str4;
        this.amount = j2;
        this.status = str5;
        this.repetitive = z;
    }

    public long getAmount() {
        return this.amount;
    }

    public String getAmountFormatted() {
        return C1580i.m6152a(this.amount);
    }

    public String getCreditAccountNumber() {
        return this.creditAccountNumber;
    }

    public String getDebitAccountName() {
        return this.debitAccountName;
    }

    public String getName() {
        return this.name;
    }

    public String getReceivingFi() {
        return this.receivingFi;
    }

    public WireStatus getResponseStatus() {
        return this.responseStatus;
    }

    public long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public String getStatus() {
        return this.status == null ? STATUS_IS_NULL : this.status.toUpperCase();
    }

    public boolean isRepetitive() {
        return this.repetitive;
    }

    public void setAmount(long j) {
        this.amount = j;
    }

    public void setCreditAccountNumber(String str) {
        this.creditAccountNumber = str;
    }

    public void setDebitAccountName(String str) {
        this.debitAccountName = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setReceivingFi(String str) {
        this.receivingFi = str;
    }

    public void setRepetitive(boolean z) {
        this.repetitive = z;
    }

    public void setResponseStatus(WireStatus wireStatus) {
        this.responseStatus = wireStatus;
    }

    public void setSequenceNumber(long j) {
        this.sequenceNumber = j;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
