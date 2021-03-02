package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@C1130ez
/* renamed from: com.google.android.gms.internal.bg */
public final class C0944bg {
    public static final String DEVICE_ID_EMULATOR = C1228gr.m4666R("emulator");

    /* renamed from: d */
    private final Date f2844d;

    /* renamed from: f */
    private final Set<String> f2845f;

    /* renamed from: h */
    private final Location f2846h;

    /* renamed from: ol */
    private final String f2847ol;

    /* renamed from: om */
    private final int f2848om;

    /* renamed from: on */
    private final boolean f2849on;

    /* renamed from: oo */
    private final Bundle f2850oo;

    /* renamed from: op */
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> f2851op;

    /* renamed from: oq */
    private final String f2852oq;

    /* renamed from: or */
    private final SearchAdRequest f2853or;

    /* renamed from: os */
    private final int f2854os;

    /* renamed from: ot */
    private final Set<String> f2855ot;

    /* renamed from: com.google.android.gms.internal.bg$a */
    public static final class C0945a {
        /* access modifiers changed from: private */

        /* renamed from: d */
        public Date f2856d;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public Location f2857h;
        /* access modifiers changed from: private */

        /* renamed from: ol */
        public String f2858ol;
        /* access modifiers changed from: private */

        /* renamed from: om */
        public int f2859om = -1;
        /* access modifiers changed from: private */

        /* renamed from: on */
        public boolean f2860on = false;
        /* access modifiers changed from: private */

        /* renamed from: oo */
        public final Bundle f2861oo = new Bundle();
        /* access modifiers changed from: private */

        /* renamed from: oq */
        public String f2862oq;
        /* access modifiers changed from: private */

        /* renamed from: os */
        public int f2863os = -1;
        /* access modifiers changed from: private */

        /* renamed from: ou */
        public final HashSet<String> f2864ou = new HashSet<>();
        /* access modifiers changed from: private */

        /* renamed from: ov */
        public final HashMap<Class<? extends NetworkExtras>, NetworkExtras> f2865ov = new HashMap<>();
        /* access modifiers changed from: private */

        /* renamed from: ow */
        public final HashSet<String> f2866ow = new HashSet<>();

        /* renamed from: a */
        public void mo8078a(Location location) {
            this.f2857h = location;
        }

        @Deprecated
        /* renamed from: a */
        public void mo8079a(NetworkExtras networkExtras) {
            if (networkExtras instanceof AdMobExtras) {
                mo8080a(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
            } else {
                this.f2865ov.put(networkExtras.getClass(), networkExtras);
            }
        }

        /* renamed from: a */
        public void mo8080a(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.f2861oo.putBundle(cls.getName(), bundle);
        }

        /* renamed from: a */
        public void mo8081a(Date date) {
            this.f2856d = date;
        }

        /* renamed from: b */
        public void mo8082b(Class<? extends CustomEvent> cls, Bundle bundle) {
            if (this.f2861oo.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
                this.f2861oo.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
            }
            this.f2861oo.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
        }

        /* renamed from: g */
        public void mo8083g(int i) {
            this.f2859om = i;
        }

        /* renamed from: g */
        public void mo8084g(boolean z) {
            this.f2860on = z;
        }

        /* renamed from: h */
        public void mo8085h(boolean z) {
            this.f2863os = z ? 1 : 0;
        }

        /* renamed from: r */
        public void mo8086r(String str) {
            this.f2864ou.add(str);
        }

        /* renamed from: s */
        public void mo8087s(String str) {
            this.f2866ow.add(str);
        }

        /* renamed from: t */
        public void mo8088t(String str) {
            this.f2858ol = str;
        }

        /* renamed from: u */
        public void mo8089u(String str) {
            this.f2862oq = str;
        }
    }

    public C0944bg(C0945a aVar) {
        this(aVar, (SearchAdRequest) null);
    }

    public C0944bg(C0945a aVar, SearchAdRequest searchAdRequest) {
        this.f2844d = aVar.f2856d;
        this.f2847ol = aVar.f2858ol;
        this.f2848om = aVar.f2859om;
        this.f2845f = Collections.unmodifiableSet(aVar.f2864ou);
        this.f2846h = aVar.f2857h;
        this.f2849on = aVar.f2860on;
        this.f2850oo = aVar.f2861oo;
        this.f2851op = Collections.unmodifiableMap(aVar.f2865ov);
        this.f2852oq = aVar.f2862oq;
        this.f2853or = searchAdRequest;
        this.f2854os = aVar.f2863os;
        this.f2855ot = Collections.unmodifiableSet(aVar.f2866ow);
    }

    /* renamed from: bd */
    public SearchAdRequest mo8063bd() {
        return this.f2853or;
    }

    /* renamed from: be */
    public Map<Class<? extends NetworkExtras>, NetworkExtras> mo8064be() {
        return this.f2851op;
    }

    /* renamed from: bf */
    public Bundle mo8065bf() {
        return this.f2850oo;
    }

    /* renamed from: bg */
    public int mo8066bg() {
        return this.f2854os;
    }

    public Date getBirthday() {
        return this.f2844d;
    }

    public String getContentUrl() {
        return this.f2847ol;
    }

    public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass) {
        Bundle bundle = this.f2850oo.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(adapterClass.getClass().getName());
        }
        return null;
    }

    public int getGender() {
        return this.f2848om;
    }

    public Set<String> getKeywords() {
        return this.f2845f;
    }

    public Location getLocation() {
        return this.f2846h;
    }

    public boolean getManualImpressionsEnabled() {
        return this.f2849on;
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return (NetworkExtras) this.f2851op.get(networkExtrasClass);
    }

    public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass) {
        return this.f2850oo.getBundle(adapterClass.getName());
    }

    public String getPublisherProvidedId() {
        return this.f2852oq;
    }

    public boolean isTestDevice(Context context) {
        return this.f2855ot.contains(C1228gr.m4674v(context));
    }
}
