package android.support.p000v4.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.p000v4.view.AccessibilityDelegateCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.ViewParentCompat;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.support.p000v4.view.accessibility.AccessibilityManagerCompat;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p000v4.view.accessibility.AccessibilityNodeProviderCompat;
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
    private static final String f1494b = View.class.getName();

    /* renamed from: c */
    private final Rect f1495c = new Rect();

    /* renamed from: d */
    private final Rect f1496d = new Rect();

    /* renamed from: e */
    private final Rect f1497e = new Rect();

    /* renamed from: f */
    private final int[] f1498f = new int[2];

    /* renamed from: g */
    private final AccessibilityManager f1499g;

    /* renamed from: h */
    private final View f1500h;

    /* renamed from: i */
    private ExploreByTouchNodeProvider f1501i;

    /* renamed from: j */
    private int f1502j = Integer.MIN_VALUE;

    /* renamed from: k */
    private int f1503k = Integer.MIN_VALUE;

    /* renamed from: android.support.v4.widget.ExploreByTouchHelper$ExploreByTouchNodeProvider */
    class ExploreByTouchNodeProvider extends AccessibilityNodeProviderCompat {
        private ExploreByTouchNodeProvider() {
        }

        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
            return ExploreByTouchHelper.this.m1076c(i);
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return ExploreByTouchHelper.this.m1075b(i, i2, bundle);
        }
    }

    public ExploreByTouchHelper(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f1500h = view;
        this.f1499g = (AccessibilityManager) view.getContext().getSystemService("accessibility");
    }

    /* renamed from: a */
    private AccessibilityEvent m1067a(int i, int i2) {
        switch (i) {
            case -1:
                return m1073b(i2);
            default:
                return m1074b(i, i2);
        }
    }

    /* renamed from: a */
    private void m1068a(int i) {
        if (this.f1503k != i) {
            int i2 = this.f1503k;
            this.f1503k = i;
            sendEventForVirtualView(i, 128);
            sendEventForVirtualView(i2, 256);
        }
    }

    /* renamed from: a */
    private boolean m1069a(int i, Bundle bundle) {
        return ViewCompat.performAccessibilityAction(this.f1500h, i, bundle);
    }

    /* renamed from: a */
    private boolean m1070a(Rect rect) {
        if (rect == null || rect.isEmpty()) {
            return false;
        }
        if (this.f1500h.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.f1500h.getParent();
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
        if (!this.f1500h.getLocalVisibleRect(this.f1497e)) {
            return false;
        }
        return rect.intersect(this.f1497e);
    }

    /* renamed from: b */
    private AccessibilityNodeInfoCompat m1072b() {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(this.f1500h);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.f1500h, obtain);
        onPopulateNodeForHost(obtain);
        LinkedList linkedList = new LinkedList();
        mo3186a((List<Integer>) linkedList);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            obtain.addChild(this.f1500h, ((Integer) it.next()).intValue());
        }
        return obtain;
    }

    /* renamed from: b */
    private AccessibilityEvent m1073b(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        ViewCompat.onInitializeAccessibilityEvent(this.f1500h, obtain);
        return obtain;
    }

    /* renamed from: b */
    private AccessibilityEvent m1074b(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        obtain.setEnabled(true);
        obtain.setClassName(f1494b);
        mo3185a(i, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setPackageName(this.f1500h.getContext().getPackageName());
            AccessibilityEventCompat.asRecord(obtain).setSource(this.f1500h, i);
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m1075b(int i, int i2, Bundle bundle) {
        switch (i) {
            case -1:
                return m1069a(i2, bundle);
            default:
                return m1077c(i, i2, bundle);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public AccessibilityNodeInfoCompat m1076c(int i) {
        switch (i) {
            case -1:
                return m1072b();
            default:
                return m1078d(i);
        }
    }

    /* renamed from: c */
    private boolean m1077c(int i, int i2, Bundle bundle) {
        switch (i2) {
            case 64:
            case 128:
                return m1079d(i, i2, bundle);
            default:
                return mo3187a(i, i2, bundle);
        }
    }

    /* renamed from: d */
    private AccessibilityNodeInfoCompat m1078d(int i) {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        obtain.setEnabled(true);
        obtain.setClassName(f1494b);
        mo3184a(i, obtain);
        if (obtain.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        obtain.getBoundsInParent(this.f1496d);
        if (this.f1496d.isEmpty()) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = obtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else {
            obtain.setPackageName(this.f1500h.getContext().getPackageName());
            obtain.setSource(this.f1500h, i);
            obtain.setParent(this.f1500h);
            if (this.f1502j == i) {
                obtain.setAccessibilityFocused(true);
                obtain.addAction(128);
            } else {
                obtain.setAccessibilityFocused(false);
                obtain.addAction(64);
            }
            if (m1070a(this.f1496d)) {
                obtain.setVisibleToUser(true);
                obtain.setBoundsInParent(this.f1496d);
            }
            this.f1500h.getLocationOnScreen(this.f1498f);
            int i2 = this.f1498f[0];
            int i3 = this.f1498f[1];
            this.f1495c.set(this.f1496d);
            this.f1495c.offset(i2, i3);
            obtain.setBoundsInScreen(this.f1495c);
            return obtain;
        }
    }

    /* renamed from: d */
    private boolean m1079d(int i, int i2, Bundle bundle) {
        switch (i2) {
            case 64:
                return m1081f(i);
            case 128:
                return m1082g(i);
            default:
                return false;
        }
    }

    /* renamed from: e */
    private boolean m1080e(int i) {
        return this.f1502j == i;
    }

    /* renamed from: f */
    private boolean m1081f(int i) {
        if (!this.f1499g.isEnabled() || !AccessibilityManagerCompat.isTouchExplorationEnabled(this.f1499g) || m1080e(i)) {
            return false;
        }
        if (this.f1502j != Integer.MIN_VALUE) {
            sendEventForVirtualView(this.f1502j, 65536);
        }
        this.f1502j = i;
        this.f1500h.invalidate();
        sendEventForVirtualView(i, 32768);
        return true;
    }

    /* renamed from: g */
    private boolean m1082g(int i) {
        if (!m1080e(i)) {
            return false;
        }
        this.f1502j = Integer.MIN_VALUE;
        this.f1500h.invalidate();
        sendEventForVirtualView(i, 65536);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo3183a(float f, float f2);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo3184a(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo3185a(int i, AccessibilityEvent accessibilityEvent);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo3186a(List<Integer> list);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo3187a(int i, int i2, Bundle bundle);

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        boolean z = true;
        if (!this.f1499g.isEnabled() || !AccessibilityManagerCompat.isTouchExplorationEnabled(this.f1499g)) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 7:
            case 9:
                int a = mo3183a(motionEvent.getX(), motionEvent.getY());
                m1068a(a);
                if (a == Integer.MIN_VALUE) {
                    z = false;
                }
                return z;
            case 10:
                if (this.f1502j == Integer.MIN_VALUE) {
                    return false;
                }
                m1068a(Integer.MIN_VALUE);
                return true;
            default:
                return false;
        }
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.f1501i == null) {
            this.f1501i = new ExploreByTouchNodeProvider();
        }
        return this.f1501i;
    }

    public int getFocusedVirtualView() {
        return this.f1502j;
    }

    public void invalidateRoot() {
        invalidateVirtualView(-1);
    }

    public void invalidateVirtualView(int i) {
        sendEventForVirtualView(i, 2048);
    }

    public void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public boolean sendEventForVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.f1499g.isEnabled() || (parent = this.f1500h.getParent()) == null) {
            return false;
        }
        return ViewParentCompat.requestSendAccessibilityEvent(parent, this.f1500h, m1067a(i, i2));
    }
}
