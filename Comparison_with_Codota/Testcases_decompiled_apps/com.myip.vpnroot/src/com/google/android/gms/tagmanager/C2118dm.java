package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1026d;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* renamed from: com.google.android.gms.tagmanager.dm */
class C2118dm {
    /* renamed from: a */
    private static C2047bz<C1026d.C1027a> m7151a(C2047bz<C1026d.C1027a> bzVar) {
        try {
            return new C2047bz<>(C2114di.m7124u(m7154db(C2114di.m7106j(bzVar.getObject()))), bzVar.mo11613oE());
        } catch (UnsupportedEncodingException e) {
            C2028bh.m6820b("Escape URI: unsupported encoding", e);
            return bzVar;
        }
    }

    /* renamed from: a */
    private static C2047bz<C1026d.C1027a> m7152a(C2047bz<C1026d.C1027a> bzVar, int i) {
        if (!m7155q(bzVar.getObject())) {
            C2028bh.m6816T("Escaping can only be applied to strings.");
            return bzVar;
        }
        switch (i) {
            case 12:
                return m7151a(bzVar);
            default:
                C2028bh.m6816T("Unsupported Value Escaping: " + i);
                return bzVar;
        }
    }

    /* renamed from: a */
    static C2047bz<C1026d.C1027a> m7153a(C2047bz<C1026d.C1027a> bzVar, int... iArr) {
        for (int a : iArr) {
            bzVar = m7152a(bzVar, a);
        }
        return bzVar;
    }

    /* renamed from: db */
    static String m7154db(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    /* renamed from: q */
    private static boolean m7155q(C1026d.C1027a aVar) {
        return C2114di.m7111o(aVar) instanceof String;
    }
}
