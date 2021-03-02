package com.google.android.gms.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.internal.kt */
class C1445kt<T extends Result> implements PendingResult<T> {

    /* renamed from: Tn */
    private final T f4196Tn;

    C1445kt(T t) {
        this.f4196Tn = t;
    }

    /* renamed from: a */
    public void mo4191a(PendingResult.C0272a aVar) {
        aVar.mo4214n(this.f4196Tn.getStatus());
    }

    public T await() {
        return this.f4196Tn;
    }

    public T await(long time, TimeUnit units) {
        return this.f4196Tn;
    }

    public void cancel() {
    }

    public boolean isCanceled() {
        return false;
    }

    public void setResultCallback(ResultCallback<T> callback) {
        callback.onResult(this.f4196Tn);
    }

    public void setResultCallback(ResultCallback<T> callback, long time, TimeUnit units) {
        callback.onResult(this.f4196Tn);
    }
}
