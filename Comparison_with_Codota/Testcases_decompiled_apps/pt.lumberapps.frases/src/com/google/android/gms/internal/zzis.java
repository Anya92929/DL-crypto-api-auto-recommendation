package com.google.android.gms.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.zzu;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzin
public final class zzis {

    /* renamed from: A */
    private String f6444A;

    /* renamed from: B */
    private List f6445B;

    /* renamed from: C */
    private String f6446C;

    /* renamed from: D */
    private boolean f6447D;

    /* renamed from: E */
    private String f6448E;

    /* renamed from: F */
    private final AdRequestInfoParcel f6449F;

    /* renamed from: a */
    private String f6450a;

    /* renamed from: b */
    private String f6451b;

    /* renamed from: c */
    private String f6452c;

    /* renamed from: d */
    private List f6453d;

    /* renamed from: e */
    private String f6454e;

    /* renamed from: f */
    private String f6455f;

    /* renamed from: g */
    private List f6456g;

    /* renamed from: h */
    private long f6457h = -1;

    /* renamed from: i */
    private boolean f6458i = false;

    /* renamed from: j */
    private final long f6459j = -1;

    /* renamed from: k */
    private List f6460k;

    /* renamed from: l */
    private long f6461l = -1;

    /* renamed from: m */
    private int f6462m = -1;

    /* renamed from: n */
    private boolean f6463n = false;

    /* renamed from: o */
    private boolean f6464o = false;

    /* renamed from: p */
    private boolean f6465p = false;

    /* renamed from: q */
    private boolean f6466q = true;

    /* renamed from: r */
    private String f6467r = "";

    /* renamed from: s */
    private boolean f6468s = false;

    /* renamed from: t */
    private boolean f6469t = false;

    /* renamed from: u */
    private RewardItemParcel f6470u;

    /* renamed from: v */
    private List f6471v;

    /* renamed from: w */
    private List f6472w;

    /* renamed from: x */
    private boolean f6473x = false;

    /* renamed from: y */
    private AutoClickProtectionConfigurationParcel f6474y;

    /* renamed from: z */
    private boolean f6475z = false;

    public zzis(AdRequestInfoParcel adRequestInfoParcel) {
        this.f6449F = adRequestInfoParcel;
    }

    /* renamed from: A */
    private void m7230A(Map map) {
        this.f6444A = m7232a(map, "Set-Cookie");
    }

    /* renamed from: B */
    private void m7231B(Map map) {
        this.f6446C = m7232a(map, "X-Afma-Safe-Browsing");
    }

    /* renamed from: a */
    static String m7232a(Map map, String str) {
        List list = (List) map.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }

    /* renamed from: a */
    private void m7233a(Map map) {
        this.f6450a = m7232a(map, "X-Afma-Ad-Size");
    }

    /* renamed from: b */
    static long m7234b(Map map, String str) {
        List list = (List) map.get(str);
        if (list != null && !list.isEmpty()) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                zzkd.zzcx(new StringBuilder(String.valueOf(str).length() + 36 + String.valueOf(str2).length()).append("Could not parse float from ").append(str).append(" header: ").append(str2).toString());
            }
        }
        return -1;
    }

    /* renamed from: b */
    private void m7235b(Map map) {
        this.f6448E = m7232a(map, "X-Afma-Ad-Slot-Size");
    }

    /* renamed from: c */
    static List m7236c(Map map, String str) {
        String str2;
        List list = (List) map.get(str);
        if (list == null || list.isEmpty() || (str2 = (String) list.get(0)) == null) {
            return null;
        }
        return Arrays.asList(str2.trim().split("\\s+"));
    }

    /* renamed from: c */
    private void m7237c(Map map) {
        List c = m7236c(map, "X-Afma-Click-Tracking-Urls");
        if (c != null) {
            this.f6453d = c;
        }
    }

    /* renamed from: d */
    private void m7238d(Map map) {
        List list = (List) map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.f6454e = (String) list.get(0);
        }
    }

    /* renamed from: d */
    private boolean m7239d(Map map, String str) {
        List list = (List) map.get(str);
        return list != null && !list.isEmpty() && Boolean.valueOf((String) list.get(0)).booleanValue();
    }

    /* renamed from: e */
    private void m7240e(Map map) {
        List c = m7236c(map, "X-Afma-Tracking-Urls");
        if (c != null) {
            this.f6456g = c;
        }
    }

    /* renamed from: f */
    private void m7241f(Map map) {
        long b = m7234b(map, "X-Afma-Interstitial-Timeout");
        if (b != -1) {
            this.f6457h = b;
        }
    }

    /* renamed from: g */
    private void m7242g(Map map) {
        this.f6455f = m7232a(map, "X-Afma-ActiveView");
    }

    /* renamed from: h */
    private void m7243h(Map map) {
        this.f6464o = "native".equals(m7232a(map, "X-Afma-Ad-Format"));
    }

    /* renamed from: i */
    private void m7244i(Map map) {
        this.f6463n |= m7239d(map, "X-Afma-Custom-Rendering-Allowed");
    }

    /* renamed from: j */
    private void m7245j(Map map) {
        this.f6458i |= m7239d(map, "X-Afma-Mediation");
    }

    /* renamed from: k */
    private void m7246k(Map map) {
        this.f6447D |= m7239d(map, "X-Afma-Render-In-Browser");
    }

    /* renamed from: l */
    private void m7247l(Map map) {
        List c = m7236c(map, "X-Afma-Manual-Tracking-Urls");
        if (c != null) {
            this.f6460k = c;
        }
    }

    /* renamed from: m */
    private void m7248m(Map map) {
        long b = m7234b(map, "X-Afma-Refresh-Rate");
        if (b != -1) {
            this.f6461l = b;
        }
    }

    /* renamed from: n */
    private void m7249n(Map map) {
        List list = (List) map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.f6462m = zzu.zzfs().zztk();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.f6462m = zzu.zzfs().zztj();
            }
        }
    }

    /* renamed from: o */
    private void m7250o(Map map) {
        List list = (List) map.get("X-Afma-Use-HTTPS");
        if (list != null && !list.isEmpty()) {
            this.f6465p = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    /* renamed from: p */
    private void m7251p(Map map) {
        List list = (List) map.get("X-Afma-Content-Url-Opted-Out");
        if (list != null && !list.isEmpty()) {
            this.f6466q = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    /* renamed from: q */
    private void m7252q(Map map) {
        List list = (List) map.get("X-Afma-Gws-Query-Id");
        if (list != null && !list.isEmpty()) {
            this.f6467r = (String) list.get(0);
        }
    }

    /* renamed from: r */
    private void m7253r(Map map) {
        String a = m7232a(map, "X-Afma-Fluid");
        if (a != null && a.equals("height")) {
            this.f6468s = true;
        }
    }

    /* renamed from: s */
    private void m7254s(Map map) {
        this.f6469t = "native_express".equals(m7232a(map, "X-Afma-Ad-Format"));
    }

    /* renamed from: t */
    private void m7255t(Map map) {
        this.f6470u = RewardItemParcel.zzch(m7232a(map, "X-Afma-Rewards"));
    }

    /* renamed from: u */
    private void m7256u(Map map) {
        if (this.f6471v == null) {
            this.f6471v = m7236c(map, "X-Afma-Reward-Video-Start-Urls");
        }
    }

    /* renamed from: v */
    private void m7257v(Map map) {
        if (this.f6472w == null) {
            this.f6472w = m7236c(map, "X-Afma-Reward-Video-Complete-Urls");
        }
    }

    /* renamed from: w */
    private void m7258w(Map map) {
        this.f6473x |= m7239d(map, "X-Afma-Use-Displayed-Impression");
    }

    /* renamed from: x */
    private void m7259x(Map map) {
        this.f6475z |= m7239d(map, "X-Afma-Auto-Collect-Location");
    }

    /* renamed from: y */
    private void m7260y(Map map) {
        List c = m7236c(map, "X-Afma-Remote-Ping-Urls");
        if (c != null) {
            this.f6445B = c;
        }
    }

    /* renamed from: z */
    private void m7261z(Map map) {
        String a = m7232a(map, "X-Afma-Auto-Protection-Configuration");
        if (a == null || TextUtils.isEmpty(a)) {
            Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
            buildUpon.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(this.f6454e)) {
                buildUpon.appendQueryParameter("debugDialog", this.f6454e);
            }
            boolean booleanValue = ((Boolean) zzdc.zzayg.get()).booleanValue();
            String valueOf = String.valueOf(buildUpon.toString());
            String valueOf2 = String.valueOf("navigationURL");
            this.f6474y = new AutoClickProtectionConfigurationParcel(booleanValue, Arrays.asList(new String[]{new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length()).append(valueOf).append("&").append(valueOf2).append("={NAVIGATION_URL}").toString()}));
            return;
        }
        try {
            this.f6474y = AutoClickProtectionConfigurationParcel.zzh(new JSONObject(a));
        } catch (JSONException e) {
            zzkd.zzd("Error parsing configuration JSON", e);
            this.f6474y = new AutoClickProtectionConfigurationParcel();
        }
    }

    public void zzb(String str, Map map, String str2) {
        this.f6451b = str;
        this.f6452c = str2;
        zzj(map);
    }

    public AdResponseParcel zzj(long j) {
        return new AdResponseParcel(this.f6449F, this.f6451b, this.f6452c, this.f6453d, this.f6456g, this.f6457h, this.f6458i, -1, this.f6460k, this.f6461l, this.f6462m, this.f6450a, j, this.f6454e, this.f6455f, this.f6463n, this.f6464o, this.f6465p, this.f6466q, false, this.f6467r, this.f6468s, this.f6469t, this.f6470u, this.f6471v, this.f6472w, this.f6473x, this.f6474y, this.f6475z, this.f6444A, this.f6445B, this.f6446C, this.f6447D, this.f6448E);
    }

    public void zzj(Map map) {
        m7233a(map);
        m7235b(map);
        m7237c(map);
        m7238d(map);
        m7240e(map);
        m7241f(map);
        m7245j(map);
        m7247l(map);
        m7248m(map);
        m7249n(map);
        m7242g(map);
        m7250o(map);
        m7244i(map);
        m7243h(map);
        m7251p(map);
        m7252q(map);
        m7253r(map);
        m7254s(map);
        m7255t(map);
        m7256u(map);
        m7257v(map);
        m7258w(map);
        m7259x(map);
        m7230A(map);
        m7261z(map);
        m7260y(map);
        m7231B(map);
        m7246k(map);
    }
}
