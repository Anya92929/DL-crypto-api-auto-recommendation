package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.request.zzc;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzio;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzkj;
import com.google.android.gms.internal.zzla;

@zzin
public abstract class zzd implements zzc.zza, zzkj {

    /* renamed from: a */
    private final zzla f3942a;

    /* renamed from: b */
    private final zzc.zza f3943b;

    /* renamed from: c */
    private final Object f3944c = new Object();

    @zzin
    public final class zza extends zzd {

        /* renamed from: a */
        private final Context f3945a;

        public zza(Context context, zzla zzla, zzc.zza zza) {
            super(zzla, zza);
            this.f3945a = context;
        }

        public /* synthetic */ Object zzpy() {
            return zzd.super.zzpy();
        }

        public void zzqw() {
        }

        public zzk zzqx() {
            return zzip.zza(this.f3945a, new zzcv((String) zzdc.zzaxy.get()), zzio.zzrf());
        }
    }

    @zzin
    public class zzb extends zzd implements zzd.zzb, zzd.zzc {

        /* renamed from: a */
        protected zze f3946a;

        /* renamed from: b */
        private Context f3947b;

        /* renamed from: c */
        private VersionInfoParcel f3948c;

        /* renamed from: d */
        private zzla f3949d;

        /* renamed from: e */
        private final zzc.zza f3950e;

        /* renamed from: f */
        private final Object f3951f = new Object();

        /* renamed from: g */
        private boolean f3952g;

        public zzb(Context context, VersionInfoParcel versionInfoParcel, zzla zzla, zzc.zza zza) {
            super(zzla, zza);
            Looper mainLooper;
            this.f3947b = context;
            this.f3948c = versionInfoParcel;
            this.f3949d = zzla;
            this.f3950e = zza;
            if (((Boolean) zzdc.zzayy.get()).booleanValue()) {
                this.f3952g = true;
                mainLooper = zzu.zzgc().zztq();
            } else {
                mainLooper = context.getMainLooper();
            }
            this.f3946a = new zze(context, mainLooper, this, this, this.f3948c.zzcnl);
            mo5665a();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5665a() {
            this.f3946a.zzarx();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public zzkj mo5666b() {
            return new zza(this.f3947b, this.f3949d, this.f3950e);
        }

        public void onConnected(Bundle bundle) {
            Void voidR = (Void) zzpy();
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            zzkd.zzcv("Cannot connect to remote service, fallback to local instance.");
            mo5666b().zzpy();
            Bundle bundle = new Bundle();
            bundle.putString("action", "gms_connection_failed_fallback_to_local");
            zzu.zzfq().zzb(this.f3947b, this.f3948c.zzcs, "gmob-apps", bundle, true);
        }

        public void onConnectionSuspended(int i) {
            zzkd.zzcv("Disconnected from remote ad request service.");
        }

        public /* synthetic */ Object zzpy() {
            return zzd.super.zzpy();
        }

        public void zzqw() {
            synchronized (this.f3951f) {
                if (this.f3946a.isConnected() || this.f3946a.isConnecting()) {
                    this.f3946a.disconnect();
                }
                Binder.flushPendingCommands();
                if (this.f3952g) {
                    zzu.zzgc().zztr();
                    this.f3952g = false;
                }
            }
        }

        public zzk zzqx() {
            zzk zzk;
            synchronized (this.f3951f) {
                try {
                    zzk = this.f3946a.zzrb();
                } catch (DeadObjectException | IllegalStateException e) {
                    zzk = null;
                }
            }
            return zzk;
        }
    }

    public zzd(zzla zzla, zzc.zza zza2) {
        this.f3942a = zzla;
        this.f3943b = zza2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5659a(zzk zzk, AdRequestInfoParcel adRequestInfoParcel) {
        try {
            zzk.zza(adRequestInfoParcel, new zzg(this));
            return true;
        } catch (RemoteException e) {
            zzkd.zzd("Could not fetch ad response from ad request service.", e);
            zzu.zzft().zzb((Throwable) e, true);
        } catch (NullPointerException e2) {
            zzkd.zzd("Could not fetch ad response from ad request service due to an Exception.", e2);
            zzu.zzft().zzb((Throwable) e2, true);
        } catch (SecurityException e3) {
            zzkd.zzd("Could not fetch ad response from ad request service due to an Exception.", e3);
            zzu.zzft().zzb((Throwable) e3, true);
        } catch (Throwable th) {
            zzkd.zzd("Could not fetch ad response from ad request service due to an Exception.", th);
            zzu.zzft().zzb(th, true);
        }
        this.f3943b.zzb(new AdResponseParcel(0));
        return false;
    }

    public void cancel() {
        zzqw();
    }

    public void zzb(AdResponseParcel adResponseParcel) {
        synchronized (this.f3944c) {
            this.f3943b.zzb(adResponseParcel);
            zzqw();
        }
    }

    /* renamed from: zzpv */
    public Void zzpy() {
        zzk zzqx = zzqx();
        if (zzqx == null) {
            this.f3943b.zzb(new AdResponseParcel(0));
            zzqw();
        } else {
            this.f3942a.zza(new C1306g(this, zzqx), new C1307h(this));
        }
        return null;
    }

    public abstract void zzqw();

    public abstract zzk zzqx();
}
