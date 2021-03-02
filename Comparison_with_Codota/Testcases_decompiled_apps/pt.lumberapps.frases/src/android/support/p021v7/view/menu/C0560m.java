package android.support.p021v7.view.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.m */
class C0560m extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ C0559l f1095a;

    /* renamed from: b */
    private int f1096b = -1;

    public C0560m(C0559l lVar) {
        this.f1095a = lVar;
        mo2425a();
    }

    /* renamed from: a */
    public C0566s getItem(int i) {
        ArrayList l = this.f1095a.f1088c.mo2488l();
        int a = this.f1095a.f1093h + i;
        if (this.f1096b >= 0 && a >= this.f1096b) {
            a++;
        }
        return (C0566s) l.get(a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2425a() {
        C0566s r = this.f1095a.f1088c.mo2495r();
        if (r != null) {
            ArrayList l = this.f1095a.f1088c.mo2488l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (((C0566s) l.get(i)) == r) {
                    this.f1096b = i;
                    return;
                }
            }
        }
        this.f1096b = -1;
    }

    public int getCount() {
        int size = this.f1095a.f1088c.mo2488l().size() - this.f1095a.f1093h;
        return this.f1096b < 0 ? size : size - 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.f1095a.f1087b.inflate(this.f1095a.f1091f, viewGroup, false) : view;
        ((C0541ah) inflate).mo2238a(getItem(i), 0);
        return inflate;
    }

    public void notifyDataSetChanged() {
        mo2425a();
        super.notifyDataSetChanged();
    }
}
