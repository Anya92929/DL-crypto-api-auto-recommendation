package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.net.Uri;
import android.widget.ImageView;

public final class zzrb extends ImageView {

    /* renamed from: a */
    private Uri f6962a;

    /* renamed from: b */
    private int f6963b;

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public int zzars() {
        return this.f6963b;
    }

    public void zzga(int i) {
        this.f6963b = i;
    }

    public void zzp(Uri uri) {
        this.f6962a = uri;
    }
}
