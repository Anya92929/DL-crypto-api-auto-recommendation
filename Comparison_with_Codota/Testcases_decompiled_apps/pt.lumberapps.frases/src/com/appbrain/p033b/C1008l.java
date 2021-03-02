package com.appbrain.p033b;

import android.support.p009v4.app.FragmentTransaction;
import android.support.p009v4.app.NotificationCompat;
import java.io.OutputStream;

/* renamed from: com.appbrain.b.l */
public final class C1008l {

    /* renamed from: a */
    private final byte[] f2653a;

    /* renamed from: b */
    private final int f2654b;

    /* renamed from: c */
    private int f2655c;

    /* renamed from: d */
    private int f2656d;

    /* renamed from: e */
    private final OutputStream f2657e;

    private C1008l(OutputStream outputStream, byte[] bArr) {
        this.f2656d = 0;
        this.f2657e = outputStream;
        this.f2653a = bArr;
        this.f2655c = 0;
        this.f2654b = bArr.length;
    }

    private C1008l(byte[] bArr, int i) {
        this.f2656d = 0;
        this.f2657e = null;
        this.f2653a = bArr;
        this.f2655c = 0;
        this.f2654b = i + 0;
    }

    /* renamed from: a */
    public static int m4210a(int i) {
        return m4225h(i) + 4;
    }

    /* renamed from: a */
    public static C1008l m4211a(OutputStream outputStream) {
        return m4212a(outputStream, (int) FragmentTransaction.TRANSIT_ENTER_MASK);
    }

    /* renamed from: a */
    public static C1008l m4212a(OutputStream outputStream, int i) {
        return new C1008l(outputStream, new byte[i]);
    }

    /* renamed from: a */
    public static C1008l m4213a(byte[] bArr) {
        return new C1008l(bArr, bArr.length);
    }

    /* renamed from: b */
    public static int m4214b(int i) {
        return m4225h(i) + 1;
    }

    /* renamed from: b */
    public static int m4215b(int i, long j) {
        return ((-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10) + m4225h(i);
    }

    /* renamed from: b */
    public static int m4216b(int i, C1002f fVar) {
        return m4225h(i) + m4218b(fVar);
    }

    /* renamed from: b */
    public static int m4217b(int i, C1020x xVar) {
        int h = m4225h(i);
        int c = xVar.mo4026c();
        return h + c + m4226i(c);
    }

    /* renamed from: b */
    public static int m4218b(C1002f fVar) {
        return m4226i(fVar.mo3919a()) + fVar.mo3919a();
    }

    /* renamed from: c */
    public static int m4219c(int i) {
        if (i >= 0) {
            return m4226i(i);
        }
        return 10;
    }

    /* renamed from: c */
    public static int m4220c(int i, int i2) {
        return m4225h(i) + m4219c(i2);
    }

    /* renamed from: c */
    private void m4221c() {
        if (this.f2657e == null) {
            throw new C1009m();
        }
        this.f2657e.write(this.f2653a, 0, this.f2655c);
        this.f2655c = 0;
    }

    /* renamed from: d */
    public static int m4222d(int i, int i2) {
        return m4225h(i) + m4219c(i2);
    }

    /* renamed from: e */
    private void m4223e(int i, int i2) {
        mo4005e(C0997al.m4145a(i, i2));
    }

    /* renamed from: g */
    private void m4224g(int i) {
        if (i >= 0) {
            mo4005e(i);
        } else {
            mo3999a((long) i);
        }
    }

    /* renamed from: h */
    private static int m4225h(int i) {
        return m4226i(C0997al.m4145a(i, 0));
    }

    /* renamed from: i */
    private static int m4226i(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (-268435456 & i) == 0 ? 4 : 5;
    }

    /* renamed from: a */
    public final void mo3992a() {
        if (this.f2657e != null) {
            m4221c();
        }
    }

    /* renamed from: a */
    public final void mo3993a(int i, float f) {
        m4223e(i, 5);
        mo4006f(Float.floatToRawIntBits(f));
    }

    /* renamed from: a */
    public final void mo3994a(int i, int i2) {
        m4223e(i, 0);
        m4224g(i2);
    }

    /* renamed from: a */
    public final void mo3995a(int i, long j) {
        m4223e(i, 0);
        mo3999a(j);
    }

    /* renamed from: a */
    public final void mo3996a(int i, C1002f fVar) {
        m4223e(i, 2);
        mo4000a(fVar);
    }

    /* renamed from: a */
    public final void mo3997a(int i, C1020x xVar) {
        m4223e(i, 2);
        mo4005e(xVar.mo4026c());
        xVar.mo4025a(this);
    }

    /* renamed from: a */
    public final void mo3998a(int i, boolean z) {
        int i2 = 0;
        m4223e(i, 0);
        if (z) {
            i2 = 1;
        }
        mo4004d(i2);
    }

    /* renamed from: a */
    public final void mo3999a(long j) {
        while ((-128 & j) != 0) {
            mo4004d((((int) j) & 127) | NotificationCompat.FLAG_HIGH_PRIORITY);
            j >>>= 7;
        }
        mo4004d((int) j);
    }

    /* renamed from: a */
    public final void mo4000a(C1002f fVar) {
        mo4005e(fVar.mo3919a());
        mo4003c(fVar);
    }

    /* renamed from: b */
    public final void mo4001b() {
        if (this.f2657e != null) {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
        } else if (this.f2654b - this.f2655c != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: b */
    public final void mo4002b(int i, int i2) {
        m4223e(i, 0);
        m4224g(i2);
    }

    /* renamed from: c */
    public final void mo4003c(C1002f fVar) {
        int a = fVar.mo3919a();
        if (this.f2654b - this.f2655c >= a) {
            fVar.mo3968b(this.f2653a, 0, this.f2655c, a);
            this.f2655c += a;
        } else {
            int i = this.f2654b - this.f2655c;
            fVar.mo3968b(this.f2653a, 0, this.f2655c, i);
            int i2 = i + 0;
            a -= i;
            this.f2655c = this.f2654b;
            this.f2656d = i + this.f2656d;
            m4221c();
            if (a <= this.f2654b) {
                fVar.mo3968b(this.f2653a, i2, 0, a);
                this.f2655c = a;
            } else {
                OutputStream outputStream = this.f2657e;
                if (i2 < 0) {
                    throw new IndexOutOfBoundsException("Source offset < 0: " + i2);
                } else if (a < 0) {
                    throw new IndexOutOfBoundsException("Length < 0: " + a);
                } else if (i2 + a > fVar.mo3919a()) {
                    throw new IndexOutOfBoundsException("Source end offset exceeded: " + (a + i2));
                } else if (a > 0) {
                    fVar.mo3921a(outputStream, i2, a);
                }
            }
        }
        this.f2656d = a + this.f2656d;
    }

    /* renamed from: d */
    public final void mo4004d(int i) {
        byte b = (byte) i;
        if (this.f2655c == this.f2654b) {
            m4221c();
        }
        byte[] bArr = this.f2653a;
        int i2 = this.f2655c;
        this.f2655c = i2 + 1;
        bArr[i2] = b;
        this.f2656d++;
    }

    /* renamed from: e */
    public final void mo4005e(int i) {
        while ((i & -128) != 0) {
            mo4004d((i & 127) | NotificationCompat.FLAG_HIGH_PRIORITY);
            i >>>= 7;
        }
        mo4004d(i);
    }

    /* renamed from: f */
    public final void mo4006f(int i) {
        mo4004d(i & 255);
        mo4004d((i >> 8) & 255);
        mo4004d((i >> 16) & 255);
        mo4004d((i >> 24) & 255);
    }
}
