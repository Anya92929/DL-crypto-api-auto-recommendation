package com.appbrain;

import android.app.Activity;
import android.content.Context;

/* renamed from: com.appbrain.aa */
public class C0980aa {

    /* renamed from: a */
    private final C1025d f2594a = new C1025d();

    private C0980aa() {
    }

    /* renamed from: a */
    public static C0980aa m4089a() {
        return new C0980aa();
    }

    /* renamed from: b */
    private void m4090b() {
        if (this.f2594a.mo4039e() != null) {
            throw new IllegalStateException("You can only call either setListener() or setFinishOnExit() once");
        }
    }

    /* renamed from: a */
    public C0980aa mo3904a(Activity activity) {
        m4090b();
        this.f2594a.mo4031a((C0982ac) new C0981ab(this, activity));
        return this;
    }

    /* renamed from: a */
    public C0980aa mo3905a(C0783a aVar) {
        this.f2594a.mo4035a(aVar);
        return this;
    }

    /* renamed from: a */
    public C0980aa mo3906a(C0982ac acVar) {
        m4090b();
        this.f2594a.mo4031a(acVar);
        return this;
    }

    /* renamed from: a */
    public C0980aa mo3907a(C1027e eVar) {
        this.f2594a.mo4032a(eVar);
        return this;
    }

    /* renamed from: a */
    public C0980aa mo3908a(String str) {
        this.f2594a.mo4033a(str);
        return this;
    }

    /* renamed from: a */
    public boolean mo3909a(Context context) {
        return C1121k.m5207a().mo3697b(context, this.f2594a);
    }

    /* renamed from: b */
    public boolean mo3910b(Context context) {
        return C1121k.m5207a().mo3695a(context, this.f2594a);
    }
}
