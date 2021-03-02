package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.C0325e;
import com.google.android.gms.common.internal.C0336j;
import com.google.android.gms.common.internal.C0339k;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.common.internal.d */
public abstract class C0316d<T extends IInterface> implements Api.C0266a, C0325e.C0327b {

    /* renamed from: Lw */
    public static final String[] f748Lw = {"service_esmobile", "service_googleme"};

    /* renamed from: Ds */
    private final String[] f749Ds;

    /* renamed from: IB */
    private final Looper f750IB;
    /* access modifiers changed from: private */

    /* renamed from: IQ */
    public final C0325e f751IQ;
    /* access modifiers changed from: private */

    /* renamed from: Lr */
    public T f752Lr;
    /* access modifiers changed from: private */

    /* renamed from: Ls */
    public final ArrayList<C0316d<T>.b<?>> f753Ls;
    /* access modifiers changed from: private */

    /* renamed from: Lt */
    public C0316d<T>.f f754Lt;

    /* renamed from: Lu */
    private volatile int f755Lu;

    /* renamed from: Lv */
    boolean f756Lv;
    /* access modifiers changed from: private */
    public final Context mContext;
    final Handler mHandler;

    /* renamed from: com.google.android.gms.common.internal.d$a */
    final class C0317a extends Handler {
        public C0317a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1 && !C0316d.this.isConnecting()) {
                C0318b bVar = (C0318b) msg.obj;
                bVar.mo4450gT();
                bVar.unregister();
            } else if (msg.what == 3) {
                C0316d.this.f751IQ.mo4462b(new ConnectionResult(((Integer) msg.obj).intValue(), (PendingIntent) null));
            } else if (msg.what == 4) {
                C0316d.this.m692az(1);
                IInterface unused = C0316d.this.f752Lr = null;
                C0316d.this.f751IQ.mo4461aB(((Integer) msg.obj).intValue());
            } else if (msg.what == 2 && !C0316d.this.isConnected()) {
                C0318b bVar2 = (C0318b) msg.obj;
                bVar2.mo4450gT();
                bVar2.unregister();
            } else if (msg.what == 2 || msg.what == 1) {
                ((C0318b) msg.obj).mo4451gU();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle this message.");
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.d$b */
    protected abstract class C0318b<TListener> {

        /* renamed from: Ly */
        private boolean f759Ly = false;
        private TListener mListener;

        public C0318b(TListener tlistener) {
            this.mListener = tlistener;
        }

        /* access modifiers changed from: protected */
        /* renamed from: g */
        public abstract void mo4449g(TListener tlistener);

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public abstract void mo4450gT();

        /* renamed from: gU */
        public void mo4451gU() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.mListener;
                if (this.f759Ly) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (tlistener != null) {
                try {
                    mo4449g(tlistener);
                } catch (RuntimeException e) {
                    mo4450gT();
                    throw e;
                }
            } else {
                mo4450gT();
            }
            synchronized (this) {
                this.f759Ly = true;
            }
            unregister();
        }

        /* renamed from: gV */
        public void mo4452gV() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        public void unregister() {
            mo4452gV();
            synchronized (C0316d.this.f753Ls) {
                C0316d.this.f753Ls.remove(this);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.d$c */
    public static final class C0319c implements GoogleApiClient.ConnectionCallbacks {

        /* renamed from: Lz */
        private final GooglePlayServicesClient.ConnectionCallbacks f760Lz;

        public C0319c(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
            this.f760Lz = connectionCallbacks;
        }

        public boolean equals(Object other) {
            return other instanceof C0319c ? this.f760Lz.equals(((C0319c) other).f760Lz) : this.f760Lz.equals(other);
        }

        public void onConnected(Bundle connectionHint) {
            this.f760Lz.onConnected(connectionHint);
        }

        public void onConnectionSuspended(int cause) {
            this.f760Lz.onDisconnected();
        }
    }

    /* renamed from: com.google.android.gms.common.internal.d$d */
    public abstract class C0320d<TListener> extends C0316d<T>.b<TListener> {

        /* renamed from: IC */
        private final DataHolder f761IC;

        public C0320d(TListener tlistener, DataHolder dataHolder) {
            super(tlistener);
            this.f761IC = dataHolder;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo4455a(TListener tlistener, DataHolder dataHolder);

        /* access modifiers changed from: protected */
        /* renamed from: g */
        public final void mo4449g(TListener tlistener) {
            mo4455a(tlistener, this.f761IC);
        }

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public void mo4450gT() {
            if (this.f761IC != null) {
                this.f761IC.close();
            }
        }

        /* renamed from: gU */
        public /* bridge */ /* synthetic */ void mo4451gU() {
            super.mo4451gU();
        }

        /* renamed from: gV */
        public /* bridge */ /* synthetic */ void mo4452gV() {
            super.mo4452gV();
        }

        public /* bridge */ /* synthetic */ void unregister() {
            super.unregister();
        }
    }

    /* renamed from: com.google.android.gms.common.internal.d$e */
    public static final class C0321e extends C0336j.C0337a {

        /* renamed from: LA */
        private C0316d f763LA;

        public C0321e(C0316d dVar) {
            this.f763LA = dVar;
        }

        /* renamed from: b */
        public void mo4456b(int i, IBinder iBinder, Bundle bundle) {
            C0348n.m857b("onPostInitComplete can be called only once per call to getServiceFromBroker", (Object) this.f763LA);
            this.f763LA.mo4429a(i, iBinder, bundle);
            this.f763LA = null;
        }
    }

    /* renamed from: com.google.android.gms.common.internal.d$f */
    final class C0322f implements ServiceConnection {
        C0322f() {
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            C0316d.this.mo4428N(binder);
        }

        public void onServiceDisconnected(ComponentName component) {
            C0316d.this.mHandler.sendMessage(C0316d.this.mHandler.obtainMessage(4, 1));
        }
    }

    /* renamed from: com.google.android.gms.common.internal.d$g */
    public static final class C0323g implements GoogleApiClient.OnConnectionFailedListener {

        /* renamed from: LB */
        private final GooglePlayServicesClient.OnConnectionFailedListener f765LB;

        public C0323g(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.f765LB = onConnectionFailedListener;
        }

        public boolean equals(Object other) {
            return other instanceof C0323g ? this.f765LB.equals(((C0323g) other).f765LB) : this.f765LB.equals(other);
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.f765LB.onConnectionFailed(result);
        }
    }

    /* renamed from: com.google.android.gms.common.internal.d$h */
    protected final class C0324h extends C0316d<T>.b<Boolean> {

        /* renamed from: LC */
        public final Bundle f766LC;

        /* renamed from: LD */
        public final IBinder f767LD;
        public final int statusCode;

        public C0324h(int i, IBinder iBinder, Bundle bundle) {
            super(true);
            this.statusCode = i;
            this.f767LD = iBinder;
            this.f766LC = bundle;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo4449g(Boolean bool) {
            if (bool == null) {
                C0316d.this.m692az(1);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    try {
                        if (C0316d.this.getServiceDescriptor().equals(this.f767LD.getInterfaceDescriptor())) {
                            IInterface unused = C0316d.this.f752Lr = C0316d.this.mo3832j(this.f767LD);
                            if (C0316d.this.f752Lr != null) {
                                C0316d.this.m692az(3);
                                C0316d.this.f751IQ.mo4464dM();
                                return;
                            }
                        }
                    } catch (RemoteException e) {
                    }
                    C0328f.m730J(C0316d.this.mContext).mo4473b(C0316d.this.getStartServiceAction(), C0316d.this.f754Lt);
                    C0322f unused2 = C0316d.this.f754Lt = null;
                    C0316d.this.m692az(1);
                    IInterface unused3 = C0316d.this.f752Lr = null;
                    C0316d.this.f751IQ.mo4462b(new ConnectionResult(8, (PendingIntent) null));
                    return;
                case 10:
                    C0316d.this.m692az(1);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    PendingIntent pendingIntent = this.f766LC != null ? (PendingIntent) this.f766LC.getParcelable("pendingIntent") : null;
                    if (C0316d.this.f754Lt != null) {
                        C0328f.m730J(C0316d.this.mContext).mo4473b(C0316d.this.getStartServiceAction(), C0316d.this.f754Lt);
                        C0322f unused4 = C0316d.this.f754Lt = null;
                    }
                    C0316d.this.m692az(1);
                    IInterface unused5 = C0316d.this.f752Lr = null;
                    C0316d.this.f751IQ.mo4462b(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: gT */
        public void mo4450gT() {
        }
    }

    protected C0316d(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this.f753Ls = new ArrayList<>();
        this.f755Lu = 1;
        this.f756Lv = false;
        this.mContext = (Context) C0348n.m861i(context);
        this.f750IB = (Looper) C0348n.m857b(looper, (Object) "Looper must not be null");
        this.f751IQ = new C0325e(context, looper, this);
        this.mHandler = new C0317a(looper);
        mo4432c(strArr);
        this.f749Ds = strArr;
        registerConnectionCallbacks((GoogleApiClient.ConnectionCallbacks) C0348n.m861i(connectionCallbacks));
        registerConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener) C0348n.m861i(onConnectionFailedListener));
    }

    @Deprecated
    protected C0316d(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this(context, context.getMainLooper(), new C0319c(connectionCallbacks), new C0323g(onConnectionFailedListener), strArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: az */
    public void m692az(int i) {
        int i2 = this.f755Lu;
        this.f755Lu = i;
        if (i2 == i) {
            return;
        }
        if (i == 3) {
            onConnected();
        } else if (i2 == 3 && i == 1) {
            onDisconnected();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: N */
    public final void mo4428N(IBinder iBinder) {
        try {
            mo3827a(C0339k.C0340a.m803Q(iBinder), new C0321e(this));
        } catch (RemoteException e) {
            Log.w("GmsClient", "service died");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4429a(int i, IBinder iBinder, Bundle bundle) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new C0324h(i, iBinder, bundle)));
    }

    @Deprecated
    /* renamed from: a */
    public final void mo4430a(C0316d<T>.b<?> bVar) {
        synchronized (this.f753Ls) {
            this.f753Ls.add(bVar);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, bVar));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo3827a(C0339k kVar, C0321e eVar) throws RemoteException;

    /* renamed from: aA */
    public void mo4431aA(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(i)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo4432c(String... strArr) {
    }

    public void connect() {
        this.f756Lv = true;
        m692az(2);
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            m692az(1);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(isGooglePlayServicesAvailable)));
            return;
        }
        if (this.f754Lt != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
            this.f752Lr = null;
            C0328f.m730J(this.mContext).mo4473b(getStartServiceAction(), this.f754Lt);
        }
        this.f754Lt = new C0322f();
        if (!C0328f.m730J(this.mContext).mo4472a(getStartServiceAction(), this.f754Lt)) {
            Log.e("GmsClient", "unable to connect to service: " + getStartServiceAction());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, 9));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: dK */
    public final void mo4433dK() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void disconnect() {
        this.f756Lv = false;
        synchronized (this.f753Ls) {
            int size = this.f753Ls.size();
            for (int i = 0; i < size; i++) {
                this.f753Ls.get(i).mo4452gV();
            }
            this.f753Ls.clear();
        }
        m692az(1);
        this.f752Lr = null;
        if (this.f754Lt != null) {
            C0328f.m730J(this.mContext).mo4473b(getStartServiceAction(), this.f754Lt);
            this.f754Lt = null;
        }
    }

    /* renamed from: fD */
    public Bundle mo4273fD() {
        return null;
    }

    /* renamed from: gR */
    public final String[] mo4434gR() {
        return this.f749Ds;
    }

    /* renamed from: gS */
    public final T mo4435gS() {
        mo4433dK();
        return this.f752Lr;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.f750IB;
    }

    /* access modifiers changed from: protected */
    public abstract String getServiceDescriptor();

    /* access modifiers changed from: protected */
    public abstract String getStartServiceAction();

    /* renamed from: gr */
    public boolean mo4274gr() {
        return this.f756Lv;
    }

    public boolean isConnected() {
        return this.f755Lu == 3;
    }

    public boolean isConnecting() {
        return this.f755Lu == 2;
    }

    @Deprecated
    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks listener) {
        return this.f751IQ.isConnectionCallbacksRegistered(new C0319c(listener));
    }

    @Deprecated
    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        return this.f751IQ.isConnectionFailedListenerRegistered(listener);
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public abstract T mo3832j(IBinder iBinder);

    /* access modifiers changed from: protected */
    public void onConnected() {
    }

    /* access modifiers changed from: protected */
    public void onDisconnected() {
    }

    @Deprecated
    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.f751IQ.registerConnectionCallbacks(new C0319c(listener));
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks listener) {
        this.f751IQ.registerConnectionCallbacks(listener);
    }

    @Deprecated
    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.f751IQ.registerConnectionFailedListener(listener);
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener listener) {
        this.f751IQ.registerConnectionFailedListener(listener);
    }

    @Deprecated
    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.f751IQ.unregisterConnectionCallbacks(new C0319c(listener));
    }

    @Deprecated
    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.f751IQ.unregisterConnectionFailedListener(listener);
    }
}
