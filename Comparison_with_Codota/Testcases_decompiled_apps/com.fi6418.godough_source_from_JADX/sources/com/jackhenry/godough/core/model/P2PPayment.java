package com.jackhenry.godough.core.model;

import java.util.Calendar;

public class P2PPayment extends Payment implements GoDoughType {
    private P2PPaymentStatus p2PPaymentStatus;

    public P2PPayment() {
    }

    public P2PPayment(Payee payee, Account account, Calendar calendar, long j, String str) {
        super(payee, account, calendar, j, str);
    }

    public P2PPaymentStatus getP2PPaymentStatus() {
        return this.p2PPaymentStatus;
    }

    public void setP2PPaymentStatus(P2PPaymentStatus p2PPaymentStatus2) {
        this.p2PPaymentStatus = p2PPaymentStatus2;
    }
}
