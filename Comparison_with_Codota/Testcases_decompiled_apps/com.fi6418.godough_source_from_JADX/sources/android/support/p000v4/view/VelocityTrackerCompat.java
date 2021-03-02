package android.support.p000v4.view;

import android.os.Build;
import android.view.VelocityTracker;

/* renamed from: android.support.v4.view.VelocityTrackerCompat */
public class VelocityTrackerCompat {

    /* renamed from: a */
    static final VelocityTrackerVersionImpl f1241a;

    /* renamed from: android.support.v4.view.VelocityTrackerCompat$BaseVelocityTrackerVersionImpl */
    class BaseVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        BaseVelocityTrackerVersionImpl() {
        }

        public float getXVelocity(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity();
        }

        public float getYVelocity(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity();
        }
    }

    /* renamed from: android.support.v4.view.VelocityTrackerCompat$HoneycombVelocityTrackerVersionImpl */
    class HoneycombVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        HoneycombVelocityTrackerVersionImpl() {
        }

        public float getXVelocity(VelocityTracker velocityTracker, int i) {
            return VelocityTrackerCompatHoneycomb.getXVelocity(velocityTracker, i);
        }

        public float getYVelocity(VelocityTracker velocityTracker, int i) {
            return VelocityTrackerCompatHoneycomb.getYVelocity(velocityTracker, i);
        }
    }

    /* renamed from: android.support.v4.view.VelocityTrackerCompat$VelocityTrackerVersionImpl */
    interface VelocityTrackerVersionImpl {
        float getXVelocity(VelocityTracker velocityTracker, int i);

        float getYVelocity(VelocityTracker velocityTracker, int i);
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f1241a = new HoneycombVelocityTrackerVersionImpl();
        } else {
            f1241a = new BaseVelocityTrackerVersionImpl();
        }
    }

    public static float getXVelocity(VelocityTracker velocityTracker, int i) {
        return f1241a.getXVelocity(velocityTracker, i);
    }

    public static float getYVelocity(VelocityTracker velocityTracker, int i) {
        return f1241a.getYVelocity(velocityTracker, i);
    }
}
