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
import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.internal.C0399di;
import com.google.android.gms.internal.C0402dj;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.de */
public abstract class C0387de<T extends IInterface> implements GooglePlayServicesClient {

    /* renamed from: kO */
    public static final String[] f1094kO = {"service_esmobile", "service_googleme"};

    /* renamed from: is */
    private final String[] f1095is;
    /* access modifiers changed from: private */

    /* renamed from: kD */
    public T f1096kD;
    /* access modifiers changed from: private */

    /* renamed from: kE */
    public ArrayList<GooglePlayServicesClient.ConnectionCallbacks> f1097kE;

    /* renamed from: kF */
    final ArrayList<GooglePlayServicesClient.ConnectionCallbacks> f1098kF = new ArrayList<>();

    /* renamed from: kG */
    private boolean f1099kG = false;

    /* renamed from: kH */
    private ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> f1100kH;

    /* renamed from: kI */
    private boolean f1101kI = false;
    /* access modifiers changed from: private */

    /* renamed from: kJ */
    public final ArrayList<C0387de<T>.b<?>> f1102kJ = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: kK */
    public C0387de<T>.e f1103kK;

    /* renamed from: kL */
    boolean f1104kL = false;

    /* renamed from: kM */
    boolean f1105kM = false;
    /* access modifiers changed from: private */

    /* renamed from: kN */
    public final Object f1106kN = new Object();
    /* access modifiers changed from: private */
    public final Context mContext;
    final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.de$a */
    final class C0388a extends Handler {
        public C0388a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what != 1 || C0387de.this.isConnecting()) {
                synchronized (C0387de.this.f1106kN) {
                    C0387de.this.f1105kM = false;
                }
                if (msg.what == 3) {
                    C0387de.this.mo4325a(new ConnectionResult(((Integer) msg.obj).intValue(), (PendingIntent) null));
                } else if (msg.what == 4) {
                    synchronized (C0387de.this.f1097kE) {
                        if (C0387de.this.f1104kL && C0387de.this.isConnected() && C0387de.this.f1097kE.contains(msg.obj)) {
                            ((GooglePlayServicesClient.ConnectionCallbacks) msg.obj).onConnected(C0387de.this.mo4329ba());
                        }
                    }
                } else if (msg.what == 2 && !C0387de.this.isConnected()) {
                    C0389b bVar = (C0389b) msg.obj;
                    bVar.mo4271aF();
                    bVar.unregister();
                } else if (msg.what == 2 || msg.what == 1) {
                    ((C0389b) msg.obj).mo4336be();
                } else {
                    Log.wtf("GmsClient", "Don't know how to handle this message.");
                }
            } else {
                C0389b bVar2 = (C0389b) msg.obj;
                bVar2.mo4271aF();
                bVar2.unregister();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.de$b */
    protected abstract class C0389b<TListener> {

        /* renamed from: kQ */
        private boolean f1109kQ = false;
        private TListener mListener;

        public C0389b(TListener tlistener) {
            this.mListener = tlistener;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo4270a(TListener tlistener);

        /* access modifiers changed from: protected */
        /* renamed from: aF */
        public abstract void mo4271aF();

        /* renamed from: be */
        public void mo4336be() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.mListener;
                if (this.f1109kQ) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (tlistener != null) {
                try {
                    mo4270a(tlistener);
                } catch (RuntimeException e) {
                    mo4271aF();
                    throw e;
                }
            } else {
                mo4271aF();
            }
            synchronized (this) {
                this.f1109kQ = true;
            }
            unregister();
        }

        /* renamed from: bf */
        public void mo4337bf() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        public void unregister() {
            mo4337bf();
            synchronized (C0387de.this.f1102kJ) {
                C0387de.this.f1102kJ.remove(this);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.de$c */
    public abstract class C0390c<TListener> extends C0387de<T>.b<TListener> {

        /* renamed from: jf */
        private final C0140d f1110jf;

        public C0390c(TListener tlistener, C0140d dVar) {
            super(tlistener);
            this.f1110jf = dVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo4270a(TListener tlistener) {
            mo4273a(tlistener, this.f1110jf);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo4273a(TListener tlistener, C0140d dVar);

        /* access modifiers changed from: protected */
        /* renamed from: aF */
        public void mo4271aF() {
            if (this.f1110jf != null) {
                this.f1110jf.close();
            }
        }

        /* renamed from: be */
        public /* bridge */ /* synthetic */ void mo4336be() {
            super.mo4336be();
        }

        /* renamed from: bf */
        public /* bridge */ /* synthetic */ void mo4337bf() {
            super.mo4337bf();
        }

        public /* bridge */ /* synthetic */ void unregister() {
            super.unregister();
        }
    }

    /* renamed from: com.google.android.gms.internal.de$d */
    public static final class C0391d extends C0399di.C0400a {

        /* renamed from: kR */
        private C0387de f1112kR;

        public C0391d(C0387de deVar) {
            this.f1112kR = deVar;
        }

        /* renamed from: b */
        public void mo4339b(int i, IBinder iBinder, Bundle bundle) {
            C0411dm.m940a("onPostInitComplete can be called only once per call to getServiceFromBroker", (Object) this.f1112kR);
            this.f1112kR.mo4324a(i, iBinder, bundle);
            this.f1112kR = null;
        }
    }

    /* renamed from: com.google.android.gms.internal.de$e */
    final class C0392e implements ServiceConnection {
        C0392e() {
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            C0387de.this.mo4334u(binder);
        }

        public void onServiceDisconnected(ComponentName component) {
            IInterface unused = C0387de.this.f1096kD = null;
            C0387de.this.mo4330bb();
        }
    }

    /* renamed from: com.google.android.gms.internal.de$f */
    protected final class C0393f extends C0387de<T>.b<Boolean> {

        /* renamed from: kS */
        public final Bundle f1115kS;

        /* renamed from: kT */
        public final IBinder f1116kT;
        public final int statusCode;

        public C0393f(int i, IBinder iBinder, Bundle bundle) {
            super(true);
            this.statusCode = i;
            this.f1116kT = iBinder;
            this.f1115kS = bundle;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4270a(Boolean bool) {
            if (bool != null) {
                switch (this.statusCode) {
                    case 0:
                        try {
                            if (C0387de.this.mo4165ah().equals(this.f1116kT.getInterfaceDescriptor())) {
                                IInterface unused = C0387de.this.f1096kD = C0387de.this.mo4168p(this.f1116kT);
                                if (C0387de.this.f1096kD != null) {
                                    C0387de.this.mo4328aZ();
                                    return;
                                }
                            }
                        } catch (RemoteException e) {
                        }
                        C0394df.m876s(C0387de.this.mContext).mo4344b(C0387de.this.mo4164ag(), C0387de.this.f1103kK);
                        C0392e unused2 = C0387de.this.f1103kK = null;
                        IInterface unused3 = C0387de.this.f1096kD = null;
                        C0387de.this.mo4325a(new ConnectionResult(8, (PendingIntent) null));
                        return;
                    case 10:
                        throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                    default:
                        PendingIntent pendingIntent = this.f1115kS != null ? (PendingIntent) this.f1115kS.getParcelable("pendingIntent") : null;
                        if (C0387de.this.f1103kK != null) {
                            C0394df.m876s(C0387de.this.mContext).mo4344b(C0387de.this.mo4164ag(), C0387de.this.f1103kK);
                            C0392e unused4 = C0387de.this.f1103kK = null;
                        }
                        IInterface unused5 = C0387de.this.f1096kD = null;
                        C0387de.this.mo4325a(new ConnectionResult(this.statusCode, pendingIntent));
                        return;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: aF */
        public void mo4271aF() {
        }
    }

    protected C0387de(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this.mContext = (Context) C0411dm.m944e(context);
        this.f1097kE = new ArrayList<>();
        this.f1097kE.add(C0411dm.m944e(connectionCallbacks));
        this.f1100kH = new ArrayList<>();
        this.f1100kH.add(C0411dm.m944e(onConnectionFailedListener));
        this.mHandler = new C0388a(context.getMainLooper());
        mo4260a(strArr);
        this.f1095is = strArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4324a(int i, IBinder iBinder, Bundle bundle) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new C0393f(i, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4325a(ConnectionResult connectionResult) {
        this.mHandler.removeMessages(4);
        synchronized (this.f1100kH) {
            this.f1101kI = true;
            ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> arrayList = this.f1100kH;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                if (this.f1104kL) {
                    if (this.f1100kH.contains(arrayList.get(i))) {
                        arrayList.get(i).onConnectionFailed(connectionResult);
                    }
                    i++;
                } else {
                    return;
                }
            }
            this.f1101kI = false;
        }
    }

    /* renamed from: a */
    public final void mo4326a(C0387de<T>.b<?> bVar) {
        synchronized (this.f1102kJ) {
            this.f1102kJ.add(bVar);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, bVar));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo4163a(C0402dj djVar, C0391d dVar) throws RemoteException;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4260a(String... strArr) {
    }

    /* renamed from: aY */
    public final String[] mo4327aY() {
        return this.f1095is;
    }

    /* access modifiers changed from: protected */
    /* renamed from: aZ */
    public void mo4328aZ() {
        boolean z = true;
        synchronized (this.f1097kE) {
            C0411dm.m945k(!this.f1099kG);
            this.mHandler.removeMessages(4);
            this.f1099kG = true;
            if (this.f1098kF.size() != 0) {
                z = false;
            }
            C0411dm.m945k(z);
            Bundle ba = mo4329ba();
            ArrayList<GooglePlayServicesClient.ConnectionCallbacks> arrayList = this.f1097kE;
            int size = arrayList.size();
            for (int i = 0; i < size && this.f1104kL && isConnected(); i++) {
                this.f1098kF.size();
                if (!this.f1098kF.contains(arrayList.get(i))) {
                    arrayList.get(i).onConnected(ba);
                }
            }
            this.f1098kF.clear();
            this.f1099kG = false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ag */
    public abstract String mo4164ag();

    /* access modifiers changed from: protected */
    /* renamed from: ah */
    public abstract String mo4165ah();

    /* access modifiers changed from: protected */
    /* renamed from: ba */
    public Bundle mo4329ba() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: bb */
    public final void mo4330bb() {
        this.mHandler.removeMessages(4);
        synchronized (this.f1097kE) {
            this.f1099kG = true;
            ArrayList<GooglePlayServicesClient.ConnectionCallbacks> arrayList = this.f1097kE;
            int size = arrayList.size();
            for (int i = 0; i < size && this.f1104kL; i++) {
                if (this.f1097kE.contains(arrayList.get(i))) {
                    arrayList.get(i).onDisconnected();
                }
            }
            this.f1099kG = false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: bc */
    public final void mo4331bc() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: bd */
    public final T mo4332bd() {
        mo4331bc();
        return this.f1096kD;
    }

    public void connect() {
        this.f1104kL = true;
        synchronized (this.f1106kN) {
            this.f1105kM = true;
        }
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(isGooglePlayServicesAvailable)));
            return;
        }
        if (this.f1103kK != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
            this.f1096kD = null;
            C0394df.m876s(this.mContext).mo4344b(mo4164ag(), this.f1103kK);
        }
        this.f1103kK = new C0392e();
        if (!C0394df.m876s(this.mContext).mo4343a(mo4164ag(), this.f1103kK)) {
            Log.e("GmsClient", "unable to connect to service: " + mo4164ag());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, 9));
        }
    }

    public void disconnect() {
        this.f1104kL = false;
        synchronized (this.f1106kN) {
            this.f1105kM = false;
        }
        synchronized (this.f1102kJ) {
            int size = this.f1102kJ.size();
            for (int i = 0; i < size; i++) {
                this.f1102kJ.get(i).mo4337bf();
            }
            this.f1102kJ.clear();
        }
        this.f1096kD = null;
        if (this.f1103kK != null) {
            C0394df.m876s(this.mContext).mo4344b(mo4164ag(), this.f1103kK);
            this.f1103kK = null;
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public boolean isConnected() {
        return this.f1096kD != null;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.f1106kN) {
            z = this.f1105kM;
        }
        return z;
    }

    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks listener) {
        boolean contains;
        C0411dm.m944e(listener);
        synchronized (this.f1097kE) {
            contains = this.f1097kE.contains(listener);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        boolean contains;
        C0411dm.m944e(listener);
        synchronized (this.f1100kH) {
            contains = this.f1100kH.contains(listener);
        }
        return contains;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public abstract T mo4168p(IBinder iBinder);

    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        C0411dm.m944e(listener);
        synchronized (this.f1097kE) {
            if (this.f1097kE.contains(listener)) {
                Log.w("GmsClient", "registerConnectionCallbacks(): listener " + listener + " is already registered");
            } else {
                if (this.f1099kG) {
                    this.f1097kE = new ArrayList<>(this.f1097kE);
                }
                this.f1097kE.add(listener);
            }
        }
        if (isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(4, listener));
        }
    }

    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        C0411dm.m944e(listener);
        synchronized (this.f1100kH) {
            if (this.f1100kH.contains(listener)) {
                Log.w("GmsClient", "registerConnectionFailedListener(): listener " + listener + " is already registered");
            } else {
                if (this.f1101kI) {
                    this.f1100kH = new ArrayList<>(this.f1100kH);
                }
                this.f1100kH.add(listener);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public final void mo4334u(IBinder iBinder) {
        try {
            mo4163a(C0402dj.C0403a.m919w(iBinder), new C0391d(this));
        } catch (RemoteException e) {
            Log.w("GmsClient", "service died");
        }
    }

    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        C0411dm.m944e(listener);
        synchronized (this.f1097kE) {
            if (this.f1097kE != null) {
                if (this.f1099kG) {
                    this.f1097kE = new ArrayList<>(this.f1097kE);
                }
                if (!this.f1097kE.remove(listener)) {
                    Log.w("GmsClient", "unregisterConnectionCallbacks(): listener " + listener + " not found");
                } else if (this.f1099kG && !this.f1098kF.contains(listener)) {
                    this.f1098kF.add(listener);
                }
            }
        }
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        C0411dm.m944e(listener);
        synchronized (this.f1100kH) {
            if (this.f1100kH != null) {
                if (this.f1101kI) {
                    this.f1100kH = new ArrayList<>(this.f1100kH);
                }
                if (!this.f1100kH.remove(listener)) {
                    Log.w("GmsClient", "unregisterConnectionFailedListener(): listener " + listener + " not found");
                }
            }
        }
    }
}
