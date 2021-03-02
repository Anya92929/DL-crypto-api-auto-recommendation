package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.pq */
final class C1830pq extends Handler {

    /* renamed from: a */
    final /* synthetic */ zzqx f5507a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1830pq(zzqx zzqx, Looper looper) {
        super(looper);
        this.f5507a = zzqx;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                PendingResult pendingResult = (PendingResult) message.obj;
                synchronized (this.f5507a.f6928e) {
                    if (pendingResult == null) {
                        this.f5507a.f6925b.m7529a(new Status(13, "Transform returned null"));
                    } else if (pendingResult instanceof zzqs) {
                        this.f5507a.f6925b.m7529a(((zzqs) pendingResult).mo9001a());
                    } else {
                        this.f5507a.f6925b.zza(pendingResult);
                    }
                }
                return;
            case 1:
                RuntimeException runtimeException = (RuntimeException) message.obj;
                String valueOf = String.valueOf(runtimeException.getMessage());
                Log.e("TransformedResultImpl", valueOf.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(valueOf) : new String("Runtime exception on the transformation worker thread: "));
                throw runtimeException;
            default:
                Log.e("TransformedResultImpl", new StringBuilder(70).append("TransformationResultHandler received unknown message type: ").append(message.what).toString());
                return;
        }
    }
}
