package com.jackhenry.godough.core.model;

import java.util.ArrayList;

public class RDAUserRegistrationData implements GoDoughType {
    private ArrayList<RDARegistrationAccount> accountDesignators;
    private ArrayList<RDARegistrationAccount> accounts;
    private String email;
    private String firstName;
    private String lastName;
    private String requestToken;

    public RDAUserRegistrationData() {
    }

    public RDAUserRegistrationData(RDAUserRegistrationData rDAUserRegistrationData, ArrayList<RDARegistrationAccount> arrayList) {
        this.firstName = rDAUserRegistrationData.getFirstName();
        this.lastName = rDAUserRegistrationData.getLastName();
        this.email = rDAUserRegistrationData.getEmail();
        this.accountDesignators = arrayList;
    }

    public RDAUserRegistrationData(String str, String str2, String str3) {
        this.firstName = str;
        this.lastName = str2;
        this.email = str3;
    }

    public ArrayList<RDARegistrationAccount> getAccountDesignators() {
        return this.accountDesignators;
    }

    public ArrayList<RDARegistrationAccount> getAccounts() {
        return this.accounts;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getRequestToken() {
        return this.requestToken;
    }

    public void setAccountDesignators(ArrayList<RDARegistrationAccount> arrayList) {
        this.accountDesignators = arrayList;
    }

    public void setAccounts(ArrayList<RDARegistrationAccount> arrayList) {
        this.accounts = arrayList;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setRequestToken(String str) {
        this.requestToken = str;
    }
}
