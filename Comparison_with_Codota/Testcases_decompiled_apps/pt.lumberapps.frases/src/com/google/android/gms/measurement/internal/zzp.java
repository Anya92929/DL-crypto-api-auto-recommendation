package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.measurement.AppMeasurement;

public class zzp extends C1923c {

    /* renamed from: a */
    private final String f7297a = zzbsf().mo9465a();

    /* renamed from: b */
    private final char f7298b;

    /* renamed from: c */
    private final long f7299c = zzbsf().zzbpz();

    /* renamed from: d */
    private final zza f7300d;

    /* renamed from: e */
    private final zza f7301e;

    /* renamed from: f */
    private final zza f7302f;

    /* renamed from: g */
    private final zza f7303g;

    /* renamed from: h */
    private final zza f7304h;

    /* renamed from: i */
    private final zza f7305i;

    /* renamed from: j */
    private final zza f7306j;

    /* renamed from: k */
    private final zza f7307k;

    /* renamed from: l */
    private final zza f7308l;

    public class zza {

        /* renamed from: b */
        private final int f7310b;

        /* renamed from: c */
        private final boolean f7311c;

        /* renamed from: d */
        private final boolean f7312d;

        zza(int i, boolean z, boolean z2) {
            this.f7310b = i;
            this.f7311c = z;
            this.f7312d = z2;
        }

        public void log(String str) {
            zzp.this.mo9591a(this.f7310b, this.f7311c, this.f7312d, str, (Object) null, (Object) null, (Object) null);
        }

        public void zzd(String str, Object obj, Object obj2, Object obj3) {
            zzp.this.mo9591a(this.f7310b, this.f7311c, this.f7312d, str, obj, obj2, obj3);
        }

        public void zze(String str, Object obj, Object obj2) {
            zzp.this.mo9591a(this.f7310b, this.f7311c, this.f7312d, str, obj, obj2, (Object) null);
        }

        public void zzj(String str, Object obj) {
            zzp.this.mo9591a(this.f7310b, this.f7311c, this.f7312d, str, obj, (Object) null, (Object) null);
        }
    }

    zzp(zzx zzx) {
        super(zzx);
        if (zzbsf().zzabd()) {
            this.f7298b = zzbsf().zzabc() ? 'P' : 'C';
        } else {
            this.f7298b = zzbsf().zzabc() ? 'p' : 'c';
        }
        this.f7300d = new zza(6, false, false);
        this.f7301e = new zza(6, true, false);
        this.f7302f = new zza(6, false, true);
        this.f7303g = new zza(5, false, false);
        this.f7304h = new zza(5, true, false);
        this.f7305i = new zza(5, false, true);
        this.f7306j = new zza(4, false, false);
        this.f7307k = new zza(3, false, false);
        this.f7308l = new zza(2, false, false);
    }

    /* renamed from: a */
    private static String m7907a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    /* renamed from: a */
    static String m7908a(boolean z, Object obj) {
        StackTraceElement stackTraceElement;
        String className;
        if (obj == null) {
            return "";
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                return String.valueOf(valueOf);
            }
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            return new StringBuilder(String.valueOf(str).length() + 43 + String.valueOf(str).length()).append(str).append(Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1)))).append("...").append(str).append(Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d)).toString();
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (!(valueOf instanceof Throwable)) {
                return z ? "-" : String.valueOf(valueOf);
            }
            Throwable th = (Throwable) valueOf;
            StringBuilder sb = new StringBuilder(z ? th.getClass().getName() : th.toString());
            String a = m7907a(AppMeasurement.class.getCanonicalName());
            String a2 = m7907a(zzx.class.getCanonicalName());
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                stackTraceElement = stackTrace[i];
                if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                    String a3 = m7907a(className);
                    if (a3.equals(a) || a3.equals(a2)) {
                        sb.append(": ");
                        sb.append(stackTraceElement);
                    }
                }
                i++;
            }
            sb.append(": ");
            sb.append(stackTraceElement);
            return sb.toString();
        }
    }

    /* renamed from: a */
    static String m7909a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        String a = m7908a(z, obj);
        String a2 = m7908a(z, obj2);
        String a3 = m7908a(z, obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(a)) {
            sb.append(str2);
            sb.append(a);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a2)) {
            sb.append(str2);
            sb.append(a2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            sb.append(str2);
            sb.append(a3);
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9590a(int i, String str) {
        Log.println(i, this.f7297a, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9591a(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && mo9592a(i)) {
            mo9590a(i, m7909a(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            zzb(i, str, obj, obj2, obj3);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo9592a(int i) {
        return Log.isLoggable(this.f7297a, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo9226d() {
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public void zzb(int i, String str, Object obj, Object obj2, Object obj3) {
        zzab.zzy(str);
        zzw d = this.f7189n.mo9663d();
        if (d == null) {
            mo9590a(6, "Scheduler not set. Not logging error/warn.");
        } else if (!d.mo9337a()) {
            mo9590a(6, "Scheduler not initialized. Not logging error/warn.");
        } else if (d.mo9338b()) {
            mo9590a(6, "Scheduler shutdown. Not logging error/warn.");
        } else {
            if (i < 0) {
                i = 0;
            }
            if (i >= "01VDIWEA?".length()) {
                i = "01VDIWEA?".length() - 1;
            }
            String valueOf = String.valueOf("1");
            char charAt = "01VDIWEA?".charAt(i);
            char c = this.f7298b;
            long j = this.f7299c;
            String valueOf2 = String.valueOf(m7909a(true, str, obj, obj2, obj3));
            String sb = new StringBuilder(String.valueOf(valueOf).length() + 23 + String.valueOf(valueOf2).length()).append(valueOf).append(charAt).append(c).append(j).append(":").append(valueOf2).toString();
            if (sb.length() > 1024) {
                sb = str.substring(0, 1024);
            }
            d.zzm(new C1896an(this, sb));
        }
    }

    public /* bridge */ /* synthetic */ void zzbrs() {
        super.zzbrs();
    }

    public /* bridge */ /* synthetic */ C1889ag zzbrt() {
        return super.zzbrt();
    }

    public /* bridge */ /* synthetic */ zzac zzbru() {
        return super.zzbru();
    }

    public /* bridge */ /* synthetic */ zzn zzbrv() {
        return super.zzbrv();
    }

    public /* bridge */ /* synthetic */ zzg zzbrw() {
        return super.zzbrw();
    }

    public /* bridge */ /* synthetic */ zzad zzbrx() {
        return super.zzbrx();
    }

    public /* bridge */ /* synthetic */ zze zzbry() {
        return super.zzbry();
    }

    public /* bridge */ /* synthetic */ zzal zzbrz() {
        return super.zzbrz();
    }

    public /* bridge */ /* synthetic */ zzv zzbsa() {
        return super.zzbsa();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsb() {
        return super.zzbsb();
    }

    public /* bridge */ /* synthetic */ zzw zzbsc() {
        return super.zzbsc();
    }

    public /* bridge */ /* synthetic */ zzp zzbsd() {
        return super.zzbsd();
    }

    public /* bridge */ /* synthetic */ zzt zzbse() {
        return super.zzbse();
    }

    public /* bridge */ /* synthetic */ zzd zzbsf() {
        return super.zzbsf();
    }

    public zza zzbsv() {
        return this.f7300d;
    }

    public zza zzbsw() {
        return this.f7301e;
    }

    public zza zzbsx() {
        return this.f7303g;
    }

    public zza zzbsy() {
        return this.f7304h;
    }

    public zza zzbsz() {
        return this.f7305i;
    }

    public zza zzbta() {
        return this.f7306j;
    }

    public zza zzbtb() {
        return this.f7307k;
    }

    public zza zzbtc() {
        return this.f7308l;
    }

    public String zzbtd() {
        Pair zzadv = zzbse().f7314b.zzadv();
        if (zzadv == null || zzadv == zzt.f7313a) {
            return null;
        }
        String valueOf = String.valueOf(String.valueOf(zzadv.second));
        String str = (String) zzadv.first;
        return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
