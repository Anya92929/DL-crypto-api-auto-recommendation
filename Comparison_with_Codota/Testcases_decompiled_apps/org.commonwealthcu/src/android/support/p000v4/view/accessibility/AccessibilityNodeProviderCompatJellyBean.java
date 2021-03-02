package android.support.p000v4.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* renamed from: android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean */
class AccessibilityNodeProviderCompatJellyBean {

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean$AccessibilityNodeInfoBridge */
    interface AccessibilityNodeInfoBridge {
        Object createAccessibilityNodeInfo(int i);

        List findAccessibilityNodeInfosByText(String str, int i);

        boolean performAction(int i, int i2, Bundle bundle);
    }

    AccessibilityNodeProviderCompatJellyBean() {
    }

    public static Object newAccessibilityNodeProviderBridge(final AccessibilityNodeInfoBridge accessibilityNodeInfoBridge) {
        return new AccessibilityNodeProvider() {
            public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) AccessibilityNodeInfoBridge.this.createAccessibilityNodeInfo(i);
            }

            public final List findAccessibilityNodeInfosByText(String str, int i) {
                return AccessibilityNodeInfoBridge.this.findAccessibilityNodeInfosByText(str, i);
            }

            public final boolean performAction(int i, int i2, Bundle bundle) {
                return AccessibilityNodeInfoBridge.this.performAction(i, i2, bundle);
            }
        };
    }
}
