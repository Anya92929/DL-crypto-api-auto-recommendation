package org.p004a.p005a.p033i;

import java.util.NoSuchElementException;
import org.p004a.p005a.C0239aa;
import org.p004a.p005a.C0245ag;
import org.p004a.p005a.C0513h;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.i.n */
public final class C0535n implements C0245ag {

    /* renamed from: a */
    private C0513h f596a;

    /* renamed from: b */
    private String f597b;

    /* renamed from: c */
    private String f598c;

    /* renamed from: d */
    private int f599d = m1076a(-1);

    public C0535n(C0513h hVar) {
        this.f596a = (C0513h) C0250b.m84a((Object) hVar, "Header iterator");
    }

    /* renamed from: a */
    private int m1076a(int i) {
        int i2 = 0;
        if (i >= 0) {
            int a = C0250b.m78a(i, "Search position");
            int length = this.f597b.length();
            int i3 = a;
            boolean z = false;
            i2 = i3;
            while (!z && i2 < length) {
                char charAt = this.f597b.charAt(i2);
                if (m1077a(charAt)) {
                    z = true;
                } else if (m1079b(charAt)) {
                    i2++;
                } else if (m1081c(charAt)) {
                    throw new C0239aa("Tokens without separator (pos " + i2 + "): " + this.f597b);
                } else {
                    throw new C0239aa("Invalid character after token (pos " + i2 + "): " + this.f597b);
                }
            }
        } else if (!this.f596a.hasNext()) {
            return -1;
        } else {
            this.f597b = this.f596a.mo5316a().mo5041d();
        }
        int b = m1078b(i2);
        if (b < 0) {
            this.f598c = null;
            return -1;
        }
        int c = m1080c(b);
        this.f598c = this.f597b.substring(b, c);
        return c;
    }

    /* renamed from: a */
    private static boolean m1077a(char c) {
        return c == ',';
    }

    /* renamed from: b */
    private int m1078b(int i) {
        int a = C0250b.m78a(i, "Search position");
        boolean z = false;
        while (!z && this.f597b != null) {
            int length = this.f597b.length();
            boolean z2 = z;
            int i2 = a;
            boolean z3 = z2;
            while (!z3 && i2 < length) {
                char charAt = this.f597b.charAt(i2);
                if (m1077a(charAt) || m1079b(charAt)) {
                    i2++;
                } else if (m1081c(this.f597b.charAt(i2))) {
                    z3 = true;
                } else {
                    throw new C0239aa("Invalid character before token (pos " + i2 + "): " + this.f597b);
                }
            }
            if (!z3) {
                if (this.f596a.hasNext()) {
                    this.f597b = this.f596a.mo5316a().mo5041d();
                    z = z3;
                    a = 0;
                } else {
                    this.f597b = null;
                }
            }
            boolean z4 = z3;
            a = i2;
            z = z4;
        }
        if (z) {
            return a;
        }
        return -1;
    }

    /* renamed from: b */
    private static boolean m1079b(char c) {
        return c == 9 || Character.isSpaceChar(c);
    }

    /* renamed from: c */
    private int m1080c(int i) {
        C0250b.m78a(i, "Search position");
        int length = this.f597b.length();
        int i2 = i + 1;
        while (i2 < length && m1081c(this.f597b.charAt(i2))) {
            i2++;
        }
        return i2;
    }

    /* renamed from: c */
    private boolean m1081c(char c) {
        if (Character.isLetterOrDigit(c)) {
            return true;
        }
        if (Character.isISOControl(c)) {
            return false;
        }
        return !(" ,;=()<>@:\\\"/[]?{}\t".indexOf(c) >= 0);
    }

    /* renamed from: a */
    public final String mo4869a() {
        if (this.f598c == null) {
            throw new NoSuchElementException("Iteration already finished.");
        }
        String str = this.f598c;
        this.f599d = m1076a(this.f599d);
        return str;
    }

    public final boolean hasNext() {
        return this.f598c != null;
    }

    public final Object next() {
        return mo4869a();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Removing tokens is not supported.");
    }
}
