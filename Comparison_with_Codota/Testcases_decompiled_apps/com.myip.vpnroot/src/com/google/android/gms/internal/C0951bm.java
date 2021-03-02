package com.google.android.gms.internal;

import android.text.TextUtils;

@C1130ez
/* renamed from: com.google.android.gms.internal.bm */
public final class C0951bm {

    /* renamed from: oU */
    private String f2903oU;

    /* renamed from: oV */
    private String f2904oV;

    /* renamed from: oW */
    private String f2905oW;

    public C0951bm() {
        this.f2903oU = null;
        this.f2904oV = null;
        this.f2905oW = null;
        this.f2903oU = "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html";
        this.f2904oV = null;
        this.f2905oW = null;
    }

    public C0951bm(String str, String str2, String str3) {
        this.f2903oU = null;
        this.f2904oV = null;
        this.f2905oW = null;
        if (TextUtils.isEmpty(str)) {
            this.f2903oU = "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html";
        } else {
            this.f2903oU = str;
        }
        this.f2904oV = str2;
        this.f2905oW = str3;
    }

    /* renamed from: bp */
    public String mo8134bp() {
        return this.f2903oU;
    }

    /* renamed from: bq */
    public String mo8135bq() {
        return this.f2904oV;
    }

    /* renamed from: br */
    public String mo8136br() {
        return this.f2905oW;
    }
}
