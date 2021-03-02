package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.p000v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.C0325e;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.ClientSettings;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.gms.common.api.b */
final class C0274b implements GoogleApiClient {

    /* renamed from: IB */
    private final Looper f601IB;
    /* access modifiers changed from: private */

    /* renamed from: IO */
    public final Lock f602IO = new ReentrantLock();

    /* renamed from: IP */
    private final Condition f603IP = this.f602IO.newCondition();

    /* renamed from: IQ */
    private final C0325e f604IQ;

    /* renamed from: IR */
    private final int f605IR;

    /* renamed from: IS */
    final Queue<C0281c<?>> f606IS = new LinkedList();
    /* access modifiers changed from: private */

    /* renamed from: IT */
    public ConnectionResult f607IT;
    /* access modifiers changed from: private */

    /* renamed from: IU */
    public int f608IU;
    /* access modifiers changed from: private */

    /* renamed from: IV */
    public volatile int f609IV = 4;
    /* access modifiers changed from: private */

    /* renamed from: IW */
    public volatile int f610IW;

    /* renamed from: IX */
    private boolean f611IX = false;

    /* renamed from: IY */
    private int f612IY;
    /* access modifiers changed from: private */

    /* renamed from: IZ */
    public long f613IZ = 5000;

    /* renamed from: Iu */
    private final C0279a f614Iu = new C0279a() {
        /* renamed from: b */
        public void mo4272b(C0281c<?> cVar) {
            C0274b.this.f621Jg.remove(cVar);
        }
    };

    /* renamed from: Ja */
    final Handler f615Ja;
    /* access modifiers changed from: private */

    /* renamed from: Jb */
    public final Bundle f616Jb = new Bundle();

    /* renamed from: Jc */
    private final Map<Api.C0268c<?>, Api.C0266a> f617Jc = new HashMap();

    /* renamed from: Jd */
    private final List<String> f618Jd;
    /* access modifiers changed from: private */

    /* renamed from: Je */
    public boolean f619Je;

    /* renamed from: Jf */
    private final Set<C0282c<?>> f620Jf = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: Jg */
    final Set<C0281c<?>> f621Jg = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: Jh */
    private final GoogleApiClient.ConnectionCallbacks f622Jh = new GoogleApiClient.ConnectionCallbacks() {
        public void onConnected(Bundle connectionHint) {
            C0274b.this.f602IO.lock();
            try {
                if (C0274b.this.f609IV == 1) {
                    if (connectionHint != null) {
                        C0274b.this.f616Jb.putAll(connectionHint);
                    }
                    C0274b.this.m545gn();
                }
            } finally {
                C0274b.this.f602IO.unlock();
            }
        }

        public void onConnectionSuspended(int cause) {
            C0274b.this.f602IO.lock();
            try {
                C0274b.this.m536aj(cause);
                switch (cause) {
                    case 1:
                        if (!C0274b.this.m547gp()) {
                            int unused = C0274b.this.f610IW = 2;
                            C0274b.this.f615Ja.sendMessageDelayed(C0274b.this.f615Ja.obtainMessage(1), C0274b.this.f613IZ);
                            break;
                        } else {
                            C0274b.this.f602IO.unlock();
                            return;
                        }
                    case 2:
                        C0274b.this.connect();
                        break;
                }
            } finally {
                C0274b.this.f602IO.unlock();
            }
        }
    };

    /* renamed from: Ji */
    private final C0325e.C0327b f623Ji = new C0325e.C0327b() {
        /* renamed from: fD */
        public Bundle mo4273fD() {
            return null;
        }

        /* renamed from: gr */
        public boolean mo4274gr() {
            return C0274b.this.f619Je;
        }

        public boolean isConnected() {
            return C0274b.this.isConnected();
        }
    };

    /* renamed from: com.google.android.gms.common.api.b$a */
    interface C0279a {
        /* renamed from: b */
        void mo4272b(C0281c<?> cVar);
    }

    /* renamed from: com.google.android.gms.common.api.b$b */
    class C0280b extends Handler {
        C0280b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                C0274b.this.f602IO.lock();
                try {
                    if (!C0274b.this.isConnected() && !C0274b.this.isConnecting() && C0274b.this.m547gp()) {
                        C0274b.m549h(C0274b.this);
                        C0274b.this.connect();
                        C0274b.this.f602IO.unlock();
                    }
                } finally {
                    C0274b.this.f602IO.unlock();
                }
            } else {
                Log.wtf("GoogleApiClientImpl", "Don't know how to handle this message.");
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.b$c */
    interface C0281c<A extends Api.C0266a> {
        /* renamed from: a */
        void mo4208a(C0279a aVar);

        /* renamed from: b */
        void mo4209b(A a) throws DeadObjectException;

        void cancel();

        /* renamed from: gf */
        Api.C0268c<A> mo4210gf();

        /* renamed from: gk */
        int mo4211gk();

        /* renamed from: m */
        void mo4212m(Status status);
    }

    public C0274b(Context context, Looper looper, ClientSettings clientSettings, Map<Api<?>, Api.ApiOptions> map, Set<GoogleApiClient.ConnectionCallbacks> set, Set<GoogleApiClient.OnConnectionFailedListener> set2, int i) {
        this.f604IQ = new C0325e(context, looper, this.f623Ji);
        this.f601IB = looper;
        this.f615Ja = new C0280b(looper);
        this.f605IR = i;
        for (GoogleApiClient.ConnectionCallbacks registerConnectionCallbacks : set) {
            this.f604IQ.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (GoogleApiClient.OnConnectionFailedListener registerConnectionFailedListener : set2) {
            this.f604IQ.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        for (Api next : map.keySet()) {
            final Api.C0267b gd = next.mo4183gd();
            Api.ApiOptions apiOptions = map.get(next);
            this.f617Jc.put(next.mo4185gf(), m532a(gd, apiOptions, context, looper, clientSettings, this.f622Jh, new GoogleApiClient.OnConnectionFailedListener() {
                public void onConnectionFailed(ConnectionResult result) {
                    C0274b.this.f602IO.lock();
                    try {
                        if (C0274b.this.f607IT == null || gd.getPriority() < C0274b.this.f608IU) {
                            ConnectionResult unused = C0274b.this.f607IT = result;
                            int unused2 = C0274b.this.f608IU = gd.getPriority();
                        }
                        C0274b.this.m545gn();
                    } finally {
                        C0274b.this.f602IO.unlock();
                    }
                }
            }));
        }
        this.f618Jd = Collections.unmodifiableList(clientSettings.getScopes());
    }

    /* renamed from: a */
    private static <C extends Api.C0266a, O> C m532a(Api.C0267b<C, O> bVar, Object obj, Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return bVar.mo3762a(context, looper, clientSettings, obj, connectionCallbacks, onConnectionFailedListener);
    }

    /* renamed from: a */
    private <A extends Api.C0266a> void m534a(C0281c<A> cVar) throws DeadObjectException {
        this.f602IO.lock();
        try {
            C0348n.m859b(cVar.mo4210gf() != null, (Object) "This task can not be executed or enqueued (it's probably a Batch or malformed)");
            this.f621Jg.add(cVar);
            cVar.mo4208a(this.f614Iu);
            if (m547gp()) {
                cVar.mo4212m(new Status(8));
                return;
            }
            cVar.mo4209b(mo4218a(cVar.mo4210gf()));
            this.f602IO.unlock();
        } finally {
            this.f602IO.unlock();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: aj */
    public void m536aj(int i) {
        this.f602IO.lock();
        try {
            if (this.f609IV != 3) {
                if (i == -1) {
                    if (isConnecting()) {
                        Iterator it = this.f606IS.iterator();
                        while (it.hasNext()) {
                            C0281c cVar = (C0281c) it.next();
                            if (cVar.mo4211gk() != 1) {
                                cVar.cancel();
                                it.remove();
                            }
                        }
                    } else {
                        this.f606IS.clear();
                    }
                    for (C0281c<?> cancel : this.f621Jg) {
                        cancel.cancel();
                    }
                    this.f621Jg.clear();
                    for (C0282c<?> clear : this.f620Jf) {
                        clear.clear();
                    }
                    this.f620Jf.clear();
                    if (this.f607IT == null && !this.f606IS.isEmpty()) {
                        this.f611IX = true;
                        return;
                    }
                }
                boolean isConnecting = isConnecting();
                boolean isConnected = isConnected();
                this.f609IV = 3;
                if (isConnecting) {
                    if (i == -1) {
                        this.f607IT = null;
                    }
                    this.f603IP.signalAll();
                }
                this.f619Je = false;
                for (Api.C0266a next : this.f617Jc.values()) {
                    if (next.isConnected()) {
                        next.disconnect();
                    }
                }
                this.f619Je = true;
                this.f609IV = 4;
                if (isConnected) {
                    if (i != -1) {
                        this.f604IQ.mo4461aB(i);
                    }
                    this.f619Je = false;
                }
            }
            this.f602IO.unlock();
        } finally {
            this.f602IO.unlock();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gn */
    public void m545gn() {
        this.f612IY--;
        if (this.f612IY != 0) {
            return;
        }
        if (this.f607IT != null) {
            this.f611IX = false;
            m536aj(3);
            if (m547gp()) {
                this.f615Ja.sendMessageDelayed(this.f615Ja.obtainMessage(1), this.f613IZ);
            } else {
                this.f604IQ.mo4462b(this.f607IT);
            }
            this.f619Je = false;
            return;
        }
        this.f609IV = 2;
        m548gq();
        this.f603IP.signalAll();
        m546go();
        if (this.f611IX) {
            this.f611IX = false;
            m536aj(-1);
            return;
        }
        this.f604IQ.mo4463d(this.f616Jb.isEmpty() ? null : this.f616Jb);
    }

    /* renamed from: go */
    private void m546go() {
        this.f602IO.lock();
        try {
            C0348n.m852a(isConnected() || m547gp(), "GoogleApiClient is not connected yet.");
            while (!this.f606IS.isEmpty()) {
                m534a(this.f606IS.remove());
            }
            this.f602IO.unlock();
        } catch (DeadObjectException e) {
            Log.w("GoogleApiClientImpl", "Service died while flushing queue", e);
        } catch (Throwable th) {
            this.f602IO.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gp */
    public boolean m547gp() {
        return this.f610IW != 0;
    }

    /* renamed from: gq */
    private void m548gq() {
        this.f602IO.lock();
        try {
            this.f610IW = 0;
            this.f615Ja.removeMessages(1);
        } finally {
            this.f602IO.unlock();
        }
    }

    /* renamed from: h */
    static /* synthetic */ int m549h(C0274b bVar) {
        int i = bVar.f610IW;
        bVar.f610IW = i - 1;
        return i;
    }

    /* renamed from: a */
    public <C extends Api.C0266a> C mo4218a(Api.C0268c<C> cVar) {
        C c = (Api.C0266a) this.f617Jc.get(cVar);
        C0348n.m857b(c, (Object) "Appropriate Api was not requested.");
        return c;
    }

    /* renamed from: a */
    public <A extends Api.C0266a, R extends Result, T extends BaseImplementation.C0269a<R, A>> T mo4219a(T t) {
        this.f602IO.lock();
        try {
            t.mo4190a(new BaseImplementation.CallbackHandler(getLooper()));
            if (isConnected()) {
                mo4221b(t);
            } else {
                this.f606IS.add(t);
            }
            return t;
        } finally {
            this.f602IO.unlock();
        }
    }

    /* renamed from: a */
    public boolean mo4220a(Scope scope) {
        return this.f618Jd.contains(scope.mo4253gt());
    }

    /* renamed from: b */
    public <A extends Api.C0266a, T extends BaseImplementation.C0269a<? extends Result, A>> T mo4221b(T t) {
        C0348n.m852a(isConnected() || m547gp(), "GoogleApiClient is not connected yet.");
        m546go();
        try {
            m534a(t);
        } catch (DeadObjectException e) {
            m536aj(1);
        }
        return t;
    }

    public ConnectionResult blockingConnect() {
        ConnectionResult connectionResult;
        C0348n.m852a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.f602IO.lock();
        try {
            connect();
            while (isConnecting()) {
                this.f603IP.await();
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.f541HE;
            } else if (this.f607IT != null) {
                connectionResult = this.f607IT;
                this.f602IO.unlock();
            } else {
                connectionResult = new ConnectionResult(13, (PendingIntent) null);
                this.f602IO.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, (PendingIntent) null);
        } finally {
            this.f602IO.unlock();
        }
        return connectionResult;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0058, code lost:
        if (isConnected() == false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        r0 = com.google.android.gms.common.ConnectionResult.f541HE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
        if (r4.f607IT == null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0066, code lost:
        r0 = r4.f607IT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0068, code lost:
        r4.f602IO.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r0 = new com.google.android.gms.common.ConnectionResult(13, (android.app.PendingIntent) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0076, code lost:
        r4.f602IO.unlock();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.common.ConnectionResult blockingConnect(long r5, java.util.concurrent.TimeUnit r7) {
        /*
            r4 = this;
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L_0x003c
            r0 = 1
        L_0x000b:
            java.lang.String r1 = "blockingConnect must not be called on the UI thread"
            com.google.android.gms.common.internal.C0348n.m852a(r0, r1)
            java.util.concurrent.locks.Lock r0 = r4.f602IO
            r0.lock()
            r4.connect()     // Catch:{ all -> 0x007c }
            long r0 = r7.toNanos(r5)     // Catch:{ all -> 0x007c }
        L_0x001c:
            boolean r2 = r4.isConnecting()     // Catch:{ all -> 0x007c }
            if (r2 == 0) goto L_0x0054
            java.util.concurrent.locks.Condition r2 = r4.f603IP     // Catch:{ InterruptedException -> 0x003e }
            long r0 = r2.awaitNanos(r0)     // Catch:{ InterruptedException -> 0x003e }
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x001c
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult     // Catch:{ InterruptedException -> 0x003e }
            r1 = 14
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ InterruptedException -> 0x003e }
            java.util.concurrent.locks.Lock r1 = r4.f602IO
            r1.unlock()
        L_0x003b:
            return r0
        L_0x003c:
            r0 = 0
            goto L_0x000b
        L_0x003e:
            r0 = move-exception
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x007c }
            r0.interrupt()     // Catch:{ all -> 0x007c }
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult     // Catch:{ all -> 0x007c }
            r1 = 15
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ all -> 0x007c }
            java.util.concurrent.locks.Lock r1 = r4.f602IO
            r1.unlock()
            goto L_0x003b
        L_0x0054:
            boolean r0 = r4.isConnected()     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0062
            com.google.android.gms.common.ConnectionResult r0 = com.google.android.gms.common.ConnectionResult.f541HE     // Catch:{ all -> 0x007c }
            java.util.concurrent.locks.Lock r1 = r4.f602IO
            r1.unlock()
            goto L_0x003b
        L_0x0062:
            com.google.android.gms.common.ConnectionResult r0 = r4.f607IT     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x006e
            com.google.android.gms.common.ConnectionResult r0 = r4.f607IT     // Catch:{ all -> 0x007c }
            java.util.concurrent.locks.Lock r1 = r4.f602IO
            r1.unlock()
            goto L_0x003b
        L_0x006e:
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult     // Catch:{ all -> 0x007c }
            r1 = 13
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ all -> 0x007c }
            java.util.concurrent.locks.Lock r1 = r4.f602IO
            r1.unlock()
            goto L_0x003b
        L_0x007c:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r4.f602IO
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.C0274b.blockingConnect(long, java.util.concurrent.TimeUnit):com.google.android.gms.common.ConnectionResult");
    }

    /* renamed from: c */
    public <L> C0282c<L> mo4224c(L l) {
        C0348n.m857b(l, (Object) "Listener must not be null");
        this.f602IO.lock();
        try {
            C0282c<L> cVar = new C0282c<>(this.f601IB, l);
            this.f620Jf.add(cVar);
            return cVar;
        } finally {
            this.f602IO.unlock();
        }
    }

    public void connect() {
        this.f602IO.lock();
        try {
            this.f611IX = false;
            if (!isConnected() && !isConnecting()) {
                this.f619Je = true;
                this.f607IT = null;
                this.f609IV = 1;
                this.f616Jb.clear();
                this.f612IY = this.f617Jc.size();
                for (Api.C0266a connect : this.f617Jc.values()) {
                    connect.connect();
                }
                this.f602IO.unlock();
            }
        } finally {
            this.f602IO.unlock();
        }
    }

    public void disconnect() {
        m548gq();
        m536aj(-1);
    }

    public Looper getLooper() {
        return this.f601IB;
    }

    public boolean isConnected() {
        return this.f609IV == 2;
    }

    public boolean isConnecting() {
        return this.f609IV == 1;
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks listener) {
        return this.f604IQ.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener listener) {
        return this.f604IQ.isConnectionFailedListenerRegistered(listener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks listener) {
        this.f604IQ.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener listener) {
        this.f604IQ.registerConnectionFailedListener(listener);
    }

    public void stopAutoManage(FragmentActivity lifecycleActivity) {
        C0348n.m852a(this.f605IR >= 0, "Called stopAutoManage but automatic lifecycle management is not enabled.");
        C0285d.m570a(lifecycleActivity).mo4287al(this.f605IR);
    }

    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks listener) {
        this.f604IQ.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener listener) {
        this.f604IQ.unregisterConnectionFailedListener(listener);
    }
}
