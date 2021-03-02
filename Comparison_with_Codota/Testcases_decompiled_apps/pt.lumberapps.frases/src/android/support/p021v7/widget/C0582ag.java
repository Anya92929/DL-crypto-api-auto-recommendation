package android.support.p021v7.widget;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.p009v4.view.C0247by;
import android.support.p021v7.p023b.C0511g;
import android.support.p021v7.p023b.C0512h;
import android.support.p021v7.p023b.C0513i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.ag */
class C0582ag extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ ActivityChooserView f1363a;

    /* renamed from: b */
    private C0704z f1364b;

    /* renamed from: c */
    private int f1365c;

    /* renamed from: d */
    private boolean f1366d;

    /* renamed from: e */
    private boolean f1367e;

    /* renamed from: f */
    private boolean f1368f;

    /* renamed from: a */
    public int mo2925a() {
        int i = this.f1365c;
        this.f1365c = Integer.MAX_VALUE;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = getCount();
        View view = null;
        int i2 = 0;
        for (int i3 = 0; i3 < count; i3++) {
            view = getView(i3, view, (ViewGroup) null);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        this.f1365c = i;
        return i2;
    }

    /* renamed from: a */
    public void mo2926a(int i) {
        if (this.f1365c != i) {
            this.f1365c = i;
            notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public void mo2927a(C0704z zVar) {
        C0704z d = this.f1363a.f1229b.mo2932d();
        if (d != null && this.f1363a.isShown()) {
            d.unregisterObserver(this.f1363a.f1236i);
        }
        this.f1364b = zVar;
        if (zVar != null && this.f1363a.isShown()) {
            zVar.registerObserver(this.f1363a.f1236i);
        }
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void mo2928a(boolean z) {
        if (this.f1368f != z) {
            this.f1368f = z;
            notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public void mo2929a(boolean z, boolean z2) {
        if (this.f1366d != z || this.f1367e != z2) {
            this.f1366d = z;
            this.f1367e = z2;
            notifyDataSetChanged();
        }
    }

    /* renamed from: b */
    public ResolveInfo mo2930b() {
        return this.f1364b.mo3371b();
    }

    /* renamed from: c */
    public int mo2931c() {
        return this.f1364b.mo3367a();
    }

    /* renamed from: d */
    public C0704z mo2932d() {
        return this.f1364b;
    }

    /* renamed from: e */
    public boolean mo2933e() {
        return this.f1366d;
    }

    public int getCount() {
        int a = this.f1364b.mo3367a();
        if (!this.f1366d && this.f1364b.mo3371b() != null) {
            a--;
        }
        int min = Math.min(a, this.f1365c);
        return this.f1368f ? min + 1 : min;
    }

    public Object getItem(int i) {
        switch (getItemViewType(i)) {
            case 0:
                if (!this.f1366d && this.f1364b.mo3371b() != null) {
                    i++;
                }
                return this.f1364b.mo3369a(i);
            case 1:
                return null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return (!this.f1368f || i != getCount() + -1) ? 0 : 1;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || view.getId() != C0511g.list_item) {
                    view = LayoutInflater.from(this.f1363a.getContext()).inflate(C0512h.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = this.f1363a.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                ((ImageView) view.findViewById(C0511g.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(C0511g.title)).setText(resolveInfo.loadLabel(packageManager));
                if (!this.f1366d || i != 0 || !this.f1367e) {
                    C0247by.m904b(view, false);
                    return view;
                }
                C0247by.m904b(view, true);
                return view;
            case 1:
                if (view != null && view.getId() == 1) {
                    return view;
                }
                View inflate = LayoutInflater.from(this.f1363a.getContext()).inflate(C0512h.abc_activity_chooser_view_list_item, viewGroup, false);
                inflate.setId(1);
                ((TextView) inflate.findViewById(C0511g.title)).setText(this.f1363a.getContext().getString(C0513i.abc_activity_chooser_view_see_all));
                return inflate;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int getViewTypeCount() {
        return 3;
    }
}
