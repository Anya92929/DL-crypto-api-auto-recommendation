package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.p009v4.app.NotificationCompat;
import android.support.p021v7.p023b.C0515k;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@zzin
public class zzli extends WebViewClient {

    /* renamed from: c */
    private static final String[] f6679c = {"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};

    /* renamed from: d */
    private static final String[] f6680d = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};

    /* renamed from: a */
    protected zzlh f6681a;

    /* renamed from: b */
    protected zzjo f6682b;

    /* renamed from: e */
    private final HashMap f6683e;

    /* renamed from: f */
    private final Object f6684f;

    /* renamed from: g */
    private com.google.android.gms.ads.internal.client.zza f6685g;

    /* renamed from: h */
    private zzg f6686h;

    /* renamed from: i */
    private zza f6687i;

    /* renamed from: j */
    private zzel f6688j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public zzb f6689k;

    /* renamed from: l */
    private boolean f6690l;

    /* renamed from: m */
    private zzer f6691m;

    /* renamed from: n */
    private zzet f6692n;

    /* renamed from: o */
    private boolean f6693o;

    /* renamed from: p */
    private boolean f6694p;

    /* renamed from: q */
    private zzp f6695q;

    /* renamed from: r */
    private final zzhe f6696r;

    /* renamed from: s */
    private zze f6697s;

    /* renamed from: t */
    private zzha f6698t;

    /* renamed from: u */
    private zzhg f6699u;

    /* renamed from: v */
    private zzd f6700v;

    /* renamed from: w */
    private boolean f6701w;

    /* renamed from: x */
    private boolean f6702x;

    /* renamed from: y */
    private boolean f6703y;

    /* renamed from: z */
    private int f6704z;

    public interface zza {
        void zza(zzlh zzlh, boolean z);
    }

    public interface zzb {
        void zzen();
    }

    public interface zzd {
        void zzem();
    }

    public zzli(zzlh zzlh, boolean z) {
        this(zzlh, z, new zzhe(zzlh, zzlh.zzuf(), new zzcu(zzlh.getContext())), (zzha) null);
    }

    zzli(zzlh zzlh, boolean z, zzhe zzhe, zzha zzha) {
        this.f6683e = new HashMap();
        this.f6684f = new Object();
        this.f6690l = false;
        this.f6681a = zzlh;
        this.f6693o = z;
        this.f6696r = zzhe;
        this.f6698t = zzha;
    }

    /* renamed from: a */
    private String m7339a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        return parse.getHost() != null ? parse.getHost() : "";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7340a() {
        synchronized (this.f6684f) {
            this.f6694p = true;
        }
        this.f6704z++;
        zzve();
    }

    /* renamed from: a */
    private void m7341a(Context context, String str, String str2, String str3) {
        if (((Boolean) zzdc.zzbav.get()).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            bundle.putString("host", m7339a(str3));
            zzu.zzfq().zza(context, this.f6681a.zzum().zzcs, "gmob-apps", bundle, true);
        }
    }

    /* renamed from: a */
    private static boolean m7343a(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7344b() {
        this.f6704z--;
        zzve();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m7346c() {
        this.f6703y = true;
        zzve();
    }

    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzkd.m7303v(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzi(parse);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.f6684f) {
            if (this.f6701w) {
                zzkd.m7303v("Blank page loaded, 1...");
                this.f6681a.zzuo();
                return;
            }
            this.f6702x = true;
            zzve();
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        m7341a(this.f6681a.getContext(), "http_err", (i >= 0 || (-i) + -1 >= f6679c.length) ? String.valueOf(i) : f6679c[(-i) - 1], str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            m7341a(this.f6681a.getContext(), "ssl_err", (primaryError < 0 || primaryError >= f6680d.length) ? String.valueOf(primaryError) : f6680d[primaryError], zzu.zzfs().zza(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public final void reset() {
        if (this.f6682b != null) {
            this.f6682b.zzrx();
            this.f6682b = null;
        }
        synchronized (this.f6684f) {
            this.f6683e.clear();
            this.f6685g = null;
            this.f6686h = null;
            this.f6687i = null;
            this.f6688j = null;
            this.f6690l = false;
            this.f6693o = false;
            this.f6694p = false;
            this.f6691m = null;
            this.f6695q = null;
            this.f6689k = null;
            if (this.f6698t != null) {
                this.f6698t.zzs(true);
                this.f6698t = null;
            }
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case C0515k.AppCompatTheme_panelBackground:
            case C0515k.AppCompatTheme_colorAccent:
            case C0515k.AppCompatTheme_colorControlNormal:
            case C0515k.AppCompatTheme_colorControlActivated:
            case C0515k.AppCompatTheme_colorControlHighlight:
            case C0515k.AppCompatTheme_colorButtonNormal:
            case 90:
            case C0515k.AppCompatTheme_controlBackground:
            case 126:
            case 127:
            case NotificationCompat.FLAG_HIGH_PRIORITY:
            case 129:
            case 130:
            case 222:
                return true;
            default:
                return false;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri uri;
        String valueOf = String.valueOf(str);
        zzkd.m7303v(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzi(parse);
        } else if (this.f6690l && webView == this.f6681a.getWebView() && m7343a(parse)) {
            if (this.f6685g != null && ((Boolean) zzdc.zzazu.get()).booleanValue()) {
                this.f6685g.onAdClicked();
                if (this.f6682b != null) {
                    this.f6682b.zzci(str);
                }
                this.f6685g = null;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        } else if (!this.f6681a.getWebView().willNotDraw()) {
            try {
                zzas zzul = this.f6681a.zzul();
                if (zzul != null && zzul.zzc(parse)) {
                    parse = zzul.zzb(parse, this.f6681a.getContext());
                }
                uri = parse;
            } catch (zzat e) {
                String valueOf2 = String.valueOf(str);
                zzkd.zzcx(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
                uri = parse;
            }
            if (this.f6697s == null || this.f6697s.zzel()) {
                zza(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", uri.toString(), (String) null, (String) null, (String) null, (String) null, (String) null));
            } else {
                this.f6697s.zzt(str);
            }
        } else {
            String valueOf3 = String.valueOf(str);
            zzkd.zzcx(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
        }
        return true;
    }

    public void zza(int i, int i2, boolean z) {
        this.f6696r.zze(i, i2);
        if (this.f6698t != null) {
            this.f6698t.zza(i, i2, z);
        }
    }

    public void zza(com.google.android.gms.ads.internal.client.zza zza2, zzg zzg, zzel zzel, zzp zzp, boolean z, zzer zzer, zzet zzet, zze zze, zzhg zzhg, zzjo zzjo) {
        if (zze == null) {
            zze = new zze(this.f6681a.getContext());
        }
        this.f6698t = new zzha(this.f6681a, zzhg);
        this.f6682b = zzjo;
        zza("/appEvent", (zzep) new zzek(zzel));
        zza("/backButton", zzeo.zzbhx);
        zza("/refresh", zzeo.zzbhy);
        zza("/canOpenURLs", zzeo.zzbho);
        zza("/canOpenIntents", zzeo.zzbhp);
        zza("/click", zzeo.zzbhq);
        zza("/close", zzeo.zzbhr);
        zza("/customClose", zzeo.zzbht);
        zza("/instrument", zzeo.zzbic);
        zza("/delayPageLoaded", (zzep) new C1763nd(this, (C1760na) null));
        zza("/httpTrack", zzeo.zzbhu);
        zza("/log", zzeo.zzbhv);
        zza("/mraid", (zzep) new zzev(zze, this.f6698t));
        zza("/mraidLoaded", (zzep) this.f6696r);
        zza("/open", (zzep) new zzew(zzer, zze, this.f6698t));
        zza("/precache", zzeo.zzbib);
        zza("/touch", zzeo.zzbhw);
        zza("/video", zzeo.zzbhz);
        zza("/videoMeta", zzeo.zzbia);
        zza("/appStreaming", zzeo.zzbhs);
        if (zzet != null) {
            zza("/setInterstitialProperties", (zzep) new zzes(zzet));
        }
        this.f6685g = zza2;
        this.f6686h = zzg;
        this.f6688j = zzel;
        this.f6691m = zzer;
        this.f6695q = zzp;
        this.f6697s = zze;
        this.f6699u = zzhg;
        this.f6692n = zzet;
        zzak(z);
    }

    public final void zza(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        zzg zzg = null;
        boolean zzun = this.f6681a.zzun();
        com.google.android.gms.ads.internal.client.zza zza2 = (!zzun || this.f6681a.zzdn().zzaus) ? this.f6685g : null;
        if (!zzun) {
            zzg = this.f6686h;
        }
        zza(new AdOverlayInfoParcel(adLauncherIntentInfoParcel, zza2, zzg, this.f6695q, this.f6681a.zzum()));
    }

    public void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean zzmw = this.f6698t != null ? this.f6698t.zzmw() : false;
        com.google.android.gms.ads.internal.overlay.zze zzfo = zzu.zzfo();
        Context context = this.f6681a.getContext();
        if (!zzmw) {
            z = true;
        }
        zzfo.zza(context, adOverlayInfoParcel, z);
        if (this.f6682b != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && adOverlayInfoParcel.zzbtj != null) {
                str = adOverlayInfoParcel.zzbtj.url;
            }
            this.f6682b.zzci(str);
        }
    }

    public void zza(zza zza2) {
        this.f6687i = zza2;
    }

    public void zza(zzb zzb2) {
        this.f6689k = zzb2;
    }

    public void zza(zzd zzd2) {
        this.f6700v = zzd2;
    }

    public void zza(String str, zzep zzep) {
        synchronized (this.f6684f) {
            List list = (List) this.f6683e.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.f6683e.put(str, list);
            }
            list.add(zzep);
        }
    }

    public final void zza(boolean z, int i) {
        zza(new AdOverlayInfoParcel((!this.f6681a.zzun() || this.f6681a.zzdn().zzaus) ? this.f6685g : null, this.f6686h, this.f6695q, this.f6681a, z, i, this.f6681a.zzum()));
    }

    public final void zza(boolean z, int i, String str) {
        C1762nc ncVar = null;
        boolean zzun = this.f6681a.zzun();
        com.google.android.gms.ads.internal.client.zza zza2 = (!zzun || this.f6681a.zzdn().zzaus) ? this.f6685g : null;
        if (!zzun) {
            ncVar = new C1762nc(this.f6681a, this.f6686h);
        }
        zza(new AdOverlayInfoParcel(zza2, ncVar, this.f6688j, this.f6695q, this.f6681a, z, i, str, this.f6681a.zzum(), this.f6691m));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzun = this.f6681a.zzun();
        zza(new AdOverlayInfoParcel((!zzun || this.f6681a.zzdn().zzaus) ? this.f6685g : null, zzun ? null : new C1762nc(this.f6681a, this.f6686h), this.f6688j, this.f6695q, this.f6681a, z, i, str, str2, this.f6681a.zzum(), this.f6691m));
    }

    public void zzak(boolean z) {
        this.f6690l = z;
    }

    public void zzb(String str, zzep zzep) {
        synchronized (this.f6684f) {
            List list = (List) this.f6683e.get(str);
            if (list != null) {
                list.remove(zzep);
            }
        }
    }

    public void zzd(int i, int i2) {
        if (this.f6698t != null) {
            this.f6698t.zzd(i, i2);
        }
    }

    public boolean zzho() {
        boolean z;
        synchronized (this.f6684f) {
            z = this.f6693o;
        }
        return z;
    }

    public void zzi(Uri uri) {
        String path = uri.getPath();
        List<zzep> list = (List) this.f6683e.get(path);
        if (list != null) {
            Map zzf = zzu.zzfq().zzf(uri);
            if (zzkd.zzaz(2)) {
                String valueOf = String.valueOf(path);
                zzkd.m7303v(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
                for (String str : zzf.keySet()) {
                    String str2 = (String) zzf.get(str);
                    zzkd.m7303v(new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length()).append("  ").append(str).append(": ").append(str2).toString());
                }
            }
            for (zzep zza2 : list) {
                zza2.zza(this.f6681a, zzf);
            }
            return;
        }
        String valueOf2 = String.valueOf(uri);
        zzkd.m7303v(new StringBuilder(String.valueOf(valueOf2).length() + 32).append("No GMSG handler found for GMSG: ").append(valueOf2).toString());
    }

    public void zzl(zzlh zzlh) {
        this.f6681a = zzlh;
    }

    public final void zznx() {
        synchronized (this.f6684f) {
            this.f6690l = false;
            this.f6693o = true;
            zzu.zzfq().runOnUiThread(new C1761nb(this));
        }
    }

    public zze zzux() {
        return this.f6697s;
    }

    public boolean zzuy() {
        boolean z;
        synchronized (this.f6684f) {
            z = this.f6694p;
        }
        return z;
    }

    public void zzuz() {
        synchronized (this.f6684f) {
            zzkd.m7303v("Loading blank page in WebView, 2...");
            this.f6701w = true;
            this.f6681a.zzcy("about:blank");
        }
    }

    public void zzva() {
        if (this.f6682b != null) {
            zzkh.zzclc.post(new C1760na(this));
        }
    }

    public final void zzve() {
        if (this.f6687i != null && ((this.f6702x && this.f6704z <= 0) || this.f6703y)) {
            this.f6687i.zza(this.f6681a, !this.f6703y);
            this.f6687i = null;
        }
        this.f6681a.zzuv();
    }

    public zzd zzvf() {
        return this.f6700v;
    }
}
