package android.support.p021v7.view.menu;

import android.content.Context;
import android.os.IBinder;
import android.support.p021v7.p023b.C0512h;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;

/* renamed from: android.support.v7.view.menu.l */
public class C0559l implements C0538ae, AdapterView.OnItemClickListener {

    /* renamed from: a */
    Context f1086a;

    /* renamed from: b */
    LayoutInflater f1087b;

    /* renamed from: c */
    C0562o f1088c;

    /* renamed from: d */
    ExpandedMenuView f1089d;

    /* renamed from: e */
    int f1090e;

    /* renamed from: f */
    int f1091f;

    /* renamed from: g */
    C0560m f1092g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f1093h;

    /* renamed from: i */
    private C0539af f1094i;

    public C0559l(int i, int i2) {
        this.f1091f = i;
        this.f1090e = i2;
    }

    public C0559l(Context context, int i) {
        this(i, 0);
        this.f1086a = context;
        this.f1087b = LayoutInflater.from(this.f1086a);
    }

    /* renamed from: a */
    public C0540ag mo2421a(ViewGroup viewGroup) {
        if (this.f1089d == null) {
            this.f1089d = (ExpandedMenuView) this.f1087b.inflate(C0512h.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1092g == null) {
                this.f1092g = new C0560m(this);
            }
            this.f1089d.setAdapter(this.f1092g);
            this.f1089d.setOnItemClickListener(this);
        }
        return this.f1089d;
    }

    /* renamed from: a */
    public ListAdapter mo2422a() {
        if (this.f1092g == null) {
            this.f1092g = new C0560m(this);
        }
        return this.f1092g;
    }

    /* renamed from: a */
    public void mo2308a(Context context, C0562o oVar) {
        if (this.f1090e != 0) {
            this.f1086a = new ContextThemeWrapper(context, this.f1090e);
            this.f1087b = LayoutInflater.from(this.f1086a);
        } else if (this.f1086a != null) {
            this.f1086a = context;
            if (this.f1087b == null) {
                this.f1087b = LayoutInflater.from(this.f1086a);
            }
        }
        this.f1088c = oVar;
        if (this.f1092g != null) {
            this.f1092g.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public void mo2333a(C0539af afVar) {
        this.f1094i = afVar;
    }

    /* renamed from: a */
    public void mo2334a(C0562o oVar, boolean z) {
        if (this.f1094i != null) {
            this.f1094i.mo2041a(oVar, z);
        }
    }

    /* renamed from: a */
    public boolean mo2335a(C0547an anVar) {
        if (!anVar.hasVisibleItems()) {
            return false;
        }
        new C0565r(anVar).mo2503a((IBinder) null);
        if (this.f1094i != null) {
            this.f1094i.mo2042a(anVar);
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo2313a(C0562o oVar, C0566s sVar) {
        return false;
    }

    /* renamed from: b */
    public void mo2336b(boolean z) {
        if (this.f1092g != null) {
            this.f1092g.notifyDataSetChanged();
        }
    }

    /* renamed from: b */
    public boolean mo2337b() {
        return false;
    }

    /* renamed from: b */
    public boolean mo2315b(C0562o oVar, C0566s sVar) {
        return false;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1088c.mo2456a((MenuItem) this.f1092g.getItem(i), (C0538ae) this, 0);
    }
}
