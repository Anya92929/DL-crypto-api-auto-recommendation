package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import com.google.android.gms.common.stats.C1093b;
import java.util.HashMap;

/* renamed from: com.google.android.gms.common.internal.al */
final class C0988al extends C0987ak implements Handler.Callback {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final HashMap<C0989am, C0990an> f4699a = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f4700b;

    /* renamed from: c */
    private final Handler f4701c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1093b f4702d;

    /* renamed from: e */
    private final long f4703e;

    C0988al(Context context) {
        this.f4700b = context.getApplicationContext();
        this.f4701c = new Handler(context.getMainLooper(), this);
        this.f4702d = C1093b.m4761a();
        this.f4703e = 5000;
    }

    /* renamed from: a */
    private boolean m4393a(C0989am amVar, ServiceConnection serviceConnection, String str) {
        boolean a;
        C1009bf.m4529a(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f4699a) {
            C0990an anVar = this.f4699a.get(amVar);
            if (anVar != null) {
                this.f4701c.removeMessages(0, anVar);
                if (!anVar.mo7537a(serviceConnection)) {
                    anVar.mo7534a(serviceConnection, str);
                    switch (anVar.mo7538b()) {
                        case 1:
                            serviceConnection.onServiceConnected(anVar.mo7543e(), anVar.mo7542d());
                            break;
                        case 2:
                            anVar.mo7535a(str);
                            break;
                    }
                } else {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + amVar);
                }
            } else {
                anVar = new C0990an(this, amVar);
                anVar.mo7534a(serviceConnection, str);
                anVar.mo7535a(str);
                this.f4699a.put(amVar, anVar);
            }
            a = anVar.mo7536a();
        }
        return a;
    }

    /* renamed from: b */
    private void m4395b(C0989am amVar, ServiceConnection serviceConnection, String str) {
        C1009bf.m4529a(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f4699a) {
            C0990an anVar = this.f4699a.get(amVar);
            if (anVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + amVar);
            } else if (!anVar.mo7537a(serviceConnection)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + amVar);
            } else {
                anVar.mo7539b(serviceConnection, str);
                if (anVar.mo7541c()) {
                    this.f4701c.sendMessageDelayed(this.f4701c.obtainMessage(0, anVar), this.f4703e);
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo7527a(String str, ServiceConnection serviceConnection, String str2) {
        return m4393a(new C0989am(str), serviceConnection, str2);
    }

    /* renamed from: b */
    public void mo7528b(String str, ServiceConnection serviceConnection, String str2) {
        m4395b(new C0989am(str), serviceConnection, str2);
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                C0990an anVar = (C0990an) message.obj;
                synchronized (this.f4699a) {
                    if (anVar.mo7541c()) {
                        if (anVar.mo7536a()) {
                            anVar.mo7540b("GmsClientSupervisor");
                        }
                        this.f4699a.remove(anVar.f4712g);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
