package android.support.p021v7.p022a;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p021v7.view.C0521b;
import android.support.p021v7.view.C0522c;
import android.support.p021v7.view.C0528i;
import android.support.p021v7.widget.C0670dn;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;

/* renamed from: android.support.v7.a.aj */
abstract class C0436aj extends C0435ai {

    /* renamed from: m */
    private static final int[] f588m = {16842836};

    /* renamed from: a */
    final Context f589a;

    /* renamed from: b */
    final Window f590b;

    /* renamed from: c */
    final Window.Callback f591c = this.f590b.getCallback();

    /* renamed from: d */
    final Window.Callback f592d;

    /* renamed from: e */
    final C0434ah f593e;

    /* renamed from: f */
    C0426a f594f;

    /* renamed from: g */
    MenuInflater f595g;

    /* renamed from: h */
    boolean f596h;

    /* renamed from: i */
    boolean f597i;

    /* renamed from: j */
    boolean f598j;

    /* renamed from: k */
    boolean f599k;

    /* renamed from: l */
    boolean f600l;

    /* renamed from: n */
    private CharSequence f601n;

    /* renamed from: o */
    private boolean f602o;

    C0436aj(Context context, Window window, C0434ah ahVar) {
        this.f589a = context;
        this.f590b = window;
        this.f593e = ahVar;
        if (this.f591c instanceof C0439am) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f592d = mo1996a(this.f591c);
        this.f590b.setCallback(this.f592d);
        C0670dn a = C0670dn.m3013a(context, (AttributeSet) null, f588m);
        Drawable b = a.mo3322b(0);
        if (b != null) {
            this.f590b.setBackgroundDrawable(b);
        }
        a.mo3319a();
    }

    /* renamed from: a */
    public C0426a mo1974a() {
        mo2002k();
        return this.f594f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract C0521b mo1995a(C0522c cVar);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Window.Callback mo1996a(Window.Callback callback) {
        return new C0439am(this, callback);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo1997a(int i, Menu menu);

    /* renamed from: a */
    public final void mo1980a(CharSequence charSequence) {
        this.f601n = charSequence;
        mo2000b(charSequence);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean mo1998a(int i, KeyEvent keyEvent);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean mo1999a(KeyEvent keyEvent);

    /* renamed from: b */
    public MenuInflater mo1981b() {
        if (this.f595g == null) {
            mo2002k();
            this.f595g = new C0528i(this.f594f != null ? this.f594f.mo1918c() : this.f589a);
        }
        return this.f595g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract void mo2000b(CharSequence charSequence);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract boolean mo2001b(int i, Menu menu);

    /* renamed from: c */
    public void mo1986c(Bundle bundle) {
    }

    /* renamed from: f */
    public void mo1990f() {
        this.f602o = true;
    }

    /* renamed from: g */
    public final C0485g mo1991g() {
        return new C0438al(this);
    }

    /* renamed from: i */
    public boolean mo1993i() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public abstract void mo2002k();

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final C0426a mo2003l() {
        return this.f594f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final Context mo2004m() {
        Context context = null;
        C0426a a = mo1974a();
        if (a != null) {
            context = a.mo1918c();
        }
        return context == null ? this.f589a : context;
    }

    /* renamed from: n */
    public boolean mo2005n() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public final boolean mo2006o() {
        return this.f602o;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public final Window.Callback mo2007p() {
        return this.f590b.getCallback();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public final CharSequence mo2008q() {
        return this.f591c instanceof Activity ? ((Activity) this.f591c).getTitle() : this.f601n;
    }
}
