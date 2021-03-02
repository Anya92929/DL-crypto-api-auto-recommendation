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

    /* renamed from: a */
    final Handler f2961a;

    /* renamed from: b */
    private int f2962b;

    /* renamed from: c */
    private long f2963c;

    /* renamed from: d */
    private long f2964d;

    /* renamed from: e */
    private int f2965e;

    /* renamed from: f */
    private long f2966f;

    /* renamed from: g */
    private final Context f2967g;

    /* renamed from: h */
    private final zzf f2968h;

    /* renamed from: i */
    private final Looper f2969i;

    /* renamed from: j */
    private final zzl f2970j;

    /* renamed from: k */
    private final com.google.android.gms.common.zzc f2971k;

    /* renamed from: l */
    private final Object f2972l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final Object f2973m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public zzs f2974n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public GoogleApiClient.zza f2975o;

    /* renamed from: p */
    private T f2976p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public final ArrayList<zzj<T>.zzc<?>> f2977q;

    /* renamed from: r */
    private zzj<T>.zze f2978r;

    /* renamed from: s */
    private int f2979s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public final Set<Scope> f2980t;

    /* renamed from: u */
    private final Account f2981u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public final GoogleApiClient.ConnectionCallbacks f2982v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public final GoogleApiClient.OnConnectionFailedListener f2983w;

    /* renamed from: x */
    private final int f2984x;
    protected AtomicInteger zzalI;

    /* renamed from: com.google.android.gms.common.internal.zzj$a */
    abstract class C0741a extends zzj<T>.zzc<Boolean> {
        public final int statusCode;
        public final Bundle zzalK;

        @BinderThread
        protected C0741a(int i, Bundle bundle) {
            super(true);
            this.statusCode = i;
            this.zzalK = bundle;
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzc */
        public void zzw(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                zzj.this.m3917a(1, null);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    if (!zzqL()) {
                        zzj.this.m3917a(1, null);
                        zzj(new ConnectionResult(8, (PendingIntent) null));
                        return;
                    }
                    return;
                case 10:
                    zzj.this.m3917a(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    zzj.this.m3917a(1, null);
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

    /* renamed from: com.google.android.gms.common.internal.zzj$b */
    final class C0742b extends Handler {
        public C0742b(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        private void m3927a(Message message) {
            zzc zzc = (zzc) message.obj;
            zzc.zzqM();
            zzc.unregister();
        }

        /* renamed from: b */
        private boolean m3928b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5;
        }

        public void handleMessage(Message message) {
            if (zzj.this.zzalI.get() != message.arg1) {
                if (m3928b(message)) {
                    m3927a(message);
                }
            } else if ((message.what == 1 || message.what == 5) && !zzj.this.isConnecting()) {
                m3927a(message);
            } else if (message.what == 3) {
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, (PendingIntent) null);
                zzj.this.f2975o.zza(connectionResult);
                zzj.this.onConnectionFailed(connectionResult);
            } else if (message.what == 4) {
                zzj.this.m3917a(4, null);
                if (zzj.this.f2982v != null) {
                    zzj.this.f2982v.onConnectionSuspended(message.arg2);
                }
                zzj.this.onConnectionSuspended(message.arg2);
                boolean unused = zzj.this.m3919a(4, 1, null);
            } else if (message.what == 2 && !zzj.this.isConnected()) {
                m3927a(message);
            } else if (m3928b(message)) {
                ((zzc) message.obj).zzqN();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
            }
        }
    }

    public abstract class zzc<TListener> {

        /* renamed from: a */
        private TListener f2987a;

        /* renamed from: c */
        private boolean f2989c = false;

        public zzc(TListener tlistener) {
            this.f2987a = tlistener;
        }

        public void unregister() {
            zzqO();
            synchronized (zzj.this.f2977q) {
                zzj.this.f2977q.remove(this);
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzqM();

        public void zzqN() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.f2987a;
                if (this.f2989c) {
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
                this.f2989c = true;
            }
            unregister();
        }

        public void zzqO() {
            synchronized (this) {
                this.f2987a = null;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzw(TListener tlistener);
    }

    public static final class zzd extends zzr.zza {

        /* renamed from: a */
        private zzj f2990a;

        /* renamed from: b */
        private final int f2991b;

        public zzd(@NonNull zzj zzj, int i) {
            this.f2990a = zzj;
            this.f2991b = i;
        }

        /* renamed from: a */
        private void m3929a() {
            this.f2990a = null;
        }

        @BinderThread
        public void zza(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
            zzx.zzb(this.f2990a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.f2990a.zza(i, iBinder, bundle, this.f2991b);
            m3929a();
        }

        @BinderThread
        public void zzb(int i, @Nullable Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }
    }

    public final class zze implements ServiceConnection {

        /* renamed from: b */
        private final int f2993b;

        public zze(int i) {
            this.f2993b = i;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzx.zzb(iBinder, (Object) "Expecting a valid IBinder");
            synchronized (zzj.this.f2973m) {
                zzs unused = zzj.this.f2974n = zzs.zza.zzaS(iBinder);
            }
            zzj.this.zzm(0, this.f2993b);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (zzj.this.f2973m) {
                zzs unused = zzj.this.f2974n = null;
            }
            zzj.this.f2961a.sendMessage(zzj.this.f2961a.obtainMessage(4, this.f2993b, 1));
        }
    }

    public class zzf implements GoogleApiClient.zza {
        public zzf() {
        }

        public void zza(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                zzj.this.zza((zzp) null, zzj.this.f2980t);
            } else if (zzj.this.f2983w != null) {
                zzj.this.f2983w.onConnectionFailed(connectionResult);
            }
        }
    }

    public final class zzg extends zzj<T>.C0000a {
        public final IBinder zzalP;

        @BinderThread
        public zzg(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.zzalP = iBinder;
        }

        /* access modifiers changed from: protected */
        public void zzj(ConnectionResult connectionResult) {
            if (zzj.this.f2983w != null) {
                zzj.this.f2983w.onConnectionFailed(connectionResult);
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
                if (zzW == null || !zzj.this.m3919a(2, 3, zzW)) {
                    return false;
                }
                Bundle zzoi = zzj.this.zzoi();
                if (zzj.this.f2982v != null) {
                    zzj.this.f2982v.onConnected(zzoi);
                }
                return true;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    public final class zzh extends zzj<T>.C0000a {
        @BinderThread
        public zzh(int i) {
            super(i, (Bundle) null);
        }

        /* access modifiers changed from: protected */
        public void zzj(ConnectionResult connectionResult) {
            zzj.this.f2975o.zza(connectionResult);
            zzj.this.onConnectionFailed(connectionResult);
        }

        /* access modifiers changed from: protected */
        public boolean zzqL() {
            zzj.this.f2975o.zza(ConnectionResult.zzafB);
            return true;
        }
    }

    public zzj(Context context, Looper looper, int i, zzf zzf2, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzl.zzau(context), com.google.android.gms.common.zzc.zzoK(), i, zzf2, (GoogleApiClient.ConnectionCallbacks) zzx.zzz(connectionCallbacks), (GoogleApiClient.OnConnectionFailedListener) zzx.zzz(onConnectionFailedListener));
    }

    protected zzj(Context context, Looper looper, zzl zzl, com.google.android.gms.common.zzc zzc2, int i, zzf zzf2, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f2972l = new Object();
        this.f2973m = new Object();
        this.f2975o = new zzf();
        this.f2977q = new ArrayList<>();
        this.f2979s = 1;
        this.zzalI = new AtomicInteger(0);
        this.f2967g = (Context) zzx.zzb(context, (Object) "Context must not be null");
        this.f2969i = (Looper) zzx.zzb(looper, (Object) "Looper must not be null");
        this.f2970j = (zzl) zzx.zzb(zzl, (Object) "Supervisor must not be null");
        this.f2971k = (com.google.android.gms.common.zzc) zzx.zzb(zzc2, (Object) "API availability must not be null");
        this.f2961a = new C0742b(looper);
        this.f2984x = i;
        this.f2968h = (zzf) zzx.zzz(zzf2);
        this.f2981u = zzf2.getAccount();
        this.f2980t = m3915a(zzf2.zzqt());
        this.f2982v = connectionCallbacks;
        this.f2983w = onConnectionFailedListener;
    }

    /* renamed from: a */
    private Set<Scope> m3915a(Set<Scope> set) {
        Set<Scope> zzb = zzb(set);
        if (zzb == null) {
            return zzb;
        }
        for (Scope contains : zzb) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return zzb;
    }

    /* renamed from: a */
    private void m3916a() {
        if (this.f2978r != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zzgu());
            this.f2970j.zzb(zzgu(), (ServiceConnection) this.f2978r, zzqD());
            this.zzalI.incrementAndGet();
        }
        this.f2978r = new zze(this.zzalI.get());
        if (!this.f2970j.zza(zzgu(), (ServiceConnection) this.f2978r, zzqD())) {
            Log.e("GmsClient", "unable to connect to service: " + zzgu());
            zzm(8, this.zzalI.get());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3917a(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        zzx.zzac(z);
        synchronized (this.f2972l) {
            this.f2979s = i;
            this.f2976p = t;
            zzc(i, t);
            switch (i) {
                case 1:
                    m3922b();
                    break;
                case 2:
                    m3916a();
                    break;
                case 3:
                    zza(t);
                    break;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m3919a(int i, int i2, T t) {
        boolean z;
        synchronized (this.f2972l) {
            if (this.f2979s != i) {
                z = false;
            } else {
                m3917a(i2, t);
                z = true;
            }
        }
        return z;
    }

    /* renamed from: b */
    private void m3922b() {
        if (this.f2978r != null) {
            this.f2970j.zzb(zzgu(), (ServiceConnection) this.f2978r, zzqD());
            this.f2978r = null;
        }
    }

    public void disconnect() {
        this.zzalI.incrementAndGet();
        synchronized (this.f2977q) {
            int size = this.f2977q.size();
            for (int i = 0; i < size; i++) {
                this.f2977q.get(i).zzqO();
            }
            this.f2977q.clear();
        }
        synchronized (this.f2973m) {
            this.f2974n = null;
        }
        m3917a(1, (IInterface) null);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        synchronized (this.f2972l) {
            i = this.f2979s;
            t = this.f2976p;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("CONNECTING");
                break;
            case 3:
                printWriter.print("CONNECTED");
                break;
            case 4:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.println("null");
        } else {
            printWriter.append(zzgv()).append("@").println(Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f2964d > 0) {
            printWriter.append(str).append("lastConnectedTime=").println(this.f2964d + " " + simpleDateFormat.format(new Date(this.f2964d)));
        }
        if (this.f2963c > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.f2962b) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append(String.valueOf(this.f2962b));
                    break;
            }
            printWriter.append(" lastSuspendedTime=").println(this.f2963c + " " + simpleDateFormat.format(new Date(this.f2963c)));
        }
        if (this.f2966f > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.f2965e));
            printWriter.append(" lastFailedTime=").println(this.f2966f + " " + simpleDateFormat.format(new Date(this.f2966f)));
        }
    }

    public final Context getContext() {
        return this.f2967g;
    }

    public final Looper getLooper() {
        return this.f2969i;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.f2972l) {
            z = this.f2979s == 3;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.f2972l) {
            z = this.f2979s == 2;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.f2965e = connectionResult.getErrorCode();
        this.f2966f = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onConnectionSuspended(int i) {
        this.f2962b = i;
        this.f2963c = System.currentTimeMillis();
    }

    @Nullable
    public abstract T zzW(IBinder iBinder);

    /* access modifiers changed from: protected */
    @BinderThread
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.f2961a.sendMessage(this.f2961a.obtainMessage(1, i2, -1, new zzg(i, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void zza(@NonNull T t) {
        this.f2964d = System.currentTimeMillis();
    }

    public void zza(@NonNull GoogleApiClient.zza zza) {
        this.f2975o = (GoogleApiClient.zza) zzx.zzb(zza, (Object) "Connection progress callbacks cannot be null.");
        m3917a(2, (IInterface) null);
    }

    @WorkerThread
    public void zza(zzp zzp, Set<Scope> set) {
        try {
            GetServiceRequest zzj = new GetServiceRequest(this.f2984x).zzcG(this.f2967g.getPackageName()).zzj(zzml());
            if (set != null) {
                zzj.zzd(set);
            }
            if (zzmE()) {
                zzj.zzc(zzqq()).zzb(zzp);
            } else if (zzqK()) {
                zzj.zzc(this.f2981u);
            }
            synchronized (this.f2973m) {
                if (this.f2974n != null) {
                    this.f2974n.zza((zzr) new zzd(this, this.zzalI.get()), zzj);
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
        this.f2961a.sendMessage(this.f2961a.obtainMessage(4, this.zzalI.get(), i));
    }

    /* access modifiers changed from: package-private */
    public void zzc(int i, T t) {
    }

    @NonNull
    public abstract String zzgu();

    @NonNull
    public abstract String zzgv();

    /* access modifiers changed from: protected */
    public void zzm(int i, int i2) {
        this.f2961a.sendMessage(this.f2961a.obtainMessage(5, i2, -1, new zzh(i)));
    }

    public boolean zzmE() {
        return false;
    }

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
        synchronized (this.f2973m) {
            asBinder = this.f2974n == null ? null : this.f2974n.asBinder();
        }
        return asBinder;
    }

    public Bundle zzoi() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzqD() {
        return this.f2968h.zzqw();
    }

    public void zzqG() {
        int isGooglePlayServicesAvailable = this.f2971k.isGooglePlayServicesAvailable(this.f2967g);
        if (isGooglePlayServicesAvailable != 0) {
            m3917a(1, (IInterface) null);
            this.f2975o = new zzf();
            this.f2961a.sendMessage(this.f2961a.obtainMessage(3, this.zzalI.get(), isGooglePlayServicesAvailable));
            return;
        }
        zza((GoogleApiClient.zza) new zzf());
    }

    /* access modifiers changed from: protected */
    public final zzf zzqH() {
        return this.f2968h;
    }

    /* access modifiers changed from: protected */
    public final void zzqI() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T zzqJ() throws DeadObjectException {
        T t;
        synchronized (this.f2972l) {
            if (this.f2979s == 4) {
                throw new DeadObjectException();
            }
            zzqI();
            zzx.zza(this.f2976p != null, (Object) "Client is connected but service is null");
            t = this.f2976p;
        }
        return t;
    }

    public boolean zzqK() {
        return false;
    }

    public final Account zzqq() {
        return this.f2981u != null ? this.f2981u : new Account("<<default account>>", "com.google");
    }
}
