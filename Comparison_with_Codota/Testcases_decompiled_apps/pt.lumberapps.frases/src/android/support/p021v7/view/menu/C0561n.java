package android.support.p021v7.view.menu;

import android.support.p021v7.p023b.C0512h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.n */
public class C0561n extends BaseAdapter {

    /* renamed from: a */
    static final int f1097a = C0512h.abc_popup_menu_item_layout;

    /* renamed from: b */
    C0562o f1098b;

    /* renamed from: c */
    private int f1099c = -1;

    /* renamed from: d */
    private boolean f1100d;

    /* renamed from: e */
    private final boolean f1101e;

    /* renamed from: f */
    private final LayoutInflater f1102f;

    public C0561n(C0562o oVar, LayoutInflater layoutInflater, boolean z) {
        this.f1101e = z;
        this.f1102f = layoutInflater;
        this.f1098b = oVar;
        mo2435c();
    }

    /* renamed from: a */
    public C0566s getItem(int i) {
        ArrayList l = this.f1101e ? this.f1098b.mo2488l() : this.f1098b.mo2484i();
        if (this.f1099c >= 0 && i >= this.f1099c) {
            i++;
        }
        return (C0566s) l.get(i);
    }

    /* renamed from: a */
    public void mo2432a(boolean z) {
        this.f1100d = z;
    }

    /* renamed from: a */
    public boolean mo2433a() {
        return this.f1100d;
    }

    /* renamed from: b */
    public C0562o mo2434b() {
        return this.f1098b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo2435c() {
        C0566s r = this.f1098b.mo2495r();
        if (r != null) {
            ArrayList l = this.f1098b.mo2488l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (((C0566s) l.get(i)) == r) {
                    this.f1099c = i;
                    return;
                }
            }
        }
        this.f1099c = -1;
    }

    public int getCount() {
        ArrayList l = this.f1101e ? this.f1098b.mo2488l() : this.f1098b.mo2484i();
        return this.f1099c < 0 ? l.size() : l.size() - 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.f1102f.inflate(f1097a, viewGroup, false) : view;
        C0541ah ahVar = (C0541ah) inflate;
        if (this.f1100d) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        ahVar.mo2238a(getItem(i), 0);
        return inflate;
    }

    public void notifyDataSetChanged() {
        mo2435c();
        super.notifyDataSetChanged();
    }
}
