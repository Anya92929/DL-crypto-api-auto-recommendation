package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzai;
import com.google.android.gms.common.util.zzw;

/* renamed from: com.google.firebase.e */
public final class C1978e {

    /* renamed from: a */
    private final String f7495a;

    /* renamed from: b */
    private final String f7496b;

    /* renamed from: c */
    private final String f7497c;

    /* renamed from: d */
    private final String f7498d;

    /* renamed from: e */
    private final String f7499e;

    /* renamed from: f */
    private final String f7500f;

    private C1978e(String str, String str2, String str3, String str4, String str5, String str6) {
        zzab.zza(!zzw.zzib(str), (Object) "ApplicationId must be set.");
        this.f7496b = str;
        this.f7495a = str2;
        this.f7497c = str3;
        this.f7498d = str4;
        this.f7499e = str5;
        this.f7500f = str6;
    }

    /* renamed from: a */
    public static C1978e m8095a(Context context) {
        zzai zzai = new zzai(context);
        String string = zzai.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new C1978e(string, zzai.getString("google_api_key"), zzai.getString("firebase_database_url"), zzai.getString("ga_trackingId"), zzai.getString("gcm_defaultSenderId"), zzai.getString("google_storage_bucket"));
    }

    /* renamed from: a */
    public String mo9849a() {
        return this.f7496b;
    }

    /* renamed from: b */
    public String mo9850b() {
        return this.f7499e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1978e)) {
            return false;
        }
        C1978e eVar = (C1978e) obj;
        return zzaa.equal(this.f7496b, eVar.f7496b) && zzaa.equal(this.f7495a, eVar.f7495a) && zzaa.equal(this.f7497c, eVar.f7497c) && zzaa.equal(this.f7498d, eVar.f7498d) && zzaa.equal(this.f7499e, eVar.f7499e) && zzaa.equal(this.f7500f, eVar.f7500f);
    }

    public int hashCode() {
        return zzaa.hashCode(this.f7496b, this.f7495a, this.f7497c, this.f7498d, this.f7499e, this.f7500f);
    }

    public String toString() {
        return zzaa.zzx(this).zzg("applicationId", this.f7496b).zzg("apiKey", this.f7495a).zzg("databaseUrl", this.f7497c).zzg("gcmSenderId", this.f7499e).zzg("storageBucket", this.f7500f).toString();
    }
}
