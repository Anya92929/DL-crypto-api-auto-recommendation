package android.support.p000v4.view;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

/* renamed from: android.support.v4.view.ViewParentCompat */
public class ViewParentCompat {
    static final ViewParentCompatImpl IMPL;

    /* renamed from: android.support.v4.view.ViewParentCompat$ViewParentCompatImpl */
    interface ViewParentCompatImpl {
        boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent);
    }

    /* renamed from: android.support.v4.view.ViewParentCompat$ViewParentCompatStubImpl */
    static class ViewParentCompatStubImpl implements ViewParentCompatImpl {
        ViewParentCompatStubImpl() {
        }

        public boolean requestSendAccessibilityEvent(ViewParent parent, View child, AccessibilityEvent event) {
            if (child == null) {
                return false;
            }
            ((AccessibilityManager) child.getContext().getSystemService("accessibility")).sendAccessibilityEvent(event);
            return true;
        }
    }

    /* renamed from: android.support.v4.view.ViewParentCompat$ViewParentCompatICSImpl */
    static class ViewParentCompatICSImpl extends ViewParentCompatStubImpl {
        ViewParentCompatICSImpl() {
        }

        public boolean requestSendAccessibilityEvent(ViewParent parent, View child, AccessibilityEvent event) {
            return ViewParentCompatICS.requestSendAccessibilityEvent(parent, child, event);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new ViewParentCompatICSImpl();
        } else {
            IMPL = new ViewParentCompatStubImpl();
        }
    }

    private ViewParentCompat() {
    }

    public static boolean requestSendAccessibilityEvent(ViewParent parent, View child, AccessibilityEvent event) {
        return IMPL.requestSendAccessibilityEvent(parent, child, event);
    }
}
