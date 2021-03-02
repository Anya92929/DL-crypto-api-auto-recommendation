package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public abstract class zzc {

    /* renamed from: a */
    private int f2853a;
    protected final DataHolder zzahi;
    protected int zzaje;

    public zzc(DataHolder dataHolder, int i) {
        this.zzahi = (DataHolder) zzx.zzz(dataHolder);
        zzbF(i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc zzc = (zzc) obj;
        return zzw.equal(Integer.valueOf(zzc.zzaje), Integer.valueOf(this.zzaje)) && zzw.equal(Integer.valueOf(zzc.f2853a), Integer.valueOf(this.f2853a)) && zzc.zzahi == this.zzahi;
    }

    /* access modifiers changed from: protected */
    public boolean getBoolean(String str) {
        return this.zzahi.zze(str, this.zzaje, this.f2853a);
    }

    /* access modifiers changed from: protected */
    public byte[] getByteArray(String str) {
        return this.zzahi.zzg(str, this.zzaje, this.f2853a);
    }

    /* access modifiers changed from: protected */
    public float getFloat(String str) {
        return this.zzahi.zzf(str, this.zzaje, this.f2853a);
    }

    /* access modifiers changed from: protected */
    public int getInteger(String str) {
        return this.zzahi.zzc(str, this.zzaje, this.f2853a);
    }

    /* access modifiers changed from: protected */
    public long getLong(String str) {
        return this.zzahi.zzb(str, this.zzaje, this.f2853a);
    }

    /* access modifiers changed from: protected */
    public String getString(String str) {
        return this.zzahi.zzd(str, this.zzaje, this.f2853a);
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaje), Integer.valueOf(this.f2853a), this.zzahi);
    }

    public boolean isDataValid() {
        return !this.zzahi.isClosed();
    }

    /* access modifiers changed from: protected */
    public void zza(String str, CharArrayBuffer charArrayBuffer) {
        this.zzahi.zza(str, this.zzaje, this.f2853a, charArrayBuffer);
    }

    /* access modifiers changed from: protected */
    public void zzbF(int i) {
        zzx.zzab(i >= 0 && i < this.zzahi.getCount());
        this.zzaje = i;
        this.f2853a = this.zzahi.zzbH(this.zzaje);
    }

    /* access modifiers changed from: protected */
    public Uri zzcA(String str) {
        return this.zzahi.zzh(str, this.zzaje, this.f2853a);
    }

    /* access modifiers changed from: protected */
    public boolean zzcB(String str) {
        return this.zzahi.zzi(str, this.zzaje, this.f2853a);
    }

    public boolean zzcz(String str) {
        return this.zzahi.zzcz(str);
    }

    /* access modifiers changed from: protected */
    public int zzqc() {
        return this.zzaje;
    }
}
