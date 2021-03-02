package com.google.android.gms.internal;

import android.support.p003v7.internal.widget.ActivityChooserView;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.pe */
public final class C1709pe {
    private int awo;
    private int awp;
    private int awq;
    private int awr;
    private int aws;
    private int awt = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int awu;
    private int awv = 64;
    private int aww = 67108864;
    private final byte[] buffer;

    private C1709pe(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.awo = i;
        this.awp = i + i2;
        this.awr = i;
    }

    /* renamed from: A */
    public static long m5963A(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    /* renamed from: a */
    public static C1709pe m5964a(byte[] bArr, int i, int i2) {
        return new C1709pe(bArr, i, i2);
    }

    /* renamed from: gn */
    public static int m5965gn(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    /* renamed from: p */
    public static C1709pe m5966p(byte[] bArr) {
        return m5964a(bArr, 0, bArr.length);
    }

    /* renamed from: qr */
    private void m5967qr() {
        this.awp += this.awq;
        int i = this.awp;
        if (i > this.awt) {
            this.awq = i - this.awt;
            this.awp -= this.awq;
            return;
        }
        this.awq = 0;
    }

    /* renamed from: a */
    public void mo10018a(C1718pm pmVar) throws IOException {
        int qn = mo10035qn();
        if (this.awu >= this.awv) {
            throw C1717pl.m6086qE();
        }
        int go = mo10023go(qn);
        this.awu++;
        pmVar.mo4923b(this);
        mo10021gl(0);
        this.awu--;
        mo10024gp(go);
    }

    /* renamed from: a */
    public void mo10019a(C1718pm pmVar, int i) throws IOException {
        if (this.awu >= this.awv) {
            throw C1717pl.m6086qE();
        }
        this.awu++;
        pmVar.mo4923b(this);
        mo10021gl(C1721pp.m6109x(i, 4));
        this.awu--;
    }

    public int getPosition() {
        return this.awr - this.awo;
    }

    /* renamed from: gl */
    public void mo10021gl(int i) throws C1717pl {
        if (this.aws != i) {
            throw C1717pl.m6084qC();
        }
    }

    /* renamed from: gm */
    public boolean mo10022gm(int i) throws IOException {
        switch (C1721pp.m6107gG(i)) {
            case 0:
                mo10031qj();
                return true;
            case 1:
                mo10038qq();
                return true;
            case 2:
                mo10027gs(mo10035qn());
                return true;
            case 3:
                mo10029qh();
                mo10021gl(C1721pp.m6109x(C1721pp.m6108gH(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                mo10037qp();
                return true;
            default:
                throw C1717pl.m6085qD();
        }
    }

    /* renamed from: go */
    public int mo10023go(int i) throws C1717pl {
        if (i < 0) {
            throw C1717pl.m6088qz();
        }
        int i2 = this.awr + i;
        int i3 = this.awt;
        if (i2 > i3) {
            throw C1717pl.m6087qy();
        }
        this.awt = i2;
        m5967qr();
        return i3;
    }

    /* renamed from: gp */
    public void mo10024gp(int i) {
        this.awt = i;
        m5967qr();
    }

    /* renamed from: gq */
    public void mo10025gq(int i) {
        if (i > this.awr - this.awo) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.awr - this.awo));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.awr = this.awo + i;
        }
    }

    /* renamed from: gr */
    public byte[] mo10026gr(int i) throws IOException {
        if (i < 0) {
            throw C1717pl.m6088qz();
        } else if (this.awr + i > this.awt) {
            mo10027gs(this.awt - this.awr);
            throw C1717pl.m6087qy();
        } else if (i <= this.awp - this.awr) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, this.awr, bArr, 0, i);
            this.awr += i;
            return bArr;
        } else {
            throw C1717pl.m6087qy();
        }
    }

    /* renamed from: gs */
    public void mo10027gs(int i) throws IOException {
        if (i < 0) {
            throw C1717pl.m6088qz();
        } else if (this.awr + i > this.awt) {
            mo10027gs(this.awt - this.awr);
            throw C1717pl.m6087qy();
        } else if (i <= this.awp - this.awr) {
            this.awr += i;
        } else {
            throw C1717pl.m6087qy();
        }
    }

    /* renamed from: qg */
    public int mo10028qg() throws IOException {
        if (mo10040qt()) {
            this.aws = 0;
            return 0;
        }
        this.aws = mo10035qn();
        if (this.aws != 0) {
            return this.aws;
        }
        throw C1717pl.m6083qB();
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* renamed from: qh */
    public void mo10029qh() throws java.io.IOException {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r1.mo10028qg()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.mo10022gm(r0)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1709pe.mo10029qh():void");
    }

    /* renamed from: qi */
    public long mo10030qi() throws IOException {
        return mo10036qo();
    }

    /* renamed from: qj */
    public int mo10031qj() throws IOException {
        return mo10035qn();
    }

    /* renamed from: qk */
    public boolean mo10032qk() throws IOException {
        return mo10035qn() != 0;
    }

    /* renamed from: ql */
    public int mo10033ql() throws IOException {
        return m5965gn(mo10035qn());
    }

    /* renamed from: qm */
    public long mo10034qm() throws IOException {
        return m5963A(mo10036qo());
    }

    /* renamed from: qn */
    public int mo10035qn() throws IOException {
        byte qu = mo10041qu();
        if (qu >= 0) {
            return qu;
        }
        byte b = qu & Byte.MAX_VALUE;
        byte qu2 = mo10041qu();
        if (qu2 >= 0) {
            return b | (qu2 << 7);
        }
        byte b2 = b | ((qu2 & Byte.MAX_VALUE) << 7);
        byte qu3 = mo10041qu();
        if (qu3 >= 0) {
            return b2 | (qu3 << 14);
        }
        byte b3 = b2 | ((qu3 & Byte.MAX_VALUE) << 14);
        byte qu4 = mo10041qu();
        if (qu4 >= 0) {
            return b3 | (qu4 << 21);
        }
        byte b4 = b3 | ((qu4 & Byte.MAX_VALUE) << 21);
        byte qu5 = mo10041qu();
        byte b5 = b4 | (qu5 << 28);
        if (qu5 >= 0) {
            return b5;
        }
        for (int i = 0; i < 5; i++) {
            if (mo10041qu() >= 0) {
                return b5;
            }
        }
        throw C1717pl.m6082qA();
    }

    /* renamed from: qo */
    public long mo10036qo() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte qu = mo10041qu();
            j |= ((long) (qu & Byte.MAX_VALUE)) << i;
            if ((qu & 128) == 0) {
                return j;
            }
        }
        throw C1717pl.m6082qA();
    }

    /* renamed from: qp */
    public int mo10037qp() throws IOException {
        return (mo10041qu() & 255) | ((mo10041qu() & 255) << 8) | ((mo10041qu() & 255) << 16) | ((mo10041qu() & 255) << 24);
    }

    /* renamed from: qq */
    public long mo10038qq() throws IOException {
        byte qu = mo10041qu();
        byte qu2 = mo10041qu();
        return ((((long) qu2) & 255) << 8) | (((long) qu) & 255) | ((((long) mo10041qu()) & 255) << 16) | ((((long) mo10041qu()) & 255) << 24) | ((((long) mo10041qu()) & 255) << 32) | ((((long) mo10041qu()) & 255) << 40) | ((((long) mo10041qu()) & 255) << 48) | ((((long) mo10041qu()) & 255) << 56);
    }

    /* renamed from: qs */
    public int mo10039qs() {
        if (this.awt == Integer.MAX_VALUE) {
            return -1;
        }
        return this.awt - this.awr;
    }

    /* renamed from: qt */
    public boolean mo10040qt() {
        return this.awr == this.awp;
    }

    /* renamed from: qu */
    public byte mo10041qu() throws IOException {
        if (this.awr == this.awp) {
            throw C1717pl.m6087qy();
        }
        byte[] bArr = this.buffer;
        int i = this.awr;
        this.awr = i + 1;
        return bArr[i];
    }

    /* renamed from: r */
    public byte[] mo10042r(int i, int i2) {
        if (i2 == 0) {
            return C1721pp.awS;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.awo + i, bArr, 0, i2);
        return bArr;
    }

    public byte[] readBytes() throws IOException {
        int qn = mo10035qn();
        if (qn > this.awp - this.awr || qn <= 0) {
            return mo10026gr(qn);
        }
        byte[] bArr = new byte[qn];
        System.arraycopy(this.buffer, this.awr, bArr, 0, qn);
        this.awr = qn + this.awr;
        return bArr;
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(mo10038qq());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(mo10037qp());
    }

    public String readString() throws IOException {
        int qn = mo10035qn();
        if (qn > this.awp - this.awr || qn <= 0) {
            return new String(mo10026gr(qn), "UTF-8");
        }
        String str = new String(this.buffer, this.awr, qn, "UTF-8");
        this.awr = qn + this.awr;
        return str;
    }
}
