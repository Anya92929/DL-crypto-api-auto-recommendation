package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzin;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzin
public final class zzad {
    public static final String DEVICE_ID_EMULATOR = zzm.zziw().zzcu("emulator");

    /* renamed from: a */
    private final Date f3501a;

    /* renamed from: b */
    private final String f3502b;

    /* renamed from: c */
    private final int f3503c;

    /* renamed from: d */
    private final Set f3504d;

    /* renamed from: e */
    private final Location f3505e;

    /* renamed from: f */
    private final boolean f3506f;

    /* renamed from: g */
    private final Bundle f3507g;

    /* renamed from: h */
    private final Map f3508h;

    /* renamed from: i */
    private final String f3509i;

    /* renamed from: j */
    private final String f3510j;

    /* renamed from: k */
    private final SearchAdRequest f3511k;

    /* renamed from: l */
    private final int f3512l;

    /* renamed from: m */
    private final Set f3513m;

    /* renamed from: n */
    private final Bundle f3514n;

    /* renamed from: o */
    private final Set f3515o;

    /* renamed from: p */
    private final boolean f3516p;

    public final class zza {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final HashSet f3517a = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final Bundle f3518b = new Bundle();
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final HashMap f3519c = new HashMap();
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final HashSet f3520d = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: e */
        public final Bundle f3521e = new Bundle();
        /* access modifiers changed from: private */

        /* renamed from: f */
        public final HashSet f3522f = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: g */
        public Date f3523g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public String f3524h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public int f3525i = -1;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public Location f3526j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public boolean f3527k = false;
        /* access modifiers changed from: private */

        /* renamed from: l */
        public String f3528l;
        /* access modifiers changed from: private */

        /* renamed from: m */
        public String f3529m;
        /* access modifiers changed from: private */

        /* renamed from: n */
        public int f3530n = -1;
        /* access modifiers changed from: private */

        /* renamed from: o */
        public boolean f3531o;

        public void setManualImpressionsEnabled(boolean z) {
            this.f3527k = z;
        }

        @Deprecated
        public void zza(NetworkExtras networkExtras) {
            if (networkExtras instanceof AdMobExtras) {
                zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
            } else {
                this.f3519c.put(networkExtras.getClass(), networkExtras);
            }
        }

        public void zza(Class cls, Bundle bundle) {
            this.f3518b.putBundle(cls.getName(), bundle);
        }

        public void zza(Date date) {
            this.f3523g = date;
        }

        public void zzaf(String str) {
            this.f3517a.add(str);
        }

        public void zzag(String str) {
            this.f3520d.add(str);
        }

        public void zzah(String str) {
            this.f3520d.remove(str);
        }

        public void zzai(String str) {
            this.f3524h = str;
        }

        public void zzaj(String str) {
            this.f3528l = str;
        }

        public void zzak(String str) {
            this.f3529m = str;
        }

        public void zzal(String str) {
            this.f3522f.add(str);
        }

        public void zzb(Location location) {
            this.f3526j = location;
        }

        public void zzb(Class cls, Bundle bundle) {
            if (this.f3518b.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
                this.f3518b.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
            }
            this.f3518b.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
        }

        public void zzf(String str, String str2) {
            this.f3521e.putString(str, str2);
        }

        public void zzn(boolean z) {
            this.f3530n = z ? 1 : 0;
        }

        public void zzo(boolean z) {
            this.f3531o = z;
        }

        public void zzt(int i) {
            this.f3525i = i;
        }
    }

    public zzad(zza zza2) {
        this(zza2, (SearchAdRequest) null);
    }

    public zzad(zza zza2, SearchAdRequest searchAdRequest) {
        this.f3501a = zza2.f3523g;
        this.f3502b = zza2.f3524h;
        this.f3503c = zza2.f3525i;
        this.f3504d = Collections.unmodifiableSet(zza2.f3517a);
        this.f3505e = zza2.f3526j;
        this.f3506f = zza2.f3527k;
        this.f3507g = zza2.f3518b;
        this.f3508h = Collections.unmodifiableMap(zza2.f3519c);
        this.f3509i = zza2.f3528l;
        this.f3510j = zza2.f3529m;
        this.f3511k = searchAdRequest;
        this.f3512l = zza2.f3530n;
        this.f3513m = Collections.unmodifiableSet(zza2.f3520d);
        this.f3514n = zza2.f3521e;
        this.f3515o = Collections.unmodifiableSet(zza2.f3522f);
        this.f3516p = zza2.f3531o;
    }

    public Date getBirthday() {
        return this.f3501a;
    }

    public String getContentUrl() {
        return this.f3502b;
    }

    public Bundle getCustomEventExtrasBundle(Class cls) {
        Bundle bundle = this.f3507g.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public Bundle getCustomTargeting() {
        return this.f3514n;
    }

    public int getGender() {
        return this.f3503c;
    }

    public Set getKeywords() {
        return this.f3504d;
    }

    public Location getLocation() {
        return this.f3505e;
    }

    public boolean getManualImpressionsEnabled() {
        return this.f3506f;
    }

    @Deprecated
    public NetworkExtras getNetworkExtras(Class cls) {
        return (NetworkExtras) this.f3508h.get(cls);
    }

    public Bundle getNetworkExtrasBundle(Class cls) {
        return this.f3507g.getBundle(cls.getName());
    }

    public String getPublisherProvidedId() {
        return this.f3509i;
    }

    public boolean isDesignedForFamilies() {
        return this.f3516p;
    }

    public boolean isTestDevice(Context context) {
        return this.f3513m.contains(zzm.zziw().zzaq(context));
    }

    public String zzje() {
        return this.f3510j;
    }

    public SearchAdRequest zzjf() {
        return this.f3511k;
    }

    public Map zzjg() {
        return this.f3508h;
    }

    public Bundle zzjh() {
        return this.f3507g;
    }

    public int zzji() {
        return this.f3512l;
    }

    public Set zzjj() {
        return this.f3515o;
    }
}
