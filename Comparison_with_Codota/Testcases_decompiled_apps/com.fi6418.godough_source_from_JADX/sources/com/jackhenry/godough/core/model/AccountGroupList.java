package com.jackhenry.godough.core.model;

import java.util.List;

public class AccountGroupList implements GoDoughType {
    private List<AccountGroup> accountGroups;

    public AccountGroupList() {
    }

    public AccountGroupList(List<AccountGroup> list) {
        this.accountGroups = list;
    }

    public List<AccountGroup> getAccountGroups() {
        return this.accountGroups;
    }

    public void setAccountGroups(List<AccountGroup> list) {
        this.accountGroups = list;
    }
}
