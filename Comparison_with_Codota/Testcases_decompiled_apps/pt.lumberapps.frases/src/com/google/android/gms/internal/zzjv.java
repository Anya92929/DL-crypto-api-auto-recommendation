package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@zzin
public class zzjv {

    /* renamed from: a */
    private final zzjx f6534a;

    /* renamed from: b */
    private final LinkedList f6535b;

    /* renamed from: c */
    private final Object f6536c;

    /* renamed from: d */
    private final String f6537d;

    /* renamed from: e */
    private final String f6538e;

    /* renamed from: f */
    private long f6539f;

    /* renamed from: g */
    private long f6540g;

    /* renamed from: h */
    private boolean f6541h;

    /* renamed from: i */
    private long f6542i;

    /* renamed from: j */
    private long f6543j;

    /* renamed from: k */
    private long f6544k;

    /* renamed from: l */
    private long f6545l;

    public zzjv(zzjx zzjx, String str, String str2) {
        this.f6536c = new Object();
        this.f6539f = -1;
        this.f6540g = -1;
        this.f6541h = false;
        this.f6542i = -1;
        this.f6543j = 0;
        this.f6544k = -1;
        this.f6545l = -1;
        this.f6534a = zzjx;
        this.f6537d = str;
        this.f6538e = str2;
        this.f6535b = new LinkedList();
    }

    public zzjv(String str, String str2) {
        this(zzu.zzft(), str, str2);
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.f6536c) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.f6537d);
            bundle.putString("slotid", this.f6538e);
            bundle.putBoolean("ismediation", this.f6541h);
            bundle.putLong("treq", this.f6544k);
            bundle.putLong("tresponse", this.f6545l);
            bundle.putLong("timp", this.f6540g);
            bundle.putLong("tload", this.f6542i);
            bundle.putLong("pcc", this.f6543j);
            bundle.putLong("tfetch", this.f6539f);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f6535b.iterator();
            while (it.hasNext()) {
                arrayList.add(((C1713lh) it.next()).mo7470d());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public void zzac(boolean z) {
        synchronized (this.f6536c) {
            if (this.f6545l != -1) {
                this.f6542i = SystemClock.elapsedRealtime();
                if (!z) {
                    this.f6540g = this.f6542i;
                    this.f6534a.zza(this);
                }
            }
        }
    }

    public void zzad(boolean z) {
        synchronized (this.f6536c) {
            if (this.f6545l != -1) {
                this.f6541h = z;
                this.f6534a.zza(this);
            }
        }
    }

    public void zzl(long j) {
        synchronized (this.f6536c) {
            this.f6545l = j;
            if (this.f6545l != -1) {
                this.f6534a.zza(this);
            }
        }
    }

    public void zzm(long j) {
        synchronized (this.f6536c) {
            if (this.f6545l != -1) {
                this.f6539f = j;
                this.f6534a.zza(this);
            }
        }
    }

    public void zzq(AdRequestParcel adRequestParcel) {
        synchronized (this.f6536c) {
            this.f6544k = SystemClock.elapsedRealtime();
            this.f6534a.zzsk().zzb(adRequestParcel, this.f6544k);
        }
    }

    public void zzry() {
        synchronized (this.f6536c) {
            if (this.f6545l != -1 && this.f6540g == -1) {
                this.f6540g = SystemClock.elapsedRealtime();
                this.f6534a.zza(this);
            }
            this.f6534a.zzsk().zzry();
        }
    }

    public void zzrz() {
        synchronized (this.f6536c) {
            if (this.f6545l != -1) {
                C1713lh lhVar = new C1713lh();
                lhVar.mo7469c();
                this.f6535b.add(lhVar);
                this.f6543j++;
                this.f6534a.zzsk().zzrz();
                this.f6534a.zza(this);
            }
        }
    }

    public void zzsa() {
        synchronized (this.f6536c) {
            if (this.f6545l != -1 && !this.f6535b.isEmpty()) {
                C1713lh lhVar = (C1713lh) this.f6535b.getLast();
                if (lhVar.mo7467a() == -1) {
                    lhVar.mo7468b();
                    this.f6534a.zza(this);
                }
            }
        }
    }
}
