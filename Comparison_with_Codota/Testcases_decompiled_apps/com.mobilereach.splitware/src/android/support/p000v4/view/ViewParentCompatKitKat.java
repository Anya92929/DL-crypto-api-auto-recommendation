package android.support.p000v4.view;

import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.view.ViewParentCompatKitKat */
class ViewParentCompatKitKat {
    ViewParentCompatKitKat() {
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent parent, View child, View source, int changeType) {
        parent.notifySubtreeAccessibilityStateChanged(child, source, changeType);
    }
}
