package p000;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: fa */
class C1107fa implements Interpolator {

    /* renamed from: a */
    private final float[] f4074a;

    /* renamed from: b */
    private final float[] f4075b;

    public C1107fa(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / 0.002f)) + 1;
        this.f4074a = new float[i];
        this.f4075b = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((((float) i2) * length) / ((float) (i - 1)), fArr, (float[]) null);
            this.f4074a[i2] = fArr[0];
            this.f4075b[i2] = fArr[1];
        }
    }

    public C1107fa(float f, float f2) {
        this(m5035a(f, f2));
    }

    public C1107fa(float f, float f2, float f3, float f4) {
        this(m5036a(f, f2, f3, f4));
    }

    public float getInterpolation(float f) {
        int i;
        if (f <= BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i2 = 0;
        int length = this.f4074a.length - 1;
        while (length - i2 > 1) {
            int i3 = (i2 + length) / 2;
            if (f < this.f4074a[i3]) {
                i = i2;
            } else {
                int i4 = length;
                i = i3;
                i3 = i4;
            }
            i2 = i;
            length = i3;
        }
        float f2 = this.f4074a[length] - this.f4074a[i2];
        if (f2 == BitmapDescriptorFactory.HUE_RED) {
            return this.f4075b[i2];
        }
        float f3 = (f - this.f4074a[i2]) / f2;
        float f4 = this.f4075b[i2];
        return (f3 * (this.f4075b[length] - f4)) + f4;
    }

    /* renamed from: a */
    private static Path m5035a(float f, float f2) {
        Path path = new Path();
        path.moveTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        path.quadTo(f, f2, 1.0f, 1.0f);
        return path;
    }

    /* renamed from: a */
    private static Path m5036a(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        return path;
    }
}