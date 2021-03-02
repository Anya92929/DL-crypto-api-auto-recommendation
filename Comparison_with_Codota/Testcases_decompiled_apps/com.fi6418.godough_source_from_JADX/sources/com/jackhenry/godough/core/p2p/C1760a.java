package com.jackhenry.godough.core.p2p;

import com.jackhenry.godough.core.C1757n;
import com.jackhenry.godough.core.C1759p;
import com.jackhenry.godough.core.model.P2PPayee;
import com.jackhenry.godough.core.model.P2PPaymentDate;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.p2p.a */
public class C1760a extends C1757n<List<P2PPaymentDate>> {

    /* renamed from: e */
    P2PPayee f6557e;

    public C1760a(P2PPayee p2PPayee, C1759p<List<P2PPaymentDate>> pVar) {
        super(new ArrayList(), pVar);
        this.f6557e = p2PPayee;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public List<P2PPaymentDate> mo9592a(Void... voidArr) {
        return new C1773b().mo10952a(this.f6557e.getId());
    }
}
