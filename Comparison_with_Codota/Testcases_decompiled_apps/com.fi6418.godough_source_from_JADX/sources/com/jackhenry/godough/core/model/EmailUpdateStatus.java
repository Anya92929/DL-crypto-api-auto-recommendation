package com.jackhenry.godough.core.model;

public class EmailUpdateStatus extends Status implements GoDoughType {
    private static final long serialVersionUID = 1;
    private boolean success;

    public EmailUpdateStatus(String str) {
        super(str);
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
