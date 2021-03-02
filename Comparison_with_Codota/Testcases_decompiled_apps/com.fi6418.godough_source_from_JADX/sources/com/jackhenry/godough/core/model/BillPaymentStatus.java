package com.jackhenry.godough.core.model;

public class BillPaymentStatus extends Status implements GoDoughType {
    private boolean wasBillPaid;

    public BillPaymentStatus(String str) {
        super(str);
    }

    public boolean isWasBillPaid() {
        return this.wasBillPaid;
    }

    public void setWasBillPaid(boolean z) {
        this.wasBillPaid = z;
    }
}
