package com.google.ads;

import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.C0265m;
import com.google.ads.internal.ActivationOverlay;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0247d;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0284b;
import com.google.ads.util.C0293g;
import com.google.ads.util.C0304i;
import java.util.HashMap;

/* renamed from: com.google.ads.x */
public class C0312x implements C0273o {
    /* renamed from: a */
    public void mo3325a(C0247d dVar, HashMap<String, String> hashMap, WebView webView) {
        boolean z;
        C0272n i = dVar.mo3550i();
        C0265m.C0266a a = i.f657d.mo3725a().f616b.mo3725a();
        m521c(hashMap, "as_domains", a.f618a);
        m521c(hashMap, "bad_ad_report_path", a.f625h);
        m519a(hashMap, "min_hwa_banner", a.f619b);
        m519a(hashMap, "min_hwa_activation_overlay", a.f620c);
        m519a(hashMap, "min_hwa_overlay", a.f621d);
        m521c(hashMap, "mraid_banner_path", a.f622e);
        m521c(hashMap, "mraid_expanded_banner_path", a.f623f);
        m521c(hashMap, "mraid_interstitial_path", a.f624g);
        m520b(hashMap, "ac_max_size", a.f626i);
        m520b(hashMap, "ac_padding", a.f627j);
        m520b(hashMap, "ac_total_quota", a.f628k);
        m520b(hashMap, "db_total_quota", a.f629l);
        m520b(hashMap, "db_quota_per_origin", a.f630m);
        m520b(hashMap, "db_quota_step_size", a.f631n);
        AdWebView l = dVar.mo3553l();
        if (AdUtil.f690a >= 11) {
            C0293g.m504a(l.getSettings(), i);
            C0293g.m504a(webView.getSettings(), i);
        }
        if (!i.f660g.mo3725a().mo3609a()) {
            boolean k = l.mo3461k();
            boolean z2 = AdUtil.f690a < a.f619b.mo3726a().intValue();
            if (!z2 && k) {
                C0284b.m480a("Re-enabling hardware acceleration for a banner after reading constants.");
                l.mo3458h();
            } else if (z2 && !k) {
                C0284b.m480a("Disabling hardware acceleration for a banner after reading constants.");
                l.mo3457g();
            }
        }
        ActivationOverlay a2 = i.f658e.mo3725a();
        if (!i.f660g.mo3725a().mo3611b() && a2 != null) {
            boolean k2 = a2.mo3461k();
            if (AdUtil.f690a < a.f620c.mo3726a().intValue()) {
                z = true;
            } else {
                z = false;
            }
            if (!z && k2) {
                C0284b.m480a("Re-enabling hardware acceleration for an activation overlay after reading constants.");
                a2.mo3458h();
            } else if (z && !k2) {
                C0284b.m480a("Disabling hardware acceleration for an activation overlay after reading constants.");
                a2.mo3457g();
            }
        }
        String a3 = a.f618a.mo3726a();
        C0192al a4 = i.f672s.mo3726a();
        if (a4 != null && !TextUtils.isEmpty(a3)) {
            a4.mo3343a(a3);
        }
        a.f632o.mo3727a(true);
    }

    /* renamed from: a */
    private void m519a(HashMap<String, String> hashMap, String str, C0304i.C0308c<Integer> cVar) {
        try {
            String str2 = hashMap.get(str);
            if (!TextUtils.isEmpty(str2)) {
                cVar.mo3727a(Integer.valueOf(str2));
            }
        } catch (NumberFormatException e) {
            C0284b.m480a("Could not parse \"" + str + "\" constant.");
        }
    }

    /* renamed from: b */
    private void m520b(HashMap<String, String> hashMap, String str, C0304i.C0308c<Long> cVar) {
        try {
            String str2 = hashMap.get(str);
            if (!TextUtils.isEmpty(str2)) {
                cVar.mo3727a(Long.valueOf(str2));
            }
        } catch (NumberFormatException e) {
            C0284b.m480a("Could not parse \"" + str + "\" constant.");
        }
    }

    /* renamed from: c */
    private void m521c(HashMap<String, String> hashMap, String str, C0304i.C0308c<String> cVar) {
        String str2 = hashMap.get(str);
        if (!TextUtils.isEmpty(str2)) {
            cVar.mo3727a(str2);
        }
    }
}
