package com.appbrain.p037f;

import com.appbrain.p033b.C0986aa;
import com.appbrain.p033b.C1002f;
import com.appbrain.p033b.C1006j;
import com.appbrain.p033b.C1008l;
import com.appbrain.p033b.C1010n;
import com.appbrain.p033b.C1011o;
import com.appbrain.p033b.C1012p;
import com.appbrain.p033b.C1020x;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* renamed from: com.appbrain.f.v */
public final class C1094v extends C1011o implements C1097y {

    /* renamed from: b */
    public static C0986aa f3052b = new C1095w();

    /* renamed from: c */
    private static final C1094v f3053c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1002f f3054d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f3055e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1035aa f3056f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f3057g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List f3058h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f3059i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public List f3060j;

    /* renamed from: k */
    private byte f3061k;

    /* renamed from: l */
    private int f3062l;

    static {
        C1094v vVar = new C1094v();
        f3053c = vVar;
        vVar.m5049o();
    }

    private C1094v() {
        this.f3061k = -1;
        this.f3062l = -1;
        this.f3054d = C1002f.f2629a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00de, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x0090=Splitter:B:34:0x0090, B:17:0x005a=Splitter:B:17:0x005a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C1094v(com.appbrain.p033b.C1006j r11, com.appbrain.p033b.C1010n r12) {
        /*
            r10 = this;
            r0 = 0
            r1 = -1
            r8 = 16
            r7 = 4
            r4 = 1
            r10.<init>()
            r10.f3061k = r1
            r10.f3062l = r1
            r10.m5049o()
            com.appbrain.b.i r5 = com.appbrain.p033b.C1002f.m4164g()
            com.appbrain.b.l r6 = com.appbrain.p033b.C1008l.m4211a((java.io.OutputStream) r5)
            r3 = r0
            r1 = r0
        L_0x001a:
            if (r3 != 0) goto L_0x00e1
            int r0 = r11.mo3978a()     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            switch(r0) {
                case 0: goto L_0x002b;
                case 10: goto L_0x002d;
                case 16: goto L_0x0082;
                case 26: goto L_0x009e;
                case 32: goto L_0x00b8;
                case 42: goto L_0x00c6;
                default: goto L_0x0023;
            }     // Catch:{ s -> 0x0059, IOException -> 0x008f }
        L_0x0023:
            boolean r0 = r11.mo3981a((int) r0, (com.appbrain.p033b.C1008l) r6)     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            if (r0 != 0) goto L_0x013b
            r3 = r4
            goto L_0x001a
        L_0x002b:
            r3 = r4
            goto L_0x001a
        L_0x002d:
            r0 = 0
            int r2 = r10.f3055e     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            r2 = r2 & 1
            if (r2 != r4) goto L_0x0138
            com.appbrain.f.aa r0 = r10.f3056f     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            com.appbrain.f.ac r0 = com.appbrain.p037f.C1035aa.m4313a((com.appbrain.p037f.C1035aa) r0)     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            r2 = r0
        L_0x003b:
            com.appbrain.b.aa r0 = com.appbrain.p037f.C1035aa.f2695b     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            com.appbrain.b.x r0 = r11.mo3979a((com.appbrain.p033b.C0986aa) r0, (com.appbrain.p033b.C1010n) r12)     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            com.appbrain.f.aa r0 = (com.appbrain.p037f.C1035aa) r0     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            r10.f3056f = r0     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            if (r2 == 0) goto L_0x0052
            com.appbrain.f.aa r0 = r10.f3056f     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            r2.mo4139a((com.appbrain.p037f.C1035aa) r0)     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            com.appbrain.f.aa r0 = r2.mo4163g()     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            r10.f3056f = r0     // Catch:{ s -> 0x0059, IOException -> 0x008f }
        L_0x0052:
            int r0 = r10.f3055e     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            r0 = r0 | 1
            r10.f3055e = r0     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            goto L_0x001a
        L_0x0059:
            r0 = move-exception
        L_0x005a:
            com.appbrain.b.s r0 = r0.mo4010a(r10)     // Catch:{ all -> 0x005f }
            throw r0     // Catch:{ all -> 0x005f }
        L_0x005f:
            r0 = move-exception
        L_0x0060:
            r2 = r1 & 4
            if (r2 != r7) goto L_0x006c
            java.util.List r2 = r10.f3058h
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)
            r10.f3058h = r2
        L_0x006c:
            r1 = r1 & 16
            if (r1 != r8) goto L_0x0078
            java.util.List r1 = r10.f3060j
            java.util.List r1 = java.util.Collections.unmodifiableList(r1)
            r10.f3060j = r1
        L_0x0078:
            r6.mo3992a()     // Catch:{ IOException -> 0x0113, all -> 0x011c }
            com.appbrain.b.f r1 = r5.mo3974a()
            r10.f3054d = r1
        L_0x0081:
            throw r0
        L_0x0082:
            int r0 = r10.f3055e     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            r0 = r0 | 2
            r10.f3055e = r0     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            boolean r0 = r11.mo3987e()     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            r10.f3057g = r0     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            goto L_0x001a
        L_0x008f:
            r0 = move-exception
        L_0x0090:
            com.appbrain.b.s r2 = new com.appbrain.b.s     // Catch:{ all -> 0x005f }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x005f }
            r2.<init>(r0)     // Catch:{ all -> 0x005f }
            com.appbrain.b.s r0 = r2.mo4010a(r10)     // Catch:{ all -> 0x005f }
            throw r0     // Catch:{ all -> 0x005f }
        L_0x009e:
            r0 = r1 & 4
            if (r0 == r7) goto L_0x00ab
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            r0.<init>()     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            r10.f3058h = r0     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            r1 = r1 | 4
        L_0x00ab:
            java.util.List r0 = r10.f3058h     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            com.appbrain.b.aa r2 = com.appbrain.p037f.C1061b.f2930b     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            com.appbrain.b.x r2 = r11.mo3979a((com.appbrain.p033b.C0986aa) r2, (com.appbrain.p033b.C1010n) r12)     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            r0.add(r2)     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            goto L_0x001a
        L_0x00b8:
            int r0 = r10.f3055e     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            r0 = r0 | 4
            r10.f3055e = r0     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            boolean r0 = r11.mo3987e()     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            r10.f3059i = r0     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            goto L_0x001a
        L_0x00c6:
            r0 = r1 & 16
            if (r0 == r8) goto L_0x0136
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            r0.<init>()     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            r10.f3060j = r0     // Catch:{ s -> 0x0059, IOException -> 0x008f }
            r0 = r1 | 16
        L_0x00d3:
            java.util.List r1 = r10.f3060j     // Catch:{ s -> 0x0130, IOException -> 0x012a, all -> 0x0124 }
            com.appbrain.b.aa r2 = com.appbrain.p037f.C1078f.f3002b     // Catch:{ s -> 0x0130, IOException -> 0x012a, all -> 0x0124 }
            com.appbrain.b.x r2 = r11.mo3979a((com.appbrain.p033b.C0986aa) r2, (com.appbrain.p033b.C1010n) r12)     // Catch:{ s -> 0x0130, IOException -> 0x012a, all -> 0x0124 }
            r1.add(r2)     // Catch:{ s -> 0x0130, IOException -> 0x012a, all -> 0x0124 }
        L_0x00de:
            r1 = r0
            goto L_0x001a
        L_0x00e1:
            r0 = r1 & 4
            if (r0 != r7) goto L_0x00ed
            java.util.List r0 = r10.f3058h
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            r10.f3058h = r0
        L_0x00ed:
            r0 = r1 & 16
            if (r0 != r8) goto L_0x00f9
            java.util.List r0 = r10.f3060j
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            r10.f3060j = r0
        L_0x00f9:
            r6.mo3992a()     // Catch:{ IOException -> 0x0103, all -> 0x010b }
            com.appbrain.b.f r0 = r5.mo3974a()
            r10.f3054d = r0
        L_0x0102:
            return
        L_0x0103:
            r0 = move-exception
            com.appbrain.b.f r0 = r5.mo3974a()
            r10.f3054d = r0
            goto L_0x0102
        L_0x010b:
            r0 = move-exception
            com.appbrain.b.f r1 = r5.mo3974a()
            r10.f3054d = r1
            throw r0
        L_0x0113:
            r1 = move-exception
            com.appbrain.b.f r1 = r5.mo3974a()
            r10.f3054d = r1
            goto L_0x0081
        L_0x011c:
            r0 = move-exception
            com.appbrain.b.f r1 = r5.mo3974a()
            r10.f3054d = r1
            throw r0
        L_0x0124:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
            goto L_0x0060
        L_0x012a:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
            goto L_0x0090
        L_0x0130:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
            goto L_0x005a
        L_0x0136:
            r0 = r1
            goto L_0x00d3
        L_0x0138:
            r2 = r0
            goto L_0x003b
        L_0x013b:
            r0 = r1
            goto L_0x00de
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appbrain.p037f.C1094v.<init>(com.appbrain.b.j, com.appbrain.b.n):void");
    }

    /* synthetic */ C1094v(C1006j jVar, C1010n nVar, byte b) {
        this(jVar, nVar);
    }

    private C1094v(C1012p pVar) {
        super((byte) 0);
        this.f3061k = -1;
        this.f3062l = -1;
        this.f3054d = pVar.mo4009c();
    }

    /* synthetic */ C1094v(C1012p pVar, byte b) {
        this(pVar);
    }

    /* renamed from: a */
    public static C1094v m5039a(InputStream inputStream) {
        return (C1094v) f3052b.mo3917a(inputStream);
    }

    /* renamed from: f */
    public static C1094v m5047f() {
        return f3053c;
    }

    /* renamed from: m */
    public static C1096x m5048m() {
        return C1096x.m5062g();
    }

    /* renamed from: o */
    private void m5049o() {
        this.f3056f = C1035aa.m4359f();
        this.f3057g = false;
        this.f3058h = Collections.emptyList();
        this.f3059i = false;
        this.f3060j = Collections.emptyList();
    }

    /* renamed from: a */
    public final void mo4025a(C1008l lVar) {
        mo4026c();
        if ((this.f3055e & 1) == 1) {
            lVar.mo3997a(1, (C1020x) this.f3056f);
        }
        if ((this.f3055e & 2) == 2) {
            lVar.mo3998a(2, this.f3057g);
        }
        for (int i = 0; i < this.f3058h.size(); i++) {
            lVar.mo3997a(3, (C1020x) this.f3058h.get(i));
        }
        if ((this.f3055e & 4) == 4) {
            lVar.mo3998a(4, this.f3059i);
        }
        for (int i2 = 0; i2 < this.f3060j.size(); i2++) {
            lVar.mo3997a(5, (C1020x) this.f3060j.get(i2));
        }
        lVar.mo4003c(this.f3054d);
    }

    /* renamed from: c */
    public final int mo4026c() {
        int i = this.f3062l;
        if (i != -1) {
            return i;
        }
        int b = (this.f3055e & 1) == 1 ? C1008l.m4217b(1, (C1020x) this.f3056f) + 0 : 0;
        if ((this.f3055e & 2) == 2) {
            b += C1008l.m4214b(2);
        }
        int i2 = b;
        for (int i3 = 0; i3 < this.f3058h.size(); i3++) {
            i2 += C1008l.m4217b(3, (C1020x) this.f3058h.get(i3));
        }
        if ((this.f3055e & 4) == 4) {
            i2 += C1008l.m4214b(4);
        }
        for (int i4 = 0; i4 < this.f3060j.size(); i4++) {
            i2 += C1008l.m4217b(5, (C1020x) this.f3060j.get(i4));
        }
        int a = this.f3054d.mo3919a() + i2;
        this.f3062l = a;
        return a;
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        byte b = this.f3061k;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.f3061k = 1;
        return true;
    }

    /* renamed from: g */
    public final boolean mo4361g() {
        return (this.f3055e & 1) == 1;
    }

    /* renamed from: h */
    public final C1035aa mo4362h() {
        return this.f3056f;
    }

    /* renamed from: i */
    public final boolean mo4363i() {
        return (this.f3055e & 2) == 2;
    }

    /* renamed from: j */
    public final boolean mo4364j() {
        return this.f3057g;
    }

    /* renamed from: k */
    public final boolean mo4365k() {
        return (this.f3055e & 4) == 4;
    }

    /* renamed from: l */
    public final boolean mo4366l() {
        return this.f3059i;
    }

    /* renamed from: n */
    public final C1096x mo4027d() {
        return C1096x.m5062g().mo4371a(this);
    }
}
