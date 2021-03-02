package com.jackhenry.godough.core.model;

public class TermsAndConditions implements GoDoughType {
    private static final long serialVersionUID = 1;
    private String termsAndConditions;

    public String getTermsAndConditions() {
        return this.termsAndConditions;
    }

    public void setTermsAndConditions(String str) {
        this.termsAndConditions = str;
    }
}
