package com.flurry.android;

import java.io.DataInput;

/* renamed from: com.flurry.android.e */
final class C0103e extends C0097ak {

    /* renamed from: a */
    String f191a;

    /* renamed from: b */
    byte f192b;

    /* renamed from: c */
    byte f193c;

    /* renamed from: d */
    C0101c f194d;

    C0103e() {
    }

    C0103e(DataInput dataInput) {
        this.f191a = dataInput.readUTF();
        this.f192b = dataInput.readByte();
        this.f193c = dataInput.readByte();
    }

    public final String toString() {
        return "{name: " + this.f191a + ", blockId: " + this.f192b + ", themeId: " + this.f193c;
    }
}
