package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public class zzg extends Thread {

    /* renamed from: a */
    private final BlockingQueue f6211a;

    /* renamed from: b */
    private final zzf f6212b;

    /* renamed from: c */
    private final zzb f6213c;

    /* renamed from: d */
    private final zzn f6214d;

    /* renamed from: e */
    private volatile boolean f6215e = false;

    public zzg(BlockingQueue blockingQueue, zzf zzf, zzb zzb, zzn zzn) {
        super("VolleyNetworkDispatcher");
        this.f6211a = blockingQueue;
        this.f6212b = zzf;
        this.f6213c = zzb;
        this.f6214d = zzn;
    }

    @TargetApi(14)
    /* renamed from: a */
    private void m7071a(zzk zzk) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(zzk.zzf());
        }
    }

    /* renamed from: a */
    private void m7072a(zzk zzk, zzr zzr) {
        this.f6214d.zza(zzk, zzk.mo8634a(zzr));
    }

    public void quit() {
        this.f6215e = true;
        interrupt();
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                zzk zzk = (zzk) this.f6211a.take();
                try {
                    zzk.zzc("network-queue-take");
                    if (zzk.isCanceled()) {
                        zzk.mo8637b("network-discard-cancelled");
                    } else {
                        m7071a(zzk);
                        zzi zza = this.f6212b.zza(zzk);
                        zzk.zzc("network-http-complete");
                        if (!zza.zzaa || !zzk.zzv()) {
                            zzm a = zzk.mo7492a(zza);
                            zzk.zzc("network-parse-complete");
                            if (zzk.zzq() && a.zzbf != null) {
                                this.f6213c.zza(zzk.zzg(), a.zzbf);
                                zzk.zzc("network-cache-written");
                            }
                            zzk.zzu();
                            this.f6214d.zza(zzk, a);
                        } else {
                            zzk.mo8637b("not-modified");
                        }
                    }
                } catch (zzr e) {
                    e.mo9015a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    m7072a(zzk, e);
                } catch (Exception e2) {
                    zzs.zza(e2, "Unhandled exception %s", e2.toString());
                    zzr zzr = new zzr((Throwable) e2);
                    zzr.mo9015a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.f6214d.zza(zzk, zzr);
                }
            } catch (InterruptedException e3) {
                if (this.f6215e) {
                    return;
                }
            }
        }
    }
}
