package com.jackhenry.godough.core.model;

import java.util.List;

public class P2PPaymentDatesResponse {
    private List<P2PPaymentDate> p2PPaymentDates;

    public List<P2PPaymentDate> getP2PPaymentDates() {
        return this.p2PPaymentDates;
    }

    public void setBillPayPaymentDates(List<P2PPaymentDate> list) {
        this.p2PPaymentDates = list;
    }
}
