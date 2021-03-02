package android.support.p003v7.widget;

import android.support.p003v7.widget.RecyclerView;
import android.view.View;

/* renamed from: android.support.v7.widget.LayoutState */
class LayoutState {

    /* renamed from: a */
    int f2765a;

    /* renamed from: b */
    int f2766b;

    /* renamed from: c */
    int f2767c;

    /* renamed from: d */
    int f2768d;

    /* renamed from: e */
    int f2769e = 0;

    /* renamed from: f */
    int f2770f = 0;

    LayoutState() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo5270a(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(this.f2766b);
        this.f2766b += this.f2767c;
        return viewForPosition;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5271a(RecyclerView.State state) {
        return this.f2766b >= 0 && this.f2766b < state.getItemCount();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f2765a + ", mCurrentPosition=" + this.f2766b + ", mItemDirection=" + this.f2767c + ", mLayoutDirection=" + this.f2768d + ", mStartLine=" + this.f2769e + ", mEndLine=" + this.f2770f + '}';
    }
}
