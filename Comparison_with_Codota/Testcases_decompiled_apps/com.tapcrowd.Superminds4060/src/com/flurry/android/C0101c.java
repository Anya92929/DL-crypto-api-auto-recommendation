package com.flurry.android;

import java.io.DataInput;
import java.io.DataOutput;

/* renamed from: com.flurry.android.c */
final class C0101c extends C0097ak {

    /* renamed from: A */
    private int f129A;

    /* renamed from: B */
    private int f130B;

    /* renamed from: C */
    private int f131C;

    /* renamed from: D */
    private int f132D;

    /* renamed from: E */
    private int f133E;

    /* renamed from: F */
    private int f134F;

    /* renamed from: G */
    private int f135G;

    /* renamed from: H */
    private int f136H;

    /* renamed from: I */
    private int f137I;

    /* renamed from: J */
    private int f138J;

    /* renamed from: K */
    private int f139K;

    /* renamed from: L */
    private int f140L;

    /* renamed from: M */
    private int f141M;

    /* renamed from: N */
    private int f142N;

    /* renamed from: O */
    private int f143O;

    /* renamed from: P */
    private int f144P;

    /* renamed from: Q */
    private int f145Q;

    /* renamed from: R */
    private int f146R;

    /* renamed from: S */
    private int f147S;

    /* renamed from: T */
    private int f148T;

    /* renamed from: U */
    private int f149U;

    /* renamed from: V */
    private int f150V;

    /* renamed from: W */
    private int f151W;

    /* renamed from: X */
    private int f152X;

    /* renamed from: Y */
    private int f153Y;

    /* renamed from: Z */
    private int f154Z;

    /* renamed from: a */
    byte f155a;

    /* renamed from: aa */
    private int f156aa;

    /* renamed from: ab */
    private int f157ab;

    /* renamed from: ac */
    private int f158ac;

    /* renamed from: ad */
    private int f159ad;

    /* renamed from: ae */
    private int f160ae;

    /* renamed from: af */
    private int f161af;

    /* renamed from: ag */
    private boolean f162ag;

    /* renamed from: b */
    String f163b;

    /* renamed from: c */
    long f164c;

    /* renamed from: d */
    String f165d;

    /* renamed from: e */
    int f166e;

    /* renamed from: f */
    int f167f;

    /* renamed from: g */
    String f168g;

    /* renamed from: h */
    int f169h;

    /* renamed from: i */
    int f170i;

    /* renamed from: j */
    String f171j;

    /* renamed from: k */
    int f172k;

    /* renamed from: l */
    int f173l;

    /* renamed from: m */
    int f174m;

    /* renamed from: n */
    int f175n;

    /* renamed from: o */
    int f176o;

    /* renamed from: p */
    int f177p;

    /* renamed from: q */
    int f178q;

    /* renamed from: r */
    private long f179r;

    /* renamed from: s */
    private String f180s;

    /* renamed from: t */
    private int f181t;

    /* renamed from: u */
    private int f182u;

    /* renamed from: v */
    private String f183v;

    /* renamed from: w */
    private int f184w;

    /* renamed from: x */
    private int f185x;

    /* renamed from: y */
    private String f186y;

    /* renamed from: z */
    private int f187z;

    C0101c() {
    }

    C0101c(DataInput dataInput) {
        m108c(dataInput);
    }

    /* renamed from: c */
    private void m108c(DataInput dataInput) {
        this.f155a = dataInput.readByte();
        this.f163b = dataInput.readUTF();
        this.f164c = dataInput.readLong();
        this.f179r = dataInput.readLong();
        this.f165d = dataInput.readUTF();
        this.f166e = dataInput.readUnsignedShort();
        this.f167f = dataInput.readInt();
        this.f168g = dataInput.readUTF();
        this.f169h = dataInput.readUnsignedShort();
        this.f170i = dataInput.readInt();
        this.f171j = dataInput.readUTF();
        this.f172k = dataInput.readUnsignedShort();
        this.f173l = dataInput.readInt();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3306a(DataInput dataInput) {
        this.f180s = dataInput.readUTF();
        this.f181t = dataInput.readUnsignedShort();
        this.f182u = dataInput.readInt();
        this.f183v = dataInput.readUTF();
        this.f184w = dataInput.readUnsignedShort();
        this.f185x = dataInput.readInt();
        this.f186y = dataInput.readUTF();
        this.f187z = dataInput.readUnsignedShort();
        this.f129A = dataInput.readInt();
        this.f130B = dataInput.readInt();
        this.f131C = dataInput.readInt();
        this.f174m = dataInput.readInt();
        this.f175n = dataInput.readInt();
        this.f176o = dataInput.readInt();
        this.f177p = dataInput.readInt();
        this.f132D = dataInput.readInt();
        this.f133E = dataInput.readInt();
        this.f134F = dataInput.readInt();
        this.f135G = dataInput.readInt();
        this.f136H = dataInput.readInt();
        this.f137I = dataInput.readInt();
        this.f138J = dataInput.readInt();
        this.f139K = dataInput.readInt();
        this.f178q = dataInput.readInt();
        this.f140L = dataInput.readInt();
        this.f141M = dataInput.readInt();
        this.f142N = dataInput.readInt();
        this.f143O = dataInput.readInt();
        this.f144P = dataInput.readInt();
        this.f145Q = dataInput.readInt();
        this.f146R = dataInput.readInt();
        this.f147S = dataInput.readInt();
        this.f148T = dataInput.readInt();
        this.f149U = dataInput.readInt();
        this.f150V = dataInput.readInt();
        this.f151W = dataInput.readInt();
        this.f152X = dataInput.readInt();
        this.f153Y = dataInput.readInt();
        this.f154Z = dataInput.readInt();
        this.f156aa = dataInput.readInt();
        this.f157ab = dataInput.readInt();
        this.f158ac = dataInput.readInt();
        this.f159ad = dataInput.readInt();
        this.f160ae = dataInput.readInt();
        this.f161af = dataInput.readInt();
        this.f162ag = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo3308b(DataInput dataInput) {
        m108c(dataInput);
        this.f162ag = dataInput.readBoolean();
        if (this.f162ag) {
            mo3306a(dataInput);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3307a(DataOutput dataOutput) {
        dataOutput.writeByte(this.f155a);
        dataOutput.writeUTF(this.f163b);
        dataOutput.writeLong(this.f164c);
        dataOutput.writeLong(this.f179r);
        dataOutput.writeUTF(this.f165d);
        dataOutput.writeShort(this.f166e);
        dataOutput.writeInt(this.f167f);
        dataOutput.writeUTF(this.f168g);
        dataOutput.writeShort(this.f169h);
        dataOutput.writeInt(this.f170i);
        dataOutput.writeUTF(this.f171j);
        dataOutput.writeShort(this.f172k);
        dataOutput.writeInt(this.f173l);
        dataOutput.writeBoolean(this.f162ag);
        if (this.f162ag) {
            dataOutput.writeUTF(this.f180s);
            dataOutput.writeShort(this.f181t);
            dataOutput.writeInt(this.f182u);
            dataOutput.writeUTF(this.f183v);
            dataOutput.writeShort(this.f184w);
            dataOutput.writeInt(this.f185x);
            dataOutput.writeUTF(this.f186y);
            dataOutput.writeShort(this.f187z);
            dataOutput.writeInt(this.f129A);
            dataOutput.writeInt(this.f130B);
            dataOutput.writeInt(this.f131C);
            dataOutput.writeInt(this.f174m);
            dataOutput.writeInt(this.f175n);
            dataOutput.writeInt(this.f176o);
            dataOutput.writeInt(this.f177p);
            dataOutput.writeInt(this.f132D);
            dataOutput.writeInt(this.f133E);
            dataOutput.writeInt(this.f134F);
            dataOutput.writeInt(this.f135G);
            dataOutput.writeInt(this.f136H);
            dataOutput.writeInt(this.f137I);
            dataOutput.writeInt(this.f138J);
            dataOutput.writeInt(this.f139K);
            dataOutput.writeInt(this.f178q);
            dataOutput.writeInt(this.f140L);
            dataOutput.writeInt(this.f141M);
            dataOutput.writeInt(this.f142N);
            dataOutput.writeInt(this.f143O);
            dataOutput.writeInt(this.f144P);
            dataOutput.writeInt(this.f145Q);
            dataOutput.writeInt(this.f146R);
            dataOutput.writeInt(this.f147S);
            dataOutput.writeInt(this.f148T);
            dataOutput.writeInt(this.f149U);
            dataOutput.writeInt(this.f150V);
            dataOutput.writeInt(this.f151W);
            dataOutput.writeInt(this.f152X);
            dataOutput.writeInt(this.f153Y);
            dataOutput.writeInt(this.f154Z);
            dataOutput.writeInt(this.f156aa);
            dataOutput.writeInt(this.f157ab);
            dataOutput.writeInt(this.f158ac);
            dataOutput.writeInt(this.f159ad);
            dataOutput.writeInt(this.f160ae);
            dataOutput.writeInt(this.f161af);
        }
    }
}
