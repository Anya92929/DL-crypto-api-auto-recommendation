package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzm;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;

public abstract class zzk implements Comparable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1854qn f6586a;

    /* renamed from: b */
    private final int f6587b;

    /* renamed from: c */
    private final String f6588c;

    /* renamed from: d */
    private final int f6589d;

    /* renamed from: e */
    private final zzm.zza f6590e;

    /* renamed from: f */
    private Integer f6591f;

    /* renamed from: g */
    private zzl f6592g;

    /* renamed from: h */
    private boolean f6593h;

    /* renamed from: i */
    private boolean f6594i;

    /* renamed from: j */
    private boolean f6595j;

    /* renamed from: k */
    private long f6596k;

    /* renamed from: l */
    private zzo f6597l;

    /* renamed from: m */
    private zzb.zza f6598m;

    public enum zza {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public zzk(int i, String str, zzm.zza zza2) {
        this.f6586a = C1854qn.f5523a ? new C1854qn() : null;
        this.f6593h = true;
        this.f6594i = false;
        this.f6595j = false;
        this.f6596k = 0;
        this.f6598m = null;
        this.f6587b = i;
        this.f6588c = str;
        this.f6590e = zza2;
        zza((zzo) new zzd());
        this.f6589d = mo7713a(str);
    }

    /* renamed from: a */
    private static int mo7713a(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    /* renamed from: a */
    private byte[] m7291a(Map map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry entry : map.entrySet()) {
                sb.append(URLEncoder.encode((String) entry.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode((String) entry.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            String valueOf = String.valueOf(str);
            throw new RuntimeException(valueOf.length() != 0 ? "Encoding not supported: ".concat(valueOf) : new String("Encoding not supported: "), unsupportedEncodingException);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract zzm mo7492a(zzi zzi);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzr mo8634a(zzr zzr) {
        return zzr;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    /* renamed from: a */
    public Map mo8635a() {
        return mo8638c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo7494a(Object obj);

    /* access modifiers changed from: protected */
    @Deprecated
    /* renamed from: b */
    public String mo8636b() {
        return mo8640d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8637b(String str) {
        if (this.f6592g != null) {
            this.f6592g.mo8789a(this);
        }
        if (C1854qn.f5523a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new C1716lk(this, str, id));
                return;
            }
            this.f6586a.mo7684a(str, id);
            this.f6586a.mo7683a(toString());
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f6596k;
        if (elapsedRealtime >= 3000) {
            zzs.zzb("%d ms: %s", Long.valueOf(elapsedRealtime), toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Map mo8638c() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo8640d() {
        return "UTF-8";
    }

    public Map getHeaders() {
        return Collections.emptyMap();
    }

    public int getMethod() {
        return this.f6587b;
    }

    public String getUrl() {
        return this.f6588c;
    }

    public boolean isCanceled() {
        return false;
    }

    public String toString() {
        String valueOf = String.valueOf(Integer.toHexString(zzf()));
        String concat = valueOf.length() != 0 ? "0x".concat(valueOf) : new String("0x");
        String valueOf2 = String.valueOf(getUrl());
        String valueOf3 = String.valueOf(zzr());
        String valueOf4 = String.valueOf(this.f6591f);
        return new StringBuilder(String.valueOf("[ ] ").length() + 3 + String.valueOf(valueOf2).length() + String.valueOf(concat).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length()).append("[ ] ").append(valueOf2).append(" ").append(concat).append(" ").append(valueOf3).append(" ").append(valueOf4).toString();
    }

    public final zzk zza(int i) {
        this.f6591f = Integer.valueOf(i);
        return this;
    }

    public zzk zza(zzb.zza zza2) {
        this.f6598m = zza2;
        return this;
    }

    public zzk zza(zzl zzl) {
        this.f6592g = zzl;
        return this;
    }

    public zzk zza(zzo zzo) {
        this.f6597l = zzo;
        return this;
    }

    /* renamed from: zzc */
    public int compareTo(zzk zzk) {
        zza zzr = zzr();
        zza zzr2 = zzk.zzr();
        return zzr == zzr2 ? this.f6591f.intValue() - zzk.f6591f.intValue() : zzr2.ordinal() - zzr.ordinal();
    }

    public void zzc(zzr zzr) {
        if (this.f6590e != null) {
            this.f6590e.zze(zzr);
        }
    }

    public void zzc(String str) {
        if (C1854qn.f5523a) {
            this.f6586a.mo7684a(str, Thread.currentThread().getId());
        } else if (this.f6596k == 0) {
            this.f6596k = SystemClock.elapsedRealtime();
        }
    }

    public int zzf() {
        return this.f6589d;
    }

    public String zzg() {
        return getUrl();
    }

    public zzb.zza zzh() {
        return this.f6598m;
    }

    @Deprecated
    public String zzk() {
        return zzo();
    }

    @Deprecated
    public byte[] zzl() {
        Map a = mo8635a();
        if (a == null || a.size() <= 0) {
            return null;
        }
        return m7291a(a, mo8636b());
    }

    public String zzo() {
        String valueOf = String.valueOf(mo8640d());
        return valueOf.length() != 0 ? "application/x-www-form-urlencoded; charset=".concat(valueOf) : new String("application/x-www-form-urlencoded; charset=");
    }

    public byte[] zzp() {
        Map c = mo8638c();
        if (c == null || c.size() <= 0) {
            return null;
        }
        return m7291a(c, mo8640d());
    }

    public final boolean zzq() {
        return this.f6593h;
    }

    public zza zzr() {
        return zza.NORMAL;
    }

    public final int zzs() {
        return this.f6597l.zzc();
    }

    public zzo zzt() {
        return this.f6597l;
    }

    public void zzu() {
        this.f6595j = true;
    }

    public boolean zzv() {
        return this.f6595j;
    }
}
