package com.google.android.gms.internal;

import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.clearcut.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class zzpb implements zzc {

    /* renamed from: a */
    private static final Object f6756a = new Object();

    /* renamed from: b */
    private static ScheduledExecutorService f6757b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final C1783nx f6758c = new C1783nx((C1775np) null);

    /* renamed from: d */
    private static final long f6759d = TimeUnit.MILLISECONDS.convert(2, TimeUnit.MINUTES);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zze f6760e;

    /* renamed from: f */
    private final zza f6761f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Object f6762g;

    /* renamed from: h */
    private long f6763h;

    /* renamed from: i */
    private final long f6764i;

    /* renamed from: j */
    private ScheduledFuture f6765j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public GoogleApiClient f6766k;

    /* renamed from: l */
    private final Runnable f6767l;

    public interface zza {
    }

    public class zzb implements zza {
    }

    public zzpb() {
        this(new zzh(), f6759d, new zzb());
    }

    public zzpb(zze zze, long j, zza zza2) {
        this.f6762g = new Object();
        this.f6763h = 0;
        this.f6765j = null;
        this.f6766k = null;
        this.f6767l = new C1775np(this);
        this.f6760e = zze;
        this.f6764i = j;
        this.f6761f = zza2;
    }

    /* renamed from: a */
    private PendingResult m7384a(GoogleApiClient googleApiClient, C1780nu nuVar) {
        m7390b().execute(new C1778ns(this, googleApiClient, nuVar));
        return nuVar;
    }

    /* renamed from: a */
    private C1781nv m7385a(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable) {
        f6758c.mo7591a();
        C1781nv nvVar = new C1781nv(logEventParcelable, googleApiClient);
        nvVar.zza(new C1779nt(this));
        return nvVar;
    }

    /* renamed from: b */
    static /* synthetic */ long m7389b(zzpb zzpb) {
        return 0;
    }

    /* renamed from: b */
    private ScheduledExecutorService m7390b() {
        synchronized (f6756a) {
            if (f6757b == null) {
                f6757b = Executors.newSingleThreadScheduledExecutor(new C1776nq(this));
            }
        }
        return f6757b;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m7391b(LogEventParcelable logEventParcelable) {
        if (logEventParcelable.f4228qC != null && logEventParcelable.f4227qB.bkh.length == 0) {
            logEventParcelable.f4227qB.bkh = logEventParcelable.f4228qC.zzanb();
        }
        if (logEventParcelable.f4229qD != null && logEventParcelable.f4227qB.bko.length == 0) {
            logEventParcelable.f4227qB.bko = logEventParcelable.f4229qD.zzanb();
        }
        logEventParcelable.f4231qv = zzapv.zzf(logEventParcelable.f4227qB);
    }

    public PendingResult zza(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable) {
        return m7384a(googleApiClient, (C1780nu) m7385a(googleApiClient, logEventParcelable));
    }
}
