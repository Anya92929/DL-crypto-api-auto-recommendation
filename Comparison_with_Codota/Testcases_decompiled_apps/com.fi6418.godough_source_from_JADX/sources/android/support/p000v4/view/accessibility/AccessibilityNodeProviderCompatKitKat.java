package android.support.p000v4.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* renamed from: android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat */
class AccessibilityNodeProviderCompatKitKat {

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat$AccessibilityNodeInfoBridge */
    interface AccessibilityNodeInfoBridge {
        Object createAccessibilityNodeInfo(int i);

        List<Object> findAccessibilityNodeInfosByText(String str, int i);

        Object findFocus(int i);

        boolean performAction(int i, int i2, Bundle bundle);
    }

    AccessibilityNodeProviderCompatKitKat() {
    }

    public static Object newAccessibilityNodeProviderBridge(final AccessibilityNodeInfoBridge accessibilityNodeInfoBridge) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) AccessibilityNodeInfoBridge.this.createAccessibilityNodeInfo(i);
            }

            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return AccessibilityNodeInfoBridge.this.findAccessibilityNodeInfosByText(str, i);
            }

            public AccessibilityNodeInfo findFocus(int i) {
                return (AccessibilityNodeInfo) AccessibilityNodeInfoBridge.this.findFocus(i);
            }

            public boolean performAction(int i, int i2, Bundle bundle) {
                return AccessibilityNodeInfoBridge.this.performAction(i, i2, bundle);
            }
        };
    }
}
