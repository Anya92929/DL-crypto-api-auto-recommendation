package com.jackhenry.godough.core.model;

import com.jackhenry.godough.core.model.Redirect;

public class MFAResponse implements GoDoughType {
    private boolean isBlocked;
    private boolean isSuccess;
    private String message;
    private Redirect redirect;

    public MFAResponse() {
    }

    public MFAResponse(Redirect.RedirectType redirectType) {
        this.isSuccess = true;
        this.redirect = new Redirect(redirectType);
    }

    public MFAResponse(Redirect redirect2) {
        this.isSuccess = true;
        this.redirect = redirect2;
    }

    public MFAResponse(Boolean bool) {
        this.isSuccess = bool.booleanValue();
        this.redirect = new Redirect(Redirect.RedirectType.HOME);
    }

    public MFAResponse(boolean z, String str) {
        this.isBlocked = z;
        this.message = str;
    }

    public String getMessage() {
        return this.message;
    }

    public Redirect getRedirect() {
        return this.redirect;
    }

    public boolean isBlocked() {
        return this.isBlocked;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setBlocked(boolean z) {
        this.isBlocked = z;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setRedirect(Redirect redirect2) {
        this.redirect = redirect2;
    }

    public void setSuccess(boolean z) {
        this.isSuccess = z;
    }
}
