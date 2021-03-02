package android.support.p021v7.p022a;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p009v4.widget.C0423x;
import android.support.p009v4.widget.DrawerLayout;
import android.support.p021v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

/* renamed from: android.support.v7.a.e */
public class C0483e implements C0423x {

    /* renamed from: a */
    private final C0485g f753a;

    /* renamed from: b */
    private final DrawerLayout f754b;

    /* renamed from: c */
    private C0488j f755c;

    /* renamed from: d */
    private Drawable f756d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f757e;

    /* renamed from: f */
    private boolean f758f;

    /* renamed from: g */
    private final int f759g;

    /* renamed from: h */
    private final int f760h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View.OnClickListener f761i;

    /* renamed from: j */
    private boolean f762j;

    public C0483e(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int i, int i2) {
        this(activity, toolbar, drawerLayout, (Drawable) null, i, i2);
    }

    C0483e(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, Drawable drawable, int i, int i2) {
        this.f757e = true;
        this.f762j = false;
        if (toolbar != null) {
            this.f753a = new C0492n(toolbar);
            toolbar.setNavigationOnClickListener(new C0484f(this));
        } else if (activity instanceof C0486h) {
            this.f753a = ((C0486h) activity).mo1948a();
        } else if (Build.VERSION.SDK_INT >= 18) {
            this.f753a = new C0491m(activity, (C0484f) null);
        } else if (Build.VERSION.SDK_INT >= 11) {
            this.f753a = new C0490l(activity, (C0484f) null);
        } else {
            this.f753a = new C0489k(activity);
        }
        this.f754b = drawerLayout;
        this.f759g = i;
        this.f760h = i2;
        if (drawable == null) {
            this.f755c = new C0487i(activity, this.f753a.mo2012b());
        } else {
            this.f755c = (C0488j) drawable;
        }
        this.f756d = mo2113b();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2090c() {
        int a = this.f754b.mo1634a(8388611);
        if (this.f754b.mo1670h(8388611) && a != 2) {
            this.f754b.mo1661f(8388611);
        } else if (a != 1) {
            this.f754b.mo1660e(8388611);
        }
    }

    /* renamed from: a */
    public void mo2109a() {
        if (this.f754b.mo1663g(8388611)) {
            this.f755c.mo2115a(1.0f);
        } else {
            this.f755c.mo2115a(0.0f);
        }
        if (this.f757e) {
            mo2112a((Drawable) this.f755c, this.f754b.mo1663g(8388611) ? this.f760h : this.f759g);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2110a(int i) {
        this.f753a.mo2010a(i);
    }

    /* renamed from: a */
    public void mo2111a(Configuration configuration) {
        if (!this.f758f) {
            this.f756d = mo2113b();
        }
        mo2109a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2112a(Drawable drawable, int i) {
        if (!this.f762j && !this.f753a.mo2013c()) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.f762j = true;
        }
        this.f753a.mo2011a(drawable, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Drawable mo2113b() {
        return this.f753a.mo2009a();
    }

    public void onDrawerClosed(View view) {
        this.f755c.mo2115a(0.0f);
        if (this.f757e) {
            mo2110a(this.f759g);
        }
    }

    public void onDrawerOpened(View view) {
        this.f755c.mo2115a(1.0f);
        if (this.f757e) {
            mo2110a(this.f760h);
        }
    }

    public void onDrawerSlide(View view, float f) {
        this.f755c.mo2115a(Math.min(1.0f, Math.max(0.0f, f)));
    }

    public void onDrawerStateChanged(int i) {
    }
}
