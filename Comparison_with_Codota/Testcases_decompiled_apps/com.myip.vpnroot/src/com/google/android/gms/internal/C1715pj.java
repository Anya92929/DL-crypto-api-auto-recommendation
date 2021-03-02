package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.pj */
class C1715pj {
    private C1713ph<?, ?> awF;
    private Object awG;
    private List<C1720po> awH = new ArrayList();

    C1715pj() {
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[mo10102c()];
        mo10099a(C1710pf.m6017q(bArr));
        return bArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10099a(C1710pf pfVar) throws IOException {
        if (this.awG != null) {
            this.awF.mo10087a(this.awG, pfVar);
            return;
        }
        for (C1720po a : this.awH) {
            a.mo10108a(pfVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10100a(C1720po poVar) {
        this.awH.add(poVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public <T> T mo10101b(C1713ph<?, T> phVar) {
        if (this.awG == null) {
            this.awF = phVar;
            this.awG = phVar.mo10090l(this.awH);
            this.awH = null;
        } else if (this.awF != phVar) {
            throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
        }
        return this.awG;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo10102c() {
        int i = 0;
        if (this.awG != null) {
            return this.awF.mo10083A(this.awG);
        }
        Iterator<C1720po> it = this.awH.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().mo10109c() + i2;
        }
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof C1715pj)) {
            return false;
        }
        C1715pj pjVar = (C1715pj) o;
        if (this.awG == null || pjVar.awG == null) {
            if (this.awH != null && pjVar.awH != null) {
                return this.awH.equals(pjVar.awH);
            }
            try {
                return Arrays.equals(toByteArray(), pjVar.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else if (this.awF != pjVar.awF) {
            return false;
        } else {
            if (!this.awF.awz.isArray()) {
                return this.awG.equals(pjVar.awG);
            }
            if (this.awG instanceof byte[]) {
                return Arrays.equals((byte[]) this.awG, (byte[]) pjVar.awG);
            }
            if (this.awG instanceof int[]) {
                return Arrays.equals((int[]) this.awG, (int[]) pjVar.awG);
            }
            if (this.awG instanceof long[]) {
                return Arrays.equals((long[]) this.awG, (long[]) pjVar.awG);
            }
            if (this.awG instanceof float[]) {
                return Arrays.equals((float[]) this.awG, (float[]) pjVar.awG);
            }
            if (this.awG instanceof double[]) {
                return Arrays.equals((double[]) this.awG, (double[]) pjVar.awG);
            }
            return this.awG instanceof boolean[] ? Arrays.equals((boolean[]) this.awG, (boolean[]) pjVar.awG) : Arrays.deepEquals((Object[]) this.awG, (Object[]) pjVar.awG);
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
