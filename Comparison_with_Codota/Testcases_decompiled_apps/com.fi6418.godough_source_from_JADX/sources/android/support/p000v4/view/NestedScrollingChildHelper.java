package android.support.p000v4.view;

import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.view.NestedScrollingChildHelper */
public class NestedScrollingChildHelper {

    /* renamed from: a */
    private final View f1195a;

    /* renamed from: b */
    private ViewParent f1196b;

    /* renamed from: c */
    private boolean f1197c;

    /* renamed from: d */
    private int[] f1198d;

    public NestedScrollingChildHelper(View view) {
        this.f1195a = view;
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        if (!isNestedScrollingEnabled() || this.f1196b == null) {
            return false;
        }
        return ViewParentCompat.onNestedFling(this.f1196b, this.f1195a, f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        if (!isNestedScrollingEnabled() || this.f1196b == null) {
            return false;
        }
        return ViewParentCompat.onNestedPreFling(this.f1196b, this.f1195a, f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        int i3;
        int i4;
        if (!isNestedScrollingEnabled() || this.f1196b == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            if (iArr2 != null) {
                this.f1195a.getLocationInWindow(iArr2);
                i4 = iArr2[0];
                i3 = iArr2[1];
            } else {
                i3 = 0;
                i4 = 0;
            }
            if (iArr == null) {
                if (this.f1198d == null) {
                    this.f1198d = new int[2];
                }
                iArr = this.f1198d;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            ViewParentCompat.onNestedPreScroll(this.f1196b, this.f1195a, i, i2, iArr);
            if (iArr2 != null) {
                this.f1195a.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i4;
                iArr2[1] = iArr2[1] - i3;
            }
            return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        int i5;
        int i6;
        if (!isNestedScrollingEnabled() || this.f1196b == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            if (iArr != null) {
                this.f1195a.getLocationInWindow(iArr);
                int i7 = iArr[0];
                i5 = iArr[1];
                i6 = i7;
            } else {
                i5 = 0;
                i6 = 0;
            }
            ViewParentCompat.onNestedScroll(this.f1196b, this.f1195a, i, i2, i3, i4);
            if (iArr != null) {
                this.f1195a.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i6;
                iArr[1] = iArr[1] - i5;
            }
            return true;
        } else if (iArr == null) {
            return false;
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
    }

    public boolean hasNestedScrollingParent() {
        return this.f1196b != null;
    }

    public boolean isNestedScrollingEnabled() {
        return this.f1197c;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.f1195a);
    }

    public void onStopNestedScroll(View view) {
        ViewCompat.stopNestedScroll(this.f1195a);
    }

    public void setNestedScrollingEnabled(boolean z) {
        if (this.f1197c) {
            ViewCompat.stopNestedScroll(this.f1195a);
        }
        this.f1197c = z;
    }

    public boolean startNestedScroll(int i) {
        if (hasNestedScrollingParent()) {
            return true;
        }
        if (isNestedScrollingEnabled()) {
            View view = this.f1195a;
            for (ViewParent parent = this.f1195a.getParent(); parent != null; parent = parent.getParent()) {
                if (ViewParentCompat.onStartNestedScroll(parent, view, this.f1195a, i)) {
                    this.f1196b = parent;
                    ViewParentCompat.onNestedScrollAccepted(parent, view, this.f1195a, i);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public void stopNestedScroll() {
        if (this.f1196b != null) {
            ViewParentCompat.onStopNestedScroll(this.f1196b, this.f1195a);
            this.f1196b = null;
        }
    }
}
