package android.support.p000v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build;

/* renamed from: android.support.v4.view.accessibility.AccessibilityWindowInfoCompat */
public class AccessibilityWindowInfoCompat {
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SYSTEM = 3;

    /* renamed from: a */
    private static final AccessibilityWindowInfoImpl f1373a;

    /* renamed from: b */
    private Object f1374b;

    /* renamed from: android.support.v4.view.accessibility.AccessibilityWindowInfoCompat$AccessibilityWindowInfoApi21Impl */
    class AccessibilityWindowInfoApi21Impl extends AccessibilityWindowInfoStubImpl {
        private AccessibilityWindowInfoApi21Impl() {
            super();
        }

        public void getBoundsInScreen(Object obj, Rect rect) {
            AccessibilityWindowInfoCompatApi21.getBoundsInScreen(obj, rect);
        }

        public Object getChild(Object obj, int i) {
            return AccessibilityWindowInfoCompatApi21.getChild(obj, i);
        }

        public int getChildCount(Object obj) {
            return AccessibilityWindowInfoCompatApi21.getChildCount(obj);
        }

        public int getId(Object obj) {
            return AccessibilityWindowInfoCompatApi21.getId(obj);
        }

        public int getLayer(Object obj) {
            return AccessibilityWindowInfoCompatApi21.getLayer(obj);
        }

        public Object getParent(Object obj) {
            return AccessibilityWindowInfoCompatApi21.getParent(obj);
        }

        public Object getRoot(Object obj) {
            return AccessibilityWindowInfoCompatApi21.getRoot(obj);
        }

        public int getType(Object obj) {
            return AccessibilityWindowInfoCompatApi21.getType(obj);
        }

        public boolean isAccessibilityFocused(Object obj) {
            return AccessibilityWindowInfoCompatApi21.isAccessibilityFocused(obj);
        }

        public boolean isActive(Object obj) {
            return AccessibilityWindowInfoCompatApi21.isActive(obj);
        }

        public boolean isFocused(Object obj) {
            return AccessibilityWindowInfoCompatApi21.isFocused(obj);
        }

        public Object obtain() {
            return AccessibilityWindowInfoCompatApi21.obtain();
        }

        public Object obtain(Object obj) {
            return AccessibilityWindowInfoCompatApi21.obtain(obj);
        }

        public void recycle(Object obj) {
            AccessibilityWindowInfoCompatApi21.recycle(obj);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityWindowInfoCompat$AccessibilityWindowInfoImpl */
    interface AccessibilityWindowInfoImpl {
        void getBoundsInScreen(Object obj, Rect rect);

        Object getChild(Object obj, int i);

        int getChildCount(Object obj);

        int getId(Object obj);

        int getLayer(Object obj);

        Object getParent(Object obj);

        Object getRoot(Object obj);

        int getType(Object obj);

        boolean isAccessibilityFocused(Object obj);

        boolean isActive(Object obj);

        boolean isFocused(Object obj);

        Object obtain();

        Object obtain(Object obj);

        void recycle(Object obj);
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityWindowInfoCompat$AccessibilityWindowInfoStubImpl */
    class AccessibilityWindowInfoStubImpl implements AccessibilityWindowInfoImpl {
        private AccessibilityWindowInfoStubImpl() {
        }

        public void getBoundsInScreen(Object obj, Rect rect) {
        }

        public Object getChild(Object obj, int i) {
            return null;
        }

        public int getChildCount(Object obj) {
            return 0;
        }

        public int getId(Object obj) {
            return -1;
        }

        public int getLayer(Object obj) {
            return -1;
        }

        public Object getParent(Object obj) {
            return null;
        }

        public Object getRoot(Object obj) {
            return null;
        }

        public int getType(Object obj) {
            return -1;
        }

        public boolean isAccessibilityFocused(Object obj) {
            return true;
        }

        public boolean isActive(Object obj) {
            return true;
        }

        public boolean isFocused(Object obj) {
            return true;
        }

        public Object obtain() {
            return null;
        }

        public Object obtain(Object obj) {
            return null;
        }

        public void recycle(Object obj) {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f1373a = new AccessibilityWindowInfoApi21Impl();
        } else {
            f1373a = new AccessibilityWindowInfoStubImpl();
        }
    }

    private AccessibilityWindowInfoCompat(Object obj) {
        this.f1374b = obj;
    }

    /* renamed from: a */
    static AccessibilityWindowInfoCompat m985a(Object obj) {
        if (obj != null) {
            return new AccessibilityWindowInfoCompat(obj);
        }
        return null;
    }

    /* renamed from: a */
    private static String m986a(int i) {
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

    public static AccessibilityWindowInfoCompat obtain() {
        return m985a(f1373a.obtain());
    }

    public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat accessibilityWindowInfoCompat) {
        return m985a(f1373a.obtain(accessibilityWindowInfoCompat.f1374b));
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
        return this.f1374b == null ? accessibilityWindowInfoCompat.f1374b == null : this.f1374b.equals(accessibilityWindowInfoCompat.f1374b);
    }

    public void getBoundsInScreen(Rect rect) {
        f1373a.getBoundsInScreen(this.f1374b, rect);
    }

    public AccessibilityWindowInfoCompat getChild(int i) {
        return m985a(f1373a.getChild(this.f1374b, i));
    }

    public int getChildCount() {
        return f1373a.getChildCount(this.f1374b);
    }

    public int getId() {
        return f1373a.getId(this.f1374b);
    }

    public int getLayer() {
        return f1373a.getLayer(this.f1374b);
    }

    public AccessibilityWindowInfoCompat getParent() {
        return m985a(f1373a.getParent(this.f1374b));
    }

    public AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.m958a(f1373a.getRoot(this.f1374b));
    }

    public int getType() {
        return f1373a.getType(this.f1374b);
    }

    public int hashCode() {
        if (this.f1374b == null) {
            return 0;
        }
        return this.f1374b.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return f1373a.isAccessibilityFocused(this.f1374b);
    }

    public boolean isActive() {
        return f1373a.isActive(this.f1374b);
    }

    public boolean isFocused() {
        return f1373a.isFocused(this.f1374b);
    }

    public void recycle() {
        f1373a.recycle(this.f1374b);
    }

    public String toString() {
        boolean z = true;
        StringBuilder sb = new StringBuilder();
        Rect rect = new Rect();
        getBoundsInScreen(rect);
        sb.append("AccessibilityWindowInfo[");
        sb.append("id=").append(getId());
        sb.append(", type=").append(m986a(getType()));
        sb.append(", layer=").append(getLayer());
        sb.append(", bounds=").append(rect);
        sb.append(", focused=").append(isFocused());
        sb.append(", active=").append(isActive());
        sb.append(", hasParent=").append(getParent() != null);
        StringBuilder append = sb.append(", hasChildren=");
        if (getChildCount() <= 0) {
            z = false;
        }
        append.append(z);
        sb.append(']');
        return sb.toString();
    }
}
