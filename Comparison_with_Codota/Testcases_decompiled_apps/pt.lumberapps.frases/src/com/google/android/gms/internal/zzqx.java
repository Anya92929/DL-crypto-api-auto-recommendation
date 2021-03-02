package com.google.android.gms.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzab;
import java.lang.ref.WeakReference;

public class zzqx extends TransformedResult implements ResultCallback {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ResultTransform f6924a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public zzqx f6925b = null;

    /* renamed from: c */
    private volatile ResultCallbacks f6926c = null;

    /* renamed from: d */
    private PendingResult f6927d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Object f6928e = new Object();

    /* renamed from: f */
    private Status f6929f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final WeakReference f6930g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C1830pq f6931h;

    /* renamed from: i */
    private boolean f6932i = false;

    public zzqx(WeakReference weakReference) {
        zzab.zzb((Object) weakReference, (Object) "GoogleApiClient reference must not be null");
        this.f6930g = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) this.f6930g.get();
        this.f6931h = new C1830pq(this, googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7528a(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7529a(Status status) {
        synchronized (this.f6928e) {
            this.f6929f = status;
            m7534b(this.f6929f);
        }
    }

    /* renamed from: b */
    private void m7533b() {
        if (this.f6924a != null || this.f6926c != null) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.f6930g.get();
            if (!(this.f6932i || this.f6924a == null || googleApiClient == null)) {
                googleApiClient.zza(this);
                this.f6932i = true;
            }
            if (this.f6929f != null) {
                m7534b(this.f6929f);
            } else if (this.f6927d != null) {
                this.f6927d.setResultCallback(this);
            }
        }
    }

    /* renamed from: b */
    private void m7534b(Status status) {
        synchronized (this.f6928e) {
            if (this.f6924a != null) {
                Status onFailure = this.f6924a.onFailure(status);
                zzab.zzb((Object) onFailure, (Object) "onFailure must not return null");
                this.f6925b.m7529a(onFailure);
            } else if (m7536c()) {
                this.f6926c.onFailure(status);
            }
        }
    }

    /* renamed from: c */
    private boolean m7536c() {
        return (this.f6926c == null || ((GoogleApiClient) this.f6930g.get()) == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9006a() {
        this.f6926c = null;
    }

    public void andFinally(ResultCallbacks resultCallbacks) {
        boolean z = true;
        synchronized (this.f6928e) {
            zzab.zza(this.f6926c == null, (Object) "Cannot call andFinally() twice.");
            if (this.f6924a != null) {
                z = false;
            }
            zzab.zza(z, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f6926c = resultCallbacks;
            m7533b();
        }
    }

    public void onResult(Result result) {
        synchronized (this.f6928e) {
            if (!result.getStatus().isSuccess()) {
                m7529a(result.getStatus());
                m7528a(result);
            } else if (this.f6924a != null) {
                zzqr.zzaqc().submit(new C1829pp(this, result));
            } else if (m7536c()) {
                this.f6926c.onSuccess(result);
            }
        }
    }

    public TransformedResult then(ResultTransform resultTransform) {
        zzqx zzqx;
        boolean z = true;
        synchronized (this.f6928e) {
            zzab.zza(this.f6924a == null, (Object) "Cannot call then() twice.");
            if (this.f6926c != null) {
                z = false;
            }
            zzab.zza(z, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f6924a = resultTransform;
            zzqx = new zzqx(this.f6930g);
            this.f6925b = zzqx;
            m7533b();
        }
        return zzqx;
    }

    public void zza(PendingResult pendingResult) {
        synchronized (this.f6928e) {
            this.f6927d = pendingResult;
            m7533b();
        }
    }
}
