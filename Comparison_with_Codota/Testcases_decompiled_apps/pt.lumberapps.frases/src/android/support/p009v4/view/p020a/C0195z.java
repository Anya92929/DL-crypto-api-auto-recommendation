package android.support.p009v4.view.p020a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.view.a.z */
class C0195z implements C0159af {

    /* renamed from: a */
    final /* synthetic */ C0192w f336a;

    /* renamed from: b */
    final /* synthetic */ C0194y f337b;

    C0195z(C0194y yVar, C0192w wVar) {
        this.f337b = yVar;
        this.f336a = wVar;
    }

    /* renamed from: a */
    public Object mo1263a(int i) {
        C0175f a = this.f336a.mo1384a(i);
        if (a == null) {
            return null;
        }
        return a.mo1290a();
    }

    /* renamed from: a */
    public List mo1264a(String str, int i) {
        List a = this.f336a.mo1386a(str, i);
        ArrayList arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((C0175f) a.get(i2)).mo1290a());
        }
        return arrayList;
    }

    /* renamed from: a */
    public boolean mo1265a(int i, int i2, Bundle bundle) {
        return this.f336a.mo1387a(i, i2, bundle);
    }
}
