package com.google.android.gms.p018c;

import com.google.android.gms.common.internal.C1009bf;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.c.i */
public final class C0667i extends C0626ao<C0667i> {

    /* renamed from: a */
    private final Map<String, Object> f4362a = new HashMap();

    /* renamed from: a */
    private String m3859a(String str) {
        C1009bf.m4530a(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        C1009bf.m4531a(str, (Object) "Name can not be empty or \"&\"");
        return str;
    }

    /* renamed from: a */
    public Map<String, Object> mo7211a() {
        return Collections.unmodifiableMap(this.f4362a);
    }

    /* renamed from: a */
    public void mo7010a(C0667i iVar) {
        C1009bf.m4528a(iVar);
        iVar.f4362a.putAll(this.f4362a);
    }

    /* renamed from: a */
    public void mo7213a(String str, String str2) {
        this.f4362a.put(m3859a(str), str2);
    }

    public String toString() {
        return m3607a((Object) this.f4362a);
    }
}
