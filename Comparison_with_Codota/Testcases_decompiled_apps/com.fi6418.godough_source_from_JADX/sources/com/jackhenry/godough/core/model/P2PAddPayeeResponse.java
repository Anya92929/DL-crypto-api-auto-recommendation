package com.jackhenry.godough.core.model;

public class P2PAddPayeeResponse {
    private P2PPayee addedPayee;
    private String message;
    private boolean wasSuccessful;

    public P2PPayee getAddedPayee() {
        return this.addedPayee;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean getWasSuccessful() {
        return this.wasSuccessful;
    }

    public void setAddedPayee(P2PPayee p2PPayee) {
        this.addedPayee = p2PPayee;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setWasSuccessful(boolean z) {
        this.wasSuccessful = z;
    }
}
