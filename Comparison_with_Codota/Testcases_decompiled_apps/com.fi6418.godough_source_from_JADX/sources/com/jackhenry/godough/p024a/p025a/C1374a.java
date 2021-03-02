package com.jackhenry.godough.p024a.p025a;

/* renamed from: com.jackhenry.godough.a.a.a */
public class C1374a {

    /* renamed from: a */
    private String f5714a;

    /* renamed from: b */
    private String f5715b;

    /* renamed from: c */
    private String f5716c;

    /* renamed from: d */
    private String f5717d;

    /* renamed from: e */
    private String f5718e;

    /* renamed from: f */
    private C1375b f5719f;

    public C1374a(String str, String str2, String str3, String[] strArr) {
        this.f5714a = str;
        this.f5715b = str2;
        this.f5716c = str3;
        mo9415a(strArr[0]);
        mo9417b(strArr[1]);
        if (mo9420e().equals("SplashActivity")) {
            mo9415a("Splash Screen");
        } else if (mo9420e().equals("HomeFragmentActivity")) {
            mo9415a("Dashboard");
        } else if (mo9420e().equals("LoginActivity")) {
            mo9415a("Login");
        }
        mo9414a(C1375b.EVENT);
    }

    public C1374a(String[] strArr) {
        this((String) null, (String) null, (String) null, strArr);
        mo9414a(C1375b.PAGE_ONLY);
    }

    /* renamed from: a */
    public String mo9412a() {
        return this.f5714a;
    }

    /* renamed from: a */
    public String mo9413a(boolean z) {
        return z ? mo9420e() : mo9419d();
    }

    /* renamed from: a */
    public void mo9414a(C1375b bVar) {
        this.f5719f = bVar;
    }

    /* renamed from: a */
    public void mo9415a(String str) {
        this.f5717d = str;
    }

    /* renamed from: b */
    public String mo9416b() {
        return this.f5715b;
    }

    /* renamed from: b */
    public void mo9417b(String str) {
        this.f5718e = str;
    }

    /* renamed from: c */
    public String mo9418c() {
        return this.f5716c;
    }

    /* renamed from: d */
    public String mo9419d() {
        return this.f5717d != null ? this.f5717d : "No Page Name";
    }

    /* renamed from: e */
    public String mo9420e() {
        return this.f5718e;
    }

    /* renamed from: f */
    public C1375b mo9421f() {
        return this.f5719f;
    }
}
