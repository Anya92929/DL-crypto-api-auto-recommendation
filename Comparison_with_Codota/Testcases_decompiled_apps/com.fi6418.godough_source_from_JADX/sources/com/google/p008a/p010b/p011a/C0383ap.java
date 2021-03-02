package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0473d;
import java.sql.Timestamp;
import java.util.Date;

/* renamed from: com.google.a.b.a.ap */
class C0383ap extends C0363al<Timestamp> {

    /* renamed from: a */
    final /* synthetic */ C0363al f3384a;

    /* renamed from: b */
    final /* synthetic */ C0382ao f3385b;

    C0383ap(C0382ao aoVar, C0363al alVar) {
        this.f3385b = aoVar;
        this.f3384a = alVar;
    }

    /* renamed from: a */
    public Timestamp mo6310b(C0470a aVar) {
        Date date = (Date) this.f3384a.mo6310b(aVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, Timestamp timestamp) {
        this.f3384a.mo6309a(dVar, timestamp);
    }
}
