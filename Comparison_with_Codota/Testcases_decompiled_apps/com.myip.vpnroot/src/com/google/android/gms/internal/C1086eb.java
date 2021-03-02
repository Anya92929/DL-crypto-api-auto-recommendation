package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.C1104ek;

@C1130ez
/* renamed from: com.google.android.gms.internal.eb */
public final class C1086eb extends C1104ek.C1105a implements ServiceConnection {
    private Context mContext;

    /* renamed from: sD */
    private boolean f3235sD = false;

    /* renamed from: sE */
    private int f3236sE;

    /* renamed from: sF */
    private Intent f3237sF;

    /* renamed from: sn */
    private C1079dw f3238sn;

    /* renamed from: su */
    private String f3239su;

    /* renamed from: sy */
    private C1085ea f3240sy;

    public C1086eb(Context context, String str, boolean z, int i, Intent intent, C1085ea eaVar) {
        this.f3239su = str;
        this.f3236sE = i;
        this.f3237sF = intent;
        this.f3235sD = z;
        this.mContext = context;
        this.f3240sy = eaVar;
    }

    public void finishPurchase() {
        int d = C1089ed.m4323d(this.f3237sF);
        if (this.f3236sE == -1 && d == 0) {
            this.f3238sn = new C1079dw(this.mContext);
            Context context = this.mContext;
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            Context context2 = this.mContext;
            context.bindService(intent, this, 1);
        }
    }

    public String getProductId() {
        return this.f3239su;
    }

    public Intent getPurchaseData() {
        return this.f3237sF;
    }

    public int getResultCode() {
        return this.f3236sE;
    }

    public boolean isVerified() {
        return this.f3235sD;
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        C1229gs.m4677U("In-app billing service connected.");
        this.f3238sn.mo8383r(service);
        String E = C1089ed.m4321E(C1089ed.m4324e(this.f3237sF));
        if (E != null) {
            if (this.f3238sn.mo8380c(this.mContext.getPackageName(), E) == 0) {
                C1087ec.m4314j(this.mContext).mo8409a(this.f3240sy);
            }
            this.mContext.unbindService(this);
            this.f3238sn.destroy();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        C1229gs.m4677U("In-app billing service disconnected.");
        this.f3238sn.destroy();
    }
}
