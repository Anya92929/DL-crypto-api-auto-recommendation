package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

/* renamed from: com.google.android.gms.internal.k */
public class C1391k {

    /* renamed from: kR */
    private String f4139kR = "googleads.g.doubleclick.net";

    /* renamed from: kS */
    private String f4140kS = "/pagead/ads";

    /* renamed from: kT */
    private String f4141kT = "ad.doubleclick.net";

    /* renamed from: kU */
    private String[] f4142kU = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};

    /* renamed from: kV */
    private C1198g f4143kV;

    public C1391k(C1198g gVar) {
        this.f4143kV = gVar;
    }

    /* renamed from: a */
    private Uri m5227a(Uri uri, Context context, String str, boolean z) throws C1467l {
        try {
            boolean a = mo9090a(uri);
            if (a) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new C1467l("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new C1467l("Query parameter already exists: ms");
            }
            String a2 = z ? this.f4143kV.mo8541a(context, str) : this.f4143kV.mo8540a(context);
            return a ? m5229b(uri, "dc_ms", a2) : m5228a(uri, "ms", a2);
        } catch (UnsupportedOperationException e) {
            throw new C1467l("Provided Uri is not in a valid state");
        }
    }

    /* renamed from: a */
    private Uri m5228a(Uri uri, String str, String str2) throws UnsupportedOperationException {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(uri2.substring(0, indexOf + 1) + str + "=" + str2 + "&" + uri2.substring(indexOf + 1)) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    /* renamed from: b */
    private Uri m5229b(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf(";adurl");
        if (indexOf != -1) {
            return Uri.parse(uri2.substring(0, indexOf + 1) + str + "=" + str2 + ";" + uri2.substring(indexOf + 1));
        }
        String encodedPath = uri.getEncodedPath();
        int indexOf2 = uri2.indexOf(encodedPath);
        return Uri.parse(uri2.substring(0, encodedPath.length() + indexOf2) + ";" + str + "=" + str2 + ";" + uri2.substring(encodedPath.length() + indexOf2));
    }

    /* renamed from: a */
    public Uri mo9088a(Uri uri, Context context) throws C1467l {
        try {
            return m5227a(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new C1467l("Provided Uri is not in a valid state");
        }
    }

    /* renamed from: a */
    public void mo9089a(MotionEvent motionEvent) {
        this.f4143kV.mo8543a(motionEvent);
    }

    /* renamed from: a */
    public boolean mo9090a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.f4141kT);
        } catch (NullPointerException e) {
            return false;
        }
    }

    /* renamed from: b */
    public boolean mo9091b(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.f4142kU) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    /* renamed from: z */
    public C1198g mo9092z() {
        return this.f4143kV;
    }
}
