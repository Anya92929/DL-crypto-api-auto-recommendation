package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@zzin
public class zzdk {

    /* renamed from: a */
    boolean f6119a;

    /* renamed from: b */
    private final List f6120b = new LinkedList();

    /* renamed from: c */
    private final Map f6121c = new LinkedHashMap();

    /* renamed from: d */
    private final Object f6122d = new Object();

    /* renamed from: e */
    private String f6123e;

    /* renamed from: f */
    private zzdi f6124f;

    /* renamed from: g */
    private zzdk f6125g;

    public zzdk(boolean z, String str, String str2) {
        this.f6119a = z;
        this.f6121c.put("action", str);
        this.f6121c.put("ad_format", str2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map mo8285a() {
        Map a;
        synchronized (this.f6122d) {
            zzde zzsl = zzu.zzft().zzsl();
            a = (zzsl == null || this.f6125g == null) ? this.f6121c : zzsl.mo8273a(this.f6121c, this.f6125g.mo8285a());
        }
        return a;
    }

    public boolean zza(zzdi zzdi, long j, String... strArr) {
        synchronized (this.f6122d) {
            for (String zzdi2 : strArr) {
                this.f6120b.add(new zzdi(j, zzdi2, zzdi));
            }
        }
        return true;
    }

    public boolean zza(zzdi zzdi, String... strArr) {
        if (!this.f6119a || zzdi == null) {
            return false;
        }
        return zza(zzdi, zzu.zzfu().elapsedRealtime(), strArr);
    }

    public void zzas(String str) {
        if (this.f6119a) {
            synchronized (this.f6122d) {
                this.f6123e = str;
            }
        }
    }

    public zzdi zzc(long j) {
        if (!this.f6119a) {
            return null;
        }
        return new zzdi(j, (String) null, (zzdi) null);
    }

    public void zzc(zzdk zzdk) {
        synchronized (this.f6122d) {
            this.f6125g = zzdk;
        }
    }

    public void zzh(String str, String str2) {
        zzde zzsl;
        if (this.f6119a && !TextUtils.isEmpty(str2) && (zzsl = zzu.zzft().zzsl()) != null) {
            synchronized (this.f6122d) {
                zzsl.zzaq(str).zza(this.f6121c, str, str2);
            }
        }
    }

    public zzdi zzkg() {
        return zzc(zzu.zzfu().elapsedRealtime());
    }

    public void zzkh() {
        synchronized (this.f6122d) {
            this.f6124f = zzkg();
        }
    }

    public String zzki() {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        synchronized (this.f6122d) {
            for (zzdi zzdi : this.f6120b) {
                long a = zzdi.mo8279a();
                String b = zzdi.mo8280b();
                zzdi c = zzdi.mo8281c();
                if (c != null && a > 0) {
                    sb2.append(b).append('.').append(a - c.mo8279a()).append(',');
                }
            }
            this.f6120b.clear();
            if (!TextUtils.isEmpty(this.f6123e)) {
                sb2.append(this.f6123e);
            } else if (sb2.length() > 0) {
                sb2.setLength(sb2.length() - 1);
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public zzdi zzkj() {
        zzdi zzdi;
        synchronized (this.f6122d) {
            zzdi = this.f6124f;
        }
        return zzdi;
    }
}
