package android.support.p021v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.support.p009v4.view.C0247by;
import android.support.p009v4.view.C0347q;
import android.support.p021v7.p023b.C0509e;
import android.support.p021v7.p023b.C0512h;
import android.support.p021v7.widget.C0647cr;
import android.support.p021v7.widget.C0648cs;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: android.support.v7.view.menu.g */
final class C0554g extends C0535ab implements C0538ae, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: a */
    private final Context f1054a;

    /* renamed from: b */
    private final int f1055b;

    /* renamed from: c */
    private final int f1056c;

    /* renamed from: d */
    private final int f1057d;

    /* renamed from: e */
    private final boolean f1058e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Handler f1059f;

    /* renamed from: g */
    private final List f1060g = new LinkedList();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final List f1061h = new ArrayList();

    /* renamed from: i */
    private final ViewTreeObserver.OnGlobalLayoutListener f1062i = new C0555h(this);

    /* renamed from: j */
    private final C0647cr f1063j = new C0556i(this);

    /* renamed from: k */
    private int f1064k = 0;

    /* renamed from: l */
    private int f1065l = 0;

    /* renamed from: m */
    private View f1066m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public View f1067n;

    /* renamed from: o */
    private int f1068o;

    /* renamed from: p */
    private int f1069p;

    /* renamed from: q */
    private int f1070q;

    /* renamed from: r */
    private boolean f1071r;

    /* renamed from: s */
    private boolean f1072s;

    /* renamed from: t */
    private C0539af f1073t;

    /* renamed from: u */
    private ViewTreeObserver f1074u;

    /* renamed from: v */
    private PopupWindow.OnDismissListener f1075v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f1076w;

    public C0554g(Context context, View view, int i, int i2, boolean z) {
        this.f1054a = context;
        this.f1066m = view;
        this.f1056c = i;
        this.f1057d = i2;
        this.f1058e = z;
        this.f1071r = false;
        this.f1068o = m2402h();
        Resources resources = context.getResources();
        this.f1055b = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0509e.abc_config_prefDialogWidth));
        this.f1059f = new Handler();
    }

    /* renamed from: a */
    private MenuItem m2392a(C0562o oVar, C0562o oVar2) {
        int size = oVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = oVar.getItem(i);
            if (item.hasSubMenu() && oVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    /* renamed from: a */
    private View m2393a(C0558k kVar, C0562o oVar) {
        C0561n nVar;
        int i;
        int i2;
        int i3 = 0;
        MenuItem a = m2392a(kVar.f1084b, oVar);
        if (a == null) {
            return null;
        }
        ListView a2 = kVar.mo2420a();
        ListAdapter adapter = a2.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            nVar = (C0561n) headerViewListAdapter.getWrappedAdapter();
        } else {
            nVar = (C0561n) adapter;
            i = 0;
        }
        int count = nVar.getCount();
        while (true) {
            if (i3 >= count) {
                i2 = -1;
                break;
            } else if (a == nVar.getItem(i3)) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 == -1) {
            return null;
        }
        int firstVisiblePosition = (i2 + i) - a2.getFirstVisiblePosition();
        if (firstVisiblePosition < 0 || firstVisiblePosition >= a2.getChildCount()) {
            return null;
        }
        return a2.getChildAt(firstVisiblePosition);
    }

    /* renamed from: b */
    private void m2397b(C0562o oVar) {
        View view;
        C0558k kVar;
        int i;
        int i2;
        Rect f;
        LayoutInflater from = LayoutInflater.from(this.f1054a);
        C0561n nVar = new C0561n(oVar, from, this.f1058e);
        nVar.mo2432a(this.f1071r);
        int a = m2292a(nVar, (ViewGroup) null, this.f1054a, this.f1055b);
        C0648cs g = m2401g();
        g.mo3065a((ListAdapter) nVar);
        g.mo3179f(a);
        g.mo3178e(this.f1065l);
        if (this.f1061h.size() > 0) {
            C0558k kVar2 = (C0558k) this.f1061h.get(this.f1061h.size() - 1);
            view = m2393a(kVar2, oVar);
            kVar = kVar2;
        } else {
            view = null;
            kVar = null;
        }
        if (view != null) {
            g.mo3220b(false);
            g.mo3218a((Object) null);
            int d = m2400d(a);
            boolean z = d == 1;
            this.f1068o = d;
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int j = kVar.f1083a.mo3186j() + iArr[0];
            i2 = iArr[1] + kVar.f1083a.mo3187k();
            i = (this.f1065l & 5) == 5 ? z ? j + a : j - view.getWidth() : z ? view.getWidth() + j : j - a;
            f = null;
        } else {
            i = this.f1069p;
            i2 = this.f1070q;
            f = mo2318f();
        }
        g.mo3176c(i);
        g.mo3177d(i2);
        g.mo3170a(f);
        this.f1061h.add(new C0558k(g, oVar, this.f1068o));
        g.mo2362a();
        if (kVar == null && this.f1072s && oVar.mo2489m() != null) {
            ListView e = g.mo2365e();
            FrameLayout frameLayout = (FrameLayout) from.inflate(C0512h.abc_popup_menu_header_item_layout, e, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(oVar.mo2489m());
            e.addHeaderView(frameLayout, (Object) null, false);
            g.mo2362a();
        }
    }

    /* renamed from: c */
    private int m2398c(C0562o oVar) {
        int size = this.f1061h.size();
        for (int i = 0; i < size; i++) {
            if (oVar == ((C0558k) this.f1061h.get(i)).f1084b) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: d */
    private int m2400d(int i) {
        ListView a = ((C0558k) this.f1061h.get(this.f1061h.size() - 1)).mo2420a();
        int[] iArr = new int[2];
        a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1067n.getWindowVisibleDisplayFrame(rect);
        if (this.f1068o != 1) {
            return iArr[0] - i < 0 ? 1 : 0;
        }
        return (a.getWidth() + iArr[0]) + i > rect.right ? 0 : 1;
    }

    /* renamed from: g */
    private C0648cs m2401g() {
        C0648cs csVar = new C0648cs(this.f1054a, (AttributeSet) null, this.f1056c, this.f1057d);
        csVar.mo3217a(this.f1063j);
        csVar.mo3172a((AdapterView.OnItemClickListener) this);
        csVar.mo3173a((PopupWindow.OnDismissListener) this);
        csVar.setAnchorView(this.f1066m);
        csVar.mo3178e(this.f1065l);
        csVar.mo3174a(true);
        return csVar;
    }

    /* renamed from: h */
    private int m2402h() {
        return C0247by.m909d(this.f1066m) == 1 ? 0 : 1;
    }

    /* renamed from: a */
    public void mo2362a() {
        if (!mo2364d()) {
            for (C0562o b : this.f1060g) {
                m2397b(b);
            }
            this.f1060g.clear();
            this.f1067n = this.f1066m;
            if (this.f1067n != null) {
                boolean z = this.f1074u == null;
                this.f1074u = this.f1067n.getViewTreeObserver();
                if (z) {
                    this.f1074u.addOnGlobalLayoutListener(this.f1062i);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo2307a(int i) {
        if (this.f1064k != i) {
            this.f1064k = i;
            this.f1065l = C0347q.m1334a(i, C0247by.m909d(this.f1066m));
        }
    }

    /* renamed from: a */
    public void mo2333a(C0539af afVar) {
        this.f1073t = afVar;
    }

    /* renamed from: a */
    public void mo2310a(C0562o oVar) {
        oVar.mo2450a((C0538ae) this, this.f1054a);
        if (mo2364d()) {
            m2397b(oVar);
        } else {
            this.f1060g.add(oVar);
        }
    }

    /* renamed from: a */
    public void mo2334a(C0562o oVar, boolean z) {
        int c = m2398c(oVar);
        if (c >= 0) {
            int i = c + 1;
            if (i < this.f1061h.size()) {
                ((C0558k) this.f1061h.get(i)).f1084b.mo2454a(false);
            }
            C0558k kVar = (C0558k) this.f1061h.remove(c);
            kVar.f1084b.mo2468b((C0538ae) this);
            if (this.f1076w) {
                kVar.f1083a.mo3219b((Object) null);
                kVar.f1083a.mo3175b(0);
            }
            kVar.f1083a.mo2363c();
            int size = this.f1061h.size();
            if (size > 0) {
                this.f1068o = ((C0558k) this.f1061h.get(size - 1)).f1085c;
            } else {
                this.f1068o = m2402h();
            }
            if (size == 0) {
                mo2363c();
                if (this.f1073t != null) {
                    this.f1073t.mo2041a(oVar, true);
                }
                if (this.f1074u != null) {
                    if (this.f1074u.isAlive()) {
                        this.f1074u.removeGlobalOnLayoutListener(this.f1062i);
                    }
                    this.f1074u = null;
                }
                this.f1075v.onDismiss();
            } else if (z) {
                ((C0558k) this.f1061h.get(0)).f1084b.mo2454a(false);
            }
        }
    }

    /* renamed from: a */
    public void mo2311a(PopupWindow.OnDismissListener onDismissListener) {
        this.f1075v = onDismissListener;
    }

    /* renamed from: a */
    public void mo2312a(boolean z) {
        this.f1071r = z;
    }

    /* renamed from: a */
    public boolean mo2335a(C0547an anVar) {
        for (C0558k kVar : this.f1061h) {
            if (anVar == kVar.f1084b) {
                kVar.mo2420a().requestFocus();
                return true;
            }
        }
        if (!anVar.hasVisibleItems()) {
            return false;
        }
        mo2310a((C0562o) anVar);
        if (this.f1073t != null) {
            this.f1073t.mo2042a(anVar);
        }
        return true;
    }

    /* renamed from: b */
    public void mo2314b(int i) {
        this.f1069p = i;
    }

    /* renamed from: b */
    public void mo2336b(boolean z) {
        for (C0558k a : this.f1061h) {
            m2293a(a.mo2420a().getAdapter()).notifyDataSetChanged();
        }
    }

    /* renamed from: b */
    public boolean mo2337b() {
        return false;
    }

    /* renamed from: c */
    public void mo2363c() {
        int size = this.f1061h.size();
        if (size > 0) {
            C0558k[] kVarArr = (C0558k[]) this.f1061h.toArray(new C0558k[size]);
            for (int i = size - 1; i >= 0; i--) {
                C0558k kVar = kVarArr[i];
                if (kVar.f1083a.mo2364d()) {
                    kVar.f1083a.mo2363c();
                }
            }
        }
    }

    /* renamed from: c */
    public void mo2316c(int i) {
        this.f1070q = i;
    }

    /* renamed from: c */
    public void mo2317c(boolean z) {
        this.f1072s = z;
    }

    /* renamed from: d */
    public boolean mo2364d() {
        return this.f1061h.size() > 0 && ((C0558k) this.f1061h.get(0)).f1083a.mo2364d();
    }

    /* renamed from: e */
    public ListView mo2365e() {
        if (this.f1061h.isEmpty()) {
            return null;
        }
        return ((C0558k) this.f1061h.get(this.f1061h.size() - 1)).mo2420a();
    }

    public void onDismiss() {
        C0558k kVar;
        int size = this.f1061h.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                kVar = null;
                break;
            }
            kVar = (C0558k) this.f1061h.get(i);
            if (!kVar.f1083a.mo2364d()) {
                break;
            }
            i++;
        }
        if (kVar != null) {
            kVar.f1084b.mo2454a(false);
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo2363c();
        return true;
    }

    public void setAnchorView(View view) {
        if (this.f1066m != view) {
            this.f1066m = view;
            this.f1065l = C0347q.m1334a(this.f1064k, C0247by.m909d(this.f1066m));
        }
    }
}
