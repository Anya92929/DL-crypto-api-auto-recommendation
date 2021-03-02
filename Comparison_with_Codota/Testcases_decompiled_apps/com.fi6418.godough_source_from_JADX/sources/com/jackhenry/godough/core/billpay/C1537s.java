package com.jackhenry.godough.core.billpay;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.BillPayment;
import com.jackhenry.godough.core.p038e.C1579h;
import com.jackhenry.godough.core.p038e.C1580i;

/* renamed from: com.jackhenry.godough.core.billpay.s */
class C1537s implements C1579h {

    /* renamed from: a */
    final /* synthetic */ BillPayment f6064a;

    /* renamed from: b */
    final /* synthetic */ C1536r f6065b;

    C1537s(C1536r rVar, BillPayment billPayment) {
        this.f6065b = rVar;
        this.f6064a = billPayment;
    }

    /* renamed from: a */
    public View mo9688a() {
        View inflate = this.f6065b.f6063a.getLayoutInflater((Bundle) null).inflate(C1496ak.bill_pay_submitted, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(C1494ai.confirm_number)).setText(this.f6064a.getStatus().getConfirmationNumber());
        ((TextView) inflate.findViewById(C1494ai.payee)).setText(this.f6064a.getPayee().getName());
        ((TextView) inflate.findViewById(C1494ai.account)).setText(this.f6064a.getAccount().getName());
        ((TextView) inflate.findViewById(C1494ai.amount)).setText(C1580i.m6152a(this.f6064a.getAmount()));
        ((TextView) inflate.findViewById(C1494ai.memo)).setText(this.f6064a.getMemo());
        ((TextView) inflate.findViewById(C1494ai.lbl_date)).setText(GoDoughApp.getUserSettings().getBillPayUserDateLabelText());
        ((TextView) inflate.findViewById(C1494ai.date)).setText(C1580i.m6154a(this.f6064a.getPaymentDate()));
        return inflate;
    }
}
