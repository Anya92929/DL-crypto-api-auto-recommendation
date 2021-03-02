package android.support.p021v7.p022a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p009v4.view.C0247by;
import android.support.p009v4.view.C0314ek;
import android.support.p009v4.view.C0332fb;
import android.support.p009v4.view.C0334fd;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.p023b.C0511g;
import android.support.p021v7.p023b.C0515k;
import android.support.p021v7.view.C0520a;
import android.support.p021v7.view.C0521b;
import android.support.p021v7.view.C0522c;
import android.support.p021v7.view.C0531l;
import android.support.p021v7.widget.ActionBarContainer;
import android.support.p021v7.widget.ActionBarContextView;
import android.support.p021v7.widget.ActionBarOverlayLayout;
import android.support.p021v7.widget.C0623bu;
import android.support.p021v7.widget.C0652cw;
import android.support.p021v7.widget.C0687i;
import android.support.p021v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;

/* renamed from: android.support.v7.a.bw */
public class C0476bw extends C0426a implements C0687i {

    /* renamed from: h */
    static final /* synthetic */ boolean f710h = (!C0476bw.class.desiredAssertionStatus());

    /* renamed from: i */
    private static final Interpolator f711i = new AccelerateInterpolator();

    /* renamed from: j */
    private static final Interpolator f712j = new DecelerateInterpolator();

    /* renamed from: k */
    private static final boolean f713k;

    /* renamed from: A */
    private boolean f714A;

    /* renamed from: B */
    private int f715B = 0;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f716C = true;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public boolean f717D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public boolean f718E;

    /* renamed from: F */
    private boolean f719F;

    /* renamed from: G */
    private boolean f720G = true;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public C0531l f721H;

    /* renamed from: I */
    private boolean f722I;

    /* renamed from: a */
    C0481ca f723a;

    /* renamed from: b */
    C0521b f724b;

    /* renamed from: c */
    C0522c f725c;

    /* renamed from: d */
    boolean f726d;

    /* renamed from: e */
    final C0332fb f727e = new C0477bx(this);

    /* renamed from: f */
    final C0332fb f728f = new C0478by(this);

    /* renamed from: g */
    final C0334fd f729g = new C0479bz(this);
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Context f730l;

    /* renamed from: m */
    private Context f731m;

    /* renamed from: n */
    private Activity f732n;

    /* renamed from: o */
    private Dialog f733o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public ActionBarOverlayLayout f734p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public ActionBarContainer f735q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public C0623bu f736r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public ActionBarContextView f737s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public View f738t;

    /* renamed from: u */
    private C0652cw f739u;

    /* renamed from: v */
    private ArrayList f740v = new ArrayList();

    /* renamed from: w */
    private int f741w = -1;

    /* renamed from: x */
    private boolean f742x;

    /* renamed from: y */
    private boolean f743y;

    /* renamed from: z */
    private ArrayList f744z = new ArrayList();

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 14) {
            z = false;
        }
        f713k = z;
    }

    public C0476bw(Activity activity, boolean z) {
        this.f732n = activity;
        View decorView = activity.getWindow().getDecorView();
        m2016a(decorView);
        if (!z) {
            this.f738t = decorView.findViewById(16908290);
        }
    }

    public C0476bw(Dialog dialog) {
        this.f733o = dialog;
        m2016a(dialog.getWindow().getDecorView());
    }

    public C0476bw(View view) {
        if (f710h || view.isInEditMode()) {
            m2016a(view);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private void m2016a(View view) {
        this.f734p = (ActionBarOverlayLayout) view.findViewById(C0511g.decor_content_parent);
        if (this.f734p != null) {
            this.f734p.setActionBarVisibilityCallback(this);
        }
        this.f736r = m2019b(view.findViewById(C0511g.action_bar));
        this.f737s = (ActionBarContextView) view.findViewById(C0511g.action_context_bar);
        this.f735q = (ActionBarContainer) view.findViewById(C0511g.action_bar_container);
        if (this.f736r == null || this.f737s == null || this.f735q == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.f730l = this.f736r.mo3091b();
        boolean z = (this.f736r.mo3109o() & 4) != 0;
        if (z) {
            this.f742x = true;
        }
        C0520a a = C0520a.m2179a(this.f730l);
        mo1919c(a.mo2192f() || z);
        m2029l(a.mo2190d());
        TypedArray obtainStyledAttributes = this.f730l.obtainStyledAttributes((AttributeSet) null, C0515k.ActionBar, C0506b.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(C0515k.ActionBar_hideOnContentScroll, false)) {
            mo1921d(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0515k.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            mo1909a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    private C0623bu m2019b(View view) {
        if (view instanceof C0623bu) {
            return (C0623bu) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m2021b(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return !z && !z2;
    }

    /* renamed from: l */
    private void m2029l(boolean z) {
        boolean z2 = true;
        this.f714A = z;
        if (!this.f714A) {
            this.f736r.mo3086a((C0652cw) null);
            this.f735q.setTabContainer(this.f739u);
        } else {
            this.f735q.setTabContainer((C0652cw) null);
            this.f736r.mo3086a(this.f739u);
        }
        boolean z3 = mo2080j() == 2;
        if (this.f739u != null) {
            if (z3) {
                this.f739u.setVisibility(0);
                if (this.f734p != null) {
                    C0247by.requestApplyInsets(this.f734p);
                }
            } else {
                this.f739u.setVisibility(8);
            }
        }
        this.f736r.mo3090a(!this.f714A && z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f734p;
        if (this.f714A || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    /* renamed from: m */
    private void m2030m(boolean z) {
        if (m2021b(this.f717D, this.f718E, this.f719F)) {
            if (!this.f720G) {
                this.f720G = true;
                mo2079i(z);
            }
        } else if (this.f720G) {
            this.f720G = false;
            mo2081j(z);
        }
    }

    /* renamed from: p */
    private void m2031p() {
        if (!this.f719F) {
            this.f719F = true;
            if (this.f734p != null) {
                this.f734p.setShowingForActionMode(true);
            }
            m2030m(false);
        }
    }

    /* renamed from: q */
    private void m2032q() {
        if (this.f719F) {
            this.f719F = false;
            if (this.f734p != null) {
                this.f734p.setShowingForActionMode(false);
            }
            m2030m(false);
        }
    }

    /* renamed from: a */
    public int mo1907a() {
        return this.f736r.mo3109o();
    }

    /* renamed from: a */
    public C0521b mo1908a(C0522c cVar) {
        if (this.f723a != null) {
            this.f723a.mo2096c();
        }
        this.f734p.setHideOnContentScrollEnabled(false);
        this.f737s.mo2643c();
        C0481ca caVar = new C0481ca(this, this.f737s.getContext(), cVar);
        if (!caVar.mo2098e()) {
            return null;
        }
        caVar.mo2097d();
        this.f737s.mo2640a(caVar);
        mo2083k(true);
        this.f737s.sendAccessibilityEvent(32);
        this.f723a = caVar;
        return caVar;
    }

    /* renamed from: a */
    public void mo1909a(float f) {
        C0247by.m907c((View) this.f735q, f);
    }

    /* renamed from: a */
    public void mo1910a(int i) {
        this.f736r.mo3098d(i);
    }

    /* renamed from: a */
    public void mo2075a(int i, int i2) {
        int o = this.f736r.mo3109o();
        if ((i2 & 4) != 0) {
            this.f742x = true;
        }
        this.f736r.mo3095c((o & (i2 ^ -1)) | (i & i2));
    }

    /* renamed from: a */
    public void mo1911a(Configuration configuration) {
        m2029l(C0520a.m2179a(this.f730l).mo2190d());
    }

    /* renamed from: a */
    public void mo1912a(Drawable drawable) {
        this.f736r.mo3093b(drawable);
    }

    /* renamed from: a */
    public void mo1913a(CharSequence charSequence) {
        this.f736r.mo3089a(charSequence);
    }

    /* renamed from: a */
    public void mo1914a(boolean z) {
        mo2075a(z ? 4 : 0, 4);
    }

    /* renamed from: b */
    public void mo2076b(int i) {
        this.f715B = i;
    }

    /* renamed from: b */
    public void mo1916b(boolean z) {
        mo2075a(z ? 8 : 0, 8);
    }

    /* renamed from: b */
    public boolean mo1917b() {
        int k = mo2082k();
        return this.f720G && (k == 0 || mo1920d() < k);
    }

    /* renamed from: c */
    public Context mo1918c() {
        if (this.f731m == null) {
            TypedValue typedValue = new TypedValue();
            this.f730l.getTheme().resolveAttribute(C0506b.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f731m = new ContextThemeWrapper(this.f730l, i);
            } else {
                this.f731m = this.f730l;
            }
        }
        return this.f731m;
    }

    /* renamed from: c */
    public void mo1919c(boolean z) {
        this.f736r.mo3094b(z);
    }

    /* renamed from: d */
    public int mo1920d() {
        return this.f734p.getActionBarHideOffset();
    }

    /* renamed from: d */
    public void mo1921d(boolean z) {
        if (!z || this.f734p.mo2667a()) {
            this.f726d = z;
            this.f734p.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    /* renamed from: e */
    public void mo1922e(boolean z) {
        if (!this.f742x) {
            mo1914a(z);
        }
    }

    /* renamed from: f */
    public void mo1924f(boolean z) {
        this.f722I = z;
        if (!z && this.f721H != null) {
            this.f721H.mo2236b();
        }
    }

    /* renamed from: f */
    public boolean mo1925f() {
        if (this.f736r == null || !this.f736r.mo3096c()) {
            return false;
        }
        this.f736r.mo3097d();
        return true;
    }

    /* renamed from: g */
    public void mo1926g(boolean z) {
        if (z != this.f743y) {
            this.f743y = z;
            int size = this.f744z.size();
            for (int i = 0; i < size; i++) {
                ((C0480c) this.f744z.get(i)).mo2088a(z);
            }
        }
    }

    /* renamed from: g */
    public boolean mo1927g() {
        ViewGroup a = this.f736r.mo3082a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    /* renamed from: h */
    public void mo2077h(boolean z) {
        this.f716C = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo2078i() {
        if (this.f725c != null) {
            this.f725c.mo2043a(this.f724b);
            this.f724b = null;
            this.f725c = null;
        }
    }

    /* renamed from: i */
    public void mo2079i(boolean z) {
        if (this.f721H != null) {
            this.f721H.mo2236b();
        }
        this.f735q.setVisibility(0);
        if (this.f715B != 0 || !f713k || (!this.f722I && !z)) {
            C0247by.m903b((View) this.f735q, 1.0f);
            C0247by.m890a((View) this.f735q, 0.0f);
            if (this.f716C && this.f738t != null) {
                C0247by.m890a(this.f738t, 0.0f);
            }
            this.f728f.onAnimationEnd((View) null);
        } else {
            C0247by.m890a((View) this.f735q, 0.0f);
            float f = (float) (-this.f735q.getHeight());
            if (z) {
                int[] iArr = {0, 0};
                this.f735q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            C0247by.m890a((View) this.f735q, f);
            C0531l lVar = new C0531l();
            C0314ek b = C0247by.m917j(this.f735q).mo1557b(0.0f);
            b.mo1555a(this.f729g);
            lVar.mo2231a(b);
            if (this.f716C && this.f738t != null) {
                C0247by.m890a(this.f738t, f);
                lVar.mo2231a(C0247by.m917j(this.f738t).mo1557b(0.0f));
            }
            lVar.mo2234a(f712j);
            lVar.mo2230a(250);
            lVar.mo2233a(this.f728f);
            this.f721H = lVar;
            lVar.mo2235a();
        }
        if (this.f734p != null) {
            C0247by.requestApplyInsets(this.f734p);
        }
    }

    /* renamed from: j */
    public int mo2080j() {
        return this.f736r.mo3110p();
    }

    /* renamed from: j */
    public void mo2081j(boolean z) {
        if (this.f721H != null) {
            this.f721H.mo2236b();
        }
        if (this.f715B != 0 || !f713k || (!this.f722I && !z)) {
            this.f727e.onAnimationEnd((View) null);
            return;
        }
        C0247by.m903b((View) this.f735q, 1.0f);
        this.f735q.setTransitioning(true);
        C0531l lVar = new C0531l();
        float f = (float) (-this.f735q.getHeight());
        if (z) {
            int[] iArr = {0, 0};
            this.f735q.getLocationInWindow(iArr);
            f -= (float) iArr[1];
        }
        C0314ek b = C0247by.m917j(this.f735q).mo1557b(f);
        b.mo1555a(this.f729g);
        lVar.mo2231a(b);
        if (this.f716C && this.f738t != null) {
            lVar.mo2231a(C0247by.m917j(this.f738t).mo1557b(f));
        }
        lVar.mo2234a(f711i);
        lVar.mo2230a(250);
        lVar.mo2233a(this.f727e);
        this.f721H = lVar;
        lVar.mo2235a();
    }

    /* renamed from: k */
    public int mo2082k() {
        return this.f735q.getHeight();
    }

    /* renamed from: k */
    public void mo2083k(boolean z) {
        C0314ek a;
        C0314ek a2;
        if (z) {
            m2031p();
        } else {
            m2032q();
        }
        if (z) {
            a2 = this.f736r.mo3081a(4, 100);
            a = this.f737s.mo2639a(0, 200);
        } else {
            a = this.f736r.mo3081a(0, 200);
            a2 = this.f737s.mo2639a(8, 100);
        }
        C0531l lVar = new C0531l();
        lVar.mo2232a(a2, a);
        lVar.mo2235a();
    }

    /* renamed from: l */
    public void mo2084l() {
        if (this.f718E) {
            this.f718E = false;
            m2030m(true);
        }
    }

    /* renamed from: m */
    public void mo2085m() {
        if (!this.f718E) {
            this.f718E = true;
            m2030m(true);
        }
    }

    /* renamed from: n */
    public void mo2086n() {
        if (this.f721H != null) {
            this.f721H.mo2236b();
            this.f721H = null;
        }
    }

    /* renamed from: o */
    public void mo2087o() {
    }

    public void setCustomView(View view) {
        this.f736r.setCustomView(view);
    }
}
