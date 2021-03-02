package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.clearcut.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.internal.zzlx;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class zzlv implements zzc {

    /* renamed from: a */
    private static final Object f3164a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final C0773c f3165b = new C0773c();

    /* renamed from: c */
    private static final long f3166c = TimeUnit.MILLISECONDS.convert(2, TimeUnit.MINUTES);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzmq f3167d;

    /* renamed from: e */
    private final zza f3168e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Object f3169f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f3170g;

    /* renamed from: h */
    private final long f3171h;

    /* renamed from: i */
    private ScheduledFuture<?> f3172i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public GoogleApiClient f3173j;

    /* renamed from: k */
    private final Runnable f3174k;

    /* renamed from: com.google.android.gms.internal.zzlv$a */
    static abstract class C0770a<R extends Result> extends zza.C2020zza<R, zzlw> {
        public C0770a(GoogleApiClient googleApiClient) {
            super(com.google.android.gms.clearcut.zzb.zzUI, googleApiClient);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlv$b */
    final class C0771b extends C0770a<Status> {

        /* renamed from: b */
        private final LogEventParcelable f3178b;

        C0771b(LogEventParcelable logEventParcelable, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.f3178b = logEventParcelable;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Status zzc(Status status) {
            return status;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void zza(zzlw zzlw) throws RemoteException {
            C07721 r0 = new zzlx.zza() {
                public void zzv(Status status) {
                    C0771b.this.zza(status);
                }
            };
            try {
                zzlv.m4040b(this.f3178b);
                zzlw.zza(r0, this.f3178b);
            } catch (Throwable th) {
                Log.e("ClearcutLoggerApiImpl", "MessageNanoProducer " + this.f3178b.zzafl.toString() + " threw: " + th.toString());
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0771b)) {
                return false;
            }
            return this.f3178b.equals(((C0771b) obj).f3178b);
        }

        public String toString() {
            return "MethodImpl(" + this.f3178b + ")";
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlv$c */
    static final class C0773c {

        /* renamed from: a */
        private int f3180a;

        private C0773c() {
            this.f3180a = 0;
        }

        /* renamed from: a */
        public synchronized void mo5870a() {
            this.f3180a++;
        }

        /* renamed from: a */
        public boolean mo5871a(long j, TimeUnit timeUnit) throws InterruptedException {
            boolean z;
            long currentTimeMillis = System.currentTimeMillis();
            long convert = TimeUnit.MILLISECONDS.convert(j, timeUnit);
            synchronized (this) {
                while (true) {
                    if (this.f3180a == 0) {
                        z = true;
                        break;
                    } else if (convert <= 0) {
                        z = false;
                        break;
                    } else {
                        wait(convert);
                        convert -= System.currentTimeMillis() - currentTimeMillis;
                    }
                }
            }
            return z;
        }

        /* renamed from: b */
        public synchronized void mo5872b() {
            if (this.f3180a == 0) {
                throw new RuntimeException("too many decrements");
            }
            this.f3180a--;
            if (this.f3180a == 0) {
                notifyAll();
            }
        }
    }

    public interface zza {
    }

    public static class zzb implements zza {
    }

    public zzlv() {
        this(new zzmt(), f3166c, new zzb());
    }

    public zzlv(zzmq zzmq, long j, zza zza2) {
        this.f3169f = new Object();
        this.f3170g = 0;
        this.f3172i = null;
        this.f3173j = null;
        this.f3174k = new Runnable() {
            public void run() {
                synchronized (zzlv.this.f3169f) {
                    if (zzlv.this.f3170g <= zzlv.this.f3167d.elapsedRealtime() && zzlv.this.f3173j != null) {
                        Log.i("ClearcutLoggerApiImpl", "disconnect managed GoogleApiClient");
                        zzlv.this.f3173j.disconnect();
                        GoogleApiClient unused = zzlv.this.f3173j = null;
                    }
                }
            }
        };
        this.f3167d = zzmq;
        this.f3171h = j;
        this.f3168e = zza2;
    }

    /* renamed from: a */
    private C0771b m4035a(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable) {
        f3165b.mo5870a();
        C0771b bVar = new C0771b(logEventParcelable, googleApiClient);
        bVar.zza((PendingResult.zza) new PendingResult.zza() {
            public void zzu(Status status) {
                zzlv.f3165b.mo5872b();
            }
        });
        return bVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m4040b(LogEventParcelable logEventParcelable) {
        if (logEventParcelable.zzafl != null && logEventParcelable.zzafk.zzbuY.length == 0) {
            logEventParcelable.zzafk.zzbuY = logEventParcelable.zzafl.zzoF();
        }
        if (logEventParcelable.zzafm != null && logEventParcelable.zzafk.zzbvf.length == 0) {
            logEventParcelable.zzafk.zzbvf = logEventParcelable.zzafm.zzoF();
        }
        logEventParcelable.zzafi = zzsu.toByteArray(logEventParcelable.zzafk);
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable) {
        m4040b(logEventParcelable);
        return googleApiClient.zza(m4035a(googleApiClient, logEventParcelable));
    }

    public boolean zza(GoogleApiClient googleApiClient, long j, TimeUnit timeUnit) {
        try {
            return f3165b.mo5871a(j, timeUnit);
        } catch (InterruptedException e) {
            Log.e("ClearcutLoggerApiImpl", "flush interrupted");
            Thread.currentThread().interrupt();
            return false;
        }
    }
}
