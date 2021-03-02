package com.appbrain.p037f;

import com.appbrain.p033b.C0986aa;
import com.appbrain.p033b.C1002f;
import com.appbrain.p033b.C1006j;
import com.appbrain.p033b.C1008l;
import com.appbrain.p033b.C1011o;
import com.appbrain.p033b.C1012p;
import com.appbrain.p033b.C1016t;
import com.appbrain.p033b.C1017u;
import com.appbrain.p033b.C1021y;

/* renamed from: com.appbrain.f.al */
public final class C1046al extends C1011o implements C1049ao {

    /* renamed from: b */
    public static C0986aa f2843b = new C1047am();

    /* renamed from: c */
    private static final C1046al f2844c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1002f f2845d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f2846e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Object f2847f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f2848g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C1017u f2849h;

    /* renamed from: i */
    private byte f2850i;

    /* renamed from: j */
    private int f2851j;

    static {
        C1046al alVar = new C1046al();
        f2844c = alVar;
        alVar.m4616l();
    }

    private C1046al() {
        this.f2850i = -1;
        this.f2851j = -1;
        this.f2845d = C1002f.f2629a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C1046al(com.appbrain.p033b.C1006j r11) {
        /*
            r10 = this;
            r2 = 1
            r0 = 0
            r1 = -1
            r8 = 4
            r10.<init>()
            r10.f2850i = r1
            r10.f2851j = r1
            r10.m4616l()
            com.appbrain.b.i r3 = com.appbrain.p033b.C1002f.m4164g()
            com.appbrain.b.l r4 = com.appbrain.p033b.C1008l.m4211a((java.io.OutputStream) r3)
            r1 = r0
        L_0x0017:
            if (r1 != 0) goto L_0x0092
            int r5 = r11.mo3978a()     // Catch:{ s -> 0x0037, IOException -> 0x0064, all -> 0x008d }
            switch(r5) {
                case 0: goto L_0x0028;
                case 10: goto L_0x002a;
                case 16: goto L_0x0057;
                case 26: goto L_0x0076;
                default: goto L_0x0020;
            }     // Catch:{ s -> 0x0037, IOException -> 0x0064, all -> 0x008d }
        L_0x0020:
            boolean r5 = r11.mo3981a((int) r5, (com.appbrain.p033b.C1008l) r4)     // Catch:{ s -> 0x0037, IOException -> 0x0064, all -> 0x008d }
            if (r5 != 0) goto L_0x0017
            r1 = r2
            goto L_0x0017
        L_0x0028:
            r1 = r2
            goto L_0x0017
        L_0x002a:
            com.appbrain.b.f r5 = r11.mo3988f()     // Catch:{ s -> 0x0037, IOException -> 0x0064, all -> 0x008d }
            int r6 = r10.f2846e     // Catch:{ s -> 0x0037, IOException -> 0x0064, all -> 0x008d }
            r6 = r6 | 1
            r10.f2846e = r6     // Catch:{ s -> 0x0037, IOException -> 0x0064, all -> 0x008d }
            r10.f2847f = r5     // Catch:{ s -> 0x0037, IOException -> 0x0064, all -> 0x008d }
            goto L_0x0017
        L_0x0037:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
            com.appbrain.b.s r0 = r0.mo4010a(r10)     // Catch:{ all -> 0x0040 }
            throw r0     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r0 = move-exception
        L_0x0041:
            r1 = r1 & 4
            if (r1 != r8) goto L_0x004d
            com.appbrain.b.u r1 = r10.f2849h
            com.appbrain.b.u r1 = r1.mo3944b()
            r10.f2849h = r1
        L_0x004d:
            r4.mo3992a()     // Catch:{ IOException -> 0x00b8, all -> 0x00c0 }
            com.appbrain.b.f r1 = r3.mo3974a()
            r10.f2845d = r1
        L_0x0056:
            throw r0
        L_0x0057:
            int r5 = r10.f2846e     // Catch:{ s -> 0x0037, IOException -> 0x0064, all -> 0x008d }
            r5 = r5 | 2
            r10.f2846e = r5     // Catch:{ s -> 0x0037, IOException -> 0x0064, all -> 0x008d }
            long r6 = r11.mo3984c()     // Catch:{ s -> 0x0037, IOException -> 0x0064, all -> 0x008d }
            r10.f2848g = r6     // Catch:{ s -> 0x0037, IOException -> 0x0064, all -> 0x008d }
            goto L_0x0017
        L_0x0064:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
            com.appbrain.b.s r2 = new com.appbrain.b.s     // Catch:{ all -> 0x0040 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0040 }
            r2.<init>(r0)     // Catch:{ all -> 0x0040 }
            com.appbrain.b.s r0 = r2.mo4010a(r10)     // Catch:{ all -> 0x0040 }
            throw r0     // Catch:{ all -> 0x0040 }
        L_0x0076:
            com.appbrain.b.f r5 = r11.mo3988f()     // Catch:{ s -> 0x0037, IOException -> 0x0064, all -> 0x008d }
            r6 = r0 & 4
            if (r6 == r8) goto L_0x0087
            com.appbrain.b.t r6 = new com.appbrain.b.t     // Catch:{ s -> 0x0037, IOException -> 0x0064, all -> 0x008d }
            r6.<init>()     // Catch:{ s -> 0x0037, IOException -> 0x0064, all -> 0x008d }
            r10.f2849h = r6     // Catch:{ s -> 0x0037, IOException -> 0x0064, all -> 0x008d }
            r0 = r0 | 4
        L_0x0087:
            com.appbrain.b.u r6 = r10.f2849h     // Catch:{ s -> 0x0037, IOException -> 0x0064, all -> 0x008d }
            r6.mo3943a((com.appbrain.p033b.C1002f) r5)     // Catch:{ s -> 0x0037, IOException -> 0x0064, all -> 0x008d }
            goto L_0x0017
        L_0x008d:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
            goto L_0x0041
        L_0x0092:
            r0 = r0 & 4
            if (r0 != r8) goto L_0x009e
            com.appbrain.b.u r0 = r10.f2849h
            com.appbrain.b.u r0 = r0.mo3944b()
            r10.f2849h = r0
        L_0x009e:
            r4.mo3992a()     // Catch:{ IOException -> 0x00a8, all -> 0x00b0 }
            com.appbrain.b.f r0 = r3.mo3974a()
            r10.f2845d = r0
        L_0x00a7:
            return
        L_0x00a8:
            r0 = move-exception
            com.appbrain.b.f r0 = r3.mo3974a()
            r10.f2845d = r0
            goto L_0x00a7
        L_0x00b0:
            r0 = move-exception
            com.appbrain.b.f r1 = r3.mo3974a()
            r10.f2845d = r1
            throw r0
        L_0x00b8:
            r1 = move-exception
            com.appbrain.b.f r1 = r3.mo3974a()
            r10.f2845d = r1
            goto L_0x0056
        L_0x00c0:
            r0 = move-exception
            com.appbrain.b.f r1 = r3.mo3974a()
            r10.f2845d = r1
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appbrain.p037f.C1046al.<init>(com.appbrain.b.j):void");
    }

    /* synthetic */ C1046al(C1006j jVar, byte b) {
        this(jVar);
    }

    private C1046al(C1012p pVar) {
        super((byte) 0);
        this.f2850i = -1;
        this.f2851j = -1;
        this.f2845d = pVar.mo4009c();
    }

    /* synthetic */ C1046al(C1012p pVar, byte b) {
        this(pVar);
    }

    /* renamed from: f */
    public static C1046al m4614f() {
        return f2844c;
    }

    /* renamed from: k */
    private C1002f m4615k() {
        Object obj = this.f2847f;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f2847f = a;
        return a;
    }

    /* renamed from: l */
    private void m4616l() {
        this.f2847f = "";
        this.f2848g = 0;
        this.f2849h = C1016t.f2665a;
    }

    /* renamed from: a */
    public final void mo4025a(C1008l lVar) {
        mo4026c();
        if ((this.f2846e & 1) == 1) {
            lVar.mo3996a(1, m4615k());
        }
        if ((this.f2846e & 2) == 2) {
            lVar.mo3995a(2, this.f2848g);
        }
        for (int i = 0; i < this.f2849h.size(); i++) {
            lVar.mo3996a(3, this.f2849h.mo3941a(i));
        }
        lVar.mo4003c(this.f2845d);
    }

    /* renamed from: c */
    public final int mo4026c() {
        int i = this.f2851j;
        if (i != -1) {
            return i;
        }
        int b = (this.f2846e & 1) == 1 ? C1008l.m4216b(1, m4615k()) + 0 : 0;
        if ((this.f2846e & 2) == 2) {
            b += C1008l.m4215b(2, this.f2848g);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f2849h.size(); i3++) {
            i2 += C1008l.m4218b(this.f2849h.mo3941a(i3));
        }
        int size = b + i2 + (this.f2849h.size() * 1) + this.f2845d.mo3919a();
        this.f2851j = size;
        return size;
    }

    /* renamed from: d */
    public final /* synthetic */ C1021y mo4027d() {
        return C1048an.m4626f().mo4213a(this);
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        byte b = this.f2850i;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.f2850i = 1;
        return true;
    }

    /* renamed from: g */
    public final boolean mo4209g() {
        return (this.f2846e & 1) == 1;
    }

    /* renamed from: h */
    public final String mo4210h() {
        Object obj = this.f2847f;
        if (obj instanceof String) {
            return (String) obj;
        }
        C1002f fVar = (C1002f) obj;
        String e = fVar.mo3970e();
        if (fVar.mo3927f()) {
            this.f2847f = e;
        }
        return e;
    }

    /* renamed from: i */
    public final boolean mo4211i() {
        return (this.f2846e & 2) == 2;
    }

    /* renamed from: j */
    public final long mo4212j() {
        return this.f2848g;
    }
}
