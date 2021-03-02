package com.google.android.gms.internal;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ah */
public final class C0213ah {

    /* renamed from: eA */
    public static final C0221ai f563eA = new C0221ai() {
        /* renamed from: a */
        public void mo4037a(C0347cq cqVar, Map<String, String> map) {
            Uri uri;
            String str = map.get("u");
            if (str == null) {
                C0344cn.m737q("URL missing from click GMSG.");
                return;
            }
            Uri parse = Uri.parse(str);
            try {
                C0599h ax = cqVar.mo4213ax();
                if (ax != null && ax.mo5303a(parse)) {
                    uri = ax.mo5301a(parse, cqVar.getContext());
                    new C0342cl(cqVar.getContext(), cqVar.mo4214ay().f1014hP, uri.toString()).start();
                }
            } catch (C0600i e) {
                C0344cn.m737q("Unable to append parameter to URL: " + str);
            }
            uri = parse;
            new C0342cl(cqVar.getContext(), cqVar.mo4214ay().f1014hP, uri.toString()).start();
        }
    };

    /* renamed from: eB */
    public static final C0221ai f564eB = new C0221ai() {
        /* renamed from: a */
        public void mo4037a(C0347cq cqVar, Map<String, String> map) {
            C0280bf au = cqVar.mo4210au();
            if (au == null) {
                C0344cn.m737q("A GMSG tried to close something that wasn't an overlay.");
            } else {
                au.close();
            }
        }
    };

    /* renamed from: eC */
    public static final C0221ai f565eC = new C0221ai() {
        /* renamed from: a */
        public void mo4037a(C0347cq cqVar, Map<String, String> map) {
            C0280bf au = cqVar.mo4210au();
            if (au == null) {
                C0344cn.m737q("A GMSG tried to use a custom close button on something that wasn't an overlay.");
            } else {
                au.mo4104d("1".equals(map.get("custom_close")));
            }
        }
    };

    /* renamed from: eD */
    public static final C0221ai f566eD = new C0221ai() {
        /* renamed from: a */
        public void mo4037a(C0347cq cqVar, Map<String, String> map) {
            String str = map.get("u");
            if (str == null) {
                C0344cn.m737q("URL missing from httpTrack GMSG.");
            } else {
                new C0342cl(cqVar.getContext(), cqVar.mo4214ay().f1014hP, str).start();
            }
        }
    };

    /* renamed from: eE */
    public static final C0221ai f567eE = new C0221ai() {
        /* renamed from: a */
        public void mo4037a(C0347cq cqVar, Map<String, String> map) {
            C0344cn.m735o("Received log message: " + map.get("string"));
        }
    };

    /* renamed from: eF */
    public static final C0221ai f568eF = new C0222aj();

    /* renamed from: eG */
    public static final C0221ai f569eG = new C0221ai() {
        /* renamed from: a */
        public void mo4037a(C0347cq cqVar, Map<String, String> map) {
            String str = map.get("tx");
            String str2 = map.get("ty");
            String str3 = map.get("td");
            try {
                int parseInt = Integer.parseInt(str);
                int parseInt2 = Integer.parseInt(str2);
                int parseInt3 = Integer.parseInt(str3);
                C0599h ax = cqVar.mo4213ax();
                if (ax != null) {
                    ax.mo5304g().mo4317a(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                C0344cn.m737q("Could not parse touch parameters from gmsg.");
            }
        }
    };

    /* renamed from: eH */
    public static final C0221ai f570eH = new C0223ak();

    /* renamed from: ez */
    public static final C0221ai f571ez = new C0221ai() {
        /* renamed from: a */
        public void mo4037a(C0347cq cqVar, Map<String, String> map) {
            String str = map.get("urls");
            if (str == null) {
                C0344cn.m737q("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            HashMap hashMap = new HashMap();
            PackageManager packageManager = cqVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
            }
            cqVar.mo4207a("openableURLs", (Map<String, ?>) hashMap);
        }
    };
}
