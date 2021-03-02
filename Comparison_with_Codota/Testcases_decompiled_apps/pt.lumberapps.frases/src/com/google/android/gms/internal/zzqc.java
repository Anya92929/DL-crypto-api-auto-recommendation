package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.common.util.zza;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpm;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.ReferenceQueue;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class zzqc implements Handler.Callback {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final Object f6877d = new Object();

    /* renamed from: e */
    private static zzqc f6878e;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public long f6879a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public long f6880b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public long f6881c;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Context f6882f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final GoogleApiAvailability f6883g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f6884h;

    /* renamed from: i */
    private final AtomicInteger f6885i;

    /* renamed from: j */
    private final SparseArray f6886j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final Map f6887k;

    /* renamed from: l */
    private zzpr f6888l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final Set f6889m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final Handler f6890n;

    /* renamed from: o */
    private final ReferenceQueue f6891o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final SparseArray f6892p;

    /* renamed from: q */
    private C1821ph f6893q;

    private zzqc(Context context) {
        this(context, GoogleApiAvailability.getInstance());
    }

    private zzqc(Context context, GoogleApiAvailability googleApiAvailability) {
        this.f6879a = 5000;
        this.f6880b = 120000;
        this.f6881c = 10000;
        this.f6884h = -1;
        this.f6885i = new AtomicInteger(1);
        this.f6886j = new SparseArray();
        this.f6887k = new ConcurrentHashMap(5, 0.75f, 1);
        this.f6888l = null;
        this.f6889m = new zza();
        this.f6891o = new ReferenceQueue();
        this.f6892p = new SparseArray();
        this.f6882f = context;
        HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
        handlerThread.start();
        this.f6890n = new Handler(handlerThread.getLooper(), this);
        this.f6883g = googleApiAvailability;
    }

    /* renamed from: a */
    private int m7491a(zzc zzc) {
        int andIncrement = this.f6885i.getAndIncrement();
        this.f6890n.sendMessage(this.f6890n.obtainMessage(6, andIncrement, 0, zzc));
        return andIncrement;
    }

    /* renamed from: a */
    private void m7495a(int i) {
        C1822pi piVar = (C1822pi) this.f6886j.get(i);
        if (piVar != null) {
            this.f6886j.delete(i);
            piVar.mo7642b(i);
            return;
        }
        Log.wtf("GoogleApiManager", new StringBuilder(64).append("onCleanupLeakInternal received for unknown instance: ").append(i).toString(), new Exception());
    }

    /* renamed from: a */
    private void m7496a(int i, boolean z) {
        C1822pi piVar = (C1822pi) this.f6886j.get(i);
        if (piVar != null) {
            if (!z) {
                this.f6886j.delete(i);
            }
            piVar.mo7638a(i, z);
            return;
        }
        Log.wtf("GoogleApiManager", new StringBuilder(52).append("onRelease received for unknown instance: ").append(i).toString(), new Exception());
    }

    /* renamed from: a */
    private void m7497a(zzc zzc, int i) {
        zzpj zzaob = zzc.zzaob();
        if (!this.f6887k.containsKey(zzaob)) {
            this.f6887k.put(zzaob, new C1822pi(this, zzc));
        }
        C1822pi piVar = (C1822pi) this.f6887k.get(zzaob);
        piVar.mo7637a(i);
        this.f6886j.put(i, piVar);
        piVar.m6563j();
        this.f6892p.put(i, new C1820pg(this, zzc, i, this.f6891o));
        if (this.f6893q == null || !this.f6893q.f5481c.get()) {
            this.f6893q = new C1821ph(this.f6891o, this.f6892p);
            this.f6893q.start();
        }
    }

    /* renamed from: a */
    private void m7498a(zzpi zzpi) {
        ((C1822pi) this.f6886j.get(zzpi.f6772sx)).mo7639a(zzpi);
    }

    /* renamed from: b */
    private void m7500b() {
        for (C1822pi piVar : this.f6887k.values()) {
            piVar.mo7641b();
            piVar.m6563j();
        }
    }

    /* renamed from: d */
    static /* synthetic */ zzpr m7502d(zzqc zzqc) {
        return null;
    }

    public static Pair zza(Context context, zzc zzc) {
        Pair create;
        synchronized (f6877d) {
            if (f6878e == null) {
                f6878e = new zzqc(context.getApplicationContext());
            }
            create = Pair.create(f6878e, Integer.valueOf(f6878e.m7491a(zzc)));
        }
        return create;
    }

    public static zzqc zzaqd() {
        zzqc zzqc;
        synchronized (f6877d) {
            zzqc = f6878e;
        }
        return zzqc;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo8965a(ConnectionResult connectionResult, int i) {
        if (!connectionResult.hasResolution() && !this.f6883g.isUserResolvableError(connectionResult.getErrorCode())) {
            return false;
        }
        this.f6883g.zza(this.f6882f, connectionResult, i);
        return true;
    }

    public boolean handleMessage(Message message) {
        boolean z = false;
        switch (message.what) {
            case 1:
                zza((zzpl) message.obj);
                break;
            case 2:
                m7495a(message.arg1);
                break;
            case 3:
                m7500b();
                break;
            case 4:
                m7498a((zzpi) message.obj);
                break;
            case 5:
                if (this.f6886j.get(message.arg1) != null) {
                    ((C1822pi) this.f6886j.get(message.arg1)).m6550a(new Status(17, "Error resolution was canceled by the user."));
                    break;
                }
                break;
            case 6:
                m7497a((zzc) message.obj, message.arg1);
                break;
            case 7:
                int i = message.arg1;
                if (message.arg2 == 1) {
                    z = true;
                }
                m7496a(i, z);
                break;
            case 8:
                if (this.f6887k.containsKey(message.obj)) {
                    ((C1822pi) this.f6887k.get(message.obj)).m6558e();
                    break;
                }
                break;
            case 9:
                if (this.f6887k.containsKey(message.obj)) {
                    ((C1822pi) this.f6887k.get(message.obj)).m6560g();
                    break;
                }
                break;
            case 10:
                if (this.f6887k.containsKey(message.obj)) {
                    ((C1822pi) this.f6887k.get(message.obj)).m6562i();
                    break;
                }
                break;
            default:
                Log.w("GoogleApiManager", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
                return false;
        }
        return true;
    }

    public void zza(ConnectionResult connectionResult, int i) {
        if (!mo8965a(connectionResult, i)) {
            this.f6890n.sendMessage(this.f6890n.obtainMessage(5, i, 0));
        }
    }

    public void zza(zzc zzc, int i, zzpm.zza zza) {
        this.f6890n.sendMessage(this.f6890n.obtainMessage(4, new zzpi.zza(zzc.getInstanceId(), i, zza)));
    }

    public void zza(zzc zzc, int i, zzqw zzqw, TaskCompletionSource taskCompletionSource) {
        this.f6890n.sendMessage(this.f6890n.obtainMessage(4, new zzpi.zzb(zzc.getInstanceId(), i, zzqw, taskCompletionSource)));
    }

    public void zza(zzpl zzpl) {
        for (zzpj zzpj : zzpl.zzaoq()) {
            C1822pi piVar = (C1822pi) this.f6887k.get(zzpj);
            if (piVar == null) {
                zzpl.cancel();
                return;
            } else if (piVar.mo7644d()) {
                zzpl.zza(zzpj, ConnectionResult.f4269rb);
            } else if (piVar.mo7643c() != null) {
                zzpl.zza(zzpj, piVar.mo7643c());
            } else {
                piVar.mo7640a(zzpl);
            }
        }
    }

    public void zza(zzpr zzpr) {
        synchronized (f6877d) {
            if (zzpr == null) {
                this.f6888l = null;
                this.f6889m.clear();
            }
        }
    }

    public void zzaoo() {
        this.f6890n.sendMessage(this.f6890n.obtainMessage(3));
    }

    public void zzd(int i, boolean z) {
        this.f6890n.sendMessage(this.f6890n.obtainMessage(7, i, z ? 1 : 2));
    }
}
