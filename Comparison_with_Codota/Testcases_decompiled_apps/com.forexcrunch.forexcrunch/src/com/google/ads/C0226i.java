package com.google.ads;

import android.app.Activity;
import com.google.ads.C0221g;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.util.C0284b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.ads.i */
class C0226i implements Runnable {

    /* renamed from: a */
    private final C0223h f445a;

    /* renamed from: b */
    private final String f446b;

    /* renamed from: c */
    private final AdRequest f447c;

    /* renamed from: d */
    private final HashMap<String, String> f448d;

    /* renamed from: e */
    private final boolean f449e = m202a((Map<String, String>) this.f448d);

    /* renamed from: f */
    private final WeakReference<Activity> f450f;

    /* renamed from: com.google.ads.i$a */
    private static class C0227a extends Exception {
        public C0227a(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    private static boolean m202a(Map<String, String> map) {
        String remove = map.remove("gwhirl_share_location");
        if ("1".equals(remove)) {
            return true;
        }
        if (remove != null && !"0".equals(remove)) {
            C0284b.m484b("Received an illegal value, '" + remove + "', for the special share location parameter from mediation server" + " (expected '0' or '1'). Will not share the location.");
        }
        return false;
    }

    public C0226i(C0223h hVar, Activity activity, String str, AdRequest adRequest, HashMap<String, String> hashMap) {
        this.f445a = hVar;
        this.f446b = str;
        this.f450f = new WeakReference<>(activity);
        this.f447c = adRequest;
        this.f448d = new HashMap<>(hashMap);
    }

    public void run() {
        try {
            C0284b.m480a("Trying to instantiate: " + this.f446b);
            m200a((MediationAdapter) C0221g.m181a(this.f446b, MediationAdapter.class));
        } catch (ClassNotFoundException e) {
            m201a("Cannot find adapter class '" + this.f446b + "'. Did you link the ad network's mediation adapter? Skipping ad network.", e, C0221g.C0222a.NOT_FOUND);
        } catch (Throwable th) {
            m201a("Error while creating adapter and loading ad from ad network. Skipping ad network.", th, C0221g.C0222a.EXCEPTION);
        }
    }

    /* renamed from: a */
    private void m201a(String str, Throwable th, C0221g.C0222a aVar) {
        C0284b.m485b(str, th);
        this.f445a.mo3412a(false, aVar);
    }

    /* renamed from: a */
    private <T extends NetworkExtras, U extends MediationServerParameters> void m200a(MediationAdapter<T, U> mediationAdapter) throws MediationServerParameters.MappingException, C0227a, IllegalAccessException, InstantiationException {
        MediationServerParameters mediationServerParameters;
        NetworkExtras networkExtras;
        Activity activity = (Activity) this.f450f.get();
        if (activity == null) {
            throw new C0227a("Activity became null while trying to instantiate adapter.");
        }
        this.f445a.mo3411a((MediationAdapter<?, ?>) mediationAdapter);
        Class<U> serverParametersType = mediationAdapter.getServerParametersType();
        if (serverParametersType != null) {
            MediationServerParameters mediationServerParameters2 = (MediationServerParameters) serverParametersType.newInstance();
            mediationServerParameters2.load(this.f448d);
            mediationServerParameters = mediationServerParameters2;
        } else {
            mediationServerParameters = null;
        }
        Class<T> additionalParametersType = mediationAdapter.getAdditionalParametersType();
        if (additionalParametersType != null) {
            networkExtras = (NetworkExtras) this.f447c.getNetworkExtras(additionalParametersType);
        } else {
            networkExtras = null;
        }
        MediationAdRequest mediationAdRequest = new MediationAdRequest(this.f447c, activity, this.f449e);
        if (this.f445a.f429a.mo3609a()) {
            if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
                throw new C0227a("Adapter " + this.f446b + " doesn't support the MediationInterstitialAdapter" + " interface.");
            }
            ((MediationInterstitialAdapter) mediationAdapter).requestInterstitialAd(new C0263k(this.f445a), activity, mediationServerParameters, mediationAdRequest, networkExtras);
        } else if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            throw new C0227a("Adapter " + this.f446b + " doesn't support the MediationBannerAdapter interface");
        } else {
            ((MediationBannerAdapter) mediationAdapter).requestBannerAd(new C0262j(this.f445a), activity, mediationServerParameters, this.f445a.f429a.mo3612c(), mediationAdRequest, networkExtras);
        }
        this.f445a.mo3422k();
    }
}
