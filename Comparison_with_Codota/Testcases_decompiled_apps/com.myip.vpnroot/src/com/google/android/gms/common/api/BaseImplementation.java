package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.C0274b;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.C0333i;
import com.google.android.gms.common.internal.C0348n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BaseImplementation {

    public static abstract class AbstractPendingResult<R extends Result> implements C0270b<R>, PendingResult<R> {

        /* renamed from: Im */
        private final Object f557Im = new Object();

        /* renamed from: In */
        private final ArrayList<PendingResult.C0272a> f558In = new ArrayList<>();

        /* renamed from: Io */
        private ResultCallback<R> f559Io;

        /* renamed from: Ip */
        private volatile R f560Ip;

        /* renamed from: Iq */
        private volatile boolean f561Iq;

        /* renamed from: Ir */
        private boolean f562Ir;

        /* renamed from: Is */
        private boolean f563Is;

        /* renamed from: It */
        private C0333i f564It;
        protected CallbackHandler<R> mHandler;

        /* renamed from: mg */
        private final CountDownLatch f565mg = new CountDownLatch(1);

        AbstractPendingResult() {
        }

        public AbstractPendingResult(Looper looper) {
            this.mHandler = new CallbackHandler<>(looper);
        }

        public AbstractPendingResult(CallbackHandler<R> callbackHandler) {
            this.mHandler = callbackHandler;
        }

        /* renamed from: c */
        private void m487c(R r) {
            this.f560Ip = r;
            this.f564It = null;
            this.f565mg.countDown();
            Status status = this.f560Ip.getStatus();
            if (this.f559Io != null) {
                this.mHandler.removeTimeoutMessages();
                if (!this.f562Ir) {
                    this.mHandler.sendResultCallback(this.f559Io, m488gg());
                }
            }
            Iterator<PendingResult.C0272a> it = this.f558In.iterator();
            while (it.hasNext()) {
                it.next().mo4214n(status);
            }
            this.f558In.clear();
        }

        /* renamed from: gg */
        private R m488gg() {
            R r;
            synchronized (this.f557Im) {
                C0348n.m852a(!this.f561Iq, "Result has already been consumed.");
                C0348n.m852a(isReady(), "Result is not ready.");
                r = this.f560Ip;
                mo4198gh();
            }
            return r;
        }

        /* renamed from: gi */
        private void m489gi() {
            synchronized (this.f557Im) {
                if (!isReady()) {
                    mo4196b(mo3773c(Status.f592Jp));
                    this.f563Is = true;
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: gj */
        public void m490gj() {
            synchronized (this.f557Im) {
                if (!isReady()) {
                    mo4196b(mo3773c(Status.f594Jr));
                    this.f563Is = true;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4190a(CallbackHandler<R> callbackHandler) {
            this.mHandler = callbackHandler;
        }

        /* renamed from: a */
        public final void mo4191a(PendingResult.C0272a aVar) {
            C0348n.m852a(!this.f561Iq, "Result has already been consumed.");
            synchronized (this.f557Im) {
                if (isReady()) {
                    aVar.mo4214n(this.f560Ip.getStatus());
                } else {
                    this.f558In.add(aVar);
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo4192a(C0333i iVar) {
            synchronized (this.f557Im) {
                this.f564It = iVar;
            }
        }

        public final R await() {
            boolean z = true;
            C0348n.m852a(Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread");
            if (this.f561Iq) {
                z = false;
            }
            C0348n.m852a(z, "Result has already been consumed");
            try {
                this.f565mg.await();
            } catch (InterruptedException e) {
                m489gi();
            }
            C0348n.m852a(isReady(), "Result is not ready.");
            return m488gg();
        }

        public final R await(long time, TimeUnit units) {
            boolean z = true;
            C0348n.m852a(time <= 0 || Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread when time is greater than zero.");
            if (this.f561Iq) {
                z = false;
            }
            C0348n.m852a(z, "Result has already been consumed.");
            try {
                if (!this.f565mg.await(time, units)) {
                    m490gj();
                }
            } catch (InterruptedException e) {
                m489gi();
            }
            C0348n.m852a(isReady(), "Result is not ready.");
            return m488gg();
        }

        /* renamed from: b */
        public final void mo4196b(R r) {
            boolean z = true;
            synchronized (this.f557Im) {
                if (this.f563Is || this.f562Ir) {
                    BaseImplementation.m485a(r);
                    return;
                }
                C0348n.m852a(!isReady(), "Results have already been set");
                if (this.f561Iq) {
                    z = false;
                }
                C0348n.m852a(z, "Result has already been consumed");
                m487c(r);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public abstract R mo3773c(Status status);

        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void cancel() {
            /*
                r2 = this;
                java.lang.Object r1 = r2.f557Im
                monitor-enter(r1)
                boolean r0 = r2.f562Ir     // Catch:{ all -> 0x002c }
                if (r0 != 0) goto L_0x000b
                boolean r0 = r2.f561Iq     // Catch:{ all -> 0x002c }
                if (r0 == 0) goto L_0x000d
            L_0x000b:
                monitor-exit(r1)     // Catch:{ all -> 0x002c }
            L_0x000c:
                return
            L_0x000d:
                com.google.android.gms.common.internal.i r0 = r2.f564It     // Catch:{ all -> 0x002c }
                if (r0 == 0) goto L_0x0016
                com.google.android.gms.common.internal.i r0 = r2.f564It     // Catch:{ RemoteException -> 0x002f }
                r0.cancel()     // Catch:{ RemoteException -> 0x002f }
            L_0x0016:
                R r0 = r2.f560Ip     // Catch:{ all -> 0x002c }
                com.google.android.gms.common.api.BaseImplementation.m485a(r0)     // Catch:{ all -> 0x002c }
                r0 = 0
                r2.f559Io = r0     // Catch:{ all -> 0x002c }
                r0 = 1
                r2.f562Ir = r0     // Catch:{ all -> 0x002c }
                com.google.android.gms.common.api.Status r0 = com.google.android.gms.common.api.Status.f595Js     // Catch:{ all -> 0x002c }
                com.google.android.gms.common.api.Result r0 = r2.mo3773c((com.google.android.gms.common.api.Status) r0)     // Catch:{ all -> 0x002c }
                r2.m487c(r0)     // Catch:{ all -> 0x002c }
                monitor-exit(r1)     // Catch:{ all -> 0x002c }
                goto L_0x000c
            L_0x002c:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x002c }
                throw r0
            L_0x002f:
                r0 = move-exception
                goto L_0x0016
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.BaseImplementation.AbstractPendingResult.cancel():void");
        }

        /* access modifiers changed from: protected */
        /* renamed from: gh */
        public void mo4198gh() {
            this.f561Iq = true;
            this.f560Ip = null;
            this.f559Io = null;
        }

        public boolean isCanceled() {
            boolean z;
            synchronized (this.f557Im) {
                z = this.f562Ir;
            }
            return z;
        }

        public final boolean isReady() {
            return this.f565mg.getCount() == 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<R> r4) {
            /*
                r3 = this;
                boolean r0 = r3.f561Iq
                if (r0 != 0) goto L_0x0015
                r0 = 1
            L_0x0005:
                java.lang.String r1 = "Result has already been consumed."
                com.google.android.gms.common.internal.C0348n.m852a(r0, r1)
                java.lang.Object r1 = r3.f557Im
                monitor-enter(r1)
                boolean r0 = r3.isCanceled()     // Catch:{ all -> 0x0028 }
                if (r0 == 0) goto L_0x0017
                monitor-exit(r1)     // Catch:{ all -> 0x0028 }
            L_0x0014:
                return
            L_0x0015:
                r0 = 0
                goto L_0x0005
            L_0x0017:
                boolean r0 = r3.isReady()     // Catch:{ all -> 0x0028 }
                if (r0 == 0) goto L_0x002b
                com.google.android.gms.common.api.BaseImplementation$CallbackHandler<R> r0 = r3.mHandler     // Catch:{ all -> 0x0028 }
                com.google.android.gms.common.api.Result r2 = r3.m488gg()     // Catch:{ all -> 0x0028 }
                r0.sendResultCallback(r4, r2)     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r1)     // Catch:{ all -> 0x0028 }
                goto L_0x0014
            L_0x0028:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0028 }
                throw r0
            L_0x002b:
                r3.f559Io = r4     // Catch:{ all -> 0x0028 }
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.BaseImplementation.AbstractPendingResult.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<R> r5, long r6, java.util.concurrent.TimeUnit r8) {
            /*
                r4 = this;
                r1 = 1
                r2 = 0
                boolean r0 = r4.f561Iq
                if (r0 != 0) goto L_0x0020
                r0 = r1
            L_0x0007:
                java.lang.String r3 = "Result has already been consumed."
                com.google.android.gms.common.internal.C0348n.m852a(r0, r3)
                com.google.android.gms.common.api.BaseImplementation$CallbackHandler<R> r0 = r4.mHandler
                if (r0 == 0) goto L_0x0022
            L_0x0010:
                java.lang.String r0 = "CallbackHandler has not been set before calling setResultCallback."
                com.google.android.gms.common.internal.C0348n.m852a(r1, r0)
                java.lang.Object r1 = r4.f557Im
                monitor-enter(r1)
                boolean r0 = r4.isCanceled()     // Catch:{ all -> 0x0035 }
                if (r0 == 0) goto L_0x0024
                monitor-exit(r1)     // Catch:{ all -> 0x0035 }
            L_0x001f:
                return
            L_0x0020:
                r0 = r2
                goto L_0x0007
            L_0x0022:
                r1 = r2
                goto L_0x0010
            L_0x0024:
                boolean r0 = r4.isReady()     // Catch:{ all -> 0x0035 }
                if (r0 == 0) goto L_0x0038
                com.google.android.gms.common.api.BaseImplementation$CallbackHandler<R> r0 = r4.mHandler     // Catch:{ all -> 0x0035 }
                com.google.android.gms.common.api.Result r2 = r4.m488gg()     // Catch:{ all -> 0x0035 }
                r0.sendResultCallback(r5, r2)     // Catch:{ all -> 0x0035 }
            L_0x0033:
                monitor-exit(r1)     // Catch:{ all -> 0x0035 }
                goto L_0x001f
            L_0x0035:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0035 }
                throw r0
            L_0x0038:
                r4.f559Io = r5     // Catch:{ all -> 0x0035 }
                com.google.android.gms.common.api.BaseImplementation$CallbackHandler<R> r0 = r4.mHandler     // Catch:{ all -> 0x0035 }
                long r2 = r8.toMillis(r6)     // Catch:{ all -> 0x0035 }
                r0.sendTimeoutResultCallback(r4, r2)     // Catch:{ all -> 0x0035 }
                goto L_0x0033
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.BaseImplementation.AbstractPendingResult.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
        }
    }

    public static class CallbackHandler<R extends Result> extends Handler {
        public static final int CALLBACK_ON_COMPLETE = 1;
        public static final int CALLBACK_ON_TIMEOUT = 2;

        public CallbackHandler() {
            this(Looper.getMainLooper());
        }

        public CallbackHandler(Looper looper) {
            super(looper);
        }

        /* access modifiers changed from: protected */
        public void deliverResultCallback(ResultCallback<R> callback, R result) {
            try {
                callback.onResult(result);
            } catch (RuntimeException e) {
                BaseImplementation.m485a(result);
                throw e;
            }
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    deliverResultCallback((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    ((AbstractPendingResult) msg.obj).m490gj();
                    return;
                default:
                    Log.wtf("GoogleApi", "Don't know how to handle this message.");
                    return;
            }
        }

        public void removeTimeoutMessages() {
            removeMessages(2);
        }

        public void sendResultCallback(ResultCallback<R> callback, R result) {
            sendMessage(obtainMessage(1, new Pair(callback, result)));
        }

        public void sendTimeoutResultCallback(AbstractPendingResult<R> pendingResult, long millis) {
            sendMessageDelayed(obtainMessage(2, pendingResult), millis);
        }
    }

    /* renamed from: com.google.android.gms.common.api.BaseImplementation$a */
    public static abstract class C0269a<R extends Result, A extends Api.C0266a> extends AbstractPendingResult<R> implements C0274b.C0281c<A> {

        /* renamed from: Ik */
        private final Api.C0268c<A> f566Ik;

        /* renamed from: Iu */
        private C0274b.C0279a f567Iu;

        protected C0269a(Api.C0268c<A> cVar) {
            this.f566Ik = (Api.C0268c) C0348n.m861i(cVar);
        }

        /* renamed from: a */
        private void m498a(RemoteException remoteException) {
            mo4212m(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo3769a(A a) throws RemoteException;

        /* renamed from: a */
        public void mo4208a(C0274b.C0279a aVar) {
            this.f567Iu = aVar;
        }

        /* renamed from: b */
        public final void mo4209b(A a) throws DeadObjectException {
            if (this.mHandler == null) {
                mo4190a(new CallbackHandler(a.getLooper()));
            }
            try {
                mo3769a(a);
            } catch (DeadObjectException e) {
                m498a((RemoteException) e);
                throw e;
            } catch (RemoteException e2) {
                m498a(e2);
            }
        }

        /* renamed from: gf */
        public final Api.C0268c<A> mo4210gf() {
            return this.f566Ik;
        }

        /* access modifiers changed from: protected */
        /* renamed from: gh */
        public void mo4198gh() {
            super.mo4198gh();
            if (this.f567Iu != null) {
                this.f567Iu.mo4272b(this);
                this.f567Iu = null;
            }
        }

        /* renamed from: gk */
        public int mo4211gk() {
            return 0;
        }

        /* renamed from: m */
        public final void mo4212m(Status status) {
            C0348n.m859b(!status.isSuccess(), (Object) "Failed result must not be success");
            mo4196b(mo3773c(status));
        }
    }

    /* renamed from: com.google.android.gms.common.api.BaseImplementation$b */
    public interface C0270b<R> {
        /* renamed from: b */
        void mo4196b(R r);
    }

    /* renamed from: a */
    static void m485a(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                Log.w("GoogleApi", "Unable to release " + result, e);
            }
        }
    }
}
