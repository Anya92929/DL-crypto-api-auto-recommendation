package com.google.android.gms.p018c;

import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: com.google.android.gms.c.ba */
public final class C0639ba extends C0626ao<C0639ba> {

    /* renamed from: a */
    public int f4268a;

    /* renamed from: b */
    public int f4269b;

    /* renamed from: c */
    public int f4270c;

    /* renamed from: d */
    public int f4271d;

    /* renamed from: e */
    public int f4272e;

    /* renamed from: f */
    private String f4273f;

    /* renamed from: a */
    public int mo7060a() {
        return this.f4268a;
    }

    /* renamed from: a */
    public void mo7061a(int i) {
        this.f4268a = i;
    }

    /* renamed from: a */
    public void mo7010a(C0639ba baVar) {
        if (this.f4268a != 0) {
            baVar.mo7061a(this.f4268a);
        }
        if (this.f4269b != 0) {
            baVar.mo7065b(this.f4269b);
        }
        if (this.f4270c != 0) {
            baVar.mo7067c(this.f4270c);
        }
        if (this.f4271d != 0) {
            baVar.mo7069d(this.f4271d);
        }
        if (this.f4272e != 0) {
            baVar.mo7071e(this.f4272e);
        }
        if (!TextUtils.isEmpty(this.f4273f)) {
            baVar.mo7063a(this.f4273f);
        }
    }

    /* renamed from: a */
    public void mo7063a(String str) {
        this.f4273f = str;
    }

    /* renamed from: b */
    public int mo7064b() {
        return this.f4269b;
    }

    /* renamed from: b */
    public void mo7065b(int i) {
        this.f4269b = i;
    }

    /* renamed from: c */
    public int mo7066c() {
        return this.f4270c;
    }

    /* renamed from: c */
    public void mo7067c(int i) {
        this.f4270c = i;
    }

    /* renamed from: d */
    public int mo7068d() {
        return this.f4271d;
    }

    /* renamed from: d */
    public void mo7069d(int i) {
        this.f4271d = i;
    }

    /* renamed from: e */
    public int mo7070e() {
        return this.f4272e;
    }

    /* renamed from: e */
    public void mo7071e(int i) {
        this.f4272e = i;
    }

    /* renamed from: f */
    public String mo7072f() {
        return this.f4273f;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("language", this.f4273f);
        hashMap.put("screenColors", Integer.valueOf(this.f4268a));
        hashMap.put("screenWidth", Integer.valueOf(this.f4269b));
        hashMap.put("screenHeight", Integer.valueOf(this.f4270c));
        hashMap.put("viewportWidth", Integer.valueOf(this.f4271d));
        hashMap.put("viewportHeight", Integer.valueOf(this.f4272e));
        return m3607a((Object) hashMap);
    }
}
