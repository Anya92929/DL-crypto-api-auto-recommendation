package com.jackhenry.godough.core.model;

public class EmailAddressData implements GoDoughType {
    private static final long serialVersionUID = 1;
    private String customerEmail;
    private EmailUpdateStatus status;

    public String getCustomerEmail() {
        return this.customerEmail;
    }

    public EmailUpdateStatus getStatus() {
        return this.status;
    }

    public void setCustomerEmail(String str) {
        this.customerEmail = str;
    }

    public void setStatus(EmailUpdateStatus emailUpdateStatus) {
        this.status = emailUpdateStatus;
    }
}
