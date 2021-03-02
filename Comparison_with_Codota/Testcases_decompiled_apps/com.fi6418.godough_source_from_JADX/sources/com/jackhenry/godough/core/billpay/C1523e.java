package com.jackhenry.godough.core.billpay;

import com.jackhenry.android.p022a.C1348a;
import com.jackhenry.android.widget.calendar.OnDateChosen;
import com.jackhenry.godough.core.model.BillPayPaymentDate;
import com.jackhenry.godough.core.p034b.p035a.C1510a;
import java.util.Calendar;
import java.util.Iterator;

/* renamed from: com.jackhenry.godough.core.billpay.e */
class C1523e implements OnDateChosen {

    /* renamed from: a */
    final /* synthetic */ C1510a f6044a;

    /* renamed from: b */
    final /* synthetic */ BillPayFragment f6045b;

    C1523e(BillPayFragment billPayFragment, C1510a aVar) {
        this.f6045b = billPayFragment;
        this.f6044a = aVar;
    }

    public void onDateChosen(Calendar calendar) {
        BillPayPaymentDate unused = this.f6045b.f6020ap = null;
        if (this.f6045b.f6023as != null) {
            Iterator it = this.f6045b.f6023as.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BillPayPaymentDate billPayPaymentDate = (BillPayPaymentDate) it.next();
                if (C1348a.m5555a(billPayPaymentDate.getProcessedDate(), calendar)) {
                    BillPayPaymentDate unused2 = this.f6045b.f6020ap = billPayPaymentDate;
                    break;
                }
            }
        }
        this.f6045b.m6039u();
        this.f6045b.m6044x();
        this.f6044a.dismiss();
    }
}
