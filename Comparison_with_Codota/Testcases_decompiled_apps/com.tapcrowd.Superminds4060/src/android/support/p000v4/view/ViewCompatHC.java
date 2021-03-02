package android.support.p000v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

/* renamed from: android.support.v4.view.ViewCompatHC */
class ViewCompatHC {
    ViewCompatHC() {
    }

    static long getFrameTime() {
        return ValueAnimator.getFrameDelay();
    }

    public static void setLayerType(View view, int layerType, Paint paint) {
        view.setLayerType(layerType, paint);
    }

    public static int getLayerType(View view) {
        return view.getLayerType();
    }
}
