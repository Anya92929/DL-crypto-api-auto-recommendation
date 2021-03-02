package com.jackhenry.godough.core.model;

import com.jackhenry.godough.core.p038e.C1580i;
import java.util.Calendar;

public class PaymentDate implements GoDoughType {
    private Calendar deliveredDate;
    private Calendar processedDate;

    public PaymentDate() {
    }

    public PaymentDate(Calendar calendar, Calendar calendar2) {
        this.processedDate = calendar;
        this.deliveredDate = calendar2;
    }

    public Calendar getDeliveredDate() {
        return this.deliveredDate;
    }

    public String getDeliveredDateFormatted() {
        return C1580i.m6154a(this.deliveredDate);
    }

    public Calendar getProcessedDate() {
        return this.processedDate;
    }

    public String getProcessedDateFormatted() {
        return C1580i.m6154a(this.processedDate);
    }

    public void setDeliveredDate(Calendar calendar) {
        this.deliveredDate = calendar;
    }

    public void setProcessedDate(Calendar calendar) {
        this.processedDate = calendar;
    }
}
