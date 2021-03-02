package com.google.android.gms.common.api;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import java.util.Map;

/* renamed from: com.google.android.gms.common.api.ae */
class C0707ae extends C0712aj {

    /* renamed from: a */
    final /* synthetic */ C0758w f4434a;

    /* renamed from: c */
    private final Map<C0743h, C0756u> f4435c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0707ae(C0758w wVar, Map<C0743h, C0756u> map) {
        super(wVar, (C0759x) null);
        this.f4434a = wVar;
        this.f4435c = map;
    }

    /* renamed from: a */
    public void mo7357a() {
        int a = this.f4434a.f4536d.mo7457a(this.f4434a.f4535c);
        if (a != 0) {
            this.f4434a.f4533a.mo7374a((C0720ar) new C0708af(this, this.f4434a, new ConnectionResult(a, (PendingIntent) null)));
            return;
        }
        if (this.f4434a.f4546n) {
            this.f4434a.f4544l.mo9018q();
        }
        for (C0743h next : this.f4435c.keySet()) {
            next.mo7433a(this.f4435c.get(next));
        }
    }
}
