package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzs;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzj<T extends IInterface> implements Api.zzb, zzk.zza {
    public static final String[] zzalJ = {"service_esmobile", "service_googleme"};
    private final Context mContext;
    final Handler mHandler;
    private final Account zzTI;
    /* access modifiers changed from: private */
    public final Set<Scope> zzXf;
    private final Looper zzagr;
    private final com.google.android.gms.common.zzc zzags;
    private final zzf zzahz;
    /* access modifiers changed from: private */
    public GoogleApiClient.zza zzalA;
    private T zzalB;
    /* access modifiers changed from: private */
    public final ArrayList<zzj<T>.zzc<?>> zzalC;
    private zzj<T>.zze zzalD;
    private int zzalE;
    /* access modifiers changed from: private */
    public final GoogleApiClient.ConnectionCallbacks zzalF;
    /* access modifiers changed from: private */
    public final GoogleApiClient.OnConnectionFailedListener zzalG;
    private final int zzalH;
    protected AtomicInteger zzalI;
    private int zzals;
    private long zzalt;
    private long zzalu;
    private int zzalv;
    private long zzalw;
    private final zzl zzalx;
    /* access modifiers changed from: private */
    public final Object zzaly;
    /* access modifiers changed from: private */
    public zzs zzalz;
    private final Object zzpV;

    private abstract class zza extends zzj<T>.zzc<Boolean> {
        public final int statusCode;
        public final Bundle zzalK;

        @BinderThread
        protected zza(int i, Bundle bundle) {
            super(true);
            this.statusCode = i;
            this.zzalK = bundle;
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzc */
        public void zzw(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                zzj.this.zzb(1, null);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    if (!zzqL()) {
                        zzj.this.zzb(1, null);
                        zzj(new ConnectionResult(8, (PendingIntent) null));
                        return;
                    }
                    return;
                case 10:
                    zzj.this.zzb(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    zzj.this.zzb(1, null);
                    if (this.zzalK != null) {
                        pendingIntent = (PendingIntent) this.zzalK.getParcelable("pendingIntent");
                    }
                    zzj(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzj(ConnectionResult connectionResult);

        /* access modifiers changed from: protected */
        public abstract boolean zzqL();

        /* access modifiers changed from: protected */
        public void zzqM() {
        }
    }

    final class zzb extends Handler {
        public zzb(Looper looper) {
            super(looper);
        }

        private void zza(Message message) {
            zzc zzc = (zzc) message.obj;
            zzc.zzqM();
            zzc.unregister();
        }

        private boolean zzb(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5;
        }

        public void handleMessage(Message msg) {
            if (zzj.this.zzalI.get() != msg.arg1) {
                if (zzb(msg)) {
                    zza(msg);
                }
            } else if ((msg.what == 1 || msg.what == 5) && !zzj.this.isConnecting()) {
                zza(msg);
            } else if (msg.what == 3) {
                ConnectionResult connectionResult = new ConnectionResult(msg.arg2, (PendingIntent) null);
                zzj.this.zzalA.zza(connectionResult);
                zzj.this.onConnectionFailed(connectionResult);
            } else if (msg.what == 4) {
                zzj.this.zzb(4, null);
                if (zzj.this.zzalF != null) {
                    zzj.this.zzalF.onConnectionSuspended(msg.arg2);
                }
                zzj.this.onConnectionSuspended(msg.arg2);
                boolean unused = zzj.this.zza(4, 1, null);
            } else if (msg.what == 2 && !zzj.this.isConnected()) {
                zza(msg);
            } else if (zzb(msg)) {
                ((zzc) msg.obj).zzqN();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + msg.what, new Exception());
            }
        }
    }

    protected abstract class zzc<TListener> {
        private TListener mListener;
        private boolean zzalM = false;

        public zzc(TListener tlistener) {
            this.mListener = tlistener;
        }

        public void unregister() {
            zzqO();
            synchronized (zzj.this.zzalC) {
                zzj.this.zzalC.remove(this);
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzqM();

        public void zzqN() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.mListener;
                if (this.zzalM) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (tlistener != null) {
                try {
                    zzw(tlistener);
                } catch (RuntimeException e) {
                    zzqM();
                    throw e;
                }
            } else {
                zzqM();
            }
            synchronized (this) {
                this.zzalM = true;
            }
            unregister();
        }

        public void zzqO() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzw(TListener tlistener);
    }

    public static final class zzd extends zzr.zza {
        private zzj zzalN;
        private final int zzalO;

        public zzd(@NonNull zzj zzj, int i) {
            this.zzalN = zzj;
            this.zzalO = i;
        }

        private void zzqP() {
            this.zzalN = null;
        }

        @BinderThread
        public void zza(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
            zzx.zzb(this.zzalN, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.zzalN.zza(i, iBinder, bundle, this.zzalO);
            zzqP();
        }

        @BinderThread
        public void zzb(int i, @Nullable Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }
    }

    public final class zze implements ServiceConnection {
        private final int zzalO;

        public zze(int i) {
            this.zzalO = i;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            zzx.zzb(binder, (Object) "Expecting a valid IBinder");
            synchronized (zzj.this.zzaly) {
                zzs unused = zzj.this.zzalz = zzs.zza.zzaS(binder);
            }
            zzj.this.zzm(0, this.zzalO);
        }

        public void onServiceDisconnected(ComponentName component) {
            synchronized (zzj.this.zzaly) {
                zzs unused = zzj.this.zzalz = null;
            }
            zzj.this.mHandler.sendMessage(zzj.this.mHandler.obtainMessage(4, this.zzalO, 1));
        }
    }

    protected class zzf implements GoogleApiClient.zza {
        public zzf() {
        }

        public void zza(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                zzj.this.zza((zzp) null, (Set<Scope>) zzj.this.zzXf);
            } else if (zzj.this.zzalG != null) {
                zzj.this.zzalG.onConnectionFailed(connectionResult);
            }
        }
    }

    protected final class zzg extends zzj<T>.zza {
        public final IBinder zzalP;

        @BinderThread
        public zzg(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.zzalP = iBinder;
        }

        /* access modifiers changed from: protected */
        public void zzj(ConnectionResult connectionResult) {
            if (zzj.this.zzalG != null) {
                zzj.this.zzalG.onConnectionFailed(connectionResult);
            }
            zzj.this.onConnectionFailed(connectionResult);
        }

        /* access modifiers changed from: protected */
        public boolean zzqL() {
            try {
                String interfaceDescriptor = this.zzalP.getInterfaceDescriptor();
                if (!zzj.this.zzgv().equals(interfaceDescriptor)) {
                    Log.e("GmsClient", "service descriptor mismatch: " + zzj.this.zzgv() + " vs. " + interfaceDescriptor);
                    return false;
                }
                IInterface zzW = zzj.this.zzW(this.zzalP);
                if (zzW == null || !zzj.this.zza(2, 3, zzW)) {
                    return false;
                }
                Bundle zzoi = zzj.this.zzoi();
                if (zzj.this.zzalF != null) {
                    zzj.this.zzalF.onConnected(zzoi);
                }
                return true;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    protected final class zzh extends zzj<T>.zza {
        @BinderThread
        public zzh(int i) {
            super(i, (Bundle) null);
        }

        /* access modifiers changed from: protected */
        public void zzj(ConnectionResult connectionResult) {
            zzj.this.zzalA.zza(connectionResult);
            zzj.this.onConnectionFailed(connectionResult);
        }

        /* access modifiers changed from: protected */
        public boolean zzqL() {
            zzj.this.zzalA.zza(ConnectionResult.zzafB);
            return true;
        }
    }

    protected zzj(Context context, Looper looper, int i, zzf zzf2, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzl.zzau(context), com.google.android.gms.common.zzc.zzoK(), i, zzf2, (GoogleApiClient.ConnectionCallbacks) zzx.zzz(connectionCallbacks), (GoogleApiClient.OnConnectionFailedListener) zzx.zzz(onConnectionFailedListener));
    }

    protected zzj(Context context, Looper looper, zzl zzl, com.google.android.gms.common.zzc zzc2, int i, zzf zzf2, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzpV = new Object();
        this.zzaly = new Object();
        this.zzalA = new zzf();
        this.zzalC = new ArrayList<>();
        this.zzalE = 1;
        this.zzalI = new AtomicInteger(0);
        this.mContext = (Context) zzx.zzb(context, (Object) "Context must not be null");
        this.zzagr = (Looper) zzx.zzb(looper, (Object) "Looper must not be null");
        this.zzalx = (zzl) zzx.zzb(zzl, (Object) "Supervisor must not be null");
        this.zzags = (com.google.android.gms.common.zzc) zzx.zzb(zzc2, (Object) "API availability must not be null");
        this.mHandler = new zzb(looper);
        this.zzalH = i;
        this.zzahz = (zzf) zzx.zzz(zzf2);
        this.zzTI = zzf2.getAccount();
        this.zzXf = zza(zzf2.zzqt());
        this.zzalF = connectionCallbacks;
        this.zzalG = onConnectionFailedListener;
    }

    private Set<Scope> zza(Set<Scope> set) {
        Set<Scope> zzb2 = zzb(set);
        if (zzb2 == null) {
            return zzb2;
        }
        for (Scope contains : zzb2) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return zzb2;
    }

    /* access modifiers changed from: private */
    public boolean zza(int i, int i2, T t) {
        boolean z;
        synchronized (this.zzpV) {
            if (this.zzalE != i) {
                z = false;
            } else {
                zzb(i2, t);
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    public void zzb(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        zzx.zzac(z);
        synchronized (this.zzpV) {
            this.zzalE = i;
            this.zzalB = t;
            zzc(i, t);
            switch (i) {
                case 1:
                    zzqF();
                    break;
                case 2:
                    zzqE();
                    break;
                case 3:
                    zza(t);
                    break;
            }
        }
    }

    private void zzqE() {
        if (this.zzalD != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zzgu());
            this.zzalx.zzb(zzgu(), (ServiceConnection) this.zzalD, zzqD());
            this.zzalI.incrementAndGet();
        }
        this.zzalD = new zze(this.zzalI.get());
        if (!this.zzalx.zza(zzgu(), (ServiceConnection) this.zzalD, zzqD())) {
            Log.e("GmsClient", "unable to connect to service: " + zzgu());
            zzm(8, this.zzalI.get());
        }
    }

    private void zzqF() {
        if (this.zzalD != null) {
            this.zzalx.zzb(zzgu(), (ServiceConnection) this.zzalD, zzqD());
            this.zzalD = null;
        }
    }

    public void disconnect() {
        this.zzalI.incrementAndGet();
        synchronized (this.zzalC) {
            int size = this.zzalC.size();
            for (int i = 0; i < size; i++) {
                this.zzalC.get(i).zzqO();
            }
            this.zzalC.clear();
        }
        synchronized (this.zzaly) {
            this.zzalz = null;
        }
        zzb(1, (IInterface) null);
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        int i;
        T t;
        synchronized (this.zzpV) {
            i = this.zzalE;
            t = this.zzalB;
        }
        writer.append(prefix).append("mConnectState=");
        switch (i) {
            case 1:
                writer.print("DISCONNECTED");
                break;
            case 2:
                writer.print("CONNECTING");
                break;
            case 3:
                writer.print("CONNECTED");
                break;
            case 4:
                writer.print("DISCONNECTING");
                break;
            default:
                writer.print("UNKNOWN");
                break;
        }
        writer.append(" mService=");
        if (t == null) {
            writer.println("null");
        } else {
            writer.append(zzgv()).append("@").println(Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzalu > 0) {
            writer.append(prefix).append("lastConnectedTime=").println(this.zzalu + " " + simpleDateFormat.format(new Date(this.zzalu)));
        }
        if (this.zzalt > 0) {
            writer.append(prefix).append("lastSuspendedCause=");
            switch (this.zzals) {
                case 1:
                    writer.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    writer.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    writer.append(String.valueOf(this.zzals));
                    break;
            }
            writer.append(" lastSuspendedTime=").println(this.zzalt + " " + simpleDateFormat.format(new Date(this.zzalt)));
        }
        if (this.zzalw > 0) {
            writer.append(prefix).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzalv));
            writer.append(" lastFailedTime=").println(this.zzalw + " " + simpleDateFormat.format(new Date(this.zzalw)));
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzagr;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzalE == 3;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzalE == 2;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onConnectionFailed(ConnectionResult result) {
        this.zzalv = result.getErrorCode();
        this.zzalw = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onConnectionSuspended(int cause) {
        this.zzals = cause;
        this.zzalt = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract T zzW(IBinder iBinder);

    /* access modifiers changed from: protected */
    @BinderThread
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new zzg(i, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void zza(@NonNull T t) {
        this.zzalu = System.currentTimeMillis();
    }

    public void zza(@NonNull GoogleApiClient.zza zza2) {
        this.zzalA = (GoogleApiClient.zza) zzx.zzb(zza2, (Object) "Connection progress callbacks cannot be null.");
        zzb(2, (IInterface) null);
    }

    @WorkerThread
    public void zza(zzp zzp, Set<Scope> set) {
        try {
            GetServiceRequest zzj = new GetServiceRequest(this.zzalH).zzcG(this.mContext.getPackageName()).zzj(zzml());
            if (set != null) {
                zzj.zzd(set);
            }
            if (zzmE()) {
                zzj.zzc(zzqq()).zzb(zzp);
            } else if (zzqK()) {
                zzj.zzc(this.zzTI);
            }
            synchronized (this.zzaly) {
                if (this.zzalz != null) {
                    this.zzalz.zza((zzr) new zzd(this, this.zzalI.get()), zzj);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            zzbS(1);
        } catch (RemoteException e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Set<Scope> zzb(@NonNull Set<Scope> set) {
        return set;
    }

    public void zzbS(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.zzalI.get(), i));
    }

    /* access modifiers changed from: package-private */
    public void zzc(int i, T t) {
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract String zzgu();

    /* access modifiers changed from: protected */
    @NonNull
    public abstract String zzgv();

    /* access modifiers changed from: protected */
    public void zzm(int i, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5, i2, -1, new zzh(i)));
    }

    public boolean zzmE() {
        return false;
    }

    /* access modifiers changed from: protected */
    public Bundle zzml() {
        return new Bundle();
    }

    public boolean zznb() {
        return false;
    }

    public Intent zznc() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @Nullable
    public IBinder zzoT() {
        IBinder asBinder;
        synchronized (this.zzaly) {
            asBinder = this.zzalz == null ? null : this.zzalz.asBinder();
        }
        return asBinder;
    }

    public Bundle zzoi() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzqD() {
        return this.zzahz.zzqw();
    }

    public void zzqG() {
        int isGooglePlayServicesAvailable = this.zzags.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            zzb(1, (IInterface) null);
            this.zzalA = new zzf();
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzalI.get(), isGooglePlayServicesAvailable));
            return;
        }
        zza((GoogleApiClient.zza) new zzf());
    }

    /* access modifiers changed from: protected */
    public final zzf zzqH() {
        return this.zzahz;
    }

    /* access modifiers changed from: protected */
    public final void zzqI() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T zzqJ() throws DeadObjectException {
        T t;
        synchronized (this.zzpV) {
            if (this.zzalE == 4) {
                throw new DeadObjectException();
            }
            zzqI();
            zzx.zza(this.zzalB != null, (Object) "Client is connected but service is null");
            t = this.zzalB;
        }
        return t;
    }

    public boolean zzqK() {
        return false;
    }

    public final Account zzqq() {
        return this.zzTI != null ? this.zzTI : new Account("<<default account>>", "com.google");
    }
}
