package com.google.android.gms.internal;

import com.google.android.gms.internal.zzso;
import java.io.IOException;

public abstract class zzso<M extends zzso<M>> extends zzsu {
    protected zzsq zzbuj;

    public void writeTo(zzsn zzsn) throws IOException {
        if (this.zzbuj != null) {
            for (int i = 0; i < this.zzbuj.mo6060a(); i++) {
                this.zzbuj.mo6063b(i).mo8280a(zzsn);
            }
        }
    }

    /* renamed from: zzJp */
    public M clone() throws CloneNotSupportedException {
        M m = (zzso) super.clone();
        zzss.zza(this, (zzso) m);
        return m;
    }

    public final <T> T zza(zzsp<M, T> zzsp) {
        C1203hh a;
        if (this.zzbuj == null || (a = this.zzbuj.mo6061a(zzsx.zzmJ(zzsp.tag))) == null) {
            return null;
        }
        return a.mo8279a(zzsp);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzsm zzsm, int i) throws IOException {
        int position = zzsm.getPosition();
        if (!zzsm.zzmo(i)) {
            return false;
        }
        int zzmJ = zzsx.zzmJ(i);
        C1204hi hiVar = new C1204hi(i, zzsm.zzz(position, zzsm.getPosition() - position));
        C1203hh hhVar = null;
        if (this.zzbuj == null) {
            this.zzbuj = new zzsq();
        } else {
            hhVar = this.zzbuj.mo6061a(zzmJ);
        }
        if (hhVar == null) {
            hhVar = new C1203hh();
            this.zzbuj.mo6062a(zzmJ, hhVar);
        }
        hhVar.mo8281a(hiVar);
        return true;
    }

    /* access modifiers changed from: protected */
    public int zzz() {
        if (this.zzbuj == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzbuj.mo6060a(); i2++) {
            i += this.zzbuj.mo6063b(i2).mo8278a();
        }
        return i;
    }
}
