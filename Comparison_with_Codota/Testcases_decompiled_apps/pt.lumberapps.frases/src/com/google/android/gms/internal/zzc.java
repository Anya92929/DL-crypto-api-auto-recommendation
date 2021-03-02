package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.internal.zzb;
import java.util.concurrent.BlockingQueue;

public class zzc extends Thread {

    /* renamed from: a */
    private static final boolean f5995a = zzs.DEBUG;

    /* renamed from: b */
    private final BlockingQueue f5996b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final BlockingQueue f5997c;

    /* renamed from: d */
    private final zzb f5998d;

    /* renamed from: e */
    private final zzn f5999e;

    /* renamed from: f */
    private volatile boolean f6000f = false;

    public zzc(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, zzb zzb, zzn zzn) {
        super("VolleyCacheDispatcher");
        this.f5996b = blockingQueue;
        this.f5997c = blockingQueue2;
        this.f5998d = zzb;
        this.f5999e = zzn;
    }

    public void quit() {
        this.f6000f = true;
        interrupt();
    }

    public void run() {
        if (f5995a) {
            zzs.zza("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f5998d.initialize();
        while (true) {
            try {
                zzk zzk = (zzk) this.f5996b.take();
                zzk.zzc("cache-queue-take");
                if (zzk.isCanceled()) {
                    zzk.mo8637b("cache-discard-canceled");
                } else {
                    zzb.zza zza = this.f5998d.zza(zzk.zzg());
                    if (zza == null) {
                        zzk.zzc("cache-miss");
                        this.f5997c.put(zzk);
                    } else if (zza.zza()) {
                        zzk.zzc("cache-hit-expired");
                        zzk.zza(zza);
                        this.f5997c.put(zzk);
                    } else {
                        zzk.zzc("cache-hit");
                        zzm a = zzk.mo7492a(new zzi(zza.data, zza.zzf));
                        zzk.zzc("cache-hit-parsed");
                        if (!zza.zzb()) {
                            this.f5999e.zza(zzk, a);
                        } else {
                            zzk.zzc("cache-hit-refresh-needed");
                            zzk.zza(zza);
                            a.zzbh = true;
                            this.f5999e.zza(zzk, a, new C1505dp(this, zzk));
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.f6000f) {
                    return;
                }
            }
        }
    }
}
