package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@C1130ez
/* renamed from: com.google.android.gms.internal.dx */
public class C1080dx extends C1206gg implements ServiceConnection {
    /* access modifiers changed from: private */
    public Context mContext;

    /* renamed from: mw */
    private final Object f3210mw = new Object();

    /* renamed from: sl */
    private boolean f3211sl = false;
    /* access modifiers changed from: private */

    /* renamed from: sm */
    public C1107el f3212sm;

    /* renamed from: sn */
    private C1079dw f3213sn;

    /* renamed from: so */
    private C1087ec f3214so;

    /* renamed from: sp */
    private List<C1085ea> f3215sp = null;
    /* access modifiers changed from: private */

    /* renamed from: sq */
    public C1090ee f3216sq;

    public C1080dx(Context context, C1107el elVar, C1090ee eeVar) {
        this.mContext = context;
        this.f3212sm = elVar;
        this.f3216sq = eeVar;
        this.f3213sn = new C1079dw(context);
        this.f3214so = C1087ec.m4314j(this.mContext);
        this.f3215sp = this.f3214so.mo8412d(10);
    }

    /* renamed from: a */
    private void m4299a(final C1085ea eaVar, String str, String str2) {
        final Intent intent = new Intent();
        intent.putExtra("RESPONSE_CODE", 0);
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        C1228gr.f3776wC.post(new Runnable() {
            public void run() {
                try {
                    if (C1080dx.this.f3216sq.mo8417a(eaVar.f3233sB, -1, intent)) {
                        C1080dx.this.f3212sm.mo8435a(new C1086eb(C1080dx.this.mContext, eaVar.f3234sC, true, -1, intent, eaVar));
                    } else {
                        C1080dx.this.f3212sm.mo8435a(new C1086eb(C1080dx.this.mContext, eaVar.f3234sC, false, -1, intent, eaVar));
                    }
                } catch (RemoteException e) {
                    C1229gs.m4679W("Fail to verify and dispatch pending transaction");
                }
            }
        });
    }

    /* renamed from: b */
    private void m4301b(long j) {
        do {
            if (!m4303c(j)) {
                C1229gs.m4679W("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.f3211sl);
    }

    /* renamed from: c */
    private boolean m4303c(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.f3210mw.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            C1229gs.m4679W("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    /* renamed from: cq */
    private void m4304cq() {
        if (!this.f3215sp.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (C1085ea next : this.f3215sp) {
                hashMap.put(next.f3234sC, next);
            }
            String str = null;
            while (true) {
                Bundle d = this.f3213sn.mo8381d(this.mContext.getPackageName(), str);
                if (d == null || C1089ed.m4322b(d) != 0) {
                    break;
                }
                ArrayList<String> stringArrayList = d.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = d.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = d.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                String string = d.getString("INAPP_CONTINUATION_TOKEN");
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= stringArrayList.size()) {
                        break;
                    }
                    if (hashMap.containsKey(stringArrayList.get(i2))) {
                        String str2 = stringArrayList.get(i2);
                        String str3 = stringArrayList2.get(i2);
                        String str4 = stringArrayList3.get(i2);
                        C1085ea eaVar = (C1085ea) hashMap.get(str2);
                        if (eaVar.f3233sB.equals(C1089ed.m4320D(str3))) {
                            m4299a(eaVar, str3, str4);
                            hashMap.remove(str2);
                        }
                    }
                    i = i2 + 1;
                }
                if (string == null || hashMap.isEmpty()) {
                    break;
                }
                str = string;
            }
            for (String str5 : hashMap.keySet()) {
                this.f3214so.mo8409a((C1085ea) hashMap.get(str5));
            }
        }
    }

    /* renamed from: cp */
    public void mo8384cp() {
        synchronized (this.f3210mw) {
            Context context = this.mContext;
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            Context context2 = this.mContext;
            context.bindService(intent, this, 1);
            m4301b(SystemClock.elapsedRealtime());
            this.mContext.unbindService(this);
            this.f3213sn.destroy();
        }
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        synchronized (this.f3210mw) {
            this.f3213sn.mo8383r(service);
            m4304cq();
            this.f3211sl = true;
            this.f3210mw.notify();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        C1229gs.m4677U("In-app billing service disconnected.");
        this.f3213sn.destroy();
    }

    public void onStop() {
        synchronized (this.f3210mw) {
            this.mContext.unbindService(this);
            this.f3213sn.destroy();
        }
    }
}
