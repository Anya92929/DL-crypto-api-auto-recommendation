package android.support.p000v4.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* renamed from: android.support.v4.view.accessibility.AccessibilityRecordCompatJellyBean */
class AccessibilityRecordCompatJellyBean {
    AccessibilityRecordCompatJellyBean() {
    }

    public static void setSource(Object record, View root, int virtualDescendantId) {
        ((AccessibilityRecord) record).setSource(root, virtualDescendantId);
    }
}
