package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

/* renamed from: com.google.android.gms.internal.h */
public class C0599h {

    /* renamed from: dA */
    private final C0323c f1544dA = new C0323c();

    /* renamed from: dw */
    private String f1545dw = "googleads.g.doubleclick.net";

    /* renamed from: dx */
    private String f1546dx = "/pagead/ads";

    /* renamed from: dy */
    private String[] f1547dy = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};

    /* renamed from: dz */
    private C0382d f1548dz;

    public C0599h(C0382d dVar) {
        this.f1548dz = dVar;
    }

    /* renamed from: a */
    private Uri m1878a(Uri uri, Context context, String str, boolean z) throws C0600i {
        try {
            if (uri.getQueryParameter("ms") != null) {
                throw new C0600i("Query parameter already exists: ms");
            }
            return m1879a(uri, "ms", z ? this.f1548dz.mo4316a(context, str) : this.f1548dz.mo4315a(context));
        } catch (UnsupportedOperationException e) {
            throw new C0600i("Provided Uri is not in a valid state");
        }
    }

    /* renamed from: a */
    private Uri m1879a(Uri uri, String str, String str2) throws UnsupportedOperationException {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(uri2.substring(0, indexOf + 1) + str + "=" + str2 + "&" + uri2.substring(indexOf + 1)) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    /* renamed from: a */
    public Uri mo5301a(Uri uri, Context context) throws C0600i {
        try {
            return m1878a(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new C0600i("Provided Uri is not in a valid state");
        }
    }

    /* renamed from: a */
    public void mo5302a(MotionEvent motionEvent) {
        this.f1548dz.mo4318a(motionEvent);
    }

    /* renamed from: a */
    public boolean mo5303a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.f1547dy) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    /* renamed from: g */
    public C0382d mo5304g() {
        return this.f1548dz;
    }
}
