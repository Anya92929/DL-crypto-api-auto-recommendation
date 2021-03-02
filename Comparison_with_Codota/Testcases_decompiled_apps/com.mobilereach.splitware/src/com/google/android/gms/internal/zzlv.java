package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.internal.zzlx;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class zzlv implements com.google.android.gms.clearcut.zzc {
    private static final Object zzafn = new Object();
    /* access modifiers changed from: private */
    public static final zze zzafo = new zze();
    private static final long zzafp = TimeUnit.MILLISECONDS.convert(2, TimeUnit.MINUTES);
    /* access modifiers changed from: private */
    public GoogleApiClient zzaaj;
    private final zza zzafq;
    /* access modifiers changed from: private */
    public final Object zzafr;
    /* access modifiers changed from: private */
    public long zzafs;
    private final long zzaft;
    private ScheduledFuture<?> zzafu;
    private final Runnable zzafv;
    /* access modifiers changed from: private */
    public final zzmq zzqW;

    public interface zza {
    }

    public static class zzb implements zza {
    }

    static abstract class zzc<R extends Result> extends zza.C0426zza<R, zzlw> {
        public zzc(GoogleApiClient googleApiClient) {
            super(com.google.android.gms.clearcut.zzb.zzUI, googleApiClient);
        }
    }

    final class zzd extends zzc<Status> {
        private final LogEventParcelable zzafx;

        zzd(LogEventParcelable logEventParcelable, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzafx = logEventParcelable;
        }

        public boolean equals(Object rhs) {
            if (!(rhs instanceof zzd)) {
                return false;
            }
            return this.zzafx.equals(((zzd) rhs).zzafx);
        }

        public String toString() {
            return "MethodImpl(" + this.zzafx + ")";
        }

        /* access modifiers changed from: protected */
        public void zza(zzlw zzlw) throws RemoteException {
            C02311 r0 = new zzlx.zza() {
                public void zzv(Status status) {
                    zzd.this.zza(status);
                }
            };
            try {
                zzlv.zza(this.zzafx);
                zzlw.zza(r0, this.zzafx);
            } catch (Throwable th) {
                Log.e("ClearcutLoggerApiImpl", "MessageNanoProducer " + this.zzafx.zzafl.toString() + " threw: " + th.toString());
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    private static final class zze {
        private int mSize;

        private zze() {
            this.mSize = 0;
        }

        public boolean zza(long j, TimeUnit timeUnit) throws InterruptedException {
            boolean z;
            long currentTimeMillis = System.currentTimeMillis();
            long convert = TimeUnit.MILLISECONDS.convert(j, timeUnit);
            synchronized (this) {
                while (true) {
                    if (this.mSize == 0) {
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

        public synchronized void zzoH() {
            this.mSize++;
        }

        public synchronized void zzoI() {
            if (this.mSize == 0) {
                throw new RuntimeException("too many decrements");
            }
            this.mSize--;
            if (this.mSize == 0) {
                notifyAll();
            }
        }
    }

    public zzlv() {
        this(new zzmt(), zzafp, new zzb());
    }

    public zzlv(zzmq zzmq, long j, zza zza2) {
        this.zzafr = new Object();
        this.zzafs = 0;
        this.zzafu = null;
        this.zzaaj = null;
        this.zzafv = new Runnable() {
            public void run() {
                synchronized (zzlv.this.zzafr) {
                    if (zzlv.this.zzafs <= zzlv.this.zzqW.elapsedRealtime() && zzlv.this.zzaaj != null) {
                        Log.i("ClearcutLoggerApiImpl", "disconnect managed GoogleApiClient");
                        zzlv.this.zzaaj.disconnect();
                        GoogleApiClient unused = zzlv.this.zzaaj = null;
                    }
                }
            }
        };
        this.zzqW = zzmq;
        this.zzaft = j;
        this.zzafq = zza2;
    }

    /* access modifiers changed from: private */
    public static void zza(LogEventParcelable logEventParcelable) {
        if (logEventParcelable.zzafl != null && logEventParcelable.zzafk.zzbuY.length == 0) {
            logEventParcelable.zzafk.zzbuY = logEventParcelable.zzafl.zzoF();
        }
        if (logEventParcelable.zzafm != null && logEventParcelable.zzafk.zzbvf.length == 0) {
            logEventParcelable.zzafk.zzbvf = logEventParcelable.zzafm.zzoF();
        }
        logEventParcelable.zzafi = zzsu.toByteArray(logEventParcelable.zzafk);
    }

    private zzd zzb(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable) {
        zzafo.zzoH();
        zzd zzd2 = new zzd(logEventParcelable, googleApiClient);
        zzd2.zza((PendingResult.zza) new PendingResult.zza() {
            public void zzu(Status status) {
                zzlv.zzafo.zzoI();
            }
        });
        return zzd2;
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable) {
        zza(logEventParcelable);
        return googleApiClient.zza(zzb(googleApiClient, logEventParcelable));
    }

    public boolean zza(GoogleApiClient googleApiClient, long j, TimeUnit timeUnit) {
        try {
            return zzafo.zza(j, timeUnit);
        } catch (InterruptedException e) {
            Log.e("ClearcutLoggerApiImpl", "flush interrupted");
            Thread.currentThread().interrupt();
            return false;
        }
    }
}
