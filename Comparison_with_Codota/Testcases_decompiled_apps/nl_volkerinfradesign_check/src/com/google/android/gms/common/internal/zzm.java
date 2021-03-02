package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class zzm extends zzl implements Handler.Callback {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final HashMap<C0743a, zzb> f3008a = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f3009b;

    /* renamed from: c */
    private final Handler f3010c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final com.google.android.gms.common.stats.zzb f3011d;

    /* renamed from: e */
    private final long f3012e;

    /* renamed from: com.google.android.gms.common.internal.zzm$a */
    static final class C0743a {

        /* renamed from: a */
        private final String f3013a;

        /* renamed from: b */
        private final ComponentName f3014b;

        public C0743a(ComponentName componentName) {
            this.f3013a = null;
            this.f3014b = (ComponentName) zzx.zzz(componentName);
        }

        public C0743a(String str) {
            this.f3013a = zzx.zzcM(str);
            this.f3014b = null;
        }

        /* renamed from: a */
        public Intent mo5512a() {
            return this.f3013a != null ? new Intent(this.f3013a).setPackage("com.google.android.gms") : new Intent().setComponent(this.f3014b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0743a)) {
                return false;
            }
            C0743a aVar = (C0743a) obj;
            return zzw.equal(this.f3013a, aVar.f3013a) && zzw.equal(this.f3014b, aVar.f3014b);
        }

        public int hashCode() {
            return zzw.hashCode(this.f3013a, this.f3014b);
        }

        public String toString() {
            return this.f3013a == null ? this.f3014b.flattenToString() : this.f3013a;
        }
    }

    final class zzb {

        /* renamed from: b */
        private final zza f3016b = new zza();
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final Set<ServiceConnection> f3017c = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: d */
        public int f3018d = 2;

        /* renamed from: e */
        private boolean f3019e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public IBinder f3020f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public final C0743a f3021g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public ComponentName f3022h;

        public class zza implements ServiceConnection {
            public zza() {
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (zzm.this.f3008a) {
                    IBinder unused = zzb.this.f3020f = iBinder;
                    ComponentName unused2 = zzb.this.f3022h = componentName;
                    for (ServiceConnection onServiceConnected : zzb.this.f3017c) {
                        onServiceConnected.onServiceConnected(componentName, iBinder);
                    }
                    int unused3 = zzb.this.f3018d = 1;
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (zzm.this.f3008a) {
                    IBinder unused = zzb.this.f3020f = null;
                    ComponentName unused2 = zzb.this.f3022h = componentName;
                    for (ServiceConnection onServiceDisconnected : zzb.this.f3017c) {
                        onServiceDisconnected.onServiceDisconnected(componentName);
                    }
                    int unused3 = zzb.this.f3018d = 2;
                }
            }
        }

        public zzb(C0743a aVar) {
            this.f3021g = aVar;
        }

        /* renamed from: a */
        public void mo5516a(ServiceConnection serviceConnection, String str) {
            zzm.this.f3011d.zza(zzm.this.f3009b, serviceConnection, str, this.f3021g.mo5512a());
            this.f3017c.add(serviceConnection);
        }

        @TargetApi(14)
        /* renamed from: a */
        public void mo5517a(String str) {
            this.f3018d = 3;
            this.f3019e = zzm.this.f3011d.zza(zzm.this.f3009b, str, this.f3021g.mo5512a(), this.f3016b, 129);
            if (!this.f3019e) {
                this.f3018d = 2;
                try {
                    zzm.this.f3011d.zza(zzm.this.f3009b, this.f3016b);
                } catch (IllegalArgumentException e) {
                }
            }
        }

        /* renamed from: a */
        public boolean mo5518a() {
            return this.f3019e;
        }

        /* renamed from: a */
        public boolean mo5519a(ServiceConnection serviceConnection) {
            return this.f3017c.contains(serviceConnection);
        }

        /* renamed from: b */
        public int mo5520b() {
            return this.f3018d;
        }

        /* renamed from: b */
        public void mo5521b(ServiceConnection serviceConnection, String str) {
            zzm.this.f3011d.zzb(zzm.this.f3009b, serviceConnection);
            this.f3017c.remove(serviceConnection);
        }

        /* renamed from: b */
        public void mo5522b(String str) {
            zzm.this.f3011d.zza(zzm.this.f3009b, this.f3016b);
            this.f3019e = false;
            this.f3018d = 2;
        }

        /* renamed from: c */
        public boolean mo5523c() {
            return this.f3017c.isEmpty();
        }

        /* renamed from: d */
        public IBinder mo5524d() {
            return this.f3020f;
        }

        /* renamed from: e */
        public ComponentName mo5525e() {
            return this.f3022h;
        }
    }

    zzm(Context context) {
        this.f3009b = context.getApplicationContext();
        this.f3010c = new Handler(context.getMainLooper(), this);
        this.f3011d = com.google.android.gms.common.stats.zzb.zzrP();
        this.f3012e = 5000;
    }

    /* renamed from: a */
    private boolean m3931a(C0743a aVar, ServiceConnection serviceConnection, String str) {
        boolean a;
        zzx.zzb(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f3008a) {
            zzb zzb2 = this.f3008a.get(aVar);
            if (zzb2 != null) {
                this.f3010c.removeMessages(0, zzb2);
                if (!zzb2.mo5519a(serviceConnection)) {
                    zzb2.mo5516a(serviceConnection, str);
                    switch (zzb2.mo5520b()) {
                        case 1:
                            serviceConnection.onServiceConnected(zzb2.mo5525e(), zzb2.mo5524d());
                            break;
                        case 2:
                            zzb2.mo5517a(str);
                            break;
                    }
                } else {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + aVar);
                }
            } else {
                zzb2 = new zzb(aVar);
                zzb2.mo5516a(serviceConnection, str);
                zzb2.mo5517a(str);
                this.f3008a.put(aVar, zzb2);
            }
            a = zzb2.mo5518a();
        }
        return a;
    }

    /* renamed from: b */
    private void m3933b(C0743a aVar, ServiceConnection serviceConnection, String str) {
        zzx.zzb(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f3008a) {
            zzb zzb2 = this.f3008a.get(aVar);
            if (zzb2 == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + aVar);
            } else if (!zzb2.mo5519a(serviceConnection)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + aVar);
            } else {
                zzb2.mo5521b(serviceConnection, str);
                if (zzb2.mo5523c()) {
                    this.f3010c.sendMessageDelayed(this.f3010c.obtainMessage(0, zzb2), this.f3012e);
                }
            }
        }
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                zzb zzb2 = (zzb) message.obj;
                synchronized (this.f3008a) {
                    if (zzb2.mo5523c()) {
                        if (zzb2.mo5518a()) {
                            zzb2.mo5522b("GmsClientSupervisor");
                        }
                        this.f3008a.remove(zzb2.f3021g);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    public boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return m3931a(new C0743a(componentName), serviceConnection, str);
    }

    public boolean zza(String str, ServiceConnection serviceConnection, String str2) {
        return m3931a(new C0743a(str), serviceConnection, str2);
    }

    public void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        m3933b(new C0743a(componentName), serviceConnection, str);
    }

    public void zzb(String str, ServiceConnection serviceConnection, String str2) {
        m3933b(new C0743a(str), serviceConnection, str2);
    }
}
