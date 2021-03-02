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
    private final Handler mHandler;
    /* access modifiers changed from: private */
    public final HashMap<zza, zzb> zzalZ = new HashMap<>();
    /* access modifiers changed from: private */
    public final com.google.android.gms.common.stats.zzb zzama;
    private final long zzamb;
    /* access modifiers changed from: private */
    public final Context zzsa;

    private static final class zza {
        private final String zzSU;
        private final ComponentName zzamc;

        public zza(ComponentName componentName) {
            this.zzSU = null;
            this.zzamc = (ComponentName) zzx.zzz(componentName);
        }

        public zza(String str) {
            this.zzSU = zzx.zzcM(str);
            this.zzamc = null;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            return zzw.equal(this.zzSU, zza.zzSU) && zzw.equal(this.zzamc, zza.zzamc);
        }

        public int hashCode() {
            return zzw.hashCode(this.zzSU, this.zzamc);
        }

        public String toString() {
            return this.zzSU == null ? this.zzamc.flattenToString() : this.zzSU;
        }

        public Intent zzqS() {
            return this.zzSU != null ? new Intent(this.zzSU).setPackage("com.google.android.gms") : new Intent().setComponent(this.zzamc);
        }
    }

    private final class zzb {
        /* access modifiers changed from: private */
        public int mState = 2;
        /* access modifiers changed from: private */
        public IBinder zzakD;
        /* access modifiers changed from: private */
        public ComponentName zzamc;
        private final zza zzamd = new zza();
        /* access modifiers changed from: private */
        public final Set<ServiceConnection> zzame = new HashSet();
        private boolean zzamf;
        /* access modifiers changed from: private */
        public final zza zzamg;

        public class zza implements ServiceConnection {
            public zza() {
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (zzm.this.zzalZ) {
                    IBinder unused = zzb.this.zzakD = binder;
                    ComponentName unused2 = zzb.this.zzamc = component;
                    for (ServiceConnection onServiceConnected : zzb.this.zzame) {
                        onServiceConnected.onServiceConnected(component, binder);
                    }
                    int unused3 = zzb.this.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (zzm.this.zzalZ) {
                    IBinder unused = zzb.this.zzakD = null;
                    ComponentName unused2 = zzb.this.zzamc = component;
                    for (ServiceConnection onServiceDisconnected : zzb.this.zzame) {
                        onServiceDisconnected.onServiceDisconnected(component);
                    }
                    int unused3 = zzb.this.mState = 2;
                }
            }
        }

        public zzb(zza zza2) {
            this.zzamg = zza2;
        }

        public IBinder getBinder() {
            return this.zzakD;
        }

        public ComponentName getComponentName() {
            return this.zzamc;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.zzamf;
        }

        public void zza(ServiceConnection serviceConnection, String str) {
            zzm.this.zzama.zza(zzm.this.zzsa, serviceConnection, str, this.zzamg.zzqS());
            this.zzame.add(serviceConnection);
        }

        public boolean zza(ServiceConnection serviceConnection) {
            return this.zzame.contains(serviceConnection);
        }

        public void zzb(ServiceConnection serviceConnection, String str) {
            zzm.this.zzama.zzb(zzm.this.zzsa, serviceConnection);
            this.zzame.remove(serviceConnection);
        }

        @TargetApi(14)
        public void zzcH(String str) {
            this.mState = 3;
            this.zzamf = zzm.this.zzama.zza(zzm.this.zzsa, str, this.zzamg.zzqS(), (ServiceConnection) this.zzamd, 129);
            if (!this.zzamf) {
                this.mState = 2;
                try {
                    zzm.this.zzama.zza(zzm.this.zzsa, this.zzamd);
                } catch (IllegalArgumentException e) {
                }
            }
        }

        public void zzcI(String str) {
            zzm.this.zzama.zza(zzm.this.zzsa, this.zzamd);
            this.zzamf = false;
            this.mState = 2;
        }

        public boolean zzqT() {
            return this.zzame.isEmpty();
        }
    }

    zzm(Context context) {
        this.zzsa = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.zzama = com.google.android.gms.common.stats.zzb.zzrP();
        this.zzamb = 5000;
    }

    private boolean zza(zza zza2, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        zzx.zzb(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.zzalZ) {
            zzb zzb2 = this.zzalZ.get(zza2);
            if (zzb2 != null) {
                this.mHandler.removeMessages(0, zzb2);
                if (!zzb2.zza(serviceConnection)) {
                    zzb2.zza(serviceConnection, str);
                    switch (zzb2.getState()) {
                        case 1:
                            serviceConnection.onServiceConnected(zzb2.getComponentName(), zzb2.getBinder());
                            break;
                        case 2:
                            zzb2.zzcH(str);
                            break;
                    }
                } else {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + zza2);
                }
            } else {
                zzb2 = new zzb(zza2);
                zzb2.zza(serviceConnection, str);
                zzb2.zzcH(str);
                this.zzalZ.put(zza2, zzb2);
            }
            isBound = zzb2.isBound();
        }
        return isBound;
    }

    private void zzb(zza zza2, ServiceConnection serviceConnection, String str) {
        zzx.zzb(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.zzalZ) {
            zzb zzb2 = this.zzalZ.get(zza2);
            if (zzb2 == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + zza2);
            } else if (!zzb2.zza(serviceConnection)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + zza2);
            } else {
                zzb2.zzb(serviceConnection, str);
                if (zzb2.zzqT()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, zzb2), this.zzamb);
                }
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                zzb zzb2 = (zzb) msg.obj;
                synchronized (this.zzalZ) {
                    if (zzb2.zzqT()) {
                        if (zzb2.isBound()) {
                            zzb2.zzcI("GmsClientSupervisor");
                        }
                        this.zzalZ.remove(zzb2.zzamg);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    public boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName), serviceConnection, str);
    }

    public boolean zza(String str, ServiceConnection serviceConnection, String str2) {
        return zza(new zza(str), serviceConnection, str2);
    }

    public void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName), serviceConnection, str);
    }

    public void zzb(String str, ServiceConnection serviceConnection, String str2) {
        zzb(new zza(str), serviceConnection, str2);
    }
}
