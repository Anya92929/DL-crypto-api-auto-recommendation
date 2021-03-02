package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.C0515ab;
import com.google.android.gms.analytics.internal.C0516ac;
import com.google.android.gms.analytics.internal.C0519af;
import com.google.android.gms.analytics.internal.C0556d;
import com.google.android.gms.analytics.internal.C0570r;
import com.google.android.gms.analytics.internal.C0578z;
import com.google.android.gms.analytics.p016a.C0502a;
import com.google.android.gms.analytics.p016a.C0503b;
import com.google.android.gms.analytics.p016a.C0504c;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.p018c.C0624am;
import com.google.android.gms.p018c.C0635ax;
import com.google.android.gms.p018c.C0636ay;
import com.google.android.gms.p018c.C0637az;
import com.google.android.gms.p018c.C0639ba;
import com.google.android.gms.p018c.C0640bb;
import com.google.android.gms.p018c.C0641bc;
import com.google.android.gms.p018c.C0642bd;
import com.google.android.gms.p018c.C0643be;
import com.google.android.gms.p018c.C0644bf;
import com.google.android.gms.p018c.C0645bg;
import com.google.android.gms.p018c.C0665g;
import com.google.android.gms.p018c.C0666h;
import com.google.android.gms.p018c.C0667i;
import com.google.android.gms.p018c.C0668j;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.x */
public class C0593x extends C0578z implements C0635ax {

    /* renamed from: a */
    private static DecimalFormat f3946a;

    /* renamed from: b */
    private final C0516ac f3947b;

    /* renamed from: c */
    private final String f3948c;

    /* renamed from: d */
    private final Uri f3949d;

    /* renamed from: e */
    private final boolean f3950e;

    /* renamed from: f */
    private final boolean f3951f;

    public C0593x(C0516ac acVar, String str) {
        this(acVar, str, true, false);
    }

    public C0593x(C0516ac acVar, String str, boolean z, boolean z2) {
        super(acVar);
        C1009bf.m4530a(str);
        this.f3947b = acVar;
        this.f3948c = str;
        this.f3950e = z;
        this.f3951f = z2;
        this.f3949d = m3474a(this.f3948c);
    }

    /* renamed from: a */
    static Uri m3474a(String str) {
        C1009bf.m4530a(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    /* renamed from: a */
    static String m3475a(double d) {
        if (f3946a == null) {
            f3946a = new DecimalFormat("0.######");
        }
        return f3946a.format(d);
    }

    /* renamed from: a */
    private static String m3476a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str;
        } else if (obj instanceof Double) {
            Double d = (Double) obj;
            if (d.doubleValue() != 0.0d) {
                return m3475a(d.doubleValue());
            }
            return null;
        } else if (!(obj instanceof Boolean)) {
            return String.valueOf(obj);
        } else {
            if (obj != Boolean.FALSE) {
                return "1";
            }
            return null;
        }
    }

    /* renamed from: a */
    private static String m3477a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append((String) next.getValue());
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static void m3478a(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, m3475a(d));
        }
    }

    /* renamed from: a */
    private static void m3479a(Map<String, String> map, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            map.put(str, i + "x" + i2);
        }
    }

    /* renamed from: a */
    private static void m3480a(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    /* renamed from: a */
    private static void m3481a(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    /* renamed from: b */
    public static Map<String, String> m3482b(C0624am amVar) {
        HashMap hashMap = new HashMap();
        C0667i iVar = (C0667i) amVar.mo6995a(C0667i.class);
        if (iVar != null) {
            for (Map.Entry next : iVar.mo7211a().entrySet()) {
                String a = m3476a(next.getValue());
                if (a != null) {
                    hashMap.put(next.getKey(), a);
                }
            }
        }
        C0668j jVar = (C0668j) amVar.mo6995a(C0668j.class);
        if (jVar != null) {
            m3480a((Map<String, String>) hashMap, "t", jVar.mo7215a());
            m3480a((Map<String, String>) hashMap, "cid", jVar.mo7220b());
            m3480a((Map<String, String>) hashMap, "uid", jVar.mo7223c());
            m3480a((Map<String, String>) hashMap, "sc", jVar.mo7229f());
            m3478a((Map<String, String>) hashMap, "sf", jVar.mo7231h());
            m3481a((Map<String, String>) hashMap, "ni", jVar.mo7230g());
            m3480a((Map<String, String>) hashMap, "adid", jVar.mo7225d());
            m3481a((Map<String, String>) hashMap, "ate", jVar.mo7228e());
        }
        C0643be beVar = (C0643be) amVar.mo6995a(C0643be.class);
        if (beVar != null) {
            m3480a((Map<String, String>) hashMap, "cd", beVar.mo7101b());
            m3478a((Map<String, String>) hashMap, "a", (double) beVar.mo7105c());
            m3480a((Map<String, String>) hashMap, "dr", beVar.mo7107d());
        }
        C0641bc bcVar = (C0641bc) amVar.mo6995a(C0641bc.class);
        if (bcVar != null) {
            m3480a((Map<String, String>) hashMap, "ec", bcVar.mo7081a());
            m3480a((Map<String, String>) hashMap, "ea", bcVar.mo7085b());
            m3480a((Map<String, String>) hashMap, "el", bcVar.mo7087c());
            m3478a((Map<String, String>) hashMap, "ev", (double) bcVar.mo7089d());
        }
        C0637az azVar = (C0637az) amVar.mo6995a(C0637az.class);
        if (azVar != null) {
            m3480a((Map<String, String>) hashMap, "cn", azVar.mo7038a());
            m3480a((Map<String, String>) hashMap, "cs", azVar.mo7041b());
            m3480a((Map<String, String>) hashMap, "cm", azVar.mo7043c());
            m3480a((Map<String, String>) hashMap, "ck", azVar.mo7045d());
            m3480a((Map<String, String>) hashMap, "cc", azVar.mo7047e());
            m3480a((Map<String, String>) hashMap, "ci", azVar.mo7049f());
            m3480a((Map<String, String>) hashMap, "anid", azVar.mo7051g());
            m3480a((Map<String, String>) hashMap, "gclid", azVar.mo7053h());
            m3480a((Map<String, String>) hashMap, "dclid", azVar.mo7055i());
            m3480a((Map<String, String>) hashMap, "aclid", azVar.mo7057j());
        }
        C0642bd bdVar = (C0642bd) amVar.mo6995a(C0642bd.class);
        if (bdVar != null) {
            m3480a((Map<String, String>) hashMap, "exd", bdVar.mo7091a());
            m3481a((Map<String, String>) hashMap, "exf", bdVar.mo7095b());
        }
        C0644bf bfVar = (C0644bf) amVar.mo6995a(C0644bf.class);
        if (bfVar != null) {
            m3480a((Map<String, String>) hashMap, "sn", bfVar.mo7109a());
            m3480a((Map<String, String>) hashMap, "sa", bfVar.mo7112b());
            m3480a((Map<String, String>) hashMap, "st", bfVar.mo7114c());
        }
        C0645bg bgVar = (C0645bg) amVar.mo6995a(C0645bg.class);
        if (bgVar != null) {
            m3480a((Map<String, String>) hashMap, "utv", bgVar.mo7117a());
            m3478a((Map<String, String>) hashMap, "utt", (double) bgVar.mo7121b());
            m3480a((Map<String, String>) hashMap, "utc", bgVar.mo7123c());
            m3480a((Map<String, String>) hashMap, "utl", bgVar.mo7125d());
        }
        C0665g gVar = (C0665g) amVar.mo6995a(C0665g.class);
        if (gVar != null) {
            for (Map.Entry next2 : gVar.mo7205a().entrySet()) {
                String b = C0594y.m3487b(((Integer) next2.getKey()).intValue());
                if (!TextUtils.isEmpty(b)) {
                    hashMap.put(b, next2.getValue());
                }
            }
        }
        C0666h hVar = (C0666h) amVar.mo6995a(C0666h.class);
        if (hVar != null) {
            for (Map.Entry next3 : hVar.mo7208a().entrySet()) {
                String c = C0594y.m3488c(((Integer) next3.getKey()).intValue());
                if (!TextUtils.isEmpty(c)) {
                    hashMap.put(c, m3475a(((Double) next3.getValue()).doubleValue()));
                }
            }
        }
        C0640bb bbVar = (C0640bb) amVar.mo6995a(C0640bb.class);
        if (bbVar != null) {
            C0503b a2 = bbVar.mo7074a();
            if (a2 != null) {
                for (Map.Entry next4 : a2.mo6565a().entrySet()) {
                    if (((String) next4.getKey()).startsWith("&")) {
                        hashMap.put(((String) next4.getKey()).substring(1), next4.getValue());
                    } else {
                        hashMap.put(next4.getKey(), next4.getValue());
                    }
                }
            }
            int i = 1;
            for (C0504c a3 : bbVar.mo7079d()) {
                hashMap.putAll(a3.mo6568a(C0594y.m3492g(i)));
                i++;
            }
            int i2 = 1;
            for (C0502a b2 : bbVar.mo7077b()) {
                hashMap.putAll(b2.mo6563b(C0594y.m3490e(i2)));
                i2++;
            }
            int i3 = 1;
            for (Map.Entry next5 : bbVar.mo7078c().entrySet()) {
                String j = C0594y.m3495j(i3);
                int i4 = 1;
                for (C0502a b3 : (List) next5.getValue()) {
                    hashMap.putAll(b3.mo6563b(j + C0594y.m3493h(i4)));
                    i4++;
                }
                if (!TextUtils.isEmpty((CharSequence) next5.getKey())) {
                    hashMap.put(j + "nm", next5.getKey());
                }
                i3++;
            }
        }
        C0639ba baVar = (C0639ba) amVar.mo6995a(C0639ba.class);
        if (baVar != null) {
            m3480a((Map<String, String>) hashMap, "ul", baVar.mo7072f());
            m3478a((Map<String, String>) hashMap, "sd", (double) baVar.mo7060a());
            m3479a(hashMap, "sr", baVar.mo7064b(), baVar.mo7066c());
            m3479a(hashMap, "vp", baVar.mo7068d(), baVar.mo7070e());
        }
        C0636ay ayVar = (C0636ay) amVar.mo6995a(C0636ay.class);
        if (ayVar != null) {
            m3480a((Map<String, String>) hashMap, "an", ayVar.mo7028a());
            m3480a((Map<String, String>) hashMap, "aid", ayVar.mo7033c());
            m3480a((Map<String, String>) hashMap, "aiid", ayVar.mo7035d());
            m3480a((Map<String, String>) hashMap, "av", ayVar.mo7031b());
        }
        return hashMap;
    }

    /* renamed from: a */
    public Uri mo6940a() {
        return this.f3949d;
    }

    /* renamed from: a */
    public void mo6941a(C0624am amVar) {
        C1009bf.m4528a(amVar);
        C1009bf.m4537b(amVar.mo7003f(), "Can't deliver not submitted measurement");
        C1009bf.m4538c("deliver should be called on worker thread");
        C0624am a = amVar.mo6994a();
        C0668j jVar = (C0668j) a.mo6998b(C0668j.class);
        if (TextUtils.isEmpty(jVar.mo7215a())) {
            mo6887p().mo6805a(m3482b(a), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(jVar.mo7220b())) {
            mo6887p().mo6805a(m3482b(a), "Ignoring measurement without client id");
        } else if (!this.f3947b.mo6609k().mo6908f()) {
            double h = jVar.mo7231h();
            if (C0570r.m3332a(h, jVar.mo7220b())) {
                mo6870b("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(h));
                return;
            }
            Map<String, String> b = m3482b(a);
            b.put("v", "1");
            b.put("_v", C0515ab.f3701b);
            b.put("tid", this.f3948c);
            if (this.f3947b.mo6609k().mo6907e()) {
                mo6874c("Dry run is enabled. GoogleAnalytics would have sent", m3477a(b));
                return;
            }
            HashMap hashMap = new HashMap();
            C0570r.m3329a((Map<String, String>) hashMap, "uid", jVar.mo7223c());
            C0636ay ayVar = (C0636ay) amVar.mo6995a(C0636ay.class);
            if (ayVar != null) {
                C0570r.m3329a((Map<String, String>) hashMap, "an", ayVar.mo7028a());
                C0570r.m3329a((Map<String, String>) hashMap, "aid", ayVar.mo7033c());
                C0570r.m3329a((Map<String, String>) hashMap, "av", ayVar.mo7031b());
                C0570r.m3329a((Map<String, String>) hashMap, "aiid", ayVar.mo7035d());
            }
            b.put("_s", String.valueOf(mo6891t().mo6846a(new C0519af(0, jVar.mo7220b(), this.f3948c, !TextUtils.isEmpty(jVar.mo7225d()), 0, hashMap))));
            mo6891t().mo6848a(new C0556d(mo6887p(), b, amVar.mo7001d(), true));
        }
    }
}
