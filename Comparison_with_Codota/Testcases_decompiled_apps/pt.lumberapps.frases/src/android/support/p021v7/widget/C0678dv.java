package android.support.p021v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p009v4.view.C0247by;
import android.support.p009v4.view.C0314ek;
import android.support.p009v4.view.C0332fb;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.p023b.C0510f;
import android.support.p021v7.p023b.C0511g;
import android.support.p021v7.p023b.C0513i;
import android.support.p021v7.p023b.C0515k;
import android.support.p021v7.view.menu.C0539af;
import android.support.p021v7.view.menu.C0562o;
import android.support.p021v7.view.menu.C0563p;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* renamed from: android.support.v7.widget.dv */
public class C0678dv implements C0623bu {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Toolbar f1659a;

    /* renamed from: b */
    private int f1660b;

    /* renamed from: c */
    private View f1661c;

    /* renamed from: d */
    private View f1662d;

    /* renamed from: e */
    private Drawable f1663e;

    /* renamed from: f */
    private Drawable f1664f;

    /* renamed from: g */
    private Drawable f1665g;

    /* renamed from: h */
    private boolean f1666h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public CharSequence f1667i;

    /* renamed from: j */
    private CharSequence f1668j;

    /* renamed from: k */
    private CharSequence f1669k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Window.Callback f1670l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f1671m;

    /* renamed from: n */
    private C0689k f1672n;

    /* renamed from: o */
    private int f1673o;

    /* renamed from: p */
    private final C0591ap f1674p;

    /* renamed from: q */
    private int f1675q;

    /* renamed from: r */
    private Drawable f1676r;

    public C0678dv(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0513i.abc_action_bar_up_description, C0510f.abc_ic_ab_back_material);
    }

    public C0678dv(Toolbar toolbar, boolean z, int i, int i2) {
        this.f1673o = 0;
        this.f1675q = 0;
        this.f1659a = toolbar;
        this.f1667i = toolbar.getTitle();
        this.f1668j = toolbar.getSubtitle();
        this.f1666h = this.f1667i != null;
        this.f1665g = toolbar.getNavigationIcon();
        if (z) {
            C0670dn a = C0670dn.m3014a(toolbar.getContext(), (AttributeSet) null, C0515k.ActionBar, C0506b.actionBarStyle, 0);
            CharSequence c = a.mo3324c(C0515k.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                mo3341b(c);
            }
            CharSequence c2 = a.mo3324c(C0515k.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c2)) {
                mo3343c(c2);
            }
            Drawable a2 = a.mo3318a(C0515k.ActionBar_logo);
            if (a2 != null) {
                mo3344d(a2);
            }
            Drawable a3 = a.mo3318a(C0515k.ActionBar_icon);
            if (this.f1665g == null && a3 != null) {
                mo3084a(a3);
            }
            Drawable a4 = a.mo3318a(C0515k.ActionBar_homeAsUpIndicator);
            if (a4 != null) {
                mo3093b(a4);
            }
            mo3095c(a.mo3317a(C0515k.ActionBar_displayOptions, 0));
            int g = a.mo3331g(C0515k.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                setCustomView(LayoutInflater.from(this.f1659a.getContext()).inflate(g, this.f1659a, false));
                mo3095c(this.f1660b | 16);
            }
            int f = a.mo3329f(C0515k.ActionBar_height, 0);
            if (f > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1659a.getLayoutParams();
                layoutParams.height = f;
                this.f1659a.setLayoutParams(layoutParams);
            }
            int d = a.mo3325d(C0515k.ActionBar_contentInsetStart, -1);
            int d2 = a.mo3325d(C0515k.ActionBar_contentInsetEnd, -1);
            if (d >= 0 || d2 >= 0) {
                this.f1659a.mo2820a(Math.max(d, 0), Math.max(d2, 0));
            }
            int g2 = a.mo3331g(C0515k.ActionBar_titleTextStyle, 0);
            if (g2 != 0) {
                this.f1659a.mo2821a(this.f1659a.getContext(), g2);
            }
            int g3 = a.mo3331g(C0515k.ActionBar_subtitleTextStyle, 0);
            if (g3 != 0) {
                this.f1659a.mo2825b(this.f1659a.getContext(), g3);
            }
            int g4 = a.mo3331g(C0515k.ActionBar_popupTheme, 0);
            if (g4 != 0) {
                this.f1659a.setPopupTheme(g4);
            }
            a.mo3319a();
        } else {
            this.f1660b = m3050s();
        }
        this.f1674p = C0591ap.m2736a();
        mo3346e(i);
        this.f1669k = this.f1659a.getNavigationContentDescription();
        mo3342c(this.f1674p.mo2982a(mo3091b(), i2));
        this.f1659a.setNavigationOnClickListener(new C0679dw(this));
    }

    /* renamed from: e */
    private void m3049e(CharSequence charSequence) {
        this.f1667i = charSequence;
        if ((this.f1660b & 8) != 0) {
            this.f1659a.setTitle(charSequence);
        }
    }

    /* renamed from: s */
    private int m3050s() {
        return this.f1659a.getNavigationIcon() != null ? 15 : 11;
    }

    /* renamed from: t */
    private void m3051t() {
        Drawable drawable = null;
        if ((this.f1660b & 2) != 0) {
            drawable = (this.f1660b & 1) != 0 ? this.f1664f != null ? this.f1664f : this.f1663e : this.f1663e;
        }
        this.f1659a.setLogo(drawable);
    }

    /* renamed from: u */
    private void m3052u() {
        if ((this.f1660b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f1669k)) {
            this.f1659a.setNavigationContentDescription(this.f1675q);
        } else {
            this.f1659a.setNavigationContentDescription(this.f1669k);
        }
    }

    /* renamed from: v */
    private void m3053v() {
        if ((this.f1660b & 4) != 0) {
            this.f1659a.setNavigationIcon(this.f1665g != null ? this.f1665g : this.f1676r);
        }
    }

    /* renamed from: a */
    public C0314ek mo3081a(int i, long j) {
        return C0247by.m917j(this.f1659a).mo1552a(i == 0 ? 1.0f : 0.0f).mo1553a(j).mo1554a((C0332fb) new C0680dx(this, i));
    }

    /* renamed from: a */
    public ViewGroup mo3082a() {
        return this.f1659a;
    }

    /* renamed from: a */
    public void mo3083a(int i) {
        mo3084a(i != 0 ? this.f1674p.mo2982a(mo3091b(), i) : null);
    }

    /* renamed from: a */
    public void mo3084a(Drawable drawable) {
        this.f1663e = drawable;
        m3051t();
    }

    /* renamed from: a */
    public void mo3085a(C0539af afVar, C0563p pVar) {
        this.f1659a.mo2822a(afVar, pVar);
    }

    /* renamed from: a */
    public void mo3086a(C0652cw cwVar) {
        if (this.f1661c != null && this.f1661c.getParent() == this.f1659a) {
            this.f1659a.removeView(this.f1661c);
        }
        this.f1661c = cwVar;
        if (cwVar != null && this.f1673o == 2) {
            this.f1659a.addView(this.f1661c, 0);
            C0675ds dsVar = (C0675ds) this.f1661c.getLayoutParams();
            dsVar.width = -2;
            dsVar.height = -2;
            dsVar.f643a = 8388691;
            cwVar.setAllowCollapse(true);
        }
    }

    /* renamed from: a */
    public void mo3087a(Menu menu, C0539af afVar) {
        if (this.f1672n == null) {
            this.f1672n = new C0689k(this.f1659a.getContext());
            this.f1672n.mo2403a(C0511g.action_menu_presenter);
        }
        this.f1672n.mo2333a(afVar);
        this.f1659a.mo2823a((C0562o) menu, this.f1672n);
    }

    /* renamed from: a */
    public void mo3088a(Window.Callback callback) {
        this.f1670l = callback;
    }

    /* renamed from: a */
    public void mo3089a(CharSequence charSequence) {
        if (!this.f1666h) {
            m3049e(charSequence);
        }
    }

    /* renamed from: a */
    public void mo3090a(boolean z) {
        this.f1659a.setCollapsible(z);
    }

    /* renamed from: b */
    public Context mo3091b() {
        return this.f1659a.getContext();
    }

    /* renamed from: b */
    public void mo3092b(int i) {
        mo3344d(i != 0 ? this.f1674p.mo2982a(mo3091b(), i) : null);
    }

    /* renamed from: b */
    public void mo3093b(Drawable drawable) {
        this.f1665g = drawable;
        m3053v();
    }

    /* renamed from: b */
    public void mo3341b(CharSequence charSequence) {
        this.f1666h = true;
        m3049e(charSequence);
    }

    /* renamed from: b */
    public void mo3094b(boolean z) {
    }

    /* renamed from: c */
    public void mo3095c(int i) {
        int i2 = this.f1660b ^ i;
        this.f1660b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m3053v();
                    m3052u();
                } else {
                    this.f1659a.setNavigationIcon((Drawable) null);
                }
            }
            if ((i2 & 3) != 0) {
                m3051t();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f1659a.setTitle(this.f1667i);
                    this.f1659a.setSubtitle(this.f1668j);
                } else {
                    this.f1659a.setTitle((CharSequence) null);
                    this.f1659a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) != 0 && this.f1662d != null) {
                if ((i & 16) != 0) {
                    this.f1659a.addView(this.f1662d);
                } else {
                    this.f1659a.removeView(this.f1662d);
                }
            }
        }
    }

    /* renamed from: c */
    public void mo3342c(Drawable drawable) {
        if (this.f1676r != drawable) {
            this.f1676r = drawable;
            m3053v();
        }
    }

    /* renamed from: c */
    public void mo3343c(CharSequence charSequence) {
        this.f1668j = charSequence;
        if ((this.f1660b & 8) != 0) {
            this.f1659a.setSubtitle(charSequence);
        }
    }

    /* renamed from: c */
    public boolean mo3096c() {
        return this.f1659a.mo2832g();
    }

    /* renamed from: d */
    public void mo3097d() {
        this.f1659a.mo2860h();
    }

    /* renamed from: d */
    public void mo3098d(int i) {
        mo3345d((CharSequence) i == 0 ? null : mo3091b().getString(i));
    }

    /* renamed from: d */
    public void mo3344d(Drawable drawable) {
        this.f1664f = drawable;
        m3051t();
    }

    /* renamed from: d */
    public void mo3345d(CharSequence charSequence) {
        this.f1669k = charSequence;
        m3052u();
    }

    /* renamed from: e */
    public CharSequence mo3099e() {
        return this.f1659a.getTitle();
    }

    /* renamed from: e */
    public void mo3346e(int i) {
        if (i != this.f1675q) {
            this.f1675q = i;
            if (TextUtils.isEmpty(this.f1659a.getNavigationContentDescription())) {
                mo3098d(this.f1675q);
            }
        }
    }

    /* renamed from: f */
    public void mo3100f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    /* renamed from: g */
    public void mo3101g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    /* renamed from: h */
    public boolean mo3102h() {
        return this.f1659a.mo2824a();
    }

    /* renamed from: i */
    public boolean mo3103i() {
        return this.f1659a.mo2826b();
    }

    /* renamed from: j */
    public boolean mo3104j() {
        return this.f1659a.mo2827c();
    }

    /* renamed from: k */
    public boolean mo3105k() {
        return this.f1659a.mo2829d();
    }

    /* renamed from: l */
    public boolean mo3106l() {
        return this.f1659a.mo2830e();
    }

    /* renamed from: m */
    public void mo3107m() {
        this.f1671m = true;
    }

    /* renamed from: n */
    public void mo3108n() {
        this.f1659a.mo2831f();
    }

    /* renamed from: o */
    public int mo3109o() {
        return this.f1660b;
    }

    /* renamed from: p */
    public int mo3110p() {
        return this.f1673o;
    }

    /* renamed from: q */
    public int mo3111q() {
        return this.f1659a.getVisibility();
    }

    /* renamed from: r */
    public Menu mo3112r() {
        return this.f1659a.getMenu();
    }

    public void setCustomView(View view) {
        if (!(this.f1662d == null || (this.f1660b & 16) == 0)) {
            this.f1659a.removeView(this.f1662d);
        }
        this.f1662d = view;
        if (view != null && (this.f1660b & 16) != 0) {
            this.f1659a.addView(this.f1662d);
        }
    }
}
