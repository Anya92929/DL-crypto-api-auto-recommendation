package com.google.android.gms.common.data;

import java.util.ArrayList;

/* renamed from: com.google.android.gms.common.data.f */
public abstract class C0144f<T> extends DataBuffer<T> {

    /* renamed from: jA */
    private boolean f391jA = false;

    /* renamed from: jB */
    private ArrayList<Integer> f392jB;

    protected C0144f(C0140d dVar) {
        super(dVar);
    }

    /* renamed from: aN */
    private void m265aN() {
        synchronized (this) {
            if (!this.f391jA) {
                int count = this.f366jf.getCount();
                this.f392jB = new ArrayList<>();
                if (count > 0) {
                    this.f392jB.add(0);
                    String primaryDataMarkerColumn = getPrimaryDataMarkerColumn();
                    String c = this.f366jf.mo3602c(primaryDataMarkerColumn, 0, this.f366jf.mo3614q(0));
                    int i = 1;
                    while (i < count) {
                        String c2 = this.f366jf.mo3602c(primaryDataMarkerColumn, i, this.f366jf.mo3614q(i));
                        if (!c2.equals(c)) {
                            this.f392jB.add(Integer.valueOf(i));
                        } else {
                            c2 = c;
                        }
                        i++;
                        c = c2;
                    }
                }
                this.f391jA = true;
            }
        }
    }

    /* renamed from: u */
    private int m266u(int i) {
        if (i < 0 || i == this.f392jB.size()) {
            return 0;
        }
        return i == this.f392jB.size() + -1 ? this.f366jf.getCount() - this.f392jB.get(i).intValue() : this.f392jB.get(i + 1).intValue() - this.f392jB.get(i).intValue();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract T mo3620a(int i, int i2);

    public final T get(int position) {
        m265aN();
        return mo3620a(mo3622t(position), m266u(position));
    }

    public int getCount() {
        m265aN();
        return this.f392jB.size();
    }

    /* access modifiers changed from: protected */
    public abstract String getPrimaryDataMarkerColumn();

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public int mo3622t(int i) {
        if (i >= 0 && i < this.f392jB.size()) {
            return this.f392jB.get(i).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }
}
