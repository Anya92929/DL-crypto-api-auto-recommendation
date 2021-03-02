package p000;

import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import java.util.List;

/* renamed from: et */
public class C1099et {
    /* renamed from: a */
    public static Object m4967a() {
        return AccessibilityRecord.obtain();
    }

    /* renamed from: a */
    public static Object m4968a(Object obj) {
        return AccessibilityRecord.obtain((AccessibilityRecord) obj);
    }

    /* renamed from: b */
    public static int m4974b(Object obj) {
        return ((AccessibilityRecord) obj).getAddedCount();
    }

    /* renamed from: c */
    public static CharSequence m4978c(Object obj) {
        return ((AccessibilityRecord) obj).getBeforeText();
    }

    /* renamed from: d */
    public static CharSequence m4982d(Object obj) {
        return ((AccessibilityRecord) obj).getClassName();
    }

    /* renamed from: e */
    public static CharSequence m4985e(Object obj) {
        return ((AccessibilityRecord) obj).getContentDescription();
    }

    /* renamed from: f */
    public static int m4988f(Object obj) {
        return ((AccessibilityRecord) obj).getCurrentItemIndex();
    }

    /* renamed from: g */
    public static int m4990g(Object obj) {
        return ((AccessibilityRecord) obj).getFromIndex();
    }

    /* renamed from: h */
    public static int m4992h(Object obj) {
        return ((AccessibilityRecord) obj).getItemCount();
    }

    /* renamed from: i */
    public static Parcelable m4994i(Object obj) {
        return ((AccessibilityRecord) obj).getParcelableData();
    }

    /* renamed from: j */
    public static int m4995j(Object obj) {
        return ((AccessibilityRecord) obj).getRemovedCount();
    }

    /* renamed from: k */
    public static int m4996k(Object obj) {
        return ((AccessibilityRecord) obj).getScrollX();
    }

    /* renamed from: l */
    public static int m4997l(Object obj) {
        return ((AccessibilityRecord) obj).getScrollY();
    }

    /* renamed from: m */
    public static Object m4998m(Object obj) {
        return ((AccessibilityRecord) obj).getSource();
    }

    /* renamed from: n */
    public static List<CharSequence> m4999n(Object obj) {
        return ((AccessibilityRecord) obj).getText();
    }

    /* renamed from: o */
    public static int m5000o(Object obj) {
        return ((AccessibilityRecord) obj).getToIndex();
    }

    /* renamed from: p */
    public static int m5001p(Object obj) {
        return ((AccessibilityRecord) obj).getWindowId();
    }

    /* renamed from: q */
    public static boolean m5002q(Object obj) {
        return ((AccessibilityRecord) obj).isChecked();
    }

    /* renamed from: r */
    public static boolean m5003r(Object obj) {
        return ((AccessibilityRecord) obj).isEnabled();
    }

    /* renamed from: s */
    public static boolean m5004s(Object obj) {
        return ((AccessibilityRecord) obj).isFullScreen();
    }

    /* renamed from: t */
    public static boolean m5005t(Object obj) {
        return ((AccessibilityRecord) obj).isPassword();
    }

    /* renamed from: u */
    public static boolean m5006u(Object obj) {
        return ((AccessibilityRecord) obj).isScrollable();
    }

    /* renamed from: v */
    public static void m5007v(Object obj) {
        ((AccessibilityRecord) obj).recycle();
    }

    /* renamed from: a */
    public static void m4969a(Object obj, int i) {
        ((AccessibilityRecord) obj).setAddedCount(i);
    }

    /* renamed from: a */
    public static void m4972a(Object obj, CharSequence charSequence) {
        ((AccessibilityRecord) obj).setBeforeText(charSequence);
    }

    /* renamed from: a */
    public static void m4973a(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setChecked(z);
    }

    /* renamed from: b */
    public static void m4976b(Object obj, CharSequence charSequence) {
        ((AccessibilityRecord) obj).setClassName(charSequence);
    }

    /* renamed from: c */
    public static void m4980c(Object obj, CharSequence charSequence) {
        ((AccessibilityRecord) obj).setContentDescription(charSequence);
    }

    /* renamed from: b */
    public static void m4975b(Object obj, int i) {
        ((AccessibilityRecord) obj).setCurrentItemIndex(i);
    }

    /* renamed from: b */
    public static void m4977b(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setEnabled(z);
    }

    /* renamed from: c */
    public static void m4979c(Object obj, int i) {
        ((AccessibilityRecord) obj).setFromIndex(i);
    }

    /* renamed from: c */
    public static void m4981c(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setFullScreen(z);
    }

    /* renamed from: d */
    public static void m4983d(Object obj, int i) {
        ((AccessibilityRecord) obj).setItemCount(i);
    }

    /* renamed from: a */
    public static void m4970a(Object obj, Parcelable parcelable) {
        ((AccessibilityRecord) obj).setParcelableData(parcelable);
    }

    /* renamed from: d */
    public static void m4984d(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setPassword(z);
    }

    /* renamed from: e */
    public static void m4986e(Object obj, int i) {
        ((AccessibilityRecord) obj).setRemovedCount(i);
    }

    /* renamed from: f */
    public static void m4989f(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollX(i);
    }

    /* renamed from: g */
    public static void m4991g(Object obj, int i) {
        ((AccessibilityRecord) obj).setScrollY(i);
    }

    /* renamed from: e */
    public static void m4987e(Object obj, boolean z) {
        ((AccessibilityRecord) obj).setScrollable(z);
    }

    /* renamed from: a */
    public static void m4971a(Object obj, View view) {
        ((AccessibilityRecord) obj).setSource(view);
    }

    /* renamed from: h */
    public static void m4993h(Object obj, int i) {
        ((AccessibilityRecord) obj).setToIndex(i);
    }
}
