package com.jackhenry.godough.core.model;

public class WiresRequest implements GoDoughType {
    private String debitAccountName;
    private String pin;
    private String requestToken;
    private long sequenceNumber;

    public String getDebitAccountName() {
        return this.debitAccountName;
    }

    public String getPin() {
        return this.pin;
    }

    public String getRequestToken() {
        return this.requestToken;
    }

    public long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public void setDebitAccountName(String str) {
        this.debitAccountName = str;
    }

    public void setPin(String str) {
        this.pin = str;
    }

    public void setRequestToken(String str) {
        this.requestToken = str;
    }

    public void setSequenceNumber(long j) {
        this.sequenceNumber = j;
    }
}
