package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.C1098ei;
import com.google.android.gms.internal.C1111en;
import com.google.android.gms.internal.C1229gs;

public final class InAppPurchaseActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.purchase.InAppPurchaseActivity";
    public static final String SIMPLE_CLASS_NAME = "InAppPurchaseActivity";

    /* renamed from: xk */
    private C1098ei f56xk;

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (this.f56xk != null) {
                this.f56xk.onActivityResult(requestCode, resultCode, data);
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not forward onActivityResult to in-app purchase manager:", e);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f56xk = C1111en.m4345e(this);
        if (this.f56xk == null) {
            C1229gs.m4679W("Could not create in-app purchase manager.");
            finish();
            return;
        }
        try {
            this.f56xk.onCreate();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not forward onCreate to in-app purchase manager:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            if (this.f56xk != null) {
                this.f56xk.onDestroy();
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not forward onDestroy to in-app purchase manager:", e);
        }
        super.onDestroy();
    }
}
