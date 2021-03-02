package com.jackhenry.godough.core.model;

public class P2PPayee extends Payee implements GoDoughType {
    private P2PAddPayeeStatus addPayeeStatus;
    private String email;
    private String keyword;
    private String message;

    public P2PPayee() {
    }

    public P2PPayee(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public P2PPayee(String str, String str2, String str3, String str4, String str5) {
        super(str, str2, str3);
        setKeyword(str5);
        this.email = str4;
    }

    public P2PAddPayeeStatus getAddPayeeStatus() {
        return this.addPayeeStatus;
    }

    public String getEmail() {
        return this.email;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public String getMessage() {
        return this.message;
    }

    public void setAddPayeeStatus(P2PAddPayeeStatus p2PAddPayeeStatus) {
        this.addPayeeStatus = p2PAddPayeeStatus;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
