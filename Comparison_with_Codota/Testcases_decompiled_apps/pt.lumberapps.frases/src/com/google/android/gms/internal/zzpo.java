package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class zzpo extends PendingResult {

    /* renamed from: a */
    static final ThreadLocal f6791a = new C1793og();

    /* renamed from: b */
    protected final zza f6792b;

    /* renamed from: c */
    protected final WeakReference f6793c;

    /* renamed from: d */
    private final Object f6794d;

    /* renamed from: e */
    private final CountDownLatch f6795e;

    /* renamed from: f */
    private final ArrayList f6796f;

    /* renamed from: g */
    private ResultCallback f6797g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Result f6798h;

    /* renamed from: i */
    private C1794oh f6799i;

    /* renamed from: j */
    private volatile boolean f6800j;

    /* renamed from: k */
    private boolean f6801k;

    /* renamed from: l */
    private boolean f6802l;

    /* renamed from: m */
    private zzr f6803m;

    /* renamed from: n */
    private volatile zzqx f6804n;

    /* renamed from: o */
    private boolean f6805o;

    public class zza extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo8931a(ResultCallback resultCallback, Result result) {
            try {
                resultCallback.onResult(result);
            } catch (RuntimeException e) {
                zzpo.zze(result);
                throw e;
            }
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    mo8931a((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    ((zzpo) message.obj).zzaa(Status.f4331st);
                    return;
                default:
                    Log.wtf("BasePendingResult", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
                    return;
            }
        }

        public void zza(ResultCallback resultCallback, Result result) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, result)));
        }

        public void zza(zzpo zzpo, long j) {
            sendMessageDelayed(obtainMessage(2, zzpo), j);
        }

        public void zzaoz() {
            removeMessages(2);
        }
    }

    @Deprecated
    zzpo() {
        this.f6794d = new Object();
        this.f6795e = new CountDownLatch(1);
        this.f6796f = new ArrayList();
        this.f6805o = false;
        this.f6792b = new zza(Looper.getMainLooper());
        this.f6793c = new WeakReference((Object) null);
    }

    @Deprecated
    protected zzpo(Looper looper) {
        this.f6794d = new Object();
        this.f6795e = new CountDownLatch(1);
        this.f6796f = new ArrayList();
        this.f6805o = false;
        this.f6792b = new zza(looper);
        this.f6793c = new WeakReference((Object) null);
    }

    protected zzpo(GoogleApiClient googleApiClient) {
        this.f6794d = new Object();
        this.f6795e = new CountDownLatch(1);
        this.f6796f = new ArrayList();
        this.f6805o = false;
        this.f6792b = new zza(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.f6793c = new WeakReference(googleApiClient);
    }

    /* renamed from: a */
    private void mo8911a(Result result) {
        this.f6798h = result;
        this.f6803m = null;
        this.f6795e.countDown();
        Status status = this.f6798h.getStatus();
        if (this.f6801k) {
            this.f6797g = null;
        } else if (this.f6797g != null) {
            this.f6792b.zzaoz();
            this.f6792b.zza(this.f6797g, m7423c());
        } else if (this.f6798h instanceof Releasable) {
            this.f6799i = new C1794oh(this, (C1793og) null);
        }
        Iterator it = this.f6796f.iterator();
        while (it.hasNext()) {
            ((PendingResult.zza) it.next()).zzv(status);
        }
        this.f6796f.clear();
    }

    /* renamed from: c */
    private Result m7423c() {
        Result result;
        boolean z = true;
        synchronized (this.f6794d) {
            if (this.f6800j) {
                z = false;
            }
            zzab.zza(z, (Object) "Result has already been consumed.");
            zzab.zza(isReady(), (Object) "Result is not ready.");
            result = this.f6798h;
            this.f6798h = null;
            this.f6797g = null;
            this.f6800j = true;
        }
        mo8910a();
        return result;
    }

    public static void zze(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                Log.w("BasePendingResult", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8910a() {
    }

    public final Result await() {
        boolean z = true;
        zzab.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread");
        zzab.zza(!this.f6800j, (Object) "Result has already been consumed");
        if (this.f6804n != null) {
            z = false;
        }
        zzab.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            this.f6795e.await();
        } catch (InterruptedException e) {
            zzaa(Status.f4329sr);
        }
        zzab.zza(isReady(), (Object) "Result is not ready.");
        return m7423c();
    }

    public final Result await(long j, TimeUnit timeUnit) {
        boolean z = true;
        zzab.zza(j <= 0 || Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread when time is greater than zero.");
        zzab.zza(!this.f6800j, (Object) "Result has already been consumed.");
        if (this.f6804n != null) {
            z = false;
        }
        zzab.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            if (!this.f6795e.await(j, timeUnit)) {
                zzaa(Status.f4331st);
            }
        } catch (InterruptedException e) {
            zzaa(Status.f4329sr);
        }
        zzab.zza(isReady(), (Object) "Result is not ready.");
        return m7423c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo8925b() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
            r2 = this;
            java.lang.Object r1 = r2.f6794d
            monitor-enter(r1)
            boolean r0 = r2.f6801k     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x000b
            boolean r0 = r2.f6800j     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x000d
        L_0x000b:
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
        L_0x000c:
            return
        L_0x000d:
            com.google.android.gms.common.internal.zzr r0 = r2.f6803m     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0016
            com.google.android.gms.common.internal.zzr r0 = r2.f6803m     // Catch:{ RemoteException -> 0x002c }
            r0.cancel()     // Catch:{ RemoteException -> 0x002c }
        L_0x0016:
            com.google.android.gms.common.api.Result r0 = r2.f6798h     // Catch:{ all -> 0x0029 }
            zze(r0)     // Catch:{ all -> 0x0029 }
            r0 = 1
            r2.f6801k = r0     // Catch:{ all -> 0x0029 }
            com.google.android.gms.common.api.Status r0 = com.google.android.gms.common.api.Status.f4332su     // Catch:{ all -> 0x0029 }
            com.google.android.gms.common.api.Result r0 = r2.zzc((com.google.android.gms.common.api.Status) r0)     // Catch:{ all -> 0x0029 }
            r2.mo8911a((com.google.android.gms.common.api.Result) r0)     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            goto L_0x000c
        L_0x0029:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            throw r0
        L_0x002c:
            r0 = move-exception
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpo.cancel():void");
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.f6794d) {
            z = this.f6801k;
        }
        return z;
    }

    public final boolean isReady() {
        return this.f6795e.getCount() == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback r6) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            java.lang.Object r3 = r5.f6794d
            monitor-enter(r3)
            if (r6 != 0) goto L_0x000c
            r0 = 0
            r5.f6797g = r0     // Catch:{ all -> 0x0027 }
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
        L_0x000b:
            return
        L_0x000c:
            boolean r2 = r5.f6800j     // Catch:{ all -> 0x0027 }
            if (r2 != 0) goto L_0x002a
            r2 = r0
        L_0x0011:
            java.lang.String r4 = "Result has already been consumed."
            com.google.android.gms.common.internal.zzab.zza((boolean) r2, (java.lang.Object) r4)     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.zzqx r2 = r5.f6804n     // Catch:{ all -> 0x0027 }
            if (r2 != 0) goto L_0x002c
        L_0x001a:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.zzab.zza((boolean) r0, (java.lang.Object) r1)     // Catch:{ all -> 0x0027 }
            boolean r0 = r5.isCanceled()     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x002e
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            goto L_0x000b
        L_0x0027:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            throw r0
        L_0x002a:
            r2 = r1
            goto L_0x0011
        L_0x002c:
            r0 = r1
            goto L_0x001a
        L_0x002e:
            boolean r0 = r5.isReady()     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x003f
            com.google.android.gms.internal.zzpo$zza r0 = r5.f6792b     // Catch:{ all -> 0x0027 }
            com.google.android.gms.common.api.Result r1 = r5.m7423c()     // Catch:{ all -> 0x0027 }
            r0.zza((com.google.android.gms.common.api.ResultCallback) r6, (com.google.android.gms.common.api.Result) r1)     // Catch:{ all -> 0x0027 }
        L_0x003d:
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            goto L_0x000b
        L_0x003f:
            r5.f6797g = r6     // Catch:{ all -> 0x0027 }
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpo.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback r7, long r8, java.util.concurrent.TimeUnit r10) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            java.lang.Object r3 = r6.f6794d
            monitor-enter(r3)
            if (r7 != 0) goto L_0x000c
            r0 = 0
            r6.f6797g = r0     // Catch:{ all -> 0x0027 }
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
        L_0x000b:
            return
        L_0x000c:
            boolean r2 = r6.f6800j     // Catch:{ all -> 0x0027 }
            if (r2 != 0) goto L_0x002a
            r2 = r0
        L_0x0011:
            java.lang.String r4 = "Result has already been consumed."
            com.google.android.gms.common.internal.zzab.zza((boolean) r2, (java.lang.Object) r4)     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.zzqx r2 = r6.f6804n     // Catch:{ all -> 0x0027 }
            if (r2 != 0) goto L_0x002c
        L_0x001a:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.zzab.zza((boolean) r0, (java.lang.Object) r1)     // Catch:{ all -> 0x0027 }
            boolean r0 = r6.isCanceled()     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x002e
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            goto L_0x000b
        L_0x0027:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            throw r0
        L_0x002a:
            r2 = r1
            goto L_0x0011
        L_0x002c:
            r0 = r1
            goto L_0x001a
        L_0x002e:
            boolean r0 = r6.isReady()     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x003f
            com.google.android.gms.internal.zzpo$zza r0 = r6.f6792b     // Catch:{ all -> 0x0027 }
            com.google.android.gms.common.api.Result r1 = r6.m7423c()     // Catch:{ all -> 0x0027 }
            r0.zza((com.google.android.gms.common.api.ResultCallback) r7, (com.google.android.gms.common.api.Result) r1)     // Catch:{ all -> 0x0027 }
        L_0x003d:
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            goto L_0x000b
        L_0x003f:
            r6.f6797g = r7     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.zzpo$zza r0 = r6.f6792b     // Catch:{ all -> 0x0027 }
            long r4 = r10.toMillis(r8)     // Catch:{ all -> 0x0027 }
            r0.zza((com.google.android.gms.internal.zzpo) r6, (long) r4)     // Catch:{ all -> 0x0027 }
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpo.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
    }

    public TransformedResult then(ResultTransform resultTransform) {
        TransformedResult then;
        boolean z = true;
        zzab.zza(!this.f6800j, (Object) "Result has already been consumed.");
        synchronized (this.f6794d) {
            zzab.zza(this.f6804n == null, (Object) "Cannot call then() twice.");
            if (this.f6797g != null) {
                z = false;
            }
            zzab.zza(z, (Object) "Cannot call then() if callbacks are set.");
            this.f6805o = true;
            this.f6804n = new zzqx(this.f6793c);
            then = this.f6804n.then(resultTransform);
            if (isReady()) {
                this.f6792b.zza((ResultCallback) this.f6804n, m7423c());
            } else {
                this.f6797g = this.f6804n;
            }
        }
        return then;
    }

    public final void zza(PendingResult.zza zza2) {
        boolean z = true;
        zzab.zza(!this.f6800j, (Object) "Result has already been consumed.");
        if (zza2 == null) {
            z = false;
        }
        zzab.zzb(z, (Object) "Callback cannot be null.");
        synchronized (this.f6794d) {
            if (isReady()) {
                zza2.zzv(this.f6798h.getStatus());
            } else {
                this.f6796f.add(zza2);
            }
        }
    }

    public final void zzaa(Status status) {
        synchronized (this.f6794d) {
            if (!isReady()) {
                zzc(zzc(status));
                this.f6802l = true;
            }
        }
    }

    public Integer zzaoj() {
        return null;
    }

    public boolean zzaov() {
        boolean isCanceled;
        synchronized (this.f6794d) {
            if (((GoogleApiClient) this.f6793c.get()) == null || !this.f6805o) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public void zzaow() {
        this.f6805o = this.f6805o || ((Boolean) f6791a.get()).booleanValue();
    }

    /* access modifiers changed from: protected */
    public abstract Result zzc(Status status);

    public final void zzc(Result result) {
        boolean z = true;
        synchronized (this.f6794d) {
            if (this.f6802l || this.f6801k || (isReady() && mo8925b())) {
                zze(result);
                return;
            }
            zzab.zza(!isReady(), (Object) "Results have already been set");
            if (this.f6800j) {
                z = false;
            }
            zzab.zza(z, (Object) "Result has already been consumed");
            mo8911a(result);
        }
    }
}
