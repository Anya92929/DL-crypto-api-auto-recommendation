package android.support.p009v4.view;

import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.view.bm */
public class C0235bm {

    /* renamed from: a */
    private final View f345a;

    /* renamed from: b */
    private ViewParent f346b;

    /* renamed from: c */
    private boolean f347c;

    /* renamed from: d */
    private int[] f348d;

    public C0235bm(View view) {
        this.f345a = view;
    }

    /* renamed from: a */
    public void mo1421a(boolean z) {
        if (this.f347c) {
            C0247by.stopNestedScroll(this.f345a);
        }
        this.f347c = z;
    }

    /* renamed from: a */
    public boolean mo1422a() {
        return this.f347c;
    }

    /* renamed from: a */
    public boolean mo1423a(float f, float f2) {
        if (!mo1422a() || this.f346b == null) {
            return false;
        }
        return C0307ed.m1168a(this.f346b, this.f345a, f, f2);
    }

    /* renamed from: a */
    public boolean mo1424a(float f, float f2, boolean z) {
        if (!mo1422a() || this.f346b == null) {
            return false;
        }
        return C0307ed.m1169a(this.f346b, this.f345a, f, f2, z);
    }

    /* renamed from: a */
    public boolean mo1425a(int i) {
        if (mo1428b()) {
            return true;
        }
        if (mo1422a()) {
            View view = this.f345a;
            for (ViewParent parent = this.f345a.getParent(); parent != null; parent = parent.getParent()) {
                if (C0307ed.m1170a(parent, view, this.f345a, i)) {
                    this.f346b = parent;
                    C0307ed.m1171b(parent, view, this.f345a, i);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo1426a(int i, int i2, int i3, int i4, int[] iArr) {
        int i5;
        int i6;
        if (!mo1422a() || this.f346b == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            if (iArr != null) {
                this.f345a.getLocationInWindow(iArr);
                int i7 = iArr[0];
                i5 = iArr[1];
                i6 = i7;
            } else {
                i5 = 0;
                i6 = 0;
            }
            C0307ed.m1166a(this.f346b, this.f345a, i, i2, i3, i4);
            if (iArr != null) {
                this.f345a.getLocationInWindow(iArr);
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

    /* renamed from: a */
    public boolean mo1427a(int i, int i2, int[] iArr, int[] iArr2) {
        int i3;
        int i4;
        if (!mo1422a() || this.f346b == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            if (iArr2 != null) {
                this.f345a.getLocationInWindow(iArr2);
                i4 = iArr2[0];
                i3 = iArr2[1];
            } else {
                i3 = 0;
                i4 = 0;
            }
            if (iArr == null) {
                if (this.f348d == null) {
                    this.f348d = new int[2];
                }
                iArr = this.f348d;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            C0307ed.m1167a(this.f346b, this.f345a, i, i2, iArr);
            if (iArr2 != null) {
                this.f345a.getLocationInWindow(iArr2);
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

    /* renamed from: b */
    public boolean mo1428b() {
        return this.f346b != null;
    }

    /* renamed from: c */
    public void mo1429c() {
        if (this.f346b != null) {
            C0307ed.m1165a(this.f346b, this.f345a);
            this.f346b = null;
        }
    }

    public void onStopNestedScroll(View view) {
        C0247by.stopNestedScroll(this.f345a);
    }
}
