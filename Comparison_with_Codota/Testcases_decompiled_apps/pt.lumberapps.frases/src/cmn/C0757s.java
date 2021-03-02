package cmn;

import android.content.Context;

/* renamed from: cmn.s */
public final class C0757s {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f1870a;

    /* renamed from: b */
    private volatile String f1871b;

    private C0757s(Context context) {
        this.f1870a = context;
    }

    /* renamed from: a */
    public static C0757s m3315a(Context context) {
        long j;
        C0757s sVar = new C0757s(context);
        String string = sVar.f1870a.getSharedPreferences("ab_sdk_pref", 0).getString("cached_user_agent", (String) null);
        if (string == null) {
            sVar.f1871b = System.getProperty("http.agent") + " (deferred init)";
            j = 500;
        } else {
            sVar.f1871b = string;
            j = 5000;
        }
        C0725at.m3229a(new C0758t(sVar), j);
        return sVar;
    }

    /* renamed from: a */
    static /* synthetic */ void m3316a(C0757s sVar, String str) {
        sVar.f1871b = str;
        sVar.f1870a.getSharedPreferences("ab_sdk_pref", 0).edit().putString("cached_user_agent", str).apply();
    }

    /* renamed from: a */
    public final String mo3446a() {
        return this.f1871b;
    }
}
