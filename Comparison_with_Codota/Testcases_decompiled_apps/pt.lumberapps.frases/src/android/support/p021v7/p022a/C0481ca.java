package android.support.p021v7.p022a;

import android.content.Context;
import android.support.p021v7.view.C0521b;
import android.support.p021v7.view.C0522c;
import android.support.p021v7.view.C0528i;
import android.support.p021v7.view.menu.C0562o;
import android.support.p021v7.view.menu.C0563p;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.a.ca */
public class C0481ca extends C0521b implements C0563p {

    /* renamed from: a */
    final /* synthetic */ C0476bw f748a;

    /* renamed from: b */
    private final Context f749b;

    /* renamed from: c */
    private final C0562o f750c;

    /* renamed from: d */
    private C0522c f751d;

    /* renamed from: e */
    private WeakReference f752e;

    public C0481ca(C0476bw bwVar, Context context, C0522c cVar) {
        this.f748a = bwVar;
        this.f749b = context;
        this.f751d = cVar;
        this.f750c = new C0562o(context).mo2442a(1);
        this.f750c.mo2370a((C0563p) this);
    }

    /* renamed from: a */
    public MenuInflater mo2089a() {
        return new C0528i(this.f749b);
    }

    /* renamed from: a */
    public void mo2090a(int i) {
        mo2095b((CharSequence) this.f748a.f730l.getResources().getString(i));
    }

    /* renamed from: a */
    public void mo2028a(C0562o oVar) {
        if (this.f751d != null) {
            mo2097d();
            this.f748a.f737s.mo2641a();
        }
    }

    /* renamed from: a */
    public void mo2091a(CharSequence charSequence) {
        this.f748a.f737s.setSubtitle(charSequence);
    }

    /* renamed from: a */
    public void mo2092a(boolean z) {
        super.mo2092a(z);
        this.f748a.f737s.setTitleOptional(z);
    }

    /* renamed from: a */
    public boolean mo2030a(C0562o oVar, MenuItem menuItem) {
        if (this.f751d != null) {
            return this.f751d.mo2045a((C0521b) this, menuItem);
        }
        return false;
    }

    /* renamed from: b */
    public Menu mo2093b() {
        return this.f750c;
    }

    /* renamed from: b */
    public void mo2094b(int i) {
        mo2091a((CharSequence) this.f748a.f730l.getResources().getString(i));
    }

    /* renamed from: b */
    public void mo2095b(CharSequence charSequence) {
        this.f748a.f737s.setTitle(charSequence);
    }

    /* renamed from: c */
    public void mo2096c() {
        if (this.f748a.f723a == this) {
            if (!C0476bw.m2021b(this.f748a.f717D, this.f748a.f718E, false)) {
                this.f748a.f724b = this;
                this.f748a.f725c = this.f751d;
            } else {
                this.f751d.mo2043a(this);
            }
            this.f751d = null;
            this.f748a.mo2083k(false);
            this.f748a.f737s.mo2642b();
            this.f748a.f736r.mo3082a().sendAccessibilityEvent(32);
            this.f748a.f734p.setHideOnContentScrollEnabled(this.f748a.f726d);
            this.f748a.f723a = null;
        }
    }

    /* renamed from: d */
    public void mo2097d() {
        if (this.f748a.f723a == this) {
            this.f750c.mo2480g();
            try {
                this.f751d.mo2046b(this, this.f750c);
            } finally {
                this.f750c.mo2482h();
            }
        }
    }

    /* renamed from: e */
    public boolean mo2098e() {
        this.f750c.mo2480g();
        try {
            return this.f751d.mo2044a((C0521b) this, (Menu) this.f750c);
        } finally {
            this.f750c.mo2482h();
        }
    }

    /* renamed from: f */
    public CharSequence mo2099f() {
        return this.f748a.f737s.getTitle();
    }

    /* renamed from: g */
    public CharSequence mo2100g() {
        return this.f748a.f737s.getSubtitle();
    }

    /* renamed from: h */
    public boolean mo2101h() {
        return this.f748a.f737s.mo2644d();
    }

    /* renamed from: i */
    public View mo2102i() {
        if (this.f752e != null) {
            return (View) this.f752e.get();
        }
        return null;
    }

    public void setCustomView(View view) {
        this.f748a.f737s.setCustomView(view);
        this.f752e = new WeakReference(view);
    }
}
