package com.google.ads.internal;

import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.AdActivity;
import com.google.ads.C0167aa;
import com.google.ads.C0168ab;
import com.google.ads.C0169ac;
import com.google.ads.C0273o;
import com.google.ads.C0274p;
import com.google.ads.C0275q;
import com.google.ads.C0276r;
import com.google.ads.C0277s;
import com.google.ads.C0278t;
import com.google.ads.C0279u;
import com.google.ads.C0310v;
import com.google.ads.C0311w;
import com.google.ads.C0312x;
import com.google.ads.C0313y;
import com.google.ads.C0314z;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0284b;
import com.google.ads.util.C0292f;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.google.ads.internal.a */
public class C0232a {

    /* renamed from: a */
    public static final C0292f<C0232a> f474a = new C0292f<C0232a>() {
        /* renamed from: a */
        public C0232a mo3484b() {
            return C0232a.f478e;
        }
    };

    /* renamed from: b */
    public static final Map<String, C0273o> f475b = Collections.unmodifiableMap(new HashMap<String, C0273o>() {
        {
            put("/invalidRequest", new C0310v());
            put("/loadAdURL", new C0311w());
            put("/loadSdkConstants", new C0312x());
            put("/log", new C0313y());
        }
    });

    /* renamed from: c */
    public static final Map<String, C0273o> f476c = Collections.unmodifiableMap(new HashMap<String, C0273o>() {
        {
            put("/log", new C0313y());
            put("/setNativeActivationOverlay", new C0167aa());
        }
    });

    /* renamed from: d */
    public static final Map<String, C0273o> f477d = Collections.unmodifiableMap(new HashMap<String, C0273o>() {
        {
            put("/open", new C0314z());
            put("/canOpenURLs", new C0275q());
            put("/close", new C0277s());
            put("/customClose", new C0278t());
            put("/appEvent", new C0274p());
            put("/log", new C0313y());
            put("/click", new C0276r());
            put("/httpTrack", new C0279u());
            put("/touch", new C0168ab());
            put("/video", new C0169ac());
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final C0232a f478e = new C0232a();

    /* renamed from: a */
    public String mo3473a(Uri uri, HashMap<String, String> hashMap) {
        if (mo3482c(uri)) {
            String host = uri.getHost();
            if (host == null) {
                C0284b.m490e("An error occurred while parsing the AMSG parameters.");
                return null;
            } else if (host.equals("launch")) {
                hashMap.put("a", "intent");
                hashMap.put(AdActivity.URL_PARAM, hashMap.get("url"));
                hashMap.remove("url");
                return "/open";
            } else if (host.equals("closecanvas")) {
                return "/close";
            } else {
                if (host.equals("log")) {
                    return "/log";
                }
                C0284b.m490e("An error occurred while parsing the AMSG: " + uri.toString());
                return null;
            }
        } else if (mo3481b(uri)) {
            return uri.getPath();
        } else {
            C0284b.m490e("Message was neither a GMSG nor an AMSG.");
            return null;
        }
    }

    /* renamed from: a */
    public void mo3478a(C0247d dVar, Map<String, C0273o> map, Uri uri, WebView webView) {
        HashMap<String, String> b = AdUtil.m457b(uri);
        if (b == null) {
            C0284b.m490e("An error occurred while parsing the message parameters.");
            return;
        }
        String a = mo3473a(uri, b);
        if (a == null) {
            C0284b.m490e("An error occurred while parsing the message.");
            return;
        }
        C0273o oVar = map.get(a);
        if (oVar == null) {
            C0284b.m490e("No AdResponse found, <message: " + a + ">");
        } else {
            oVar.mo3325a(dVar, b, webView);
        }
    }

    /* renamed from: a */
    public boolean mo3479a(Uri uri) {
        if (uri == null || !uri.isHierarchical()) {
            return false;
        }
        if (mo3481b(uri) || mo3482c(uri)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo3481b(Uri uri) {
        String authority;
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.equals("gmsg") || (authority = uri.getAuthority()) == null || !authority.equals("mobileads.google.com")) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public boolean mo3482c(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.equals("admob")) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void mo3476a(WebView webView, String str, String str2) {
        if (str2 != null) {
            mo3475a(webView, "AFMA_ReceiveMessage" + "('" + str + "', " + str2 + ");");
        } else {
            mo3475a(webView, "AFMA_ReceiveMessage" + "('" + str + "');");
        }
    }

    /* renamed from: a */
    public void mo3475a(WebView webView, String str) {
        C0284b.m480a("Sending JS to a WebView: " + str);
        webView.loadUrl("javascript:" + str);
    }

    /* renamed from: a */
    public void mo3477a(WebView webView, Map<String, Boolean> map) {
        mo3476a(webView, "openableURLs", new JSONObject(map).toString());
    }

    /* renamed from: a */
    public void mo3474a(WebView webView) {
        mo3476a(webView, "onshow", "{'version': 'afma-sdk-a-v6.4.1'}");
    }

    /* renamed from: b */
    public void mo3480b(WebView webView) {
        mo3476a(webView, "onhide", (String) null);
    }
}
