package android.support.p001v4.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.p001v4.view.AccessibilityDelegateCompat;
import android.support.p001v4.view.ViewCompat;
import android.support.p001v4.view.ViewParentCompat;
import android.support.p001v4.view.accessibility.AccessibilityEventCompat;
import android.support.p001v4.view.accessibility.AccessibilityManagerCompat;
import android.support.p001v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p001v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: android.support.v4.widget.ExploreByTouchHelper */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;

    /* renamed from: b */
    private static final String f1195b = View.class.getName();

    /* renamed from: c */
    private final Rect f1196c = new Rect();

    /* renamed from: d */
    private final Rect f1197d = new Rect();

    /* renamed from: e */
    private final Rect f1198e = new Rect();

    /* renamed from: f */
    private final int[] f1199f = new int[2];

    /* renamed from: g */
    private final AccessibilityManager f1200g;

    /* renamed from: h */
    private final View f1201h;

    /* renamed from: i */
    private C0414a f1202i;

    /* renamed from: j */
    private int f1203j = INVALID_ID;

    /* renamed from: k */
    private int f1204k = INVALID_ID;

    /* access modifiers changed from: protected */
    public abstract int getVirtualViewAt(float f, float f2);

    /* access modifiers changed from: protected */
    public abstract void getVisibleVirtualViews(List<Integer> list);

    /* access modifiers changed from: protected */
    public abstract boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent);

    /* access modifiers changed from: protected */
    public abstract void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public ExploreByTouchHelper(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f1201h = view;
        this.f1200g = (AccessibilityManager) view.getContext().getSystemService("accessibility");
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.f1202i == null) {
            this.f1202i = new C0414a();
        }
        return this.f1202i;
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        boolean z = true;
        if (!this.f1200g.isEnabled() || !AccessibilityManagerCompat.isTouchExplorationEnabled(this.f1200g)) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 7:
            case 9:
                int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
                m2510a(virtualViewAt);
                if (virtualViewAt == Integer.MIN_VALUE) {
                    z = false;
                }
                return z;
            case 10:
                if (this.f1203j == Integer.MIN_VALUE) {
                    return false;
                }
                m2510a((int) INVALID_ID);
                return true;
            default:
                return false;
        }
    }

    public boolean sendEventForVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.f1200g.isEnabled() || (parent = this.f1201h.getParent()) == null) {
            return false;
        }
        return ViewParentCompat.requestSendAccessibilityEvent(parent, this.f1201h, m2509a(i, i2));
    }

    public void invalidateRoot() {
        invalidateVirtualView(-1);
    }

    public void invalidateVirtualView(int i) {
        sendEventForVirtualView(i, 2048);
    }

    public int getFocusedVirtualView() {
        return this.f1203j;
    }

    /* renamed from: a */
    private void m2510a(int i) {
        if (this.f1204k != i) {
            int i2 = this.f1204k;
            this.f1204k = i;
            sendEventForVirtualView(i, 128);
            sendEventForVirtualView(i2, 256);
        }
    }

    /* renamed from: a */
    private AccessibilityEvent m2509a(int i, int i2) {
        switch (i) {
            case -1:
                return m2516b(i2);
            default:
                return m2517b(i, i2);
        }
    }

    /* renamed from: b */
    private AccessibilityEvent m2516b(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        ViewCompat.onInitializeAccessibilityEvent(this.f1201h, obtain);
        return obtain;
    }

    /* renamed from: b */
    private AccessibilityEvent m2517b(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        obtain.setEnabled(true);
        obtain.setClassName(f1195b);
        onPopulateEventForVirtualView(i, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setPackageName(this.f1201h.getContext().getPackageName());
            AccessibilityEventCompat.asRecord(obtain).setSource(this.f1201h, i);
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public AccessibilityNodeInfoCompat m2519c(int i) {
        switch (i) {
            case -1:
                return m2515b();
            default:
                return m2521d(i);
        }
    }

    /* renamed from: b */
    private AccessibilityNodeInfoCompat m2515b() {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(this.f1201h);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.f1201h, obtain);
        onPopulateNodeForHost(obtain);
        LinkedList linkedList = new LinkedList();
        getVisibleVirtualViews(linkedList);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            obtain.addChild(this.f1201h, ((Integer) it.next()).intValue());
        }
        return obtain;
    }

    /* renamed from: d */
    private AccessibilityNodeInfoCompat m2521d(int i) {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        obtain.setEnabled(true);
        obtain.setClassName(f1195b);
        onPopulateNodeForVirtualView(i, obtain);
        if (obtain.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        obtain.getBoundsInParent(this.f1197d);
        if (this.f1197d.isEmpty()) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = obtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else {
            obtain.setPackageName(this.f1201h.getContext().getPackageName());
            obtain.setSource(this.f1201h, i);
            obtain.setParent(this.f1201h);
            if (this.f1203j == i) {
                obtain.setAccessibilityFocused(true);
                obtain.addAction(128);
            } else {
                obtain.setAccessibilityFocused(false);
                obtain.addAction(64);
            }
            if (m2513a(this.f1197d)) {
                obtain.setVisibleToUser(true);
                obtain.setBoundsInParent(this.f1197d);
            }
            this.f1201h.getLocationOnScreen(this.f1199f);
            int i2 = this.f1199f[0];
            int i3 = this.f1199f[1];
            this.f1196c.set(this.f1197d);
            this.f1196c.offset(i2, i3);
            obtain.setBoundsInScreen(this.f1196c);
            return obtain;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m2511a(int i, int i2, Bundle bundle) {
        switch (i) {
            case -1:
                return m2512a(i2, bundle);
            default:
                return m2518b(i, i2, bundle);
        }
    }

    /* renamed from: a */
    private boolean m2512a(int i, Bundle bundle) {
        return ViewCompat.performAccessibilityAction(this.f1201h, i, bundle);
    }

    /* renamed from: b */
    private boolean m2518b(int i, int i2, Bundle bundle) {
        switch (i2) {
            case 64:
            case 128:
                return m2520c(i, i2, bundle);
            default:
                return onPerformActionForVirtualView(i, i2, bundle);
        }
    }

    /* renamed from: c */
    private boolean m2520c(int i, int i2, Bundle bundle) {
        switch (i2) {
            case 64:
                return m2523f(i);
            case 128:
                return m2524g(i);
            default:
                return false;
        }
    }

    /* renamed from: a */
    private boolean m2513a(Rect rect) {
        if (rect == null || rect.isEmpty()) {
            return false;
        }
        if (this.f1201h.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.f1201h.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (ViewCompat.getAlpha(view) <= BitmapDescriptorFactory.HUE_RED || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent == null) {
            return false;
        }
        if (!this.f1201h.getLocalVisibleRect(this.f1198e)) {
            return false;
        }
        return rect.intersect(this.f1198e);
    }

    /* renamed from: e */
    private boolean m2522e(int i) {
        return this.f1203j == i;
    }

    /* renamed from: f */
    private boolean m2523f(int i) {
        if (!this.f1200g.isEnabled() || !AccessibilityManagerCompat.isTouchExplorationEnabled(this.f1200g) || m2522e(i)) {
            return false;
        }
        if (this.f1203j != Integer.MIN_VALUE) {
            sendEventForVirtualView(this.f1203j, 65536);
        }
        this.f1203j = i;
        this.f1201h.invalidate();
        sendEventForVirtualView(i, 32768);
        return true;
    }

    /* renamed from: g */
    private boolean m2524g(int i) {
        if (!m2522e(i)) {
            return false;
        }
        this.f1203j = INVALID_ID;
        this.f1201h.invalidate();
        sendEventForVirtualView(i, 65536);
        return true;
    }

    public void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    /* renamed from: android.support.v4.widget.ExploreByTouchHelper$a */
    class C0414a extends AccessibilityNodeProviderCompat {
        private C0414a() {
        }

        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
            return ExploreByTouchHelper.this.m2519c(i);
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return ExploreByTouchHelper.this.m2511a(i, i2, bundle);
        }
    }
}
