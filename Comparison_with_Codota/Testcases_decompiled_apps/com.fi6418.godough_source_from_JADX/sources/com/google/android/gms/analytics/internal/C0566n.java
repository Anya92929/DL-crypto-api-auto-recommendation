package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.analytics.internal.n */
public class C0566n extends C0514aa {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public SharedPreferences f3881a;

    /* renamed from: b */
    private long f3882b;

    /* renamed from: c */
    private long f3883c = -1;

    /* renamed from: d */
    private final C0568p f3884d = new C0568p(this, "monitoring", mo6888q().mo6730G());

    protected C0566n(C0516ac acVar) {
        super(acVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6598a() {
        this.f3881a = mo6886o().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    /* renamed from: a */
    public void mo6823a(String str) {
        mo6884m();
        mo6596D();
        SharedPreferences.Editor edit = this.f3881a.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (!edit.commit()) {
            mo6879e("Failed to commit campaign data");
        }
    }

    /* renamed from: b */
    public long mo6824b() {
        mo6884m();
        mo6596D();
        if (this.f3882b == 0) {
            long j = this.f3881a.getLong("first_run", 0);
            if (j != 0) {
                this.f3882b = j;
            } else {
                long a = mo6885n().mo6990a();
                SharedPreferences.Editor edit = this.f3881a.edit();
                edit.putLong("first_run", a);
                if (!edit.commit()) {
                    mo6879e("Failed to commit first run time");
                }
                this.f3882b = a;
            }
        }
        return this.f3882b;
    }

    /* renamed from: c */
    public C0569q mo6825c() {
        return new C0569q(mo6885n(), mo6824b());
    }

    /* renamed from: d */
    public long mo6826d() {
        mo6884m();
        mo6596D();
        if (this.f3883c == -1) {
            this.f3883c = this.f3881a.getLong("last_dispatch", 0);
        }
        return this.f3883c;
    }

    /* renamed from: e */
    public void mo6827e() {
        mo6884m();
        mo6596D();
        long a = mo6885n().mo6990a();
        SharedPreferences.Editor edit = this.f3881a.edit();
        edit.putLong("last_dispatch", a);
        edit.apply();
        this.f3883c = a;
    }

    /* renamed from: f */
    public String mo6828f() {
        mo6884m();
        mo6596D();
        String string = this.f3881a.getString("installation_campaign", (String) null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    /* renamed from: g */
    public C0568p mo6829g() {
        return this.f3884d;
    }
}
