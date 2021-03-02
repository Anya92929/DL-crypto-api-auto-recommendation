package android.support.p001v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000.C1082ek;
import p000.C1089eq;

/* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat */
public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final C0368d f1083a;

    /* renamed from: b */
    private final Object f1084b;

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$d */
    interface C0368d {
        /* renamed from: A */
        boolean mo2354A(Object obj);

        /* renamed from: B */
        boolean mo2355B(Object obj);

        /* renamed from: C */
        void mo2356C(Object obj);

        /* renamed from: D */
        int mo2401D(Object obj);

        /* renamed from: E */
        boolean mo2402E(Object obj);

        /* renamed from: F */
        boolean mo2403F(Object obj);

        /* renamed from: G */
        String mo2404G(Object obj);

        /* renamed from: H */
        int mo2405H(Object obj);

        /* renamed from: I */
        Object mo2406I(Object obj);

        /* renamed from: J */
        Object mo2407J(Object obj);

        /* renamed from: K */
        Object mo2408K(Object obj);

        /* renamed from: L */
        int mo2409L(Object obj);

        /* renamed from: M */
        int mo2410M(Object obj);

        /* renamed from: N */
        boolean mo2411N(Object obj);

        /* renamed from: O */
        int mo2412O(Object obj);

        /* renamed from: P */
        int mo2413P(Object obj);

        /* renamed from: Q */
        int mo2414Q(Object obj);

        /* renamed from: R */
        int mo2415R(Object obj);

        /* renamed from: S */
        boolean mo2416S(Object obj);

        /* renamed from: T */
        boolean mo2417T(Object obj);

        /* renamed from: U */
        Object mo2418U(Object obj);

        /* renamed from: V */
        Object mo2419V(Object obj);

        /* renamed from: W */
        boolean mo2420W(Object obj);

        /* renamed from: X */
        Bundle mo2421X(Object obj);

        /* renamed from: Y */
        int mo2422Y(Object obj);

        /* renamed from: Z */
        int mo2423Z(Object obj);

        /* renamed from: a */
        Object mo2357a();

        /* renamed from: a */
        Object mo2332a(int i, int i2, int i3, int i4, boolean z, boolean z2);

        /* renamed from: a */
        Object mo2333a(int i, int i2, boolean z, int i3);

        /* renamed from: a */
        Object mo2334a(int i, CharSequence charSequence);

        /* renamed from: a */
        Object mo2358a(View view);

        /* renamed from: a */
        Object mo2424a(View view, int i);

        /* renamed from: a */
        List<Object> mo2335a(Object obj);

        /* renamed from: a */
        List<Object> mo2359a(Object obj, String str);

        /* renamed from: a */
        void mo2336a(Object obj, int i);

        /* renamed from: a */
        void mo2425a(Object obj, int i, int i2);

        /* renamed from: a */
        void mo2360a(Object obj, Rect rect);

        /* renamed from: a */
        void mo2337a(Object obj, CharSequence charSequence);

        /* renamed from: a */
        void mo2338a(Object obj, Object obj2);

        /* renamed from: a */
        void mo2361a(Object obj, boolean z);

        /* renamed from: a */
        boolean mo2426a(Object obj, int i, Bundle bundle);

        /* renamed from: a */
        boolean mo2339a(Object obj, View view);

        /* renamed from: a */
        boolean mo2340a(Object obj, View view, int i);

        /* renamed from: aa */
        int mo2427aa(Object obj);

        /* renamed from: ab */
        boolean mo2428ab(Object obj);

        /* renamed from: ac */
        boolean mo2429ac(Object obj);

        /* renamed from: ad */
        boolean mo2430ad(Object obj);

        /* renamed from: ae */
        boolean mo2431ae(Object obj);

        /* renamed from: b */
        int mo2341b(Object obj);

        /* renamed from: b */
        void mo2362b(Object obj, int i);

        /* renamed from: b */
        void mo2363b(Object obj, Rect rect);

        /* renamed from: b */
        void mo2348b(Object obj, View view);

        /* renamed from: b */
        void mo2349b(Object obj, View view, int i);

        /* renamed from: b */
        void mo2364b(Object obj, CharSequence charSequence);

        /* renamed from: b */
        void mo2432b(Object obj, String str);

        /* renamed from: b */
        void mo2365b(Object obj, boolean z);

        /* renamed from: b */
        boolean mo2342b(Object obj, Object obj2);

        /* renamed from: c */
        CharSequence mo2343c(Object obj);

        /* renamed from: c */
        Object mo2366c(Object obj, int i);

        /* renamed from: c */
        List<Object> mo2433c(Object obj, String str);

        /* renamed from: c */
        void mo2367c(Object obj, Rect rect);

        /* renamed from: c */
        void mo2350c(Object obj, View view);

        /* renamed from: c */
        void mo2351c(Object obj, View view, int i);

        /* renamed from: c */
        void mo2368c(Object obj, CharSequence charSequence);

        /* renamed from: c */
        void mo2434c(Object obj, Object obj2);

        /* renamed from: c */
        void mo2369c(Object obj, boolean z);

        /* renamed from: d */
        void mo2370d(Object obj, Rect rect);

        /* renamed from: d */
        void mo2371d(Object obj, View view);

        /* renamed from: d */
        void mo2435d(Object obj, View view, int i);

        /* renamed from: d */
        void mo2372d(Object obj, CharSequence charSequence);

        /* renamed from: d */
        void mo2436d(Object obj, Object obj2);

        /* renamed from: d */
        void mo2373d(Object obj, boolean z);

        /* renamed from: d */
        boolean mo2344d(Object obj);

        /* renamed from: d */
        boolean mo2374d(Object obj, int i);

        /* renamed from: e */
        CharSequence mo2345e(Object obj);

        /* renamed from: e */
        Object mo2437e(Object obj, int i);

        /* renamed from: e */
        void mo2375e(Object obj, View view);

        /* renamed from: e */
        void mo2438e(Object obj, View view, int i);

        /* renamed from: e */
        void mo2376e(Object obj, CharSequence charSequence);

        /* renamed from: e */
        void mo2439e(Object obj, Object obj2);

        /* renamed from: e */
        void mo2377e(Object obj, boolean z);

        /* renamed from: f */
        int mo2346f(Object obj);

        /* renamed from: f */
        Object mo2440f(Object obj, int i);

        /* renamed from: f */
        void mo2378f(Object obj, View view);

        /* renamed from: f */
        void mo2441f(Object obj, View view, int i);

        /* renamed from: f */
        void mo2379f(Object obj, boolean z);

        /* renamed from: g */
        Object mo2347g(Object obj);

        /* renamed from: g */
        void mo2442g(Object obj, int i);

        /* renamed from: g */
        void mo2443g(Object obj, View view);

        /* renamed from: g */
        void mo2444g(Object obj, View view, int i);

        /* renamed from: g */
        void mo2380g(Object obj, boolean z);

        /* renamed from: h */
        Object mo2352h(Object obj);

        /* renamed from: h */
        void mo2445h(Object obj, int i);

        /* renamed from: h */
        void mo2446h(Object obj, View view);

        /* renamed from: h */
        void mo2447h(Object obj, View view, int i);

        /* renamed from: h */
        void mo2381h(Object obj, boolean z);

        /* renamed from: i */
        Object mo2353i(Object obj);

        /* renamed from: i */
        void mo2448i(Object obj, int i);

        /* renamed from: i */
        void mo2382i(Object obj, boolean z);

        /* renamed from: j */
        Object mo2383j(Object obj);

        /* renamed from: j */
        void mo2384j(Object obj, boolean z);

        /* renamed from: k */
        int mo2385k(Object obj);

        /* renamed from: k */
        void mo2449k(Object obj, boolean z);

        /* renamed from: l */
        int mo2386l(Object obj);

        /* renamed from: l */
        void mo2450l(Object obj, boolean z);

        /* renamed from: m */
        CharSequence mo2387m(Object obj);

        /* renamed from: m */
        void mo2451m(Object obj, boolean z);

        /* renamed from: n */
        CharSequence mo2388n(Object obj);

        /* renamed from: n */
        void mo2452n(Object obj, boolean z);

        /* renamed from: o */
        CharSequence mo2389o(Object obj);

        /* renamed from: o */
        void mo2453o(Object obj, boolean z);

        /* renamed from: p */
        Object mo2390p(Object obj);

        /* renamed from: p */
        void mo2454p(Object obj, boolean z);

        /* renamed from: q */
        CharSequence mo2391q(Object obj);

        /* renamed from: q */
        void mo2455q(Object obj, boolean z);

        /* renamed from: r */
        int mo2392r(Object obj);

        /* renamed from: s */
        boolean mo2393s(Object obj);

        /* renamed from: t */
        boolean mo2394t(Object obj);

        /* renamed from: u */
        boolean mo2395u(Object obj);

        /* renamed from: v */
        boolean mo2396v(Object obj);

        /* renamed from: w */
        boolean mo2397w(Object obj);

        /* renamed from: x */
        boolean mo2398x(Object obj);

        /* renamed from: y */
        boolean mo2399y(Object obj);

        /* renamed from: z */
        boolean mo2400z(Object obj);
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat */
    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CLICK = new AccessibilityActionCompat(16, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_COLLAPSE = new AccessibilityActionCompat(524288, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_COPY = new AccessibilityActionCompat(16384, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CUT = new AccessibilityActionCompat(65536, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_DISMISS = new AccessibilityActionCompat(1048576, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_EXPAND = new AccessibilityActionCompat(262144, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_FOCUS = new AccessibilityActionCompat(1, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_LONG_CLICK = new AccessibilityActionCompat(32, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_PASTE = new AccessibilityActionCompat(32768, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_SELECT = new AccessibilityActionCompat(4, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, (CharSequence) null);
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Object f1085a;

        public AccessibilityActionCompat(int i, CharSequence charSequence) {
            this(AccessibilityNodeInfoCompat.f1083a.mo2334a(i, charSequence));
        }

        private AccessibilityActionCompat(Object obj) {
            this.f1085a = obj;
        }

        public int getId() {
            return AccessibilityNodeInfoCompat.f1083a.mo2341b(this.f1085a);
        }

        public CharSequence getLabel() {
            return AccessibilityNodeInfoCompat.f1083a.mo2343c(this.f1085a);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat */
    public static class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;

        /* renamed from: a */
        final Object f1086a;

        public static CollectionInfoCompat obtain(int i, int i2, boolean z, int i3) {
            return new CollectionInfoCompat(AccessibilityNodeInfoCompat.f1083a.mo2333a(i, i2, z, i3));
        }

        private CollectionInfoCompat(Object obj) {
            this.f1086a = obj;
        }

        public int getColumnCount() {
            return AccessibilityNodeInfoCompat.f1083a.mo2409L(this.f1086a);
        }

        public int getRowCount() {
            return AccessibilityNodeInfoCompat.f1083a.mo2410M(this.f1086a);
        }

        public boolean isHierarchical() {
            return AccessibilityNodeInfoCompat.f1083a.mo2411N(this.f1086a);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat */
    public static class CollectionItemInfoCompat {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Object f1087a;

        public static CollectionItemInfoCompat obtain(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfoCompat.f1083a.mo2332a(i, i2, i3, i4, z, z2));
        }

        private CollectionItemInfoCompat(Object obj) {
            this.f1087a = obj;
        }

        public int getColumnIndex() {
            return AccessibilityNodeInfoCompat.f1083a.mo2412O(this.f1087a);
        }

        public int getColumnSpan() {
            return AccessibilityNodeInfoCompat.f1083a.mo2413P(this.f1087a);
        }

        public int getRowIndex() {
            return AccessibilityNodeInfoCompat.f1083a.mo2414Q(this.f1087a);
        }

        public int getRowSpan() {
            return AccessibilityNodeInfoCompat.f1083a.mo2415R(this.f1087a);
        }

        public boolean isHeading() {
            return AccessibilityNodeInfoCompat.f1083a.mo2416S(this.f1087a);
        }

        public boolean isSelected() {
            return AccessibilityNodeInfoCompat.f1083a.mo2344d(this.f1087a);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$RangeInfoCompat */
    public static class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Object f1088a;

        private RangeInfoCompat(Object obj) {
            this.f1088a = obj;
        }

        public float getCurrent() {
            return C1089eq.C1092c.m4954a(this.f1088a);
        }

        public float getMax() {
            return C1089eq.C1092c.m4955b(this.f1088a);
        }

        public float getMin() {
            return C1089eq.C1092c.m4956c(this.f1088a);
        }

        public int getType() {
            return C1089eq.C1092c.m4957d(this.f1088a);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$i */
    static class C0373i implements C0368d {
        C0373i() {
        }

        /* renamed from: a */
        public Object mo2334a(int i, CharSequence charSequence) {
            return null;
        }

        /* renamed from: a */
        public Object mo2357a() {
            return null;
        }

        /* renamed from: a */
        public Object mo2358a(View view) {
            return null;
        }

        /* renamed from: a */
        public Object mo2424a(View view, int i) {
            return null;
        }

        /* renamed from: j */
        public Object mo2383j(Object obj) {
            return null;
        }

        /* renamed from: b */
        public void mo2362b(Object obj, int i) {
        }

        /* renamed from: a */
        public void mo2338a(Object obj, Object obj2) {
        }

        /* renamed from: b */
        public boolean mo2342b(Object obj, Object obj2) {
            return false;
        }

        /* renamed from: b */
        public int mo2341b(Object obj) {
            return 0;
        }

        /* renamed from: c */
        public CharSequence mo2343c(Object obj) {
            return null;
        }

        /* renamed from: d */
        public void mo2371d(Object obj, View view) {
        }

        /* renamed from: e */
        public void mo2438e(Object obj, View view, int i) {
        }

        /* renamed from: a */
        public boolean mo2339a(Object obj, View view) {
            return false;
        }

        /* renamed from: a */
        public boolean mo2340a(Object obj, View view, int i) {
            return false;
        }

        /* renamed from: a */
        public List<Object> mo2359a(Object obj, String str) {
            return Collections.emptyList();
        }

        /* renamed from: k */
        public int mo2385k(Object obj) {
            return 0;
        }

        /* renamed from: a */
        public void mo2360a(Object obj, Rect rect) {
        }

        /* renamed from: b */
        public void mo2363b(Object obj, Rect rect) {
        }

        /* renamed from: c */
        public Object mo2366c(Object obj, int i) {
            return null;
        }

        /* renamed from: l */
        public int mo2386l(Object obj) {
            return 0;
        }

        /* renamed from: m */
        public CharSequence mo2387m(Object obj) {
            return null;
        }

        /* renamed from: n */
        public CharSequence mo2388n(Object obj) {
            return null;
        }

        /* renamed from: o */
        public CharSequence mo2389o(Object obj) {
            return null;
        }

        /* renamed from: p */
        public Object mo2390p(Object obj) {
            return null;
        }

        /* renamed from: q */
        public CharSequence mo2391q(Object obj) {
            return null;
        }

        /* renamed from: r */
        public int mo2392r(Object obj) {
            return 0;
        }

        /* renamed from: s */
        public boolean mo2393s(Object obj) {
            return false;
        }

        /* renamed from: t */
        public boolean mo2394t(Object obj) {
            return false;
        }

        /* renamed from: u */
        public boolean mo2395u(Object obj) {
            return false;
        }

        /* renamed from: v */
        public boolean mo2396v(Object obj) {
            return false;
        }

        /* renamed from: w */
        public boolean mo2397w(Object obj) {
            return false;
        }

        /* renamed from: x */
        public boolean mo2398x(Object obj) {
            return false;
        }

        /* renamed from: E */
        public boolean mo2402E(Object obj) {
            return false;
        }

        /* renamed from: F */
        public boolean mo2403F(Object obj) {
            return false;
        }

        /* renamed from: y */
        public boolean mo2399y(Object obj) {
            return false;
        }

        /* renamed from: z */
        public boolean mo2400z(Object obj) {
            return false;
        }

        /* renamed from: A */
        public boolean mo2354A(Object obj) {
            return false;
        }

        /* renamed from: B */
        public boolean mo2355B(Object obj) {
            return false;
        }

        /* renamed from: d */
        public boolean mo2374d(Object obj, int i) {
            return false;
        }

        /* renamed from: a */
        public boolean mo2426a(Object obj, int i, Bundle bundle) {
            return false;
        }

        /* renamed from: g */
        public void mo2442g(Object obj, int i) {
        }

        /* renamed from: D */
        public int mo2401D(Object obj) {
            return 0;
        }

        /* renamed from: c */
        public void mo2367c(Object obj, Rect rect) {
        }

        /* renamed from: d */
        public void mo2370d(Object obj, Rect rect) {
        }

        /* renamed from: a */
        public void mo2361a(Object obj, boolean z) {
        }

        /* renamed from: b */
        public void mo2365b(Object obj, boolean z) {
        }

        /* renamed from: b */
        public void mo2364b(Object obj, CharSequence charSequence) {
        }

        /* renamed from: c */
        public void mo2369c(Object obj, boolean z) {
        }

        /* renamed from: c */
        public void mo2368c(Object obj, CharSequence charSequence) {
        }

        /* renamed from: d */
        public void mo2373d(Object obj, boolean z) {
        }

        /* renamed from: e */
        public void mo2377e(Object obj, boolean z) {
        }

        /* renamed from: f */
        public void mo2379f(Object obj, boolean z) {
        }

        /* renamed from: k */
        public void mo2449k(Object obj, boolean z) {
        }

        /* renamed from: l */
        public void mo2450l(Object obj, boolean z) {
        }

        /* renamed from: g */
        public void mo2380g(Object obj, boolean z) {
        }

        /* renamed from: d */
        public void mo2372d(Object obj, CharSequence charSequence) {
        }

        /* renamed from: e */
        public void mo2375e(Object obj, View view) {
        }

        /* renamed from: h */
        public void mo2381h(Object obj, boolean z) {
        }

        /* renamed from: i */
        public void mo2382i(Object obj, boolean z) {
        }

        /* renamed from: j */
        public void mo2384j(Object obj, boolean z) {
        }

        /* renamed from: f */
        public void mo2378f(Object obj, View view) {
        }

        /* renamed from: d */
        public void mo2435d(Object obj, View view, int i) {
        }

        /* renamed from: e */
        public Object mo2437e(Object obj, int i) {
            return null;
        }

        /* renamed from: f */
        public Object mo2440f(Object obj, int i) {
            return null;
        }

        /* renamed from: e */
        public void mo2376e(Object obj, CharSequence charSequence) {
        }

        /* renamed from: C */
        public void mo2356C(Object obj) {
        }

        /* renamed from: f */
        public void mo2441f(Object obj, View view, int i) {
        }

        /* renamed from: G */
        public String mo2404G(Object obj) {
            return null;
        }

        /* renamed from: b */
        public void mo2432b(Object obj, String str) {
        }

        /* renamed from: H */
        public int mo2405H(Object obj) {
            return 0;
        }

        /* renamed from: h */
        public void mo2445h(Object obj, int i) {
        }

        /* renamed from: I */
        public Object mo2406I(Object obj) {
            return null;
        }

        /* renamed from: c */
        public void mo2434c(Object obj, Object obj2) {
        }

        /* renamed from: J */
        public Object mo2407J(Object obj) {
            return null;
        }

        /* renamed from: d */
        public void mo2436d(Object obj, Object obj2) {
        }

        /* renamed from: K */
        public Object mo2408K(Object obj) {
            return null;
        }

        /* renamed from: e */
        public void mo2439e(Object obj, Object obj2) {
        }

        /* renamed from: a */
        public List<Object> mo2335a(Object obj) {
            return null;
        }

        /* renamed from: a */
        public Object mo2333a(int i, int i2, boolean z, int i3) {
            return null;
        }

        /* renamed from: L */
        public int mo2409L(Object obj) {
            return 0;
        }

        /* renamed from: M */
        public int mo2410M(Object obj) {
            return 0;
        }

        /* renamed from: N */
        public boolean mo2411N(Object obj) {
            return false;
        }

        /* renamed from: a */
        public Object mo2332a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return null;
        }

        /* renamed from: O */
        public int mo2412O(Object obj) {
            return 0;
        }

        /* renamed from: P */
        public int mo2413P(Object obj) {
            return 0;
        }

        /* renamed from: Q */
        public int mo2414Q(Object obj) {
            return 0;
        }

        /* renamed from: R */
        public int mo2415R(Object obj) {
            return 0;
        }

        /* renamed from: S */
        public boolean mo2416S(Object obj) {
            return false;
        }

        /* renamed from: d */
        public boolean mo2344d(Object obj) {
            return false;
        }

        /* renamed from: h */
        public Object mo2352h(Object obj) {
            return null;
        }

        /* renamed from: b */
        public void mo2348b(Object obj, View view) {
        }

        /* renamed from: b */
        public void mo2349b(Object obj, View view, int i) {
        }

        /* renamed from: i */
        public Object mo2353i(Object obj) {
            return null;
        }

        /* renamed from: c */
        public void mo2350c(Object obj, View view) {
        }

        /* renamed from: c */
        public void mo2351c(Object obj, View view, int i) {
        }

        /* renamed from: m */
        public void mo2451m(Object obj, boolean z) {
        }

        /* renamed from: T */
        public boolean mo2417T(Object obj) {
            return false;
        }

        /* renamed from: a */
        public void mo2337a(Object obj, CharSequence charSequence) {
        }

        /* renamed from: e */
        public CharSequence mo2345e(Object obj) {
            return null;
        }

        /* renamed from: g */
        public void mo2443g(Object obj, View view) {
        }

        /* renamed from: g */
        public void mo2444g(Object obj, View view, int i) {
        }

        /* renamed from: U */
        public Object mo2418U(Object obj) {
            return null;
        }

        /* renamed from: h */
        public void mo2446h(Object obj, View view) {
        }

        /* renamed from: h */
        public void mo2447h(Object obj, View view, int i) {
        }

        /* renamed from: V */
        public Object mo2419V(Object obj) {
            return null;
        }

        /* renamed from: W */
        public boolean mo2420W(Object obj) {
            return false;
        }

        /* renamed from: n */
        public void mo2452n(Object obj, boolean z) {
        }

        /* renamed from: c */
        public List<Object> mo2433c(Object obj, String str) {
            return Collections.emptyList();
        }

        /* renamed from: X */
        public Bundle mo2421X(Object obj) {
            return new Bundle();
        }

        /* renamed from: Y */
        public int mo2422Y(Object obj) {
            return 0;
        }

        /* renamed from: i */
        public void mo2448i(Object obj, int i) {
        }

        /* renamed from: a */
        public void mo2336a(Object obj, int i) {
        }

        /* renamed from: f */
        public int mo2346f(Object obj) {
            return -1;
        }

        /* renamed from: a */
        public void mo2425a(Object obj, int i, int i2) {
        }

        /* renamed from: Z */
        public int mo2423Z(Object obj) {
            return -1;
        }

        /* renamed from: aa */
        public int mo2427aa(Object obj) {
            return -1;
        }

        /* renamed from: g */
        public Object mo2347g(Object obj) {
            return null;
        }

        /* renamed from: ab */
        public boolean mo2428ab(Object obj) {
            return false;
        }

        /* renamed from: o */
        public void mo2453o(Object obj, boolean z) {
        }

        /* renamed from: ac */
        public boolean mo2429ac(Object obj) {
            return false;
        }

        /* renamed from: p */
        public void mo2454p(Object obj, boolean z) {
        }

        /* renamed from: ad */
        public boolean mo2430ad(Object obj) {
            return false;
        }

        /* renamed from: q */
        public void mo2455q(Object obj, boolean z) {
        }

        /* renamed from: ae */
        public boolean mo2431ae(Object obj) {
            return false;
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$c */
    static class C0367c extends C0373i {
        C0367c() {
        }

        /* renamed from: a */
        public Object mo2357a() {
            return C1085em.m4850a();
        }

        /* renamed from: a */
        public Object mo2358a(View view) {
            return C1085em.m4851a(view);
        }

        /* renamed from: j */
        public Object mo2383j(Object obj) {
            return C1085em.m4852a(obj);
        }

        /* renamed from: b */
        public void mo2362b(Object obj, int i) {
            C1085em.m4854a(obj, i);
        }

        /* renamed from: d */
        public void mo2371d(Object obj, View view) {
            C1085em.m4856a(obj, view);
        }

        /* renamed from: a */
        public List<Object> mo2359a(Object obj, String str) {
            return C1085em.m4853a(obj, str);
        }

        /* renamed from: k */
        public int mo2385k(Object obj) {
            return C1085em.m4859b(obj);
        }

        /* renamed from: a */
        public void mo2360a(Object obj, Rect rect) {
            C1085em.m4855a(obj, rect);
        }

        /* renamed from: b */
        public void mo2363b(Object obj, Rect rect) {
            C1085em.m4861b(obj, rect);
        }

        /* renamed from: c */
        public Object mo2366c(Object obj, int i) {
            return C1085em.m4860b(obj, i);
        }

        /* renamed from: l */
        public int mo2386l(Object obj) {
            return C1085em.m4865c(obj);
        }

        /* renamed from: m */
        public CharSequence mo2387m(Object obj) {
            return C1085em.m4871d(obj);
        }

        /* renamed from: n */
        public CharSequence mo2388n(Object obj) {
            return C1085em.m4875e(obj);
        }

        /* renamed from: o */
        public CharSequence mo2389o(Object obj) {
            return C1085em.m4877f(obj);
        }

        /* renamed from: p */
        public Object mo2390p(Object obj) {
            return C1085em.m4879g(obj);
        }

        /* renamed from: q */
        public CharSequence mo2391q(Object obj) {
            return C1085em.m4881h(obj);
        }

        /* renamed from: r */
        public int mo2392r(Object obj) {
            return C1085em.m4883i(obj);
        }

        /* renamed from: s */
        public boolean mo2393s(Object obj) {
            return C1085em.m4886j(obj);
        }

        /* renamed from: t */
        public boolean mo2394t(Object obj) {
            return C1085em.m4887k(obj);
        }

        /* renamed from: u */
        public boolean mo2395u(Object obj) {
            return C1085em.m4888l(obj);
        }

        /* renamed from: v */
        public boolean mo2396v(Object obj) {
            return C1085em.m4889m(obj);
        }

        /* renamed from: w */
        public boolean mo2397w(Object obj) {
            return C1085em.m4890n(obj);
        }

        /* renamed from: x */
        public boolean mo2398x(Object obj) {
            return C1085em.m4891o(obj);
        }

        /* renamed from: y */
        public boolean mo2399y(Object obj) {
            return C1085em.m4892p(obj);
        }

        /* renamed from: z */
        public boolean mo2400z(Object obj) {
            return C1085em.m4893q(obj);
        }

        /* renamed from: A */
        public boolean mo2354A(Object obj) {
            return C1085em.m4894r(obj);
        }

        /* renamed from: B */
        public boolean mo2355B(Object obj) {
            return C1085em.m4895s(obj);
        }

        /* renamed from: d */
        public boolean mo2374d(Object obj, int i) {
            return C1085em.m4870c(obj, i);
        }

        /* renamed from: c */
        public void mo2367c(Object obj, Rect rect) {
            C1085em.m4866c(obj, rect);
        }

        /* renamed from: d */
        public void mo2370d(Object obj, Rect rect) {
            C1085em.m4872d(obj, rect);
        }

        /* renamed from: a */
        public void mo2361a(Object obj, boolean z) {
            C1085em.m4858a(obj, z);
        }

        /* renamed from: b */
        public void mo2365b(Object obj, boolean z) {
            C1085em.m4864b(obj, z);
        }

        /* renamed from: b */
        public void mo2364b(Object obj, CharSequence charSequence) {
            C1085em.m4857a(obj, charSequence);
        }

        /* renamed from: c */
        public void mo2369c(Object obj, boolean z) {
            C1085em.m4869c(obj, z);
        }

        /* renamed from: c */
        public void mo2368c(Object obj, CharSequence charSequence) {
            C1085em.m4863b(obj, charSequence);
        }

        /* renamed from: d */
        public void mo2373d(Object obj, boolean z) {
            C1085em.m4874d(obj, z);
        }

        /* renamed from: e */
        public void mo2377e(Object obj, boolean z) {
            C1085em.m4876e(obj, z);
        }

        /* renamed from: f */
        public void mo2379f(Object obj, boolean z) {
            C1085em.m4878f(obj, z);
        }

        /* renamed from: g */
        public void mo2380g(Object obj, boolean z) {
            C1085em.m4880g(obj, z);
        }

        /* renamed from: d */
        public void mo2372d(Object obj, CharSequence charSequence) {
            C1085em.m4868c(obj, charSequence);
        }

        /* renamed from: e */
        public void mo2375e(Object obj, View view) {
            C1085em.m4862b(obj, view);
        }

        /* renamed from: h */
        public void mo2381h(Object obj, boolean z) {
            C1085em.m4882h(obj, z);
        }

        /* renamed from: i */
        public void mo2382i(Object obj, boolean z) {
            C1085em.m4884i(obj, z);
        }

        /* renamed from: j */
        public void mo2384j(Object obj, boolean z) {
            C1085em.m4885j(obj, z);
        }

        /* renamed from: f */
        public void mo2378f(Object obj, View view) {
            C1085em.m4867c(obj, view);
        }

        /* renamed from: e */
        public void mo2376e(Object obj, CharSequence charSequence) {
            C1085em.m4873d(obj, charSequence);
        }

        /* renamed from: C */
        public void mo2356C(Object obj) {
            C1085em.m4896t(obj);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$e */
    static class C0369e extends C0367c {
        C0369e() {
        }

        /* renamed from: a */
        public Object mo2424a(View view, int i) {
            return C1086en.m4897a(view, i);
        }

        /* renamed from: e */
        public Object mo2437e(Object obj, int i) {
            return C1086en.m4904b(obj, i);
        }

        /* renamed from: f */
        public Object mo2440f(Object obj, int i) {
            return C1086en.m4907c(obj, i);
        }

        /* renamed from: e */
        public void mo2438e(Object obj, View view, int i) {
            C1086en.m4899a(obj, view, i);
        }

        /* renamed from: d */
        public void mo2435d(Object obj, View view, int i) {
            C1086en.m4905b(obj, view, i);
        }

        /* renamed from: E */
        public boolean mo2402E(Object obj) {
            return C1086en.m4901a(obj);
        }

        /* renamed from: k */
        public void mo2449k(Object obj, boolean z) {
            C1086en.m4900a(obj, z);
        }

        /* renamed from: F */
        public boolean mo2403F(Object obj) {
            return C1086en.m4909c(obj);
        }

        /* renamed from: l */
        public void mo2450l(Object obj, boolean z) {
            C1086en.m4906b(obj, z);
        }

        /* renamed from: a */
        public boolean mo2426a(Object obj, int i, Bundle bundle) {
            return C1086en.m4902a(obj, i, bundle);
        }

        /* renamed from: g */
        public void mo2442g(Object obj, int i) {
            C1086en.m4898a(obj, i);
        }

        /* renamed from: D */
        public int mo2401D(Object obj) {
            return C1086en.m4903b(obj);
        }

        /* renamed from: f */
        public void mo2441f(Object obj, View view, int i) {
            C1086en.m4908c(obj, view, i);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$f */
    static class C0370f extends C0369e {
        C0370f() {
        }

        /* renamed from: g */
        public void mo2443g(Object obj, View view) {
            C1087eo.m4911a(obj, view);
        }

        /* renamed from: g */
        public void mo2444g(Object obj, View view, int i) {
            C1087eo.m4912a(obj, view, i);
        }

        /* renamed from: U */
        public Object mo2418U(Object obj) {
            return C1087eo.m4910a(obj);
        }

        /* renamed from: h */
        public void mo2446h(Object obj, View view) {
            C1087eo.m4914b(obj, view);
        }

        /* renamed from: h */
        public void mo2447h(Object obj, View view, int i) {
            C1087eo.m4915b(obj, view, i);
        }

        /* renamed from: V */
        public Object mo2419V(Object obj) {
            return C1087eo.m4913b(obj);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$g */
    static class C0371g extends C0370f {
        C0371g() {
        }

        /* renamed from: G */
        public String mo2404G(Object obj) {
            return C1088ep.m4916a(obj);
        }

        /* renamed from: b */
        public void mo2432b(Object obj, String str) {
            C1088ep.m4918a(obj, str);
        }

        /* renamed from: c */
        public List<Object> mo2433c(Object obj, String str) {
            return C1088ep.m4921b(obj, str);
        }

        /* renamed from: a */
        public void mo2425a(Object obj, int i, int i2) {
            C1088ep.m4917a(obj, i, i2);
        }

        /* renamed from: Z */
        public int mo2423Z(Object obj) {
            return C1088ep.m4920b(obj);
        }

        /* renamed from: aa */
        public int mo2427aa(Object obj) {
            return C1088ep.m4922c(obj);
        }

        /* renamed from: ac */
        public boolean mo2429ac(Object obj) {
            return C1088ep.m4923d(obj);
        }

        /* renamed from: p */
        public void mo2454p(Object obj, boolean z) {
            C1088ep.m4919a(obj, z);
        }

        /* renamed from: ae */
        public boolean mo2431ae(Object obj) {
            return C1088ep.m4924e(obj);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$h */
    static class C0372h extends C0371g {
        C0372h() {
        }

        /* renamed from: H */
        public int mo2405H(Object obj) {
            return C1089eq.m4925a(obj);
        }

        /* renamed from: h */
        public void mo2445h(Object obj, int i) {
            C1089eq.m4928a(obj, i);
        }

        /* renamed from: I */
        public Object mo2406I(Object obj) {
            return C1089eq.m4931b(obj);
        }

        /* renamed from: c */
        public void mo2434c(Object obj, Object obj2) {
            C1089eq.m4929a(obj, obj2);
        }

        /* renamed from: a */
        public Object mo2333a(int i, int i2, boolean z, int i3) {
            return C1089eq.m4927a(i, i2, z, i3);
        }

        /* renamed from: a */
        public Object mo2332a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return C1089eq.m4926a(i, i2, i3, i4, z);
        }

        /* renamed from: L */
        public int mo2409L(Object obj) {
            return C1089eq.C1090a.m4946a(obj);
        }

        /* renamed from: M */
        public int mo2410M(Object obj) {
            return C1089eq.C1090a.m4947b(obj);
        }

        /* renamed from: N */
        public boolean mo2411N(Object obj) {
            return C1089eq.C1090a.m4948c(obj);
        }

        /* renamed from: J */
        public Object mo2407J(Object obj) {
            return C1089eq.m4935c(obj);
        }

        /* renamed from: K */
        public Object mo2408K(Object obj) {
            return C1089eq.m4938d(obj);
        }

        /* renamed from: e */
        public void mo2439e(Object obj, Object obj2) {
            C1089eq.m4936c(obj, obj2);
        }

        /* renamed from: O */
        public int mo2412O(Object obj) {
            return C1089eq.C1091b.m4949a(obj);
        }

        /* renamed from: P */
        public int mo2413P(Object obj) {
            return C1089eq.C1091b.m4950b(obj);
        }

        /* renamed from: Q */
        public int mo2414Q(Object obj) {
            return C1089eq.C1091b.m4951c(obj);
        }

        /* renamed from: R */
        public int mo2415R(Object obj) {
            return C1089eq.C1091b.m4952d(obj);
        }

        /* renamed from: S */
        public boolean mo2416S(Object obj) {
            return C1089eq.C1091b.m4953e(obj);
        }

        /* renamed from: d */
        public void mo2436d(Object obj, Object obj2) {
            C1089eq.m4933b(obj, obj2);
        }

        /* renamed from: m */
        public void mo2451m(Object obj, boolean z) {
            C1089eq.m4930a(obj, z);
        }

        /* renamed from: T */
        public boolean mo2417T(Object obj) {
            return C1089eq.m4940e(obj);
        }

        /* renamed from: W */
        public boolean mo2420W(Object obj) {
            return C1089eq.m4941f(obj);
        }

        /* renamed from: n */
        public void mo2452n(Object obj, boolean z) {
            C1089eq.m4934b(obj, z);
        }

        /* renamed from: X */
        public Bundle mo2421X(Object obj) {
            return C1089eq.m4942g(obj);
        }

        /* renamed from: Y */
        public int mo2422Y(Object obj) {
            return C1089eq.m4943h(obj);
        }

        /* renamed from: i */
        public void mo2448i(Object obj, int i) {
            C1089eq.m4932b(obj, i);
        }

        /* renamed from: ab */
        public boolean mo2428ab(Object obj) {
            return C1089eq.m4944i(obj);
        }

        /* renamed from: o */
        public void mo2453o(Object obj, boolean z) {
            C1089eq.m4937c(obj, z);
        }

        /* renamed from: ad */
        public boolean mo2430ad(Object obj) {
            return C1089eq.m4945j(obj);
        }

        /* renamed from: q */
        public void mo2455q(Object obj, boolean z) {
            C1089eq.m4939d(obj, z);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$a */
    static class C0365a extends C0372h {
        C0365a() {
        }

        /* renamed from: a */
        public Object mo2334a(int i, CharSequence charSequence) {
            return C1082ek.m4830a(i, charSequence);
        }

        /* renamed from: a */
        public List<Object> mo2335a(Object obj) {
            return C1082ek.m4831a(obj);
        }

        /* renamed from: a */
        public Object mo2333a(int i, int i2, boolean z, int i3) {
            return C1082ek.m4829a(i, i2, z, i3);
        }

        /* renamed from: a */
        public void mo2338a(Object obj, Object obj2) {
            C1082ek.m4834a(obj, obj2);
        }

        /* renamed from: b */
        public boolean mo2342b(Object obj, Object obj2) {
            return C1082ek.m4838b(obj, obj2);
        }

        /* renamed from: b */
        public int mo2341b(Object obj) {
            return C1082ek.m4841e(obj);
        }

        /* renamed from: c */
        public CharSequence mo2343c(Object obj) {
            return C1082ek.m4842f(obj);
        }

        /* renamed from: a */
        public Object mo2332a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return C1082ek.m4828a(i, i2, i3, i4, z, z2);
        }

        /* renamed from: d */
        public boolean mo2344d(Object obj) {
            return C1082ek.C1083a.m4843a(obj);
        }

        /* renamed from: e */
        public CharSequence mo2345e(Object obj) {
            return C1082ek.m4837b(obj);
        }

        /* renamed from: a */
        public void mo2337a(Object obj, CharSequence charSequence) {
            C1082ek.m4833a(obj, charSequence);
        }

        /* renamed from: a */
        public void mo2336a(Object obj, int i) {
            C1082ek.m4832a(obj, i);
        }

        /* renamed from: f */
        public int mo2346f(Object obj) {
            return C1082ek.m4839c(obj);
        }

        /* renamed from: g */
        public Object mo2347g(Object obj) {
            return C1082ek.m4840d(obj);
        }

        /* renamed from: a */
        public boolean mo2339a(Object obj, View view) {
            return C1082ek.m4835a(obj, view);
        }

        /* renamed from: a */
        public boolean mo2340a(Object obj, View view, int i) {
            return C1082ek.m4836a(obj, view, i);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$b */
    static class C0366b extends C0365a {
        C0366b() {
        }

        /* renamed from: h */
        public Object mo2352h(Object obj) {
            return C1084el.m4844a(obj);
        }

        /* renamed from: b */
        public void mo2348b(Object obj, View view) {
            C1084el.m4845a(obj, view);
        }

        /* renamed from: b */
        public void mo2349b(Object obj, View view, int i) {
            C1084el.m4846a(obj, view, i);
        }

        /* renamed from: i */
        public Object mo2353i(Object obj) {
            return C1084el.m4847b(obj);
        }

        /* renamed from: c */
        public void mo2350c(Object obj, View view) {
            C1084el.m4848b(obj, view);
        }

        /* renamed from: c */
        public void mo2351c(Object obj, View view, int i) {
            C1084el.m4849b(obj, view, i);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 22) {
            f1083a = new C0366b();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f1083a = new C0365a();
        } else if (Build.VERSION.SDK_INT >= 19) {
            f1083a = new C0372h();
        } else if (Build.VERSION.SDK_INT >= 18) {
            f1083a = new C0371g();
        } else if (Build.VERSION.SDK_INT >= 17) {
            f1083a = new C0370f();
        } else if (Build.VERSION.SDK_INT >= 16) {
            f1083a = new C0369e();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f1083a = new C0367c();
        } else {
            f1083a = new C0373i();
        }
    }

    /* renamed from: a */
    static AccessibilityNodeInfoCompat m1800a(Object obj) {
        if (obj != null) {
            return new AccessibilityNodeInfoCompat(obj);
        }
        return null;
    }

    public AccessibilityNodeInfoCompat(Object obj) {
        this.f1084b = obj;
    }

    public Object getInfo() {
        return this.f1084b;
    }

    public static AccessibilityNodeInfoCompat obtain(View view) {
        return m1800a(f1083a.mo2358a(view));
    }

    public static AccessibilityNodeInfoCompat obtain(View view, int i) {
        return m1800a(f1083a.mo2424a(view, i));
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return m1800a(f1083a.mo2357a());
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return m1800a(f1083a.mo2383j(accessibilityNodeInfoCompat.f1084b));
    }

    public void setSource(View view) {
        f1083a.mo2378f(this.f1084b, view);
    }

    public void setSource(View view, int i) {
        f1083a.mo2435d(this.f1084b, view, i);
    }

    public AccessibilityNodeInfoCompat findFocus(int i) {
        return m1800a(f1083a.mo2437e(this.f1084b, i));
    }

    public AccessibilityNodeInfoCompat focusSearch(int i) {
        return m1800a(f1083a.mo2440f(this.f1084b, i));
    }

    public int getWindowId() {
        return f1083a.mo2392r(this.f1084b);
    }

    public int getChildCount() {
        return f1083a.mo2386l(this.f1084b);
    }

    public AccessibilityNodeInfoCompat getChild(int i) {
        return m1800a(f1083a.mo2366c(this.f1084b, i));
    }

    public void addChild(View view) {
        f1083a.mo2371d(this.f1084b, view);
    }

    public void addChild(View view, int i) {
        f1083a.mo2438e(this.f1084b, view, i);
    }

    public boolean removeChild(View view) {
        return f1083a.mo2339a(this.f1084b, view);
    }

    public boolean removeChild(View view, int i) {
        return f1083a.mo2340a(this.f1084b, view, i);
    }

    public int getActions() {
        return f1083a.mo2385k(this.f1084b);
    }

    public void addAction(int i) {
        f1083a.mo2362b(this.f1084b, i);
    }

    public void addAction(AccessibilityActionCompat accessibilityActionCompat) {
        f1083a.mo2338a(this.f1084b, accessibilityActionCompat.f1085a);
    }

    public boolean removeAction(AccessibilityActionCompat accessibilityActionCompat) {
        return f1083a.mo2342b(this.f1084b, accessibilityActionCompat.f1085a);
    }

    public boolean performAction(int i) {
        return f1083a.mo2374d(this.f1084b, i);
    }

    public boolean performAction(int i, Bundle bundle) {
        return f1083a.mo2426a(this.f1084b, i, bundle);
    }

    public void setMovementGranularities(int i) {
        f1083a.mo2442g(this.f1084b, i);
    }

    public int getMovementGranularities() {
        return f1083a.mo2401D(this.f1084b);
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String str) {
        ArrayList arrayList = new ArrayList();
        List<Object> a = f1083a.mo2359a(this.f1084b, str);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new AccessibilityNodeInfoCompat(a.get(i)));
        }
        return arrayList;
    }

    public AccessibilityNodeInfoCompat getParent() {
        return m1800a(f1083a.mo2390p(this.f1084b));
    }

    public void setParent(View view) {
        f1083a.mo2375e(this.f1084b, view);
    }

    public void setParent(View view, int i) {
        f1083a.mo2441f(this.f1084b, view, i);
    }

    public void getBoundsInParent(Rect rect) {
        f1083a.mo2360a(this.f1084b, rect);
    }

    public void setBoundsInParent(Rect rect) {
        f1083a.mo2367c(this.f1084b, rect);
    }

    public void getBoundsInScreen(Rect rect) {
        f1083a.mo2363b(this.f1084b, rect);
    }

    public void setBoundsInScreen(Rect rect) {
        f1083a.mo2370d(this.f1084b, rect);
    }

    public boolean isCheckable() {
        return f1083a.mo2393s(this.f1084b);
    }

    public void setCheckable(boolean z) {
        f1083a.mo2361a(this.f1084b, z);
    }

    public boolean isChecked() {
        return f1083a.mo2394t(this.f1084b);
    }

    public void setChecked(boolean z) {
        f1083a.mo2365b(this.f1084b, z);
    }

    public boolean isFocusable() {
        return f1083a.mo2397w(this.f1084b);
    }

    public void setFocusable(boolean z) {
        f1083a.mo2377e(this.f1084b, z);
    }

    public boolean isFocused() {
        return f1083a.mo2398x(this.f1084b);
    }

    public void setFocused(boolean z) {
        f1083a.mo2379f(this.f1084b, z);
    }

    public boolean isVisibleToUser() {
        return f1083a.mo2402E(this.f1084b);
    }

    public void setVisibleToUser(boolean z) {
        f1083a.mo2449k(this.f1084b, z);
    }

    public boolean isAccessibilityFocused() {
        return f1083a.mo2403F(this.f1084b);
    }

    public void setAccessibilityFocused(boolean z) {
        f1083a.mo2450l(this.f1084b, z);
    }

    public boolean isSelected() {
        return f1083a.mo2355B(this.f1084b);
    }

    public void setSelected(boolean z) {
        f1083a.mo2384j(this.f1084b, z);
    }

    public boolean isClickable() {
        return f1083a.mo2395u(this.f1084b);
    }

    public void setClickable(boolean z) {
        f1083a.mo2369c(this.f1084b, z);
    }

    public boolean isLongClickable() {
        return f1083a.mo2399y(this.f1084b);
    }

    public void setLongClickable(boolean z) {
        f1083a.mo2380g(this.f1084b, z);
    }

    public boolean isEnabled() {
        return f1083a.mo2396v(this.f1084b);
    }

    public void setEnabled(boolean z) {
        f1083a.mo2373d(this.f1084b, z);
    }

    public boolean isPassword() {
        return f1083a.mo2400z(this.f1084b);
    }

    public void setPassword(boolean z) {
        f1083a.mo2381h(this.f1084b, z);
    }

    public boolean isScrollable() {
        return f1083a.mo2354A(this.f1084b);
    }

    public void setScrollable(boolean z) {
        f1083a.mo2382i(this.f1084b, z);
    }

    public CharSequence getPackageName() {
        return f1083a.mo2389o(this.f1084b);
    }

    public void setPackageName(CharSequence charSequence) {
        f1083a.mo2372d(this.f1084b, charSequence);
    }

    public CharSequence getClassName() {
        return f1083a.mo2387m(this.f1084b);
    }

    public void setClassName(CharSequence charSequence) {
        f1083a.mo2364b(this.f1084b, charSequence);
    }

    public CharSequence getText() {
        return f1083a.mo2391q(this.f1084b);
    }

    public void setText(CharSequence charSequence) {
        f1083a.mo2376e(this.f1084b, charSequence);
    }

    public CharSequence getContentDescription() {
        return f1083a.mo2388n(this.f1084b);
    }

    public void setContentDescription(CharSequence charSequence) {
        f1083a.mo2368c(this.f1084b, charSequence);
    }

    public void recycle() {
        f1083a.mo2356C(this.f1084b);
    }

    public void setViewIdResourceName(String str) {
        f1083a.mo2432b(this.f1084b, str);
    }

    public String getViewIdResourceName() {
        return f1083a.mo2404G(this.f1084b);
    }

    public int getLiveRegion() {
        return f1083a.mo2405H(this.f1084b);
    }

    public void setLiveRegion(int i) {
        f1083a.mo2445h(this.f1084b, i);
    }

    public CollectionInfoCompat getCollectionInfo() {
        Object I = f1083a.mo2406I(this.f1084b);
        if (I == null) {
            return null;
        }
        return new CollectionInfoCompat(I);
    }

    public void setCollectionInfo(Object obj) {
        f1083a.mo2434c(this.f1084b, ((CollectionInfoCompat) obj).f1086a);
    }

    public void setCollectionItemInfo(Object obj) {
        f1083a.mo2436d(this.f1084b, ((CollectionItemInfoCompat) obj).f1087a);
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        Object J = f1083a.mo2407J(this.f1084b);
        if (J == null) {
            return null;
        }
        return new CollectionItemInfoCompat(J);
    }

    public RangeInfoCompat getRangeInfo() {
        Object K = f1083a.mo2408K(this.f1084b);
        if (K == null) {
            return null;
        }
        return new RangeInfoCompat(K);
    }

    public void setRangeInfo(RangeInfoCompat rangeInfoCompat) {
        f1083a.mo2439e(this.f1084b, rangeInfoCompat.f1088a);
    }

    public List<AccessibilityActionCompat> getActionList() {
        List<Object> a = f1083a.mo2335a(this.f1084b);
        if (a == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new AccessibilityActionCompat(a.get(i)));
        }
        return arrayList;
    }

    public void setContentInvalid(boolean z) {
        f1083a.mo2451m(this.f1084b, z);
    }

    public boolean isContentInvalid() {
        return f1083a.mo2417T(this.f1084b);
    }

    public void setError(CharSequence charSequence) {
        f1083a.mo2337a(this.f1084b, charSequence);
    }

    public CharSequence getError() {
        return f1083a.mo2345e(this.f1084b);
    }

    public void setLabelFor(View view) {
        f1083a.mo2443g(this.f1084b, view);
    }

    public void setLabelFor(View view, int i) {
        f1083a.mo2444g(this.f1084b, view, i);
    }

    public AccessibilityNodeInfoCompat getLabelFor() {
        return m1800a(f1083a.mo2418U(this.f1084b));
    }

    public void setLabeledBy(View view) {
        f1083a.mo2446h(this.f1084b, view);
    }

    public void setLabeledBy(View view, int i) {
        f1083a.mo2447h(this.f1084b, view, i);
    }

    public AccessibilityNodeInfoCompat getLabeledBy() {
        return m1800a(f1083a.mo2419V(this.f1084b));
    }

    public boolean canOpenPopup() {
        return f1083a.mo2420W(this.f1084b);
    }

    public void setCanOpenPopup(boolean z) {
        f1083a.mo2452n(this.f1084b, z);
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String str) {
        List<Object> c = f1083a.mo2433c(this.f1084b, str);
        if (c == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object accessibilityNodeInfoCompat : c) {
            arrayList.add(new AccessibilityNodeInfoCompat(accessibilityNodeInfoCompat));
        }
        return arrayList;
    }

    public Bundle getExtras() {
        return f1083a.mo2421X(this.f1084b);
    }

    public int getInputType() {
        return f1083a.mo2422Y(this.f1084b);
    }

    public void setInputType(int i) {
        f1083a.mo2448i(this.f1084b, i);
    }

    public void setMaxTextLength(int i) {
        f1083a.mo2336a(this.f1084b, i);
    }

    public int getMaxTextLength() {
        return f1083a.mo2346f(this.f1084b);
    }

    public void setTextSelection(int i, int i2) {
        f1083a.mo2425a(this.f1084b, i, i2);
    }

    public int getTextSelectionStart() {
        return f1083a.mo2423Z(this.f1084b);
    }

    public int getTextSelectionEnd() {
        return f1083a.mo2427aa(this.f1084b);
    }

    public AccessibilityNodeInfoCompat getTraversalBefore() {
        return m1800a(f1083a.mo2352h(this.f1084b));
    }

    public void setTraversalBefore(View view) {
        f1083a.mo2348b(this.f1084b, view);
    }

    public void setTraversalBefore(View view, int i) {
        f1083a.mo2349b(this.f1084b, view, i);
    }

    public AccessibilityNodeInfoCompat getTraversalAfter() {
        return m1800a(f1083a.mo2353i(this.f1084b));
    }

    public void setTraversalAfter(View view) {
        f1083a.mo2350c(this.f1084b, view);
    }

    public void setTraversalAfter(View view, int i) {
        f1083a.mo2351c(this.f1084b, view, i);
    }

    public AccessibilityWindowInfoCompat getWindow() {
        return AccessibilityWindowInfoCompat.m2328a(f1083a.mo2347g(this.f1084b));
    }

    public boolean isDismissable() {
        return f1083a.mo2428ab(this.f1084b);
    }

    public void setDismissable(boolean z) {
        f1083a.mo2453o(this.f1084b, z);
    }

    public boolean isEditable() {
        return f1083a.mo2429ac(this.f1084b);
    }

    public void setEditable(boolean z) {
        f1083a.mo2454p(this.f1084b, z);
    }

    public boolean isMultiLine() {
        return f1083a.mo2430ad(this.f1084b);
    }

    public void setMultiLine(boolean z) {
        f1083a.mo2455q(this.f1084b, z);
    }

    public boolean refresh() {
        return f1083a.mo2431ae(this.f1084b);
    }

    public int hashCode() {
        if (this.f1084b == null) {
            return 0;
        }
        return this.f1084b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        if (this.f1084b == null) {
            if (accessibilityNodeInfoCompat.f1084b != null) {
                return false;
            }
            return true;
        } else if (!this.f1084b.equals(accessibilityNodeInfoCompat.f1084b)) {
            return false;
        } else {
            return true;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        sb.append("; boundsInParent: " + rect);
        getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ").append(getPackageName());
        sb.append("; className: ").append(getClassName());
        sb.append("; text: ").append(getText());
        sb.append("; contentDescription: ").append(getContentDescription());
        sb.append("; viewId: ").append(getViewIdResourceName());
        sb.append("; checkable: ").append(isCheckable());
        sb.append("; checked: ").append(isChecked());
        sb.append("; focusable: ").append(isFocusable());
        sb.append("; focused: ").append(isFocused());
        sb.append("; selected: ").append(isSelected());
        sb.append("; clickable: ").append(isClickable());
        sb.append("; longClickable: ").append(isLongClickable());
        sb.append("; enabled: ").append(isEnabled());
        sb.append("; password: ").append(isPassword());
        sb.append("; scrollable: " + isScrollable());
        sb.append("; [");
        int actions = getActions();
        while (actions != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(actions);
            actions &= numberOfTrailingZeros ^ -1;
            sb.append(m1801a(numberOfTrailingZeros));
            if (actions != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: a */
    private static String m1801a(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
