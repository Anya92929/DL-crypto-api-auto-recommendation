package com.google.android.gms.common.internal;

import android.accounts.Account;
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
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzd {

    /* renamed from: xE */
    public static final String[] f4521xE = {"service_esmobile", "service_googleme"};

    /* renamed from: a */
    private int f4522a;

    /* renamed from: b */
    final Handler f4523b;

    /* renamed from: c */
    protected AtomicInteger f4524c;

    /* renamed from: d */
    private long f4525d;

    /* renamed from: e */
    private long f4526e;

    /* renamed from: f */
    private int f4527f;

    /* renamed from: g */
    private long f4528g;

    /* renamed from: h */
    private final Context f4529h;

    /* renamed from: i */
    private final Looper f4530i;

    /* renamed from: j */
    private final zzm f4531j;

    /* renamed from: k */
    private final com.google.android.gms.common.zzc f4532k;

    /* renamed from: l */
    private final Object f4533l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final Object f4534m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public zzu f4535n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public zzf f4536o;

    /* renamed from: p */
    private IInterface f4537p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public final ArrayList f4538q;

    /* renamed from: r */
    private zzh f4539r;

    /* renamed from: s */
    private int f4540s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public final zzb f4541t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public final zzc f4542u;

    /* renamed from: v */
    private final int f4543v;

    /* renamed from: w */
    private final String f4544w;

    public interface zzb {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface zzc {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public abstract class zze {

        /* renamed from: a */
        private Object f4545a;

        /* renamed from: c */
        private boolean f4547c = false;

        public zze(Object obj) {
            this.f4545a = obj;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo6615a(Object obj);

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public abstract void mo6617b();

        public void unregister() {
            zzasg();
            synchronized (zzd.this.f4538q) {
                zzd.this.f4538q.remove(this);
            }
        }

        public void zzasf() {
            Object obj;
            synchronized (this) {
                obj = this.f4545a;
                if (this.f4547c) {
                    String valueOf = String.valueOf(this);
                    Log.w("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.").toString());
                }
            }
            if (obj != null) {
                try {
                    mo6615a(obj);
                } catch (RuntimeException e) {
                    mo6617b();
                    throw e;
                }
            } else {
                mo6617b();
            }
            synchronized (this) {
                this.f4547c = true;
            }
            unregister();
        }

        public void zzasg() {
            synchronized (this) {
                this.f4545a = null;
            }
        }
    }

    public interface zzf {
        void zzh(ConnectionResult connectionResult);
    }

    public final class zzg extends zzt.zza {

        /* renamed from: a */
        private zzd f4548a;

        /* renamed from: b */
        private final int f4549b;

        public zzg(zzd zzd, int i) {
            this.f4548a = zzd;
            this.f4549b = i;
        }

        /* renamed from: a */
        private void m6107a() {
            this.f4548a = null;
        }

        public void zza(int i, IBinder iBinder, Bundle bundle) {
            zzab.zzb((Object) this.f4548a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.f4548a.mo6666a(i, iBinder, bundle, this.f4549b);
            m6107a();
        }

        public void zzb(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }
    }

    public final class zzh implements ServiceConnection {

        /* renamed from: b */
        private final int f4551b;

        public zzh(int i) {
            this.f4551b = i;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzab.zzb((Object) iBinder, (Object) "Expecting a valid IBinder");
            synchronized (zzd.this.f4534m) {
                zzu unused = zzd.this.f4535n = zzu.zza.zzdt(iBinder);
            }
            zzd.this.mo6665a(0, (Bundle) null, this.f4551b);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (zzd.this.f4534m) {
                zzu unused = zzd.this.f4535n = null;
            }
            zzd.this.f4523b.sendMessage(zzd.this.f4523b.obtainMessage(4, this.f4551b, 1));
        }
    }

    public class zzi implements zzf {
        public zzi() {
        }

        public void zzh(ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                zzd.this.zza((zzq) null, zzd.this.mo6675f());
            } else if (zzd.this.f4542u != null) {
                zzd.this.f4542u.onConnectionFailed(connectionResult);
            }
        }
    }

    public final class zzj extends C1364c {

        /* renamed from: xK */
        public final IBinder f4554xK;

        public zzj(int i, IBinder iBinder, Bundle bundle) {
            super(zzd.this, i, bundle);
            this.f4554xK = iBinder;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo6613a(ConnectionResult connectionResult) {
            if (zzd.this.f4542u != null) {
                zzd.this.f4542u.onConnectionFailed(connectionResult);
            }
            zzd.this.mo6668a(connectionResult);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo6616a() {
            try {
                String interfaceDescriptor = this.f4554xK.getInterfaceDescriptor();
                if (!zzd.this.mo5671a().equals(interfaceDescriptor)) {
                    String valueOf = String.valueOf(zzd.this.mo5671a());
                    Log.e("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 34 + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(valueOf).append(" vs. ").append(interfaceDescriptor).toString());
                    return false;
                }
                IInterface zzbb = zzd.this.zzbb(this.f4554xK);
                if (zzbb == null || !zzd.this.m6084a(2, 3, zzbb)) {
                    return false;
                }
                Bundle zzamh = zzd.this.zzamh();
                if (zzd.this.f4541t != null) {
                    zzd.this.f4541t.onConnected(zzamh);
                }
                return true;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    public final class zzk extends C1364c {
        public zzk(int i, Bundle bundle) {
            super(zzd.this, i, bundle);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo6613a(ConnectionResult connectionResult) {
            zzd.this.f4536o.zzh(connectionResult);
            zzd.this.mo6668a(connectionResult);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo6616a() {
            zzd.this.f4536o.zzh(ConnectionResult.f4269rb);
            return true;
        }
    }

    protected zzd(Context context, Looper looper, int i, zzb zzb2, zzc zzc2, String str) {
        this(context, looper, zzm.zzce(context), com.google.android.gms.common.zzc.zzang(), i, (zzb) zzab.zzy(zzb2), (zzc) zzab.zzy(zzc2), str);
    }

    protected zzd(Context context, Looper looper, zzm zzm, com.google.android.gms.common.zzc zzc2, int i, zzb zzb2, zzc zzc3, String str) {
        this.f4533l = new Object();
        this.f4534m = new Object();
        this.f4538q = new ArrayList();
        this.f4540s = 1;
        this.f4524c = new AtomicInteger(0);
        this.f4529h = (Context) zzab.zzb((Object) context, (Object) "Context must not be null");
        this.f4530i = (Looper) zzab.zzb((Object) looper, (Object) "Looper must not be null");
        this.f4531j = (zzm) zzab.zzb((Object) zzm, (Object) "Supervisor must not be null");
        this.f4532k = (com.google.android.gms.common.zzc) zzab.zzb((Object) zzc2, (Object) "API availability must not be null");
        this.f4523b = new C1365d(this, looper);
        this.f4543v = i;
        this.f4541t = zzb2;
        this.f4542u = zzc3;
        this.f4544w = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m6084a(int i, int i2, IInterface iInterface) {
        boolean z;
        synchronized (this.f4533l) {
            if (this.f4540s != i) {
                z = false;
            } else {
                m6087b(i2, iInterface);
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6087b(int i, IInterface iInterface) {
        boolean z = true;
        if ((i == 3) != (iInterface != null)) {
            z = false;
        }
        zzab.zzbo(z);
        synchronized (this.f4533l) {
            this.f4540s = i;
            this.f4537p = iInterface;
            mo6653a(i, iInterface);
            switch (i) {
                case 1:
                    m6092h();
                    break;
                case 2:
                    m6091g();
                    break;
                case 3:
                    mo6667a(iInterface);
                    break;
            }
        }
    }

    /* renamed from: g */
    private void m6091g() {
        if (this.f4539r != null) {
            String valueOf = String.valueOf(zzqz());
            String valueOf2 = String.valueOf(mo6669b());
            Log.e("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 70 + String.valueOf(valueOf2).length()).append("Calling connect() while still connected, missing disconnect() for ").append(valueOf).append(" on ").append(valueOf2).toString());
            this.f4531j.zzb(zzqz(), mo6669b(), this.f4539r, mo6670c());
            this.f4524c.incrementAndGet();
        }
        this.f4539r = new zzh(this.f4524c.get());
        if (!this.f4531j.zza(zzqz(), mo6669b(), this.f4539r, mo6670c())) {
            String valueOf3 = String.valueOf(zzqz());
            String valueOf4 = String.valueOf(mo6669b());
            Log.e("GmsClient", new StringBuilder(String.valueOf(valueOf3).length() + 34 + String.valueOf(valueOf4).length()).append("unable to connect to service: ").append(valueOf3).append(" on ").append(valueOf4).toString());
            mo6665a(16, (Bundle) null, this.f4524c.get());
        }
    }

    /* renamed from: h */
    private void m6092h() {
        if (this.f4539r != null) {
            this.f4531j.zzb(zzqz(), mo6669b(), this.f4539r, mo6670c());
            this.f4539r = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo5671a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6664a(int i) {
        this.f4522a = i;
        this.f4525d = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6665a(int i, Bundle bundle, int i2) {
        this.f4523b.sendMessage(this.f4523b.obtainMessage(5, i2, -1, new zzk(i, bundle)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6666a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.f4523b.sendMessage(this.f4523b.obtainMessage(1, i2, -1, new zzj(i, iBinder, bundle)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6653a(int i, IInterface iInterface) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6667a(IInterface iInterface) {
        this.f4526e = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6668a(ConnectionResult connectionResult) {
        this.f4527f = connectionResult.getErrorCode();
        this.f4528g = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo6669b() {
        return "com.google.android.gms";
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final String mo6670c() {
        return this.f4544w == null ? this.f4529h.getClass().getName() : this.f4544w;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Bundle mo6671d() {
        return new Bundle();
    }

    public void disconnect() {
        this.f4524c.incrementAndGet();
        synchronized (this.f4538q) {
            int size = this.f4538q.size();
            for (int i = 0; i < size; i++) {
                ((zze) this.f4538q.get(i)).zzasg();
            }
            this.f4538q.clear();
        }
        synchronized (this.f4534m) {
            this.f4535n = null;
        }
        m6087b(1, (IInterface) null);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        IInterface iInterface;
        synchronized (this.f4533l) {
            i = this.f4540s;
            iInterface = this.f4537p;
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
        if (iInterface == null) {
            printWriter.println("null");
        } else {
            printWriter.append(mo5671a()).append("@").println(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f4526e > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.f4526e;
            String valueOf = String.valueOf(simpleDateFormat.format(new Date(this.f4526e)));
            append.println(new StringBuilder(String.valueOf(valueOf).length() + 21).append(j).append(" ").append(valueOf).toString());
        }
        if (this.f4525d > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.f4522a) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append(String.valueOf(this.f4522a));
                    break;
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.f4525d;
            String valueOf2 = String.valueOf(simpleDateFormat.format(new Date(this.f4525d)));
            append2.println(new StringBuilder(String.valueOf(valueOf2).length() + 21).append(j2).append(" ").append(valueOf2).toString());
        }
        if (this.f4528g > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.f4527f));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.f4528g;
            String valueOf3 = String.valueOf(simpleDateFormat.format(new Date(this.f4528g)));
            append3.println(new StringBuilder(String.valueOf(valueOf3).length() + 21).append(j3).append(" ").append(valueOf3).toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public final void mo6674e() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Set mo6675f() {
        return Collections.EMPTY_SET;
    }

    public Account getAccount() {
        return null;
    }

    public final Context getContext() {
        return this.f4529h;
    }

    public final Looper getLooper() {
        return this.f4530i;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.f4533l) {
            z = this.f4540s == 3;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.f4533l) {
            z = this.f4540s == 2;
        }
        return z;
    }

    public void zza(zzf zzf2) {
        this.f4536o = (zzf) zzab.zzb((Object) zzf2, (Object) "Connection progress callbacks cannot be null.");
        m6087b(2, (IInterface) null);
    }

    public void zza(zzf zzf2, ConnectionResult connectionResult) {
        this.f4536o = (zzf) zzab.zzb((Object) zzf2, (Object) "Connection progress callbacks cannot be null.");
        this.f4523b.sendMessage(this.f4523b.obtainMessage(3, this.f4524c.get(), connectionResult.getErrorCode(), connectionResult.getResolution()));
    }

    public void zza(zzq zzq, Set set) {
        try {
            GetServiceRequest zzn = new GetServiceRequest(this.f4543v).zzhl(this.f4529h.getPackageName()).zzn(mo6671d());
            if (set != null) {
                zzn.zzf(set);
            }
            if (zzafk()) {
                zzn.zzd(zzary()).zzb(zzq);
            } else if (zzasb()) {
                zzn.zzd(getAccount());
            }
            synchronized (this.f4534m) {
                if (this.f4535n != null) {
                    this.f4535n.zza((zzt) new zzg(this, this.f4524c.get()), zzn);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            zzgc(1);
        } catch (RemoteException e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    public boolean zzafk() {
        return false;
    }

    public boolean zzafz() {
        return false;
    }

    public Intent zzaga() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public Bundle zzamh() {
        return null;
    }

    public boolean zzanu() {
        return true;
    }

    public IBinder zzanv() {
        IBinder asBinder;
        synchronized (this.f4534m) {
            asBinder = this.f4535n == null ? null : this.f4535n.asBinder();
        }
        return asBinder;
    }

    public void zzarx() {
        int isGooglePlayServicesAvailable = this.f4532k.isGooglePlayServicesAvailable(this.f4529h);
        if (isGooglePlayServicesAvailable != 0) {
            m6087b(1, (IInterface) null);
            this.f4536o = new zzi();
            this.f4523b.sendMessage(this.f4523b.obtainMessage(3, this.f4524c.get(), isGooglePlayServicesAvailable));
            return;
        }
        zza(new zzi());
    }

    public final Account zzary() {
        return getAccount() != null ? getAccount() : new Account("<<default account>>", "com.google");
    }

    public final IInterface zzasa() {
        IInterface iInterface;
        synchronized (this.f4533l) {
            if (this.f4540s == 4) {
                throw new DeadObjectException();
            }
            mo6674e();
            zzab.zza(this.f4537p != null, (Object) "Client is connected but service is null");
            iInterface = this.f4537p;
        }
        return iInterface;
    }

    public boolean zzasb() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract IInterface zzbb(IBinder iBinder);

    public void zzgc(int i) {
        this.f4523b.sendMessage(this.f4523b.obtainMessage(4, this.f4524c.get(), i));
    }

    /* access modifiers changed from: protected */
    public abstract String zzqz();
}
