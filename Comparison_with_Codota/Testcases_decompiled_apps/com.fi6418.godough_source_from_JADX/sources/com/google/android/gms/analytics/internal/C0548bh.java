package com.google.android.gms.analytics.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.analytics.C0501a;
import com.google.android.gms.common.internal.C1009bf;

/* renamed from: com.google.android.gms.analytics.internal.bh */
public class C0548bh extends C0514aa {

    /* renamed from: a */
    private boolean f3797a;

    /* renamed from: b */
    private boolean f3798b;

    /* renamed from: c */
    private AlarmManager f3799c = ((AlarmManager) mo6886o().getSystemService("alarm"));

    protected C0548bh(C0516ac acVar) {
        super(acVar);
    }

    /* renamed from: f */
    private PendingIntent m3199f() {
        Intent intent = new Intent(mo6886o(), C0501a.class);
        intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        return PendingIntent.getBroadcast(mo6886o(), 0, intent, 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6598a() {
        ActivityInfo receiverInfo;
        try {
            this.f3799c.cancel(m3199f());
            if (mo6888q().mo6740j() > 0 && (receiverInfo = mo6886o().getPackageManager().getReceiverInfo(new ComponentName(mo6886o(), C0501a.class), 2)) != null && receiverInfo.enabled) {
                mo6869b("Receiver registered. Using alarm for local dispatch.");
                this.f3797a = true;
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    /* renamed from: b */
    public boolean mo6771b() {
        return this.f3797a;
    }

    /* renamed from: c */
    public boolean mo6772c() {
        return this.f3798b;
    }

    /* renamed from: d */
    public void mo6773d() {
        mo6596D();
        C1009bf.m4533a(mo6771b(), (Object) "Receiver not registered");
        long j = mo6888q().mo6740j();
        if (j > 0) {
            mo6774e();
            long b = mo6885n().mo6991b() + j;
            this.f3798b = true;
            this.f3799c.setInexactRepeating(2, b, 0, m3199f());
        }
    }

    /* renamed from: e */
    public void mo6774e() {
        mo6596D();
        this.f3798b = false;
        this.f3799c.cancel(m3199f());
    }
}
