package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.C1009bf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.internal.d */
public class C0556d {

    /* renamed from: a */
    private final Map<String, String> f3853a;

    /* renamed from: b */
    private final List<Command> f3854b;

    /* renamed from: c */
    private final long f3855c;

    /* renamed from: d */
    private final long f3856d;

    /* renamed from: e */
    private final int f3857e;

    /* renamed from: f */
    private final boolean f3858f;

    /* renamed from: g */
    private final String f3859g;

    public C0556d(C0578z zVar, Map<String, String> map, long j, boolean z) {
        this(zVar, map, j, z, 0, 0, (List<Command>) null);
    }

    public C0556d(C0578z zVar, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(zVar, map, j, z, j2, i, (List<Command>) null);
    }

    public C0556d(C0578z zVar, Map<String, String> map, long j, boolean z, long j2, int i, List<Command> list) {
        String a;
        String a2;
        C1009bf.m4528a(zVar);
        C1009bf.m4528a(map);
        this.f3856d = j;
        this.f3858f = z;
        this.f3855c = j2;
        this.f3857e = i;
        this.f3854b = list != null ? list : Collections.EMPTY_LIST;
        this.f3859g = m3238a(list);
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            if (m3239a(next.getKey()) && (a2 = m3236a(zVar, next.getKey())) != null) {
                hashMap.put(a2, m3240b(zVar, next.getValue()));
            }
        }
        for (Map.Entry next2 : map.entrySet()) {
            if (!m3239a(next2.getKey()) && (a = m3236a(zVar, next2.getKey())) != null) {
                hashMap.put(a, m3240b(zVar, next2.getValue()));
            }
        }
        if (!TextUtils.isEmpty(this.f3859g)) {
            C0570r.m3329a((Map<String, String>) hashMap, "_v", this.f3859g);
            if (this.f3859g.equals("ma4.0.0") || this.f3859g.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.f3853a = Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: a */
    public static C0556d m3235a(C0578z zVar, C0556d dVar, Map<String, String> map) {
        return new C0556d(zVar, map, dVar.mo6790d(), dVar.mo6792f(), dVar.mo6789c(), dVar.mo6787a(), dVar.mo6791e());
    }

    /* renamed from: a */
    private static String m3236a(C0578z zVar, Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > 256) {
            obj2 = obj2.substring(0, 256);
            zVar.mo6875c("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        if (TextUtils.isEmpty(obj2)) {
            return null;
        }
        return obj2;
    }

    /* renamed from: a */
    private String m3237a(String str, String str2) {
        C1009bf.m4530a(str);
        C1009bf.m4537b(!str.startsWith("&"), "Short param name required");
        String str3 = this.f3853a.get(str);
        return str3 != null ? str3 : str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m3238a(java.util.List<com.google.android.gms.analytics.internal.Command> r5) {
        /*
            r1 = 0
            if (r5 == 0) goto L_0x002c
            java.util.Iterator r2 = r5.iterator()
        L_0x0007:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x002c
            java.lang.Object r0 = r2.next()
            com.google.android.gms.analytics.internal.Command r0 = (com.google.android.gms.analytics.internal.Command) r0
            java.lang.String r3 = "appendVersion"
            java.lang.String r4 = r0.mo6587a()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0007
            java.lang.String r0 = r0.mo6588b()
        L_0x0023:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x002a
        L_0x0029:
            return r1
        L_0x002a:
            r1 = r0
            goto L_0x0029
        L_0x002c:
            r0 = r1
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.C0556d.m3238a(java.util.List):java.lang.String");
    }

    /* renamed from: a */
    private static boolean m3239a(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().startsWith("&");
    }

    /* renamed from: b */
    private static String m3240b(C0578z zVar, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length <= 8192) {
            return obj2;
        }
        String substring = obj2.substring(0, 8192);
        zVar.mo6875c("Hit param value is too long and will be trimmed", Integer.valueOf(length), substring);
        return substring;
    }

    /* renamed from: a */
    public int mo6787a() {
        return this.f3857e;
    }

    /* renamed from: b */
    public Map<String, String> mo6788b() {
        return this.f3853a;
    }

    /* renamed from: c */
    public long mo6789c() {
        return this.f3855c;
    }

    /* renamed from: d */
    public long mo6790d() {
        return this.f3856d;
    }

    /* renamed from: e */
    public List<Command> mo6791e() {
        return this.f3854b;
    }

    /* renamed from: f */
    public boolean mo6792f() {
        return this.f3858f;
    }

    /* renamed from: g */
    public long mo6793g() {
        return C0570r.m3325a(m3237a("_s", "0"));
    }

    /* renamed from: h */
    public String mo6794h() {
        return m3237a("_m", "");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ht=").append(this.f3856d);
        if (this.f3855c != 0) {
            stringBuffer.append(", dbId=").append(this.f3855c);
        }
        if (((long) this.f3857e) != 0) {
            stringBuffer.append(", appUID=").append(this.f3857e);
        }
        ArrayList<String> arrayList = new ArrayList<>(this.f3853a.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            stringBuffer.append(", ");
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append(this.f3853a.get(str));
        }
        return stringBuffer.toString();
    }
}
