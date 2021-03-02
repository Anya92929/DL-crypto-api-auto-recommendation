package com.appbrain.p036e;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;

/* renamed from: com.appbrain.e.a */
public class C1028a extends LayerDrawable {

    /* renamed from: a */
    private final int f2681a;

    /* renamed from: b */
    private final ColorFilter f2682b;

    /* renamed from: c */
    private final ColorFilter f2683c;

    /* renamed from: d */
    private final ColorFilter f2684d;

    /* renamed from: e */
    private final ColorFilter f2685e;

    public C1028a(Drawable[] drawableArr, float[] fArr) {
        this(drawableArr, fArr, (byte) 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private C1028a(Drawable[] drawableArr, float[] fArr, byte b) {
        super(drawableArr);
        this.f2681a = -1;
        float[] fArr2 = new float[fArr.length];
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        for (int i = 0; i < 3; i++) {
            int i2 = i * 5;
            fArr2[i2] = (float) (((double) fArr2[i2]) * 1.25d);
            int i3 = (i * 5) + 1;
            fArr2[i3] = (float) (((double) fArr2[i3]) * 1.25d);
            int i4 = (i * 5) + 2;
            fArr2[i4] = (float) (((double) fArr2[i4]) * 1.25d);
        }
        this.f2683c = new ColorMatrixColorFilter(fArr2);
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = i5 * 5;
            fArr2[i6] = (float) (((double) fArr2[i6]) * 0.8d);
            int i7 = (i5 * 5) + 1;
            fArr2[i7] = (float) (((double) fArr2[i7]) * 0.8d);
            int i8 = (i5 * 5) + 2;
            fArr2[i8] = (float) (((double) fArr2[i8]) * 0.8d);
        }
        this.f2684d = new ColorMatrixColorFilter(fArr2);
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        for (int i9 = 0; i9 < 3; i9++) {
            float f = ((fArr[i9] + fArr[i9 + 5]) + fArr[i9 + 10]) / 3.0f;
            fArr2[i9] = ((fArr2[i9] - f) / 2.0f) + f;
            fArr2[i9 + 5] = ((fArr2[i9 + 5] - f) / 2.0f) + f;
            fArr2[i9 + 10] = f + ((fArr2[i9 + 10] - f) / 2.0f);
        }
        this.f2685e = new ColorMatrixColorFilter(fArr2);
        this.f2682b = new ColorMatrixColorFilter(fArr);
        m4303a(getState());
    }

    /* renamed from: a */
    private static Drawable m4300a(Drawable drawable, Context context) {
        return drawable instanceof GradientDrawable ? new C1030c(drawable.getConstantState().newDrawable(context.getResources())) : C1031d.m4306a(drawable, context.getResources());
    }

    /* renamed from: a */
    public static C1028a m4301a(Context context, Drawable drawable) {
        return m4305b(context, drawable);
    }

    /* renamed from: a */
    public static C1028a m4302a(Context context, Drawable drawable, Drawable drawable2) {
        return new C1029b(new Drawable[]{m4300a(drawable, context)}, m4304a(), drawable2);
    }

    /* renamed from: a */
    private void m4303a(int[] iArr) {
        ColorFilter colorFilter = this.f2682b;
        ColorFilter colorFilter2 = colorFilter;
        boolean z = false;
        for (int i : iArr) {
            if (i == 16842910) {
                z = true;
            }
            if (i == 16842919) {
                colorFilter2 = this.f2684d;
            }
            if (i == 16842908 || i == 16842913) {
                colorFilter2 = this.f2683c;
            }
        }
        if (!z) {
            colorFilter2 = this.f2685e;
        }
        (this.f2681a != -1 ? getDrawable(this.f2681a) : this).setColorFilter(colorFilter2);
        invalidateSelf();
    }

    /* renamed from: a */
    private static float[] m4304a() {
        float[] fArr = new float[20];
        fArr[18] = 1.0f;
        int blue = Color.blue(-1);
        int red = Color.red(-1);
        int green = Color.green(-1);
        fArr[0] = ((float) red) / 255.0f;
        fArr[6] = ((float) green) / 255.0f;
        fArr[12] = ((float) blue) / 255.0f;
        return fArr;
    }

    /* renamed from: b */
    public static C1028a m4305b(Context context, Drawable drawable) {
        return new C1028a(new Drawable[]{m4300a(drawable, context)}, m4304a());
    }

    public boolean isStateful() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        m4303a(iArr);
        return super.onStateChange(iArr);
    }
}
