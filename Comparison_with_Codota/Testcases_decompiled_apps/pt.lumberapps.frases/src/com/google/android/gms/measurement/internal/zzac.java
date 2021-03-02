package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzf;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class zzac extends C1923c {

    /* renamed from: a */
    private C1930j f7243a;

    /* renamed from: b */
    private AppMeasurement.zzb f7244b;

    /* renamed from: c */
    private final Set f7245c = new HashSet();

    /* renamed from: d */
    private boolean f7246d;

    protected zzac(zzx zzx) {
        super(zzx);
    }

    /* renamed from: a */
    private void m7739a(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        mo9387a(str, str2, zzyw().currentTimeMillis(), bundle, z, z2, z3, str3);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7740a(String str, String str2, Object obj, long j) {
        zzab.zzhr(str);
        zzab.zzhr(str2);
        zzwu();
        zzyv();
        mo9339c();
        if (!this.f7189n.isEnabled()) {
            zzbsd().zzbtb().log("User property not set since app measurement is disabled");
        } else if (this.f7189n.mo9660b()) {
            zzbsd().zzbtb().zze("Setting user property (FE)", str2, obj);
            zzbrx().mo9403a(new UserAttributeParcel(str2, j, obj, str));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7741a(boolean z) {
        zzwu();
        zzyv();
        mo9339c();
        zzbsd().zzbtb().zzj("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzbse().mo9616b(z);
        zzbrx().mo9406e();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7742b(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzab.zzhr(str);
        zzab.zzhr(str2);
        zzab.zzy(bundle);
        zzwu();
        mo9339c();
        if (!this.f7189n.isEnabled()) {
            zzbsd().zzbtb().log("Event not sent since app measurement is disabled");
            return;
        }
        if (!this.f7246d) {
            this.f7246d = true;
            m7743e();
        }
        boolean zzmt = zzal.zzmt(str2);
        if (z && this.f7244b != null && !zzmt) {
            zzbsd().zzbtb().zze("Passing event to registered event handler (FE)", str2, bundle);
            this.f7244b.zzb(str, str2, bundle, j);
        } else if (this.f7189n.mo9660b()) {
            int zzml = zzbrz().zzml(str2);
            if (zzml != 0) {
                this.f7189n.zzbrz().zze(zzml, "_ev", zzbrz().zza(str2, zzbsf().zzbqn(), true));
                return;
            }
            bundle.putString("_o", str);
            Bundle zza = zzbrz().zza(str2, bundle, zzf.zzz("_o"), z3);
            Bundle a = z2 ? mo9386a(zza) : zza;
            zzbsd().zzbtb().zze("Logging event (FE)", str2, a);
            zzbrx().mo9402a(new EventParcel(str2, new EventParams(a), str, j), str3);
            for (AppMeasurement.zzc zzc : this.f7245c) {
                zzc.zzc(str, str2, a, j);
            }
        }
    }

    /* renamed from: e */
    private void m7743e() {
        try {
            zzg(Class.forName(m7744f()));
        } catch (ClassNotFoundException e) {
            zzbsd().zzbta().log("Tag Manager is not found and thus will not be used");
        }
    }

    /* renamed from: f */
    private String m7744f() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Bundle mo9386a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzl = zzbrz().zzl(str, bundle.get(str));
                if (zzl == null) {
                    zzbsd().zzbsx().zzj("Param value can't be null", str);
                } else if ((!(zzl instanceof String) && !(zzl instanceof Character) && !(zzl instanceof CharSequence)) || !TextUtils.isEmpty(String.valueOf(zzl))) {
                    zzbrz().zza(bundle2, str, zzl);
                }
            }
        }
        return bundle2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9387a(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzbsc().zzm(new C1927g(this, str, str2, j, bundle != null ? new Bundle(bundle) : new Bundle(), z, z2, z3, str3));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9388a(String str, String str2, long j, Object obj) {
        zzbsc().zzm(new C1928h(this, str, str2, obj, j));
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo9226d() {
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public void setMeasurementEnabled(boolean z) {
        mo9339c();
        zzyv();
        zzbsc().zzm(new C1924d(this, z));
    }

    public void setMinimumSessionDuration(long j) {
        zzyv();
        zzbsc().zzm(new C1925e(this, j));
    }

    public void setSessionTimeoutDuration(long j) {
        zzyv();
        zzbsc().zzm(new C1926f(this, j));
    }

    public void zza(AppMeasurement.zzb zzb) {
        zzwu();
        zzyv();
        mo9339c();
        if (!(zzb == null || zzb == this.f7244b)) {
            zzab.zza(this.f7244b == null, (Object) "EventInterceptor already set.");
        }
        this.f7244b = zzb;
    }

    public void zza(AppMeasurement.zzc zzc) {
        zzwu();
        zzyv();
        mo9339c();
        zzab.zzy(zzc);
        if (this.f7245c.contains(zzc)) {
            throw new IllegalStateException("OnEventListener already registered.");
        }
        this.f7245c.add(zzc);
    }

    public void zza(String str, String str2, Bundle bundle, boolean z) {
        zzyv();
        m7739a(str, str2, bundle, true, this.f7244b == null || zzal.zzmt(str2), z, (String) null);
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

    @TargetApi(14)
    public void zzbun() {
        if (getContext().getApplicationContext() instanceof Application) {
            Application application = (Application) getContext().getApplicationContext();
            if (this.f7243a == null) {
                this.f7243a = new C1930j(this, (C1924d) null);
            }
            application.unregisterActivityLifecycleCallbacks(this.f7243a);
            application.registerActivityLifecycleCallbacks(this.f7243a);
            zzbsd().zzbtc().log("Registered activity lifecycle callback");
        }
    }

    public void zzbuo() {
        zzwu();
        zzyv();
        mo9339c();
        if (this.f7189n.mo9660b()) {
            zzbrx().mo9407f();
            String k = zzbse().mo9625k();
            if (!TextUtils.isEmpty(k) && !k.equals(zzbrw().zzbso())) {
                Bundle bundle = new Bundle();
                bundle.putString("_po", k);
                zze("auto", "_ou", bundle);
            }
        }
    }

    public List zzce(boolean z) {
        zzyv();
        mo9339c();
        zzbsd().zzbtb().log("Fetching user attributes (FE)");
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzbsd().zzbsx().log("getUserProperties called from main thread.");
            return null;
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.f7189n.zzbsc().zzm(new C1929i(this, atomicReference, z));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzbsd().zzbsx().zzj("Interrupted waiting for get user properties", e);
            }
        }
        List list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzbsd().zzbsx().log("Timed out waiting for get user properties");
        return null;
    }

    public void zzd(String str, String str2, Bundle bundle, long j) {
        zzyv();
        mo9387a(str, str2, j, bundle, false, true, true, (String) null);
    }

    public void zzd(String str, String str2, Object obj) {
        zzab.zzhr(str);
        long currentTimeMillis = zzyw().currentTimeMillis();
        int zzmn = zzbrz().zzmn(str2);
        if (zzmn != 0) {
            this.f7189n.zzbrz().zze(zzmn, "_ev", zzbrz().zza(str2, zzbsf().zzbqo(), true));
        } else if (obj != null) {
            int zzm = zzbrz().zzm(str2, obj);
            if (zzm != 0) {
                this.f7189n.zzbrz().zze(zzm, "_ev", zzbrz().zza(str2, zzbsf().zzbqo(), true));
                return;
            }
            Object zzn = zzbrz().zzn(str2, obj);
            if (zzn != null) {
                mo9388a(str, str2, currentTimeMillis, zzn);
            }
        } else {
            mo9388a(str, str2, currentTimeMillis, (Object) null);
        }
    }

    public void zze(String str, String str2, Bundle bundle) {
        zzyv();
        m7739a(str, str2, bundle, true, this.f7244b == null || zzal.zzmt(str2), false, (String) null);
    }

    public void zzg(Class cls) {
        try {
            cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{getContext()});
        } catch (Exception e) {
            zzbsd().zzbsx().zzj("Failed to invoke Tag Manager's initialize() method", e);
        }
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
