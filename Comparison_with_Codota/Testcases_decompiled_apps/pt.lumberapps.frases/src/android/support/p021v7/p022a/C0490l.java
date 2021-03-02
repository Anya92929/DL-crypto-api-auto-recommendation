package android.support.p021v7.p022a;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v7.a.l */
class C0490l implements C0485g {

    /* renamed from: a */
    final Activity f766a;

    /* renamed from: b */
    C0494p f767b;

    private C0490l(Activity activity) {
        this.f766a = activity;
    }

    /* synthetic */ C0490l(Activity activity, C0484f fVar) {
        this(activity);
    }

    /* renamed from: a */
    public Drawable mo2009a() {
        return C0493o.m2124a(this.f766a);
    }

    /* renamed from: a */
    public void mo2010a(int i) {
        this.f767b = C0493o.m2125a(this.f767b, this.f766a, i);
    }

    /* renamed from: a */
    public void mo2011a(Drawable drawable, int i) {
        this.f766a.getActionBar().setDisplayShowHomeEnabled(true);
        this.f767b = C0493o.m2126a(this.f767b, this.f766a, drawable, i);
        this.f766a.getActionBar().setDisplayShowHomeEnabled(false);
    }

    /* renamed from: b */
    public Context mo2012b() {
        ActionBar actionBar = this.f766a.getActionBar();
        return actionBar != null ? actionBar.getThemedContext() : this.f766a;
    }

    /* renamed from: c */
    public boolean mo2013c() {
        ActionBar actionBar = this.f766a.getActionBar();
        return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
    }
}
