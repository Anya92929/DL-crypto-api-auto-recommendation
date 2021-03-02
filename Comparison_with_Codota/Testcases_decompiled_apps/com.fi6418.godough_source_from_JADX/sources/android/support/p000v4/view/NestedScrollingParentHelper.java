package android.support.p000v4.view;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.view.NestedScrollingParentHelper */
public class NestedScrollingParentHelper {

    /* renamed from: a */
    private final ViewGroup f1199a;

    /* renamed from: b */
    private int f1200b;

    public NestedScrollingParentHelper(ViewGroup viewGroup) {
        this.f1199a = viewGroup;
    }

    public int getNestedScrollAxes() {
        return this.f1200b;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1200b = i;
    }

    public void onStopNestedScroll(View view) {
        this.f1200b = 0;
    }
}
