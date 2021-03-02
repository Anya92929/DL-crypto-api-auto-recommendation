package com.google.android.gms.ads.formats;

import com.google.android.gms.internal.zzin;

@zzin
public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int ORIENTATION_ANY = 0;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;

    /* renamed from: a */
    private final boolean f3406a;

    /* renamed from: b */
    private final int f3407b;

    /* renamed from: c */
    private final boolean f3408c;

    /* renamed from: d */
    private final int f3409d;

    public @interface AdChoicesPlacement {
    }

    public final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public boolean f3410a = false;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f3411b = 0;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f3412c = false;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public int f3413d = 1;

        public NativeAdOptions build() {
            return new NativeAdOptions(this);
        }

        public Builder setAdChoicesPlacement(@AdChoicesPlacement int i) {
            this.f3413d = i;
            return this;
        }

        public Builder setImageOrientation(int i) {
            this.f3411b = i;
            return this;
        }

        public Builder setRequestMultipleImages(boolean z) {
            this.f3412c = z;
            return this;
        }

        public Builder setReturnUrlsForImageAssets(boolean z) {
            this.f3410a = z;
            return this;
        }
    }

    private NativeAdOptions(Builder builder) {
        this.f3406a = builder.f3410a;
        this.f3407b = builder.f3411b;
        this.f3408c = builder.f3412c;
        this.f3409d = builder.f3413d;
    }

    public int getAdChoicesPlacement() {
        return this.f3409d;
    }

    public int getImageOrientation() {
        return this.f3407b;
    }

    public boolean shouldRequestMultipleImages() {
        return this.f3408c;
    }

    public boolean shouldReturnUrlsForImageAssets() {
        return this.f3406a;
    }
}
