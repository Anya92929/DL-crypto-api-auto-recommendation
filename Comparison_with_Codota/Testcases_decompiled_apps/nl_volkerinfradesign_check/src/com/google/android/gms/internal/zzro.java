package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api;

public final class zzro implements Api.ApiOptions.Optional {
    public static final zzro zzbgV = new zza().zzFJ();

    /* renamed from: a */
    private final boolean f3247a;

    /* renamed from: b */
    private final boolean f3248b;

    /* renamed from: c */
    private final String f3249c;

    /* renamed from: d */
    private final boolean f3250d;

    /* renamed from: e */
    private final String f3251e;

    /* renamed from: f */
    private final boolean f3252f;

    public static final class zza {

        /* renamed from: a */
        private boolean f3253a;

        /* renamed from: b */
        private boolean f3254b;

        /* renamed from: c */
        private String f3255c;

        /* renamed from: d */
        private boolean f3256d;

        /* renamed from: e */
        private String f3257e;

        /* renamed from: f */
        private boolean f3258f;

        public zzro zzFJ() {
            return new zzro(this.f3253a, this.f3254b, this.f3255c, this.f3256d, this.f3257e, this.f3258f);
        }
    }

    private zzro(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4) {
        this.f3247a = z;
        this.f3248b = z2;
        this.f3249c = str;
        this.f3250d = z3;
        this.f3252f = z4;
        this.f3251e = str2;
    }

    public boolean zzFH() {
        return this.f3247a;
    }

    public boolean zzFI() {
        return this.f3252f;
    }

    public boolean zzmO() {
        return this.f3248b;
    }

    public boolean zzmQ() {
        return this.f3250d;
    }

    public String zzmR() {
        return this.f3249c;
    }

    @Nullable
    public String zzmS() {
        return this.f3251e;
    }
}
