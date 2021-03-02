package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;

/* renamed from: com.google.android.gms.common.data.d */
public abstract class C0297d {

    /* renamed from: IC */
    protected final DataHolder f693IC;

    /* renamed from: JQ */
    protected int f694JQ;

    /* renamed from: JR */
    private int f695JR;

    public C0297d(DataHolder dataHolder, int i) {
        this.f693IC = (DataHolder) C0348n.m861i(dataHolder);
        mo4340ap(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4336a(String str, CharArrayBuffer charArrayBuffer) {
        this.f693IC.mo4302a(str, this.f694JQ, this.f695JR, charArrayBuffer);
    }

    /* renamed from: aQ */
    public boolean mo4337aQ(String str) {
        return this.f693IC.mo4303aQ(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: aR */
    public Uri mo4338aR(String str) {
        return this.f693IC.mo4314g(str, this.f694JQ, this.f695JR);
    }

    /* access modifiers changed from: protected */
    /* renamed from: aS */
    public boolean mo4339aS(String str) {
        return this.f693IC.mo4322h(str, this.f694JQ, this.f695JR);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ap */
    public void mo4340ap(int i) {
        C0348n.m850I(i >= 0 && i < this.f693IC.getCount());
        this.f694JQ = i;
        this.f695JR = this.f693IC.mo4304ar(this.f694JQ);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0297d)) {
            return false;
        }
        C0297d dVar = (C0297d) obj;
        return C0345m.equal(Integer.valueOf(dVar.f694JQ), Integer.valueOf(this.f694JQ)) && C0345m.equal(Integer.valueOf(dVar.f695JR), Integer.valueOf(this.f695JR)) && dVar.f693IC == this.f693IC;
    }

    /* access modifiers changed from: protected */
    /* renamed from: gA */
    public int mo4341gA() {
        return this.f694JQ;
    }

    /* access modifiers changed from: protected */
    public boolean getBoolean(String column) {
        return this.f693IC.mo4308d(column, this.f694JQ, this.f695JR);
    }

    /* access modifiers changed from: protected */
    public byte[] getByteArray(String column) {
        return this.f693IC.mo4312f(column, this.f694JQ, this.f695JR);
    }

    /* access modifiers changed from: protected */
    public float getFloat(String column) {
        return this.f693IC.mo4310e(column, this.f694JQ, this.f695JR);
    }

    /* access modifiers changed from: protected */
    public int getInteger(String column) {
        return this.f693IC.mo4305b(column, this.f694JQ, this.f695JR);
    }

    /* access modifiers changed from: protected */
    public long getLong(String column) {
        return this.f693IC.mo4301a(column, this.f694JQ, this.f695JR);
    }

    /* access modifiers changed from: protected */
    public String getString(String column) {
        return this.f693IC.mo4306c(column, this.f694JQ, this.f695JR);
    }

    public int hashCode() {
        return C0345m.hashCode(Integer.valueOf(this.f694JQ), Integer.valueOf(this.f695JR), this.f693IC);
    }

    public boolean isDataValid() {
        return !this.f693IC.isClosed();
    }
}
