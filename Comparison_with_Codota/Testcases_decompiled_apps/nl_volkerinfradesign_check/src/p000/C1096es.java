package p000;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* renamed from: es */
public class C1096es {

    /* renamed from: es$a */
    public interface C1098a {
        /* renamed from: a */
        Object mo2465a(int i);

        /* renamed from: a */
        List<Object> mo2466a(String str, int i);

        /* renamed from: a */
        boolean mo2467a(int i, int i2, Bundle bundle);

        /* renamed from: b */
        Object mo2468b(int i);
    }

    /* renamed from: a */
    public static Object m4962a(final C1098a aVar) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) aVar.mo2465a(i);
            }

            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return aVar.mo2466a(str, i);
            }

            public boolean performAction(int i, int i2, Bundle bundle) {
                return aVar.mo2467a(i, i2, bundle);
            }

            public AccessibilityNodeInfo findFocus(int i) {
                return (AccessibilityNodeInfo) aVar.mo2468b(i);
            }
        };
    }
}
