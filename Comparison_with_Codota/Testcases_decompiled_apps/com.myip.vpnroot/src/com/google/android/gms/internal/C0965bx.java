package com.google.android.gms.internal;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

@C1130ez
/* renamed from: com.google.android.gms.internal.bx */
public final class C0965bx {

    /* renamed from: pA */
    public static final C0974by f2942pA = new C0974by() {
        /* renamed from: a */
        public void mo7942a(C1232gv gvVar, Map<String, String> map) {
        }
    };

    /* renamed from: pB */
    public static final C0974by f2943pB = new C0974by() {
        /* renamed from: a */
        public void mo7942a(C1232gv gvVar, Map<String, String> map) {
            String str = map.get("urls");
            if (TextUtils.isEmpty(str)) {
                C1229gs.m4679W("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            HashMap hashMap = new HashMap();
            PackageManager packageManager = gvVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
            }
            gvVar.mo8622a("openableURLs", (Map<String, ?>) hashMap);
        }
    };

    /* renamed from: pC */
    public static final C0974by f2944pC = new C0974by() {
        /* renamed from: a */
        public void mo7942a(C1232gv gvVar, Map<String, String> map) {
            Uri uri;
            String str = map.get("u");
            if (str == null) {
                C1229gs.m4679W("URL missing from click GMSG.");
                return;
            }
            Uri parse = Uri.parse(str);
            try {
                C1391k dx = gvVar.mo8633dx();
                if (dx != null && dx.mo9091b(parse)) {
                    uri = dx.mo9088a(parse, gvVar.getContext());
                    new C1227gq(gvVar.getContext(), gvVar.mo8634dy().f3777wD, uri.toString()).start();
                }
            } catch (C1467l e) {
                C1229gs.m4679W("Unable to append parameter to URL: " + str);
            }
            uri = parse;
            new C1227gq(gvVar.getContext(), gvVar.mo8634dy().f3777wD, uri.toString()).start();
        }
    };

    /* renamed from: pD */
    public static final C0974by f2945pD = new C0974by() {
        /* renamed from: a */
        public void mo7942a(C1232gv gvVar, Map<String, String> map) {
            C1056dk du = gvVar.mo8630du();
            if (du == null) {
                C1229gs.m4679W("A GMSG tried to close something that wasn't an overlay.");
            } else {
                du.close();
            }
        }
    };

    /* renamed from: pE */
    public static final C0974by f2946pE = new C0974by() {
        /* renamed from: a */
        public void mo7942a(C1232gv gvVar, Map<String, String> map) {
            gvVar.mo8638o("1".equals(map.get("custom_close")));
        }
    };

    /* renamed from: pF */
    public static final C0974by f2947pF = new C0974by() {
        /* renamed from: a */
        public void mo7942a(C1232gv gvVar, Map<String, String> map) {
            String str = map.get("u");
            if (str == null) {
                C1229gs.m4679W("URL missing from httpTrack GMSG.");
            } else {
                new C1227gq(gvVar.getContext(), gvVar.mo8634dy().f3777wD, str).start();
            }
        }
    };

    /* renamed from: pG */
    public static final C0974by f2948pG = new C0974by() {
        /* renamed from: a */
        public void mo7942a(C1232gv gvVar, Map<String, String> map) {
            C1229gs.m4677U("Received log message: " + map.get("string"));
        }
    };

    /* renamed from: pH */
    public static final C0974by f2949pH = new C0974by() {
        /* renamed from: a */
        public void mo7942a(C1232gv gvVar, Map<String, String> map) {
            String str = map.get("tx");
            String str2 = map.get("ty");
            String str3 = map.get("td");
            try {
                int parseInt = Integer.parseInt(str);
                int parseInt2 = Integer.parseInt(str2);
                int parseInt3 = Integer.parseInt(str3);
                C1391k dx = gvVar.mo8633dx();
                if (dx != null) {
                    dx.mo9092z().mo8542a(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                C1229gs.m4679W("Could not parse touch parameters from gmsg.");
            }
        }
    };

    /* renamed from: pI */
    public static final C0974by f2950pI = new C0991ce();
}
