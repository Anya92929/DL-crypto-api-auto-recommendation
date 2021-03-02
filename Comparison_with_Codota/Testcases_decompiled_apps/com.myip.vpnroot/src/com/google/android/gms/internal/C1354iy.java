package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

/* renamed from: com.google.android.gms.internal.iy */
public final class C1354iy extends ImageView {

    /* renamed from: Lc */
    private Uri f4082Lc;

    /* renamed from: Ld */
    private int f4083Ld;

    /* renamed from: Le */
    private int f4084Le;

    /* renamed from: Lf */
    private C1355a f4085Lf;

    /* renamed from: Lg */
    private int f4086Lg;

    /* renamed from: Lh */
    private float f4087Lh;

    /* renamed from: com.google.android.gms.internal.iy$a */
    public interface C1355a {
        /* renamed from: g */
        Path mo8969g(int i, int i2);
    }

    /* renamed from: ay */
    public void mo8964ay(int i) {
        this.f4083Ld = i;
    }

    /* renamed from: g */
    public void mo8965g(Uri uri) {
        this.f4082Lc = uri;
    }

    /* renamed from: gN */
    public int mo8966gN() {
        return this.f4083Ld;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f4085Lf != null) {
            canvas.clipPath(this.f4085Lf.mo8969g(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.f4084Le != 0) {
            canvas.drawColor(this.f4084Le);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth;
        int i;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        switch (this.f4086Lg) {
            case 1:
                i = getMeasuredHeight();
                measuredWidth = (int) (((float) i) * this.f4087Lh);
                break;
            case 2:
                measuredWidth = getMeasuredWidth();
                i = (int) (((float) measuredWidth) / this.f4087Lh);
                break;
            default:
                return;
        }
        setMeasuredDimension(measuredWidth, i);
    }
}
