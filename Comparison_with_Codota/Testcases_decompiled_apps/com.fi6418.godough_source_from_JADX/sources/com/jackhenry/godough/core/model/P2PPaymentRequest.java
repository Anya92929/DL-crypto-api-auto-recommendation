package com.jackhenry.godough.core.model;

public class P2PPaymentRequest extends PaymentRequest {
    public P2PPaymentRequest() {
    }

    public P2PPaymentRequest(P2PPayment p2PPayment) {
        super(p2PPayment);
    }
}
