package com.appbrain.p037f;

import com.appbrain.p033b.C0986aa;
import com.appbrain.p033b.C1002f;
import com.appbrain.p033b.C1006j;
import com.appbrain.p033b.C1008l;
import com.appbrain.p033b.C1010n;
import com.appbrain.p033b.C1011o;
import com.appbrain.p033b.C1012p;
import com.appbrain.p033b.C1016t;
import com.appbrain.p033b.C1017u;
import com.appbrain.p033b.C1020x;
import com.appbrain.p033b.C1021y;
import java.util.Collections;
import java.util.List;

/* renamed from: com.appbrain.f.ah */
public final class C1042ah extends C1011o implements C1045ak {

    /* renamed from: b */
    public static C0986aa f2810b = new C1043ai();

    /* renamed from: c */
    private static final C1042ah f2811c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1002f f2812d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f2813e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1017u f2814f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C1017u f2815g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C1017u f2816h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C1017u f2817i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C1017u f2818j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C1017u f2819k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public List f2820l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Object f2821m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f2822n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C1017u f2823o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public List f2824p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Object f2825q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public List f2826r;

    /* renamed from: s */
    private byte f2827s;

    /* renamed from: t */
    private int f2828t;

    static {
        C1042ah ahVar = new C1042ah();
        f2811c = ahVar;
        ahVar.m4573s();
    }

    private C1042ah() {
        this.f2827s = -1;
        this.f2828t = -1;
        this.f2812d = C1002f.f2629a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0163  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:124:0x01d5=Splitter:B:124:0x01d5, B:76:0x0117=Splitter:B:76:0x0117} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C1042ah(com.appbrain.p033b.C1006j r14, com.appbrain.p033b.C1010n r15) {
        /*
            r13 = this;
            r11 = 4
            r10 = 2
            r9 = 4096(0x1000, float:5.74E-42)
            r8 = 64
            r3 = 1
            r13.<init>()
            r0 = -1
            r13.f2827s = r0
            r0 = -1
            r13.f2828t = r0
            r13.m4573s()
            r1 = 0
            com.appbrain.b.i r4 = com.appbrain.p033b.C1002f.m4164g()
            com.appbrain.b.l r5 = com.appbrain.p033b.C1008l.m4211a((java.io.OutputStream) r4)
            r0 = 0
            r2 = r0
            r0 = r1
        L_0x001f:
            if (r2 != 0) goto L_0x0280
            int r1 = r14.mo3978a()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            switch(r1) {
                case 0: goto L_0x0030;
                case 10: goto L_0x0032;
                case 18: goto L_0x004a;
                case 26: goto L_0x0062;
                case 34: goto L_0x007a;
                case 42: goto L_0x0094;
                case 50: goto L_0x00af;
                case 56: goto L_0x00ca;
                case 58: goto L_0x00e7;
                case 66: goto L_0x01af;
                case 72: goto L_0x01c3;
                case 82: goto L_0x01e3;
                case 90: goto L_0x01fe;
                case 98: goto L_0x021b;
                case 104: goto L_0x022f;
                case 106: goto L_0x024c;
                default: goto L_0x0028;
            }     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
        L_0x0028:
            boolean r1 = r14.mo3981a((int) r1, (com.appbrain.p033b.C1008l) r5)     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            if (r1 != 0) goto L_0x001f
            r2 = r3
            goto L_0x001f
        L_0x0030:
            r2 = r3
            goto L_0x001f
        L_0x0032:
            com.appbrain.b.f r6 = r14.mo3988f()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r0 & 1
            if (r1 == r3) goto L_0x034e
            com.appbrain.b.t r1 = new com.appbrain.b.t     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1.<init>()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r13.f2814f = r1     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r0 | 1
        L_0x0043:
            com.appbrain.b.u r0 = r13.f2814f     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0.mo3943a((com.appbrain.p033b.C1002f) r6)     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0 = r1
            goto L_0x001f
        L_0x004a:
            com.appbrain.b.f r6 = r14.mo3988f()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r0 & 2
            if (r1 == r10) goto L_0x034b
            com.appbrain.b.t r1 = new com.appbrain.b.t     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1.<init>()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r13.f2815g = r1     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r0 | 2
        L_0x005b:
            com.appbrain.b.u r0 = r13.f2815g     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0.mo3943a((com.appbrain.p033b.C1002f) r6)     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0 = r1
            goto L_0x001f
        L_0x0062:
            com.appbrain.b.f r6 = r14.mo3988f()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r0 & 4
            if (r1 == r11) goto L_0x0348
            com.appbrain.b.t r1 = new com.appbrain.b.t     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1.<init>()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r13.f2816h = r1     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r0 | 4
        L_0x0073:
            com.appbrain.b.u r0 = r13.f2816h     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0.mo3943a((com.appbrain.p033b.C1002f) r6)     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0 = r1
            goto L_0x001f
        L_0x007a:
            com.appbrain.b.f r6 = r14.mo3988f()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r0 & 8
            r7 = 8
            if (r1 == r7) goto L_0x0345
            com.appbrain.b.t r1 = new com.appbrain.b.t     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1.<init>()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r13.f2817i = r1     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r0 | 8
        L_0x008d:
            com.appbrain.b.u r0 = r13.f2817i     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0.mo3943a((com.appbrain.p033b.C1002f) r6)     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0 = r1
            goto L_0x001f
        L_0x0094:
            com.appbrain.b.f r6 = r14.mo3988f()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r0 & 16
            r7 = 16
            if (r1 == r7) goto L_0x0342
            com.appbrain.b.t r1 = new com.appbrain.b.t     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1.<init>()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r13.f2818j = r1     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r0 | 16
        L_0x00a7:
            com.appbrain.b.u r0 = r13.f2818j     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0.mo3943a((com.appbrain.p033b.C1002f) r6)     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0 = r1
            goto L_0x001f
        L_0x00af:
            com.appbrain.b.f r6 = r14.mo3988f()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r0 & 32
            r7 = 32
            if (r1 == r7) goto L_0x033f
            com.appbrain.b.t r1 = new com.appbrain.b.t     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1.<init>()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r13.f2819k = r1     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r0 | 32
        L_0x00c2:
            com.appbrain.b.u r0 = r13.f2819k     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0.mo3943a((com.appbrain.p033b.C1002f) r6)     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0 = r1
            goto L_0x001f
        L_0x00ca:
            r1 = r0 & 64
            if (r1 == r8) goto L_0x033c
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1.<init>()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r13.f2820l = r1     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r0 | 64
        L_0x00d7:
            java.util.List r0 = r13.f2820l     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            int r6 = r14.mo3986d()     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0.add(r6)     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0 = r1
            goto L_0x001f
        L_0x00e7:
            int r1 = r14.mo3990h()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            int r6 = r14.mo3983b(r1)     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r0 & 64
            if (r1 == r8) goto L_0x0339
            int r1 = r14.mo3991i()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            if (r1 <= 0) goto L_0x0339
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1.<init>()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r13.f2820l = r1     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r0 | 64
        L_0x0102:
            int r0 = r14.mo3991i()     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            if (r0 <= 0) goto L_0x01a9
            java.util.List r0 = r13.f2820l     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            int r7 = r14.mo3986d()     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0.add(r7)     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            goto L_0x0102
        L_0x0116:
            r0 = move-exception
        L_0x0117:
            com.appbrain.b.s r0 = r0.mo4010a(r13)     // Catch:{ all -> 0x011c }
            throw r0     // Catch:{ all -> 0x011c }
        L_0x011c:
            r0 = move-exception
        L_0x011d:
            r2 = r1 & 1
            if (r2 != r3) goto L_0x0129
            com.appbrain.b.u r2 = r13.f2814f
            com.appbrain.b.u r2 = r2.mo3944b()
            r13.f2814f = r2
        L_0x0129:
            r2 = r1 & 2
            if (r2 != r10) goto L_0x0135
            com.appbrain.b.u r2 = r13.f2815g
            com.appbrain.b.u r2 = r2.mo3944b()
            r13.f2815g = r2
        L_0x0135:
            r2 = r1 & 4
            if (r2 != r11) goto L_0x0141
            com.appbrain.b.u r2 = r13.f2816h
            com.appbrain.b.u r2 = r2.mo3944b()
            r13.f2816h = r2
        L_0x0141:
            r2 = r1 & 8
            r3 = 8
            if (r2 != r3) goto L_0x014f
            com.appbrain.b.u r2 = r13.f2817i
            com.appbrain.b.u r2 = r2.mo3944b()
            r13.f2817i = r2
        L_0x014f:
            r2 = r1 & 16
            r3 = 16
            if (r2 != r3) goto L_0x015d
            com.appbrain.b.u r2 = r13.f2818j
            com.appbrain.b.u r2 = r2.mo3944b()
            r13.f2818j = r2
        L_0x015d:
            r2 = r1 & 32
            r3 = 32
            if (r2 != r3) goto L_0x016b
            com.appbrain.b.u r2 = r13.f2819k
            com.appbrain.b.u r2 = r2.mo3944b()
            r13.f2819k = r2
        L_0x016b:
            r2 = r1 & 64
            if (r2 != r8) goto L_0x0177
            java.util.List r2 = r13.f2820l
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)
            r13.f2820l = r2
        L_0x0177:
            r2 = r1 & 512(0x200, float:7.175E-43)
            r3 = 512(0x200, float:7.175E-43)
            if (r2 != r3) goto L_0x0185
            com.appbrain.b.u r2 = r13.f2823o
            com.appbrain.b.u r2 = r2.mo3944b()
            r13.f2823o = r2
        L_0x0185:
            r2 = r1 & 1024(0x400, float:1.435E-42)
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 != r3) goto L_0x0193
            java.util.List r2 = r13.f2824p
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)
            r13.f2824p = r2
        L_0x0193:
            r1 = r1 & 4096(0x1000, float:5.74E-42)
            if (r1 != r9) goto L_0x019f
            java.util.List r1 = r13.f2826r
            java.util.List r1 = java.util.Collections.unmodifiableList(r1)
            r13.f2826r = r1
        L_0x019f:
            r5.mo3992a()     // Catch:{ IOException -> 0x031c, all -> 0x0325 }
            com.appbrain.b.f r1 = r4.mo3974a()
            r13.f2812d = r1
        L_0x01a8:
            throw r0
        L_0x01a9:
            r14.mo3985c(r6)     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0 = r1
            goto L_0x001f
        L_0x01af:
            com.appbrain.b.f r1 = r14.mo3988f()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            int r6 = r13.f2813e     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r6 = r6 | 1
            r13.f2813e = r6     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r13.f2821m = r1     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            goto L_0x001f
        L_0x01bd:
            r1 = move-exception
            r12 = r1
            r1 = r0
            r0 = r12
            goto L_0x0117
        L_0x01c3:
            int r1 = r13.f2813e     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r1 | 2
            r13.f2813e = r1     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            boolean r1 = r14.mo3987e()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r13.f2822n = r1     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            goto L_0x001f
        L_0x01d1:
            r1 = move-exception
            r12 = r1
            r1 = r0
            r0 = r12
        L_0x01d5:
            com.appbrain.b.s r2 = new com.appbrain.b.s     // Catch:{ all -> 0x011c }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x011c }
            r2.<init>(r0)     // Catch:{ all -> 0x011c }
            com.appbrain.b.s r0 = r2.mo4010a(r13)     // Catch:{ all -> 0x011c }
            throw r0     // Catch:{ all -> 0x011c }
        L_0x01e3:
            com.appbrain.b.f r6 = r14.mo3988f()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r0 & 512(0x200, float:7.175E-43)
            r7 = 512(0x200, float:7.175E-43)
            if (r1 == r7) goto L_0x0336
            com.appbrain.b.t r1 = new com.appbrain.b.t     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1.<init>()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r13.f2823o = r1     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r0 | 512(0x200, float:7.175E-43)
        L_0x01f6:
            com.appbrain.b.u r0 = r13.f2823o     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0.mo3943a((com.appbrain.p033b.C1002f) r6)     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0 = r1
            goto L_0x001f
        L_0x01fe:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            r6 = 1024(0x400, float:1.435E-42)
            if (r1 == r6) goto L_0x0333
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1.<init>()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r13.f2824p = r1     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r0 | 1024(0x400, float:1.435E-42)
        L_0x020d:
            java.util.List r0 = r13.f2824p     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            com.appbrain.b.aa r6 = com.appbrain.p037f.C1046al.f2843b     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            com.appbrain.b.x r6 = r14.mo3979a((com.appbrain.p033b.C0986aa) r6, (com.appbrain.p033b.C1010n) r15)     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0.add(r6)     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0 = r1
            goto L_0x001f
        L_0x021b:
            com.appbrain.b.f r1 = r14.mo3988f()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            int r6 = r13.f2813e     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r6 = r6 | 4
            r13.f2813e = r6     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r13.f2825q = r1     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            goto L_0x001f
        L_0x0229:
            r1 = move-exception
            r12 = r1
            r1 = r0
            r0 = r12
            goto L_0x011d
        L_0x022f:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == r9) goto L_0x0330
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1.<init>()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r13.f2826r = r1     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r1 = r0 | 4096(0x1000, float:5.74E-42)
        L_0x023c:
            java.util.List r0 = r13.f2826r     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            int r6 = r14.mo3986d()     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0.add(r6)     // Catch:{ s -> 0x0116, IOException -> 0x032d }
            r0 = r1
            goto L_0x001f
        L_0x024c:
            int r1 = r14.mo3990h()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            int r1 = r14.mo3983b(r1)     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == r9) goto L_0x0267
            int r6 = r14.mo3991i()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            if (r6 <= 0) goto L_0x0267
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r6.<init>()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r13.f2826r = r6     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r0 = r0 | 4096(0x1000, float:5.74E-42)
        L_0x0267:
            int r6 = r14.mo3991i()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            if (r6 <= 0) goto L_0x027b
            java.util.List r6 = r13.f2826r     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            int r7 = r14.mo3986d()     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            r6.add(r7)     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            goto L_0x0267
        L_0x027b:
            r14.mo3985c(r1)     // Catch:{ s -> 0x01bd, IOException -> 0x01d1, all -> 0x0229 }
            goto L_0x001f
        L_0x0280:
            r1 = r0 & 1
            if (r1 != r3) goto L_0x028c
            com.appbrain.b.u r1 = r13.f2814f
            com.appbrain.b.u r1 = r1.mo3944b()
            r13.f2814f = r1
        L_0x028c:
            r1 = r0 & 2
            if (r1 != r10) goto L_0x0298
            com.appbrain.b.u r1 = r13.f2815g
            com.appbrain.b.u r1 = r1.mo3944b()
            r13.f2815g = r1
        L_0x0298:
            r1 = r0 & 4
            if (r1 != r11) goto L_0x02a4
            com.appbrain.b.u r1 = r13.f2816h
            com.appbrain.b.u r1 = r1.mo3944b()
            r13.f2816h = r1
        L_0x02a4:
            r1 = r0 & 8
            r2 = 8
            if (r1 != r2) goto L_0x02b2
            com.appbrain.b.u r1 = r13.f2817i
            com.appbrain.b.u r1 = r1.mo3944b()
            r13.f2817i = r1
        L_0x02b2:
            r1 = r0 & 16
            r2 = 16
            if (r1 != r2) goto L_0x02c0
            com.appbrain.b.u r1 = r13.f2818j
            com.appbrain.b.u r1 = r1.mo3944b()
            r13.f2818j = r1
        L_0x02c0:
            r1 = r0 & 32
            r2 = 32
            if (r1 != r2) goto L_0x02ce
            com.appbrain.b.u r1 = r13.f2819k
            com.appbrain.b.u r1 = r1.mo3944b()
            r13.f2819k = r1
        L_0x02ce:
            r1 = r0 & 64
            if (r1 != r8) goto L_0x02da
            java.util.List r1 = r13.f2820l
            java.util.List r1 = java.util.Collections.unmodifiableList(r1)
            r13.f2820l = r1
        L_0x02da:
            r1 = r0 & 512(0x200, float:7.175E-43)
            r2 = 512(0x200, float:7.175E-43)
            if (r1 != r2) goto L_0x02e8
            com.appbrain.b.u r1 = r13.f2823o
            com.appbrain.b.u r1 = r1.mo3944b()
            r13.f2823o = r1
        L_0x02e8:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            r2 = 1024(0x400, float:1.435E-42)
            if (r1 != r2) goto L_0x02f6
            java.util.List r1 = r13.f2824p
            java.util.List r1 = java.util.Collections.unmodifiableList(r1)
            r13.f2824p = r1
        L_0x02f6:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 != r9) goto L_0x0302
            java.util.List r0 = r13.f2826r
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            r13.f2826r = r0
        L_0x0302:
            r5.mo3992a()     // Catch:{ IOException -> 0x030c, all -> 0x0314 }
            com.appbrain.b.f r0 = r4.mo3974a()
            r13.f2812d = r0
        L_0x030b:
            return
        L_0x030c:
            r0 = move-exception
            com.appbrain.b.f r0 = r4.mo3974a()
            r13.f2812d = r0
            goto L_0x030b
        L_0x0314:
            r0 = move-exception
            com.appbrain.b.f r1 = r4.mo3974a()
            r13.f2812d = r1
            throw r0
        L_0x031c:
            r1 = move-exception
            com.appbrain.b.f r1 = r4.mo3974a()
            r13.f2812d = r1
            goto L_0x01a8
        L_0x0325:
            r0 = move-exception
            com.appbrain.b.f r1 = r4.mo3974a()
            r13.f2812d = r1
            throw r0
        L_0x032d:
            r0 = move-exception
            goto L_0x01d5
        L_0x0330:
            r1 = r0
            goto L_0x023c
        L_0x0333:
            r1 = r0
            goto L_0x020d
        L_0x0336:
            r1 = r0
            goto L_0x01f6
        L_0x0339:
            r1 = r0
            goto L_0x0102
        L_0x033c:
            r1 = r0
            goto L_0x00d7
        L_0x033f:
            r1 = r0
            goto L_0x00c2
        L_0x0342:
            r1 = r0
            goto L_0x00a7
        L_0x0345:
            r1 = r0
            goto L_0x008d
        L_0x0348:
            r1 = r0
            goto L_0x0073
        L_0x034b:
            r1 = r0
            goto L_0x005b
        L_0x034e:
            r1 = r0
            goto L_0x0043
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appbrain.p037f.C1042ah.<init>(com.appbrain.b.j, com.appbrain.b.n):void");
    }

    /* synthetic */ C1042ah(C1006j jVar, C1010n nVar, byte b) {
        this(jVar, nVar);
    }

    private C1042ah(C1012p pVar) {
        super((byte) 0);
        this.f2827s = -1;
        this.f2828t = -1;
        this.f2812d = pVar.mo4009c();
    }

    /* synthetic */ C1042ah(C1012p pVar, byte b) {
        this(pVar);
    }

    /* renamed from: f */
    public static C1042ah m4562f() {
        return f2811c;
    }

    /* renamed from: q */
    private C1002f m4571q() {
        Object obj = this.f2821m;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f2821m = a;
        return a;
    }

    /* renamed from: r */
    private C1002f m4572r() {
        Object obj = this.f2825q;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f2825q = a;
        return a;
    }

    /* renamed from: s */
    private void m4573s() {
        this.f2814f = C1016t.f2665a;
        this.f2815g = C1016t.f2665a;
        this.f2816h = C1016t.f2665a;
        this.f2817i = C1016t.f2665a;
        this.f2818j = C1016t.f2665a;
        this.f2819k = C1016t.f2665a;
        this.f2820l = Collections.emptyList();
        this.f2821m = "";
        this.f2822n = false;
        this.f2823o = C1016t.f2665a;
        this.f2824p = Collections.emptyList();
        this.f2825q = "";
        this.f2826r = Collections.emptyList();
    }

    /* renamed from: a */
    public final String mo4188a(int i) {
        return (String) this.f2814f.get(i);
    }

    /* renamed from: a */
    public final void mo4025a(C1008l lVar) {
        mo4026c();
        for (int i = 0; i < this.f2814f.size(); i++) {
            lVar.mo3996a(1, this.f2814f.mo3941a(i));
        }
        for (int i2 = 0; i2 < this.f2815g.size(); i2++) {
            lVar.mo3996a(2, this.f2815g.mo3941a(i2));
        }
        for (int i3 = 0; i3 < this.f2816h.size(); i3++) {
            lVar.mo3996a(3, this.f2816h.mo3941a(i3));
        }
        for (int i4 = 0; i4 < this.f2817i.size(); i4++) {
            lVar.mo3996a(4, this.f2817i.mo3941a(i4));
        }
        for (int i5 = 0; i5 < this.f2818j.size(); i5++) {
            lVar.mo3996a(5, this.f2818j.mo3941a(i5));
        }
        for (int i6 = 0; i6 < this.f2819k.size(); i6++) {
            lVar.mo3996a(6, this.f2819k.mo3941a(i6));
        }
        for (int i7 = 0; i7 < this.f2820l.size(); i7++) {
            lVar.mo3994a(7, ((Integer) this.f2820l.get(i7)).intValue());
        }
        if ((this.f2813e & 1) == 1) {
            lVar.mo3996a(8, m4571q());
        }
        if ((this.f2813e & 2) == 2) {
            lVar.mo3998a(9, this.f2822n);
        }
        for (int i8 = 0; i8 < this.f2823o.size(); i8++) {
            lVar.mo3996a(10, this.f2823o.mo3941a(i8));
        }
        for (int i9 = 0; i9 < this.f2824p.size(); i9++) {
            lVar.mo3997a(11, (C1020x) this.f2824p.get(i9));
        }
        if ((this.f2813e & 4) == 4) {
            lVar.mo3996a(12, m4572r());
        }
        for (int i10 = 0; i10 < this.f2826r.size(); i10++) {
            lVar.mo3994a(13, ((Integer) this.f2826r.get(i10)).intValue());
        }
        lVar.mo4003c(this.f2812d);
    }

    /* renamed from: b */
    public final String mo4189b(int i) {
        return (String) this.f2815g.get(i);
    }

    /* renamed from: c */
    public final int mo4026c() {
        int i = 0;
        int i2 = this.f2828t;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f2814f.size(); i4++) {
            i3 += C1008l.m4218b(this.f2814f.mo3941a(i4));
        }
        int size = i3 + 0 + (this.f2814f.size() * 1);
        int i5 = 0;
        for (int i6 = 0; i6 < this.f2815g.size(); i6++) {
            i5 += C1008l.m4218b(this.f2815g.mo3941a(i6));
        }
        int size2 = size + i5 + (this.f2815g.size() * 1);
        int i7 = 0;
        for (int i8 = 0; i8 < this.f2816h.size(); i8++) {
            i7 += C1008l.m4218b(this.f2816h.mo3941a(i8));
        }
        int size3 = size2 + i7 + (this.f2816h.size() * 1);
        int i9 = 0;
        for (int i10 = 0; i10 < this.f2817i.size(); i10++) {
            i9 += C1008l.m4218b(this.f2817i.mo3941a(i10));
        }
        int size4 = size3 + i9 + (this.f2817i.size() * 1);
        int i11 = 0;
        for (int i12 = 0; i12 < this.f2818j.size(); i12++) {
            i11 += C1008l.m4218b(this.f2818j.mo3941a(i12));
        }
        int size5 = size4 + i11 + (this.f2818j.size() * 1);
        int i13 = 0;
        for (int i14 = 0; i14 < this.f2819k.size(); i14++) {
            i13 += C1008l.m4218b(this.f2819k.mo3941a(i14));
        }
        int size6 = size5 + i13 + (this.f2819k.size() * 1);
        int i15 = 0;
        for (int i16 = 0; i16 < this.f2820l.size(); i16++) {
            i15 += C1008l.m4219c(((Integer) this.f2820l.get(i16)).intValue());
        }
        int size7 = size6 + i15 + (this.f2820l.size() * 1);
        if ((this.f2813e & 1) == 1) {
            size7 += C1008l.m4216b(8, m4571q());
        }
        if ((this.f2813e & 2) == 2) {
            size7 += C1008l.m4214b(9);
        }
        int i17 = 0;
        for (int i18 = 0; i18 < this.f2823o.size(); i18++) {
            i17 += C1008l.m4218b(this.f2823o.mo3941a(i18));
        }
        int size8 = size7 + i17 + (this.f2823o.size() * 1);
        for (int i19 = 0; i19 < this.f2824p.size(); i19++) {
            size8 += C1008l.m4217b(11, (C1020x) this.f2824p.get(i19));
        }
        if ((this.f2813e & 4) == 4) {
            size8 += C1008l.m4216b(12, m4572r());
        }
        int i20 = 0;
        while (i < this.f2826r.size()) {
            i++;
            i20 = C1008l.m4219c(((Integer) this.f2826r.get(i)).intValue()) + i20;
        }
        int size9 = size8 + i20 + (this.f2826r.size() * 1) + this.f2812d.mo3919a();
        this.f2828t = size9;
        return size9;
    }

    /* renamed from: c */
    public final String mo4190c(int i) {
        return (String) this.f2816h.get(i);
    }

    /* renamed from: d */
    public final /* synthetic */ C1021y mo4027d() {
        return C1044aj.m4599f().mo4208a(this);
    }

    /* renamed from: d */
    public final String mo4191d(int i) {
        return (String) this.f2817i.get(i);
    }

    /* renamed from: e */
    public final String mo4192e(int i) {
        return (String) this.f2818j.get(i);
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        byte b = this.f2827s;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.f2827s = 1;
        return true;
    }

    /* renamed from: f */
    public final String mo4193f(int i) {
        return (String) this.f2819k.get(i);
    }

    /* renamed from: g */
    public final int mo4194g() {
        return this.f2814f.size();
    }

    /* renamed from: g */
    public final int mo4195g(int i) {
        return ((Integer) this.f2820l.get(i)).intValue();
    }

    /* renamed from: h */
    public final String mo4196h(int i) {
        return (String) this.f2823o.get(i);
    }

    /* renamed from: h */
    public final boolean mo4197h() {
        return (this.f2813e & 1) == 1;
    }

    /* renamed from: i */
    public final C1046al mo4198i(int i) {
        return (C1046al) this.f2824p.get(i);
    }

    /* renamed from: i */
    public final String mo4199i() {
        Object obj = this.f2821m;
        if (obj instanceof String) {
            return (String) obj;
        }
        C1002f fVar = (C1002f) obj;
        String e = fVar.mo3970e();
        if (fVar.mo3927f()) {
            this.f2821m = e;
        }
        return e;
    }

    /* renamed from: j */
    public final int mo4200j(int i) {
        return ((Integer) this.f2826r.get(i)).intValue();
    }

    /* renamed from: j */
    public final boolean mo4201j() {
        return (this.f2813e & 2) == 2;
    }

    /* renamed from: k */
    public final boolean mo4202k() {
        return this.f2822n;
    }

    /* renamed from: l */
    public final int mo4203l() {
        return this.f2823o.size();
    }

    /* renamed from: m */
    public final int mo4204m() {
        return this.f2824p.size();
    }

    /* renamed from: n */
    public final boolean mo4205n() {
        return (this.f2813e & 4) == 4;
    }

    /* renamed from: o */
    public final String mo4206o() {
        Object obj = this.f2825q;
        if (obj instanceof String) {
            return (String) obj;
        }
        C1002f fVar = (C1002f) obj;
        String e = fVar.mo3970e();
        if (fVar.mo3927f()) {
            this.f2825q = e;
        }
        return e;
    }

    /* renamed from: p */
    public final int mo4207p() {
        return this.f2826r.size();
    }
}
