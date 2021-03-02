package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class zzn extends zzm implements Handler.Callback {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final HashMap f4599a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f4600b;

    /* renamed from: c */
    private final Handler f4601c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final com.google.android.gms.common.stats.zzb f4602d;

    /* renamed from: e */
    private final long f4603e;

    final class zzb {

        /* renamed from: b */
        private final zza f4605b = new zza();
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final Set f4606c = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: d */
        public int f4607d = 2;

        /* renamed from: e */
        private boolean f4608e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public IBinder f4609f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public final C1383v f4610g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public ComponentName f4611h;

        public class zza implements ServiceConnection {
            public zza() {
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (zzn.this.f4599a) {
                    IBinder unused = zzb.this.f4609f = iBinder;
                    ComponentName unused2 = zzb.this.f4611h = componentName;
                    for (ServiceConnection onServiceConnected : zzb.this.f4606c) {
                        onServiceConnected.onServiceConnected(componentName, iBinder);
                    }
                    int unused3 = zzb.this.f4607d = 1;
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (zzn.this.f4599a) {
                    IBinder unused = zzb.this.f4609f = null;
                    ComponentName unused2 = zzb.this.f4611h = componentName;
                    for (ServiceConnection onServiceDisconnected : zzb.this.f4606c) {
                        onServiceDisconnected.onServiceDisconnected(componentName);
                    }
                    int unused3 = zzb.this.f4607d = 2;
                }
            }
        }

        public zzb(C1383v vVar) {
            this.f4610g = vVar;
        }

        /* renamed from: a */
        public void mo6740a(ServiceConnection serviceConnection, String str) {
            zzn.this.f4602d.zza(zzn.this.f4600b, serviceConnection, str, this.f4610g.mo6624a());
            this.f4606c.add(serviceConnection);
        }

        @TargetApi(14)
        /* renamed from: a */
        public void mo6741a(String str) {
            this.f4607d = 3;
            this.f4608e = zzn.this.f4602d.zza(zzn.this.f4600b, str, this.f4610g.mo6624a(), this.f4605b, 129);
            if (!this.f4608e) {
                this.f4607d = 2;
                try {
                    zzn.this.f4602d.zza(zzn.this.f4600b, this.f4605b);
                } catch (IllegalArgumentException e) {
                }
            }
        }

        /* renamed from: a */
        public boolean mo6742a() {
            return this.f4608e;
        }

        /* renamed from: a */
        public boolean mo6743a(ServiceConnection serviceConnection) {
            return this.f4606c.contains(serviceConnection);
        }

        /* renamed from: b */
        public int mo6744b() {
            return this.f4607d;
        }

        /* renamed from: b */
        public void mo6745b(ServiceConnection serviceConnection, String str) {
            zzn.this.f4602d.zzb(zzn.this.f4600b, serviceConnection);
            this.f4606c.remove(serviceConnection);
        }

        /* renamed from: b */
        public void mo6746b(String str) {
            zzn.this.f4602d.zza(zzn.this.f4600b, this.f4605b);
            this.f4608e = false;
            this.f4607d = 2;
        }

        /* renamed from: c */
        public boolean mo6747c() {
            return this.f4606c.isEmpty();
        }

        /* renamed from: d */
        public IBinder mo6748d() {
            return this.f4609f;
        }

        /* renamed from: e */
        public ComponentName mo6749e() {
            return this.f4611h;
        }
    }

    zzn(Context context) {
        this.f4600b = context.getApplicationContext();
        this.f4601c = new Handler(context.getMainLooper(), this);
        this.f4602d = com.google.android.gms.common.stats.zzb.zzaux();
        this.f4603e = 5000;
    }

    /* renamed from: a */
    private boolean m6121a(C1383v vVar, ServiceConnection serviceConnection, String str) {
        boolean a;
        zzab.zzb((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f4599a) {
            zzb zzb2 = (zzb) this.f4599a.get(vVar);
            if (zzb2 != null) {
                this.f4601c.removeMessages(0, zzb2);
                if (!zzb2.mo6743a(serviceConnection)) {
                    zzb2.mo6740a(serviceConnection, str);
                    switch (zzb2.mo6744b()) {
                        case 1:
                            serviceConnection.onServiceConnected(zzb2.mo6749e(), zzb2.mo6748d());
                            break;
                        case 2:
                            zzb2.mo6741a(str);
                            break;
                    }
                } else {
                    String valueOf = String.valueOf(vVar);
                    throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
                }
            } else {
                zzb2 = new zzb(vVar);
                zzb2.mo6740a(serviceConnection, str);
                zzb2.mo6741a(str);
                this.f4599a.put(vVar, zzb2);
            }
            a = zzb2.mo6742a();
        }
        return a;
    }

    /* renamed from: b */
    private void m6123b(C1383v vVar, ServiceConnection serviceConnection, String str) {
        zzab.zzb((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f4599a) {
            zzb zzb2 = (zzb) this.f4599a.get(vVar);
            if (zzb2 == null) {
                String valueOf = String.valueOf(vVar);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
            } else if (!zzb2.mo6743a(serviceConnection)) {
                String valueOf2 = String.valueOf(vVar);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf2).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf2).toString());
            } else {
                zzb2.mo6745b(serviceConnection, str);
                if (zzb2.mo6747c()) {
                    this.f4601c.sendMessageDelayed(this.f4601c.obtainMessage(0, zzb2), this.f4603e);
                }
            }
        }
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                zzb zzb2 = (zzb) message.obj;
                synchronized (this.f4599a) {
                    if (zzb2.mo6747c()) {
                        if (zzb2.mo6742a()) {
                            zzb2.mo6746b("GmsClientSupervisor");
                        }
                        this.f4599a.remove(zzb2.f4610g);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    public boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return m6121a(new C1383v(componentName), serviceConnection, str);
    }

    public boolean zza(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return m6121a(new C1383v(str, str2), serviceConnection, str3);
    }

    public void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        m6123b(new C1383v(componentName), serviceConnection, str);
    }

    public void zzb(String str, String str2, ServiceConnection serviceConnection, String str3) {
        m6123b(new C1383v(str, str2), serviceConnection, str3);
    }
}
