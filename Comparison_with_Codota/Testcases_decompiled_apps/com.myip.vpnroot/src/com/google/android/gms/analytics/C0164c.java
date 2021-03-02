package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C1249hb;
import com.google.android.gms.internal.C1251hc;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.c */
class C0164c implements C0163b {
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */

    /* renamed from: xG */
    public ServiceConnection f164xG;
    /* access modifiers changed from: private */

    /* renamed from: xH */
    public C0166b f165xH;
    /* access modifiers changed from: private */

    /* renamed from: xI */
    public C0167c f166xI;
    /* access modifiers changed from: private */

    /* renamed from: xJ */
    public C1251hc f167xJ;

    /* renamed from: com.google.android.gms.analytics.c$a */
    final class C0165a implements ServiceConnection {
        C0165a() {
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            C0207z.m308V("service connected, binder: " + binder);
            try {
                if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(binder.getInterfaceDescriptor())) {
                    C0207z.m308V("bound to service");
                    C1251hc unused = C0164c.this.f167xJ = C1251hc.C1252a.m4754E(binder);
                    C0164c.this.m159dL();
                    return;
                }
            } catch (RemoteException e) {
            }
            try {
                C0164c.this.mContext.unbindService(this);
            } catch (IllegalArgumentException e2) {
            }
            ServiceConnection unused2 = C0164c.this.f164xG = null;
            C0164c.this.f166xI.mo3661a(2, (Intent) null);
        }

        public void onServiceDisconnected(ComponentName component) {
            C0207z.m308V("service disconnected: " + component);
            ServiceConnection unused = C0164c.this.f164xG = null;
            C0164c.this.f165xH.onDisconnected();
        }
    }

    /* renamed from: com.google.android.gms.analytics.c$b */
    public interface C0166b {
        void onConnected();

        void onDisconnected();
    }

    /* renamed from: com.google.android.gms.analytics.c$c */
    public interface C0167c {
        /* renamed from: a */
        void mo3661a(int i, Intent intent);
    }

    public C0164c(Context context, C0166b bVar, C0167c cVar) {
        this.mContext = context;
        if (bVar == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.f165xH = bVar;
        if (cVar == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.f166xI = cVar;
    }

    /* renamed from: dJ */
    private C1251hc m158dJ() {
        mo3655dK();
        return this.f167xJ;
    }

    /* access modifiers changed from: private */
    /* renamed from: dL */
    public void m159dL() {
        m160dM();
    }

    /* renamed from: dM */
    private void m160dM() {
        this.f165xH.onConnected();
    }

    /* renamed from: a */
    public void mo3651a(Map<String, String> map, long j, String str, List<C1249hb> list) {
        try {
            m158dJ().mo8706a(map, j, str, list);
        } catch (RemoteException e) {
            C0207z.m306T("sendHit failed: " + e);
        }
    }

    public void connect() {
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.analytics.service.AnalyticsService"));
        intent.putExtra("app_package_name", this.mContext.getPackageName());
        if (this.f164xG != null) {
            C0207z.m306T("Calling connect() while still connected, missing disconnect().");
            return;
        }
        this.f164xG = new C0165a();
        boolean bindService = this.mContext.bindService(intent, this.f164xG, 129);
        C0207z.m308V("connect: bindService returned " + bindService + " for " + intent);
        if (!bindService) {
            this.f164xG = null;
            this.f166xI.mo3661a(1, (Intent) null);
        }
    }

    /* renamed from: dI */
    public void mo3653dI() {
        try {
            m158dJ().mo8707dI();
        } catch (RemoteException e) {
            C0207z.m306T("clear hits failed: " + e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: dK */
    public void mo3655dK() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void disconnect() {
        this.f167xJ = null;
        if (this.f164xG != null) {
            try {
                this.mContext.unbindService(this.f164xG);
            } catch (IllegalArgumentException | IllegalStateException e) {
            }
            this.f164xG = null;
            this.f165xH.onDisconnected();
        }
    }

    public boolean isConnected() {
        return this.f167xJ != null;
    }
}
