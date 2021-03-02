package android.support.p001v4.view;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

/* renamed from: android.support.v4.view.ViewParentCompat */
public class ViewParentCompat {

    /* renamed from: a */
    static final C0342b f1066a;

    /* renamed from: android.support.v4.view.ViewParentCompat$b */
    interface C0342b {
        /* renamed from: a */
        void mo2090a(ViewParent viewParent, View view);

        /* renamed from: a */
        void mo2091a(ViewParent viewParent, View view, int i, int i2, int i3, int i4);

        /* renamed from: a */
        void mo2092a(ViewParent viewParent, View view, int i, int i2, int[] iArr);

        /* renamed from: a */
        boolean mo2093a(ViewParent viewParent, View view, float f, float f2);

        /* renamed from: a */
        boolean mo2094a(ViewParent viewParent, View view, float f, float f2, boolean z);

        /* renamed from: a */
        boolean mo2095a(ViewParent viewParent, View view, View view2, int i);

        /* renamed from: a */
        boolean mo2089a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent);

        /* renamed from: b */
        void mo2096b(ViewParent viewParent, View view, View view2, int i);

        /* renamed from: c */
        void mo2097c(ViewParent viewParent, View view, View view2, int i);
    }

    /* renamed from: android.support.v4.view.ViewParentCompat$e */
    static class C0345e implements C0342b {
        C0345e() {
        }

        /* renamed from: a */
        public boolean mo2089a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
            if (view == null) {
                return false;
            }
            ((AccessibilityManager) view.getContext().getSystemService("accessibility")).sendAccessibilityEvent(accessibilityEvent);
            return true;
        }

        /* renamed from: a */
        public boolean mo2095a(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        /* renamed from: b */
        public void mo2096b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        /* renamed from: a */
        public void mo2090a(ViewParent viewParent, View view) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onStopNestedScroll(view);
            }
        }

        /* renamed from: a */
        public void mo2091a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        /* renamed from: a */
        public void mo2092a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        /* renamed from: a */
        public boolean mo2094a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo2093a(ViewParent viewParent, View view, float f, float f2) {
            if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }

        /* renamed from: c */
        public void mo2097c(ViewParent viewParent, View view, View view2, int i) {
        }
    }

    /* renamed from: android.support.v4.view.ViewParentCompat$a */
    static class C0341a extends C0345e {
        C0341a() {
        }

        /* renamed from: a */
        public boolean mo2089a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
            return ViewParentCompatICS.requestSendAccessibilityEvent(viewParent, view, accessibilityEvent);
        }
    }

    /* renamed from: android.support.v4.view.ViewParentCompat$c */
    static class C0343c extends C0341a {
        C0343c() {
        }

        /* renamed from: c */
        public void mo2097c(ViewParent viewParent, View view, View view2, int i) {
            C1065dz.m4768a(viewParent, view, view2, i);
        }
    }

    /* renamed from: android.support.v4.view.ViewParentCompat$d */
    static class C0344d extends C0343c {
        C0344d() {
        }

        /* renamed from: a */
        public boolean mo2095a(ViewParent viewParent, View view, View view2, int i) {
            return C1067ea.m4775a(viewParent, view, view2, i);
        }

        /* renamed from: b */
        public void mo2096b(ViewParent viewParent, View view, View view2, int i) {
            C1067ea.m4776b(viewParent, view, view2, i);
        }

        /* renamed from: a */
        public void mo2090a(ViewParent viewParent, View view) {
            C1067ea.m4770a(viewParent, view);
        }

        /* renamed from: a */
        public void mo2091a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            C1067ea.m4771a(viewParent, view, i, i2, i3, i4);
        }

        /* renamed from: a */
        public void mo2092a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            C1067ea.m4772a(viewParent, view, i, i2, iArr);
        }

        /* renamed from: a */
        public boolean mo2094a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return C1067ea.m4774a(viewParent, view, f, f2, z);
        }

        /* renamed from: a */
        public boolean mo2093a(ViewParent viewParent, View view, float f, float f2) {
            return C1067ea.m4773a(viewParent, view, f, f2);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f1066a = new C0344d();
        } else if (i >= 19) {
            f1066a = new C0343c();
        } else if (i >= 14) {
            f1066a = new C0341a();
        } else {
            f1066a = new C0345e();
        }
    }

    private ViewParentCompat() {
    }

    public static boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return f1066a.mo2089a(viewParent, view, accessibilityEvent);
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i) {
        return f1066a.mo2095a(viewParent, view, view2, i);
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i) {
        f1066a.mo2096b(viewParent, view, view2, i);
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view) {
        f1066a.mo2090a(viewParent, view);
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        f1066a.mo2091a(viewParent, view, i, i2, i3, i4);
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        f1066a.mo2092a(viewParent, view, i, i2, iArr);
    }

    public static boolean onNestedFling(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f1066a.mo2094a(viewParent, view, f, f2, z);
    }

    public static boolean onNestedPreFling(ViewParent viewParent, View view, float f, float f2) {
        return f1066a.mo2093a(viewParent, view, f, f2);
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i) {
        f1066a.mo2097c(viewParent, view, view2, i);
    }
}
