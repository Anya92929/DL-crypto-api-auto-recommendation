package com.jackhenry.godough.core.p2p;

import com.jackhenry.godough.core.C1757n;
import com.jackhenry.godough.core.C1759p;
import com.jackhenry.godough.core.model.P2PPayment;

/* renamed from: com.jackhenry.godough.core.p2p.al */
public class C1772al extends C1757n<P2PPayment> {
    public C1772al(P2PPayment p2PPayment, C1759p<P2PPayment> pVar) {
        super(p2PPayment, pVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public P2PPayment mo9592a(Void... voidArr) {
        C1773b bVar = new C1773b();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bVar.mo10951a((P2PPayment) this.f6512c);
    }
}
