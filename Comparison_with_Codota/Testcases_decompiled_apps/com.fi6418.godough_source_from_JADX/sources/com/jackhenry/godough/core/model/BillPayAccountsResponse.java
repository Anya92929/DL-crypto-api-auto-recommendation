package com.jackhenry.godough.core.model;

import java.util.List;

public class BillPayAccountsResponse {
    private List<Account> billPayAccounts;

    public List<Account> getBillPayAccounts() {
        return this.billPayAccounts;
    }

    public void setBillPayAccounts(List<Account> list) {
        this.billPayAccounts = list;
    }
}
