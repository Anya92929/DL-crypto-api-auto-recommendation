package com.jackhenry.godough.core.model;

import java.util.List;

public class DepositAccountResponse {
    private List<DepositAccount> rdaAccounts;

    public List<DepositAccount> getRdaAccounts() {
        return this.rdaAccounts;
    }

    public void setRdaAccounts(List<DepositAccount> list) {
        this.rdaAccounts = list;
    }
}
