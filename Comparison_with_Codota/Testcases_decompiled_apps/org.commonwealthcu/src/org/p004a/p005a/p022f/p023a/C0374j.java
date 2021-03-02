package org.p004a.p005a.p022f.p023a;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.p004a.p005a.C0546k;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p022f.C0380e;
import org.p004a.p005a.p022f.p023a.p024a.C0363a;
import org.p004a.p005a.p022f.p023a.p024a.C0365c;

/* renamed from: org.a.a.f.a.j */
public final class C0374j {

    /* renamed from: a */
    private static final char[] f213a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* renamed from: b */
    private String f214b = "form-data";

    /* renamed from: c */
    private int f215c = C0369e.f203a;

    /* renamed from: d */
    private String f216d = null;

    /* renamed from: e */
    private Charset f217e = null;

    /* renamed from: f */
    private List f218f = null;

    C0374j() {
    }

    /* renamed from: a */
    public static C0374j m439a() {
        return new C0374j();
    }

    /* renamed from: a */
    public final C0374j mo5112a(int i) {
        this.f215c = i;
        return this;
    }

    /* renamed from: a */
    public final C0374j mo5113a(String str, String str2) {
        return mo5114a(str, (C0363a) new C0365c(str2, C0380e.f226a));
    }

    /* renamed from: a */
    public final C0374j mo5114a(String str, C0363a aVar) {
        C0250b.m84a((Object) str, "Name");
        C0250b.m84a((Object) aVar, "Content body");
        C0366b bVar = new C0366b(str, aVar);
        if (this.f218f == null) {
            this.f218f = new ArrayList();
        }
        this.f218f.add(bVar);
        return this;
    }

    /* renamed from: b */
    public final C0546k mo5115b() {
        C0362a fVar;
        Charset charset = null;
        String str = this.f214b != null ? this.f214b : "form-data";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int nextInt = random.nextInt(11) + 30;
        for (int i = 0; i < nextInt; i++) {
            sb.append(f213a[random.nextInt(f213a.length)]);
        }
        String sb2 = sb.toString();
        List arrayList = this.f218f != null ? new ArrayList(this.f218f) : Collections.emptyList();
        switch (C0375k.f219a[(this.f215c != 0 ? this.f215c : C0369e.f203a) - 1]) {
            case 1:
                fVar = new C0368d(str, charset, sb2, arrayList);
                break;
            case 2:
                fVar = new C0370f(str, charset, sb2, arrayList);
                break;
            default:
                fVar = new C0371g(str, charset, sb2, arrayList);
                break;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("multipart/form-data; boundary=");
        sb3.append(sb2);
        if (charset != null) {
            sb3.append("; charset=");
            sb3.append(charset.name());
        }
        return new C0376l(fVar, sb3.toString(), fVar.mo5096b());
    }
}
