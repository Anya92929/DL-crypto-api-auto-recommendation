package android.support.p001v4.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.ViewGroupCompat */
public class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    /* renamed from: a */
    static final C0327c f990a;

    /* renamed from: android.support.v4.view.ViewGroupCompat$c */
    interface C0327c {
        /* renamed from: a */
        int mo2003a(ViewGroup viewGroup);

        /* renamed from: a */
        void mo2004a(ViewGroup viewGroup, int i);

        /* renamed from: a */
        void mo2001a(ViewGroup viewGroup, boolean z);

        /* renamed from: a */
        boolean mo2002a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        /* renamed from: b */
        void mo2005b(ViewGroup viewGroup, boolean z);

        /* renamed from: b */
        boolean mo2006b(ViewGroup viewGroup);

        /* renamed from: c */
        int mo2007c(ViewGroup viewGroup);
    }

    /* renamed from: android.support.v4.view.ViewGroupCompat$f */
    static class C0330f implements C0327c {
        C0330f() {
        }

        /* renamed from: a */
        public boolean mo2002a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return true;
        }

        /* renamed from: a */
        public void mo2001a(ViewGroup viewGroup, boolean z) {
        }

        /* renamed from: a */
        public int mo2003a(ViewGroup viewGroup) {
            return 0;
        }

        /* renamed from: a */
        public void mo2004a(ViewGroup viewGroup, int i) {
        }

        /* renamed from: b */
        public void mo2005b(ViewGroup viewGroup, boolean z) {
        }

        /* renamed from: b */
        public boolean mo2006b(ViewGroup viewGroup) {
            return false;
        }

        /* renamed from: c */
        public int mo2007c(ViewGroup viewGroup) {
            if (viewGroup instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewGroup).getNestedScrollAxes();
            }
            return 0;
        }
    }

    /* renamed from: android.support.v4.view.ViewGroupCompat$a */
    static class C0325a extends C0330f {
        C0325a() {
        }

        /* renamed from: a */
        public void mo2001a(ViewGroup viewGroup, boolean z) {
            C1061dv.m4761a(viewGroup, z);
        }
    }

    /* renamed from: android.support.v4.view.ViewGroupCompat$b */
    static class C0326b extends C0325a {
        C0326b() {
        }

        /* renamed from: a */
        public boolean mo2002a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return C1062dw.m4762a(viewGroup, view, accessibilityEvent);
        }
    }

    /* renamed from: android.support.v4.view.ViewGroupCompat$d */
    static class C0328d extends C0326b {
        C0328d() {
        }

        /* renamed from: a */
        public int mo2003a(ViewGroup viewGroup) {
            return C1063dx.m4763a(viewGroup);
        }

        /* renamed from: a */
        public void mo2004a(ViewGroup viewGroup, int i) {
            C1063dx.m4764a(viewGroup, i);
        }
    }

    /* renamed from: android.support.v4.view.ViewGroupCompat$e */
    static class C0329e extends C0328d {
        C0329e() {
        }

        /* renamed from: b */
        public void mo2005b(ViewGroup viewGroup, boolean z) {
            C1064dy.m4765a(viewGroup, z);
        }

        /* renamed from: b */
        public boolean mo2006b(ViewGroup viewGroup) {
            return C1064dy.m4766a(viewGroup);
        }

        /* renamed from: c */
        public int mo2007c(ViewGroup viewGroup) {
            return C1064dy.m4767b(viewGroup);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f990a = new C0329e();
        } else if (i >= 18) {
            f990a = new C0328d();
        } else if (i >= 14) {
            f990a = new C0326b();
        } else if (i >= 11) {
            f990a = new C0325a();
        } else {
            f990a = new C0330f();
        }
    }

    private ViewGroupCompat() {
    }

    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f990a.mo2002a(viewGroup, view, accessibilityEvent);
    }

    public static void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z) {
        f990a.mo2001a(viewGroup, z);
    }

    public static int getLayoutMode(ViewGroup viewGroup) {
        return f990a.mo2003a(viewGroup);
    }

    public static void setLayoutMode(ViewGroup viewGroup, int i) {
        f990a.mo2004a(viewGroup, i);
    }

    public static void setTransitionGroup(ViewGroup viewGroup, boolean z) {
        f990a.mo2005b(viewGroup, z);
    }

    public static boolean isTransitionGroup(ViewGroup viewGroup) {
        return f990a.mo2006b(viewGroup);
    }

    public static int getNestedScrollAxes(ViewGroup viewGroup) {
        return f990a.mo2007c(viewGroup);
    }
}
