package android.support.p000v4.widget;

import android.widget.EdgeEffect;

/* renamed from: android.support.v4.widget.EdgeEffectCompatLollipop */
class EdgeEffectCompatLollipop {
    EdgeEffectCompatLollipop() {
    }

    public static boolean onPull(Object edgeEffect, float deltaDistance, float displacement) {
        ((EdgeEffect) edgeEffect).onPull(deltaDistance, displacement);
        return true;
    }
}
