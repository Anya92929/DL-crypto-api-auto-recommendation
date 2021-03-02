package com.appbrain.p033b;

import android.support.p009v4.app.FragmentTransaction;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.appbrain.b.j */
public final class C1006j {

    /* renamed from: a */
    private final byte[] f2639a;

    /* renamed from: b */
    private final boolean f2640b;

    /* renamed from: c */
    private int f2641c;

    /* renamed from: d */
    private int f2642d;

    /* renamed from: e */
    private int f2643e;

    /* renamed from: f */
    private final InputStream f2644f;

    /* renamed from: g */
    private int f2645g;

    /* renamed from: h */
    private boolean f2646h;

    /* renamed from: i */
    private int f2647i;

    /* renamed from: j */
    private int f2648j;

    /* renamed from: k */
    private int f2649k;

    /* renamed from: l */
    private int f2650l;

    /* renamed from: m */
    private int f2651m;

    /* renamed from: n */
    private C1007k f2652n;

    private C1006j(InputStream inputStream) {
        this.f2646h = false;
        this.f2648j = Integer.MAX_VALUE;
        this.f2650l = 64;
        this.f2651m = 67108864;
        this.f2652n = null;
        this.f2639a = new byte[FragmentTransaction.TRANSIT_ENTER_MASK];
        this.f2641c = 0;
        this.f2643e = 0;
        this.f2647i = 0;
        this.f2644f = inputStream;
        this.f2640b = false;
    }

    private C1006j(byte[] bArr, int i) {
        this.f2646h = false;
        this.f2648j = Integer.MAX_VALUE;
        this.f2650l = 64;
        this.f2651m = 67108864;
        this.f2652n = null;
        this.f2639a = bArr;
        this.f2641c = i + 0;
        this.f2643e = 0;
        this.f2647i = 0;
        this.f2644f = null;
        this.f2640b = false;
    }

    /* renamed from: a */
    public static C1006j m4186a(InputStream inputStream) {
        return new C1006j(inputStream);
    }

    /* renamed from: a */
    public static C1006j m4187a(byte[] bArr, int i) {
        C1006j jVar = new C1006j(bArr, i);
        try {
            jVar.mo3983b(i);
            return jVar;
        } catch (C1015s e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: d */
    private void m4188d(int i) {
        if (!m4189e(i)) {
            throw C1015s.m4249a();
        }
    }

    /* renamed from: e */
    private boolean m4189e(int i) {
        while (this.f2643e + i > this.f2641c) {
            if (this.f2647i + this.f2643e + i > this.f2648j || this.f2644f == null) {
                return false;
            }
            int i2 = this.f2643e;
            if (i2 > 0) {
                if (this.f2641c > i2) {
                    System.arraycopy(this.f2639a, i2, this.f2639a, 0, this.f2641c - i2);
                }
                this.f2647i += i2;
                this.f2641c -= i2;
                this.f2643e = 0;
            }
            int read = this.f2644f.read(this.f2639a, this.f2641c, this.f2639a.length - this.f2641c);
            if (read == 0 || read < -1 || read > this.f2639a.length) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
            } else if (read <= 0) {
                return false;
            } else {
                this.f2641c = read + this.f2641c;
                if ((this.f2647i + i) - this.f2651m > 0) {
                    throw C1015s.m4256h();
                }
                m4195m();
                if (this.f2641c >= i) {
                    return true;
                }
            }
        }
        throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
    }

    /* renamed from: f */
    private byte[] m4190f(int i) {
        if (i <= 0) {
            if (i == 0) {
                return C1013q.f2662a;
            }
            throw C1015s.m4250b();
        } else if (this.f2647i + this.f2643e + i > this.f2648j) {
            m4191g((this.f2648j - this.f2647i) - this.f2643e);
            throw C1015s.m4249a();
        } else if (i < 4096) {
            byte[] bArr = new byte[i];
            int i2 = this.f2641c - this.f2643e;
            System.arraycopy(this.f2639a, this.f2643e, bArr, 0, i2);
            this.f2643e = this.f2641c;
            int i3 = i - i2;
            if (this.f2641c - this.f2643e < i3) {
                m4188d(i3);
            }
            System.arraycopy(this.f2639a, 0, bArr, i2, i - i2);
            this.f2643e = i - i2;
            return bArr;
        } else {
            int i4 = this.f2643e;
            int i5 = this.f2641c;
            this.f2647i += this.f2641c;
            this.f2643e = 0;
            this.f2641c = 0;
            ArrayList arrayList = new ArrayList();
            int i6 = i - (i5 - i4);
            while (i6 > 0) {
                byte[] bArr2 = new byte[Math.min(i6, FragmentTransaction.TRANSIT_ENTER_MASK)];
                int i7 = 0;
                while (i7 < bArr2.length) {
                    int read = this.f2644f == null ? -1 : this.f2644f.read(bArr2, i7, bArr2.length - i7);
                    if (read == -1) {
                        throw C1015s.m4249a();
                    }
                    this.f2647i += read;
                    i7 += read;
                }
                arrayList.add(bArr2);
                i6 -= bArr2.length;
            }
            byte[] bArr3 = new byte[i];
            int i8 = i5 - i4;
            System.arraycopy(this.f2639a, i4, bArr3, 0, i8);
            Iterator it = arrayList.iterator();
            while (true) {
                int i9 = i8;
                if (!it.hasNext()) {
                    return bArr3;
                }
                byte[] bArr4 = (byte[]) it.next();
                System.arraycopy(bArr4, 0, bArr3, i9, bArr4.length);
                i8 = bArr4.length + i9;
            }
        }
    }

    /* renamed from: g */
    private void m4191g(int i) {
        if (i <= this.f2641c - this.f2643e && i >= 0) {
            this.f2643e += i;
        } else if (i < 0) {
            throw C1015s.m4250b();
        } else if (this.f2647i + this.f2643e + i > this.f2648j) {
            m4191g((this.f2648j - this.f2647i) - this.f2643e);
            throw C1015s.m4249a();
        } else {
            int i2 = this.f2641c - this.f2643e;
            this.f2643e = this.f2641c;
            m4188d(1);
            while (i - i2 > this.f2641c) {
                i2 += this.f2641c;
                this.f2643e = this.f2641c;
                m4188d(1);
            }
            this.f2643e = i - i2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b9, code lost:
        if (((long) r4[r3]) < 0) goto L_0x00bb;
     */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long m4192j() {
        /*
            r10 = this;
            r8 = 0
            int r0 = r10.f2643e
            int r1 = r10.f2641c
            if (r1 == r0) goto L_0x00bb
            byte[] r4 = r10.f2639a
            int r1 = r0 + 1
            byte r0 = r4[r0]
            if (r0 < 0) goto L_0x0014
            r10.f2643e = r1
            long r0 = (long) r0
        L_0x0013:
            return r0
        L_0x0014:
            int r2 = r10.f2641c
            int r2 = r2 - r1
            r3 = 9
            if (r2 < r3) goto L_0x00bb
            int r2 = r1 + 1
            byte r1 = r4[r1]
            int r1 = r1 << 7
            r0 = r0 ^ r1
            long r0 = (long) r0
            int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x002d
            r4 = -128(0xffffffffffffff80, double:NaN)
            long r0 = r0 ^ r4
        L_0x002a:
            r10.f2643e = r2
            goto L_0x0013
        L_0x002d:
            int r3 = r2 + 1
            byte r2 = r4[r2]
            int r2 = r2 << 14
            long r6 = (long) r2
            long r0 = r0 ^ r6
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 < 0) goto L_0x003e
            r4 = 16256(0x3f80, double:8.0315E-320)
            long r0 = r0 ^ r4
            r2 = r3
            goto L_0x002a
        L_0x003e:
            int r2 = r3 + 1
            byte r3 = r4[r3]
            int r3 = r3 << 21
            long r6 = (long) r3
            long r0 = r0 ^ r6
            int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x004f
            r4 = -2080896(0xffffffffffe03f80, double:NaN)
            long r0 = r0 ^ r4
            goto L_0x002a
        L_0x004f:
            int r3 = r2 + 1
            byte r2 = r4[r2]
            long r6 = (long) r2
            r2 = 28
            long r6 = r6 << r2
            long r0 = r0 ^ r6
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 < 0) goto L_0x0062
            r4 = 266354560(0xfe03f80, double:1.315966377E-315)
            long r0 = r0 ^ r4
            r2 = r3
            goto L_0x002a
        L_0x0062:
            int r2 = r3 + 1
            byte r3 = r4[r3]
            long r6 = (long) r3
            r3 = 35
            long r6 = r6 << r3
            long r0 = r0 ^ r6
            int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x0076
            r4 = -34093383808(0xfffffff80fe03f80, double:NaN)
            long r0 = r0 ^ r4
            goto L_0x002a
        L_0x0076:
            int r3 = r2 + 1
            byte r2 = r4[r2]
            long r6 = (long) r2
            r2 = 42
            long r6 = r6 << r2
            long r0 = r0 ^ r6
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 < 0) goto L_0x008b
            r4 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            long r0 = r0 ^ r4
            r2 = r3
            goto L_0x002a
        L_0x008b:
            int r2 = r3 + 1
            byte r3 = r4[r3]
            long r6 = (long) r3
            r3 = 49
            long r6 = r6 << r3
            long r0 = r0 ^ r6
            int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x009f
            r4 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            long r0 = r0 ^ r4
            goto L_0x002a
        L_0x009f:
            int r3 = r2 + 1
            byte r2 = r4[r2]
            long r6 = (long) r2
            r2 = 56
            long r6 = r6 << r2
            long r0 = r0 ^ r6
            r6 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r0 = r0 ^ r6
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x00c1
            int r2 = r3 + 1
            byte r3 = r4[r3]
            long r4 = (long) r3
            int r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x002a
        L_0x00bb:
            long r0 = r10.m4193k()
            goto L_0x0013
        L_0x00c1:
            r2 = r3
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appbrain.p033b.C1006j.m4192j():long");
    }

    /* renamed from: k */
    private long m4193k() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            if (this.f2643e == this.f2641c) {
                m4188d(1);
            }
            byte[] bArr = this.f2639a;
            int i2 = this.f2643e;
            this.f2643e = i2 + 1;
            byte b = bArr[i2];
            j |= ((long) (b & Byte.MAX_VALUE)) << i;
            if ((b & 128) == 0) {
                return j;
            }
        }
        throw C1015s.m4251c();
    }

    /* renamed from: l */
    private int m4194l() {
        int i = this.f2643e;
        if (this.f2641c - i < 4) {
            m4188d(4);
            i = this.f2643e;
        }
        byte[] bArr = this.f2639a;
        this.f2643e = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* renamed from: m */
    private void m4195m() {
        this.f2641c += this.f2642d;
        int i = this.f2647i + this.f2641c;
        if (i > this.f2648j) {
            this.f2642d = i - this.f2648j;
            this.f2641c -= this.f2642d;
            return;
        }
        this.f2642d = 0;
    }

    /* renamed from: a */
    public final int mo3978a() {
        boolean z = true;
        if (this.f2643e != this.f2641c || m4189e(1)) {
            z = false;
        }
        if (z) {
            this.f2645g = 0;
            return 0;
        }
        this.f2645g = mo3990h();
        if (C0997al.m4146b(this.f2645g) != 0) {
            return this.f2645g;
        }
        throw C1015s.m4252d();
    }

    /* renamed from: a */
    public final C1020x mo3979a(C0986aa aaVar, C1010n nVar) {
        int h = mo3990h();
        if (this.f2649k >= this.f2650l) {
            throw C1015s.m4255g();
        }
        int b = mo3983b(h);
        this.f2649k++;
        C1020x xVar = (C1020x) aaVar.mo3916a(this, nVar);
        mo3980a(0);
        this.f2649k--;
        mo3985c(b);
        return xVar;
    }

    /* renamed from: a */
    public final void mo3980a(int i) {
        if (this.f2645g != i) {
            throw C1015s.m4253e();
        }
    }

    /* renamed from: a */
    public final boolean mo3981a(int i, C1008l lVar) {
        int a;
        switch (C0997al.m4144a(i)) {
            case 0:
                long j = m4192j();
                lVar.mo4005e(i);
                lVar.mo3999a(j);
                return true;
            case 1:
                int i2 = this.f2643e;
                if (this.f2641c - i2 < 8) {
                    m4188d(8);
                    i2 = this.f2643e;
                }
                byte[] bArr = this.f2639a;
                this.f2643e = i2 + 8;
                long j2 = ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
                lVar.mo4005e(i);
                lVar.mo4004d(((int) j2) & 255);
                lVar.mo4004d(((int) (j2 >> 8)) & 255);
                lVar.mo4004d(((int) (j2 >> 16)) & 255);
                lVar.mo4004d(((int) (j2 >> 24)) & 255);
                lVar.mo4004d(((int) (j2 >> 32)) & 255);
                lVar.mo4004d(((int) (j2 >> 40)) & 255);
                lVar.mo4004d(((int) (j2 >> 48)) & 255);
                lVar.mo4004d(((int) (j2 >> 56)) & 255);
                return true;
            case 2:
                C1002f f = mo3988f();
                lVar.mo4005e(i);
                lVar.mo4000a(f);
                return true;
            case 3:
                lVar.mo4005e(i);
                do {
                    a = mo3978a();
                    if (a == 0 || !mo3981a(a, lVar)) {
                        int a2 = C0997al.m4145a(C0997al.m4146b(i), 4);
                        mo3980a(a2);
                        lVar.mo4005e(a2);
                        return true;
                    }
                    a = mo3978a();
                    int a22 = C0997al.m4145a(C0997al.m4146b(i), 4);
                    mo3980a(a22);
                    lVar.mo4005e(a22);
                    return true;
                } while (!mo3981a(a, lVar));
                int a222 = C0997al.m4145a(C0997al.m4146b(i), 4);
                mo3980a(a222);
                lVar.mo4005e(a222);
                return true;
            case 4:
                return false;
            case 5:
                int l = m4194l();
                lVar.mo4005e(i);
                lVar.mo4006f(l);
                return true;
            default:
                throw C1015s.m4254f();
        }
    }

    /* renamed from: b */
    public final float mo3982b() {
        return Float.intBitsToFloat(m4194l());
    }

    /* renamed from: b */
    public final int mo3983b(int i) {
        if (i < 0) {
            throw C1015s.m4250b();
        }
        int i2 = this.f2647i + this.f2643e + i;
        int i3 = this.f2648j;
        if (i2 > i3) {
            throw C1015s.m4249a();
        }
        this.f2648j = i2;
        m4195m();
        return i3;
    }

    /* renamed from: c */
    public final long mo3984c() {
        return m4192j();
    }

    /* renamed from: c */
    public final void mo3985c(int i) {
        this.f2648j = i;
        m4195m();
    }

    /* renamed from: d */
    public final int mo3986d() {
        return mo3990h();
    }

    /* renamed from: e */
    public final boolean mo3987e() {
        return m4192j() != 0;
    }

    /* renamed from: f */
    public final C1002f mo3988f() {
        int h = mo3990h();
        if (h > this.f2641c - this.f2643e || h <= 0) {
            return h == 0 ? C1002f.f2629a : new C1018v(m4190f(h));
        }
        C1002f a = (!this.f2640b || !this.f2646h) ? C1002f.m4162a(this.f2639a, this.f2643e, h) : new C1000d(this.f2639a, this.f2643e, h);
        this.f2643e = h + this.f2643e;
        return a;
    }

    /* renamed from: g */
    public final int mo3989g() {
        return mo3990h();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
        if (r3[r2] < 0) goto L_0x0081;
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int mo3990h() {
        /*
            r8 = this;
            r6 = 0
            int r0 = r8.f2643e
            int r1 = r8.f2641c
            if (r1 == r0) goto L_0x0081
            byte[] r3 = r8.f2639a
            int r2 = r0 + 1
            byte r0 = r3[r0]
            if (r0 < 0) goto L_0x0013
            r8.f2643e = r2
        L_0x0012:
            return r0
        L_0x0013:
            int r1 = r8.f2641c
            int r1 = r1 - r2
            r4 = 9
            if (r1 < r4) goto L_0x0081
            int r1 = r2 + 1
            byte r2 = r3[r2]
            int r2 = r2 << 7
            r0 = r0 ^ r2
            long r4 = (long) r0
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x002e
            long r2 = (long) r0
            r4 = -128(0xffffffffffffff80, double:NaN)
            long r2 = r2 ^ r4
            int r0 = (int) r2
        L_0x002b:
            r8.f2643e = r1
            goto L_0x0012
        L_0x002e:
            int r2 = r1 + 1
            byte r1 = r3[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            long r4 = (long) r0
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x0041
            long r0 = (long) r0
            r4 = 16256(0x3f80, double:8.0315E-320)
            long r0 = r0 ^ r4
            int r0 = (int) r0
            r1 = r2
            goto L_0x002b
        L_0x0041:
            int r1 = r2 + 1
            byte r2 = r3[r2]
            int r2 = r2 << 21
            r0 = r0 ^ r2
            long r4 = (long) r0
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x0054
            long r2 = (long) r0
            r4 = -2080896(0xffffffffffe03f80, double:NaN)
            long r2 = r2 ^ r4
            int r0 = (int) r2
            goto L_0x002b
        L_0x0054:
            int r2 = r1 + 1
            byte r1 = r3[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            long r4 = (long) r0
            r6 = 266354560(0xfe03f80, double:1.315966377E-315)
            long r4 = r4 ^ r6
            int r0 = (int) r4
            if (r1 >= 0) goto L_0x0087
            int r1 = r2 + 1
            byte r2 = r3[r2]
            if (r2 >= 0) goto L_0x002b
            int r2 = r1 + 1
            byte r1 = r3[r1]
            if (r1 >= 0) goto L_0x0087
            int r1 = r2 + 1
            byte r2 = r3[r2]
            if (r2 >= 0) goto L_0x002b
            int r2 = r1 + 1
            byte r1 = r3[r1]
            if (r1 >= 0) goto L_0x0087
            int r1 = r2 + 1
            byte r2 = r3[r2]
            if (r2 >= 0) goto L_0x002b
        L_0x0081:
            long r0 = r8.m4193k()
            int r0 = (int) r0
            goto L_0x0012
        L_0x0087:
            r1 = r2
            goto L_0x002b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appbrain.p033b.C1006j.mo3990h():int");
    }

    /* renamed from: i */
    public final int mo3991i() {
        if (this.f2648j == Integer.MAX_VALUE) {
            return -1;
        }
        return this.f2648j - (this.f2647i + this.f2643e);
    }
}
