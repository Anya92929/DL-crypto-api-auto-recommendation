package android.support.p021v7.p022a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p021v7.widget.Toolbar;

/* renamed from: android.support.v7.a.n */
class C0492n implements C0485g {

    /* renamed from: a */
    final Toolbar f769a;

    /* renamed from: b */
    final Drawable f770b;

    /* renamed from: c */
    final CharSequence f771c;

    C0492n(Toolbar toolbar) {
        this.f769a = toolbar;
        this.f770b = toolbar.getNavigationIcon();
        this.f771c = toolbar.getNavigationContentDescription();
    }

    /* renamed from: a */
    public Drawable mo2009a() {
        return this.f770b;
    }

    /* renamed from: a */
    public void mo2010a(int i) {
        if (i == 0) {
            this.f769a.setNavigationContentDescription(this.f771c);
        } else {
            this.f769a.setNavigationContentDescription(i);
        }
    }

    /* renamed from: a */
    public void mo2011a(Drawable drawable, int i) {
        this.f769a.setNavigationIcon(drawable);
        mo2010a(i);
    }

    /* renamed from: b */
    public Context mo2012b() {
        return this.f769a.getContext();
    }

    /* renamed from: c */
    public boolean mo2013c() {
        return true;
    }
}
