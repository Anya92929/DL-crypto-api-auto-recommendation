package android.support.p009v4.view.p020a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.view.a.ab */
class C0155ab implements C0162ai {

    /* renamed from: a */
    final /* synthetic */ C0192w f303a;

    /* renamed from: b */
    final /* synthetic */ C0154aa f304b;

    C0155ab(C0154aa aaVar, C0192w wVar) {
        this.f304b = aaVar;
        this.f303a = wVar;
    }

    /* renamed from: a */
    public Object mo1256a(int i) {
        C0175f a = this.f303a.mo1384a(i);
        if (a == null) {
            return null;
        }
        return a.mo1290a();
    }

    /* renamed from: a */
    public List mo1257a(String str, int i) {
        List a = this.f303a.mo1386a(str, i);
        ArrayList arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((C0175f) a.get(i2)).mo1290a());
        }
        return arrayList;
    }

    /* renamed from: a */
    public boolean mo1258a(int i, int i2, Bundle bundle) {
        return this.f303a.mo1387a(i, i2, bundle);
    }

    /* renamed from: b */
    public Object mo1259b(int i) {
        C0175f b = this.f303a.mo1388b(i);
        if (b == null) {
            return null;
        }
        return b.mo1290a();
    }
}
