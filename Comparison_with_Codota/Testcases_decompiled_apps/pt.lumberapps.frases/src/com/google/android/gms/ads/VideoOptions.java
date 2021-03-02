package com.google.android.gms.ads;

import com.google.android.gms.internal.zzin;

@zzin
public final class VideoOptions {

    /* renamed from: a */
    private final boolean f3399a;

    public final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public boolean f3400a = false;

        public VideoOptions build() {
            return new VideoOptions(this);
        }

        public Builder setStartMuted(boolean z) {
            this.f3400a = z;
            return this;
        }
    }

    private VideoOptions(Builder builder) {
        this.f3399a = builder.f3400a;
    }

    public boolean getStartMuted() {
        return this.f3399a;
    }
}
