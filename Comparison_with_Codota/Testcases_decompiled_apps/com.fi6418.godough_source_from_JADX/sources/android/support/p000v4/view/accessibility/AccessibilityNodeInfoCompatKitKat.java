package android.support.p000v4.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat */
class AccessibilityNodeInfoCompatKitKat {

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat$CollectionInfo */
    class CollectionInfo {
        CollectionInfo() {
        }

        /* renamed from: a */
        static int m973a(Object obj) {
            return ((AccessibilityNodeInfo.CollectionInfo) obj).getColumnCount();
        }

        /* renamed from: b */
        static int m974b(Object obj) {
            return ((AccessibilityNodeInfo.CollectionInfo) obj).getRowCount();
        }

        /* renamed from: c */
        static boolean m975c(Object obj) {
            return ((AccessibilityNodeInfo.CollectionInfo) obj).isHierarchical();
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat$CollectionItemInfo */
    class CollectionItemInfo {
        CollectionItemInfo() {
        }

        /* renamed from: a */
        static int m976a(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnIndex();
        }

        /* renamed from: b */
        static int m977b(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnSpan();
        }

        /* renamed from: c */
        static int m978c(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowIndex();
        }

        /* renamed from: d */
        static int m979d(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowSpan();
        }

        /* renamed from: e */
        static boolean m980e(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).isHeading();
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat$RangeInfo */
    class RangeInfo {
        RangeInfo() {
        }

        /* renamed from: a */
        static float m981a(Object obj) {
            return ((AccessibilityNodeInfo.RangeInfo) obj).getCurrent();
        }

        /* renamed from: b */
        static float m982b(Object obj) {
            return ((AccessibilityNodeInfo.RangeInfo) obj).getMax();
        }

        /* renamed from: c */
        static float m983c(Object obj) {
            return ((AccessibilityNodeInfo.RangeInfo) obj).getMin();
        }

        /* renamed from: d */
        static int m984d(Object obj) {
            return ((AccessibilityNodeInfo.RangeInfo) obj).getType();
        }
    }

    AccessibilityNodeInfoCompatKitKat() {
    }

    /* renamed from: a */
    static int m968a(Object obj) {
        return ((AccessibilityNodeInfo) obj).getLiveRegion();
    }

    /* renamed from: a */
    static void m969a(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).setLiveRegion(i);
    }

    /* renamed from: b */
    static Object m970b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getCollectionInfo();
    }

    /* renamed from: c */
    static Object m971c(Object obj) {
        return ((AccessibilityNodeInfo) obj).getCollectionItemInfo();
    }

    public static boolean canOpenPopup(Object obj) {
        return ((AccessibilityNodeInfo) obj).canOpenPopup();
    }

    /* renamed from: d */
    static Object m972d(Object obj) {
        return ((AccessibilityNodeInfo) obj).getRangeInfo();
    }

    public static Bundle getExtras(Object obj) {
        return ((AccessibilityNodeInfo) obj).getExtras();
    }

    public static int getInputType(Object obj) {
        return ((AccessibilityNodeInfo) obj).getInputType();
    }

    public static boolean isContentInvalid(Object obj) {
        return ((AccessibilityNodeInfo) obj).isContentInvalid();
    }

    public static boolean isDismissable(Object obj) {
        return ((AccessibilityNodeInfo) obj).isDismissable();
    }

    public static boolean isMultiLine(Object obj) {
        return ((AccessibilityNodeInfo) obj).isMultiLine();
    }

    public static Object obtainCollectionInfo(int i, int i2, boolean z, int i3) {
        return AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z);
    }

    public static Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z) {
        return AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z);
    }

    public static void setCanOpenPopup(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setCanOpenPopup(z);
    }

    public static void setCollectionInfo(Object obj, Object obj2) {
        ((AccessibilityNodeInfo) obj).setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) obj2);
    }

    public static void setCollectionItemInfo(Object obj, Object obj2) {
        ((AccessibilityNodeInfo) obj).setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) obj2);
    }

    public static void setContentInvalid(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setContentInvalid(z);
    }

    public static void setDismissable(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setDismissable(z);
    }

    public static void setInputType(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).setInputType(i);
    }

    public static void setMultiLine(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setMultiLine(z);
    }

    public static void setRangeInfo(Object obj, Object obj2) {
        ((AccessibilityNodeInfo) obj).setRangeInfo((AccessibilityNodeInfo.RangeInfo) obj2);
    }
}
