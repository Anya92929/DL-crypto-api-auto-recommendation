package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;

public abstract class zzc {

    /* renamed from: a */
    protected final DataHolder f4391a;

    /* renamed from: b */
    protected int f4392b;

    /* renamed from: c */
    private int f4393c;

    public zzc(DataHolder dataHolder, int i) {
        this.f4391a = (DataHolder) zzab.zzy(dataHolder);
        mo6461a(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6461a(int i) {
        zzab.zzbn(i >= 0 && i < this.f4391a.getCount());
        this.f4392b = i;
        this.f4393c = this.f4391a.zzfs(this.f4392b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc zzc = (zzc) obj;
        return zzaa.equal(Integer.valueOf(zzc.f4392b), Integer.valueOf(this.f4392b)) && zzaa.equal(Integer.valueOf(zzc.f4393c), Integer.valueOf(this.f4393c)) && zzc.f4391a == this.f4391a;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.f4392b), Integer.valueOf(this.f4393c), this.f4391a);
    }

    public boolean isDataValid() {
        return !this.f4391a.isClosed();
    }

    public boolean zzhe(String str) {
        return this.f4391a.zzhe(str);
    }
}
