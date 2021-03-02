package com.jackhenry.godough.core.rda;

import android.content.Context;
import com.jackhenry.godough.core.C1757n;
import com.jackhenry.godough.core.C1759p;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Deposit;

/* renamed from: com.jackhenry.godough.core.rda.af */
public class C1810af extends C1757n<Deposit> {
    public C1810af(Deposit deposit, C1759p<Deposit> pVar) {
        super(deposit, pVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Deposit mo9592a(Void... voidArr) {
        C1881x xVar = new C1881x();
        GoDoughApp app = GoDoughApp.getApp();
        ((Deposit) this.f6512c).setFrontCheckImage(C1805aa.m6707a(0, (Context) app));
        ((Deposit) this.f6512c).setBackCheckImage(C1805aa.m6707a(1, (Context) app));
        return xVar.mo11105a((Deposit) this.f6512c);
    }
}
