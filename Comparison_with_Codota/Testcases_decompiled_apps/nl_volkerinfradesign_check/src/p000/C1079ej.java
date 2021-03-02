package p000;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

/* renamed from: ej */
public class C1079ej {

    /* renamed from: ej$a */
    public interface C1081a {
        /* renamed from: a */
        void mo2206a(boolean z);
    }

    /* renamed from: a */
    public static Object m4821a(final C1081a aVar) {
        return new AccessibilityManager.AccessibilityStateChangeListener() {
            public void onAccessibilityStateChanged(boolean z) {
                aVar.mo2206a(z);
            }
        };
    }

    /* renamed from: a */
    public static boolean m4824a(AccessibilityManager accessibilityManager, Object obj) {
        return accessibilityManager.addAccessibilityStateChangeListener((AccessibilityManager.AccessibilityStateChangeListener) obj);
    }

    /* renamed from: b */
    public static boolean m4826b(AccessibilityManager accessibilityManager, Object obj) {
        return accessibilityManager.removeAccessibilityStateChangeListener((AccessibilityManager.AccessibilityStateChangeListener) obj);
    }

    /* renamed from: a */
    public static List<AccessibilityServiceInfo> m4823a(AccessibilityManager accessibilityManager, int i) {
        return accessibilityManager.getEnabledAccessibilityServiceList(i);
    }

    /* renamed from: a */
    public static List<AccessibilityServiceInfo> m4822a(AccessibilityManager accessibilityManager) {
        return accessibilityManager.getInstalledAccessibilityServiceList();
    }

    /* renamed from: b */
    public static boolean m4825b(AccessibilityManager accessibilityManager) {
        return accessibilityManager.isTouchExplorationEnabled();
    }
}
