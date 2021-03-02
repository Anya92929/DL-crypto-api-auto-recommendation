package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.C1009bf;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: com.google.android.gms.analytics.internal.m */
class C0565m {

    /* renamed from: a */
    final /* synthetic */ C0564l f3878a;

    /* renamed from: b */
    private int f3879b;

    /* renamed from: c */
    private ByteArrayOutputStream f3880c = new ByteArrayOutputStream();

    public C0565m(C0564l lVar) {
        this.f3878a = lVar;
    }

    /* renamed from: a */
    public int mo6820a() {
        return this.f3879b;
    }

    /* renamed from: a */
    public boolean mo6821a(C0556d dVar) {
        C1009bf.m4528a(dVar);
        if (this.f3879b + 1 > this.f3878a.mo6888q().mo6743m()) {
            return false;
        }
        String a = this.f3878a.mo6814a(dVar, false);
        if (a == null) {
            this.f3878a.mo6887p().mo6804a(dVar, "Error formatting hit");
            return true;
        }
        byte[] bytes = a.getBytes();
        int length = bytes.length;
        if (length > this.f3878a.mo6888q().mo6735e()) {
            this.f3878a.mo6887p().mo6804a(dVar, "Hit size exceeds the maximum size limit");
            return true;
        }
        if (this.f3880c.size() > 0) {
            length++;
        }
        if (length + this.f3880c.size() > this.f3878a.mo6888q().mo6737g()) {
            return false;
        }
        try {
            if (this.f3880c.size() > 0) {
                this.f3880c.write(C0564l.f3875c);
            }
            this.f3880c.write(bytes);
            this.f3879b++;
            return true;
        } catch (IOException e) {
            this.f3878a.mo6880e("Failed to write payload when batching hits", e);
            return true;
        }
    }

    /* renamed from: b */
    public byte[] mo6822b() {
        return this.f3880c.toByteArray();
    }
}
