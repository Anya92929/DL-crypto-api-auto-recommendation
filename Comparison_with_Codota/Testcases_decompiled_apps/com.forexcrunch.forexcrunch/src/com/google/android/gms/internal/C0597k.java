package com.google.android.gms.internal;

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
import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.internal.C0609o;
import com.google.android.gms.internal.C0612p;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.k */
public abstract class C0597k<T extends IInterface> implements GooglePlayServicesClient {

    /* renamed from: bD */
    public static final String[] f1389bD = {"service_esmobile", "service_googleme"};

    /* renamed from: bA */
    boolean f1390bA = false;

    /* renamed from: bB */
    boolean f1391bB = false;
    /* access modifiers changed from: private */

    /* renamed from: bC */
    public final Object f1392bC = new Object();
    /* access modifiers changed from: private */

    /* renamed from: bs */
    public T f1393bs;
    /* access modifiers changed from: private */

    /* renamed from: bt */
    public ArrayList<GooglePlayServicesClient.ConnectionCallbacks> f1394bt;

    /* renamed from: bu */
    final ArrayList<GooglePlayServicesClient.ConnectionCallbacks> f1395bu = new ArrayList<>();

    /* renamed from: bv */
    private boolean f1396bv = false;

    /* renamed from: bw */
    private ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> f1397bw;

    /* renamed from: bx */
    private boolean f1398bx = false;
    /* access modifiers changed from: private */

    /* renamed from: by */
    public final ArrayList<C0597k<T>.b<?>> f1399by = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: bz */
    public C0597k<T>.e f1400bz;

    /* renamed from: f */
    private final String[] f1401f;
    /* access modifiers changed from: private */
    public final Context mContext;
    final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.k$a */
    final class C0598a extends Handler {
        public C0598a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what != 1 || C0597k.this.isConnecting()) {
                synchronized (C0597k.this.f1392bC) {
                    C0597k.this.f1391bB = false;
                }
                if (msg.what == 3) {
                    C0597k.this.mo4590a(new ConnectionResult(((Integer) msg.obj).intValue(), (PendingIntent) null));
                } else if (msg.what == 4) {
                    synchronized (C0597k.this.f1394bt) {
                        if (C0597k.this.f1390bA && C0597k.this.isConnected() && C0597k.this.f1394bt.contains(msg.obj)) {
                            ((GooglePlayServicesClient.ConnectionCallbacks) msg.obj).onConnected(C0597k.this.mo4640z());
                        }
                    }
                } else if (msg.what == 2 && !C0597k.this.isConnected()) {
                    C0599b bVar = (C0599b) msg.obj;
                    bVar.mo4647d();
                    bVar.unregister();
                } else if (msg.what == 2 || msg.what == 1) {
                    ((C0599b) msg.obj).mo5436D();
                } else {
                    Log.wtf("GmsClient", "Don't know how to handle this message.");
                }
            } else {
                C0599b bVar2 = (C0599b) msg.obj;
                bVar2.mo4647d();
                bVar2.unregister();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.k$b */
    protected abstract class C0599b<TListener> {

        /* renamed from: bF */
        private boolean f1404bF = false;
        private TListener mListener;

        public C0599b(TListener tlistener) {
            this.mListener = tlistener;
        }

        /* renamed from: D */
        public void mo5436D() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.mListener;
                if (this.f1404bF) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (tlistener != null) {
                try {
                    mo4646a(tlistener);
                } catch (RuntimeException e) {
                    mo4647d();
                    throw e;
                }
            } else {
                mo4647d();
            }
            synchronized (this) {
                this.f1404bF = true;
            }
            unregister();
        }

        /* renamed from: E */
        public void mo5437E() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo4646a(TListener tlistener);

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public abstract void mo4647d();

        public void unregister() {
            mo5437E();
            synchronized (C0597k.this.f1399by) {
                C0597k.this.f1399by.remove(this);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.k$c */
    public abstract class C0600c<TListener> extends C0597k<T>.b<TListener> {

        /* renamed from: S */
        private final C0344d f1405S;

        public C0600c(TListener tlistener, C0344d dVar) {
            super(tlistener);
            this.f1405S = dVar;
        }

        /* renamed from: D */
        public /* bridge */ /* synthetic */ void mo5436D() {
            super.mo5436D();
        }

        /* renamed from: E */
        public /* bridge */ /* synthetic */ void mo5437E() {
            super.mo5437E();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo4646a(TListener tlistener) {
            mo4644a(tlistener, this.f1405S);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo4644a(TListener tlistener, C0344d dVar);

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4647d() {
            if (this.f1405S != null) {
                this.f1405S.close();
            }
        }

        public /* bridge */ /* synthetic */ void unregister() {
            super.unregister();
        }
    }

    /* renamed from: com.google.android.gms.internal.k$d */
    public static final class C0601d extends C0609o.C0610a {

        /* renamed from: bG */
        private C0597k f1407bG;

        public C0601d(C0597k kVar) {
            this.f1407bG = kVar;
        }

        /* renamed from: b */
        public void mo5439b(int i, IBinder iBinder, Bundle bundle) {
            C0621s.m1887b("onPostInitComplete can be called only once per call to getServiceFromBroker", (Object) this.f1407bG);
            this.f1407bG.mo4588a(i, iBinder, bundle);
            this.f1407bG = null;
        }
    }

    /* renamed from: com.google.android.gms.internal.k$e */
    final class C0602e implements ServiceConnection {
        C0602e() {
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            C0597k.this.mo5432f(binder);
        }

        public void onServiceDisconnected(ComponentName component) {
            IInterface unused = C0597k.this.f1393bs = null;
            C0597k.this.mo5428A();
        }
    }

    /* renamed from: com.google.android.gms.internal.k$f */
    protected final class C0603f extends C0597k<T>.b<Boolean> {

        /* renamed from: bH */
        public final Bundle f1410bH;

        /* renamed from: bI */
        public final IBinder f1411bI;
        public final int statusCode;

        public C0603f(int i, IBinder iBinder, Bundle bundle) {
            super(true);
            this.statusCode = i;
            this.f1411bI = iBinder;
            this.f1410bH = bundle;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4646a(Boolean bool) {
            if (bool != null) {
                switch (this.statusCode) {
                    case 0:
                        try {
                            if (C0597k.this.mo4601c().equals(this.f1411bI.getInterfaceDescriptor())) {
                                IInterface unused = C0597k.this.f1393bs = C0597k.this.mo4600c(this.f1411bI);
                                if (C0597k.this.f1393bs != null) {
                                    C0597k.this.mo4639y();
                                    return;
                                }
                            }
                        } catch (RemoteException e) {
                        }
                        C0604l.m1824g(C0597k.this.mContext).mo5444b(C0597k.this.mo4598b(), C0597k.this.f1400bz);
                        C0602e unused2 = C0597k.this.f1400bz = null;
                        IInterface unused3 = C0597k.this.f1393bs = null;
                        C0597k.this.mo4590a(new ConnectionResult(8, (PendingIntent) null));
                        return;
                    case 10:
                        throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                    default:
                        PendingIntent pendingIntent = this.f1410bH != null ? (PendingIntent) this.f1410bH.getParcelable("pendingIntent") : null;
                        if (C0597k.this.f1400bz != null) {
                            C0604l.m1824g(C0597k.this.mContext).mo5444b(C0597k.this.mo4598b(), C0597k.this.f1400bz);
                            C0602e unused4 = C0597k.this.f1400bz = null;
                        }
                        IInterface unused5 = C0597k.this.f1393bs = null;
                        C0597k.this.mo4590a(new ConnectionResult(this.statusCode, pendingIntent));
                        return;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo4647d() {
        }
    }

    protected C0597k(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this.mContext = (Context) C0621s.m1890d(context);
        this.f1394bt = new ArrayList<>();
        this.f1394bt.add(C0621s.m1890d(connectionCallbacks));
        this.f1397bw = new ArrayList<>();
        this.f1397bw.add(C0621s.m1890d(onConnectionFailedListener));
        this.mHandler = new C0598a(context.getMainLooper());
        mo4596a(strArr);
        this.f1401f = strArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public final void mo5428A() {
        this.mHandler.removeMessages(4);
        synchronized (this.f1394bt) {
            this.f1396bv = true;
            ArrayList<GooglePlayServicesClient.ConnectionCallbacks> arrayList = this.f1394bt;
            int size = arrayList.size();
            for (int i = 0; i < size && this.f1390bA; i++) {
                if (this.f1394bt.contains(arrayList.get(i))) {
                    arrayList.get(i).onDisconnected();
                }
            }
            this.f1396bv = false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public final void mo5429B() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public final T mo5430C() {
        mo5429B();
        return this.f1393bs;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4588a(int i, IBinder iBinder, Bundle bundle) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new C0603f(i, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4590a(ConnectionResult connectionResult) {
        this.mHandler.removeMessages(4);
        synchronized (this.f1397bw) {
            this.f1398bx = true;
            ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> arrayList = this.f1397bw;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                if (this.f1390bA) {
                    if (this.f1397bw.contains(arrayList.get(i))) {
                        arrayList.get(i).onConnectionFailed(connectionResult);
                    }
                    i++;
                } else {
                    return;
                }
            }
            this.f1398bx = false;
        }
    }

    /* renamed from: a */
    public final void mo5431a(C0597k<T>.b<?> bVar) {
        synchronized (this.f1399by) {
            this.f1399by.add(bVar);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, bVar));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo4595a(C0612p pVar, C0601d dVar) throws RemoteException;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4596a(String... strArr) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract String mo4598b();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract T mo4600c(IBinder iBinder);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract String mo4601c();

    public void connect() {
        this.f1390bA = true;
        synchronized (this.f1392bC) {
            this.f1391bB = true;
        }
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(isGooglePlayServicesAvailable)));
            return;
        }
        if (this.f1400bz != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
            this.f1393bs = null;
            C0604l.m1824g(this.mContext).mo5444b(mo4598b(), this.f1400bz);
        }
        this.f1400bz = new C0602e();
        if (!C0604l.m1824g(this.mContext).mo5443a(mo4598b(), this.f1400bz)) {
            Log.e("GmsClient", "unable to connect to service: " + mo4598b());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, 9));
        }
    }

    public void disconnect() {
        this.f1390bA = false;
        synchronized (this.f1392bC) {
            this.f1391bB = false;
        }
        synchronized (this.f1399by) {
            int size = this.f1399by.size();
            for (int i = 0; i < size; i++) {
                this.f1399by.get(i).mo5437E();
            }
            this.f1399by.clear();
        }
        this.f1393bs = null;
        if (this.f1400bz != null) {
            C0604l.m1824g(this.mContext).mo5444b(mo4598b(), this.f1400bz);
            this.f1400bz = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final void mo5432f(IBinder iBinder) {
        try {
            mo4595a(C0612p.C0613a.m1864h(iBinder), new C0601d(this));
        } catch (RemoteException e) {
            Log.w("GmsClient", "service died");
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public boolean isConnected() {
        return this.f1393bs != null;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.f1392bC) {
            z = this.f1391bB;
        }
        return z;
    }

    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks listener) {
        boolean contains;
        C0621s.m1890d(listener);
        synchronized (this.f1394bt) {
            contains = this.f1394bt.contains(listener);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        boolean contains;
        C0621s.m1890d(listener);
        synchronized (this.f1397bw) {
            contains = this.f1397bw.contains(listener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        C0621s.m1890d(listener);
        synchronized (this.f1394bt) {
            if (this.f1394bt.contains(listener)) {
                Log.w("GmsClient", "registerConnectionCallbacks(): listener " + listener + " is already registered");
            } else {
                if (this.f1396bv) {
                    this.f1394bt = new ArrayList<>(this.f1394bt);
                }
                this.f1394bt.add(listener);
            }
        }
        if (isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(4, listener));
        }
    }

    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        C0621s.m1890d(listener);
        synchronized (this.f1397bw) {
            if (this.f1397bw.contains(listener)) {
                Log.w("GmsClient", "registerConnectionFailedListener(): listener " + listener + " is already registered");
            } else {
                if (this.f1398bx) {
                    this.f1397bw = new ArrayList<>(this.f1397bw);
                }
                this.f1397bw.add(listener);
            }
        }
    }

    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        C0621s.m1890d(listener);
        synchronized (this.f1394bt) {
            if (this.f1394bt != null) {
                if (this.f1396bv) {
                    this.f1394bt = new ArrayList<>(this.f1394bt);
                }
                if (!this.f1394bt.remove(listener)) {
                    Log.w("GmsClient", "unregisterConnectionCallbacks(): listener " + listener + " not found");
                } else if (this.f1396bv && !this.f1395bu.contains(listener)) {
                    this.f1395bu.add(listener);
                }
            }
        }
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        C0621s.m1890d(listener);
        synchronized (this.f1397bw) {
            if (this.f1397bw != null) {
                if (this.f1398bx) {
                    this.f1397bw = new ArrayList<>(this.f1397bw);
                }
                if (!this.f1397bw.remove(listener)) {
                    Log.w("GmsClient", "unregisterConnectionFailedListener(): listener " + listener + " not found");
                }
            }
        }
    }

    /* renamed from: x */
    public final String[] mo5434x() {
        return this.f1401f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public void mo4639y() {
        boolean z = true;
        synchronized (this.f1394bt) {
            C0621s.m1884a(!this.f1396bv);
            this.mHandler.removeMessages(4);
            this.f1396bv = true;
            if (this.f1395bu.size() != 0) {
                z = false;
            }
            C0621s.m1884a(z);
            Bundle z2 = mo4640z();
            ArrayList<GooglePlayServicesClient.ConnectionCallbacks> arrayList = this.f1394bt;
            int size = arrayList.size();
            for (int i = 0; i < size && this.f1390bA && isConnected(); i++) {
                this.f1395bu.size();
                if (!this.f1395bu.contains(arrayList.get(i))) {
                    arrayList.get(i).onConnected(z2);
                }
            }
            this.f1395bu.clear();
            this.f1396bv = false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public Bundle mo4640z() {
        return null;
    }
}
