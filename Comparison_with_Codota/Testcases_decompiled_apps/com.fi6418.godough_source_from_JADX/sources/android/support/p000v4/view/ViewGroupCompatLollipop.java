package android.support.p000v4.view;

import android.view.ViewGroup;

/* renamed from: android.support.v4.view.ViewGroupCompatLollipop */
class ViewGroupCompatLollipop {
    ViewGroupCompatLollipop() {
    }

    public static int getNestedScrollAxes(ViewGroup viewGroup) {
        return viewGroup.getNestedScrollAxes();
    }

    public static boolean isTransitionGroup(ViewGroup viewGroup) {
        return viewGroup.isTransitionGroup();
    }

    public static void setTransitionGroup(ViewGroup viewGroup, boolean z) {
        viewGroup.setTransitionGroup(z);
    }
}
