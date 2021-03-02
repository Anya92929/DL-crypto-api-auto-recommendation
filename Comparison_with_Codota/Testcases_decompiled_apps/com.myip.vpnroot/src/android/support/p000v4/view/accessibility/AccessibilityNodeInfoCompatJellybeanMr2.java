package android.support.p000v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr2 */
class AccessibilityNodeInfoCompatJellybeanMr2 {
    AccessibilityNodeInfoCompatJellybeanMr2() {
    }

    public static void setViewIdResourceName(Object info, String viewId) {
        ((AccessibilityNodeInfo) info).setViewIdResourceName(viewId);
    }

    public static String getViewIdResourceName(Object info) {
        return ((AccessibilityNodeInfo) info).getViewIdResourceName();
    }
}
