package com.jackhenry.godough.core.p2p;

import com.jackhenry.android.p022a.C1348a;
import com.jackhenry.android.widget.calendar.OnDateChosen;
import com.jackhenry.godough.core.model.P2PPaymentDate;
import com.jackhenry.godough.core.p034b.p035a.C1510a;
import java.util.Calendar;
import java.util.Iterator;

/* renamed from: com.jackhenry.godough.core.p2p.p */
class C1787p implements OnDateChosen {

    /* renamed from: a */
    final /* synthetic */ C1510a f6590a;

    /* renamed from: b */
    final /* synthetic */ P2PFragment f6591b;

    C1787p(P2PFragment p2PFragment, C1510a aVar) {
        this.f6591b = p2PFragment;
        this.f6590a = aVar;
    }

    public void onDateChosen(Calendar calendar) {
        P2PPaymentDate unused = this.f6591b.f6536ao = null;
        if (this.f6591b.f6542au != null) {
            Iterator it = this.f6591b.f6542au.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                P2PPaymentDate p2PPaymentDate = (P2PPaymentDate) it.next();
                if (C1348a.m5555a(p2PPaymentDate.getProcessedDate(), calendar)) {
                    P2PPaymentDate unused2 = this.f6591b.f6536ao = p2PPaymentDate;
                    break;
                }
            }
        }
        this.f6591b.m6592t();
        this.f6591b.m6595v();
        this.f6590a.dismiss();
    }
}
