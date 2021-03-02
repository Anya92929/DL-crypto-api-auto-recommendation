package com.google.android.gms.internal;

import android.support.p000v4.media.TransportMediator;
import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* renamed from: com.google.android.gms.internal.pf */
public final class C1710pf {
    private final int awx;
    private final byte[] buffer;
    private int position;

    /* renamed from: com.google.android.gms.internal.pf$a */
    public static class C1711a extends IOException {
        C1711a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private C1710pf(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.position = i;
        this.awx = i + i2;
    }

    /* renamed from: D */
    public static int m5992D(long j) {
        return m5994G(j);
    }

    /* renamed from: E */
    public static int m5993E(long j) {
        return m5994G(m5995I(j));
    }

    /* renamed from: G */
    public static int m5994G(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    /* renamed from: I */
    public static long m5995I(long j) {
        return (j << 1) ^ (j >> 63);
    }

    /* renamed from: V */
    public static int m5996V(boolean z) {
        return 1;
    }

    /* renamed from: b */
    public static int m5997b(int i, double d) {
        return m6015gy(i) + m6010f(d);
    }

    /* renamed from: b */
    public static int m5998b(int i, C1718pm pmVar) {
        return (m6015gy(i) * 2) + m6005d(pmVar);
    }

    /* renamed from: b */
    public static int m5999b(int i, byte[] bArr) {
        return m6015gy(i) + m6018s(bArr);
    }

    /* renamed from: b */
    public static C1710pf m6000b(byte[] bArr, int i, int i2) {
        return new C1710pf(bArr, i, i2);
    }

    /* renamed from: c */
    public static int m6001c(int i, float f) {
        return m6015gy(i) + m6007e(f);
    }

    /* renamed from: c */
    public static int m6002c(int i, C1718pm pmVar) {
        return m6015gy(i) + m6009e(pmVar);
    }

    /* renamed from: c */
    public static int m6003c(int i, boolean z) {
        return m6015gy(i) + m5996V(z);
    }

    /* renamed from: d */
    public static int m6004d(int i, long j) {
        return m6015gy(i) + m5992D(j);
    }

    /* renamed from: d */
    public static int m6005d(C1718pm pmVar) {
        return pmVar.mo10106qG();
    }

    /* renamed from: df */
    public static int m6006df(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + m6011gA(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    /* renamed from: e */
    public static int m6007e(float f) {
        return 4;
    }

    /* renamed from: e */
    public static int m6008e(int i, long j) {
        return m6015gy(i) + m5993E(j);
    }

    /* renamed from: e */
    public static int m6009e(C1718pm pmVar) {
        int qG = pmVar.mo10106qG();
        return qG + m6011gA(qG);
    }

    /* renamed from: f */
    public static int m6010f(double d) {
        return 8;
    }

    /* renamed from: gA */
    public static int m6011gA(int i) {
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

    /* renamed from: gC */
    public static int m6012gC(int i) {
        return (i << 1) ^ (i >> 31);
    }

    /* renamed from: gv */
    public static int m6013gv(int i) {
        if (i >= 0) {
            return m6011gA(i);
        }
        return 10;
    }

    /* renamed from: gw */
    public static int m6014gw(int i) {
        return m6011gA(m6012gC(i));
    }

    /* renamed from: gy */
    public static int m6015gy(int i) {
        return m6011gA(C1721pp.m6109x(i, 0));
    }

    /* renamed from: j */
    public static int m6016j(int i, String str) {
        return m6015gy(i) + m6006df(str);
    }

    /* renamed from: q */
    public static C1710pf m6017q(byte[] bArr) {
        return m6000b(bArr, 0, bArr.length);
    }

    /* renamed from: s */
    public static int m6018s(byte[] bArr) {
        return m6011gA(bArr.length) + bArr.length;
    }

    /* renamed from: u */
    public static int m6019u(int i, int i2) {
        return m6015gy(i) + m6013gv(i2);
    }

    /* renamed from: v */
    public static int m6020v(int i, int i2) {
        return m6015gy(i) + m6014gw(i2);
    }

    /* renamed from: B */
    public void mo10047B(long j) throws IOException {
        mo10049F(j);
    }

    /* renamed from: C */
    public void mo10048C(long j) throws IOException {
        mo10049F(m5995I(j));
    }

    /* renamed from: F */
    public void mo10049F(long j) throws IOException {
        while ((-128 & j) != 0) {
            mo10070gx((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        mo10070gx((int) j);
    }

    /* renamed from: H */
    public void mo10050H(long j) throws IOException {
        mo10070gx(((int) j) & MotionEventCompat.ACTION_MASK);
        mo10070gx(((int) (j >> 8)) & MotionEventCompat.ACTION_MASK);
        mo10070gx(((int) (j >> 16)) & MotionEventCompat.ACTION_MASK);
        mo10070gx(((int) (j >> 24)) & MotionEventCompat.ACTION_MASK);
        mo10070gx(((int) (j >> 32)) & MotionEventCompat.ACTION_MASK);
        mo10070gx(((int) (j >> 40)) & MotionEventCompat.ACTION_MASK);
        mo10070gx(((int) (j >> 48)) & MotionEventCompat.ACTION_MASK);
        mo10070gx(((int) (j >> 56)) & MotionEventCompat.ACTION_MASK);
    }

    /* renamed from: U */
    public void mo10051U(boolean z) throws IOException {
        mo10070gx(z ? 1 : 0);
    }

    /* renamed from: a */
    public void mo10052a(int i, double d) throws IOException {
        mo10078w(i, 1);
        mo10066e(d);
    }

    /* renamed from: a */
    public void mo10053a(int i, C1718pm pmVar) throws IOException {
        mo10078w(i, 2);
        mo10062c(pmVar);
    }

    /* renamed from: a */
    public void mo10054a(int i, byte[] bArr) throws IOException {
        mo10078w(i, 2);
        mo10074r(bArr);
    }

    /* renamed from: b */
    public void mo10055b(byte b) throws IOException {
        if (this.position == this.awx) {
            throw new C1711a(this.position, this.awx);
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    /* renamed from: b */
    public void mo10056b(int i, float f) throws IOException {
        mo10078w(i, 5);
        mo10064d(f);
    }

    /* renamed from: b */
    public void mo10057b(int i, long j) throws IOException {
        mo10078w(i, 0);
        mo10047B(j);
    }

    /* renamed from: b */
    public void mo10058b(int i, String str) throws IOException {
        mo10078w(i, 2);
        mo10065de(str);
    }

    /* renamed from: b */
    public void mo10059b(int i, boolean z) throws IOException {
        mo10078w(i, 0);
        mo10051U(z);
    }

    /* renamed from: b */
    public void mo10060b(C1718pm pmVar) throws IOException {
        pmVar.mo4922a(this);
    }

    /* renamed from: c */
    public void mo10061c(int i, long j) throws IOException {
        mo10078w(i, 0);
        mo10048C(j);
    }

    /* renamed from: c */
    public void mo10062c(C1718pm pmVar) throws IOException {
        mo10071gz(pmVar.mo10105qF());
        pmVar.mo4922a(this);
    }

    /* renamed from: c */
    public void mo10063c(byte[] bArr, int i, int i2) throws IOException {
        if (this.awx - this.position >= i2) {
            System.arraycopy(bArr, i, this.buffer, this.position, i2);
            this.position += i2;
            return;
        }
        throw new C1711a(this.position, this.awx);
    }

    /* renamed from: d */
    public void mo10064d(float f) throws IOException {
        mo10067gB(Float.floatToIntBits(f));
    }

    /* renamed from: de */
    public void mo10065de(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        mo10071gz(bytes.length);
        mo10077t(bytes);
    }

    /* renamed from: e */
    public void mo10066e(double d) throws IOException {
        mo10050H(Double.doubleToLongBits(d));
    }

    /* renamed from: gB */
    public void mo10067gB(int i) throws IOException {
        mo10070gx(i & MotionEventCompat.ACTION_MASK);
        mo10070gx((i >> 8) & MotionEventCompat.ACTION_MASK);
        mo10070gx((i >> 16) & MotionEventCompat.ACTION_MASK);
        mo10070gx((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    /* renamed from: gt */
    public void mo10068gt(int i) throws IOException {
        if (i >= 0) {
            mo10071gz(i);
        } else {
            mo10049F((long) i);
        }
    }

    /* renamed from: gu */
    public void mo10069gu(int i) throws IOException {
        mo10071gz(m6012gC(i));
    }

    /* renamed from: gx */
    public void mo10070gx(int i) throws IOException {
        mo10055b((byte) i);
    }

    /* renamed from: gz */
    public void mo10071gz(int i) throws IOException {
        while ((i & -128) != 0) {
            mo10070gx((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        mo10070gx(i);
    }

    /* renamed from: qv */
    public int mo10072qv() {
        return this.awx - this.position;
    }

    /* renamed from: qw */
    public void mo10073qw() {
        if (mo10072qv() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: r */
    public void mo10074r(byte[] bArr) throws IOException {
        mo10071gz(bArr.length);
        mo10077t(bArr);
    }

    /* renamed from: s */
    public void mo10075s(int i, int i2) throws IOException {
        mo10078w(i, 0);
        mo10068gt(i2);
    }

    /* renamed from: t */
    public void mo10076t(int i, int i2) throws IOException {
        mo10078w(i, 0);
        mo10069gu(i2);
    }

    /* renamed from: t */
    public void mo10077t(byte[] bArr) throws IOException {
        mo10063c(bArr, 0, bArr.length);
    }

    /* renamed from: w */
    public void mo10078w(int i, int i2) throws IOException {
        mo10071gz(C1721pp.m6109x(i, i2));
    }
}
