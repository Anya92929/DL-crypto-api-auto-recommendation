package android.support.p001v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p001v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p001v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.view.ViewCompat */
public class ViewCompat {
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int LAYER_TYPE_HARDWARE = 2;
    public static final int LAYER_TYPE_NONE = 0;
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    public static final int MEASURED_SIZE_MASK = 16777215;
    public static final int MEASURED_STATE_MASK = -16777216;
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;

    /* renamed from: a */
    static final C0319m f982a;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.view.ViewCompat$ScrollIndicators */
    public @interface ScrollIndicators {
    }

    /* renamed from: android.support.v4.view.ViewCompat$m */
    interface C0319m {
        /* renamed from: A */
        float mo1890A(View view);

        /* renamed from: B */
        float mo1891B(View view);

        /* renamed from: C */
        float mo1892C(View view);

        /* renamed from: D */
        float mo1893D(View view);

        /* renamed from: E */
        int mo1894E(View view);

        /* renamed from: F */
        int mo1895F(View view);

        /* renamed from: G */
        ViewPropertyAnimatorCompat mo1896G(View view);

        /* renamed from: H */
        float mo1897H(View view);

        /* renamed from: I */
        float mo1898I(View view);

        /* renamed from: J */
        String mo1899J(View view);

        /* renamed from: K */
        int mo1900K(View view);

        /* renamed from: L */
        void mo1901L(View view);

        /* renamed from: M */
        float mo1902M(View view);

        /* renamed from: N */
        float mo1903N(View view);

        /* renamed from: O */
        Rect mo1904O(View view);

        /* renamed from: P */
        boolean mo1905P(View view);

        /* renamed from: Q */
        void mo1906Q(View view);

        /* renamed from: R */
        boolean mo1907R(View view);

        /* renamed from: S */
        boolean mo1908S(View view);

        /* renamed from: T */
        ColorStateList mo1909T(View view);

        /* renamed from: U */
        PorterDuff.Mode mo1910U(View view);

        /* renamed from: V */
        void mo1911V(View view);

        /* renamed from: W */
        boolean mo1912W(View view);

        /* renamed from: X */
        boolean mo1913X(View view);

        /* renamed from: Y */
        float mo1914Y(View view);

        /* renamed from: Z */
        boolean mo1915Z(View view);

        /* renamed from: a */
        int mo1916a(int i, int i2);

        /* renamed from: a */
        int mo1917a(int i, int i2, int i3);

        /* renamed from: a */
        int mo1918a(View view);

        /* renamed from: a */
        WindowInsetsCompat mo1920a(View view, WindowInsetsCompat windowInsetsCompat);

        /* renamed from: a */
        void mo1921a(View view, float f);

        /* renamed from: a */
        void mo1922a(View view, int i, int i2);

        /* renamed from: a */
        void mo1923a(View view, int i, int i2, int i3, int i4);

        /* renamed from: a */
        void mo1924a(View view, int i, Paint paint);

        /* renamed from: a */
        void mo1925a(View view, ColorStateList colorStateList);

        /* renamed from: a */
        void mo1926a(View view, Paint paint);

        /* renamed from: a */
        void mo1927a(View view, PorterDuff.Mode mode);

        /* renamed from: a */
        void mo1928a(View view, Rect rect);

        /* renamed from: a */
        void mo1929a(View view, @Nullable AccessibilityDelegateCompat accessibilityDelegateCompat);

        /* renamed from: a */
        void mo1930a(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener);

        /* renamed from: a */
        void mo1931a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

        /* renamed from: a */
        void mo1932a(View view, AccessibilityEvent accessibilityEvent);

        /* renamed from: a */
        void mo1933a(View view, Runnable runnable);

        /* renamed from: a */
        void mo1934a(View view, Runnable runnable, long j);

        /* renamed from: a */
        void mo1935a(View view, String str);

        /* renamed from: a */
        void mo1936a(View view, boolean z);

        /* renamed from: a */
        void mo1937a(ViewGroup viewGroup, boolean z);

        /* renamed from: a */
        boolean mo1938a(View view, float f, float f2);

        /* renamed from: a */
        boolean mo1939a(View view, float f, float f2, boolean z);

        /* renamed from: a */
        boolean mo1940a(View view, int i);

        /* renamed from: a */
        boolean mo1941a(View view, int i, int i2, int i3, int i4, int[] iArr);

        /* renamed from: a */
        boolean mo1942a(View view, int i, int i2, int[] iArr, int[] iArr2);

        /* renamed from: a */
        boolean mo1943a(View view, int i, Bundle bundle);

        /* renamed from: aa */
        boolean mo1944aa(View view);

        /* renamed from: ab */
        int mo1945ab(View view);

        /* renamed from: b */
        WindowInsetsCompat mo1946b(View view, WindowInsetsCompat windowInsetsCompat);

        /* renamed from: b */
        void mo1947b(View view, float f);

        /* renamed from: b */
        void mo1948b(View view, int i, int i2, int i3, int i4);

        /* renamed from: b */
        void mo1949b(View view, AccessibilityEvent accessibilityEvent);

        /* renamed from: b */
        void mo1950b(View view, boolean z);

        /* renamed from: b */
        boolean mo1951b(View view);

        /* renamed from: b */
        boolean mo1952b(View view, int i);

        /* renamed from: c */
        void mo1953c(View view, float f);

        /* renamed from: c */
        void mo1954c(View view, int i);

        /* renamed from: c */
        void mo1955c(View view, boolean z);

        /* renamed from: c */
        boolean mo1956c(View view);

        /* renamed from: d */
        void mo1957d(View view);

        /* renamed from: d */
        void mo1958d(View view, float f);

        /* renamed from: d */
        void mo1959d(View view, int i);

        /* renamed from: d */
        void mo1960d(View view, boolean z);

        /* renamed from: e */
        int mo1961e(View view);

        /* renamed from: e */
        void mo1962e(View view, float f);

        /* renamed from: e */
        void mo1963e(View view, int i);

        /* renamed from: e */
        void mo1964e(View view, boolean z);

        /* renamed from: f */
        AccessibilityNodeProviderCompat mo1965f(View view);

        /* renamed from: f */
        void mo1966f(View view, float f);

        /* renamed from: f */
        void mo1967f(View view, int i);

        /* renamed from: g */
        float mo1968g(View view);

        /* renamed from: g */
        void mo1969g(View view, float f);

        /* renamed from: g */
        void mo1970g(View view, int i);

        /* renamed from: h */
        int mo1971h(View view);

        /* renamed from: h */
        void mo1972h(View view, float f);

        /* renamed from: h */
        boolean mo1973h(View view, int i);

        /* renamed from: i */
        int mo1974i(View view);

        /* renamed from: i */
        void mo1975i(View view, float f);

        /* renamed from: i */
        void mo1976i(View view, int i);

        /* renamed from: j */
        int mo1977j(View view);

        /* renamed from: j */
        void mo1978j(View view, float f);

        /* renamed from: k */
        ViewParent mo1979k(View view);

        /* renamed from: k */
        void mo1980k(View view, float f);

        /* renamed from: l */
        void mo1981l(View view, float f);

        /* renamed from: l */
        boolean mo1982l(View view);

        /* renamed from: m */
        int mo1983m(View view);

        /* renamed from: m */
        void mo1984m(View view, float f);

        /* renamed from: n */
        int mo1985n(View view);

        /* renamed from: n */
        void mo1986n(View view, float f);

        /* renamed from: o */
        int mo1987o(View view);

        /* renamed from: p */
        int mo1988p(View view);

        /* renamed from: q */
        int mo1989q(View view);

        /* renamed from: r */
        int mo1990r(View view);

        /* renamed from: s */
        void mo1991s(View view);

        /* renamed from: t */
        void mo1992t(View view);

        /* renamed from: u */
        boolean mo1993u(View view);

        /* renamed from: v */
        float mo1994v(View view);

        /* renamed from: w */
        float mo1995w(View view);

        /* renamed from: x */
        float mo1996x(View view);

        /* renamed from: y */
        float mo1997y(View view);

        /* renamed from: z */
        float mo1998z(View view);
    }

    /* renamed from: android.support.v4.view.ViewCompat$a */
    static class C0307a implements C0319m {

        /* renamed from: a */
        WeakHashMap<View, ViewPropertyAnimatorCompat> f983a = null;

        /* renamed from: b */
        private Method f984b;

        /* renamed from: c */
        private Method f985c;

        /* renamed from: d */
        private boolean f986d;

        C0307a() {
        }

        /* renamed from: a */
        public boolean mo1940a(View view, int i) {
            return (view instanceof ScrollingView) && m1206a((ScrollingView) view, i);
        }

        /* renamed from: b */
        public boolean mo1952b(View view, int i) {
            return (view instanceof ScrollingView) && m1208b((ScrollingView) view, i);
        }

        /* renamed from: a */
        public int mo1918a(View view) {
            return 2;
        }

        /* renamed from: c */
        public void mo1954c(View view, int i) {
        }

        /* renamed from: a */
        public void mo1929a(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        }

        /* renamed from: b */
        public boolean mo1951b(View view) {
            return false;
        }

        /* renamed from: a */
        public void mo1932a(View view, AccessibilityEvent accessibilityEvent) {
        }

        /* renamed from: b */
        public void mo1949b(View view, AccessibilityEvent accessibilityEvent) {
        }

        /* renamed from: a */
        public void mo1931a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        /* renamed from: c */
        public boolean mo1956c(View view) {
            return false;
        }

        /* renamed from: a */
        public void mo1936a(View view, boolean z) {
        }

        /* renamed from: d */
        public void mo1957d(View view) {
            view.invalidate();
        }

        /* renamed from: a */
        public void mo1923a(View view, int i, int i2, int i3, int i4) {
            view.invalidate(i, i2, i3, i4);
        }

        /* renamed from: a */
        public void mo1933a(View view, Runnable runnable) {
            view.postDelayed(runnable, mo1919a());
        }

        /* renamed from: a */
        public void mo1934a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, mo1919a() + j);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public long mo1919a() {
            return 10;
        }

        /* renamed from: e */
        public int mo1961e(View view) {
            return 0;
        }

        /* renamed from: d */
        public void mo1959d(View view, int i) {
        }

        /* renamed from: a */
        public boolean mo1943a(View view, int i, Bundle bundle) {
            return false;
        }

        /* renamed from: f */
        public AccessibilityNodeProviderCompat mo1965f(View view) {
            return null;
        }

        /* renamed from: g */
        public float mo1968g(View view) {
            return 1.0f;
        }

        /* renamed from: a */
        public void mo1924a(View view, int i, Paint paint) {
        }

        /* renamed from: h */
        public int mo1971h(View view) {
            return 0;
        }

        /* renamed from: i */
        public int mo1974i(View view) {
            return 0;
        }

        /* renamed from: e */
        public void mo1963e(View view, int i) {
        }

        /* renamed from: a */
        public void mo1926a(View view, Paint paint) {
        }

        /* renamed from: j */
        public int mo1977j(View view) {
            return 0;
        }

        /* renamed from: f */
        public void mo1967f(View view, int i) {
        }

        /* renamed from: k */
        public ViewParent mo1979k(View view) {
            return view.getParent();
        }

        /* renamed from: l */
        public boolean mo1982l(View view) {
            Drawable background = view.getBackground();
            if (background == null || background.getOpacity() != -1) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public int mo1917a(int i, int i2, int i3) {
            return View.resolveSize(i, i2);
        }

        /* renamed from: m */
        public int mo1983m(View view) {
            return view.getMeasuredWidth();
        }

        /* renamed from: n */
        public int mo1985n(View view) {
            return view.getMeasuredHeight();
        }

        /* renamed from: o */
        public int mo1987o(View view) {
            return 0;
        }

        /* renamed from: p */
        public int mo1988p(View view) {
            return 0;
        }

        /* renamed from: g */
        public void mo1970g(View view, int i) {
        }

        /* renamed from: q */
        public int mo1989q(View view) {
            return view.getPaddingLeft();
        }

        /* renamed from: r */
        public int mo1990r(View view) {
            return view.getPaddingRight();
        }

        /* renamed from: b */
        public void mo1948b(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        /* renamed from: s */
        public void mo1991s(View view) {
            if (!this.f986d) {
                m1207b();
            }
            if (this.f984b != null) {
                try {
                    this.f984b.invoke(view, new Object[0]);
                } catch (Exception e) {
                    Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", e);
                }
            } else {
                view.onStartTemporaryDetach();
            }
        }

        /* renamed from: t */
        public void mo1992t(View view) {
            if (!this.f986d) {
                m1207b();
            }
            if (this.f985c != null) {
                try {
                    this.f985c.invoke(view, new Object[0]);
                } catch (Exception e) {
                    Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", e);
                }
            } else {
                view.onFinishTemporaryDetach();
            }
        }

        /* renamed from: u */
        public boolean mo1993u(View view) {
            return true;
        }

        /* renamed from: b */
        private void m1207b() {
            try {
                this.f984b = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
                this.f985c = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
            } catch (NoSuchMethodException e) {
                Log.e("ViewCompat", "Couldn't find method", e);
            }
            this.f986d = true;
        }

        /* renamed from: v */
        public float mo1994v(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        /* renamed from: w */
        public float mo1995w(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        /* renamed from: x */
        public float mo1996x(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        /* renamed from: y */
        public float mo1997y(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        /* renamed from: z */
        public float mo1998z(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        /* renamed from: A */
        public float mo1890A(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        /* renamed from: B */
        public float mo1891B(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        /* renamed from: C */
        public float mo1892C(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        /* renamed from: D */
        public float mo1893D(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        /* renamed from: E */
        public int mo1894E(View view) {
            return C1046dh.m4650d(view);
        }

        /* renamed from: F */
        public int mo1895F(View view) {
            return C1046dh.m4651e(view);
        }

        /* renamed from: G */
        public ViewPropertyAnimatorCompat mo1896G(View view) {
            return new ViewPropertyAnimatorCompat(view);
        }

        /* renamed from: a */
        public void mo1921a(View view, float f) {
        }

        /* renamed from: b */
        public void mo1947b(View view, float f) {
        }

        /* renamed from: c */
        public void mo1953c(View view, float f) {
        }

        /* renamed from: d */
        public void mo1958d(View view, float f) {
        }

        /* renamed from: e */
        public void mo1962e(View view, float f) {
        }

        /* renamed from: f */
        public void mo1966f(View view, float f) {
        }

        /* renamed from: g */
        public void mo1969g(View view, float f) {
        }

        /* renamed from: h */
        public void mo1972h(View view, float f) {
        }

        /* renamed from: i */
        public void mo1975i(View view, float f) {
        }

        /* renamed from: j */
        public void mo1978j(View view, float f) {
        }

        /* renamed from: k */
        public void mo1980k(View view, float f) {
        }

        /* renamed from: l */
        public void mo1981l(View view, float f) {
        }

        /* renamed from: H */
        public float mo1897H(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        /* renamed from: I */
        public float mo1898I(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        /* renamed from: a */
        public void mo1935a(View view, String str) {
        }

        /* renamed from: J */
        public String mo1899J(View view) {
            return null;
        }

        /* renamed from: K */
        public int mo1900K(View view) {
            return 0;
        }

        /* renamed from: L */
        public void mo1901L(View view) {
        }

        /* renamed from: m */
        public void mo1984m(View view, float f) {
        }

        /* renamed from: M */
        public float mo1902M(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        /* renamed from: n */
        public void mo1986n(View view, float f) {
        }

        /* renamed from: N */
        public float mo1903N(View view) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        /* renamed from: a */
        public void mo1928a(View view, Rect rect) {
        }

        /* renamed from: O */
        public Rect mo1904O(View view) {
            return null;
        }

        /* renamed from: a */
        public void mo1937a(ViewGroup viewGroup, boolean z) {
        }

        /* renamed from: P */
        public boolean mo1905P(View view) {
            return false;
        }

        /* renamed from: b */
        public void mo1950b(View view, boolean z) {
        }

        /* renamed from: Q */
        public void mo1906Q(View view) {
        }

        /* renamed from: a */
        public void mo1930a(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        }

        /* renamed from: a */
        public WindowInsetsCompat mo1920a(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        /* renamed from: b */
        public WindowInsetsCompat mo1946b(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        /* renamed from: c */
        public void mo1955c(View view, boolean z) {
        }

        /* renamed from: d */
        public void mo1960d(View view, boolean z) {
        }

        /* renamed from: R */
        public boolean mo1907R(View view) {
            return false;
        }

        /* renamed from: e */
        public void mo1964e(View view, boolean z) {
            if (view instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view).setNestedScrollingEnabled(z);
            }
        }

        /* renamed from: S */
        public boolean mo1908S(View view) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).isNestedScrollingEnabled();
            }
            return false;
        }

        /* renamed from: T */
        public ColorStateList mo1909T(View view) {
            return C1046dh.m4645a(view);
        }

        /* renamed from: a */
        public void mo1925a(View view, ColorStateList colorStateList) {
            C1046dh.m4646a(view, colorStateList);
        }

        /* renamed from: a */
        public void mo1927a(View view, PorterDuff.Mode mode) {
            C1046dh.m4647a(view, mode);
        }

        /* renamed from: U */
        public PorterDuff.Mode mo1910U(View view) {
            return C1046dh.m4648b(view);
        }

        /* renamed from: a */
        private boolean m1206a(ScrollingView scrollingView, int i) {
            int computeHorizontalScrollOffset = scrollingView.computeHorizontalScrollOffset();
            int computeHorizontalScrollRange = scrollingView.computeHorizontalScrollRange() - scrollingView.computeHorizontalScrollExtent();
            if (computeHorizontalScrollRange == 0) {
                return false;
            }
            if (i < 0) {
                if (computeHorizontalScrollOffset <= 0) {
                    return false;
                }
                return true;
            } else if (computeHorizontalScrollOffset >= computeHorizontalScrollRange - 1) {
                return false;
            } else {
                return true;
            }
        }

        /* renamed from: b */
        private boolean m1208b(ScrollingView scrollingView, int i) {
            int computeVerticalScrollOffset = scrollingView.computeVerticalScrollOffset();
            int computeVerticalScrollRange = scrollingView.computeVerticalScrollRange() - scrollingView.computeVerticalScrollExtent();
            if (computeVerticalScrollRange == 0) {
                return false;
            }
            if (i < 0) {
                if (computeVerticalScrollOffset <= 0) {
                    return false;
                }
                return true;
            } else if (computeVerticalScrollOffset >= computeVerticalScrollRange - 1) {
                return false;
            } else {
                return true;
            }
        }

        /* renamed from: h */
        public boolean mo1973h(View view, int i) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).startNestedScroll(i);
            }
            return false;
        }

        /* renamed from: V */
        public void mo1911V(View view) {
            if (view instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view).stopNestedScroll();
            }
        }

        /* renamed from: W */
        public boolean mo1912W(View view) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).hasNestedScrollingParent();
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo1941a(View view, int i, int i2, int i3, int i4, int[] iArr) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedScroll(i, i2, i3, i4, iArr);
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo1942a(View view, int i, int i2, int[] iArr, int[] iArr2) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedPreScroll(i, i2, iArr, iArr2);
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo1939a(View view, float f, float f2, boolean z) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedFling(f, f2, z);
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo1938a(View view, float f, float f2) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).dispatchNestedPreFling(f, f2);
            }
            return false;
        }

        /* renamed from: X */
        public boolean mo1913X(View view) {
            return C1046dh.m4649c(view);
        }

        /* renamed from: a */
        public int mo1916a(int i, int i2) {
            return i | i2;
        }

        /* renamed from: Y */
        public float mo1914Y(View view) {
            return mo1903N(view) + mo1902M(view);
        }

        /* renamed from: Z */
        public boolean mo1915Z(View view) {
            return C1046dh.m4652f(view);
        }

        /* renamed from: aa */
        public boolean mo1944aa(View view) {
            return false;
        }

        /* renamed from: ab */
        public int mo1945ab(View view) {
            return 0;
        }

        /* renamed from: i */
        public void mo1976i(View view, int i) {
        }

        /* renamed from: a */
        public void mo1922a(View view, int i, int i2) {
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$b */
    static class C0308b extends C0307a {
        C0308b() {
        }

        /* renamed from: l */
        public boolean mo1982l(View view) {
            return C1047di.m4654a(view);
        }

        /* renamed from: a */
        public void mo1937a(ViewGroup viewGroup, boolean z) {
            C1047di.m4653a(viewGroup, z);
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$c */
    static class C0309c extends C0308b {
        C0309c() {
        }

        /* renamed from: a */
        public int mo1918a(View view) {
            return C1048dj.m4655a(view);
        }

        /* renamed from: c */
        public void mo1954c(View view, int i) {
            C1048dj.m4656a(view, i);
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$d */
    static class C0310d extends C0309c {
        C0310d() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public long mo1919a() {
            return C1049dk.m4660a();
        }

        /* renamed from: g */
        public float mo1968g(View view) {
            return C1049dk.m4657a(view);
        }

        /* renamed from: a */
        public void mo1924a(View view, int i, Paint paint) {
            C1049dk.m4662a(view, i, paint);
        }

        /* renamed from: h */
        public int mo1971h(View view) {
            return C1049dk.m4664b(view);
        }

        /* renamed from: a */
        public void mo1926a(View view, Paint paint) {
            mo1924a(view, mo1971h(view), paint);
            view.invalidate();
        }

        /* renamed from: a */
        public int mo1917a(int i, int i2, int i3) {
            return C1049dk.m4659a(i, i2, i3);
        }

        /* renamed from: m */
        public int mo1983m(View view) {
            return C1049dk.m4667c(view);
        }

        /* renamed from: n */
        public int mo1985n(View view) {
            return C1049dk.m4669d(view);
        }

        /* renamed from: o */
        public int mo1987o(View view) {
            return C1049dk.m4671e(view);
        }

        /* renamed from: v */
        public float mo1994v(View view) {
            return C1049dk.m4673f(view);
        }

        /* renamed from: w */
        public float mo1995w(View view) {
            return C1049dk.m4675g(view);
        }

        /* renamed from: b */
        public void mo1947b(View view, float f) {
            C1049dk.m4661a(view, f);
        }

        /* renamed from: c */
        public void mo1953c(View view, float f) {
            C1049dk.m4665b(view, f);
        }

        /* renamed from: d */
        public void mo1958d(View view, float f) {
            C1049dk.m4668c(view, f);
        }

        /* renamed from: i */
        public void mo1975i(View view, float f) {
            C1049dk.m4670d(view, f);
        }

        /* renamed from: j */
        public void mo1978j(View view, float f) {
            C1049dk.m4672e(view, f);
        }

        /* renamed from: a */
        public void mo1921a(View view, float f) {
            C1049dk.m4674f(view, f);
        }

        /* renamed from: e */
        public void mo1962e(View view, float f) {
            C1049dk.m4676g(view, f);
        }

        /* renamed from: f */
        public void mo1966f(View view, float f) {
            C1049dk.m4678h(view, f);
        }

        /* renamed from: g */
        public void mo1969g(View view, float f) {
            C1049dk.m4680i(view, f);
        }

        /* renamed from: h */
        public void mo1972h(View view, float f) {
            C1049dk.m4682j(view, f);
        }

        /* renamed from: k */
        public void mo1980k(View view, float f) {
            C1049dk.m4684k(view, f);
        }

        /* renamed from: l */
        public void mo1981l(View view, float f) {
            C1049dk.m4686l(view, f);
        }

        /* renamed from: x */
        public float mo1996x(View view) {
            return C1049dk.m4677h(view);
        }

        /* renamed from: y */
        public float mo1997y(View view) {
            return C1049dk.m4679i(view);
        }

        /* renamed from: z */
        public float mo1998z(View view) {
            return C1049dk.m4681j(view);
        }

        /* renamed from: A */
        public float mo1890A(View view) {
            return C1049dk.m4683k(view);
        }

        /* renamed from: B */
        public float mo1891B(View view) {
            return C1049dk.m4685l(view);
        }

        /* renamed from: C */
        public float mo1892C(View view) {
            return C1049dk.m4687m(view);
        }

        /* renamed from: D */
        public float mo1893D(View view) {
            return C1049dk.m4688n(view);
        }

        /* renamed from: H */
        public float mo1897H(View view) {
            return C1049dk.m4689o(view);
        }

        /* renamed from: I */
        public float mo1898I(View view) {
            return C1049dk.m4690p(view);
        }

        /* renamed from: Q */
        public void mo1906Q(View view) {
            C1049dk.m4691q(view);
        }

        /* renamed from: c */
        public void mo1955c(View view, boolean z) {
            C1049dk.m4663a(view, z);
        }

        /* renamed from: d */
        public void mo1960d(View view, boolean z) {
            C1049dk.m4666b(view, z);
        }

        /* renamed from: a */
        public int mo1916a(int i, int i2) {
            return C1049dk.m4658a(i, i2);
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$f */
    static class C0312f extends C0310d {

        /* renamed from: b */
        static Field f987b;

        /* renamed from: c */
        static boolean f988c = false;

        C0312f() {
        }

        /* renamed from: a */
        public boolean mo1940a(View view, int i) {
            return C1050dl.m4695a(view, i);
        }

        /* renamed from: b */
        public boolean mo1952b(View view, int i) {
            return C1050dl.m4698b(view, i);
        }

        /* renamed from: a */
        public void mo1932a(View view, AccessibilityEvent accessibilityEvent) {
            C1050dl.m4692a(view, accessibilityEvent);
        }

        /* renamed from: b */
        public void mo1949b(View view, AccessibilityEvent accessibilityEvent) {
            C1050dl.m4696b(view, accessibilityEvent);
        }

        /* renamed from: a */
        public void mo1931a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            C1050dl.m4697b(view, accessibilityNodeInfoCompat.getInfo());
        }

        /* renamed from: a */
        public void mo1929a(View view, @Nullable AccessibilityDelegateCompat accessibilityDelegateCompat) {
            C1050dl.m4693a(view, accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.mo1680a());
        }

        /* renamed from: b */
        public boolean mo1951b(View view) {
            boolean z = true;
            if (f988c) {
                return false;
            }
            if (f987b == null) {
                try {
                    f987b = View.class.getDeclaredField("mAccessibilityDelegate");
                    f987b.setAccessible(true);
                } catch (Throwable th) {
                    f988c = true;
                    return false;
                }
            }
            try {
                if (f987b.get(view) == null) {
                    z = false;
                }
                return z;
            } catch (Throwable th2) {
                f988c = true;
                return false;
            }
        }

        /* renamed from: G */
        public ViewPropertyAnimatorCompat mo1896G(View view) {
            if (this.f983a == null) {
                this.f983a = new WeakHashMap();
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) this.f983a.get(view);
            if (viewPropertyAnimatorCompat != null) {
                return viewPropertyAnimatorCompat;
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
            this.f983a.put(view, viewPropertyAnimatorCompat2);
            return viewPropertyAnimatorCompat2;
        }

        /* renamed from: b */
        public void mo1950b(View view, boolean z) {
            C1050dl.m4694a(view, z);
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$e */
    static class C0311e extends C0312f {
        C0311e() {
        }

        /* renamed from: aa */
        public boolean mo1944aa(View view) {
            return C1051dm.m4699a(view);
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$g */
    static class C0313g extends C0311e {
        C0313g() {
        }

        /* renamed from: c */
        public boolean mo1956c(View view) {
            return C1052dn.m4705a(view);
        }

        /* renamed from: a */
        public void mo1936a(View view, boolean z) {
            C1052dn.m4704a(view, z);
        }

        /* renamed from: d */
        public void mo1957d(View view) {
            C1052dn.m4707b(view);
        }

        /* renamed from: a */
        public void mo1923a(View view, int i, int i2, int i3, int i4) {
            C1052dn.m4701a(view, i, i2, i3, i4);
        }

        /* renamed from: a */
        public void mo1933a(View view, Runnable runnable) {
            C1052dn.m4702a(view, runnable);
        }

        /* renamed from: a */
        public void mo1934a(View view, Runnable runnable, long j) {
            C1052dn.m4703a(view, runnable, j);
        }

        /* renamed from: e */
        public int mo1961e(View view) {
            return C1052dn.m4708c(view);
        }

        /* renamed from: d */
        public void mo1959d(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            C1052dn.m4700a(view, i);
        }

        /* renamed from: a */
        public boolean mo1943a(View view, int i, Bundle bundle) {
            return C1052dn.m4706a(view, i, bundle);
        }

        /* renamed from: f */
        public AccessibilityNodeProviderCompat mo1965f(View view) {
            Object d = C1052dn.m4709d(view);
            if (d != null) {
                return new AccessibilityNodeProviderCompat(d);
            }
            return null;
        }

        /* renamed from: k */
        public ViewParent mo1979k(View view) {
            return C1052dn.m4710e(view);
        }

        /* renamed from: E */
        public int mo1894E(View view) {
            return C1052dn.m4711f(view);
        }

        /* renamed from: F */
        public int mo1895F(View view) {
            return C1052dn.m4712g(view);
        }

        /* renamed from: L */
        public void mo1901L(View view) {
            C1052dn.m4713h(view);
        }

        /* renamed from: P */
        public boolean mo1905P(View view) {
            return C1052dn.m4714i(view);
        }

        /* renamed from: u */
        public boolean mo1993u(View view) {
            return C1052dn.m4715j(view);
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$h */
    static class C0314h extends C0313g {
        C0314h() {
        }

        /* renamed from: i */
        public int mo1974i(View view) {
            return C1053do.m4716a(view);
        }

        /* renamed from: e */
        public void mo1963e(View view, int i) {
            C1053do.m4717a(view, i);
        }

        /* renamed from: a */
        public void mo1926a(View view, Paint paint) {
            C1053do.m4719a(view, paint);
        }

        /* renamed from: j */
        public int mo1977j(View view) {
            return C1053do.m4720b(view);
        }

        /* renamed from: f */
        public void mo1967f(View view, int i) {
            C1053do.m4721b(view, i);
        }

        /* renamed from: q */
        public int mo1989q(View view) {
            return C1053do.m4722c(view);
        }

        /* renamed from: r */
        public int mo1990r(View view) {
            return C1053do.m4723d(view);
        }

        /* renamed from: b */
        public void mo1948b(View view, int i, int i2, int i3, int i4) {
            C1053do.m4718a(view, i, i2, i3, i4);
        }

        /* renamed from: K */
        public int mo1900K(View view) {
            return C1053do.m4724e(view);
        }

        /* renamed from: R */
        public boolean mo1907R(View view) {
            return C1053do.m4725f(view);
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$i */
    static class C0315i extends C0314h {
        C0315i() {
        }

        /* renamed from: a */
        public void mo1928a(View view, Rect rect) {
            C1054dp.m4727a(view, rect);
        }

        /* renamed from: O */
        public Rect mo1904O(View view) {
            return C1054dp.m4726a(view);
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$j */
    static class C0316j extends C0315i {
        C0316j() {
        }

        /* renamed from: p */
        public int mo1988p(View view) {
            return C1055dq.m4728a(view);
        }

        /* renamed from: g */
        public void mo1970g(View view, int i) {
            C1055dq.m4729a(view, i);
        }

        /* renamed from: d */
        public void mo1959d(View view, int i) {
            C1052dn.m4700a(view, i);
        }

        /* renamed from: X */
        public boolean mo1913X(View view) {
            return C1055dq.m4730b(view);
        }

        /* renamed from: Z */
        public boolean mo1915Z(View view) {
            return C1055dq.m4731c(view);
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$k */
    static class C0317k extends C0316j {
        C0317k() {
        }

        /* renamed from: a */
        public void mo1935a(View view, String str) {
            C1056dr.m4738a(view, str);
        }

        /* renamed from: J */
        public String mo1899J(View view) {
            return C1056dr.m4733a(view);
        }

        /* renamed from: L */
        public void mo1901L(View view) {
            C1056dr.m4746b(view);
        }

        /* renamed from: m */
        public void mo1984m(View view, float f) {
            C1056dr.m4734a(view, f);
        }

        /* renamed from: M */
        public float mo1902M(View view) {
            return C1056dr.m4748c(view);
        }

        /* renamed from: n */
        public void mo1986n(View view, float f) {
            C1056dr.m4747b(view, f);
        }

        /* renamed from: N */
        public float mo1903N(View view) {
            return C1056dr.m4749d(view);
        }

        /* renamed from: a */
        public void mo1930a(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            C1056dr.m4737a(view, onApplyWindowInsetsListener);
        }

        /* renamed from: e */
        public void mo1964e(View view, boolean z) {
            C1056dr.m4739a(view, z);
        }

        /* renamed from: S */
        public boolean mo1908S(View view) {
            return C1056dr.m4752g(view);
        }

        /* renamed from: h */
        public boolean mo1973h(View view, int i) {
            return C1056dr.m4742a(view, i);
        }

        /* renamed from: V */
        public void mo1911V(View view) {
            C1056dr.m4753h(view);
        }

        /* renamed from: W */
        public boolean mo1912W(View view) {
            return C1056dr.m4754i(view);
        }

        /* renamed from: a */
        public boolean mo1941a(View view, int i, int i2, int i3, int i4, int[] iArr) {
            return C1056dr.m4743a(view, i, i2, i3, i4, iArr);
        }

        /* renamed from: a */
        public boolean mo1942a(View view, int i, int i2, int[] iArr, int[] iArr2) {
            return C1056dr.m4744a(view, i, i2, iArr, iArr2);
        }

        /* renamed from: a */
        public boolean mo1939a(View view, float f, float f2, boolean z) {
            return C1056dr.m4741a(view, f, f2, z);
        }

        /* renamed from: a */
        public boolean mo1938a(View view, float f, float f2) {
            return C1056dr.m4740a(view, f, f2);
        }

        /* renamed from: T */
        public ColorStateList mo1909T(View view) {
            return C1056dr.m4750e(view);
        }

        /* renamed from: a */
        public void mo1925a(View view, ColorStateList colorStateList) {
            C1056dr.m4735a(view, colorStateList);
        }

        /* renamed from: a */
        public void mo1927a(View view, PorterDuff.Mode mode) {
            C1056dr.m4736a(view, mode);
        }

        /* renamed from: U */
        public PorterDuff.Mode mo1910U(View view) {
            return C1056dr.m4751f(view);
        }

        /* renamed from: a */
        public WindowInsetsCompat mo1920a(View view, WindowInsetsCompat windowInsetsCompat) {
            return C1056dr.m4732a(view, windowInsetsCompat);
        }

        /* renamed from: b */
        public WindowInsetsCompat mo1946b(View view, WindowInsetsCompat windowInsetsCompat) {
            return C1056dr.m4745b(view, windowInsetsCompat);
        }

        /* renamed from: Y */
        public float mo1914Y(View view) {
            return C1056dr.m4755j(view);
        }
    }

    /* renamed from: android.support.v4.view.ViewCompat$l */
    static class C0318l extends C0317k {
        C0318l() {
        }

        /* renamed from: i */
        public void mo1976i(View view, int i) {
            C1058ds.m4757a(view, i);
        }

        /* renamed from: a */
        public void mo1922a(View view, int i, int i2) {
            C1058ds.m4758a(view, i, i2);
        }

        /* renamed from: ab */
        public int mo1945ab(View view) {
            return C1058ds.m4756a(view);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            f982a = new C0318l();
        } else if (i >= 21) {
            f982a = new C0317k();
        } else if (i >= 19) {
            f982a = new C0316j();
        } else if (i >= 17) {
            f982a = new C0314h();
        } else if (i >= 16) {
            f982a = new C0313g();
        } else if (i >= 15) {
            f982a = new C0311e();
        } else if (i >= 14) {
            f982a = new C0312f();
        } else if (i >= 11) {
            f982a = new C0310d();
        } else if (i >= 9) {
            f982a = new C0309c();
        } else if (i >= 7) {
            f982a = new C0308b();
        } else {
            f982a = new C0307a();
        }
    }

    public static boolean canScrollHorizontally(View view, int i) {
        return f982a.mo1940a(view, i);
    }

    public static boolean canScrollVertically(View view, int i) {
        return f982a.mo1952b(view, i);
    }

    public static int getOverScrollMode(View view) {
        return f982a.mo1918a(view);
    }

    public static void setOverScrollMode(View view, int i) {
        f982a.mo1954c(view, i);
    }

    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        f982a.mo1932a(view, accessibilityEvent);
    }

    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        f982a.mo1949b(view, accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        f982a.mo1931a(view, accessibilityNodeInfoCompat);
    }

    public static void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        f982a.mo1929a(view, accessibilityDelegateCompat);
    }

    public static boolean hasAccessibilityDelegate(View view) {
        return f982a.mo1951b(view);
    }

    public static boolean hasTransientState(View view) {
        return f982a.mo1956c(view);
    }

    public static void setHasTransientState(View view, boolean z) {
        f982a.mo1936a(view, z);
    }

    public static void postInvalidateOnAnimation(View view) {
        f982a.mo1957d(view);
    }

    public static void postInvalidateOnAnimation(View view, int i, int i2, int i3, int i4) {
        f982a.mo1923a(view, i, i2, i3, i4);
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        f982a.mo1933a(view, runnable);
    }

    public static void postOnAnimationDelayed(View view, Runnable runnable, long j) {
        f982a.mo1934a(view, runnable, j);
    }

    public static int getImportantForAccessibility(View view) {
        return f982a.mo1961e(view);
    }

    public static void setImportantForAccessibility(View view, int i) {
        f982a.mo1959d(view, i);
    }

    public static boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return f982a.mo1943a(view, i, bundle);
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        return f982a.mo1965f(view);
    }

    public static float getAlpha(View view) {
        return f982a.mo1968g(view);
    }

    public static void setLayerType(View view, int i, Paint paint) {
        f982a.mo1924a(view, i, paint);
    }

    public static int getLayerType(View view) {
        return f982a.mo1971h(view);
    }

    public static int getLabelFor(View view) {
        return f982a.mo1974i(view);
    }

    public static void setLabelFor(View view, @IdRes int i) {
        f982a.mo1963e(view, i);
    }

    public static void setLayerPaint(View view, Paint paint) {
        f982a.mo1926a(view, paint);
    }

    public static int getLayoutDirection(View view) {
        return f982a.mo1977j(view);
    }

    public static void setLayoutDirection(View view, int i) {
        f982a.mo1967f(view, i);
    }

    public static ViewParent getParentForAccessibility(View view) {
        return f982a.mo1979k(view);
    }

    public static boolean isOpaque(View view) {
        return f982a.mo1982l(view);
    }

    public static int resolveSizeAndState(int i, int i2, int i3) {
        return f982a.mo1917a(i, i2, i3);
    }

    public static int getMeasuredWidthAndState(View view) {
        return f982a.mo1983m(view);
    }

    public static int getMeasuredHeightAndState(View view) {
        return f982a.mo1985n(view);
    }

    public static int getMeasuredState(View view) {
        return f982a.mo1987o(view);
    }

    public static int combineMeasuredStates(int i, int i2) {
        return f982a.mo1916a(i, i2);
    }

    public static int getAccessibilityLiveRegion(View view) {
        return f982a.mo1988p(view);
    }

    public static void setAccessibilityLiveRegion(View view, int i) {
        f982a.mo1970g(view, i);
    }

    public static int getPaddingStart(View view) {
        return f982a.mo1989q(view);
    }

    public static int getPaddingEnd(View view) {
        return f982a.mo1990r(view);
    }

    public static void setPaddingRelative(View view, int i, int i2, int i3, int i4) {
        f982a.mo1948b(view, i, i2, i3, i4);
    }

    public static void dispatchStartTemporaryDetach(View view) {
        f982a.mo1991s(view);
    }

    public static void dispatchFinishTemporaryDetach(View view) {
        f982a.mo1992t(view);
    }

    public static float getTranslationX(View view) {
        return f982a.mo1994v(view);
    }

    public static float getTranslationY(View view) {
        return f982a.mo1995w(view);
    }

    public static int getMinimumWidth(View view) {
        return f982a.mo1894E(view);
    }

    public static int getMinimumHeight(View view) {
        return f982a.mo1895F(view);
    }

    public static ViewPropertyAnimatorCompat animate(View view) {
        return f982a.mo1896G(view);
    }

    public static void setTranslationX(View view, float f) {
        f982a.mo1947b(view, f);
    }

    public static void setTranslationY(View view, float f) {
        f982a.mo1953c(view, f);
    }

    public static void setAlpha(View view, @FloatRange(from = 0.0d, mo4to = 1.0d) float f) {
        f982a.mo1958d(view, f);
    }

    public static void setX(View view, float f) {
        f982a.mo1975i(view, f);
    }

    public static void setY(View view, float f) {
        f982a.mo1978j(view, f);
    }

    public static void setRotation(View view, float f) {
        f982a.mo1921a(view, f);
    }

    public static void setRotationX(View view, float f) {
        f982a.mo1962e(view, f);
    }

    public static void setRotationY(View view, float f) {
        f982a.mo1966f(view, f);
    }

    public static void setScaleX(View view, float f) {
        f982a.mo1969g(view, f);
    }

    public static void setScaleY(View view, float f) {
        f982a.mo1972h(view, f);
    }

    public static float getPivotX(View view) {
        return f982a.mo1897H(view);
    }

    public static void setPivotX(View view, float f) {
        f982a.mo1980k(view, f);
    }

    public static float getPivotY(View view) {
        return f982a.mo1898I(view);
    }

    public static void setPivotY(View view, float f) {
        f982a.mo1981l(view, f);
    }

    public static float getRotation(View view) {
        return f982a.mo1998z(view);
    }

    public static float getRotationX(View view) {
        return f982a.mo1890A(view);
    }

    public static float getRotationY(View view) {
        return f982a.mo1891B(view);
    }

    public static float getScaleX(View view) {
        return f982a.mo1892C(view);
    }

    public static float getScaleY(View view) {
        return f982a.mo1893D(view);
    }

    public static float getX(View view) {
        return f982a.mo1996x(view);
    }

    public static float getY(View view) {
        return f982a.mo1997y(view);
    }

    public static void setElevation(View view, float f) {
        f982a.mo1984m(view, f);
    }

    public static float getElevation(View view) {
        return f982a.mo1902M(view);
    }

    public static void setTranslationZ(View view, float f) {
        f982a.mo1986n(view, f);
    }

    public static float getTranslationZ(View view) {
        return f982a.mo1903N(view);
    }

    public static void setTransitionName(View view, String str) {
        f982a.mo1935a(view, str);
    }

    public static String getTransitionName(View view) {
        return f982a.mo1899J(view);
    }

    public static int getWindowSystemUiVisibility(View view) {
        return f982a.mo1900K(view);
    }

    public static void requestApplyInsets(View view) {
        f982a.mo1901L(view);
    }

    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
        f982a.mo1937a(viewGroup, z);
    }

    public static boolean getFitsSystemWindows(View view) {
        return f982a.mo1905P(view);
    }

    public static void setFitsSystemWindows(View view, boolean z) {
        f982a.mo1950b(view, z);
    }

    public static void jumpDrawablesToCurrentState(View view) {
        f982a.mo1906Q(view);
    }

    public static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        f982a.mo1930a(view, onApplyWindowInsetsListener);
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return f982a.mo1920a(view, windowInsetsCompat);
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return f982a.mo1946b(view, windowInsetsCompat);
    }

    public static void setSaveFromParentEnabled(View view, boolean z) {
        f982a.mo1955c(view, z);
    }

    public static void setActivated(View view, boolean z) {
        f982a.mo1960d(view, z);
    }

    public static boolean hasOverlappingRendering(View view) {
        return f982a.mo1993u(view);
    }

    public static boolean isPaddingRelative(View view) {
        return f982a.mo1907R(view);
    }

    public static ColorStateList getBackgroundTintList(View view) {
        return f982a.mo1909T(view);
    }

    public static void setBackgroundTintList(View view, ColorStateList colorStateList) {
        f982a.mo1925a(view, colorStateList);
    }

    public static PorterDuff.Mode getBackgroundTintMode(View view) {
        return f982a.mo1910U(view);
    }

    public static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
        f982a.mo1927a(view, mode);
    }

    public static void setNestedScrollingEnabled(View view, boolean z) {
        f982a.mo1964e(view, z);
    }

    public static boolean isNestedScrollingEnabled(View view) {
        return f982a.mo1908S(view);
    }

    public static boolean startNestedScroll(View view, int i) {
        return f982a.mo1973h(view, i);
    }

    public static void stopNestedScroll(View view) {
        f982a.mo1911V(view);
    }

    public static boolean hasNestedScrollingParent(View view) {
        return f982a.mo1912W(view);
    }

    public static boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr) {
        return f982a.mo1941a(view, i, i2, i3, i4, iArr);
    }

    public static boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2) {
        return f982a.mo1942a(view, i, i2, iArr, iArr2);
    }

    public static boolean dispatchNestedFling(View view, float f, float f2, boolean z) {
        return f982a.mo1939a(view, f, f2, z);
    }

    public static boolean dispatchNestedPreFling(View view, float f, float f2) {
        return f982a.mo1938a(view, f, f2);
    }

    public static boolean isLaidOut(View view) {
        return f982a.mo1913X(view);
    }

    public static float getZ(View view) {
        return f982a.mo1914Y(view);
    }

    public static void offsetTopAndBottom(View view, int i) {
        view.offsetTopAndBottom(i);
        if (i != 0 && Build.VERSION.SDK_INT < 11) {
            view.invalidate();
        }
    }

    public static void offsetLeftAndRight(View view, int i) {
        view.offsetLeftAndRight(i);
        if (i != 0 && Build.VERSION.SDK_INT < 11) {
            view.invalidate();
        }
    }

    public static void setClipBounds(View view, Rect rect) {
        f982a.mo1928a(view, rect);
    }

    public static Rect getClipBounds(View view) {
        return f982a.mo1904O(view);
    }

    public static boolean isAttachedToWindow(View view) {
        return f982a.mo1915Z(view);
    }

    public static boolean hasOnClickListeners(View view) {
        return f982a.mo1944aa(view);
    }

    public static void setScrollIndicators(@NonNull View view, int i) {
        f982a.mo1976i(view, i);
    }

    public static void setScrollIndicators(@NonNull View view, int i, int i2) {
        f982a.mo1922a(view, i, i2);
    }

    public static int getScrollIndicators(@NonNull View view) {
        return f982a.mo1945ab(view);
    }
}
