package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* renamed from: com.google.android.gms.tagmanager.ce */
class C2055ce {
    private static C2055ce apS;
    private volatile String anR;
    private volatile C2056a apT;
    private volatile String apU;
    private volatile String apV;

    /* renamed from: com.google.android.gms.tagmanager.ce$a */
    enum C2056a {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    C2055ce() {
        clear();
    }

    /* renamed from: cF */
    private String m6904cF(String str) {
        return str.split("&")[0].split("=")[1];
    }

    /* renamed from: j */
    private String m6905j(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    /* renamed from: oH */
    static C2055ce m6906oH() {
        C2055ce ceVar;
        synchronized (C2055ce.class) {
            if (apS == null) {
                apS = new C2055ce();
            }
            ceVar = apS;
        }
        return ceVar;
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.apT = C2056a.NONE;
        this.apU = null;
        this.anR = null;
        this.apV = null;
    }

    /* access modifiers changed from: package-private */
    public String getContainerId() {
        return this.anR;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public synchronized boolean mo11629i(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    C2028bh.m6818V("Container preview url: " + decode);
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.apT = C2056a.CONTAINER_DEBUG;
                    } else {
                        this.apT = C2056a.CONTAINER;
                    }
                    this.apV = m6905j(uri);
                    if (this.apT == C2056a.CONTAINER || this.apT == C2056a.CONTAINER_DEBUG) {
                        this.apU = "/r?" + this.apV;
                    }
                    this.anR = m6904cF(this.apV);
                } else if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                    C2028bh.m6819W("Invalid preview uri: " + decode);
                    z = false;
                } else if (m6904cF(uri.getQuery()).equals(this.anR)) {
                    C2028bh.m6818V("Exit preview mode for container: " + this.anR);
                    this.apT = C2056a.NONE;
                    this.apU = null;
                } else {
                    z = false;
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: oI */
    public C2056a mo11630oI() {
        return this.apT;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: oJ */
    public String mo11631oJ() {
        return this.apU;
    }
}
