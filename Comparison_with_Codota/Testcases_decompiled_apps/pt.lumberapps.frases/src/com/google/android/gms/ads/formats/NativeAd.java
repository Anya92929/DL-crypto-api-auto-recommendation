package com.google.android.gms.ads.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;

public abstract class NativeAd {

    public abstract class Image {
        public abstract Drawable getDrawable();

        public abstract double getScale();

        public abstract Uri getUri();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo4901a();
}
