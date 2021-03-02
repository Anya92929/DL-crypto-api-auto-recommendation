package p000;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* renamed from: er */
public class C1093er {

    /* renamed from: er$a */
    public interface C1095a {
        /* renamed from: a */
        Object mo2462a(int i);

        /* renamed from: a */
        List<Object> mo2463a(String str, int i);

        /* renamed from: a */
        boolean mo2464a(int i, int i2, Bundle bundle);
    }

    /* renamed from: a */
    public static Object m4958a(final C1095a aVar) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) aVar.mo2462a(i);
            }

            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return aVar.mo2463a(str, i);
            }

            public boolean performAction(int i, int i2, Bundle bundle) {
                return aVar.mo2464a(i, i2, bundle);
            }
        };
    }
}
