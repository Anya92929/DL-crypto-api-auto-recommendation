package com.jackhenry.godough.core.model;

import java.util.List;

public class P2PAccountsResponse {
    private List<Account> p2PAccounts;

    public List<Account> getP2PAccounts() {
        return this.p2PAccounts;
    }

    public void setP2PAccounts(List<Account> list) {
        this.p2PAccounts = list;
    }
}
