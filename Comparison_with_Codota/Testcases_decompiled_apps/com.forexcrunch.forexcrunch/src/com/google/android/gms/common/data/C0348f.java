package com.google.android.gms.common.data;

import java.util.ArrayList;

/* renamed from: com.google.android.gms.common.data.f */
public abstract class C0348f<T> extends DataBuffer<T> {

    /* renamed from: ao */
    private boolean f817ao = false;

    /* renamed from: ap */
    private ArrayList<Integer> f818ap;

    protected C0348f(C0344d dVar) {
        super(dVar);
    }

    /* renamed from: h */
    private int m588h(int i) {
        if (i >= 0 && i < this.f818ap.size()) {
            return this.f818ap.get(i).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    /* renamed from: i */
    private int m589i(int i) {
        if (i < 0 || i == this.f818ap.size()) {
            return 0;
        }
        return i == this.f818ap.size() + -1 ? this.f792S.getCount() - this.f818ap.get(i).intValue() : this.f818ap.get(i + 1).intValue() - this.f818ap.get(i).intValue();
    }

    /* renamed from: m */
    private void m590m() {
        synchronized (this) {
            if (!this.f817ao) {
                int count = this.f792S.getCount();
                this.f818ap = new ArrayList<>();
                if (count > 0) {
                    this.f818ap.add(0);
                    String primaryDataMarkerColumn = getPrimaryDataMarkerColumn();
                    String c = this.f792S.mo4050c(primaryDataMarkerColumn, 0, this.f792S.mo4054e(0));
                    int i = 1;
                    while (i < count) {
                        String c2 = this.f792S.mo4050c(primaryDataMarkerColumn, i, this.f792S.mo4054e(i));
                        if (!c2.equals(c)) {
                            this.f818ap.add(Integer.valueOf(i));
                        } else {
                            c2 = c;
                        }
                        i++;
                        c = c2;
                    }
                }
                this.f817ao = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract T mo4071a(int i, int i2);

    public final T get(int position) {
        m590m();
        return mo4071a(m588h(position), m589i(position));
    }

    public int getCount() {
        m590m();
        return this.f818ap.size();
    }

    /* access modifiers changed from: protected */
    public abstract String getPrimaryDataMarkerColumn();
}
