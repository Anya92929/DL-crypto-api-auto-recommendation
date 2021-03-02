package com.google.android.gms.internal;

public abstract class zzapp extends zzapv {

    /* renamed from: a */
    protected zzapr f5895a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo7714a() {
        if (this.f5895a == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f5895a.mo8039a(); i2++) {
            i += this.f5895a.mo8043b(i2).mo7180a();
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo8023a(zzapn zzapn, int i) {
        int position = zzapn.getPosition();
        if (!zzapn.zzafp(i)) {
            return false;
        }
        int zzagj = zzapy.zzagj(i);
        C1501dl dlVar = new C1501dl(i, zzapn.zzad(position, zzapn.getPosition() - position));
        C1500dk dkVar = null;
        if (this.f5895a == null) {
            this.f5895a = new zzapr();
        } else {
            dkVar = this.f5895a.mo8040a(zzagj);
        }
        if (dkVar == null) {
            dkVar = new C1500dk();
            this.f5895a.mo8041a(zzagj, dkVar);
        }
        dkVar.mo7182a(dlVar);
        return true;
    }

    /* renamed from: aA */
    public zzapp clone() {
        zzapp zzapp = (zzapp) super.clone();
        zzapt.zza(this, zzapp);
        return zzapp;
    }

    /* renamed from: aB */
    public /* synthetic */ zzapv mo8025aB() {
        return (zzapp) clone();
    }

    public final Object zza(zzapq zzapq) {
        C1500dk a;
        if (this.f5895a == null || (a = this.f5895a.mo8040a(zzapy.zzagj(zzapq.tag))) == null) {
            return null;
        }
        return a.mo7181a(zzapq);
    }

    public void zza(zzapo zzapo) {
        if (this.f5895a != null) {
            for (int i = 0; i < this.f5895a.mo8039a(); i++) {
                this.f5895a.mo8043b(i).mo7183a(zzapo);
            }
        }
    }
}
