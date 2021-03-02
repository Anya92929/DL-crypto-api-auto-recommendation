package com.google.android.gms.internal;

import java.io.IOException;
import org.apache.commons.lang3.CharEncoding;

public final class zzsm {

    /* renamed from: a */
    private final byte[] f3271a;

    /* renamed from: b */
    private int f3272b;

    /* renamed from: c */
    private int f3273c;

    /* renamed from: d */
    private int f3274d;

    /* renamed from: e */
    private int f3275e;

    /* renamed from: f */
    private int f3276f;

    /* renamed from: g */
    private int f3277g = Integer.MAX_VALUE;

    /* renamed from: h */
    private int f3278h;

    /* renamed from: i */
    private int f3279i = 64;

    /* renamed from: j */
    private int f3280j = 67108864;

    private zzsm(byte[] bArr, int i, int i2) {
        this.f3271a = bArr;
        this.f3272b = i;
        this.f3273c = i + i2;
        this.f3275e = i;
    }

    /* renamed from: a */
    private void m4080a() {
        this.f3273c += this.f3274d;
        int i = this.f3273c;
        if (i > this.f3277g) {
            this.f3274d = i - this.f3277g;
            this.f3273c -= this.f3274d;
            return;
        }
        this.f3274d = 0;
    }

    public static zzsm zzD(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public static zzsm zza(byte[] bArr, int i, int i2) {
        return new zzsm(bArr, i, i2);
    }

    public static long zzan(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static int zzmp(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public int getPosition() {
        return this.f3275e - this.f3272b;
    }

    public byte[] readBytes() throws IOException {
        int zzJf = zzJf();
        if (zzJf > this.f3273c - this.f3275e || zzJf <= 0) {
            return zzJf == 0 ? zzsx.zzbuD : zzmt(zzJf);
        }
        byte[] bArr = new byte[zzJf];
        System.arraycopy(this.f3271a, this.f3275e, bArr, 0, zzJf);
        this.f3275e = zzJf + this.f3275e;
        return bArr;
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(zzJi());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(zzJh());
    }

    public String readString() throws IOException {
        int zzJf = zzJf();
        if (zzJf > this.f3273c - this.f3275e || zzJf <= 0) {
            return new String(zzmt(zzJf), CharEncoding.UTF_8);
        }
        String str = new String(this.f3271a, this.f3275e, zzJf, CharEncoding.UTF_8);
        this.f3275e = zzJf + this.f3275e;
        return str;
    }

    public int zzIX() throws IOException {
        if (zzJl()) {
            this.f3276f = 0;
            return 0;
        }
        this.f3276f = zzJf();
        if (this.f3276f != 0) {
            return this.f3276f;
        }
        throw zzst.m4104d();
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void zzIY() throws java.io.IOException {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r1.zzIX()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.zzmo(r0)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsm.zzIY():void");
    }

    public long zzIZ() throws IOException {
        return zzJg();
    }

    public long zzJa() throws IOException {
        return zzJg();
    }

    public int zzJb() throws IOException {
        return zzJf();
    }

    public boolean zzJc() throws IOException {
        return zzJf() != 0;
    }

    public int zzJd() throws IOException {
        return zzmp(zzJf());
    }

    public long zzJe() throws IOException {
        return zzan(zzJg());
    }

    public int zzJf() throws IOException {
        byte zzJm = zzJm();
        if (zzJm >= 0) {
            return zzJm;
        }
        byte b = zzJm & Byte.MAX_VALUE;
        byte zzJm2 = zzJm();
        if (zzJm2 >= 0) {
            return b | (zzJm2 << 7);
        }
        byte b2 = b | ((zzJm2 & Byte.MAX_VALUE) << 7);
        byte zzJm3 = zzJm();
        if (zzJm3 >= 0) {
            return b2 | (zzJm3 << 14);
        }
        byte b3 = b2 | ((zzJm3 & Byte.MAX_VALUE) << 14);
        byte zzJm4 = zzJm();
        if (zzJm4 >= 0) {
            return b3 | (zzJm4 << 21);
        }
        byte b4 = b3 | ((zzJm4 & Byte.MAX_VALUE) << 21);
        byte zzJm5 = zzJm();
        byte b5 = b4 | (zzJm5 << 28);
        if (zzJm5 >= 0) {
            return b5;
        }
        for (int i = 0; i < 5; i++) {
            if (zzJm() >= 0) {
                return b5;
            }
        }
        throw zzst.m4103c();
    }

    public long zzJg() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzJm = zzJm();
            j |= ((long) (zzJm & Byte.MAX_VALUE)) << i;
            if ((zzJm & 128) == 0) {
                return j;
            }
        }
        throw zzst.m4103c();
    }

    public int zzJh() throws IOException {
        return (zzJm() & 255) | ((zzJm() & 255) << 8) | ((zzJm() & 255) << 16) | ((zzJm() & 255) << 24);
    }

    public long zzJi() throws IOException {
        byte zzJm = zzJm();
        byte zzJm2 = zzJm();
        return ((((long) zzJm2) & 255) << 8) | (((long) zzJm) & 255) | ((((long) zzJm()) & 255) << 16) | ((((long) zzJm()) & 255) << 24) | ((((long) zzJm()) & 255) << 32) | ((((long) zzJm()) & 255) << 40) | ((((long) zzJm()) & 255) << 48) | ((((long) zzJm()) & 255) << 56);
    }

    public int zzJk() {
        if (this.f3277g == Integer.MAX_VALUE) {
            return -1;
        }
        return this.f3277g - this.f3275e;
    }

    public boolean zzJl() {
        return this.f3275e == this.f3273c;
    }

    public byte zzJm() throws IOException {
        if (this.f3275e == this.f3273c) {
            throw zzst.m4101a();
        }
        byte[] bArr = this.f3271a;
        int i = this.f3275e;
        this.f3275e = i + 1;
        return bArr[i];
    }

    public void zza(zzsu zzsu) throws IOException {
        int zzJf = zzJf();
        if (this.f3278h >= this.f3279i) {
            throw zzst.m4107g();
        }
        int zzmq = zzmq(zzJf);
        this.f3278h++;
        zzsu.mergeFrom(this);
        zzmn(0);
        this.f3278h--;
        zzmr(zzmq);
    }

    public void zza(zzsu zzsu, int i) throws IOException {
        if (this.f3278h >= this.f3279i) {
            throw zzst.m4107g();
        }
        this.f3278h++;
        zzsu.mergeFrom(this);
        zzmn(zzsx.m4114a(i, 4));
        this.f3278h--;
    }

    public void zzmn(int i) throws zzst {
        if (this.f3276f != i) {
            throw zzst.m4105e();
        }
    }

    public boolean zzmo(int i) throws IOException {
        switch (zzsx.m4113a(i)) {
            case 0:
                zzJb();
                return true;
            case 1:
                zzJi();
                return true;
            case 2:
                zzmu(zzJf());
                return true;
            case 3:
                zzIY();
                zzmn(zzsx.m4114a(zzsx.zzmJ(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                zzJh();
                return true;
            default:
                throw zzst.m4106f();
        }
    }

    public int zzmq(int i) throws zzst {
        if (i < 0) {
            throw zzst.m4102b();
        }
        int i2 = this.f3275e + i;
        int i3 = this.f3277g;
        if (i2 > i3) {
            throw zzst.m4101a();
        }
        this.f3277g = i2;
        m4080a();
        return i3;
    }

    public void zzmr(int i) {
        this.f3277g = i;
        m4080a();
    }

    public void zzms(int i) {
        if (i > this.f3275e - this.f3272b) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.f3275e - this.f3272b));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.f3275e = this.f3272b + i;
        }
    }

    public byte[] zzmt(int i) throws IOException {
        if (i < 0) {
            throw zzst.m4102b();
        } else if (this.f3275e + i > this.f3277g) {
            zzmu(this.f3277g - this.f3275e);
            throw zzst.m4101a();
        } else if (i <= this.f3273c - this.f3275e) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.f3271a, this.f3275e, bArr, 0, i);
            this.f3275e += i;
            return bArr;
        } else {
            throw zzst.m4101a();
        }
    }

    public void zzmu(int i) throws IOException {
        if (i < 0) {
            throw zzst.m4102b();
        } else if (this.f3275e + i > this.f3277g) {
            zzmu(this.f3277g - this.f3275e);
            throw zzst.m4101a();
        } else if (i <= this.f3273c - this.f3275e) {
            this.f3275e += i;
        } else {
            throw zzst.m4101a();
        }
    }

    public byte[] zzz(int i, int i2) {
        if (i2 == 0) {
            return zzsx.zzbuD;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f3271a, this.f3272b + i, bArr, 0, i2);
        return bArr;
    }
}
