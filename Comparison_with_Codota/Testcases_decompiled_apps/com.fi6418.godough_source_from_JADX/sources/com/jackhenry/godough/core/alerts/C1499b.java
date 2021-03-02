package com.jackhenry.godough.core.alerts;

import android.content.Context;
import com.jackhenry.godough.core.C1752m;

/* renamed from: com.jackhenry.godough.core.alerts.b */
public class C1499b extends C1752m<Boolean> {

    /* renamed from: f */
    private long f5981f;

    public C1499b(Context context, long j) {
        super(context);
        this.f5981f = j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public Boolean mo9582j() {
        Boolean valueOf = Boolean.valueOf(new C1505h().mo9703a(this.f5981f));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return valueOf;
    }
}
