package com.jackhenry.godough.core.model;

import java.io.Serializable;

public class MFAPhone implements Serializable {
    private static final long serialVersionUID = 1;
    private String extension;
    private String phoneNumber;
    private String phoneNumberType;

    public enum PhoneType {
        Mobile,
        Home,
        Work,
        Other
    }

    public String getExtension() {
        return this.extension;
    }

    public String getNumber() {
        return this.phoneNumber;
    }

    public int getType() {
        return this.phoneNumberType != null ? PhoneType.valueOf(this.phoneNumberType).ordinal() : PhoneType.Mobile.ordinal();
    }

    public void setExtension(String str) {
        this.extension = str;
    }

    public void setNumber(String str) {
        this.phoneNumber = str;
    }

    public void setType(int i) {
        this.phoneNumberType = PhoneType.values()[i].name();
    }
}
