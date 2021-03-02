package com.google.android.gms.p018c;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.C1009bf;
import java.util.HashMap;
import java.util.UUID;

/* renamed from: com.google.android.gms.c.be */
public final class C0643be extends C0626ao<C0643be> {

    /* renamed from: a */
    private String f4284a;

    /* renamed from: b */
    private int f4285b;

    /* renamed from: c */
    private int f4286c;

    /* renamed from: d */
    private String f4287d;

    /* renamed from: e */
    private String f4288e;

    /* renamed from: f */
    private boolean f4289f;

    /* renamed from: g */
    private boolean f4290g;

    /* renamed from: h */
    private boolean f4291h;

    public C0643be() {
        this(false);
    }

    public C0643be(boolean z) {
        this(z, m3702a());
    }

    public C0643be(boolean z, int i) {
        C1009bf.m4527a(i);
        this.f4285b = i;
        this.f4290g = z;
    }

    /* renamed from: a */
    static int m3702a() {
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits != 0) {
            return leastSignificantBits;
        }
        int mostSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L);
        if (mostSignificantBits != 0) {
            return mostSignificantBits;
        }
        Log.e("GAv4", "UUID.randomUUID() returned 0.");
        return Integer.MAX_VALUE;
    }

    /* renamed from: e */
    private void m3703e() {
        if (this.f4291h) {
            throw new IllegalStateException("ScreenViewInfo is immutable");
        }
    }

    /* renamed from: a */
    public void mo7097a(int i) {
        m3703e();
        this.f4285b = i;
    }

    /* renamed from: a */
    public void mo7010a(C0643be beVar) {
        if (!TextUtils.isEmpty(this.f4284a)) {
            beVar.mo7099a(this.f4284a);
        }
        if (this.f4285b != 0) {
            beVar.mo7097a(this.f4285b);
        }
        if (this.f4286c != 0) {
            beVar.mo7102b(this.f4286c);
        }
        if (!TextUtils.isEmpty(this.f4287d)) {
            beVar.mo7103b(this.f4287d);
        }
        if (!TextUtils.isEmpty(this.f4288e)) {
            beVar.mo7106c(this.f4288e);
        }
        if (this.f4289f) {
            beVar.mo7104b(this.f4289f);
        }
        if (this.f4290g) {
            beVar.mo7100a(this.f4290g);
        }
    }

    /* renamed from: a */
    public void mo7099a(String str) {
        m3703e();
        this.f4284a = str;
    }

    /* renamed from: a */
    public void mo7100a(boolean z) {
        m3703e();
        this.f4290g = z;
    }

    /* renamed from: b */
    public String mo7101b() {
        return this.f4284a;
    }

    /* renamed from: b */
    public void mo7102b(int i) {
        m3703e();
        this.f4286c = i;
    }

    /* renamed from: b */
    public void mo7103b(String str) {
        m3703e();
        this.f4287d = str;
    }

    /* renamed from: b */
    public void mo7104b(boolean z) {
        m3703e();
        this.f4289f = z;
    }

    /* renamed from: c */
    public int mo7105c() {
        return this.f4285b;
    }

    /* renamed from: c */
    public void mo7106c(String str) {
        m3703e();
        if (TextUtils.isEmpty(str)) {
            this.f4288e = null;
        } else {
            this.f4288e = str;
        }
    }

    /* renamed from: d */
    public String mo7107d() {
        return this.f4288e;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("screenName", this.f4284a);
        hashMap.put("interstitial", Boolean.valueOf(this.f4289f));
        hashMap.put("automatic", Boolean.valueOf(this.f4290g));
        hashMap.put("screenId", Integer.valueOf(this.f4285b));
        hashMap.put("referrerScreenId", Integer.valueOf(this.f4286c));
        hashMap.put("referrerScreenName", this.f4287d);
        hashMap.put("referrerUri", this.f4288e);
        return m3607a((Object) hashMap);
    }
}
