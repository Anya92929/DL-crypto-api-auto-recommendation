package android.support.p021v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* renamed from: android.support.v7.view.menu.ab */
abstract class C0535ab implements C0538ae, C0544ak, AdapterView.OnItemClickListener {

    /* renamed from: a */
    private Rect f1001a;

    C0535ab() {
    }

    /* renamed from: a */
    protected static int m2292a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i2 = 0;
        int i3 = 0;
        View view = null;
        int i4 = 0;
        ViewGroup viewGroup2 = viewGroup;
        while (i2 < count) {
            int itemViewType = listAdapter.getItemViewType(i2);
            if (itemViewType != i3) {
                i3 = itemViewType;
                view = null;
            }
            FrameLayout frameLayout = viewGroup2 == null ? new FrameLayout(context) : viewGroup2;
            view = listAdapter.getView(i2, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth <= i4) {
                measuredWidth = i4;
            }
            i2++;
            i4 = measuredWidth;
            viewGroup2 = frameLayout;
        }
        return i4;
    }

    /* renamed from: a */
    protected static C0561n m2293a(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (C0561n) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (C0561n) listAdapter;
    }

    /* renamed from: a */
    public abstract void mo2307a(int i);

    /* renamed from: a */
    public void mo2308a(Context context, C0562o oVar) {
    }

    /* renamed from: a */
    public void mo2309a(Rect rect) {
        this.f1001a = rect;
    }

    /* renamed from: a */
    public abstract void mo2310a(C0562o oVar);

    /* renamed from: a */
    public abstract void mo2311a(PopupWindow.OnDismissListener onDismissListener);

    /* renamed from: a */
    public abstract void mo2312a(boolean z);

    /* renamed from: a */
    public boolean mo2313a(C0562o oVar, C0566s sVar) {
        return false;
    }

    /* renamed from: b */
    public abstract void mo2314b(int i);

    /* renamed from: b */
    public boolean mo2315b(C0562o oVar, C0566s sVar) {
        return false;
    }

    /* renamed from: c */
    public abstract void mo2316c(int i);

    /* renamed from: c */
    public abstract void mo2317c(boolean z);

    /* renamed from: f */
    public Rect mo2318f() {
        return this.f1001a;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        m2293a(listAdapter).f1098b.mo2455a((MenuItem) listAdapter.getItem(i), 0);
    }

    public abstract void setAnchorView(View view);
}
