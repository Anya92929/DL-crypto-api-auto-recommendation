package com.google.android.gms.common.data;

import java.util.ArrayList;

/* renamed from: com.google.android.gms.common.data.g */
public abstract class C0300g<T> extends DataBuffer<T> {

    /* renamed from: Ki */
    private boolean f698Ki = false;

    /* renamed from: Kj */
    private ArrayList<Integer> f699Kj;

    protected C0300g(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: gF */
    private void m630gF() {
        synchronized (this) {
            if (!this.f698Ki) {
                int count = this.f667IC.getCount();
                this.f699Kj = new ArrayList<>();
                if (count > 0) {
                    this.f699Kj.add(0);
                    String gE = mo4357gE();
                    String c = this.f667IC.mo4306c(gE, 0, this.f667IC.mo4304ar(0));
                    int i = 1;
                    while (i < count) {
                        String c2 = this.f667IC.mo4306c(gE, i, this.f667IC.mo4304ar(i));
                        if (!c2.equals(c)) {
                            this.f699Kj.add(Integer.valueOf(i));
                        } else {
                            c2 = c;
                        }
                        i++;
                        c = c2;
                    }
                }
                this.f698Ki = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: au */
    public int mo4354au(int i) {
        if (i >= 0 && i < this.f699Kj.size()) {
            return this.f699Kj.get(i).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    /* access modifiers changed from: protected */
    /* renamed from: av */
    public int mo4355av(int i) {
        if (i < 0 || i == this.f699Kj.size()) {
            return 0;
        }
        int count = i == this.f699Kj.size() + -1 ? this.f667IC.getCount() - this.f699Kj.get(i).intValue() : this.f699Kj.get(i + 1).intValue() - this.f699Kj.get(i).intValue();
        if (count != 1) {
            return count;
        }
        int au = mo4354au(i);
        int ar = this.f667IC.mo4304ar(au);
        String gG = mo4358gG();
        if (gG == null || this.f667IC.mo4306c(gG, au, ar) != null) {
            return count;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public abstract T mo4356f(int i, int i2);

    /* access modifiers changed from: protected */
    /* renamed from: gE */
    public abstract String mo4357gE();

    /* access modifiers changed from: protected */
    /* renamed from: gG */
    public String mo4358gG() {
        return null;
    }

    public final T get(int position) {
        m630gF();
        return mo4356f(mo4354au(position), mo4355av(position));
    }

    public int getCount() {
        m630gF();
        return this.f699Kj.size();
    }
}
