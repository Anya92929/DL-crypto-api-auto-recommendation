package com.jackhenry.godough.core.model;

import com.jackhenry.godough.p028c.p029a.p030a.C1397a;

public class DepositRequest implements GoDoughType {
    private String accountReferenceId;
    private String accountRoutingNumber;
    private Long amount;
    private String backCheckImage;
    private String frontCheckImage;
    private String requestToken;

    public DepositRequest() {
    }

    public DepositRequest(Deposit deposit) {
        this.accountReferenceId = deposit.getAccount().getReferenceId();
        this.accountRoutingNumber = deposit.getAccount().getRoutingNumber();
        this.amount = deposit.getAmount();
        C1397a aVar = new C1397a();
        this.frontCheckImage = (String) aVar.mo9444a((Object) deposit.getFrontCheckImage());
        this.backCheckImage = (String) aVar.mo9444a((Object) deposit.getBackCheckImage());
    }

    public String getAccountReferenceId() {
        return this.accountReferenceId;
    }

    public String getAccountRoutingNumber() {
        return this.accountRoutingNumber;
    }

    public Long getAmount() {
        return this.amount;
    }

    public double getAmountAsDouble() {
        return (double) (this.amount.longValue() / 100);
    }

    public String getBackCheckImage() {
        return this.backCheckImage;
    }

    public String getFrontCheckImage() {
        return this.frontCheckImage;
    }

    public String getRequestToken() {
        return this.requestToken;
    }

    public void setAccountReferenceId(String str) {
        this.accountReferenceId = str;
    }

    public void setAccountRoutingNumber(String str) {
        this.accountRoutingNumber = str;
    }

    public void setAmount(double d) {
        this.amount = Long.valueOf((long) (100.0d * d));
    }

    public void setBackCheckImage(String str) {
        this.backCheckImage = str;
    }

    public void setFrontCheckImage(String str) {
        this.frontCheckImage = str;
    }

    public void setRequestToken(String str) {
        this.requestToken = str;
    }
}
