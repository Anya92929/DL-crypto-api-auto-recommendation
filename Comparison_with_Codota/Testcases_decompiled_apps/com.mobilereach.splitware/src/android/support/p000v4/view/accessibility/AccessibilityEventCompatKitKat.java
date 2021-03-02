package android.support.p000v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.accessibility.AccessibilityEventCompatKitKat */
class AccessibilityEventCompatKitKat {
    AccessibilityEventCompatKitKat() {
    }

    public static void setContentChangeTypes(AccessibilityEvent event, int changeTypes) {
        event.setContentChangeTypes(changeTypes);
    }

    public static int getContentChangeTypes(AccessibilityEvent event) {
        return event.getContentChangeTypes();
    }
}
