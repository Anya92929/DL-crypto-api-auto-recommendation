package android.support.p009v4.view;

import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.view.ei */
class C0312ei implements C0309ef {
    C0312ei() {
    }

    /* renamed from: a */
    public void mo1544a(ViewParent viewParent, View view) {
        if (viewParent instanceof C0236bn) {
            ((C0236bn) viewParent).onStopNestedScroll(view);
        }
    }

    /* renamed from: a */
    public void mo1545a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        if (viewParent instanceof C0236bn) {
            ((C0236bn) viewParent).onNestedScroll(view, i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    public void mo1546a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        if (viewParent instanceof C0236bn) {
            ((C0236bn) viewParent).onNestedPreScroll(view, i, i2, iArr);
        }
    }

    /* renamed from: a */
    public boolean mo1547a(ViewParent viewParent, View view, float f, float f2) {
        if (viewParent instanceof C0236bn) {
            return ((C0236bn) viewParent).onNestedPreFling(view, f, f2);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo1548a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        if (viewParent instanceof C0236bn) {
            return ((C0236bn) viewParent).onNestedFling(view, f, f2, z);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo1549a(ViewParent viewParent, View view, View view2, int i) {
        if (viewParent instanceof C0236bn) {
            return ((C0236bn) viewParent).onStartNestedScroll(view, view2, i);
        }
        return false;
    }

    /* renamed from: b */
    public void mo1550b(ViewParent viewParent, View view, View view2, int i) {
        if (viewParent instanceof C0236bn) {
            ((C0236bn) viewParent).onNestedScrollAccepted(view, view2, i);
        }
    }
}
