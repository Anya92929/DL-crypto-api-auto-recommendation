package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class zzaod extends zzaoo {

    /* renamed from: a */
    private static final Writer f5833a = new C1454bs();

    /* renamed from: b */
    private static final zzanb f5834b = new zzanb("closed");

    /* renamed from: c */
    private final List f5835c = new ArrayList();

    /* renamed from: d */
    private String f5836d;

    /* renamed from: e */
    private zzamv f5837e = zzamx.bei;

    public zzaod() {
        super(f5833a);
    }

    /* renamed from: a */
    private zzamv m6704a() {
        return (zzamv) this.f5835c.get(this.f5835c.size() - 1);
    }

    /* renamed from: a */
    private void m6705a(zzamv zzamv) {
        if (this.f5836d != null) {
            if (!zzamv.zzczj() || mo7949y()) {
                ((zzamy) m6704a()).zza(this.f5836d, zzamv);
            }
            this.f5836d = null;
        } else if (this.f5835c.isEmpty()) {
            this.f5837e = zzamv;
        } else {
            zzamv a = m6704a();
            if (a instanceof zzams) {
                ((zzams) a).zzc(zzamv);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public void close() {
        if (!this.f5835c.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f5835c.add(f5834b);
    }

    /* renamed from: f */
    public zzamv mo7920f() {
        if (this.f5835c.isEmpty()) {
            return this.f5837e;
        }
        String valueOf = String.valueOf(this.f5835c);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 34).append("Expected one JSON element but was ").append(valueOf).toString());
    }

    public void flush() {
    }

    /* renamed from: h */
    public zzaoo mo7922h() {
        zzams zzams = new zzams();
        m6705a(zzams);
        this.f5835c.add(zzams);
        return this;
    }

    /* renamed from: i */
    public zzaoo mo7923i() {
        if (this.f5835c.isEmpty() || this.f5836d != null) {
            throw new IllegalStateException();
        } else if (m6704a() instanceof zzams) {
            this.f5835c.remove(this.f5835c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: j */
    public zzaoo mo7924j() {
        zzamy zzamy = new zzamy();
        m6705a(zzamy);
        this.f5835c.add(zzamy);
        return this;
    }

    /* renamed from: k */
    public zzaoo mo7925k() {
        if (this.f5835c.isEmpty() || this.f5836d != null) {
            throw new IllegalStateException();
        } else if (m6704a() instanceof zzamy) {
            this.f5835c.remove(this.f5835c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: l */
    public zzaoo mo7926l() {
        m6705a(zzamx.bei);
        return this;
    }

    public zzaoo zza(Number number) {
        if (number == null) {
            return mo7926l();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                String valueOf = String.valueOf(number);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("JSON forbids NaN and infinities: ").append(valueOf).toString());
            }
        }
        m6705a(new zzanb(number));
        return this;
    }

    public zzaoo zzcr(long j) {
        m6705a(new zzanb((Number) Long.valueOf(j)));
        return this;
    }

    public zzaoo zzda(boolean z) {
        m6705a(new zzanb(Boolean.valueOf(z)));
        return this;
    }

    public zzaoo zztr(String str) {
        if (this.f5835c.isEmpty() || this.f5836d != null) {
            throw new IllegalStateException();
        } else if (m6704a() instanceof zzamy) {
            this.f5836d = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public zzaoo zzts(String str) {
        if (str == null) {
            return mo7926l();
        }
        m6705a(new zzanb(str));
        return this;
    }
}
