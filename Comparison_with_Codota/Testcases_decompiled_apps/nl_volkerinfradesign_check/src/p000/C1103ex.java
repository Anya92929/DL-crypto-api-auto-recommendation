package p000;

import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: ex */
public abstract class C1103ex implements Interpolator {

    /* renamed from: a */
    private final float[] f4072a;

    /* renamed from: b */
    private final float f4073b = (1.0f / ((float) (this.f4072a.length - 1)));

    public C1103ex(float[] fArr) {
        this.f4072a = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int min = Math.min((int) (((float) (this.f4072a.length - 1)) * f), this.f4072a.length - 2);
        float f2 = (f - (((float) min) * this.f4073b)) / this.f4073b;
        return ((this.f4072a[min + 1] - this.f4072a[min]) * f2) + this.f4072a[min];
    }
}
