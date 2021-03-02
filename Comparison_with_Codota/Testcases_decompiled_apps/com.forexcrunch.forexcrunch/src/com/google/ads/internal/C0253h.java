package com.google.ads.internal;

import android.content.Context;
import com.google.ads.AdSize;

/* renamed from: com.google.ads.internal.h */
public class C0253h {

    /* renamed from: a */
    public static final C0253h f584a = new C0253h((AdSize) null, true);

    /* renamed from: b */
    private AdSize f585b;

    /* renamed from: c */
    private boolean f586c;

    /* renamed from: d */
    private final boolean f587d;

    private C0253h(AdSize adSize, boolean z) {
        this.f585b = adSize;
        this.f587d = z;
    }

    /* renamed from: a */
    public static C0253h m393a(AdSize adSize, Context context) {
        return new C0253h(AdSize.createAdSize(adSize, context), false);
    }

    /* renamed from: a */
    public static C0253h m392a(AdSize adSize) {
        return m393a(adSize, (Context) null);
    }

    /* renamed from: a */
    public boolean mo3609a() {
        return this.f587d;
    }

    /* renamed from: b */
    public boolean mo3611b() {
        return this.f586c;
    }

    /* renamed from: c */
    public AdSize mo3612c() {
        return this.f585b;
    }

    /* renamed from: b */
    public void mo3610b(AdSize adSize) {
        if (!this.f587d) {
            this.f585b = adSize;
        }
    }

    /* renamed from: a */
    public void mo3608a(boolean z) {
        this.f586c = z;
    }
}
