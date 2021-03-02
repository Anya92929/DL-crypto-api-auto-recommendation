package com.jackhenry.godough.core.model;

import java.util.List;

public class BillPayPayeesResponse {
    private List<BillPayPayee> billPayPayees;

    public List<BillPayPayee> getBillPayPayees() {
        return this.billPayPayees;
    }

    public void setBillPayPayees(List<BillPayPayee> list) {
        this.billPayPayees = list;
    }
}
