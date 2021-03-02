package com.google.ads;

import com.google.ads.util.C0282a;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.google.ads.a */
public class C0166a {

    /* renamed from: a */
    private final String f119a;

    /* renamed from: b */
    private final String f120b;

    /* renamed from: c */
    private final List<String> f121c;

    /* renamed from: d */
    private final List<String> f122d;

    /* renamed from: e */
    private final HashMap<String, String> f123e;

    public C0166a(String str, String str2, List<String> list, List<String> list2, HashMap<String, String> hashMap) {
        C0282a.m471a(str2);
        if (str != null) {
            C0282a.m471a(str);
        }
        this.f119a = str;
        this.f120b = str2;
        this.f121c = list;
        this.f123e = hashMap;
        this.f122d = list2;
    }

    /* renamed from: a */
    public String mo3320a() {
        return this.f119a;
    }

    /* renamed from: b */
    public String mo3321b() {
        return this.f120b;
    }

    /* renamed from: c */
    public List<String> mo3322c() {
        return this.f121c;
    }

    /* renamed from: d */
    public List<String> mo3323d() {
        return this.f122d;
    }

    /* renamed from: e */
    public HashMap<String, String> mo3324e() {
        return this.f123e;
    }
}
