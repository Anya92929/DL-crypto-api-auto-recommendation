package android.support.p001v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import java.util.Collections;
import java.util.List;
import p000.C1079ej;

/* renamed from: android.support.v4.view.accessibility.AccessibilityManagerCompat */
public class AccessibilityManagerCompat {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final C0363c f1079a;

    /* renamed from: android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat */
    public static abstract class AccessibilityStateChangeListenerCompat {

        /* renamed from: a */
        final Object f1080a = AccessibilityManagerCompat.f1079a.mo2200a(this);

        public abstract void onAccessibilityStateChanged(boolean z);
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityManagerCompat$c */
    interface C0363c {
        /* renamed from: a */
        Object mo2200a(AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat);

        /* renamed from: a */
        List<AccessibilityServiceInfo> mo2201a(AccessibilityManager accessibilityManager);

        /* renamed from: a */
        List<AccessibilityServiceInfo> mo2202a(AccessibilityManager accessibilityManager, int i);

        /* renamed from: a */
        boolean mo2203a(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat);

        /* renamed from: b */
        boolean mo2204b(AccessibilityManager accessibilityManager);

        /* renamed from: b */
        boolean mo2205b(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat);
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityManagerCompat$b */
    static class C0362b implements C0363c {
        C0362b() {
        }

        /* renamed from: a */
        public Object mo2200a(AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return null;
        }

        /* renamed from: a */
        public boolean mo2203a(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return false;
        }

        /* renamed from: b */
        public boolean mo2205b(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return false;
        }

        /* renamed from: a */
        public List<AccessibilityServiceInfo> mo2202a(AccessibilityManager accessibilityManager, int i) {
            return Collections.emptyList();
        }

        /* renamed from: a */
        public List<AccessibilityServiceInfo> mo2201a(AccessibilityManager accessibilityManager) {
            return Collections.emptyList();
        }

        /* renamed from: b */
        public boolean mo2204b(AccessibilityManager accessibilityManager) {
            return false;
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityManagerCompat$a */
    static class C0360a extends C0362b {
        C0360a() {
        }

        /* renamed from: a */
        public Object mo2200a(final AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return C1079ej.m4821a((C1079ej.C1081a) new C1079ej.C1081a() {
                /* renamed from: a */
                public void mo2206a(boolean z) {
                    accessibilityStateChangeListenerCompat.onAccessibilityStateChanged(z);
                }
            });
        }

        /* renamed from: a */
        public boolean mo2203a(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return C1079ej.m4824a(accessibilityManager, accessibilityStateChangeListenerCompat.f1080a);
        }

        /* renamed from: b */
        public boolean mo2205b(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return C1079ej.m4826b(accessibilityManager, accessibilityStateChangeListenerCompat.f1080a);
        }

        /* renamed from: a */
        public List<AccessibilityServiceInfo> mo2202a(AccessibilityManager accessibilityManager, int i) {
            return C1079ej.m4823a(accessibilityManager, i);
        }

        /* renamed from: a */
        public List<AccessibilityServiceInfo> mo2201a(AccessibilityManager accessibilityManager) {
            return C1079ej.m4822a(accessibilityManager);
        }

        /* renamed from: b */
        public boolean mo2204b(AccessibilityManager accessibilityManager) {
            return C1079ej.m4825b(accessibilityManager);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f1079a = new C0360a();
        } else {
            f1079a = new C0362b();
        }
    }

    public static boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
        return f1079a.mo2203a(accessibilityManager, accessibilityStateChangeListenerCompat);
    }

    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
        return f1079a.mo2205b(accessibilityManager, accessibilityStateChangeListenerCompat);
    }

    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
        return f1079a.mo2201a(accessibilityManager);
    }

    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i) {
        return f1079a.mo2202a(accessibilityManager, i);
    }

    public static boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
        return f1079a.mo2204b(accessibilityManager);
    }
}
