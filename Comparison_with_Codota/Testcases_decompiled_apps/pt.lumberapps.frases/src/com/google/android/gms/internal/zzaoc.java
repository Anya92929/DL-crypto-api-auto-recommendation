package com.google.android.gms.internal;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzaoc extends zzaom {

    /* renamed from: a */
    private static final Reader f5830a = new C1453br();

    /* renamed from: b */
    private static final Object f5831b = new Object();

    /* renamed from: c */
    private final List f5832c = new ArrayList();

    public zzaoc(zzamv zzamv) {
        super(f5830a);
        this.f5832c.add(zzamv);
    }

    /* renamed from: a */
    private Object m6699a() {
        return this.f5832c.get(this.f5832c.size() - 1);
    }

    /* renamed from: a */
    private void m6700a(zzaon zzaon) {
        if (mo7902b() != zzaon) {
            String valueOf = String.valueOf(zzaon);
            String valueOf2 = String.valueOf(mo7902b());
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
        }
    }

    /* renamed from: c */
    private Object m6701c() {
        return this.f5832c.remove(this.f5832c.size() - 1);
    }

    /* renamed from: b */
    public zzaon mo7902b() {
        if (this.f5832c.isEmpty()) {
            return zzaon.END_DOCUMENT;
        }
        Object a = m6699a();
        if (a instanceof Iterator) {
            boolean z = this.f5832c.get(this.f5832c.size() - 2) instanceof zzamy;
            Iterator it = (Iterator) a;
            if (!it.hasNext()) {
                return z ? zzaon.END_OBJECT : zzaon.END_ARRAY;
            }
            if (z) {
                return zzaon.NAME;
            }
            this.f5832c.add(it.next());
            return mo7902b();
        } else if (a instanceof zzamy) {
            return zzaon.BEGIN_OBJECT;
        } else {
            if (a instanceof zzams) {
                return zzaon.BEGIN_ARRAY;
            }
            if (a instanceof zzanb) {
                zzanb zzanb = (zzanb) a;
                if (zzanb.zzczq()) {
                    return zzaon.STRING;
                }
                if (zzanb.zzczo()) {
                    return zzaon.BOOLEAN;
                }
                if (zzanb.zzczp()) {
                    return zzaon.NUMBER;
                }
                throw new AssertionError();
            } else if (a instanceof zzamx) {
                return zzaon.NULL;
            } else {
                if (a == f5831b) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    public void beginArray() {
        m6700a(zzaon.BEGIN_ARRAY);
        this.f5832c.add(((zzams) m6699a()).iterator());
    }

    public void beginObject() {
        m6700a(zzaon.BEGIN_OBJECT);
        this.f5832c.add(((zzamy) m6699a()).entrySet().iterator());
    }

    public void close() {
        this.f5832c.clear();
        this.f5832c.add(f5831b);
    }

    /* renamed from: e */
    public void mo7906e() {
        m6700a(zzaon.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m6699a()).next();
        this.f5832c.add(entry.getValue());
        this.f5832c.add(new zzanb((String) entry.getKey()));
    }

    public void endArray() {
        m6700a(zzaon.END_ARRAY);
        m6701c();
        m6701c();
    }

    public void endObject() {
        m6700a(zzaon.END_OBJECT);
        m6701c();
        m6701c();
    }

    public boolean hasNext() {
        zzaon b = mo7902b();
        return (b == zzaon.END_OBJECT || b == zzaon.END_ARRAY) ? false : true;
    }

    public boolean nextBoolean() {
        m6700a(zzaon.BOOLEAN);
        return ((zzanb) m6701c()).getAsBoolean();
    }

    public double nextDouble() {
        zzaon b = mo7902b();
        if (b == zzaon.NUMBER || b == zzaon.STRING) {
            double asDouble = ((zzanb) m6699a()).getAsDouble();
            if (isLenient() || (!Double.isNaN(asDouble) && !Double.isInfinite(asDouble))) {
                m6701c();
                return asDouble;
            }
            throw new NumberFormatException(new StringBuilder(57).append("JSON forbids NaN and infinities: ").append(asDouble).toString());
        }
        String valueOf = String.valueOf(zzaon.NUMBER);
        String valueOf2 = String.valueOf(b);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public int nextInt() {
        zzaon b = mo7902b();
        if (b == zzaon.NUMBER || b == zzaon.STRING) {
            int asInt = ((zzanb) m6699a()).getAsInt();
            m6701c();
            return asInt;
        }
        String valueOf = String.valueOf(zzaon.NUMBER);
        String valueOf2 = String.valueOf(b);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public long nextLong() {
        zzaon b = mo7902b();
        if (b == zzaon.NUMBER || b == zzaon.STRING) {
            long asLong = ((zzanb) m6699a()).getAsLong();
            m6701c();
            return asLong;
        }
        String valueOf = String.valueOf(zzaon.NUMBER);
        String valueOf2 = String.valueOf(b);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public String nextName() {
        m6700a(zzaon.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m6699a()).next();
        this.f5832c.add(entry.getValue());
        return (String) entry.getKey();
    }

    public void nextNull() {
        m6700a(zzaon.NULL);
        m6701c();
    }

    public String nextString() {
        zzaon b = mo7902b();
        if (b == zzaon.STRING || b == zzaon.NUMBER) {
            return ((zzanb) m6701c()).zzczf();
        }
        String valueOf = String.valueOf(zzaon.STRING);
        String valueOf2 = String.valueOf(b);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public void skipValue() {
        if (mo7902b() == zzaon.NAME) {
            nextName();
        } else {
            m6701c();
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
