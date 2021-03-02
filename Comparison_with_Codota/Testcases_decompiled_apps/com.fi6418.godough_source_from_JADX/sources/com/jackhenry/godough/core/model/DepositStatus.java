package com.jackhenry.godough.core.model;

public class DepositStatus implements GoDoughType {
    private boolean WasDepositSuccessful;
    private String errorMessage;
    private String transactionId;
    private RDAVelocity velocity;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public RDAVelocity getRDAVelocity() {
        return this.velocity;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public boolean isWasDepositSuccessful() {
        return this.WasDepositSuccessful;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setRDAVelocity(RDAVelocity rDAVelocity) {
        this.velocity = rDAVelocity;
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }

    public void setWasDepositSuccessful(boolean z) {
        this.WasDepositSuccessful = z;
    }
}
