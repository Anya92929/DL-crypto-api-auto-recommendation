package com.jackhenry.godough.core.model;

import java.util.List;

public class FromAccountList implements GoDoughType {
    private List<Account> fromAccounts;

    public List<Account> getAccounts() {
        return this.fromAccounts;
    }

    public void setAccounts(List<Account> list) {
        this.fromAccounts = list;
    }
}
