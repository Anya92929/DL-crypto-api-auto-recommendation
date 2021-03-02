package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.C0348n;

/* renamed from: com.google.android.gms.common.api.c */
public final class C0282c<L> {

    /* renamed from: Jl */
    private final C0282c<L>.a f630Jl;
    private volatile L mListener;

    /* renamed from: com.google.android.gms.common.api.c$a */
    private final class C0283a extends Handler {
        public C0283a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            boolean z = true;
            if (msg.what != 1) {
                z = false;
            }
            C0348n.m851K(z);
            C0282c.this.mo4279b((C0284b) msg.obj);
        }
    }

    /* renamed from: com.google.android.gms.common.api.c$b */
    public interface C0284b<L> {
        /* renamed from: d */
        void mo4282d(L l);

        /* renamed from: gs */
        void mo4283gs();
    }

    C0282c(Looper looper, L l) {
        this.f630Jl = new C0283a(looper);
        this.mListener = C0348n.m857b(l, (Object) "Listener must not be null");
    }

    /* renamed from: a */
    public void mo4278a(C0284b<L> bVar) {
        C0348n.m857b(bVar, (Object) "Notifier must not be null");
        this.f630Jl.sendMessage(this.f630Jl.obtainMessage(1, bVar));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4279b(C0284b<L> bVar) {
        L l = this.mListener;
        if (l == null) {
            bVar.mo4283gs();
            return;
        }
        try {
            bVar.mo4282d(l);
        } catch (Exception e) {
            Log.w("ListenerHolder", "Notifying listener failed", e);
            bVar.mo4283gs();
        }
    }

    public void clear() {
        this.mListener = null;
    }
}
