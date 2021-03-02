package cmn;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: cmn.ab */
final class C0707ab extends LinkedHashMap {

    /* renamed from: a */
    final /* synthetic */ int f1746a = 100;

    /* renamed from: b */
    final /* synthetic */ C0706aa f1747b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0707ab(C0706aa aaVar, int i) {
        super(i, 0.75f, true);
        this.f1747b = aaVar;
    }

    /* access modifiers changed from: protected */
    public final boolean removeEldestEntry(Map.Entry entry) {
        return size() > this.f1746a;
    }
}
