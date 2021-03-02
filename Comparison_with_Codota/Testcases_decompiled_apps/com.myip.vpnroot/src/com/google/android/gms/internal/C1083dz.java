package com.google.android.gms.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchaseActivity;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C1098ei;

@C1130ez
/* renamed from: com.google.android.gms.internal.dz */
public class C1083dz extends C1098ei.C1099a implements ServiceConnection {

    /* renamed from: nr */
    private final Activity f3223nr;

    /* renamed from: sm */
    private C1107el f3224sm;

    /* renamed from: sn */
    private C1079dw f3225sn;

    /* renamed from: so */
    private final C1087ec f3226so;

    /* renamed from: sq */
    private C1090ee f3227sq;

    /* renamed from: sw */
    private Context f3228sw;

    /* renamed from: sx */
    private C1092eg f3229sx;

    /* renamed from: sy */
    private C1085ea f3230sy;

    /* renamed from: sz */
    private String f3231sz = null;

    public C1083dz(Activity activity) {
        this.f3223nr = activity;
        this.f3226so = C1087ec.m4314j(this.f3223nr.getApplicationContext());
    }

    /* renamed from: a */
    public static void m4309a(Context context, boolean z, C1078dv dvVar) {
        Intent intent = new Intent();
        intent.setClassName(context, InAppPurchaseActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", z);
        C1078dv.m4288a(intent, dvVar);
        context.startActivity(intent);
    }

    /* renamed from: a */
    private void m4310a(String str, boolean z, int i, Intent intent) {
        try {
            this.f3224sm.mo8435a(new C1086eb(this.f3228sw, str, z, i, intent, this.f3230sy));
        } catch (RemoteException e) {
            C1229gs.m4679W("Fail to invoke PlayStorePurchaseListener.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1001) {
            try {
                int d = C1089ed.m4323d(data);
                if (resultCode != -1 || d != 0) {
                    this.f3226so.mo8409a(this.f3230sy);
                    m4310a(this.f3229sx.getProductId(), false, resultCode, data);
                } else if (this.f3227sq.mo8417a(this.f3231sz, resultCode, data)) {
                    m4310a(this.f3229sx.getProductId(), true, resultCode, data);
                } else {
                    m4310a(this.f3229sx.getProductId(), false, resultCode, data);
                }
                this.f3229sx.recordPlayBillingResolution(d);
            } catch (RemoteException e) {
                C1229gs.m4679W("Fail to process purchase result.");
            } finally {
                this.f3231sz = null;
                this.f3223nr.finish();
            }
        }
    }

    public void onCreate() {
        C1078dv c = C1078dv.m4289c(this.f3223nr.getIntent());
        this.f3224sm = c.f3205lM;
        this.f3227sq = c.f3206lT;
        this.f3229sx = c.f3207si;
        this.f3225sn = new C1079dw(this.f3223nr.getApplicationContext());
        this.f3228sw = c.f3208sj;
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        this.f3223nr.bindService(intent, this, 1);
    }

    public void onDestroy() {
        this.f3223nr.unbindService(this);
        this.f3225sn.destroy();
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        this.f3225sn.mo8383r(service);
        try {
            this.f3231sz = this.f3227sq.mo8418cu();
            Bundle a = this.f3225sn.mo8379a(this.f3223nr.getPackageName(), this.f3229sx.getProductId(), this.f3231sz);
            PendingIntent pendingIntent = (PendingIntent) a.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int b = C1089ed.m4322b(a);
                this.f3229sx.recordPlayBillingResolution(b);
                m4310a(this.f3229sx.getProductId(), false, b, (Intent) null);
                this.f3223nr.finish();
                return;
            }
            this.f3230sy = new C1085ea(this.f3229sx.getProductId(), this.f3231sz);
            this.f3226so.mo8410b(this.f3230sy);
            Integer num = 0;
            Integer num2 = 0;
            Integer num3 = 0;
            this.f3223nr.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), num.intValue(), num2.intValue(), num3.intValue());
        } catch (IntentSender.SendIntentException | RemoteException e) {
            C1229gs.m4683d("Error when connecting in-app billing service", e);
            this.f3223nr.finish();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        C1229gs.m4677U("In-app billing service disconnected.");
        this.f3225sn.destroy();
    }
}
