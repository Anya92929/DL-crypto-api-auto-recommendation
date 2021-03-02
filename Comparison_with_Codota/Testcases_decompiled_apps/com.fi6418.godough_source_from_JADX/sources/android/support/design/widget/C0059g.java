package android.support.design.widget;

import android.content.Context;
import android.os.Parcelable;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.design.widget.g */
public abstract class C0059g<V extends View> {
    public C0059g() {
    }

    public C0059g(Context context, AttributeSet attributeSet) {
    }

    /* renamed from: a */
    public Parcelable mo39a(CoordinatorLayout coordinatorLayout, V v) {
        return View.BaseSavedState.EMPTY_STATE;
    }

    /* renamed from: a */
    public WindowInsetsCompat mo268a(CoordinatorLayout coordinatorLayout, V v, WindowInsetsCompat windowInsetsCompat) {
        return windowInsetsCompat;
    }

    /* renamed from: a */
    public void mo44a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
    }

    /* renamed from: a */
    public void mo45a(CoordinatorLayout coordinatorLayout, V v, View view) {
    }

    /* renamed from: a */
    public void mo46a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
    }

    /* renamed from: a */
    public void mo47a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
    }

    /* renamed from: a */
    public boolean mo53a(CoordinatorLayout coordinatorLayout, V v, int i) {
        return false;
    }

    /* renamed from: a */
    public boolean mo62a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
        return false;
    }

    /* renamed from: a */
    public boolean mo54a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        return false;
    }

    /* renamed from: a */
    public boolean mo269a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return false;
    }

    /* renamed from: a */
    public boolean mo55a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
        return false;
    }

    /* renamed from: a */
    public boolean mo56a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        return false;
    }

    /* renamed from: b */
    public final int mo270b(CoordinatorLayout coordinatorLayout, V v) {
        return ViewCompat.MEASURED_STATE_MASK;
    }

    /* renamed from: b */
    public void mo271b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
    }

    /* renamed from: b */
    public boolean mo60b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        return false;
    }

    /* renamed from: b */
    public boolean mo63b(CoordinatorLayout coordinatorLayout, V v, View view) {
        return false;
    }

    /* renamed from: c */
    public final float mo272c(CoordinatorLayout coordinatorLayout, V v) {
        return BitmapDescriptorFactory.HUE_RED;
    }

    /* renamed from: c */
    public boolean mo64c(CoordinatorLayout coordinatorLayout, V v, View view) {
        return false;
    }

    /* renamed from: d */
    public boolean mo273d(CoordinatorLayout coordinatorLayout, V v) {
        return mo272c(coordinatorLayout, v) > BitmapDescriptorFactory.HUE_RED;
    }

    /* renamed from: e */
    public boolean mo274e(CoordinatorLayout coordinatorLayout, V v) {
        return false;
    }
}
