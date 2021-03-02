package android.support.p000v4.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

/* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompatApi21 */
class AccessibilityNodeInfoCompatApi21 {

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompatApi21$CollectionItemInfo */
    class CollectionItemInfo {
        CollectionItemInfo() {
        }

        public static boolean isSelected(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).isSelected();
        }
    }

    AccessibilityNodeInfoCompatApi21() {
    }

    /* renamed from: a */
    static Object m963a(int i, CharSequence charSequence) {
        return new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
    }

    /* renamed from: a */
    static List<Object> m964a(Object obj) {
        return ((AccessibilityNodeInfo) obj).getActionList();
    }

    /* renamed from: a */
    static void m965a(Object obj, Object obj2) {
        ((AccessibilityNodeInfo) obj).addAction((AccessibilityNodeInfo.AccessibilityAction) obj2);
    }

    /* renamed from: b */
    static int m966b(Object obj) {
        return ((AccessibilityNodeInfo.AccessibilityAction) obj).getId();
    }

    /* renamed from: c */
    static CharSequence m967c(Object obj) {
        return ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel();
    }

    public static CharSequence getError(Object obj) {
        return ((AccessibilityNodeInfo) obj).getError();
    }

    public static int getMaxTextLength(Object obj) {
        return ((AccessibilityNodeInfo) obj).getMaxTextLength();
    }

    public static Object getWindow(Object obj) {
        return ((AccessibilityNodeInfo) obj).getWindow();
    }

    public static Object obtainCollectionInfo(int i, int i2, boolean z, int i3) {
        return AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3);
    }

    public static Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2);
    }

    public static boolean removeAction(Object obj, Object obj2) {
        return ((AccessibilityNodeInfo) obj).removeAction((AccessibilityNodeInfo.AccessibilityAction) obj2);
    }

    public static boolean removeChild(Object obj, View view) {
        return ((AccessibilityNodeInfo) obj).removeChild(view);
    }

    public static boolean removeChild(Object obj, View view, int i) {
        return ((AccessibilityNodeInfo) obj).removeChild(view, i);
    }

    public static void setError(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setError(charSequence);
    }

    public static void setMaxTextLength(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).setMaxTextLength(i);
    }
}
