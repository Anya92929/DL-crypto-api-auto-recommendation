package p000;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: eq */
public class C1089eq {
    /* renamed from: a */
    public static int m4925a(Object obj) {
        return ((AccessibilityNodeInfo) obj).getLiveRegion();
    }

    /* renamed from: a */
    public static void m4928a(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).setLiveRegion(i);
    }

    /* renamed from: b */
    public static Object m4931b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getCollectionInfo();
    }

    /* renamed from: c */
    public static Object m4935c(Object obj) {
        return ((AccessibilityNodeInfo) obj).getCollectionItemInfo();
    }

    /* renamed from: a */
    public static void m4929a(Object obj, Object obj2) {
        ((AccessibilityNodeInfo) obj).setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) obj2);
    }

    /* renamed from: b */
    public static void m4933b(Object obj, Object obj2) {
        ((AccessibilityNodeInfo) obj).setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) obj2);
    }

    /* renamed from: d */
    public static Object m4938d(Object obj) {
        return ((AccessibilityNodeInfo) obj).getRangeInfo();
    }

    /* renamed from: c */
    public static void m4936c(Object obj, Object obj2) {
        ((AccessibilityNodeInfo) obj).setRangeInfo((AccessibilityNodeInfo.RangeInfo) obj2);
    }

    /* renamed from: a */
    public static Object m4927a(int i, int i2, boolean z, int i3) {
        return AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z);
    }

    /* renamed from: a */
    public static Object m4926a(int i, int i2, int i3, int i4, boolean z) {
        return AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z);
    }

    /* renamed from: a */
    public static void m4930a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setContentInvalid(z);
    }

    /* renamed from: e */
    public static boolean m4940e(Object obj) {
        return ((AccessibilityNodeInfo) obj).isContentInvalid();
    }

    /* renamed from: f */
    public static boolean m4941f(Object obj) {
        return ((AccessibilityNodeInfo) obj).canOpenPopup();
    }

    /* renamed from: b */
    public static void m4934b(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setCanOpenPopup(z);
    }

    /* renamed from: g */
    public static Bundle m4942g(Object obj) {
        return ((AccessibilityNodeInfo) obj).getExtras();
    }

    /* renamed from: h */
    public static int m4943h(Object obj) {
        return ((AccessibilityNodeInfo) obj).getInputType();
    }

    /* renamed from: b */
    public static void m4932b(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).setInputType(i);
    }

    /* renamed from: i */
    public static boolean m4944i(Object obj) {
        return ((AccessibilityNodeInfo) obj).isDismissable();
    }

    /* renamed from: c */
    public static void m4937c(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setDismissable(z);
    }

    /* renamed from: j */
    public static boolean m4945j(Object obj) {
        return ((AccessibilityNodeInfo) obj).isMultiLine();
    }

    /* renamed from: d */
    public static void m4939d(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setMultiLine(z);
    }

    /* renamed from: eq$a */
    public static class C1090a {
        /* renamed from: a */
        public static int m4946a(Object obj) {
            return ((AccessibilityNodeInfo.CollectionInfo) obj).getColumnCount();
        }

        /* renamed from: b */
        public static int m4947b(Object obj) {
            return ((AccessibilityNodeInfo.CollectionInfo) obj).getRowCount();
        }

        /* renamed from: c */
        public static boolean m4948c(Object obj) {
            return ((AccessibilityNodeInfo.CollectionInfo) obj).isHierarchical();
        }
    }

    /* renamed from: eq$b */
    public static class C1091b {
        /* renamed from: a */
        public static int m4949a(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnIndex();
        }

        /* renamed from: b */
        public static int m4950b(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnSpan();
        }

        /* renamed from: c */
        public static int m4951c(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowIndex();
        }

        /* renamed from: d */
        public static int m4952d(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowSpan();
        }

        /* renamed from: e */
        public static boolean m4953e(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).isHeading();
        }
    }

    /* renamed from: eq$c */
    public static class C1092c {
        /* renamed from: a */
        public static float m4954a(Object obj) {
            return ((AccessibilityNodeInfo.RangeInfo) obj).getCurrent();
        }

        /* renamed from: b */
        public static float m4955b(Object obj) {
            return ((AccessibilityNodeInfo.RangeInfo) obj).getMax();
        }

        /* renamed from: c */
        public static float m4956c(Object obj) {
            return ((AccessibilityNodeInfo.RangeInfo) obj).getMin();
        }

        /* renamed from: d */
        public static int m4957d(Object obj) {
            return ((AccessibilityNodeInfo.RangeInfo) obj).getType();
        }
    }
}
