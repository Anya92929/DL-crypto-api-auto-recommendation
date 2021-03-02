package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.measurement.internal.zzm;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class zzy extends zzm.zza {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzx f7392a;

    /* renamed from: b */
    private final boolean f7393b;

    public zzy(zzx zzx) {
        zzab.zzy(zzx);
        this.f7392a = zzx;
        this.f7393b = false;
    }

    public zzy(zzx zzx, boolean z) {
        zzab.zzy(zzx);
        this.f7392a = zzx;
        this.f7393b = z;
    }

    /* renamed from: a */
    private void m8010a(AppMetadata appMetadata) {
        zzab.zzy(appMetadata);
        m8011c(appMetadata.packageName);
        this.f7392a.zzbrz().zzmq(appMetadata.aic);
    }

    /* renamed from: c */
    private void m8011c(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f7392a.zzbsd().zzbsv().log("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            mo9702b(str);
        } catch (SecurityException e) {
            this.f7392a.zzbsd().zzbsv().zzj("Measurement Service called with invalid calling package", str);
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9701a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(":", 2);
            if (split.length == 2) {
                try {
                    long longValue = Long.valueOf(split[0]).longValue();
                    if (longValue > 0) {
                        this.f7392a.zzbse().f7314b.zzh(split[1], longValue);
                    } else {
                        this.f7392a.zzbsd().zzbsx().zzj("Combining sample with a non-positive weight", Long.valueOf(longValue));
                    }
                } catch (NumberFormatException e) {
                    this.f7392a.zzbsd().zzbsx().zzj("Combining sample with a non-number weight", split[0]);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo9702b(String str) {
        int myUid = this.f7393b ? Process.myUid() : Binder.getCallingUid();
        if (!com.google.android.gms.common.util.zzy.zzb(this.f7392a.getContext(), myUid, str)) {
            if (!com.google.android.gms.common.util.zzy.zze(this.f7392a.getContext(), myUid) || this.f7392a.mo9669h()) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
        }
    }

    public List zza(AppMetadata appMetadata, boolean z) {
        m8010a(appMetadata);
        try {
            List<C1888af> list = (List) this.f7392a.zzbsc().zzd(new C1920bk(this, appMetadata)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (C1888af afVar : list) {
                if (z || !zzal.zzmt(afVar.f7082b)) {
                    arrayList.add(new UserAttributeParcel(afVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.f7392a.zzbsd().zzbsv().zzj("Failed to get user attributes", e);
            return null;
        }
    }

    public void zza(AppMetadata appMetadata) {
        m8010a(appMetadata);
        this.f7392a.zzbsc().zzm(new C1921bl(this, appMetadata));
    }

    public void zza(EventParcel eventParcel, AppMetadata appMetadata) {
        zzab.zzy(eventParcel);
        m8010a(appMetadata);
        this.f7392a.zzbsc().zzm(new C1915bf(this, appMetadata, eventParcel));
    }

    public void zza(EventParcel eventParcel, String str, String str2) {
        zzab.zzy(eventParcel);
        zzab.zzhr(str);
        m8011c(str);
        this.f7392a.zzbsc().zzm(new C1916bg(this, str2, eventParcel, str));
    }

    public void zza(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        zzab.zzy(userAttributeParcel);
        m8010a(appMetadata);
        if (userAttributeParcel.getValue() == null) {
            this.f7392a.zzbsc().zzm(new C1918bi(this, appMetadata, userAttributeParcel));
        } else {
            this.f7392a.zzbsc().zzm(new C1919bj(this, appMetadata, userAttributeParcel));
        }
    }

    public byte[] zza(EventParcel eventParcel, String str) {
        zzab.zzhr(str);
        zzab.zzy(eventParcel);
        m8011c(str);
        this.f7392a.zzbsd().zzbtb().zzj("Log and bundle. event", eventParcel.name);
        long nanoTime = this.f7392a.zzyw().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f7392a.zzbsc().zze(new C1917bh(this, eventParcel, str)).get();
            if (bArr == null) {
                this.f7392a.zzbsd().zzbsv().log("Log and bundle returned null");
                bArr = new byte[0];
            }
            this.f7392a.zzbsd().zzbtb().zzd("Log and bundle processed. event, size, time_ms", eventParcel.name, Integer.valueOf(bArr.length), Long.valueOf((this.f7392a.zzyw().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.f7392a.zzbsd().zzbsv().zze("Failed to log and bundle. event, error", eventParcel.name, e);
            return null;
        }
    }

    public void zzb(AppMetadata appMetadata) {
        m8010a(appMetadata);
        this.f7392a.zzbsc().zzm(new C1914be(this, appMetadata));
    }
}
