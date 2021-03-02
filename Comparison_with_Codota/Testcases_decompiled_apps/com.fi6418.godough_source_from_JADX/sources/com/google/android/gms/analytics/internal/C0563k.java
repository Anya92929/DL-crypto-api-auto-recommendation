package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.common.internal.C1009bf;

/* renamed from: com.google.android.gms.analytics.internal.k */
class C0563k extends BroadcastReceiver {

    /* renamed from: a */
    static final String f3871a = C0563k.class.getName();

    /* renamed from: b */
    private final C0516ac f3872b;

    /* renamed from: c */
    private boolean f3873c;

    /* renamed from: d */
    private boolean f3874d;

    C0563k(C0516ac acVar) {
        C1009bf.m4528a(acVar);
        this.f3872b = acVar;
    }

    /* renamed from: g */
    private void m3271g() {
        m3273i();
        m3274j();
    }

    /* renamed from: h */
    private Context m3272h() {
        return this.f3872b.mo6600b();
    }

    /* renamed from: i */
    private C0562j m3273i() {
        return this.f3872b.mo6604f();
    }

    /* renamed from: j */
    private C0572t m3274j() {
        return this.f3872b.mo6607i();
    }

    /* renamed from: a */
    public void mo6807a() {
        m3271g();
        if (!this.f3873c) {
            Context h = m3272h();
            h.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
            intentFilter.addCategory(h.getPackageName());
            h.registerReceiver(this, intentFilter);
            this.f3874d = mo6812f();
            this.f3872b.mo6604f().mo6866a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f3874d));
            this.f3873c = true;
        }
    }

    /* renamed from: b */
    public void mo6808b() {
        if (mo6810d()) {
            this.f3872b.mo6604f().mo6869b("Unregistering connectivity change receiver");
            this.f3873c = false;
            this.f3874d = false;
            try {
                m3272h().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                m3273i().mo6880e("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    /* renamed from: c */
    public void mo6809c() {
        if (Build.VERSION.SDK_INT > 10) {
            Context h = m3272h();
            Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
            intent.addCategory(h.getPackageName());
            intent.putExtra(f3871a, true);
            h.sendOrderedBroadcast(intent, (String) null);
        }
    }

    /* renamed from: d */
    public boolean mo6810d() {
        return this.f3873c;
    }

    /* renamed from: e */
    public boolean mo6811e() {
        if (!this.f3873c) {
            this.f3872b.mo6604f().mo6879e("Connectivity unknown. Receiver not registered");
        }
        return this.f3874d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public boolean mo6812f() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) m3272h().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (SecurityException e) {
            return false;
        }
    }

    public void onReceive(Context context, Intent intent) {
        m3271g();
        String action = intent.getAction();
        this.f3872b.mo6604f().mo6866a("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean f = mo6812f();
            if (this.f3874d != f) {
                this.f3874d = f;
                m3274j().mo6850a(f);
            }
        } else if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.f3872b.mo6604f().mo6877d("NetworkBroadcastReceiver received unknown action", action);
        } else if (!intent.hasExtra(f3871a)) {
            m3274j().mo6855f();
        }
    }
}
