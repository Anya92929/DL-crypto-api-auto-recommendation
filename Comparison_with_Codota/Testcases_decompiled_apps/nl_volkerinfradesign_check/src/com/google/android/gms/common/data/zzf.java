package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T> extends AbstractDataBuffer<T> {

    /* renamed from: a */
    private boolean f2856a = false;

    /* renamed from: b */
    private ArrayList<Integer> f2857b;

    protected zzf(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: a */
    private void m3858a() {
        synchronized (this) {
            if (!this.f2856a) {
                int count = this.zzahi.getCount();
                this.f2857b = new ArrayList<>();
                if (count > 0) {
                    this.f2857b.add(0);
                    String zzqg = zzqg();
                    String zzd = this.zzahi.zzd(zzqg, 0, this.zzahi.zzbH(0));
                    int i = 1;
                    while (i < count) {
                        int zzbH = this.zzahi.zzbH(i);
                        String zzd2 = this.zzahi.zzd(zzqg, i, zzbH);
                        if (zzd2 == null) {
                            throw new NullPointerException("Missing value for markerColumn: " + zzqg + ", at row: " + i + ", for window: " + zzbH);
                        }
                        if (!zzd2.equals(zzd)) {
                            this.f2857b.add(Integer.valueOf(i));
                        } else {
                            zzd2 = zzd;
                        }
                        i++;
                        zzd = zzd2;
                    }
                }
                this.f2856a = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5325a(int i) {
        if (i >= 0 && i < this.f2857b.size()) {
            return this.f2857b.get(i).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    public final T get(int i) {
        m3858a();
        return zzk(mo5325a(i), zzbL(i));
    }

    public int getCount() {
        m3858a();
        return this.f2857b.size();
    }

    /* access modifiers changed from: protected */
    public int zzbL(int i) {
        if (i < 0 || i == this.f2857b.size()) {
            return 0;
        }
        int count = i == this.f2857b.size() + -1 ? this.zzahi.getCount() - this.f2857b.get(i).intValue() : this.f2857b.get(i + 1).intValue() - this.f2857b.get(i).intValue();
        if (count != 1) {
            return count;
        }
        int a = mo5325a(i);
        int zzbH = this.zzahi.zzbH(a);
        String zzqi = zzqi();
        if (zzqi == null || this.zzahi.zzd(zzqi, a, zzbH) != null) {
            return count;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract T zzk(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String zzqg();

    /* access modifiers changed from: protected */
    public String zzqi() {
        return null;
    }
}
