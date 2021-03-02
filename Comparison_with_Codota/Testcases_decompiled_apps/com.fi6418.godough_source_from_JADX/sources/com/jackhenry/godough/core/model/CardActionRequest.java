package com.jackhenry.godough.core.model;

public class CardActionRequest implements GoDoughType {
    private int cardAction;
    private String cardNumber;
    private String cardNumberSuffix;
    private String requestToken;

    public int getCardAction() {
        return this.cardAction;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public String getCardNumberSuffix() {
        return this.cardNumberSuffix;
    }

    public String getRequestToken() {
        return this.requestToken;
    }

    public void setCardAction(int i) {
        this.cardAction = i;
    }

    public void setCardNumber(String str) {
        this.cardNumber = str;
    }

    public void setCardNumberSuffix(String str) {
        this.cardNumberSuffix = str;
    }

    public void setRequestToken(String str) {
        this.requestToken = str;
    }
}
