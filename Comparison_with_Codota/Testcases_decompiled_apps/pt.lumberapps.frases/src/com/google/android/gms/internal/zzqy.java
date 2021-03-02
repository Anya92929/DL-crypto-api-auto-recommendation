package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.support.p009v4.p019f.C0136a;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzd;
import com.google.android.gms.internal.zzpm;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class zzqy {

    /* renamed from: b */
    private static final zzpm.zza[] f6933b = new zzpm.zza[0];

    /* renamed from: a */
    final Set f6934a;

    /* renamed from: c */
    private final C1833pt f6935c;

    /* renamed from: d */
    private final Map f6936d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C1834pu f6937e;

    public zzqy(Api.zzc zzc, Api.zze zze) {
        this.f6934a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.f6935c = new C1831pr(this);
        this.f6937e = null;
        this.f6936d = new C0136a();
        this.f6936d.put(zzc, zze);
    }

    public zzqy(Map map) {
        this.f6934a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.f6935c = new C1831pr(this);
        this.f6937e = null;
        this.f6936d = map;
    }

    /* renamed from: a */
    static /* synthetic */ zzd m7540a(zzqy zzqy) {
        return null;
    }

    /* renamed from: a */
    private static void m7541a(zzpm.zza zza, zzd zzd, IBinder iBinder) {
        if (zza.isReady()) {
            zza.zza(new C1832ps(zza, zzd, iBinder, (C1831pr) null));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            zza.zza((C1833pt) null);
            zza.cancel();
            zzd.remove(zza.zzaoj().intValue());
        } else {
            C1832ps psVar = new C1832ps(zza, zzd, iBinder, (C1831pr) null);
            zza.zza(psVar);
            try {
                iBinder.linkToDeath(psVar, 0);
            } catch (RemoteException e) {
                zza.cancel();
                zzd.remove(zza.zzaoj().intValue());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9008a(zzpm.zza zza) {
        this.f6934a.add(zza);
        zza.zza(this.f6935c);
    }

    public void dump(PrintWriter printWriter) {
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f6934a.size());
    }

    public void release() {
        for (zzpm.zza zza : (zzpm.zza[]) this.f6934a.toArray(f6933b)) {
            zza.zza((C1833pt) null);
            if (zza.zzaoj() != null) {
                zza.zzaor();
                m7541a(zza, (zzd) null, ((Api.zze) this.f6936d.get(zza.zzans())).zzanv());
                this.f6934a.remove(zza);
            } else if (zza.zzaov()) {
                this.f6934a.remove(zza);
            }
        }
    }

    public void zza(C1834pu puVar) {
        if (this.f6934a.isEmpty()) {
            puVar.mo7645a();
        }
        this.f6937e = puVar;
    }

    public void zzaqz() {
        for (zzpm.zza zzaa : (zzpm.zza[]) this.f6934a.toArray(f6933b)) {
            zzaa.zzaa(new Status(8, "The connection to Google Play services was lost"));
        }
    }

    public boolean zzara() {
        for (zzpm.zza isReady : (zzpm.zza[]) this.f6934a.toArray(f6933b)) {
            if (!isReady.isReady()) {
                return true;
            }
        }
        return false;
    }
}
