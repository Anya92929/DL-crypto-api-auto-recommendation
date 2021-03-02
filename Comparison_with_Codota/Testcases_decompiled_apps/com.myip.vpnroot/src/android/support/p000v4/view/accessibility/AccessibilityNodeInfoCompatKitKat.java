package android.support.p000v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat */
class AccessibilityNodeInfoCompatKitKat {
    AccessibilityNodeInfoCompatKitKat() {
    }

    public static int getLiveRegion(Object info) {
        return ((AccessibilityNodeInfo) info).getLiveRegion();
    }

    public static void setLiveRegion(Object info, int mode) {
        ((AccessibilityNodeInfo) info).setLiveRegion(mode);
    }
}
