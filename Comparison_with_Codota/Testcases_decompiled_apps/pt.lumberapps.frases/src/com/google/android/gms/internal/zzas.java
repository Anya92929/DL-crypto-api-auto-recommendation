package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

public class zzas {

    /* renamed from: e */
    private static final String[] f5921e = {"/aclk", "/pcs/click"};

    /* renamed from: a */
    private String f5922a = "googleads.g.doubleclick.net";

    /* renamed from: b */
    private String f5923b = "/pagead/ads";

    /* renamed from: c */
    private String f5924c = "ad.doubleclick.net";

    /* renamed from: d */
    private String[] f5925d = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};

    /* renamed from: f */
    private zzan f5926f;

    public zzas(zzan zzan) {
        this.f5926f = zzan;
    }

    /* renamed from: a */
    private Uri m6879a(Uri uri, Context context, String str, boolean z) {
        try {
            boolean zzb = zzb(uri);
            if (zzb) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzat("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzat("Query parameter already exists: ms");
            }
            String zzb2 = z ? this.f5926f.zzb(context, str) : this.f5926f.zzb(context);
            return zzb ? m6881b(uri, "dc_ms", zzb2) : m6880a(uri, "ms", zzb2);
        } catch (UnsupportedOperationException e) {
            throw new zzat("Provided Uri is not in a valid state");
        }
    }

    /* renamed from: a */
    private Uri m6880a(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(uri2.substring(0, indexOf + 1) + str + "=" + str2 + "&" + uri2.substring(indexOf + 1)) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    /* renamed from: b */
    private Uri m6881b(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf(";adurl");
        if (indexOf != -1) {
            return Uri.parse(uri2.substring(0, indexOf + 1) + str + "=" + str2 + ";" + uri2.substring(indexOf + 1));
        }
        String encodedPath = uri.getEncodedPath();
        int indexOf2 = uri2.indexOf(encodedPath);
        return Uri.parse(uri2.substring(0, encodedPath.length() + indexOf2) + ";" + str + "=" + str2 + ";" + uri2.substring(encodedPath.length() + indexOf2));
    }

    public Uri zza(Uri uri, Context context) {
        return m6879a(uri, context, (String) null, false);
    }

    public void zza(MotionEvent motionEvent) {
        this.f5926f.zza(motionEvent);
    }

    public boolean zza(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.f5922a) && uri.getPath().equals(this.f5923b);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public zzan zzaw() {
        return this.f5926f;
    }

    public Uri zzb(Uri uri, Context context) {
        try {
            return m6879a(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new zzat("Provided Uri is not in a valid state");
        }
    }

    public void zzb(String str, String str2) {
        this.f5922a = str;
        this.f5923b = str2;
    }

    public boolean zzb(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.f5924c);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean zzc(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.f5925d) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean zzd(Uri uri) {
        if (!zzc(uri)) {
            return false;
        }
        for (String endsWith : f5921e) {
            if (uri.getPath().endsWith(endsWith)) {
                return true;
            }
        }
        return false;
    }

    public void zzk(String str) {
        this.f5925d = str.split(",");
    }
}
