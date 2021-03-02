package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.zzab;

/* renamed from: com.google.android.gms.measurement.internal.as */
class C1901as extends BroadcastReceiver {

    /* renamed from: a */
    static final String f7112a = C1901as.class.getName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final zzx f7113b;

    /* renamed from: c */
    private boolean f7114c;

    /* renamed from: d */
    private boolean f7115d;

    C1901as(zzx zzx) {
        zzab.zzy(zzx);
        this.f7113b = zzx;
    }

    /* renamed from: d */
    private Context m7648d() {
        return this.f7113b.getContext();
    }

    /* renamed from: e */
    private zzp m7649e() {
        return this.f7113b.zzbsd();
    }

    /* renamed from: a */
    public void mo9251a() {
        this.f7113b.mo9646a();
        this.f7113b.zzwu();
        if (!this.f7114c) {
            m7648d().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f7115d = this.f7113b.zzbts().zzadj();
            m7649e().zzbtc().zzj("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f7115d));
            this.f7114c = true;
        }
    }

    /* renamed from: b */
    public void mo9252b() {
        this.f7113b.mo9646a();
        this.f7113b.zzwu();
        if (mo9253c()) {
            m7649e().zzbtc().log("Unregistering connectivity change receiver");
            this.f7114c = false;
            this.f7115d = false;
            try {
                m7648d().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                m7649e().zzbsv().zzj("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    /* renamed from: c */
    public boolean mo9253c() {
        this.f7113b.zzwu();
        return this.f7114c;
    }

    public void onReceive(Context context, Intent intent) {
        this.f7113b.mo9646a();
        String action = intent.getAction();
        m7649e().zzbtc().zzj("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zzadj = this.f7113b.zzbts().zzadj();
            if (this.f7115d != zzadj) {
                this.f7115d = zzadj;
                this.f7113b.zzbsc().zzm(new C1902at(this, zzadj));
                return;
            }
            return;
        }
        m7649e().zzbsx().zzj("NetworkBroadcastReceiver received unknown action", action);
    }
}
