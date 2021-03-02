package android.support.p009v4.view;

import android.os.Build;
import android.view.VelocityTracker;

/* renamed from: android.support.v4.view.bt */
public final class C0242bt {

    /* renamed from: a */
    static final C0245bw f351a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f351a = new C0244bv();
        } else {
            f351a = new C0243bu();
        }
    }

    /* renamed from: a */
    public static float m877a(VelocityTracker velocityTracker, int i) {
        return f351a.mo1465a(velocityTracker, i);
    }

    /* renamed from: b */
    public static float m878b(VelocityTracker velocityTracker, int i) {
        return f351a.mo1466b(velocityTracker, i);
    }
}
