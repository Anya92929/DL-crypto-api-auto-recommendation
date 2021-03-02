package com.jackhenry.godough.core.model;

public class BillPaymentRequest extends PaymentRequest {
    public BillPaymentRequest() {
    }

    public BillPaymentRequest(BillPayment billPayment) {
        super(billPayment);
    }
}
