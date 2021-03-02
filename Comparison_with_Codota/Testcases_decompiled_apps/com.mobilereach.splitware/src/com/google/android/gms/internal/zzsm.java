package com.google.android.gms.internal;

import java.io.IOException;

public final class zzsm {
    private final byte[] buffer;
    private int zzbtZ;
    private int zzbua;
    private int zzbub;
    private int zzbuc;
    private int zzbud;
    private int zzbue = Integer.MAX_VALUE;
    private int zzbuf;
    private int zzbug = 64;
    private int zzbuh = 67108864;

    private zzsm(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzbtZ = i;
        this.zzbua = i + i2;
        this.zzbuc = i;
    }

    public static zzsm zzD(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    private void zzJj() {
        this.zzbua += this.zzbub;
        int i = this.zzbua;
        if (i > this.zzbue) {
            this.zzbub = i - this.zzbue;
            this.zzbua -= this.zzbub;
            return;
        }
        this.zzbub = 0;
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
        return this.zzbuc - this.zzbtZ;
    }

    public byte[] readBytes() throws IOException {
        int zzJf = zzJf();
        if (zzJf > this.zzbua - this.zzbuc || zzJf <= 0) {
            return zzJf == 0 ? zzsx.zzbuD : zzmt(zzJf);
        }
        byte[] bArr = new byte[zzJf];
        System.arraycopy(this.buffer, this.zzbuc, bArr, 0, zzJf);
        this.zzbuc = zzJf + this.zzbuc;
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
        if (zzJf > this.zzbua - this.zzbuc || zzJf <= 0) {
            return new String(zzmt(zzJf), "UTF-8");
        }
        String str = new String(this.buffer, this.zzbuc, zzJf, "UTF-8");
        this.zzbuc = zzJf + this.zzbuc;
        return str;
    }

    public int zzIX() throws IOException {
        if (zzJl()) {
            this.zzbud = 0;
            return 0;
        }
        this.zzbud = zzJf();
        if (this.zzbud != 0) {
            return this.zzbud;
        }
        throw zzst.zzJv();
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
        throw zzst.zzJu();
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
        throw zzst.zzJu();
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
        if (this.zzbue == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzbue - this.zzbuc;
    }

    public boolean zzJl() {
        return this.zzbuc == this.zzbua;
    }

    public byte zzJm() throws IOException {
        if (this.zzbuc == this.zzbua) {
            throw zzst.zzJs();
        }
        byte[] bArr = this.buffer;
        int i = this.zzbuc;
        this.zzbuc = i + 1;
        return bArr[i];
    }

    public void zza(zzsu zzsu) throws IOException {
        int zzJf = zzJf();
        if (this.zzbuf >= this.zzbug) {
            throw zzst.zzJy();
        }
        int zzmq = zzmq(zzJf);
        this.zzbuf++;
        zzsu.mergeFrom(this);
        zzmn(0);
        this.zzbuf--;
        zzmr(zzmq);
    }

    public void zza(zzsu zzsu, int i) throws IOException {
        if (this.zzbuf >= this.zzbug) {
            throw zzst.zzJy();
        }
        this.zzbuf++;
        zzsu.mergeFrom(this);
        zzmn(zzsx.zzF(i, 4));
        this.zzbuf--;
    }

    public void zzmn(int i) throws zzst {
        if (this.zzbud != i) {
            throw zzst.zzJw();
        }
    }

    public boolean zzmo(int i) throws IOException {
        switch (zzsx.zzmI(i)) {
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
                zzmn(zzsx.zzF(zzsx.zzmJ(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                zzJh();
                return true;
            default:
                throw zzst.zzJx();
        }
    }

    public int zzmq(int i) throws zzst {
        if (i < 0) {
            throw zzst.zzJt();
        }
        int i2 = this.zzbuc + i;
        int i3 = this.zzbue;
        if (i2 > i3) {
            throw zzst.zzJs();
        }
        this.zzbue = i2;
        zzJj();
        return i3;
    }

    public void zzmr(int i) {
        this.zzbue = i;
        zzJj();
    }

    public void zzms(int i) {
        if (i > this.zzbuc - this.zzbtZ) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.zzbuc - this.zzbtZ));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.zzbuc = this.zzbtZ + i;
        }
    }

    public byte[] zzmt(int i) throws IOException {
        if (i < 0) {
            throw zzst.zzJt();
        } else if (this.zzbuc + i > this.zzbue) {
            zzmu(this.zzbue - this.zzbuc);
            throw zzst.zzJs();
        } else if (i <= this.zzbua - this.zzbuc) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, this.zzbuc, bArr, 0, i);
            this.zzbuc += i;
            return bArr;
        } else {
            throw zzst.zzJs();
        }
    }

    public void zzmu(int i) throws IOException {
        if (i < 0) {
            throw zzst.zzJt();
        } else if (this.zzbuc + i > this.zzbue) {
            zzmu(this.zzbue - this.zzbuc);
            throw zzst.zzJs();
        } else if (i <= this.zzbua - this.zzbuc) {
            this.zzbuc += i;
        } else {
            throw zzst.zzJs();
        }
    }

    public byte[] zzz(int i, int i2) {
        if (i2 == 0) {
            return zzsx.zzbuD;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzbtZ + i, bArr, 0, i2);
        return bArr;
    }
}
