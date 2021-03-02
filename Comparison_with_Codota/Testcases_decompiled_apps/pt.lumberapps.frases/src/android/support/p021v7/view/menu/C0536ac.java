package android.support.p021v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.support.p009v4.view.C0247by;
import android.support.p009v4.view.C0347q;
import android.support.p021v7.p023b.C0507c;
import android.view.View;
import android.widget.PopupWindow;

/* renamed from: android.support.v7.view.menu.ac */
public class C0536ac {

    /* renamed from: a */
    private final Context f1002a;

    /* renamed from: b */
    private final C0562o f1003b;

    /* renamed from: c */
    private final boolean f1004c;

    /* renamed from: d */
    private final int f1005d;

    /* renamed from: e */
    private final int f1006e;

    /* renamed from: f */
    private View f1007f;

    /* renamed from: g */
    private int f1008g;

    /* renamed from: h */
    private boolean f1009h;

    /* renamed from: i */
    private C0539af f1010i;

    /* renamed from: j */
    private C0535ab f1011j;

    /* renamed from: k */
    private PopupWindow.OnDismissListener f1012k;

    /* renamed from: l */
    private final PopupWindow.OnDismissListener f1013l;

    public C0536ac(Context context, C0562o oVar, View view, boolean z, int i) {
        this(context, oVar, view, z, i, 0);
    }

    public C0536ac(Context context, C0562o oVar, View view, boolean z, int i, int i2) {
        this.f1008g = 8388611;
        this.f1013l = new C0537ad(this);
        this.f1002a = context;
        this.f1003b = oVar;
        this.f1007f = view;
        this.f1004c = z;
        this.f1005d = i;
        this.f1006e = i2;
    }

    /* renamed from: a */
    private void m2306a(int i, int i2, boolean z, boolean z2) {
        C0535ab b = mo2326b();
        b.mo2317c(z2);
        if (z) {
            if ((C0347q.m1334a(this.f1008g, C0247by.m909d(this.f1007f)) & 7) == 5) {
                i -= this.f1007f.getWidth();
            }
            b.mo2314b(i);
            b.mo2316c(i2);
            int i3 = (int) ((this.f1002a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            b.mo2309a(new Rect(i - i3, i2 - i3, i + i3, i3 + i2));
        }
        b.mo2362a();
    }

    /* renamed from: g */
    private C0535ab m2307g() {
        C0535ab gVar = this.f1002a.getResources().getBoolean(C0507c.abc_config_enableCascadingSubmenus) ? new C0554g(this.f1002a, this.f1007f, this.f1005d, this.f1006e, this.f1004c) : new C0545al(this.f1002a, this.f1003b, this.f1007f, this.f1005d, this.f1006e, this.f1004c);
        gVar.mo2310a(this.f1003b);
        gVar.mo2311a(this.f1013l);
        gVar.setAnchorView(this.f1007f);
        gVar.mo2333a(this.f1010i);
        gVar.mo2312a(this.f1009h);
        gVar.mo2307a(this.f1008g);
        return gVar;
    }

    /* renamed from: a */
    public void mo2321a() {
        if (!mo2327c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    /* renamed from: a */
    public void mo2322a(int i) {
        this.f1008g = i;
    }

    /* renamed from: a */
    public void mo2323a(C0539af afVar) {
        this.f1010i = afVar;
        if (this.f1011j != null) {
            this.f1011j.mo2333a(afVar);
        }
    }

    /* renamed from: a */
    public void mo2324a(boolean z) {
        this.f1009h = z;
    }

    /* renamed from: a */
    public boolean mo2325a(int i, int i2) {
        if (mo2330f()) {
            return true;
        }
        if (this.f1007f == null) {
            return false;
        }
        m2306a(i, i2, true, true);
        return true;
    }

    /* renamed from: b */
    public C0535ab mo2326b() {
        if (this.f1011j == null) {
            this.f1011j = m2307g();
        }
        return this.f1011j;
    }

    /* renamed from: c */
    public boolean mo2327c() {
        if (mo2330f()) {
            return true;
        }
        if (this.f1007f == null) {
            return false;
        }
        m2306a(0, 0, false, false);
        return true;
    }

    /* renamed from: d */
    public void mo2328d() {
        if (mo2330f()) {
            this.f1011j.mo2363c();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo2329e() {
        this.f1011j = null;
        if (this.f1012k != null) {
            this.f1012k.onDismiss();
        }
    }

    /* renamed from: f */
    public boolean mo2330f() {
        return this.f1011j != null && this.f1011j.mo2364d();
    }

    public void setAnchorView(View view) {
        this.f1007f = view;
    }
}
