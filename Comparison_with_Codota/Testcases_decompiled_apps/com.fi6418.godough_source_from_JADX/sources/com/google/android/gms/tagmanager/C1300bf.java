package com.google.android.gms.tagmanager;

import com.google.android.gms.p018c.C0661c;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* renamed from: com.google.android.gms.tagmanager.bf */
class C1300bf {
    /* renamed from: a */
    private static C1275ah<C0661c> m5367a(C1275ah<C0661c> ahVar) {
        try {
            return new C1275ah<>(C1298bd.m5357c((Object) m5370a(C1298bd.m5353a(ahVar.mo9092a()))), ahVar.mo9093b());
        } catch (UnsupportedEncodingException e) {
            C1333x.m5441a("Escape URI: unsupported encoding", e);
            return ahVar;
        }
    }

    /* renamed from: a */
    private static C1275ah<C0661c> m5368a(C1275ah<C0661c> ahVar, int i) {
        if (!m5371a(ahVar.mo9092a())) {
            C1333x.m5440a("Escaping can only be applied to strings.");
            return ahVar;
        }
        switch (i) {
            case 12:
                return m5367a(ahVar);
            default:
                C1333x.m5440a("Unsupported Value Escaping: " + i);
                return ahVar;
        }
    }

    /* renamed from: a */
    static C1275ah<C0661c> m5369a(C1275ah<C0661c> ahVar, int... iArr) {
        for (int a : iArr) {
            ahVar = m5368a(ahVar, a);
        }
        return ahVar;
    }

    /* renamed from: a */
    static String m5370a(String str) {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    /* renamed from: a */
    private static boolean m5371a(C0661c cVar) {
        return C1298bd.m5358c(cVar) instanceof String;
    }
}
