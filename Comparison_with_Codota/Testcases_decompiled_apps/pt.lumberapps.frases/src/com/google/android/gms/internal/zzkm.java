package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.List;

@zzin
public class zzkm {

    /* renamed from: a */
    private final String[] f6624a;

    /* renamed from: b */
    private final double[] f6625b;

    /* renamed from: c */
    private final double[] f6626c;

    /* renamed from: d */
    private final int[] f6627d;

    /* renamed from: e */
    private int f6628e;

    public class zza {
        public final int count;
        public final String name;
        public final double zzclw;
        public final double zzclx;
        public final double zzcly;

        public zza(String str, double d, double d2, double d3, int i) {
            this.name = str;
            this.zzclx = d;
            this.zzclw = d2;
            this.zzcly = d3;
            this.count = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            return zzaa.equal(this.name, zza.name) && this.zzclw == zza.zzclw && this.zzclx == zza.zzclx && this.count == zza.count && Double.compare(this.zzcly, zza.zzcly) == 0;
        }

        public int hashCode() {
            return zzaa.hashCode(this.name, Double.valueOf(this.zzclw), Double.valueOf(this.zzclx), Double.valueOf(this.zzcly), Integer.valueOf(this.count));
        }

        public String toString() {
            return zzaa.zzx(this).zzg("name", this.name).zzg("minBound", Double.valueOf(this.zzclx)).zzg("maxBound", Double.valueOf(this.zzclw)).zzg("percent", Double.valueOf(this.zzcly)).zzg("count", Integer.valueOf(this.count)).toString();
        }
    }

    public class zzb {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final List f6629a = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final List f6630b = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final List f6631c = new ArrayList();

        public zzb zza(String str, double d, double d2) {
            int i;
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.f6629a.size()) {
                    break;
                }
                double doubleValue = ((Double) this.f6631c.get(i)).doubleValue();
                double doubleValue2 = ((Double) this.f6630b.get(i)).doubleValue();
                if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                    break;
                }
                i2 = i + 1;
            }
            this.f6629a.add(i, str);
            this.f6631c.add(i, Double.valueOf(d));
            this.f6630b.add(i, Double.valueOf(d2));
            return this;
        }

        public zzkm zzto() {
            return new zzkm(this);
        }
    }

    private zzkm(zzb zzb2) {
        int size = zzb2.f6630b.size();
        this.f6624a = (String[]) zzb2.f6629a.toArray(new String[size]);
        this.f6625b = m7325a(zzb2.f6630b);
        this.f6626c = m7325a(zzb2.f6631c);
        this.f6627d = new int[size];
        this.f6628e = 0;
    }

    /* renamed from: a */
    private double[] m7325a(List list) {
        double[] dArr = new double[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dArr.length) {
                return dArr;
            }
            dArr[i2] = ((Double) list.get(i2)).doubleValue();
            i = i2 + 1;
        }
    }

    public List getBuckets() {
        ArrayList arrayList = new ArrayList(this.f6624a.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f6624a.length) {
                return arrayList;
            }
            arrayList.add(new zza(this.f6624a[i2], this.f6626c[i2], this.f6625b[i2], ((double) this.f6627d[i2]) / ((double) this.f6628e), this.f6627d[i2]));
            i = i2 + 1;
        }
    }

    public void zza(double d) {
        this.f6628e++;
        int i = 0;
        while (i < this.f6626c.length) {
            if (this.f6626c[i] <= d && d < this.f6625b[i]) {
                int[] iArr = this.f6627d;
                iArr[i] = iArr[i] + 1;
            }
            if (d >= this.f6626c[i]) {
                i++;
            } else {
                return;
            }
        }
    }
}
