package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzpj;
import com.google.android.gms.internal.zzpm;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzqd;
import com.google.android.gms.internal.zzqo;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzc {

    /* renamed from: a */
    private final Context f4345a;

    /* renamed from: b */
    private final zzqo f4346b;

    /* renamed from: c */
    private final Api f4347c;

    /* renamed from: d */
    private final Api.ApiOptions f4348d;

    /* renamed from: e */
    private final zzpj f4349e;

    /* renamed from: f */
    private final Looper f4350f;

    /* renamed from: g */
    private final int f4351g;

    /* renamed from: h */
    private final zzqc f4352h;

    /* renamed from: i */
    private final GoogleApiClient f4353i;

    /* renamed from: j */
    private final AtomicBoolean f4354j;

    /* renamed from: k */
    private final AtomicInteger f4355k;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzc(Context context, Api api, Api.ApiOptions apiOptions) {
        this(context, api, apiOptions, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
    }

    public zzc(Context context, Api api, Api.ApiOptions apiOptions, Looper looper) {
        this.f4354j = new AtomicBoolean(false);
        this.f4355k = new AtomicInteger(0);
        zzab.zzb((Object) context, (Object) "Null context is not permitted.");
        zzab.zzb((Object) api, (Object) "Api must not be null.");
        zzab.zzb((Object) looper, (Object) "Looper must not be null.");
        this.f4345a = context.getApplicationContext();
        this.f4347c = api;
        this.f4348d = apiOptions;
        this.f4350f = looper;
        this.f4346b = new zzqo();
        this.f4349e = new zzpj(this.f4347c, this.f4348d);
        this.f4353i = new zzqd(this);
        Pair zza = zzqc.zza(this.f4345a, this);
        this.f4352h = (zzqc) zza.first;
        this.f4351g = ((Integer) zza.second).intValue();
    }

    /* renamed from: a */
    private zzpm.zza m5977a(int i, zzpm.zza zza) {
        zza.zzaow();
        this.f4352h.zza(this, i, zza);
        return zza;
    }

    /* renamed from: a */
    private Task m5978a(int i, zzqw zzqw) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f4352h.zza(this, i, zzqw, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public Context getApplicationContext() {
        return this.f4345a;
    }

    public int getInstanceId() {
        return this.f4351g;
    }

    public Looper getLooper() {
        return this.f4350f;
    }

    public void release() {
        boolean z = true;
        if (!this.f4354j.getAndSet(true)) {
            this.f4346b.release();
            zzqc zzqc = this.f4352h;
            int i = this.f4351g;
            if (this.f4355k.get() <= 0) {
                z = false;
            }
            zzqc.zzd(i, z);
        }
    }

    public zzpm.zza zza(zzpm.zza zza) {
        return m5977a(0, zza);
    }

    public Task zza(zzqw zzqw) {
        return m5978a(0, zzqw);
    }

    public void zzanx() {
        this.f4355k.incrementAndGet();
    }

    public void zzany() {
        if (this.f4355k.decrementAndGet() == 0 && this.f4354j.get()) {
            this.f4352h.zzd(this.f4351g, false);
        }
    }

    public Api zzanz() {
        return this.f4347c;
    }

    public Api.ApiOptions zzaoa() {
        return this.f4348d;
    }

    public zzpj zzaob() {
        return this.f4349e;
    }

    public GoogleApiClient zzaoc() {
        return this.f4353i;
    }

    public zzpm.zza zzb(zzpm.zza zza) {
        return m5977a(1, zza);
    }

    public Task zzb(zzqw zzqw) {
        return m5978a(1, zzqw);
    }
}
