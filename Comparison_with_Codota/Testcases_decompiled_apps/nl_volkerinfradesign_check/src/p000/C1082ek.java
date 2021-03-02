package p000;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

/* renamed from: ek */
public class C1082ek {
    /* renamed from: a */
    public static List<Object> m4831a(Object obj) {
        return ((AccessibilityNodeInfo) obj).getActionList();
    }

    /* renamed from: a */
    public static void m4834a(Object obj, Object obj2) {
        ((AccessibilityNodeInfo) obj).addAction((AccessibilityNodeInfo.AccessibilityAction) obj2);
    }

    /* renamed from: b */
    public static boolean m4838b(Object obj, Object obj2) {
        return ((AccessibilityNodeInfo) obj).removeAction((AccessibilityNodeInfo.AccessibilityAction) obj2);
    }

    /* renamed from: a */
    public static Object m4829a(int i, int i2, boolean z, int i3) {
        return AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3);
    }

    /* renamed from: a */
    public static Object m4828a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2);
    }

    /* renamed from: b */
    public static CharSequence m4837b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getError();
    }

    /* renamed from: a */
    public static void m4833a(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setError(charSequence);
    }

    /* renamed from: a */
    public static void m4832a(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).setMaxTextLength(i);
    }

    /* renamed from: c */
    public static int m4839c(Object obj) {
        return ((AccessibilityNodeInfo) obj).getMaxTextLength();
    }

    /* renamed from: d */
    public static Object m4840d(Object obj) {
        return ((AccessibilityNodeInfo) obj).getWindow();
    }

    /* renamed from: a */
    public static boolean m4835a(Object obj, View view) {
        return ((AccessibilityNodeInfo) obj).removeChild(view);
    }

    /* renamed from: a */
    public static boolean m4836a(Object obj, View view, int i) {
        return ((AccessibilityNodeInfo) obj).removeChild(view, i);
    }

    /* renamed from: ek$a */
    public static class C1083a {
        /* renamed from: a */
        public static boolean m4843a(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).isSelected();
        }
    }

    /* renamed from: a */
    public static Object m4830a(int i, CharSequence charSequence) {
        return new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
    }

    /* renamed from: e */
    public static int m4841e(Object obj) {
        return ((AccessibilityNodeInfo.AccessibilityAction) obj).getId();
    }

    /* renamed from: f */
    public static CharSequence m4842f(Object obj) {
        return ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel();
    }
}
