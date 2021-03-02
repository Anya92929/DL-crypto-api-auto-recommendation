package android.support.p000v4.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.view.animation.PathInterpolatorDonut */
class PathInterpolatorDonut implements Interpolator {
    private static final float PRECISION = 0.002f;

    /* renamed from: mX */
    private final float[] f7mX;

    /* renamed from: mY */
    private final float[] f8mY;

    public PathInterpolatorDonut(float f, float f2) {
        this(createQuad(f, f2));
    }

    public PathInterpolatorDonut(float f, float f2, float f3, float f4) {
        this(createCubic(f, f2, f3, f4));
    }

    public PathInterpolatorDonut(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / PRECISION)) + 1;
        this.f7mX = new float[i];
        this.f8mY = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((((float) i2) * length) / ((float) (i - 1)), fArr, (float[]) null);
            this.f7mX[i2] = fArr[0];
            this.f8mY[i2] = fArr[1];
        }
    }

    private static Path createCubic(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        return path;
    }

    private static Path createQuad(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        return path;
    }

    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.f7mX.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f7mX[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f2 = this.f7mX[length] - this.f7mX[i];
        if (f2 == 0.0f) {
            return this.f8mY[i];
        }
        float f3 = (f - this.f7mX[i]) / f2;
        float f4 = this.f8mY[i];
        return (f3 * (this.f8mY[length] - f4)) + f4;
    }
}
