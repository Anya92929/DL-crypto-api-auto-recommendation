package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.common.internal.C1009bf;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.internal.j */
public class C0562j extends C0514aa {

    /* renamed from: a */
    private static String f3868a = "3";

    /* renamed from: b */
    private static String f3869b = "01VDIWEA?";

    /* renamed from: c */
    private static C0562j f3870c;

    public C0562j(C0516ac acVar) {
        super(acVar);
    }

    /* renamed from: b */
    public static C0562j m3264b() {
        return f3870c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo6802a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object l = obj instanceof Integer ? new Long((long) ((Integer) obj).intValue()) : obj;
        if (!(l instanceof Long)) {
            return l instanceof Boolean ? String.valueOf(l) : l instanceof Throwable ? l.getClass().getCanonicalName() : "-";
        }
        if (Math.abs(((Long) l).longValue()) < 100) {
            return String.valueOf(l);
        }
        String str = String.valueOf(l).charAt(0) == '-' ? "-" : "";
        String valueOf = String.valueOf(Math.abs(((Long) l).longValue()));
        return str + Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1))) + "..." + str + Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6598a() {
        synchronized (C0562j.class) {
            f3870c = this;
        }
    }

    /* renamed from: a */
    public void mo6803a(int i, String str, Object obj, Object obj2, Object obj3) {
        String a = C0551bk.f3819c.mo6775a();
        if (Log.isLoggable(a, i)) {
            Log.println(i, a, m3369c(str, obj, obj2, obj3));
        }
        if (i >= 5) {
            mo6806b(i, str, obj, obj2, obj3);
        }
    }

    /* renamed from: a */
    public void mo6804a(C0556d dVar, String str) {
        if (str == null) {
            str = "no reason provided";
        }
        mo6877d("Discarding hit. " + str, dVar != null ? dVar.toString() : "no hit data");
    }

    /* renamed from: a */
    public void mo6805a(Map<String, String> map, String str) {
        String str2;
        if (str == null) {
            str = "no reason provided";
        }
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry next : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append((String) next.getKey());
                sb.append('=');
                sb.append((String) next.getValue());
            }
            str2 = sb.toString();
        } else {
            str2 = "no hit data";
        }
        mo6877d("Discarding hit. " + str, str2);
    }

    /* renamed from: b */
    public synchronized void mo6806b(int i, String str, Object obj, Object obj2, Object obj3) {
        int i2 = 0;
        synchronized (this) {
            C1009bf.m4528a(str);
            if (i >= 0) {
                i2 = i;
            }
            String str2 = f3868a + f3869b.charAt(i2 >= f3869b.length() ? f3869b.length() - 1 : i2) + (mo6888q().mo6732b() ? mo6888q().mo6731a() ? 'P' : 'C' : mo6888q().mo6731a() ? 'p' : 'c') + C0515ab.f3700a + ":" + m3369c(str, mo6802a(obj), mo6802a(obj2), mo6802a(obj3));
            if (str2.length() > 1024) {
                str2 = str2.substring(0, 1024);
            }
            C0566n n = mo6882k().mo6612n();
            if (n != null) {
                n.mo6829g().mo6831a(str2);
            }
        }
    }
}
