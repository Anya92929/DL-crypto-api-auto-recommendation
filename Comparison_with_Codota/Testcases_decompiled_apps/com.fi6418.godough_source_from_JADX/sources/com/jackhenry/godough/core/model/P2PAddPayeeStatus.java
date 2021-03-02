package com.jackhenry.godough.core.model;

public class P2PAddPayeeStatus extends Status {
    private static final long serialVersionUID = 1;
    private boolean wasSuccessful;

    public P2PAddPayeeStatus(String str, boolean z) {
        super(str);
        this.wasSuccessful = z;
    }

    public boolean getWasSuccessful() {
        return this.wasSuccessful;
    }

    public void setWasSuccessful(boolean z) {
        this.wasSuccessful = z;
    }
}
