package android.support.p007a.p008a;

import android.graphics.Path;

/* renamed from: android.support.a.a.q */
class C0021q {

    /* renamed from: m */
    protected C0013i[] f113m = null;

    /* renamed from: n */
    String f114n;

    /* renamed from: o */
    int f115o;

    public C0021q() {
    }

    public C0021q(C0021q qVar) {
        this.f114n = qVar.f114n;
        this.f115o = qVar.f115o;
        this.f113m = C0010f.m60a(qVar.f113m);
    }

    /* renamed from: a */
    public void mo104a(Path path) {
        path.reset();
        if (this.f113m != null) {
            C0013i.m66a(this.f113m, path);
        }
    }

    /* renamed from: a */
    public boolean mo100a() {
        return false;
    }

    /* renamed from: b */
    public String mo105b() {
        return this.f114n;
    }
}
