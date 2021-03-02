package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* renamed from: com.google.android.gms.tagmanager.ai */
class C1276ai {

    /* renamed from: a */
    private static C1276ai f5306a;

    /* renamed from: b */
    private volatile C1277aj f5307b;

    /* renamed from: c */
    private volatile String f5308c;

    /* renamed from: d */
    private volatile String f5309d;

    /* renamed from: e */
    private volatile String f5310e;

    C1276ai() {
        mo9098e();
    }

    /* renamed from: a */
    static C1276ai m5275a() {
        C1276ai aiVar;
        synchronized (C1276ai.class) {
            if (f5306a == null) {
                f5306a = new C1276ai();
            }
            aiVar = f5306a;
        }
        return aiVar;
    }

    /* renamed from: a */
    private String m5276a(String str) {
        return str.split("&")[0].split("=")[1];
    }

    /* renamed from: b */
    private String m5277b(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo9094a(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    C1333x.m5444d("Container preview url: " + decode);
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.f5307b = C1277aj.CONTAINER_DEBUG;
                    } else {
                        this.f5307b = C1277aj.CONTAINER;
                    }
                    this.f5310e = m5277b(uri);
                    if (this.f5307b == C1277aj.CONTAINER || this.f5307b == C1277aj.CONTAINER_DEBUG) {
                        this.f5309d = "/r?" + this.f5310e;
                    }
                    this.f5308c = m5276a(this.f5310e);
                } else if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                    C1333x.m5442b("Invalid preview uri: " + decode);
                    z = false;
                } else if (m5276a(uri.getQuery()).equals(this.f5308c)) {
                    C1333x.m5444d("Exit preview mode for container: " + this.f5308c);
                    this.f5307b = C1277aj.NONE;
                    this.f5309d = null;
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
    /* renamed from: b */
    public C1277aj mo9095b() {
        return this.f5307b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo9096c() {
        return this.f5309d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo9097d() {
        return this.f5308c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo9098e() {
        this.f5307b = C1277aj.NONE;
        this.f5309d = null;
        this.f5308c = null;
        this.f5310e = null;
    }
}
