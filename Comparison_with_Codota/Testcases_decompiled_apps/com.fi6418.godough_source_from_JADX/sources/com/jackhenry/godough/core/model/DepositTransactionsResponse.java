package com.jackhenry.godough.core.model;

import java.util.List;

public class DepositTransactionsResponse {
    private List<DepositTransaction> rdaTransactions;

    public List<DepositTransaction> getRdaTransactions() {
        return this.rdaTransactions;
    }

    public void setRdaTransactions(List<DepositTransaction> list) {
        this.rdaTransactions = list;
    }
}
