package org.p004a.p005a.p025g.p031f;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;
import org.p004a.p005a.C0219a;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p032h.C0514a;
import org.p004a.p005a.p032h.C0519f;

/* renamed from: org.a.a.g.f.g */
public final class C0505g extends InputStream {

    /* renamed from: a */
    private final long f546a;

    /* renamed from: b */
    private long f547b = 0;

    /* renamed from: c */
    private boolean f548c = false;

    /* renamed from: d */
    private C0519f f549d = null;

    public C0505g(C0519f fVar, long j) {
        this.f549d = (C0519f) C0250b.m84a((Object) fVar, "Session input buffer");
        this.f546a = C0250b.m80a(j, "Content length");
    }

    public final int available() {
        if (this.f549d instanceof C0514a) {
            return Math.min(((C0514a) this.f549d).mo5282d(), (int) (this.f546a - this.f547b));
        }
        return 0;
    }

    public final void close() {
        if (!this.f548c) {
            try {
                if (this.f547b < this.f546a) {
                    do {
                    } while (read(new byte[2048]) >= 0);
                }
            } finally {
                this.f548c = true;
            }
        }
    }

    public final int read() {
        if (this.f548c) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.f547b >= this.f546a) {
            return -1;
        } else {
            int a = this.f549d.mo5233a();
            if (a != -1) {
                this.f547b++;
            } else if (this.f547b < this.f546a) {
                throw new C0219a("Premature end of Content-Length delimited message body (expected: " + this.f546a + "; received: " + this.f547b);
            }
            return a;
        }
    }

    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (this.f548c) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.f547b >= this.f546a) {
            return -1;
        } else {
            if (this.f547b + ((long) i2) > this.f546a) {
                i2 = (int) (this.f546a - this.f547b);
            }
            int a = this.f549d.mo5235a(bArr, i, i2);
            if (a != -1 || this.f547b >= this.f546a) {
                if (a > 0) {
                    this.f547b += (long) a;
                }
                return a;
            }
            throw new C0219a("Premature end of Content-Length delimited message body (expected: " + this.f546a + "; received: " + this.f547b);
        }
    }

    public final long skip(long j) {
        int read;
        if (j <= 0) {
            return 0;
        }
        byte[] bArr = new byte[2048];
        long min = Math.min(j, this.f546a - this.f547b);
        long j2 = 0;
        while (min > 0 && (read = read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH, min))) != -1) {
            j2 += (long) read;
            min -= (long) read;
        }
        return j2;
    }
}
