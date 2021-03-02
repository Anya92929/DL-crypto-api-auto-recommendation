package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

/* renamed from: com.google.android.gms.security.a */
final class C1947a extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ Context f7405a;

    /* renamed from: b */
    final /* synthetic */ ProviderInstaller.ProviderInstallListener f7406b;

    C1947a(Context context, ProviderInstaller.ProviderInstallListener providerInstallListener) {
        this.f7405a = context;
        this.f7406b = providerInstallListener;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Integer doInBackground(Void... voidArr) {
        try {
            ProviderInstaller.installIfNeeded(this.f7405a);
            return 0;
        } catch (GooglePlayServicesRepairableException e) {
            return Integer.valueOf(e.getConnectionStatusCode());
        } catch (GooglePlayServicesNotAvailableException e2) {
            return Integer.valueOf(e2.errorCode);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Integer num) {
        if (num.intValue() == 0) {
            this.f7406b.onProviderInstalled();
            return;
        }
        this.f7406b.onProviderInstallFailed(num.intValue(), ProviderInstaller.f7402a.zza(this.f7405a, num.intValue(), "pi"));
    }
}
