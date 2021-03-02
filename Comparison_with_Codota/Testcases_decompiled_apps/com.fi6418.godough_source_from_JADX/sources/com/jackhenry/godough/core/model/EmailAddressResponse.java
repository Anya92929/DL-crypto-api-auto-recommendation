package com.jackhenry.godough.core.model;

public class EmailAddressResponse {
    private EmailAddressData emailAddressData;
    private Redirect redirect;

    public EmailAddressData getEmailAddressData() {
        return this.emailAddressData;
    }

    public Redirect getRedirect() {
        return this.redirect;
    }

    public void setEmailAddressData(EmailAddressData emailAddressData2) {
        this.emailAddressData = emailAddressData2;
    }

    public void setRedirect(Redirect redirect2) {
        this.redirect = redirect2;
    }
}
