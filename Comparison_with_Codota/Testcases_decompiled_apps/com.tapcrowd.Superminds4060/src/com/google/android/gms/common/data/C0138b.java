package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.C0408dl;
import com.google.android.gms.internal.C0411dm;

/* renamed from: com.google.android.gms.common.data.b */
public abstract class C0138b {

    /* renamed from: jf */
    protected final C0140d f369jf;

    /* renamed from: ji */
    protected final int f370ji;

    /* renamed from: jj */
    private final int f371jj;

    public C0138b(C0140d dVar, int i) {
        this.f369jf = (C0140d) C0411dm.m944e(dVar);
        C0411dm.m945k(i >= 0 && i < dVar.getCount());
        this.f370ji = i;
        this.f371jj = dVar.mo3614q(this.f370ji);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3584a(String str, CharArrayBuffer charArrayBuffer) {
        this.f369jf.mo3595a(str, this.f370ji, this.f371jj, charArrayBuffer);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0138b)) {
            return false;
        }
        C0138b bVar = (C0138b) obj;
        return C0408dl.equal(Integer.valueOf(bVar.f370ji), Integer.valueOf(this.f370ji)) && C0408dl.equal(Integer.valueOf(bVar.f371jj), Integer.valueOf(this.f371jj)) && bVar.f369jf == this.f369jf;
    }

    /* access modifiers changed from: protected */
    public boolean getBoolean(String column) {
        return this.f369jf.mo3604d(column, this.f370ji, this.f371jj);
    }

    /* access modifiers changed from: protected */
    public byte[] getByteArray(String column) {
        return this.f369jf.mo3606e(column, this.f370ji, this.f371jj);
    }

    /* access modifiers changed from: protected */
    public int getInteger(String column) {
        return this.f369jf.mo3600b(column, this.f370ji, this.f371jj);
    }

    /* access modifiers changed from: protected */
    public long getLong(String column) {
        return this.f369jf.mo3594a(column, this.f370ji, this.f371jj);
    }

    /* access modifiers changed from: protected */
    public String getString(String column) {
        return this.f369jf.mo3602c(column, this.f370ji, this.f371jj);
    }

    public int hashCode() {
        return C0408dl.hashCode(Integer.valueOf(this.f370ji), Integer.valueOf(this.f371jj), this.f369jf);
    }

    public boolean isDataValid() {
        return !this.f369jf.isClosed();
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public Uri mo3591u(String str) {
        return this.f369jf.mo3607f(str, this.f370ji, this.f371jj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public boolean mo3592v(String str) {
        return this.f369jf.mo3609g(str, this.f370ji, this.f371jj);
    }
}
