package android.support.p009v4.view.p020a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* renamed from: android.support.v4.view.a.ae */
final class C0158ae extends AccessibilityNodeProvider {

    /* renamed from: a */
    final /* synthetic */ C0159af f305a;

    C0158ae(C0159af afVar) {
        this.f305a = afVar;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f305a.mo1263a(i);
    }

    public List findAccessibilityNodeInfosByText(String str, int i) {
        return this.f305a.mo1264a(str, i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f305a.mo1265a(i, i2, bundle);
    }
}
