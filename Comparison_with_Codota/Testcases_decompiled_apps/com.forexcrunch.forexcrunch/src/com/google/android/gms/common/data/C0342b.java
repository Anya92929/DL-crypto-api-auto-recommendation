package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.C0618r;
import com.google.android.gms.internal.C0621s;

/* renamed from: com.google.android.gms.common.data.b */
public abstract class C0342b {

    /* renamed from: S */
    protected final C0344d f795S;

    /* renamed from: V */
    protected final int f796V;

    /* renamed from: W */
    private final int f797W;

    public C0342b(C0344d dVar, int i) {
        this.f795S = (C0344d) C0621s.m1890d(dVar);
        C0621s.m1884a(i >= 0 && i < dVar.getCount());
        this.f796V = i;
        this.f797W = dVar.mo4054e(this.f796V);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4037a(String str, CharArrayBuffer charArrayBuffer) {
        this.f795S.mo4048a(str, this.f796V, this.f797W, charArrayBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Uri mo4038d(String str) {
        return this.f795S.mo4056f(str, this.f796V, this.f797W);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo4039e(String str) {
        return this.f795S.mo4057g(str, this.f796V, this.f797W);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0342b)) {
            return false;
        }
        C0342b bVar = (C0342b) obj;
        return C0618r.m1881a(Integer.valueOf(bVar.f796V), Integer.valueOf(this.f796V)) && C0618r.m1881a(Integer.valueOf(bVar.f797W), Integer.valueOf(this.f797W)) && bVar.f795S == this.f795S;
    }

    /* access modifiers changed from: protected */
    public boolean getBoolean(String column) {
        return this.f795S.mo4052d(column, this.f796V, this.f797W);
    }

    /* access modifiers changed from: protected */
    public byte[] getByteArray(String column) {
        return this.f795S.mo4055e(column, this.f796V, this.f797W);
    }

    /* access modifiers changed from: protected */
    public int getInteger(String column) {
        return this.f795S.mo4049b(column, this.f796V, this.f797W);
    }

    /* access modifiers changed from: protected */
    public long getLong(String column) {
        return this.f795S.mo4047a(column, this.f796V, this.f797W);
    }

    /* access modifiers changed from: protected */
    public String getString(String column) {
        return this.f795S.mo4050c(column, this.f796V, this.f797W);
    }

    public int hashCode() {
        return C0618r.hashCode(Integer.valueOf(this.f796V), Integer.valueOf(this.f797W), this.f795S);
    }

    public boolean isDataValid() {
        return !this.f795S.isClosed();
    }
}
