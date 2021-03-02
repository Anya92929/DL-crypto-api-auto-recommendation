package com.google.ads;

import android.content.Context;
import android.net.Uri;

/* renamed from: com.google.ads.al */
public class C0192al {

    /* renamed from: a */
    private String f349a = "googleads.g.doubleclick.net";

    /* renamed from: b */
    private String f350b = "/pagead/ads";

    /* renamed from: c */
    private String[] f351c = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};

    /* renamed from: d */
    private C0188ai f352d;

    /* renamed from: e */
    private C0187ah f353e = new C0187ah();

    public C0192al(C0188ai aiVar) {
        this.f352d = aiVar;
    }

    /* renamed from: a */
    public boolean mo3344a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.f351c) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    /* renamed from: a */
    public void mo3343a(String str) {
        this.f351c = str.split(",");
    }

    /* renamed from: a */
    public Uri mo3342a(Uri uri, Context context) throws C0193am {
        try {
            return m83a(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new C0193am("Provided Uri is not in a valid state");
        }
    }

    /* renamed from: a */
    private Uri m84a(Uri uri, String str, String str2) throws UnsupportedOperationException {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(uri2.substring(0, indexOf + 1) + str + "=" + str2 + "&" + uri2.substring(indexOf + 1)) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    /* renamed from: a */
    private Uri m83a(Uri uri, Context context, String str, boolean z) throws C0193am {
        String a;
        try {
            if (uri.getQueryParameter("ms") != null) {
                throw new C0193am("Query parameter already exists: ms");
            }
            if (z) {
                a = this.f352d.mo3333a(context, str);
            } else {
                a = this.f352d.mo3332a(context);
            }
            return m84a(uri, "ms", a);
        } catch (UnsupportedOperationException e) {
            throw new C0193am("Provided Uri is not in a valid state");
        }
    }
}
