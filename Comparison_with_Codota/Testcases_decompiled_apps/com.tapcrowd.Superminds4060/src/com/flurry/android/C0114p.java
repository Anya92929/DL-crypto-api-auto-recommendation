package com.flurry.android;

import java.io.DataOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.flurry.android.p */
final class C0114p {

    /* renamed from: a */
    final String f216a;

    /* renamed from: b */
    int f217b;

    /* renamed from: c */
    C0121w f218c;

    /* renamed from: d */
    long f219d;

    /* renamed from: e */
    List f220e;

    /* renamed from: f */
    private byte f221f;

    /* renamed from: g */
    private AtomicInteger f222g;

    C0114p(C0114p pVar, long j) {
        this(pVar.f216a, pVar.f221f, j);
        this.f218c = pVar.f218c;
        this.f219d = pVar.f219d;
    }

    C0114p(String str, byte b, long j) {
        this.f220e = new ArrayList();
        this.f222g = new AtomicInteger(0);
        this.f217b = this.f222g.incrementAndGet();
        this.f216a = str;
        this.f221f = b;
        this.f220e.add(new C0104f((byte) 1, j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3325a(C0104f fVar) {
        this.f220e.add(fVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final long mo3324a() {
        return ((C0104f) this.f220e.get(0)).f196b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3326a(DataOutput dataOutput) {
        dataOutput.writeShort(this.f217b);
        dataOutput.writeUTF(this.f216a);
        dataOutput.writeByte(this.f221f);
        if (this.f218c == null) {
            dataOutput.writeLong(0);
            dataOutput.writeLong(0);
            dataOutput.writeByte(0);
        } else {
            dataOutput.writeLong(this.f218c.f259a);
            dataOutput.writeLong(this.f218c.f263e);
            byte[] bArr = this.f218c.f265g;
            dataOutput.writeByte(bArr.length);
            dataOutput.write(bArr);
        }
        dataOutput.writeShort(this.f220e.size());
        for (C0104f fVar : this.f220e) {
            dataOutput.writeByte(fVar.f195a);
            dataOutput.writeLong(fVar.f196b);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{hook: " + this.f216a + ", ad: " + this.f218c.f262d + ", transitions: [");
        for (C0104f append : this.f220e) {
            sb.append(append);
            sb.append(",");
        }
        sb.append("]}");
        return sb.toString();
    }
}
