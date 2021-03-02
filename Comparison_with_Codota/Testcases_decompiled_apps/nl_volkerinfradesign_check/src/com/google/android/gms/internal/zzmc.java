package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

public final class zzmc extends ImageView {

    /* renamed from: a */
    private Uri f3208a;

    /* renamed from: b */
    private int f3209b;

    /* renamed from: c */
    private int f3210c;

    /* renamed from: d */
    private zza f3211d;

    /* renamed from: e */
    private int f3212e;

    /* renamed from: f */
    private float f3213f;

    public interface zza {
        Path zzl(int i, int i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f3211d != null) {
            canvas.clipPath(this.f3211d.zzl(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.f3210c != 0) {
            canvas.drawColor(this.f3210c);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int measuredWidth;
        int i3;
        super.onMeasure(i, i2);
        switch (this.f3212e) {
            case 1:
                i3 = getMeasuredHeight();
                measuredWidth = (int) (((float) i3) * this.f3213f);
                break;
            case 2:
                measuredWidth = getMeasuredWidth();
                i3 = (int) (((float) measuredWidth) / this.f3213f);
                break;
            default:
                return;
        }
        setMeasuredDimension(measuredWidth, i3);
    }

    public void zzbO(int i) {
        this.f3209b = i;
    }

    public void zzm(Uri uri) {
        this.f3208a = uri;
    }

    public int zzqp() {
        return this.f3209b;
    }
}
