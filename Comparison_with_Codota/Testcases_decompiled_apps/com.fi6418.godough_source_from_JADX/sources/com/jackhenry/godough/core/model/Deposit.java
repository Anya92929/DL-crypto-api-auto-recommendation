package com.jackhenry.godough.core.model;

public class Deposit implements GoDoughType {
    private DepositAccount account;
    private Long amount;
    private byte[] backCheckImage;
    private byte[] frontCheckImage;
    private DepositStatus status;

    public enum Side {
        FRONT,
        BACK
    }

    public DepositAccount getAccount() {
        return this.account;
    }

    public Long getAmount() {
        return this.amount;
    }

    public double getAmountAsDouble() {
        return ((double) this.amount.longValue()) / 100.0d;
    }

    public byte[] getBackCheckImage() {
        return this.backCheckImage;
    }

    public byte[] getFrontCheckImage() {
        return this.frontCheckImage;
    }

    public DepositStatus getStatus() {
        return this.status;
    }

    public void setAccount(DepositAccount depositAccount) {
        this.account = depositAccount;
    }

    public void setAmount(long j) {
        this.amount = Long.valueOf(j);
    }

    public void setBackCheckImage(byte[] bArr) {
        this.backCheckImage = bArr;
    }

    public void setFrontCheckImage(byte[] bArr) {
        this.frontCheckImage = bArr;
    }

    public void setStatus(DepositStatus depositStatus) {
        this.status = depositStatus;
    }
}
