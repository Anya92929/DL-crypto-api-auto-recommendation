package com.google.android.gms.internal;

import com.google.android.gms.internal.zzso;
import java.io.IOException;

public abstract class zzso<M extends zzso<M>> extends zzsu {
    protected zzsq zzbuj;

    public void writeTo(zzsn output) throws IOException {
        if (this.zzbuj != null) {
            for (int i = 0; i < this.zzbuj.size(); i++) {
                this.zzbuj.zzmG(i).writeTo(output);
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
        zzsr zzmF;
        if (this.zzbuj == null || (zzmF = this.zzbuj.zzmF(zzsx.zzmJ(zzsp.tag))) == null) {
            return null;
        }
        return zzmF.zzb(zzsp);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzsm zzsm, int i) throws IOException {
        int position = zzsm.getPosition();
        if (!zzsm.zzmo(i)) {
            return false;
        }
        int zzmJ = zzsx.zzmJ(i);
        zzsw zzsw = new zzsw(i, zzsm.zzz(position, zzsm.getPosition() - position));
        zzsr zzsr = null;
        if (this.zzbuj == null) {
            this.zzbuj = new zzsq();
        } else {
            zzsr = this.zzbuj.zzmF(zzmJ);
        }
        if (zzsr == null) {
            zzsr = new zzsr();
            this.zzbuj.zza(zzmJ, zzsr);
        }
        zzsr.zza(zzsw);
        return true;
    }

    /* access modifiers changed from: protected */
    public int zzz() {
        if (this.zzbuj == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzbuj.size(); i2++) {
            i += this.zzbuj.zzmG(i2).zzz();
        }
        return i;
    }
}
