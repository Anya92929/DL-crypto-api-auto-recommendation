package com.jackhenry.godough.core.model;

import java.util.Calendar;

public class BillPayPaymentDate extends PaymentDate implements GoDoughType {
    public BillPayPaymentDate() {
    }

    public BillPayPaymentDate(Calendar calendar, Calendar calendar2) {
        super(calendar, calendar2);
    }
}
