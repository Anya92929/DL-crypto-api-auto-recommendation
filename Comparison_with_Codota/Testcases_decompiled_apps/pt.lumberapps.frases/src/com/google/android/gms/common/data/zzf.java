package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf extends AbstractDataBuffer {

    /* renamed from: b */
    private boolean f4396b;

    /* renamed from: c */
    private ArrayList f4397c;

    /* renamed from: c */
    private void m6002c() {
        synchronized (this) {
            if (!this.f4396b) {
                int count = this.f4364a.getCount();
                this.f4397c = new ArrayList();
                if (count > 0) {
                    this.f4397c.add(0);
                    String a = mo6473a();
                    String zzd = this.f4364a.zzd(a, 0, this.f4364a.zzfs(0));
                    int i = 1;
                    while (i < count) {
                        int zzfs = this.f4364a.zzfs(i);
                        String zzd2 = this.f4364a.zzd(a, i, zzfs);
                        if (zzd2 == null) {
                            throw new NullPointerException(new StringBuilder(String.valueOf(a).length() + 78).append("Missing value for markerColumn: ").append(a).append(", at row: ").append(i).append(", for window: ").append(zzfs).toString());
                        }
                        if (!zzd2.equals(zzd)) {
                            this.f4397c.add(Integer.valueOf(i));
                        } else {
                            zzd2 = zzd;
                        }
                        i++;
                        zzd = zzd2;
                    }
                }
                this.f4396b = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6471a(int i) {
        if (i >= 0 && i < this.f4397c.size()) {
            return ((Integer) this.f4397c.get(i)).intValue();
        }
        throw new IllegalArgumentException(new StringBuilder(53).append("Position ").append(i).append(" is out of bounds for this buffer").toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo6472a(int i, int i2);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo6473a();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo6474b(int i) {
        if (i < 0 || i == this.f4397c.size()) {
            return 0;
        }
        int count = i == this.f4397c.size() + -1 ? this.f4364a.getCount() - ((Integer) this.f4397c.get(i)).intValue() : ((Integer) this.f4397c.get(i + 1)).intValue() - ((Integer) this.f4397c.get(i)).intValue();
        if (count != 1) {
            return count;
        }
        int a = mo6471a(i);
        int zzfs = this.f4364a.zzfs(a);
        String b = mo6475b();
        if (b == null || this.f4364a.zzd(b, a, zzfs) != null) {
            return count;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo6475b() {
        return null;
    }

    public final Object get(int i) {
        m6002c();
        return mo6472a(mo6471a(i), mo6474b(i));
    }

    public int getCount() {
        m6002c();
        return this.f4397c.size();
    }
}
