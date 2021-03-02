package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.internal.zzqj;
import com.google.android.gms.internal.zzqk;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.tasks.t */
class C1969t extends zzqj {

    /* renamed from: a */
    private final List f7473a = new ArrayList();

    private C1969t(zzqk zzqk) {
        super(zzqk);
        this.f6908d.zza("TaskOnStopCallback", (zzqj) this);
    }

    /* renamed from: b */
    public static C1969t m8069b(Activity activity) {
        zzqk a = m7513a(activity);
        C1969t tVar = (C1969t) a.zza("TaskOnStopCallback", C1969t.class);
        return tVar == null ? new C1969t(a) : tVar;
    }

    /* renamed from: a */
    public void mo9831a(C1966q qVar) {
        synchronized (this.f7473a) {
            this.f7473a.add(new WeakReference(qVar));
        }
    }

    public void onStop() {
        synchronized (this.f7473a) {
            for (WeakReference weakReference : this.f7473a) {
                C1966q qVar = (C1966q) weakReference.get();
                if (qVar != null) {
                    qVar.mo9820a();
                }
            }
            this.f7473a.clear();
        }
    }
}
