package android.support.p001v4.view;

import android.os.Build;
import android.os.Bundle;
import android.support.p001v4.view.AccessibilityDelegateCompatIcs;
import android.support.p001v4.view.AccessibilityDelegateCompatJellyBean;
import android.support.p001v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p001v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.AccessibilityDelegateCompat */
public class AccessibilityDelegateCompat {

    /* renamed from: b */
    private static final C0259b f889b;

    /* renamed from: c */
    private static final Object f890c = f889b.mo1690a();

    /* renamed from: a */
    final Object f891a = f889b.mo1691a(this);

    /* renamed from: android.support.v4.view.AccessibilityDelegateCompat$b */
    interface C0259b {
        /* renamed from: a */
        AccessibilityNodeProviderCompat mo1706a(Object obj, View view);

        /* renamed from: a */
        Object mo1690a();

        /* renamed from: a */
        Object mo1691a(AccessibilityDelegateCompat accessibilityDelegateCompat);

        /* renamed from: a */
        void mo1692a(Object obj, View view, int i);

        /* renamed from: a */
        void mo1693a(Object obj, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

        /* renamed from: a */
        boolean mo1707a(Object obj, View view, int i, Bundle bundle);

        /* renamed from: a */
        boolean mo1694a(Object obj, View view, AccessibilityEvent accessibilityEvent);

        /* renamed from: a */
        boolean mo1695a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        /* renamed from: b */
        void mo1696b(Object obj, View view, AccessibilityEvent accessibilityEvent);

        /* renamed from: c */
        void mo1697c(Object obj, View view, AccessibilityEvent accessibilityEvent);

        /* renamed from: d */
        void mo1698d(Object obj, View view, AccessibilityEvent accessibilityEvent);
    }

    /* renamed from: android.support.v4.view.AccessibilityDelegateCompat$d */
    static class C0262d implements C0259b {
        C0262d() {
        }

        /* renamed from: a */
        public Object mo1690a() {
            return null;
        }

        /* renamed from: a */
        public Object mo1691a(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            return null;
        }

        /* renamed from: a */
        public boolean mo1694a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return false;
        }

        /* renamed from: b */
        public void mo1696b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        /* renamed from: a */
        public void mo1693a(Object obj, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        /* renamed from: c */
        public void mo1697c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        /* renamed from: a */
        public boolean mo1695a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return true;
        }

        /* renamed from: a */
        public void mo1692a(Object obj, View view, int i) {
        }

        /* renamed from: d */
        public void mo1698d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        /* renamed from: a */
        public AccessibilityNodeProviderCompat mo1706a(Object obj, View view) {
            return null;
        }

        /* renamed from: a */
        public boolean mo1707a(Object obj, View view, int i, Bundle bundle) {
            return false;
        }
    }

    /* renamed from: android.support.v4.view.AccessibilityDelegateCompat$a */
    static class C0257a extends C0262d {
        C0257a() {
        }

        /* renamed from: a */
        public Object mo1690a() {
            return AccessibilityDelegateCompatIcs.m1034a();
        }

        /* renamed from: a */
        public Object mo1691a(final AccessibilityDelegateCompat accessibilityDelegateCompat) {
            return AccessibilityDelegateCompatIcs.m1035a(new AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge() {
                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.onInitializeAccessibilityEvent(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityNodeInfo(View view, Object obj) {
                    accessibilityDelegateCompat.onInitializeAccessibilityNodeInfo(view, new AccessibilityNodeInfoCompat(obj));
                }

                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.onPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }

                public void sendAccessibilityEvent(View view, int i) {
                    accessibilityDelegateCompat.sendAccessibilityEvent(view, i);
                }

                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.sendAccessibilityEventUnchecked(view, accessibilityEvent);
                }
            });
        }

        /* renamed from: a */
        public boolean mo1694a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return AccessibilityDelegateCompatIcs.m1038a(obj, view, accessibilityEvent);
        }

        /* renamed from: b */
        public void mo1696b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompatIcs.m1040b(obj, view, accessibilityEvent);
        }

        /* renamed from: a */
        public void mo1693a(Object obj, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityDelegateCompatIcs.m1037a(obj, view, accessibilityNodeInfoCompat.getInfo());
        }

        /* renamed from: c */
        public void mo1697c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompatIcs.m1041c(obj, view, accessibilityEvent);
        }

        /* renamed from: a */
        public boolean mo1695a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return AccessibilityDelegateCompatIcs.m1039a(obj, viewGroup, view, accessibilityEvent);
        }

        /* renamed from: a */
        public void mo1692a(Object obj, View view, int i) {
            AccessibilityDelegateCompatIcs.m1036a(obj, view, i);
        }

        /* renamed from: d */
        public void mo1698d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompatIcs.m1042d(obj, view, accessibilityEvent);
        }
    }

    /* renamed from: android.support.v4.view.AccessibilityDelegateCompat$c */
    static class C0260c extends C0257a {
        C0260c() {
        }

        /* renamed from: a */
        public Object mo1691a(final AccessibilityDelegateCompat accessibilityDelegateCompat) {
            return AccessibilityDelegateCompatJellyBean.m1043a(new AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean() {
                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.onInitializeAccessibilityEvent(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityNodeInfo(View view, Object obj) {
                    accessibilityDelegateCompat.onInitializeAccessibilityNodeInfo(view, new AccessibilityNodeInfoCompat(obj));
                }

                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.onPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }

                public void sendAccessibilityEvent(View view, int i) {
                    accessibilityDelegateCompat.sendAccessibilityEvent(view, i);
                }

                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.sendAccessibilityEventUnchecked(view, accessibilityEvent);
                }

                public Object getAccessibilityNodeProvider(View view) {
                    AccessibilityNodeProviderCompat accessibilityNodeProvider = accessibilityDelegateCompat.getAccessibilityNodeProvider(view);
                    if (accessibilityNodeProvider != null) {
                        return accessibilityNodeProvider.getProvider();
                    }
                    return null;
                }

                public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    return accessibilityDelegateCompat.performAccessibilityAction(view, i, bundle);
                }
            });
        }

        /* renamed from: a */
        public AccessibilityNodeProviderCompat mo1706a(Object obj, View view) {
            Object a = AccessibilityDelegateCompatJellyBean.m1044a(obj, view);
            if (a != null) {
                return new AccessibilityNodeProviderCompat(a);
            }
            return null;
        }

        /* renamed from: a */
        public boolean mo1707a(Object obj, View view, int i, Bundle bundle) {
            return AccessibilityDelegateCompatJellyBean.m1045a(obj, view, i, bundle);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f889b = new C0260c();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f889b = new C0257a();
        } else {
            f889b = new C0262d();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Object mo1680a() {
        return this.f891a;
    }

    public void sendAccessibilityEvent(View view, int i) {
        f889b.mo1692a(f890c, view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        f889b.mo1698d(f890c, view, accessibilityEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return f889b.mo1694a(f890c, view, accessibilityEvent);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        f889b.mo1697c(f890c, view, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        f889b.mo1696b(f890c, view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        f889b.mo1693a(f890c, view, accessibilityNodeInfoCompat);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f889b.mo1695a(f890c, viewGroup, view, accessibilityEvent);
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        return f889b.mo1706a(f890c, view);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return f889b.mo1707a(f890c, view, i, bundle);
    }
}
