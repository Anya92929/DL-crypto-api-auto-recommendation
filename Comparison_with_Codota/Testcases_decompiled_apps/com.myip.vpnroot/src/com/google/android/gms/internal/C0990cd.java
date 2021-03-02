package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@C1130ez
/* renamed from: com.google.android.gms.internal.cd */
public final class C0990cd implements C0974by {

    /* renamed from: pL */
    private final C0975bz f3012pL;

    /* renamed from: pM */
    private final C1741v f3013pM;

    public C0990cd(C0975bz bzVar, C1741v vVar) {
        this.f3012pL = bzVar;
        this.f3013pM = vVar;
    }

    /* renamed from: b */
    private static boolean m4111b(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    /* renamed from: c */
    private static int m4112c(Map<String, String> map) {
        String str = map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return C1213gj.m4634dn();
            }
            if ("l".equalsIgnoreCase(str)) {
                return C1213gj.m4633dm();
            }
        }
        return -1;
    }

    /* renamed from: a */
    public void mo7942a(C1232gv gvVar, Map<String, String> map) {
        String str = map.get("a");
        if (str == null) {
            C1229gs.m4679W("Action missing from an open GMSG.");
        } else if (this.f3013pM == null || this.f3013pM.mo10154av()) {
            C1234gw dv = gvVar.mo8631dv();
            if ("expand".equalsIgnoreCase(str)) {
                if (gvVar.mo8635dz()) {
                    C1229gs.m4679W("Cannot expand WebView that is already expanded.");
                } else {
                    dv.mo8653a(m4111b(map), m4112c(map));
                }
            } else if ("webapp".equalsIgnoreCase(str)) {
                String str2 = map.get("u");
                if (str2 != null) {
                    dv.mo8654a(m4111b(map), m4112c(map), str2);
                } else {
                    dv.mo8655a(m4111b(map), m4112c(map), map.get("html"), map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                String str3 = map.get("product_id");
                String str4 = map.get("report_urls");
                if (this.f3012pL == null) {
                    return;
                }
                if (str4 == null || str4.isEmpty()) {
                    this.f3012pL.mo8165a(str3, new ArrayList());
                    return;
                }
                this.f3012pL.mo8165a(str3, new ArrayList(Arrays.asList(str4.split(" "))));
            } else {
                dv.mo8647a(new C1055dj(map.get("i"), map.get("u"), map.get("m"), map.get("p"), map.get("c"), map.get("f"), map.get("e")));
            }
        } else {
            this.f3013pM.mo10155d(map.get("u"));
        }
    }
}
