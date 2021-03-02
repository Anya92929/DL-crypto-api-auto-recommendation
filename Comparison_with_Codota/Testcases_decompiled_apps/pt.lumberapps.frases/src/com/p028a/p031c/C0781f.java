package com.p028a.p031c;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* renamed from: com.a.c.f */
public class C0781f extends BitmapDrawable {

    /* renamed from: a */
    private float f2037a;

    /* renamed from: b */
    private WeakReference f2038b;

    /* renamed from: c */
    private boolean f2039c;

    /* renamed from: d */
    private Matrix f2040d;

    /* renamed from: e */
    private int f2041e;

    /* renamed from: f */
    private float f2042f;

    public C0781f(Resources resources, Bitmap bitmap, ImageView imageView, float f, float f2) {
        super(resources, bitmap);
        this.f2038b = new WeakReference(imageView);
        this.f2037a = f;
        this.f2042f = f2;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        imageView.setImageMatrix(new Matrix());
        m3563a(imageView, bitmap, false);
    }

    /* renamed from: a */
    private float m3558a(int i, int i2) {
        return this.f2042f != Float.MAX_VALUE ? (1.0f - this.f2042f) / 2.0f : ((1.5f - Math.max(1.0f, Math.min(1.5f, ((float) i2) / ((float) i)))) / 2.0f) + 0.25f;
    }

    /* renamed from: a */
    private int m3559a(int i, int i2, int i3) {
        float f = this.f2037a;
        if (this.f2037a == Float.MAX_VALUE) {
            f = ((float) i2) / ((float) i);
        }
        return (int) (f * ((float) i3));
    }

    /* renamed from: a */
    private int m3560a(ImageView imageView) {
        int i = 0;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            i = layoutParams.width;
        }
        if (i <= 0) {
            i = imageView.getWidth();
        }
        return i > 0 ? (i - imageView.getPaddingLeft()) - imageView.getPaddingRight() : i;
    }

    /* renamed from: a */
    private Matrix m3561a(ImageView imageView, Bitmap bitmap) {
        float f;
        float f2;
        float f3 = 0.0f;
        int width = bitmap.getWidth();
        if (this.f2040d != null && width == this.f2041e) {
            return this.f2040d;
        }
        int height = bitmap.getHeight();
        int a = m3560a(imageView);
        int a2 = m3559a(width, height, a);
        if (width <= 0 || height <= 0 || a <= 0 || a2 <= 0) {
            return null;
        }
        if (this.f2040d == null || width != this.f2041e) {
            this.f2040d = new Matrix();
            if (width * a2 >= a * height) {
                f = ((float) a2) / ((float) height);
                f2 = (((float) a) - (((float) width) * f)) * 0.5f;
            } else {
                f = ((float) a) / ((float) width);
                float a3 = (((float) a2) - (((float) height) * f)) * m3558a(width, height);
                f2 = 0.0f;
                f3 = a3;
            }
            this.f2040d.setScale(f, f);
            this.f2040d.postTranslate(f2, f3);
            this.f2041e = width;
        }
        return this.f2040d;
    }

    /* renamed from: a */
    private void m3562a(Canvas canvas, ImageView imageView, Bitmap bitmap) {
        Matrix a = m3561a(imageView, bitmap);
        if (a != null) {
            int paddingTop = imageView.getPaddingTop() + imageView.getPaddingBottom();
            int paddingLeft = imageView.getPaddingLeft() + imageView.getPaddingRight();
            if (paddingTop > 0 || paddingLeft > 0) {
                canvas.clipRect(0, 0, imageView.getWidth() - paddingLeft, imageView.getHeight() - paddingTop);
            }
            canvas.drawBitmap(bitmap, a, getPaint());
        }
        if (!this.f2039c) {
            m3563a(imageView, bitmap, true);
        }
    }

    /* renamed from: a */
    private void m3563a(ImageView imageView, Bitmap bitmap, boolean z) {
        int a = m3560a(imageView);
        if (a > 0) {
            int a2 = m3559a(bitmap.getWidth(), bitmap.getHeight(), a) + imageView.getPaddingTop() + imageView.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams != null) {
                if (a2 != layoutParams.height) {
                    layoutParams.height = a2;
                    imageView.setLayoutParams(layoutParams);
                }
                if (z) {
                    this.f2039c = true;
                }
            }
        }
    }

    public void draw(Canvas canvas) {
        ImageView imageView = null;
        if (this.f2038b != null) {
            imageView = (ImageView) this.f2038b.get();
        }
        if (this.f2037a == 0.0f || imageView == null) {
            super.draw(canvas);
        } else {
            m3562a(canvas, imageView, getBitmap());
        }
    }
}
