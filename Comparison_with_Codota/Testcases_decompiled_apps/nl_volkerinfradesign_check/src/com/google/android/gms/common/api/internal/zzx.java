package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
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
import java.lang.ref.WeakReference;

public class zzx<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ResultTransform<? super R, ? extends Result> f2815a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public zzx<? extends Result> f2816b = null;

    /* renamed from: c */
    private ResultCallbacks<? super R> f2817c = null;

    /* renamed from: d */
    private PendingResult<R> f2818d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Object f2819e = new Object();

    /* renamed from: f */
    private Status f2820f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final WeakReference<GoogleApiClient> f2821g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final zzx<R>.C0000a f2822h;

    /* renamed from: com.google.android.gms.common.api.internal.zzx$a */
    final class C0719a extends Handler {
        public C0719a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    PendingResult pendingResult = (PendingResult) message.obj;
                    synchronized (zzx.this.f2819e) {
                        if (pendingResult == null) {
                            zzx.this.f2816b.m3834a(new Status(13, "Transform returned null"));
                        } else if (pendingResult instanceof zzt) {
                            zzx.this.f2816b.m3834a(((zzt) pendingResult).mo5228a());
                        } else {
                            zzx.this.f2816b.zza(pendingResult);
                        }
                    }
                    return;
                case 1:
                    RuntimeException runtimeException = (RuntimeException) message.obj;
                    Log.e("TransformedResultImpl", "Runtime exception on the transformation worker thread: " + runtimeException.getMessage());
                    throw runtimeException;
                default:
                    Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + message.what);
                    return;
            }
        }
    }

    public zzx(WeakReference<GoogleApiClient> weakReference) {
        com.google.android.gms.common.internal.zzx.zzb(weakReference, (Object) "GoogleApiClient reference must not be null");
        this.f2821g = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) this.f2821g.get();
        this.f2822h = new C0719a(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3833a(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                Log.w("TransformedResultImpl", "Unable to release " + result, e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3834a(Status status) {
        synchronized (this.f2819e) {
            this.f2820f = status;
            m3839b(this.f2820f);
        }
    }

    /* renamed from: b */
    private void m3838b() {
        if (this.f2815a != null || this.f2817c != null) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.f2821g.get();
            if (!(this.f2815a == null || googleApiClient == null)) {
                googleApiClient.zza(this);
            }
            if (this.f2820f != null) {
                m3839b(this.f2820f);
            } else if (this.f2818d != null) {
                this.f2818d.setResultCallback(this);
            }
        }
    }

    /* renamed from: b */
    private void m3839b(Status status) {
        synchronized (this.f2819e) {
            if (this.f2815a != null) {
                Status onFailure = this.f2815a.onFailure(status);
                com.google.android.gms.common.internal.zzx.zzb(onFailure, (Object) "onFailure must not return null");
                this.f2816b.m3834a(onFailure);
            } else if (m3841c()) {
                this.f2817c.onFailure(status);
            }
        }
    }

    /* renamed from: c */
    private boolean m3841c() {
        return (this.f2817c == null || ((GoogleApiClient) this.f2821g.get()) == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5238a() {
        synchronized (this.f2819e) {
            this.f2817c = null;
        }
    }

    public void andFinally(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        boolean z = true;
        synchronized (this.f2819e) {
            com.google.android.gms.common.internal.zzx.zza(this.f2817c == null, (Object) "Cannot call andFinally() twice.");
            if (this.f2815a != null) {
                z = false;
            }
            com.google.android.gms.common.internal.zzx.zza(z, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f2817c = resultCallbacks;
            m3838b();
        }
    }

    public void onResult(final R r) {
        synchronized (this.f2819e) {
            if (!r.getStatus().isSuccess()) {
                m3834a(r.getStatus());
                m3833a((Result) r);
            } else if (this.f2815a != null) {
                zzs.zzpN().submit(new Runnable() {
                    @WorkerThread
                    public void run() {
                        try {
                            zzx.this.f2822h.sendMessage(zzx.this.f2822h.obtainMessage(0, zzx.this.f2815a.onSuccess(r)));
                            zzx.this.m3833a(r);
                            GoogleApiClient googleApiClient = (GoogleApiClient) zzx.this.f2821g.get();
                            if (googleApiClient != null) {
                                googleApiClient.zzb(zzx.this);
                            }
                        } catch (RuntimeException e) {
                            zzx.this.f2822h.sendMessage(zzx.this.f2822h.obtainMessage(1, e));
                            zzx.this.m3833a(r);
                            GoogleApiClient googleApiClient2 = (GoogleApiClient) zzx.this.f2821g.get();
                            if (googleApiClient2 != null) {
                                googleApiClient2.zzb(zzx.this);
                            }
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            zzx.this.m3833a(r);
                            GoogleApiClient googleApiClient3 = (GoogleApiClient) zzx.this.f2821g.get();
                            if (googleApiClient3 != null) {
                                googleApiClient3.zzb(zzx.this);
                            }
                            throw th2;
                        }
                    }
                });
            } else if (m3841c()) {
                this.f2817c.onSuccess(r);
            }
        }
    }

    @NonNull
    public <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        zzx<? extends Result> zzx;
        boolean z = true;
        synchronized (this.f2819e) {
            com.google.android.gms.common.internal.zzx.zza(this.f2815a == null, (Object) "Cannot call then() twice.");
            if (this.f2817c != null) {
                z = false;
            }
            com.google.android.gms.common.internal.zzx.zza(z, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f2815a = resultTransform;
            zzx = new zzx<>(this.f2821g);
            this.f2816b = zzx;
            m3838b();
        }
        return zzx;
    }

    public void zza(PendingResult<?> pendingResult) {
        synchronized (this.f2819e) {
            this.f2818d = pendingResult;
            m3838b();
        }
    }
}
