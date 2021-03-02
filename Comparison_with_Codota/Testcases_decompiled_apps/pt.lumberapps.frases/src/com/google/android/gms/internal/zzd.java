package com.google.android.gms.internal;

public class zzd implements zzo {

    /* renamed from: a */
    private int f6093a;

    /* renamed from: b */
    private int f6094b;

    /* renamed from: c */
    private final int f6095c;

    /* renamed from: d */
    private final float f6096d;

    public zzd() {
        this(2500, 1, 1.0f);
    }

    public zzd(int i, int i2, float f) {
        this.f6093a = i;
        this.f6095c = i2;
        this.f6096d = f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo8260a() {
        return this.f6094b <= this.f6095c;
    }

    public void zza(zzr zzr) {
        this.f6094b++;
        this.f6093a = (int) (((float) this.f6093a) + (((float) this.f6093a) * this.f6096d));
        if (!mo8260a()) {
            throw zzr;
        }
    }

    public int zzc() {
        return this.f6093a;
    }

    public int zzd() {
        return this.f6094b;
    }
}
