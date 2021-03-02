package com.google.android.gms.internal;

public final class zzapn {

    /* renamed from: a */
    private final byte[] f5884a;

    /* renamed from: b */
    private int f5885b;

    /* renamed from: c */
    private int f5886c;

    /* renamed from: d */
    private int f5887d;

    /* renamed from: e */
    private int f5888e;

    /* renamed from: f */
    private int f5889f;

    /* renamed from: g */
    private int f5890g = Integer.MAX_VALUE;

    /* renamed from: h */
    private int f5891h;

    /* renamed from: i */
    private int f5892i = 64;

    /* renamed from: j */
    private int f5893j = 67108864;

    private zzapn(byte[] bArr, int i, int i2) {
        this.f5884a = bArr;
        this.f5885b = i;
        this.f5886c = i + i2;
        this.f5888e = i;
    }

    /* renamed from: a */
    private void m6769a() {
        this.f5886c += this.f5887d;
        int i = this.f5886c;
        if (i > this.f5890g) {
            this.f5887d = i - this.f5890g;
            this.f5886c -= this.f5887d;
            return;
        }
        this.f5887d = 0;
    }

    public static int zzafq(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static zzapn zzb(byte[] bArr, int i, int i2) {
        return new zzapn(bArr, i, i2);
    }

    public static zzapn zzbd(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public static long zzcs(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    /* renamed from: ah */
    public int mo7957ah() {
        if (mo7971aw()) {
            this.f5889f = 0;
            return 0;
        }
        this.f5889f = mo7966aq();
        if (this.f5889f != 0) {
            return this.f5889f;
        }
        throw zzapu.m6821d();
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* renamed from: ai */
    public void mo7958ai() {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r1.mo7957ah()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.zzafp(r0)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzapn.mo7958ai():void");
    }

    /* renamed from: aj */
    public long mo7959aj() {
        return mo7967ar();
    }

    /* renamed from: ak */
    public long mo7960ak() {
        return mo7967ar();
    }

    /* renamed from: al */
    public int mo7961al() {
        return mo7966aq();
    }

    /* renamed from: am */
    public long mo7962am() {
        return mo7969at();
    }

    /* renamed from: an */
    public boolean mo7963an() {
        return mo7966aq() != 0;
    }

    /* renamed from: ao */
    public int mo7964ao() {
        return zzafq(mo7966aq());
    }

    /* renamed from: ap */
    public long mo7965ap() {
        return zzcs(mo7967ar());
    }

    /* renamed from: aq */
    public int mo7966aq() {
        byte ax = mo7972ax();
        if (ax >= 0) {
            return ax;
        }
        byte b = ax & Byte.MAX_VALUE;
        byte ax2 = mo7972ax();
        if (ax2 >= 0) {
            return b | (ax2 << 7);
        }
        byte b2 = b | ((ax2 & Byte.MAX_VALUE) << 7);
        byte ax3 = mo7972ax();
        if (ax3 >= 0) {
            return b2 | (ax3 << 14);
        }
        byte b3 = b2 | ((ax3 & Byte.MAX_VALUE) << 14);
        byte ax4 = mo7972ax();
        if (ax4 >= 0) {
            return b3 | (ax4 << 21);
        }
        byte b4 = b3 | ((ax4 & Byte.MAX_VALUE) << 21);
        byte ax5 = mo7972ax();
        byte b5 = b4 | (ax5 << 28);
        if (ax5 >= 0) {
            return b5;
        }
        for (int i = 0; i < 5; i++) {
            if (mo7972ax() >= 0) {
                return b5;
            }
        }
        throw zzapu.m6820c();
    }

    /* renamed from: ar */
    public long mo7967ar() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte ax = mo7972ax();
            j |= ((long) (ax & Byte.MAX_VALUE)) << i;
            if ((ax & 128) == 0) {
                return j;
            }
        }
        throw zzapu.m6820c();
    }

    /* renamed from: as */
    public int mo7968as() {
        return (mo7972ax() & 255) | ((mo7972ax() & 255) << 8) | ((mo7972ax() & 255) << 16) | ((mo7972ax() & 255) << 24);
    }

    /* renamed from: at */
    public long mo7969at() {
        byte ax = mo7972ax();
        byte ax2 = mo7972ax();
        return ((((long) ax2) & 255) << 8) | (((long) ax) & 255) | ((((long) mo7972ax()) & 255) << 16) | ((((long) mo7972ax()) & 255) << 24) | ((((long) mo7972ax()) & 255) << 32) | ((((long) mo7972ax()) & 255) << 40) | ((((long) mo7972ax()) & 255) << 48) | ((((long) mo7972ax()) & 255) << 56);
    }

    /* renamed from: av */
    public int mo7970av() {
        if (this.f5890g == Integer.MAX_VALUE) {
            return -1;
        }
        return this.f5890g - this.f5888e;
    }

    /* renamed from: aw */
    public boolean mo7971aw() {
        return this.f5888e == this.f5886c;
    }

    /* renamed from: ax */
    public byte mo7972ax() {
        if (this.f5888e == this.f5886c) {
            throw zzapu.m6818a();
        }
        byte[] bArr = this.f5884a;
        int i = this.f5888e;
        this.f5888e = i + 1;
        return bArr[i];
    }

    public int getPosition() {
        return this.f5888e - this.f5885b;
    }

    public byte[] readBytes() {
        int aq = mo7966aq();
        if (aq < 0) {
            throw zzapu.m6819b();
        } else if (aq == 0) {
            return zzapy.bjO;
        } else {
            if (aq > this.f5886c - this.f5888e) {
                throw zzapu.m6818a();
            }
            byte[] bArr = new byte[aq];
            System.arraycopy(this.f5884a, this.f5888e, bArr, 0, aq);
            this.f5888e = aq + this.f5888e;
            return bArr;
        }
    }

    public double readDouble() {
        return Double.longBitsToDouble(mo7969at());
    }

    public float readFloat() {
        return Float.intBitsToFloat(mo7968as());
    }

    public String readString() {
        int aq = mo7966aq();
        if (aq < 0) {
            throw zzapu.m6819b();
        } else if (aq > this.f5886c - this.f5888e) {
            throw zzapu.m6818a();
        } else {
            String str = new String(this.f5884a, this.f5888e, aq, zzapt.f5904a);
            this.f5888e = aq + this.f5888e;
            return str;
        }
    }

    public void zza(zzapv zzapv) {
        int aq = mo7966aq();
        if (this.f5891h >= this.f5892i) {
            throw zzapu.m6824g();
        }
        int zzafr = zzafr(aq);
        this.f5891h++;
        zzapv.zzb(this);
        zzafo(0);
        this.f5891h--;
        zzafs(zzafr);
    }

    public void zza(zzapv zzapv, int i) {
        if (this.f5891h >= this.f5892i) {
            throw zzapu.m6824g();
        }
        this.f5891h++;
        zzapv.zzb(this);
        zzafo(zzapy.zzaj(i, 4));
        this.f5891h--;
    }

    public byte[] zzad(int i, int i2) {
        if (i2 == 0) {
            return zzapy.bjO;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f5884a, this.f5885b + i, bArr, 0, i2);
        return bArr;
    }

    public void zzafo(int i) {
        if (this.f5889f != i) {
            throw zzapu.m6822e();
        }
    }

    public boolean zzafp(int i) {
        switch (zzapy.m6834a(i)) {
            case 0:
                mo7961al();
                return true;
            case 1:
                mo7969at();
                return true;
            case 2:
                zzafu(mo7966aq());
                return true;
            case 3:
                mo7958ai();
                zzafo(zzapy.zzaj(zzapy.zzagj(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                mo7968as();
                return true;
            default:
                throw zzapu.m6823f();
        }
    }

    public int zzafr(int i) {
        if (i < 0) {
            throw zzapu.m6819b();
        }
        int i2 = this.f5888e + i;
        int i3 = this.f5890g;
        if (i2 > i3) {
            throw zzapu.m6818a();
        }
        this.f5890g = i2;
        m6769a();
        return i3;
    }

    public void zzafs(int i) {
        this.f5890g = i;
        m6769a();
    }

    public void zzaft(int i) {
        if (i > this.f5888e - this.f5885b) {
            throw new IllegalArgumentException(new StringBuilder(50).append("Position ").append(i).append(" is beyond current ").append(this.f5888e - this.f5885b).toString());
        } else if (i < 0) {
            throw new IllegalArgumentException(new StringBuilder(24).append("Bad position ").append(i).toString());
        } else {
            this.f5888e = this.f5885b + i;
        }
    }

    public void zzafu(int i) {
        if (i < 0) {
            throw zzapu.m6819b();
        } else if (this.f5888e + i > this.f5890g) {
            zzafu(this.f5890g - this.f5888e);
            throw zzapu.m6818a();
        } else if (i <= this.f5886c - this.f5888e) {
            this.f5888e += i;
        } else {
            throw zzapu.m6818a();
        }
    }
}
