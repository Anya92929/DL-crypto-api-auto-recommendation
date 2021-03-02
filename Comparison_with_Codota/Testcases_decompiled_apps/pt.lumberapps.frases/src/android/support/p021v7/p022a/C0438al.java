package android.support.p021v7.p022a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.widget.C0670dn;
import android.util.AttributeSet;

/* renamed from: android.support.v7.a.al */
class C0438al implements C0485g {

    /* renamed from: a */
    final /* synthetic */ C0436aj f603a;

    private C0438al(C0436aj ajVar) {
        this.f603a = ajVar;
    }

    /* renamed from: a */
    public Drawable mo2009a() {
        C0670dn a = C0670dn.m3013a(mo2012b(), (AttributeSet) null, new int[]{C0506b.homeAsUpIndicator});
        Drawable a2 = a.mo3318a(0);
        a.mo3319a();
        return a2;
    }

    /* renamed from: a */
    public void mo2010a(int i) {
        C0426a a = this.f603a.mo1974a();
        if (a != null) {
            a.mo1910a(i);
        }
    }

    /* renamed from: a */
    public void mo2011a(Drawable drawable, int i) {
        C0426a a = this.f603a.mo1974a();
        if (a != null) {
            a.mo1912a(drawable);
            a.mo1910a(i);
        }
    }

    /* renamed from: b */
    public Context mo2012b() {
        return this.f603a.mo2004m();
    }

    /* renamed from: c */
    public boolean mo2013c() {
        C0426a a = this.f603a.mo1974a();
        return (a == null || (a.mo1907a() & 4) == 0) ? false : true;
    }
}
