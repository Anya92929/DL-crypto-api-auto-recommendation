package com.jackhenry.godough.core.model;

import java.util.List;

public class TransferToAccountList implements GoDoughType {
    private List<TransferToAccount> toAccounts;

    public TransferToAccountList() {
    }

    public TransferToAccountList(List<TransferToAccount> list) {
        this.toAccounts = list;
    }

    public List<TransferToAccount> getAccounts() {
        return this.toAccounts;
    }

    public void setAccounts(List<TransferToAccount> list) {
        this.toAccounts = list;
    }
}
