package com.google.android.gms.playlog.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.playlog.internal.zza;
import com.google.android.gms.playlog.internal.zzb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzf extends zzj<zza> {

    /* renamed from: b */
    private final String f3580b;

    /* renamed from: c */
    private final zzd f3581c;

    /* renamed from: d */
    private final zzb f3582d = new zzb();

    /* renamed from: e */
    private final Object f3583e = new Object();

    /* renamed from: f */
    private boolean f3584f = true;

    public zzf(Context context, Looper looper, zzd zzd, com.google.android.gms.common.internal.zzf zzf) {
        super(context, looper, 24, zzf, zzd, zzd);
        this.f3580b = context.getPackageName();
        this.f3581c = (zzd) zzx.zzz(zzd);
        this.f3581c.zza(this);
    }

    /* renamed from: a */
    private void m4235a() {
        PlayLoggerContext playLoggerContext;
        zzb.zzab(!this.f3584f);
        if (!this.f3582d.isEmpty()) {
            PlayLoggerContext playLoggerContext2 = null;
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<zzb.zza> it = this.f3582d.zzEU().iterator();
                while (it.hasNext()) {
                    zzb.zza next = it.next();
                    if (next.zzbdI != null) {
                        ((zza) zzqJ()).zza(this.f3580b, next.zzbdG, zzsu.toByteArray(next.zzbdI));
                    } else {
                        if (next.zzbdG.equals(playLoggerContext2)) {
                            arrayList.add(next.zzbdH);
                            playLoggerContext = playLoggerContext2;
                        } else {
                            if (!arrayList.isEmpty()) {
                                ((zza) zzqJ()).zza(this.f3580b, playLoggerContext2, (List<LogEvent>) arrayList);
                                arrayList.clear();
                            }
                            PlayLoggerContext playLoggerContext3 = next.zzbdG;
                            arrayList.add(next.zzbdH);
                            playLoggerContext = playLoggerContext3;
                        }
                        playLoggerContext2 = playLoggerContext;
                    }
                }
                if (!arrayList.isEmpty()) {
                    ((zza) zzqJ()).zza(this.f3580b, playLoggerContext2, (List<LogEvent>) arrayList);
                }
                this.f3582d.clear();
            } catch (RemoteException e) {
                Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
            }
        }
    }

    /* renamed from: a */
    private void m4236a(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        this.f3582d.zza(playLoggerContext, logEvent);
    }

    /* renamed from: b */
    private void m4237b(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        try {
            m4235a();
            ((zza) zzqJ()).zza(this.f3580b, playLoggerContext, logEvent);
        } catch (RemoteException e) {
            Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
            m4236a(playLoggerContext, logEvent);
        } catch (IllegalStateException e2) {
            Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
            m4236a(playLoggerContext, logEvent);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7268a(boolean z) {
        synchronized (this.f3583e) {
            boolean z2 = this.f3584f;
            this.f3584f = z;
            if (z2 && !this.f3584f) {
                m4235a();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() {
        /*
            r3 = this;
            java.lang.Object r1 = r3.f3583e
            monitor-enter(r1)
            boolean r0 = r3.isConnecting()     // Catch:{ all -> 0x001c }
            if (r0 != 0) goto L_0x000f
            boolean r0 = r3.isConnected()     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0011
        L_0x000f:
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
        L_0x0010:
            return
        L_0x0011:
            com.google.android.gms.playlog.internal.zzd r0 = r3.f3581c     // Catch:{ all -> 0x001c }
            r2 = 1
            r0.zzat(r2)     // Catch:{ all -> 0x001c }
            r3.zzqG()     // Catch:{ all -> 0x001c }
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
            goto L_0x0010
        L_0x001c:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.playlog.internal.zzf.start():void");
    }

    public void stop() {
        synchronized (this.f3583e) {
            this.f3581c.zzat(false);
            disconnect();
        }
    }

    public void zzb(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        synchronized (this.f3583e) {
            if (this.f3584f) {
                m4236a(playLoggerContext, logEvent);
            } else {
                m4237b(playLoggerContext, logEvent);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdO */
    public zza zzW(IBinder iBinder) {
        return zza.C2024zza.zzdN(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.playlog.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }
}
