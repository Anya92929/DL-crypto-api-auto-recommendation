package android.support.design.widget;

import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.widget.ViewDragHelper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class SwipeDismissBehavior<V extends View> extends C0059g<V> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ViewDragHelper f77a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C0014af f78b;

    /* renamed from: c */
    private boolean f79c;

    /* renamed from: d */
    private float f80d = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: e */
    private boolean f81e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f82f = 2;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public float f83g = 0.5f;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public float f84h = BitmapDescriptorFactory.HUE_RED;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public float f85i = 0.5f;

    /* renamed from: j */
    private final ViewDragHelper.Callback f86j = new C0013ae(this);

    /* renamed from: a */
    static float m113a(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    /* renamed from: a */
    private void m116a(ViewGroup viewGroup) {
        if (this.f77a == null) {
            this.f77a = this.f81e ? ViewDragHelper.create(viewGroup, this.f80d, this.f86j) : ViewDragHelper.create(viewGroup, this.f86j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m118b(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static float m120c(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    /* renamed from: a */
    public int mo142a() {
        if (this.f77a != null) {
            return this.f77a.getViewDragState();
        }
        return 0;
    }

    /* renamed from: a */
    public void mo143a(float f) {
        this.f84h = m120c(BitmapDescriptorFactory.HUE_RED, f, 1.0f);
    }

    /* renamed from: a */
    public void mo144a(int i) {
        this.f82f = i;
    }

    /* renamed from: a */
    public void mo145a(C0014af afVar) {
        this.f78b = afVar;
    }

    /* renamed from: a */
    public boolean mo54a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f77a == null) {
            return false;
        }
        this.f77a.processTouchEvent(motionEvent);
        return true;
    }

    /* renamed from: b */
    public void mo146b(float f) {
        this.f85i = m120c(BitmapDescriptorFactory.HUE_RED, f, 1.0f);
    }

    /* renamed from: b */
    public boolean mo60b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 1:
            case 3:
                if (this.f79c) {
                    this.f79c = false;
                    return false;
                }
                break;
            default:
                this.f79c = !coordinatorLayout.mo75a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        if (this.f79c) {
            return false;
        }
        m116a((ViewGroup) coordinatorLayout);
        return this.f77a.shouldInterceptTouchEvent(motionEvent);
    }
}
