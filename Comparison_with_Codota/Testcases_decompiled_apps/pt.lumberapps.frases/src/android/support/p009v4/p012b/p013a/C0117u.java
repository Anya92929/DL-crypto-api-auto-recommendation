package android.support.p009v4.p012b.p013a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.b.a.u */
class C0117u extends C0114r {
    C0117u(Drawable drawable) {
        super(drawable);
    }

    C0117u(C0115s sVar, Resources resources) {
        super(sVar, resources);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Drawable mo984a(Drawable.ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0115s mo952b() {
        return new C0118v(this.f173b, (Resources) null);
    }
}
