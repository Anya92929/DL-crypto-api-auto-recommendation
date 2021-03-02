package com.google.ads.internal;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;

/* renamed from: com.google.ads.internal.e */
public class C0248e {

    /* renamed from: a */
    private final String f560a;

    /* renamed from: b */
    private HashMap<String, String> f561b;

    public C0248e(Bundle bundle) {
        this.f560a = bundle.getString("action");
        this.f561b = m333a(bundle.getSerializable("params"));
    }

    public C0248e(String str) {
        this.f560a = str;
    }

    public C0248e(String str, HashMap<String, String> hashMap) {
        this(str);
        this.f561b = hashMap;
    }

    /* renamed from: a */
    private HashMap<String, String> m333a(Serializable serializable) {
        if (serializable instanceof HashMap) {
            return (HashMap) serializable;
        }
        return null;
    }

    /* renamed from: a */
    public Bundle mo3568a() {
        Bundle bundle = new Bundle();
        bundle.putString("action", this.f560a);
        bundle.putSerializable("params", this.f561b);
        return bundle;
    }

    /* renamed from: b */
    public String mo3569b() {
        return this.f560a;
    }

    /* renamed from: c */
    public HashMap<String, String> mo3570c() {
        return this.f561b;
    }
}
