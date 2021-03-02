package com.flurry.android;

import java.io.DataInput;

public final class AdImage extends C0097ak {

    /* renamed from: a */
    long f3a;

    /* renamed from: b */
    int f4b;

    /* renamed from: c */
    int f5c;

    /* renamed from: d */
    String f6d;

    /* renamed from: e */
    byte[] f7e;

    AdImage() {
    }

    AdImage(DataInput dataInput) {
        mo3225a(dataInput);
    }

    public final long getId() {
        return this.f3a;
    }

    public final int getWidth() {
        return this.f4b;
    }

    public final int getHeight() {
        return this.f5c;
    }

    public final String getMimeType() {
        return this.f6d;
    }

    public final byte[] getImageData() {
        return this.f7e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3225a(DataInput dataInput) {
        this.f3a = dataInput.readLong();
        this.f4b = dataInput.readInt();
        this.f5c = dataInput.readInt();
        this.f6d = dataInput.readUTF();
        this.f7e = new byte[dataInput.readInt()];
        dataInput.readFully(this.f7e);
    }
}
