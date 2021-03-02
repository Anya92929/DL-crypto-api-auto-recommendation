package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class zzl {

    /* renamed from: a */
    private AtomicInteger f6660a;

    /* renamed from: b */
    private final Map f6661b;

    /* renamed from: c */
    private final Set f6662c;

    /* renamed from: d */
    private final PriorityBlockingQueue f6663d;

    /* renamed from: e */
    private final PriorityBlockingQueue f6664e;

    /* renamed from: f */
    private final zzb f6665f;

    /* renamed from: g */
    private final zzf f6666g;

    /* renamed from: h */
    private final zzn f6667h;

    /* renamed from: i */
    private zzg[] f6668i;

    /* renamed from: j */
    private zzc f6669j;

    /* renamed from: k */
    private List f6670k;

    public interface zza {
        void zzg(zzk zzk);
    }

    public zzl(zzb zzb, zzf zzf) {
        this(zzb, zzf, 4);
    }

    public zzl(zzb zzb, zzf zzf, int i) {
        this(zzb, zzf, i, new zze(new Handler(Looper.getMainLooper())));
    }

    public zzl(zzb zzb, zzf zzf, int i, zzn zzn) {
        this.f6660a = new AtomicInteger();
        this.f6661b = new HashMap();
        this.f6662c = new HashSet();
        this.f6663d = new PriorityBlockingQueue();
        this.f6664e = new PriorityBlockingQueue();
        this.f6670k = new ArrayList();
        this.f6665f = zzb;
        this.f6666g = zzf;
        this.f6668i = new zzg[i];
        this.f6667h = zzn;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8789a(zzk zzk) {
        synchronized (this.f6662c) {
            this.f6662c.remove(zzk);
        }
        synchronized (this.f6670k) {
            for (zza zzg : this.f6670k) {
                zzg.zzg(zzk);
            }
        }
        if (zzk.zzq()) {
            synchronized (this.f6661b) {
                String zzg2 = zzk.zzg();
                Queue queue = (Queue) this.f6661b.remove(zzg2);
                if (queue != null) {
                    if (zzs.DEBUG) {
                        zzs.zza("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queue.size()), zzg2);
                    }
                    this.f6663d.addAll(queue);
                }
            }
        }
    }

    public int getSequenceNumber() {
        return this.f6660a.incrementAndGet();
    }

    public void start() {
        stop();
        this.f6669j = new zzc(this.f6663d, this.f6664e, this.f6665f, this.f6667h);
        this.f6669j.start();
        for (int i = 0; i < this.f6668i.length; i++) {
            zzg zzg = new zzg(this.f6664e, this.f6666g, this.f6665f, this.f6667h);
            this.f6668i[i] = zzg;
            zzg.start();
        }
    }

    public void stop() {
        if (this.f6669j != null) {
            this.f6669j.quit();
        }
        for (int i = 0; i < this.f6668i.length; i++) {
            if (this.f6668i[i] != null) {
                this.f6668i[i].quit();
            }
        }
    }

    public zzk zze(zzk zzk) {
        zzk.zza(this);
        synchronized (this.f6662c) {
            this.f6662c.add(zzk);
        }
        zzk.zza(getSequenceNumber());
        zzk.zzc("add-to-queue");
        if (!zzk.zzq()) {
            this.f6664e.add(zzk);
        } else {
            synchronized (this.f6661b) {
                String zzg = zzk.zzg();
                if (this.f6661b.containsKey(zzg)) {
                    Queue queue = (Queue) this.f6661b.get(zzg);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(zzk);
                    this.f6661b.put(zzg, queue);
                    if (zzs.DEBUG) {
                        zzs.zza("Request for cacheKey=%s is in flight, putting on hold.", zzg);
                    }
                } else {
                    this.f6661b.put(zzg, (Object) null);
                    this.f6663d.add(zzk);
                }
            }
        }
        return zzk;
    }
}
