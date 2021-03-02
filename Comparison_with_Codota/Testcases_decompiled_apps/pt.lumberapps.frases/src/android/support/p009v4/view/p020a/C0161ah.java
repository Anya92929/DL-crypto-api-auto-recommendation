package android.support.p009v4.view.p020a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* renamed from: android.support.v4.view.a.ah */
final class C0161ah extends AccessibilityNodeProvider {

    /* renamed from: a */
    final /* synthetic */ C0162ai f306a;

    C0161ah(C0162ai aiVar) {
        this.f306a = aiVar;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.f306a.mo1256a(i);
    }

    public List findAccessibilityNodeInfosByText(String str, int i) {
        return this.f306a.mo1257a(str, i);
    }

    public AccessibilityNodeInfo findFocus(int i) {
        return (AccessibilityNodeInfo) this.f306a.mo1259b(i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f306a.mo1258a(i, i2, bundle);
    }
}
