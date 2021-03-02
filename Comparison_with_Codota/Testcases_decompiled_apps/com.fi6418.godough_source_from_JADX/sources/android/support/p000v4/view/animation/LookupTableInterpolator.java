package android.support.p000v4.view.animation;

import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v4.view.animation.LookupTableInterpolator */
abstract class LookupTableInterpolator implements Interpolator {

    /* renamed from: a */
    private final float[] f1378a;

    /* renamed from: b */
    private final float f1379b = (1.0f / ((float) (this.f1378a.length - 1)));

    public LookupTableInterpolator(float[] fArr) {
        this.f1378a = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int min = Math.min((int) (((float) (this.f1378a.length - 1)) * f), this.f1378a.length - 2);
        float f2 = (f - (((float) min) * this.f1379b)) / this.f1379b;
        return ((this.f1378a[min + 1] - this.f1378a[min]) * f2) + this.f1378a[min];
    }
}
