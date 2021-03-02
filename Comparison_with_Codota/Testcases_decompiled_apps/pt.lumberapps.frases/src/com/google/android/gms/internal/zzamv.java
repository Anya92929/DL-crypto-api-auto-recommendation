package com.google.android.gms.internal;

import java.io.IOException;
import java.io.StringWriter;

public abstract class zzamv {
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Boolean mo7838a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double getAsDouble() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int getAsInt() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long getAsLong() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            zzaoo zzaoo = new zzaoo(stringWriter);
            zzaoo.setLenient(true);
            zzanw.zzb(this, zzaoo);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public Number zzcze() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String zzczf() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean zzczg() {
        return this instanceof zzams;
    }

    public boolean zzczh() {
        return this instanceof zzamy;
    }

    public boolean zzczi() {
        return this instanceof zzanb;
    }

    public boolean zzczj() {
        return this instanceof zzamx;
    }

    public zzamy zzczk() {
        if (zzczh()) {
            return (zzamy) this;
        }
        String valueOf = String.valueOf(this);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 19).append("Not a JSON Object: ").append(valueOf).toString());
    }

    public zzams zzczl() {
        if (zzczg()) {
            return (zzams) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public zzanb zzczm() {
        if (zzczi()) {
            return (zzanb) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }
}
