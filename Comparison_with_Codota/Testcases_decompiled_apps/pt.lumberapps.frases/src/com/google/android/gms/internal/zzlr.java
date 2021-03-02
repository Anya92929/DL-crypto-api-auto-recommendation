package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.internal.zzaa;
import java.net.URI;
import java.net.URISyntaxException;

@zzin
public class zzlr extends WebViewClient {

    /* renamed from: a */
    private final String f6752a;

    /* renamed from: b */
    private boolean f6753b = false;

    /* renamed from: c */
    private final zzlh f6754c;

    /* renamed from: d */
    private final zzhz f6755d;

    public zzlr(zzhz zzhz, zzlh zzlh, String str) {
        this.f6752a = m7381b(str);
        this.f6754c = zzlh;
        this.f6755d = zzhz;
    }

    /* renamed from: b */
    private String m7381b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return str.endsWith("/") ? str.substring(0, str.length() - 1) : str;
        } catch (IndexOutOfBoundsException e) {
            zzkd.m5769e(e.getMessage());
            return str;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo8881a(String str) {
        String b = m7381b(str);
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        try {
            URI uri = new URI(b);
            if ("passback".equals(uri.getScheme())) {
                zzkd.zzcv("Passback received");
                this.f6755d.zzqa();
                return true;
            } else if (TextUtils.isEmpty(this.f6752a)) {
                return false;
            } else {
                URI uri2 = new URI(this.f6752a);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!zzaa.equal(host, host2) || !zzaa.equal(path, path2)) {
                    return false;
                }
                zzkd.zzcv("Passback received");
                this.f6755d.zzqa();
                return true;
            }
        } catch (URISyntaxException e) {
            zzkd.m5769e(e.getMessage());
            return false;
        }
    }

    public void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzkd.zzcv(valueOf.length() != 0 ? "JavascriptAdWebViewClient::onLoadResource: ".concat(valueOf) : new String("JavascriptAdWebViewClient::onLoadResource: "));
        if (!mo8881a(str)) {
            this.f6754c.zzuj().onLoadResource(this.f6754c.getWebView(), str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzkd.zzcv(valueOf.length() != 0 ? "JavascriptAdWebViewClient::onPageFinished: ".concat(valueOf) : new String("JavascriptAdWebViewClient::onPageFinished: "));
        if (!this.f6753b) {
            this.f6755d.zzpz();
            this.f6753b = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzkd.zzcv(valueOf.length() != 0 ? "JavascriptAdWebViewClient::shouldOverrideUrlLoading: ".concat(valueOf) : new String("JavascriptAdWebViewClient::shouldOverrideUrlLoading: "));
        if (!mo8881a(str)) {
            return this.f6754c.zzuj().shouldOverrideUrlLoading(this.f6754c.getWebView(), str);
        }
        zzkd.zzcv("shouldOverrideUrlLoading: received passback url");
        return true;
    }
}
