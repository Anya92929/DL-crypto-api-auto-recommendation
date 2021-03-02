package android.support.p009v4.view.p020a;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* renamed from: android.support.v4.view.a.ap */
class C0169ap {
    /* renamed from: a */
    public static void m510a(Object obj, int i) {
        ((AccessibilityRecord) obj).setFromIndex(i);
    }

    /* renamed from: a */
    public static void m511a(Object obj, View view) {
        ((AccessibilityRecord) obj).setSource(view);
    }

    /* renamed from: a */
    public static void m512a(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setScrollable(z);
    }

    /* renamed from: b */
    public static void m513b(Object obj, int i) {
        ((AccessibilityRecord) obj).setItemCount(i);
    }

    /* renamed from: c */
    public static void m514c(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollX(i);
    }

    /* renamed from: d */
    public static void m515d(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollY(i);
    }

    /* renamed from: e */
    public static void m516e(Object obj, int i) {
        ((AccessibilityRecord) obj).setToIndex(i);
    }
}
