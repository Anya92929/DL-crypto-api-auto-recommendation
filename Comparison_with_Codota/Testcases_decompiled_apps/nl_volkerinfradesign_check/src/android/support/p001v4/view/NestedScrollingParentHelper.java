package android.support.p001v4.view;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.view.NestedScrollingParentHelper */
public class NestedScrollingParentHelper {

    /* renamed from: a */
    private final ViewGroup f940a;

    /* renamed from: b */
    private int f941b;

    public NestedScrollingParentHelper(ViewGroup viewGroup) {
        this.f940a = viewGroup;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f941b = i;
    }

    public int getNestedScrollAxes() {
        return this.f941b;
    }

    public void onStopNestedScroll(View view) {
        this.f941b = 0;
    }
}
