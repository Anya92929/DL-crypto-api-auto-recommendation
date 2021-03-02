package p000;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

/* renamed from: em */
public class C1085em {
    /* renamed from: a */
    public static Object m4850a() {
        return AccessibilityNodeInfo.obtain();
    }

    /* renamed from: a */
    public static Object m4851a(View view) {
        return AccessibilityNodeInfo.obtain(view);
    }

    /* renamed from: a */
    public static Object m4852a(Object obj) {
        return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo) obj);
    }

    /* renamed from: a */
    public static void m4854a(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).addAction(i);
    }

    /* renamed from: a */
    public static void m4856a(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).addChild(view);
    }

    /* renamed from: a */
    public static List<Object> m4853a(Object obj, String str) {
        return ((AccessibilityNodeInfo) obj).findAccessibilityNodeInfosByText(str);
    }

    /* renamed from: b */
    public static int m4859b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getActions();
    }

    /* renamed from: a */
    public static void m4855a(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInParent(rect);
    }

    /* renamed from: b */
    public static void m4861b(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInScreen(rect);
    }

    /* renamed from: b */
    public static Object m4860b(Object obj, int i) {
        return ((AccessibilityNodeInfo) obj).getChild(i);
    }

    /* renamed from: c */
    public static int m4865c(Object obj) {
        return ((AccessibilityNodeInfo) obj).getChildCount();
    }

    /* renamed from: d */
    public static CharSequence m4871d(Object obj) {
        return ((AccessibilityNodeInfo) obj).getClassName();
    }

    /* renamed from: e */
    public static CharSequence m4875e(Object obj) {
        return ((AccessibilityNodeInfo) obj).getContentDescription();
    }

    /* renamed from: f */
    public static CharSequence m4877f(Object obj) {
        return ((AccessibilityNodeInfo) obj).getPackageName();
    }

    /* renamed from: g */
    public static Object m4879g(Object obj) {
        return ((AccessibilityNodeInfo) obj).getParent();
    }

    /* renamed from: h */
    public static CharSequence m4881h(Object obj) {
        return ((AccessibilityNodeInfo) obj).getText();
    }

    /* renamed from: i */
    public static int m4883i(Object obj) {
        return ((AccessibilityNodeInfo) obj).getWindowId();
    }

    /* renamed from: j */
    public static boolean m4886j(Object obj) {
        return ((AccessibilityNodeInfo) obj).isCheckable();
    }

    /* renamed from: k */
    public static boolean m4887k(Object obj) {
        return ((AccessibilityNodeInfo) obj).isChecked();
    }

    /* renamed from: l */
    public static boolean m4888l(Object obj) {
        return ((AccessibilityNodeInfo) obj).isClickable();
    }

    /* renamed from: m */
    public static boolean m4889m(Object obj) {
        return ((AccessibilityNodeInfo) obj).isEnabled();
    }

    /* renamed from: n */
    public static boolean m4890n(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocusable();
    }

    /* renamed from: o */
    public static boolean m4891o(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocused();
    }

    /* renamed from: p */
    public static boolean m4892p(Object obj) {
        return ((AccessibilityNodeInfo) obj).isLongClickable();
    }

    /* renamed from: q */
    public static boolean m4893q(Object obj) {
        return ((AccessibilityNodeInfo) obj).isPassword();
    }

    /* renamed from: r */
    public static boolean m4894r(Object obj) {
        return ((AccessibilityNodeInfo) obj).isScrollable();
    }

    /* renamed from: s */
    public static boolean m4895s(Object obj) {
        return ((AccessibilityNodeInfo) obj).isSelected();
    }

    /* renamed from: c */
    public static boolean m4870c(Object obj, int i) {
        return ((AccessibilityNodeInfo) obj).performAction(i);
    }

    /* renamed from: c */
    public static void m4866c(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).setBoundsInParent(rect);
    }

    /* renamed from: d */
    public static void m4872d(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).setBoundsInScreen(rect);
    }

    /* renamed from: a */
    public static void m4858a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setCheckable(z);
    }

    /* renamed from: b */
    public static void m4864b(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setChecked(z);
    }

    /* renamed from: a */
    public static void m4857a(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setClassName(charSequence);
    }

    /* renamed from: c */
    public static void m4869c(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setClickable(z);
    }

    /* renamed from: b */
    public static void m4863b(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setContentDescription(charSequence);
    }

    /* renamed from: d */
    public static void m4874d(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setEnabled(z);
    }

    /* renamed from: e */
    public static void m4876e(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setFocusable(z);
    }

    /* renamed from: f */
    public static void m4878f(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setFocused(z);
    }

    /* renamed from: g */
    public static void m4880g(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setLongClickable(z);
    }

    /* renamed from: c */
    public static void m4868c(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setPackageName(charSequence);
    }

    /* renamed from: b */
    public static void m4862b(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setParent(view);
    }

    /* renamed from: h */
    public static void m4882h(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setPassword(z);
    }

    /* renamed from: i */
    public static void m4884i(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setScrollable(z);
    }

    /* renamed from: j */
    public static void m4885j(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setSelected(z);
    }

    /* renamed from: c */
    public static void m4867c(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setSource(view);
    }

    /* renamed from: d */
    public static void m4873d(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setText(charSequence);
    }

    /* renamed from: t */
    public static void m4896t(Object obj) {
        ((AccessibilityNodeInfo) obj).recycle();
    }
}
