package com.jackhenry.godough.core.model;

import java.util.Calendar;

public class BillPayment extends Payment implements GoDoughType {
    private BillPaymentStatus billPaymentStatus;

    public BillPayment() {
    }

    public BillPayment(Payee payee, Account account, Calendar calendar, long j, String str) {
        super(payee, account, calendar, j, str);
    }

    public BillPaymentStatus getStatus() {
        return this.billPaymentStatus;
    }

    public void setStatus(BillPaymentStatus billPaymentStatus2) {
        this.billPaymentStatus = billPaymentStatus2;
    }
}
