package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.zzc;
import com.google.android.gms.measurement.internal.zzm;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class zzad extends C1923c {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zza f7247a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public zzm f7248b;

    /* renamed from: c */
    private Boolean f7249c;

    /* renamed from: d */
    private final C1892aj f7250d;

    /* renamed from: e */
    private final C1887ae f7251e;

    /* renamed from: f */
    private final List f7252f = new ArrayList();

    /* renamed from: g */
    private final C1892aj f7253g;

    public class zza implements ServiceConnection, zzd.zzb, zzd.zzc {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public volatile boolean f7255b;

        /* renamed from: c */
        private volatile zzo f7256c;

        protected zza() {
        }

        public void onConnected(Bundle bundle) {
            zzab.zzhi("MeasurementServiceConnection.onConnected");
            synchronized (this) {
                try {
                    this.f7256c = null;
                    zzad.this.zzbsc().zzm(new C1940t(this, (zzm) this.f7256c.zzasa()));
                } catch (DeadObjectException | IllegalStateException e) {
                    this.f7256c = null;
                    this.f7255b = false;
                }
            }
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            zzab.zzhi("MeasurementServiceConnection.onConnectionFailed");
            zzp zzbtp = zzad.this.f7189n.zzbtp();
            if (zzbtp != null) {
                zzbtp.zzbsx().zzj("Service connection failed", connectionResult);
            }
            synchronized (this) {
                this.f7255b = false;
                this.f7256c = null;
            }
        }

        public void onConnectionSuspended(int i) {
            zzab.zzhi("MeasurementServiceConnection.onConnectionSuspended");
            zzad.this.zzbsd().zzbtb().log("Service connection suspended");
            zzad.this.zzbsc().zzm(new C1941u(this));
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzab.zzhi("MeasurementServiceConnection.onServiceConnected");
            synchronized (this) {
                if (iBinder == null) {
                    this.f7255b = false;
                    zzad.this.zzbsd().zzbsv().log("Service connected with null binder");
                    return;
                }
                zzm zzm = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        zzm = zzm.zza.zzjf(iBinder);
                        zzad.this.zzbsd().zzbtc().log("Bound to IMeasurementService interface");
                    } else {
                        zzad.this.zzbsd().zzbsv().zzj("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException e) {
                    zzad.this.zzbsd().zzbsv().log("Service connect failed to get IMeasurementService");
                }
                if (zzm == null) {
                    this.f7255b = false;
                    try {
                        zzb.zzaux().zza(zzad.this.getContext(), zzad.this.f7247a);
                    } catch (IllegalArgumentException e2) {
                    }
                } else {
                    zzad.this.zzbsc().zzm(new C1938r(this, zzm));
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            zzab.zzhi("MeasurementServiceConnection.onServiceDisconnected");
            zzad.this.zzbsd().zzbtb().log("Service disconnected");
            zzad.this.zzbsc().zzm(new C1939s(this, componentName));
        }

        public void zzbuw() {
            zzad.this.zzwu();
            Context context = zzad.this.getContext();
            synchronized (this) {
                if (this.f7255b) {
                    zzad.this.zzbsd().zzbtc().log("Connection attempt already in progress");
                } else if (this.f7256c != null) {
                    zzad.this.zzbsd().zzbtc().log("Already awaiting connection attempt");
                } else {
                    this.f7256c = new zzo(context, Looper.getMainLooper(), this, this);
                    zzad.this.zzbsd().zzbtc().log("Connecting to remote service");
                    this.f7255b = true;
                    this.f7256c.zzarx();
                }
            }
        }

        public void zzy(Intent intent) {
            zzad.this.zzwu();
            Context context = zzad.this.getContext();
            zzb zzaux = zzb.zzaux();
            synchronized (this) {
                if (this.f7255b) {
                    zzad.this.zzbsd().zzbtc().log("Connection attempt already in progress");
                    return;
                }
                this.f7255b = true;
                zzaux.zza(context, intent, (ServiceConnection) zzad.this.f7247a, 129);
            }
        }
    }

    protected zzad(zzx zzx) {
        super(zzx);
        this.f7251e = new C1887ae(zzx.zzyw());
        this.f7247a = new zza();
        this.f7250d = new C1931k(this, zzx);
        this.f7253g = new C1932l(this, zzx);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7750a(ComponentName componentName) {
        zzwu();
        if (this.f7248b != null) {
            this.f7248b = null;
            zzbsd().zzbtc().zzj("Disconnected from device MeasurementService", componentName);
            m7761l();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7753a(zzm zzm) {
        zzwu();
        zzab.zzy(zzm);
        this.f7248b = zzm;
        m7758i();
        m7762m();
    }

    /* renamed from: a */
    private void m7754a(Runnable runnable) {
        zzwu();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.f7252f.size()) >= zzbsf().zzbrh()) {
            zzbsd().zzbsv().log("Discarding data. Max runnable queue size reached");
        } else {
            this.f7252f.add(runnable);
            if (!this.f7189n.mo9669h()) {
                this.f7253g.mo9233a(60000);
            }
            mo9408g();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m7758i() {
        zzwu();
        this.f7251e.mo9219a();
        if (!this.f7189n.mo9669h()) {
            this.f7250d.mo9233a(zzbsf().mo9476k());
        }
    }

    /* renamed from: j */
    private boolean m7759j() {
        List<ResolveInfo> queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        return queryIntentServices != null && queryIntentServices.size() > 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m7760k() {
        zzwu();
        if (isConnected()) {
            zzbsd().zzbtc().log("Inactivity, disconnecting from AppMeasurementService");
            disconnect();
        }
    }

    /* renamed from: l */
    private void m7761l() {
        zzwu();
        mo9408g();
    }

    /* renamed from: m */
    private void m7762m() {
        zzwu();
        zzbsd().zzbtc().zzj("Processing queued up service tasks", Integer.valueOf(this.f7252f.size()));
        for (Runnable zzm : this.f7252f) {
            zzbsc().zzm(zzm);
        }
        this.f7252f.clear();
        this.f7253g.mo9235c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9402a(EventParcel eventParcel, String str) {
        zzab.zzy(eventParcel);
        zzwu();
        mo9339c();
        m7754a((Runnable) new C1934n(this, str, eventParcel));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9403a(UserAttributeParcel userAttributeParcel) {
        zzwu();
        mo9339c();
        m7754a((Runnable) new C1935o(this, userAttributeParcel));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9404a(AtomicReference atomicReference, boolean z) {
        zzwu();
        mo9339c();
        m7754a((Runnable) new C1936p(this, atomicReference, z));
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo9226d() {
    }

    public void disconnect() {
        zzwu();
        mo9339c();
        try {
            zzb.zzaux().zza(getContext(), this.f7247a);
        } catch (IllegalArgumentException | IllegalStateException e) {
        }
        this.f7248b = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo9406e() {
        zzwu();
        mo9339c();
        m7754a((Runnable) new C1933m(this));
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo9407f() {
        zzwu();
        mo9339c();
        m7754a((Runnable) new C1937q(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo9408g() {
        zzwu();
        mo9339c();
        if (!isConnected()) {
            if (this.f7249c == null) {
                this.f7249c = zzbse().mo9623i();
                if (this.f7249c == null) {
                    zzbsd().zzbtc().log("State of service unknown");
                    this.f7249c = Boolean.valueOf(mo9409h());
                    zzbse().mo9614a(this.f7249c.booleanValue());
                }
            }
            if (this.f7249c.booleanValue()) {
                zzbsd().zzbtc().log("Using measurement service");
                this.f7247a.zzbuw();
            } else if (!this.f7189n.mo9669h() && m7759j()) {
                zzbsd().zzbtc().log("Using local app measurement service");
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
                this.f7247a.zzy(intent);
            } else if (zzbsf().zzabd()) {
                zzbsd().zzbtc().log("Using direct local measurement implementation");
                m7753a((zzm) new zzy(this.f7189n, true));
            } else {
                zzbsd().zzbsv().log("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public boolean mo9409h() {
        zzwu();
        mo9339c();
        if (zzbsf().zzabc()) {
            return true;
        }
        zzbsd().zzbtc().log("Checking service availability");
        switch (zzc.zzang().isGooglePlayServicesAvailable(getContext())) {
            case 0:
                zzbsd().zzbtc().log("Service available");
                return true;
            case 1:
                zzbsd().zzbtc().log("Service missing");
                return false;
            case 2:
                zzbsd().zzbtb().log("Service container out of date");
                return true;
            case 3:
                zzbsd().zzbsx().log("Service disabled");
                return false;
            case 9:
                zzbsd().zzbsx().log("Service invalid");
                return false;
            case 18:
                zzbsd().zzbsx().log("Service updating");
                return true;
            default:
                return false;
        }
    }

    public boolean isConnected() {
        zzwu();
        mo9339c();
        return this.f7248b != null;
    }

    public /* bridge */ /* synthetic */ void zzbrs() {
        super.zzbrs();
    }

    public /* bridge */ /* synthetic */ C1889ag zzbrt() {
        return super.zzbrt();
    }

    public /* bridge */ /* synthetic */ zzac zzbru() {
        return super.zzbru();
    }

    public /* bridge */ /* synthetic */ zzn zzbrv() {
        return super.zzbrv();
    }

    public /* bridge */ /* synthetic */ zzg zzbrw() {
        return super.zzbrw();
    }

    public /* bridge */ /* synthetic */ zzad zzbrx() {
        return super.zzbrx();
    }

    public /* bridge */ /* synthetic */ zze zzbry() {
        return super.zzbry();
    }

    public /* bridge */ /* synthetic */ zzal zzbrz() {
        return super.zzbrz();
    }

    public /* bridge */ /* synthetic */ zzv zzbsa() {
        return super.zzbsa();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsb() {
        return super.zzbsb();
    }

    public /* bridge */ /* synthetic */ zzw zzbsc() {
        return super.zzbsc();
    }

    public /* bridge */ /* synthetic */ zzp zzbsd() {
        return super.zzbsd();
    }

    public /* bridge */ /* synthetic */ zzt zzbse() {
        return super.zzbse();
    }

    public /* bridge */ /* synthetic */ zzd zzbsf() {
        return super.zzbsf();
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
