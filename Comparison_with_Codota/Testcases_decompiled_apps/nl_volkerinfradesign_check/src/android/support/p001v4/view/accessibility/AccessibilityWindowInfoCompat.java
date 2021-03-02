package android.support.p001v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build;

/* renamed from: android.support.v4.view.accessibility.AccessibilityWindowInfoCompat */
public class AccessibilityWindowInfoCompat {
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SYSTEM = 3;

    /* renamed from: a */
    private static final C0387b f1097a;

    /* renamed from: b */
    private Object f1098b;

    /* renamed from: android.support.v4.view.accessibility.AccessibilityWindowInfoCompat$b */
    interface C0387b {
        /* renamed from: a */
        Object mo2577a();

        /* renamed from: a */
        Object mo2578a(Object obj);

        /* renamed from: a */
        Object mo2579a(Object obj, int i);

        /* renamed from: a */
        void mo2580a(Object obj, Rect rect);

        /* renamed from: b */
        int mo2581b(Object obj);

        /* renamed from: c */
        int mo2582c(Object obj);

        /* renamed from: d */
        Object mo2583d(Object obj);

        /* renamed from: e */
        Object mo2584e(Object obj);

        /* renamed from: f */
        int mo2585f(Object obj);

        /* renamed from: g */
        boolean mo2586g(Object obj);

        /* renamed from: h */
        boolean mo2587h(Object obj);

        /* renamed from: i */
        boolean mo2588i(Object obj);

        /* renamed from: j */
        int mo2589j(Object obj);

        /* renamed from: k */
        void mo2590k(Object obj);
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityWindowInfoCompat$c */
    static class C0388c implements C0387b {
        private C0388c() {
        }

        /* renamed from: a */
        public Object mo2577a() {
            return null;
        }

        /* renamed from: a */
        public Object mo2578a(Object obj) {
            return null;
        }

        /* renamed from: b */
        public int mo2581b(Object obj) {
            return -1;
        }

        /* renamed from: c */
        public int mo2582c(Object obj) {
            return -1;
        }

        /* renamed from: d */
        public Object mo2583d(Object obj) {
            return null;
        }

        /* renamed from: e */
        public Object mo2584e(Object obj) {
            return null;
        }

        /* renamed from: f */
        public int mo2585f(Object obj) {
            return -1;
        }

        /* renamed from: a */
        public void mo2580a(Object obj, Rect rect) {
        }

        /* renamed from: g */
        public boolean mo2586g(Object obj) {
            return true;
        }

        /* renamed from: h */
        public boolean mo2587h(Object obj) {
            return true;
        }

        /* renamed from: i */
        public boolean mo2588i(Object obj) {
            return true;
        }

        /* renamed from: j */
        public int mo2589j(Object obj) {
            return 0;
        }

        /* renamed from: a */
        public Object mo2579a(Object obj, int i) {
            return null;
        }

        /* renamed from: k */
        public void mo2590k(Object obj) {
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityWindowInfoCompat$a */
    static class C0386a extends C0388c {
        private C0386a() {
            super();
        }

        /* renamed from: a */
        public Object mo2577a() {
            return C1102ew.m5013a();
        }

        /* renamed from: a */
        public Object mo2578a(Object obj) {
            return C1102ew.m5014a(obj);
        }

        /* renamed from: b */
        public int mo2581b(Object obj) {
            return C1102ew.m5017b(obj);
        }

        /* renamed from: c */
        public int mo2582c(Object obj) {
            return C1102ew.m5018c(obj);
        }

        /* renamed from: d */
        public Object mo2583d(Object obj) {
            return C1102ew.m5019d(obj);
        }

        /* renamed from: e */
        public Object mo2584e(Object obj) {
            return C1102ew.m5020e(obj);
        }

        /* renamed from: f */
        public int mo2585f(Object obj) {
            return C1102ew.m5021f(obj);
        }

        /* renamed from: a */
        public void mo2580a(Object obj, Rect rect) {
            C1102ew.m5016a(obj, rect);
        }

        /* renamed from: g */
        public boolean mo2586g(Object obj) {
            return C1102ew.m5022g(obj);
        }

        /* renamed from: h */
        public boolean mo2587h(Object obj) {
            return C1102ew.m5023h(obj);
        }

        /* renamed from: i */
        public boolean mo2588i(Object obj) {
            return C1102ew.m5024i(obj);
        }

        /* renamed from: j */
        public int mo2589j(Object obj) {
            return C1102ew.m5025j(obj);
        }

        /* renamed from: a */
        public Object mo2579a(Object obj, int i) {
            return C1102ew.m5015a(obj, i);
        }

        /* renamed from: k */
        public void mo2590k(Object obj) {
            C1102ew.m5026k(obj);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f1097a = new C0386a();
        } else {
            f1097a = new C0388c();
        }
    }

    /* renamed from: a */
    static AccessibilityWindowInfoCompat m2328a(Object obj) {
        if (obj != null) {
            return new AccessibilityWindowInfoCompat(obj);
        }
        return null;
    }

    private AccessibilityWindowInfoCompat(Object obj) {
        this.f1098b = obj;
    }

    public int getType() {
        return f1097a.mo2581b(this.f1098b);
    }

    public int getLayer() {
        return f1097a.mo2582c(this.f1098b);
    }

    public AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.m1800a(f1097a.mo2583d(this.f1098b));
    }

    public AccessibilityWindowInfoCompat getParent() {
        return m2328a(f1097a.mo2584e(this.f1098b));
    }

    public int getId() {
        return f1097a.mo2585f(this.f1098b);
    }

    public void getBoundsInScreen(Rect rect) {
        f1097a.mo2580a(this.f1098b, rect);
    }

    public boolean isActive() {
        return f1097a.mo2586g(this.f1098b);
    }

    public boolean isFocused() {
        return f1097a.mo2587h(this.f1098b);
    }

    public boolean isAccessibilityFocused() {
        return f1097a.mo2588i(this.f1098b);
    }

    public int getChildCount() {
        return f1097a.mo2589j(this.f1098b);
    }

    public AccessibilityWindowInfoCompat getChild(int i) {
        return m2328a(f1097a.mo2579a(this.f1098b, i));
    }

    public static AccessibilityWindowInfoCompat obtain() {
        return m2328a(f1097a.mo2577a());
    }

    public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat accessibilityWindowInfoCompat) {
        return m2328a(f1097a.mo2578a(accessibilityWindowInfoCompat.f1098b));
    }

    public void recycle() {
        f1097a.mo2590k(this.f1098b);
    }

    public int hashCode() {
        if (this.f1098b == null) {
            return 0;
        }
        return this.f1098b.hashCode();
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
        AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = (AccessibilityWindowInfoCompat) obj;
        if (this.f1098b == null) {
            if (accessibilityWindowInfoCompat.f1098b != null) {
                return false;
            }
            return true;
        } else if (!this.f1098b.equals(accessibilityWindowInfoCompat.f1098b)) {
            return false;
        } else {
            return true;
        }
    }

    public String toString() {
        boolean z;
        boolean z2 = true;
        StringBuilder sb = new StringBuilder();
        Rect rect = new Rect();
        getBoundsInScreen(rect);
        sb.append("AccessibilityWindowInfo[");
        sb.append("id=").append(getId());
        sb.append(", type=").append(m2329a(getType()));
        sb.append(", layer=").append(getLayer());
        sb.append(", bounds=").append(rect);
        sb.append(", focused=").append(isFocused());
        sb.append(", active=").append(isActive());
        StringBuilder append = sb.append(", hasParent=");
        if (getParent() != null) {
            z = true;
        } else {
            z = false;
        }
        append.append(z);
        StringBuilder append2 = sb.append(", hasChildren=");
        if (getChildCount() <= 0) {
            z2 = false;
        }
        append2.append(z2);
        sb.append(']');
        return sb.toString();
    }

    /* renamed from: a */
    private static String m2329a(int i) {
        switch (i) {
            case 1:
                return "TYPE_APPLICATION";
            case 2:
                return "TYPE_INPUT_METHOD";
            case 3:
                return "TYPE_SYSTEM";
            case 4:
                return "TYPE_ACCESSIBILITY_OVERLAY";
            default:
                return "<UNKNOWN>";
        }
    }
}
