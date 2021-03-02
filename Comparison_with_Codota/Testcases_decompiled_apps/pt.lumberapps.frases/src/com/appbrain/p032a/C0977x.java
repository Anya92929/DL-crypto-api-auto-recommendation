package com.appbrain.p032a;

import cmn.C0709ad;

/* renamed from: com.appbrain.a.x */
public class C0977x {

    /* renamed from: a */
    private float f2586a;

    public C0977x(int i) {
        this.f2586a = ((float) i) / C0709ad.m3186a(50.0f);
        if (this.f2586a == 0.0f) {
            this.f2586a = 1.0f;
        }
        new StringBuilder("factor is ").append(this.f2586a);
    }

    /* renamed from: a */
    public final float mo3901a(float f) {
        return this.f2586a * f;
    }

    /* renamed from: b */
    public final float mo3902b(float f) {
        return C0709ad.m3186a(this.f2586a * f);
    }

    /* renamed from: c */
    public final int mo3903c(float f) {
        return C0709ad.m3188b(this.f2586a * f);
    }
}
