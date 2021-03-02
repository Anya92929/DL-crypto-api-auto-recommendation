package com.google.android.gms.internal;

import com.google.android.gms.internal.C1712pg;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.pg */
public abstract class C1712pg<M extends C1712pg<M>> extends C1718pm {
    protected C1714pi awy;

    /* renamed from: a */
    public final <T> T mo10079a(C1713ph<M, T> phVar) {
        C1715pj gD;
        if (this.awy == null || (gD = this.awy.mo10094gD(C1721pp.m6108gH(phVar.tag))) == null) {
            return null;
        }
        return gD.mo10101b(phVar);
    }

    /* renamed from: a */
    public void mo4922a(C1710pf pfVar) throws IOException {
        if (this.awy != null) {
            for (int i = 0; i < this.awy.size(); i++) {
                this.awy.mo10095gE(i).mo10099a(pfVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo10080a(C1709pe peVar, int i) throws IOException {
        int position = peVar.getPosition();
        if (!peVar.mo10022gm(i)) {
            return false;
        }
        int gH = C1721pp.m6108gH(i);
        C1720po poVar = new C1720po(i, peVar.mo10042r(position, peVar.getPosition() - position));
        C1715pj pjVar = null;
        if (this.awy == null) {
            this.awy = new C1714pi();
        } else {
            pjVar = this.awy.mo10094gD(gH);
        }
        if (pjVar == null) {
            pjVar = new C1715pj();
            this.awy.mo10092a(gH, pjVar);
        }
        pjVar.mo10100a(poVar);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo10081a(M m) {
        return (this.awy == null || this.awy.isEmpty()) ? m.awy == null || m.awy.isEmpty() : this.awy.equals(m.awy);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo4924c() {
        if (this.awy == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.awy.size(); i2++) {
            i += this.awy.mo10095gE(i2).mo10102c();
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: qx */
    public final int mo10082qx() {
        if (this.awy == null || this.awy.isEmpty()) {
            return 0;
        }
        return this.awy.hashCode();
    }
}
