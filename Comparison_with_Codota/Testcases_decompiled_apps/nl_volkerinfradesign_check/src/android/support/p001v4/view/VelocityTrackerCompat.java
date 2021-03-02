package android.support.p001v4.view;

import android.os.Build;
import android.view.VelocityTracker;

/* renamed from: android.support.v4.view.VelocityTrackerCompat */
public class VelocityTrackerCompat {

    /* renamed from: a */
    static final C0306c f981a;

    /* renamed from: android.support.v4.view.VelocityTrackerCompat$c */
    interface C0306c {
        /* renamed from: a */
        float mo1888a(VelocityTracker velocityTracker, int i);

        /* renamed from: b */
        float mo1889b(VelocityTracker velocityTracker, int i);
    }

    /* renamed from: android.support.v4.view.VelocityTrackerCompat$a */
    static class C0304a implements C0306c {
        C0304a() {
        }

        /* renamed from: a */
        public float mo1888a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity();
        }

        /* renamed from: b */
        public float mo1889b(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity();
        }
    }

    /* renamed from: android.support.v4.view.VelocityTrackerCompat$b */
    static class C0305b implements C0306c {
        C0305b() {
        }

        /* renamed from: a */
        public float mo1888a(VelocityTracker velocityTracker, int i) {
            return C1045dg.m4643a(velocityTracker, i);
        }

        /* renamed from: b */
        public float mo1889b(VelocityTracker velocityTracker, int i) {
            return C1045dg.m4644b(velocityTracker, i);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f981a = new C0305b();
        } else {
            f981a = new C0304a();
        }
    }

    public static float getXVelocity(VelocityTracker velocityTracker, int i) {
        return f981a.mo1888a(velocityTracker, i);
    }

    public static float getYVelocity(VelocityTracker velocityTracker, int i) {
        return f981a.mo1889b(velocityTracker, i);
    }
}
