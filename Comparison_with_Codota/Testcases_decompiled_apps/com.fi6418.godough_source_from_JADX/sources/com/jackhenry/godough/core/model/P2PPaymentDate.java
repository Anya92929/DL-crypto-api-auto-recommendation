package com.jackhenry.godough.core.model;

import java.util.Calendar;

public class P2PPaymentDate extends PaymentDate implements GoDoughType {
    public P2PPaymentDate() {
    }

    public P2PPaymentDate(Calendar calendar, Calendar calendar2) {
        super(calendar, calendar2);
    }
}
