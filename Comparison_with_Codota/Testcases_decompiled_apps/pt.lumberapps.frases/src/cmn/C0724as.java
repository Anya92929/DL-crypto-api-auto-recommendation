package cmn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: cmn.as */
public final class C0724as {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final List f1791a = new ArrayList();

    public C0724as(List list) {
        this.f1791a.addAll(list);
    }

    /* renamed from: a */
    static /* synthetic */ C0724as m3224a(C0724as asVar) {
        C0724as asVar2 = new C0724as(asVar.f1791a);
        Collections.shuffle(asVar2.f1791a);
        return asVar2;
    }
}
