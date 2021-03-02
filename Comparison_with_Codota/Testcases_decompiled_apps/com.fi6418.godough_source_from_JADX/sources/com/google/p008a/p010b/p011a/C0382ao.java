package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.C0364am;
import com.google.p008a.C0481k;
import com.google.p008a.p012c.C0468a;
import java.sql.Timestamp;
import java.util.Date;

/* renamed from: com.google.a.b.a.ao */
final class C0382ao implements C0364am {
    C0382ao() {
    }

    /* renamed from: a */
    public <T> C0363al<T> mo6311a(C0481k kVar, C0468a<T> aVar) {
        if (aVar.mo6494a() != Timestamp.class) {
            return null;
        }
        return new C0383ap(this, kVar.mo6512a(Date.class));
    }
}
