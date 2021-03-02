package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.internal.C0514aa;
import com.google.android.gms.analytics.internal.C0516ac;
import com.google.android.gms.analytics.internal.C0560h;
import com.google.android.gms.analytics.internal.C0570r;
import com.google.android.gms.common.internal.C1009bf;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* renamed from: com.google.android.gms.analytics.t */
public class C0589t extends C0514aa {

    /* renamed from: a */
    private boolean f3928a;

    /* renamed from: b */
    private final Map<String, String> f3929b = new HashMap();

    /* renamed from: c */
    private final Map<String, String> f3930c = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C0560h f3931d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C0591v f3932e;

    C0589t(C0516ac acVar, String str, C0560h hVar) {
        super(acVar);
        if (str != null) {
            this.f3929b.put("&tid", str);
        }
        this.f3929b.put("useSecure", "1");
        this.f3929b.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
        if (hVar == null) {
            this.f3931d = new C0560h("tracking");
        } else {
            this.f3931d = hVar;
        }
        this.f3932e = new C0591v(this, acVar);
    }

    /* renamed from: a */
    private static void m3448a(Map<String, String> map, Map<String, String> map2) {
        C1009bf.m4528a(map2);
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                String b = m3451b((Map.Entry<String, String>) next);
                if (b != null) {
                    map2.put(b, next.getValue());
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m3449a(Map.Entry<String, String> entry) {
        String key = entry.getKey();
        String value = entry.getValue();
        return key.startsWith("&") && key.length() >= 2;
    }

    /* renamed from: b */
    private static String m3451b(Map.Entry<String, String> entry) {
        if (!m3449a(entry)) {
            return null;
        }
        return entry.getKey().substring(1);
    }

    /* renamed from: b */
    private static void m3452b(Map<String, String> map, Map<String, String> map2) {
        C1009bf.m4528a(map2);
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                String b = m3451b((Map.Entry<String, String>) next);
                if (b != null && !map2.containsKey(b)) {
                    map2.put(b, next.getValue());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6598a() {
        this.f3932e.mo6597E();
        String c = mo6893v().mo6838c();
        if (c != null) {
            mo6929a("&an", c);
        }
        String b = mo6893v().mo6837b();
        if (b != null) {
            mo6929a("&av", b);
        }
    }

    /* renamed from: a */
    public void mo6928a(String str) {
        mo6929a("&cd", str);
    }

    /* renamed from: a */
    public void mo6929a(String str, String str2) {
        C1009bf.m4529a(str, (Object) "Key should be non-null");
        if (!TextUtils.isEmpty(str)) {
            this.f3929b.put(str, str2);
        }
    }

    /* renamed from: a */
    public void mo6930a(Map<String, String> map) {
        long a = mo6885n().mo6990a();
        if (mo6890s().mo6908f()) {
            mo6873c("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        boolean e = mo6890s().mo6907e();
        HashMap hashMap = new HashMap();
        m3448a(this.f3929b, (Map<String, String>) hashMap);
        m3448a(map, (Map<String, String>) hashMap);
        boolean a2 = C0570r.m3335a(this.f3929b.get("useSecure"), true);
        m3452b(this.f3930c, hashMap);
        this.f3930c.clear();
        String str = (String) hashMap.get("t");
        if (TextUtils.isEmpty(str)) {
            mo6887p().mo6805a((Map<String, String>) hashMap, "Missing hit type parameter");
            return;
        }
        String str2 = (String) hashMap.get("tid");
        if (TextUtils.isEmpty(str2)) {
            mo6887p().mo6805a((Map<String, String>) hashMap, "Missing tracking id parameter");
            return;
        }
        boolean b = mo6931b();
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || "pageview".equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int parseInt = Integer.parseInt(this.f3929b.get("&a")) + 1;
                if (parseInt >= Integer.MAX_VALUE) {
                    parseInt = 1;
                }
                this.f3929b.put("&a", Integer.toString(parseInt));
            }
        }
        mo6889r().mo7018a((Runnable) new C0590u(this, hashMap, b, str, a, e, a2, str2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo6931b() {
        return this.f3928a;
    }
}
