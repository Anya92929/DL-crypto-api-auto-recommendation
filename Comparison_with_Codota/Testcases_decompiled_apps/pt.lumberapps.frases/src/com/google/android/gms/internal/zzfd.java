package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.Map;

@zzin
public abstract class zzfd implements Releasable {

    /* renamed from: a */
    protected Context f6172a;

    /* renamed from: b */
    protected String f6173b;

    /* renamed from: c */
    protected WeakReference f6174c;

    public zzfd(zzlh zzlh) {
        this.f6172a = zzlh.getContext();
        this.f6173b = zzu.zzfq().zzg(this.f6172a, zzlh.zzum().zzcs);
        this.f6174c = new WeakReference(zzlh);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7023a(String str, Map map) {
        zzlh zzlh = (zzlh) this.f6174c.get();
        if (zzlh != null) {
            zzlh.zza(str, map);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m7024b(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1396664534:
                if (str.equals("badUrl")) {
                    c = 6;
                    break;
                }
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    c = 2;
                    break;
                }
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    c = 7;
                    break;
                }
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    c = 3;
                    break;
                }
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    c = 1;
                    break;
                }
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    c = 8;
                    break;
                }
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    c = 9;
                    break;
                }
                break;
            case 96784904:
                if (str.equals("error")) {
                    c = 0;
                    break;
                }
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    c = 5;
                    break;
                }
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
                return "internal";
            case 4:
            case 5:
                return "io";
            case 6:
            case 7:
                return "network";
            case 8:
            case 9:
                return "policy";
            default:
                return "internal";
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo8357a(String str) {
        return zzm.zziw().zzcu(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8358a(String str, String str2, int i) {
        zza.zzcnb.post(new C1573gc(this, str, str2, i));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8359a(String str, String str2, int i, int i2, boolean z) {
        zza.zzcnb.post(new C1572gb(this, str, str2, i, i2, z));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8360a(String str, String str2, String str3, String str4) {
        zza.zzcnb.post(new C1574gd(this, str, str2, str3, str4));
    }

    public abstract void abort();

    public void release() {
    }

    public abstract boolean zzaz(String str);
}
