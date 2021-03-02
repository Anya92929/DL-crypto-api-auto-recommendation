package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzams extends zzamv implements Iterable {

    /* renamed from: a */
    private final List f5790a = new ArrayList();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzams) && ((zzams) obj).f5790a.equals(this.f5790a));
    }

    public boolean getAsBoolean() {
        if (this.f5790a.size() == 1) {
            return ((zzamv) this.f5790a.get(0)).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public double getAsDouble() {
        if (this.f5790a.size() == 1) {
            return ((zzamv) this.f5790a.get(0)).getAsDouble();
        }
        throw new IllegalStateException();
    }

    public int getAsInt() {
        if (this.f5790a.size() == 1) {
            return ((zzamv) this.f5790a.get(0)).getAsInt();
        }
        throw new IllegalStateException();
    }

    public long getAsLong() {
        if (this.f5790a.size() == 1) {
            return ((zzamv) this.f5790a.get(0)).getAsLong();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.f5790a.hashCode();
    }

    public Iterator iterator() {
        return this.f5790a.iterator();
    }

    public void zzc(zzamv zzamv) {
        if (zzamv == null) {
            zzamv = zzamx.bei;
        }
        this.f5790a.add(zzamv);
    }

    public Number zzcze() {
        if (this.f5790a.size() == 1) {
            return ((zzamv) this.f5790a.get(0)).zzcze();
        }
        throw new IllegalStateException();
    }

    public String zzczf() {
        if (this.f5790a.size() == 1) {
            return ((zzamv) this.f5790a.get(0)).zzczf();
        }
        throw new IllegalStateException();
    }
}
