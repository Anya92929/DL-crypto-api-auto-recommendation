package android.support.p001v4.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import p000.C1093er;
import p000.C1096es;

/* renamed from: android.support.v4.view.accessibility.AccessibilityNodeProviderCompat */
public class AccessibilityNodeProviderCompat {

    /* renamed from: a */
    private static final C0374a f1089a;

    /* renamed from: b */
    private final Object f1090b;

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$a */
    interface C0374a {
        /* renamed from: a */
        Object mo2461a(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat);
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$d */
    static class C0379d implements C0374a {
        C0379d() {
        }

        /* renamed from: a */
        public Object mo2461a(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return null;
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$b */
    static class C0375b extends C0379d {
        C0375b() {
        }

        /* renamed from: a */
        public Object mo2461a(final AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return C1093er.m4958a(new C1093er.C1095a() {
                /* renamed from: a */
                public boolean mo2464a(int i, int i2, Bundle bundle) {
                    return accessibilityNodeProviderCompat.performAction(i, i2, bundle);
                }

                /* renamed from: a */
                public List<Object> mo2463a(String str, int i) {
                    List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText = accessibilityNodeProviderCompat.findAccessibilityNodeInfosByText(str, i);
                    ArrayList arrayList = new ArrayList();
                    int size = findAccessibilityNodeInfosByText.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(findAccessibilityNodeInfosByText.get(i2).getInfo());
                    }
                    return arrayList;
                }

                /* renamed from: a */
                public Object mo2462a(int i) {
                    AccessibilityNodeInfoCompat createAccessibilityNodeInfo = accessibilityNodeProviderCompat.createAccessibilityNodeInfo(i);
                    if (createAccessibilityNodeInfo == null) {
                        return null;
                    }
                    return createAccessibilityNodeInfo.getInfo();
                }
            });
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$c */
    static class C0377c extends C0379d {
        C0377c() {
        }

        /* renamed from: a */
        public Object mo2461a(final AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return C1096es.m4962a(new C1096es.C1098a() {
                /* renamed from: a */
                public boolean mo2467a(int i, int i2, Bundle bundle) {
                    return accessibilityNodeProviderCompat.performAction(i, i2, bundle);
                }

                /* renamed from: a */
                public List<Object> mo2466a(String str, int i) {
                    List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText = accessibilityNodeProviderCompat.findAccessibilityNodeInfosByText(str, i);
                    ArrayList arrayList = new ArrayList();
                    int size = findAccessibilityNodeInfosByText.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(findAccessibilityNodeInfosByText.get(i2).getInfo());
                    }
                    return arrayList;
                }

                /* renamed from: a */
                public Object mo2465a(int i) {
                    AccessibilityNodeInfoCompat createAccessibilityNodeInfo = accessibilityNodeProviderCompat.createAccessibilityNodeInfo(i);
                    if (createAccessibilityNodeInfo == null) {
                        return null;
                    }
                    return createAccessibilityNodeInfo.getInfo();
                }

                /* renamed from: b */
                public Object mo2468b(int i) {
                    AccessibilityNodeInfoCompat findFocus = accessibilityNodeProviderCompat.findFocus(i);
                    if (findFocus == null) {
                        return null;
                    }
                    return findFocus.getInfo();
                }
            });
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f1089a = new C0377c();
        } else if (Build.VERSION.SDK_INT >= 16) {
            f1089a = new C0375b();
        } else {
            f1089a = new C0379d();
        }
    }

    public AccessibilityNodeProviderCompat() {
        this.f1090b = f1089a.mo2461a(this);
    }

    public AccessibilityNodeProviderCompat(Object obj) {
        this.f1090b = obj;
    }

    public Object getProvider() {
        return this.f1090b;
    }

    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
        return null;
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return false;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String str, int i) {
        return null;
    }

    public AccessibilityNodeInfoCompat findFocus(int i) {
        return null;
    }
}
