package com.jackhenry.godough.core.billpay;

import com.jackhenry.godough.core.C1757n;
import com.jackhenry.godough.core.C1759p;
import com.jackhenry.godough.core.model.BillPayPayee;
import com.jackhenry.godough.core.model.BillPayPaymentDate;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.billpay.w */
public class C1541w extends C1757n<List<BillPayPaymentDate>> {

    /* renamed from: e */
    BillPayPayee f6072e;

    public C1541w(BillPayPayee billPayPayee, C1759p<List<BillPayPaymentDate>> pVar) {
        super(new ArrayList(), pVar);
        this.f6072e = billPayPayee;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public List<BillPayPaymentDate> mo9592a(Void... voidArr) {
        return new C1542x().mo9743a(this.f6072e.getId());
    }
}
