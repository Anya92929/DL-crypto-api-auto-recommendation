package com.jackhenry.godough.core.model;

import java.util.List;

public class AccountGroup implements GoDoughType {
    private List<Account> accounts;
    private String name;

    public AccountGroup() {
    }

    public AccountGroup(String str, List<Account> list) {
        this.name = str;
        this.accounts = list;
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }

    public String getName() {
        return this.name;
    }

    public void setAccounts(List<Account> list) {
        this.accounts = list;
    }

    public void setName(String str) {
        this.name = str;
    }
}
