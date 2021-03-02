package com.jackhenry.godough.core.model;

public class P2PPaymentStatus extends Status implements GoDoughType {
    private static final long serialVersionUID = 1;
    private boolean isBlocked;
    private Redirect redirect;
    private boolean wasPersonPaid;

    public enum Redirect {
        MFA,
        SPLASH
    }

    public P2PPaymentStatus(String str) {
        super(str);
    }

    public P2PPaymentStatus(String str, Redirect redirect2) {
        super(str);
        this.redirect = redirect2;
    }

    public P2PPaymentStatus(String str, boolean z) {
        super(str);
        this.isBlocked = z;
    }

    public Redirect getRedirect() {
        return this.redirect;
    }

    public boolean isBlocked() {
        return this.isBlocked;
    }

    public boolean isWasPersonPaid() {
        return this.wasPersonPaid;
    }

    public void setBlocked(boolean z) {
        this.isBlocked = z;
    }

    public void setRedirect(Redirect redirect2) {
        this.redirect = redirect2;
    }

    public void setWasPersonPaid(boolean z) {
        this.wasPersonPaid = z;
    }
}
