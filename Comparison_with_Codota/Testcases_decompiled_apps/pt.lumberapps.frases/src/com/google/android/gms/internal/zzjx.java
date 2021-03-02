package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.zzkf;
import com.google.android.gms.internal.zzsb;
import java.lang.Thread;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Future;

@zzin
public class zzjx implements zzkf.zzb {

    /* renamed from: A */
    private long f6552A = 0;

    /* renamed from: a */
    private final Object f6553a = new Object();

    /* renamed from: b */
    private final String f6554b;

    /* renamed from: c */
    private final zzjy f6555c;

    /* renamed from: d */
    private zzcg f6556d;

    /* renamed from: e */
    private BigInteger f6557e = BigInteger.ONE;

    /* renamed from: f */
    private final HashSet f6558f = new HashSet();

    /* renamed from: g */
    private final HashMap f6559g = new HashMap();

    /* renamed from: h */
    private boolean f6560h = false;

    /* renamed from: i */
    private boolean f6561i = true;

    /* renamed from: j */
    private int f6562j = 0;

    /* renamed from: k */
    private boolean f6563k = false;

    /* renamed from: l */
    private Context f6564l;

    /* renamed from: m */
    private VersionInfoParcel f6565m;

    /* renamed from: n */
    private zzde f6566n = null;

    /* renamed from: o */
    private boolean f6567o = true;

    /* renamed from: p */
    private zzcn f6568p = null;

    /* renamed from: q */
    private zzco f6569q = null;

    /* renamed from: r */
    private zzcm f6570r = null;

    /* renamed from: s */
    private String f6571s;

    /* renamed from: t */
    private Boolean f6572t = null;

    /* renamed from: u */
    private String f6573u;

    /* renamed from: v */
    private boolean f6574v = false;

    /* renamed from: w */
    private boolean f6575w = false;

    /* renamed from: x */
    private boolean f6576x = false;

    /* renamed from: y */
    private boolean f6577y = false;

    /* renamed from: z */
    private String f6578z = "";

    public zzjx(zzkh zzkh) {
        this.f6554b = zzkh.zztf();
        this.f6555c = new zzjy(this.f6554b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8595a() {
        try {
            this.f6566n = zzu.zzfv().zza(new zzdd(this.f6564l, this.f6565m.zzcs));
        } catch (IllegalArgumentException e) {
            zzkd.zzd("Cannot initialize CSI reporter.", e);
        }
    }

    public Resources getResources() {
        if (this.f6565m.zzcnm) {
            return this.f6564l.getResources();
        }
        try {
            zzsb zza = zzsb.zza(this.f6564l, zzsb.f6978KI, ModuleDescriptor.MODULE_ID);
            if (zza != null) {
                return zza.zzbby().getResources();
            }
            return null;
        } catch (zzsb.zza e) {
            zzkd.zzd("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public String getSessionId() {
        return this.f6554b;
    }

    public Bundle zza(Context context, zzjz zzjz, String str) {
        Bundle bundle;
        synchronized (this.f6553a) {
            bundle = new Bundle();
            bundle.putBundle("app", this.f6555c.zze(context, str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.f6559g.keySet()) {
                bundle2.putBundle(str2, ((zzka) this.f6559g.get(str2)).toBundle());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f6558f.iterator();
            while (it.hasNext()) {
                arrayList.add(((zzjv) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzjz.zza(this.f6558f);
            this.f6558f.clear();
        }
        return bundle;
    }

    public void zza(zzjv zzjv) {
        synchronized (this.f6553a) {
            this.f6558f.add(zzjv);
        }
    }

    public void zza(String str, zzka zzka) {
        synchronized (this.f6553a) {
            this.f6559g.put(str, zzka);
        }
    }

    public void zza(Thread thread) {
        zzim.zza(this.f6564l, thread, this.f6565m);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzco zzaa(android.content.Context r11) {
        /*
            r10 = this;
            r2 = 0
            com.google.android.gms.internal.zzcy r1 = com.google.android.gms.internal.zzdc.zzazh
            java.lang.Object r1 = r1.get()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x001b
            boolean r1 = com.google.android.gms.common.util.zzs.zzavq()
            if (r1 == 0) goto L_0x001b
            boolean r1 = r10.zzsi()
            if (r1 == 0) goto L_0x001d
        L_0x001b:
            r1 = r2
        L_0x001c:
            return r1
        L_0x001d:
            java.lang.Object r3 = r10.f6553a
            monitor-enter(r3)
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0070 }
            if (r1 == 0) goto L_0x0028
            if (r11 != 0) goto L_0x002b
        L_0x0028:
            monitor-exit(r3)     // Catch:{ all -> 0x0070 }
            r1 = r2
            goto L_0x001c
        L_0x002b:
            com.google.android.gms.internal.zzcn r1 = r10.f6568p     // Catch:{ all -> 0x0070 }
            if (r1 != 0) goto L_0x0042
            android.content.Context r1 = r11.getApplicationContext()     // Catch:{ all -> 0x0070 }
            android.app.Application r1 = (android.app.Application) r1     // Catch:{ all -> 0x0070 }
            com.google.android.gms.internal.zzcn r2 = new com.google.android.gms.internal.zzcn     // Catch:{ all -> 0x0070 }
            if (r1 != 0) goto L_0x003d
            r0 = r11
            android.app.Application r0 = (android.app.Application) r0     // Catch:{ all -> 0x0070 }
            r1 = r0
        L_0x003d:
            r2.<init>(r1, r11)     // Catch:{ all -> 0x0070 }
            r10.f6568p = r2     // Catch:{ all -> 0x0070 }
        L_0x0042:
            com.google.android.gms.internal.zzcm r1 = r10.f6570r     // Catch:{ all -> 0x0070 }
            if (r1 != 0) goto L_0x004d
            com.google.android.gms.internal.zzcm r1 = new com.google.android.gms.internal.zzcm     // Catch:{ all -> 0x0070 }
            r1.<init>()     // Catch:{ all -> 0x0070 }
            r10.f6570r = r1     // Catch:{ all -> 0x0070 }
        L_0x004d:
            com.google.android.gms.internal.zzco r1 = r10.f6569q     // Catch:{ all -> 0x0070 }
            if (r1 != 0) goto L_0x0067
            com.google.android.gms.internal.zzco r1 = new com.google.android.gms.internal.zzco     // Catch:{ all -> 0x0070 }
            com.google.android.gms.internal.zzcn r2 = r10.f6568p     // Catch:{ all -> 0x0070 }
            com.google.android.gms.internal.zzcm r4 = r10.f6570r     // Catch:{ all -> 0x0070 }
            com.google.android.gms.internal.zzim r5 = new com.google.android.gms.internal.zzim     // Catch:{ all -> 0x0070 }
            android.content.Context r6 = r10.f6564l     // Catch:{ all -> 0x0070 }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r7 = r10.f6565m     // Catch:{ all -> 0x0070 }
            r8 = 0
            r9 = 0
            r5.<init>(r6, r7, r8, r9)     // Catch:{ all -> 0x0070 }
            r1.<init>(r2, r4, r5)     // Catch:{ all -> 0x0070 }
            r10.f6569q = r1     // Catch:{ all -> 0x0070 }
        L_0x0067:
            com.google.android.gms.internal.zzco r1 = r10.f6569q     // Catch:{ all -> 0x0070 }
            r1.zzhz()     // Catch:{ all -> 0x0070 }
            com.google.android.gms.internal.zzco r1 = r10.f6569q     // Catch:{ all -> 0x0070 }
            monitor-exit(r3)     // Catch:{ all -> 0x0070 }
            goto L_0x001c
        L_0x0070:
            r1 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0070 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzjx.zzaa(android.content.Context):com.google.android.gms.internal.zzco");
    }

    public void zzae(boolean z) {
        synchronized (this.f6553a) {
            if (this.f6567o != z) {
                zzkf.zze(this.f6564l, z);
            }
            this.f6567o = z;
            zzco zzaa = zzaa(this.f6564l);
            if (zzaa != null && !zzaa.isAlive()) {
                zzkd.zzcw("start fetching content...");
                zzaa.zzhz();
            }
        }
    }

    public void zzaf(boolean z) {
        this.f6577y = z;
    }

    public void zzag(boolean z) {
        synchronized (this.f6553a) {
            this.f6574v = z;
        }
    }

    @TargetApi(23)
    public void zzb(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (this.f6553a) {
            if (!this.f6563k) {
                this.f6564l = context.getApplicationContext();
                this.f6565m = versionInfoParcel;
                zzkf.zza(context, this);
                zzkf.zzb(context, this);
                zzkf.zzc(context, (zzkf.zzb) this);
                zzkf.zzd(context, this);
                zzkf.zze(context, (zzkf.zzb) this);
                zzkf.zzf(context, (zzkf.zzb) this);
                zza(Thread.currentThread());
                this.f6573u = zzu.zzfq().zzg(context, versionInfoParcel.zzcs);
                if (zzs.zzavy() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                    this.f6575w = true;
                }
                this.f6556d = new zzcg(context.getApplicationContext(), this.f6565m, zzu.zzfq().zzc(context, versionInfoParcel));
                mo8595a();
                zzu.zzga().zzt(this.f6564l);
                this.f6563k = true;
            }
        }
    }

    public void zzb(Boolean bool) {
        synchronized (this.f6553a) {
            this.f6572t = bool;
        }
    }

    public void zzb(Throwable th, boolean z) {
        new zzim(this.f6564l, this.f6565m, (Thread.UncaughtExceptionHandler) null, (Thread.UncaughtExceptionHandler) null).zza(th, z);
    }

    public void zzb(HashSet hashSet) {
        synchronized (this.f6553a) {
            this.f6558f.addAll(hashSet);
        }
    }

    public Future zzc(Context context, boolean z) {
        Future future;
        synchronized (this.f6553a) {
            if (z != this.f6561i) {
                this.f6561i = z;
                future = zzkf.zzc(context, z);
            } else {
                future = null;
            }
        }
        return future;
    }

    public Future zzcm(String str) {
        Future future;
        synchronized (this.f6553a) {
            if (str != null) {
                if (!str.equals(this.f6571s)) {
                    this.f6571s = str;
                    future = zzkf.zzf(this.f6564l, str);
                }
            }
            future = null;
        }
        return future;
    }

    public Future zzd(Context context, String str) {
        Future future;
        this.f6552A = zzu.zzfu().currentTimeMillis();
        synchronized (this.f6553a) {
            if (str != null) {
                if (!str.equals(this.f6578z)) {
                    this.f6578z = str;
                    future = zzkf.zza(context, str, this.f6552A);
                }
            }
            future = null;
        }
        return future;
    }

    public Future zzd(Context context, boolean z) {
        Future future;
        synchronized (this.f6553a) {
            if (z != this.f6576x) {
                this.f6576x = z;
                future = zzkf.zzf(context, z);
            } else {
                future = null;
            }
        }
        return future;
    }

    public void zzg(Bundle bundle) {
        synchronized (this.f6553a) {
            this.f6561i = bundle.containsKey("use_https") ? bundle.getBoolean("use_https") : this.f6561i;
            this.f6562j = bundle.containsKey("webview_cache_version") ? bundle.getInt("webview_cache_version") : this.f6562j;
            if (bundle.containsKey("content_url_opted_out")) {
                zzae(bundle.getBoolean("content_url_opted_out"));
            }
            if (bundle.containsKey("content_url_hashes")) {
                this.f6571s = bundle.getString("content_url_hashes");
            }
            this.f6576x = bundle.containsKey("auto_collect_location") ? bundle.getBoolean("auto_collect_location") : this.f6576x;
            this.f6578z = bundle.containsKey("app_settings_json") ? bundle.getString("app_settings_json") : this.f6578z;
            this.f6552A = bundle.containsKey("app_settings_last_update_ms") ? bundle.getLong("app_settings_last_update_ms") : 0;
        }
    }

    public boolean zzsi() {
        boolean z;
        synchronized (this.f6553a) {
            z = this.f6567o;
        }
        return z;
    }

    public String zzsj() {
        String bigInteger;
        synchronized (this.f6553a) {
            bigInteger = this.f6557e.toString();
            this.f6557e = this.f6557e.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public zzjy zzsk() {
        zzjy zzjy;
        synchronized (this.f6553a) {
            zzjy = this.f6555c;
        }
        return zzjy;
    }

    public zzde zzsl() {
        zzde zzde;
        synchronized (this.f6553a) {
            zzde = this.f6566n;
        }
        return zzde;
    }

    public boolean zzsm() {
        boolean z;
        synchronized (this.f6553a) {
            z = this.f6560h;
            this.f6560h = true;
        }
        return z;
    }

    public boolean zzsn() {
        boolean z;
        synchronized (this.f6553a) {
            z = this.f6561i || this.f6575w;
        }
        return z;
    }

    public String zzso() {
        String str;
        synchronized (this.f6553a) {
            str = this.f6573u;
        }
        return str;
    }

    public String zzsp() {
        String str;
        synchronized (this.f6553a) {
            str = this.f6571s;
        }
        return str;
    }

    public Boolean zzsq() {
        Boolean bool;
        synchronized (this.f6553a) {
            bool = this.f6572t;
        }
        return bool;
    }

    public boolean zzsr() {
        boolean z;
        synchronized (this.f6553a) {
            z = this.f6576x;
        }
        return z;
    }

    public boolean zzss() {
        return this.f6577y;
    }

    public zzjw zzst() {
        zzjw zzjw;
        synchronized (this.f6553a) {
            zzjw = new zzjw(this.f6578z, this.f6552A);
        }
        return zzjw;
    }

    public zzcg zzsu() {
        return this.f6556d;
    }

    public boolean zzsv() {
        boolean z;
        synchronized (this.f6553a) {
            z = this.f6574v;
        }
        return z;
    }
}
