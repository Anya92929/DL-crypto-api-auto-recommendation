package android.support.p009v4.view;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.view.bo */
public class C0237bo {

    /* renamed from: a */
    private final ViewGroup f349a;

    /* renamed from: b */
    private int f350b;

    public C0237bo(ViewGroup viewGroup) {
        this.f349a = viewGroup;
    }

    /* renamed from: a */
    public int mo1438a() {
        return this.f350b;
    }

    /* renamed from: a */
    public void mo1439a(View view, View view2, int i) {
        this.f350b = i;
    }

    public void onStopNestedScroll(View view) {
        this.f350b = 0;
    }
}
