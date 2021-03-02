package android.support.p021v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.p021v7.p023b.C0509e;
import android.support.p021v7.p023b.C0512h;
import android.support.p021v7.widget.C0648cs;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

/* renamed from: android.support.v7.view.menu.al */
final class C0545al extends C0535ab implements C0538ae, View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {

    /* renamed from: a */
    private final Context f1015a;

    /* renamed from: b */
    private final C0562o f1016b;

    /* renamed from: c */
    private final C0561n f1017c;

    /* renamed from: d */
    private final boolean f1018d;

    /* renamed from: e */
    private final int f1019e;

    /* renamed from: f */
    private final int f1020f;

    /* renamed from: g */
    private final int f1021g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C0648cs f1022h;

    /* renamed from: i */
    private final ViewTreeObserver.OnGlobalLayoutListener f1023i = new C0546am(this);

    /* renamed from: j */
    private PopupWindow.OnDismissListener f1024j;

    /* renamed from: k */
    private View f1025k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public View f1026l;

    /* renamed from: m */
    private C0539af f1027m;

    /* renamed from: n */
    private ViewTreeObserver f1028n;

    /* renamed from: o */
    private boolean f1029o;

    /* renamed from: p */
    private boolean f1030p;

    /* renamed from: q */
    private int f1031q;

    /* renamed from: r */
    private int f1032r = 0;

    /* renamed from: s */
    private int f1033s;

    /* renamed from: t */
    private int f1034t;

    /* renamed from: u */
    private boolean f1035u;

    public C0545al(Context context, C0562o oVar, View view, int i, int i2, boolean z) {
        this.f1015a = context;
        this.f1016b = oVar;
        this.f1018d = z;
        this.f1017c = new C0561n(oVar, LayoutInflater.from(context), this.f1018d);
        this.f1020f = i;
        this.f1021g = i2;
        Resources resources = context.getResources();
        this.f1019e = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0509e.abc_config_prefDialogWidth));
        this.f1025k = view;
        this.f1022h = new C0648cs(this.f1015a, (AttributeSet) null, this.f1020f, this.f1021g);
        oVar.mo2450a((C0538ae) this, context);
    }

    /* renamed from: g */
    private boolean m2340g() {
        if (mo2364d()) {
            return true;
        }
        if (this.f1029o || this.f1025k == null) {
            return false;
        }
        this.f1026l = this.f1025k;
        this.f1022h.mo3173a((PopupWindow.OnDismissListener) this);
        this.f1022h.mo3172a((AdapterView.OnItemClickListener) this);
        this.f1022h.mo3174a(true);
        View view = this.f1026l;
        boolean z = this.f1028n == null;
        this.f1028n = view.getViewTreeObserver();
        if (z) {
            this.f1028n.addOnGlobalLayoutListener(this.f1023i);
        }
        this.f1022h.setAnchorView(view);
        this.f1022h.mo3178e(this.f1032r);
        if (!this.f1030p) {
            this.f1031q = m2292a(this.f1017c, (ViewGroup) null, this.f1015a, this.f1019e);
            this.f1030p = true;
        }
        this.f1022h.mo3180g(this.f1031q);
        this.f1022h.mo3183h(2);
        this.f1022h.mo3176c(this.f1033s);
        this.f1022h.mo3177d(this.f1034t);
        this.f1022h.mo3170a(mo2318f());
        this.f1022h.mo2362a();
        ListView e = this.f1022h.mo2365e();
        e.setOnKeyListener(this);
        if (this.f1035u && this.f1016b.mo2489m() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1015a).inflate(C0512h.abc_popup_menu_header_item_layout, e, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f1016b.mo2489m());
            }
            frameLayout.setEnabled(false);
            e.addHeaderView(frameLayout, (Object) null, false);
        }
        this.f1022h.mo3065a((ListAdapter) this.f1017c);
        this.f1022h.mo2362a();
        return true;
    }

    /* renamed from: a */
    public void mo2362a() {
        if (!m2340g()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    /* renamed from: a */
    public void mo2307a(int i) {
        this.f1032r = i;
    }

    /* renamed from: a */
    public void mo2333a(C0539af afVar) {
        this.f1027m = afVar;
    }

    /* renamed from: a */
    public void mo2310a(C0562o oVar) {
    }

    /* renamed from: a */
    public void mo2334a(C0562o oVar, boolean z) {
        if (oVar == this.f1016b) {
            mo2363c();
            if (this.f1027m != null) {
                this.f1027m.mo2041a(oVar, z);
            }
        }
    }

    /* renamed from: a */
    public void mo2311a(PopupWindow.OnDismissListener onDismissListener) {
        this.f1024j = onDismissListener;
    }

    /* renamed from: a */
    public void mo2312a(boolean z) {
        this.f1017c.mo2432a(z);
    }

    /* renamed from: a */
    public boolean mo2335a(C0547an anVar) {
        if (anVar.hasVisibleItems()) {
            C0536ac acVar = new C0536ac(this.f1015a, anVar, this.f1026l, this.f1018d, this.f1020f, this.f1021g);
            acVar.mo2323a(this.f1027m);
            acVar.mo2324a(this.f1017c.mo2433a());
            if (acVar.mo2325a(this.f1033s, this.f1034t)) {
                if (this.f1027m != null) {
                    this.f1027m.mo2042a(anVar);
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public void mo2314b(int i) {
        this.f1033s = i;
    }

    /* renamed from: b */
    public void mo2336b(boolean z) {
        this.f1030p = false;
        if (this.f1017c != null) {
            this.f1017c.notifyDataSetChanged();
        }
    }

    /* renamed from: b */
    public boolean mo2337b() {
        return false;
    }

    /* renamed from: c */
    public void mo2363c() {
        if (mo2364d()) {
            this.f1022h.mo2363c();
        }
    }

    /* renamed from: c */
    public void mo2316c(int i) {
        this.f1034t = i;
    }

    /* renamed from: c */
    public void mo2317c(boolean z) {
        this.f1035u = z;
    }

    /* renamed from: d */
    public boolean mo2364d() {
        return !this.f1029o && this.f1022h.mo2364d();
    }

    /* renamed from: e */
    public ListView mo2365e() {
        return this.f1022h.mo2365e();
    }

    public void onDismiss() {
        this.f1029o = true;
        this.f1016b.close();
        if (this.f1028n != null) {
            if (!this.f1028n.isAlive()) {
                this.f1028n = this.f1026l.getViewTreeObserver();
            }
            this.f1028n.removeGlobalOnLayoutListener(this.f1023i);
            this.f1028n = null;
        }
        this.f1024j.onDismiss();
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo2363c();
        return true;
    }

    public void setAnchorView(View view) {
        this.f1025k = view;
    }
}
