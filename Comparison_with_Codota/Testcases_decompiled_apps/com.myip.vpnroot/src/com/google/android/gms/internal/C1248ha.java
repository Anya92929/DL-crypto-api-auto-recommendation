package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.internal.C0345m;
import java.net.URI;
import java.net.URISyntaxException;

@C1130ez
/* renamed from: com.google.android.gms.internal.ha */
public class C1248ha extends WebViewClient {

    /* renamed from: md */
    private final C1232gv f3824md;

    /* renamed from: xc */
    private final String f3825xc;

    /* renamed from: xd */
    private boolean f3826xd = false;

    /* renamed from: xe */
    private final C1152fc f3827xe;

    public C1248ha(C1152fc fcVar, C1232gv gvVar, String str) {
        this.f3825xc = m4748Z(str);
        this.f3824md = gvVar;
        this.f3827xe = fcVar;
    }

    /* renamed from: Z */
    private String m4748Z(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return str.endsWith("/") ? str.substring(0, str.length() - 1) : str;
        } catch (IndexOutOfBoundsException e) {
            C1229gs.m4676T(e.getMessage());
            return str;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: Y */
    public boolean mo8694Y(String str) {
        String Z = m4748Z(str);
        if (TextUtils.isEmpty(Z)) {
            return false;
        }
        try {
            URI uri = new URI(Z);
            if ("passback".equals(uri.getScheme())) {
                C1229gs.m4675S("Passback received");
                this.f3827xe.mo8474cA();
                return true;
            } else if (TextUtils.isEmpty(this.f3825xc)) {
                return false;
            } else {
                URI uri2 = new URI(this.f3825xc);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!C0345m.equal(host, host2) || !C0345m.equal(path, path2)) {
                    return false;
                }
                C1229gs.m4675S("Passback received");
                this.f3827xe.mo8474cA();
                return true;
            }
        } catch (URISyntaxException e) {
            C1229gs.m4676T(e.getMessage());
            return false;
        }
    }

    public void onLoadResource(WebView view, String url) {
        C1229gs.m4675S("JavascriptAdWebViewClient::onLoadResource: " + url);
        if (!mo8694Y(url)) {
            this.f3824md.mo8631dv().onLoadResource(this.f3824md, url);
        }
    }

    public void onPageFinished(WebView view, String url) {
        C1229gs.m4675S("JavascriptAdWebViewClient::onPageFinished: " + url);
        if (!this.f3826xd) {
            this.f3827xe.mo8477cz();
            this.f3826xd = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        C1229gs.m4675S("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + url);
        if (!mo8694Y(url)) {
            return this.f3824md.mo8631dv().shouldOverrideUrlLoading(this.f3824md, url);
        }
        C1229gs.m4675S("shouldOverrideUrlLoading: received passback url");
        return true;
    }
}
