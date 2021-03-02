package com.jackhenry.godough.core.model;

import java.util.List;

public class BillPayPaymentDatesResponse {
    private List<BillPayPaymentDate> billPayPaymentDates;

    public List<BillPayPaymentDate> getBillPayPaymentDates() {
        return this.billPayPaymentDates;
    }

    public void setBillPayPaymentDates(List<BillPayPaymentDate> list) {
        this.billPayPaymentDates = list;
    }
}
