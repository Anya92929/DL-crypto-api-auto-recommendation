package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.mediation.admob.AdMobServerParameters;
import com.google.android.gms.dynamic.C0164b;
import com.google.android.gms.dynamic.C0167c;
import com.google.android.gms.internal.C0241ax;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.az */
public final class C0247az<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends C0241ax.C0242a {

    /* renamed from: fr */
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> f615fr;

    /* renamed from: fs */
    private final NETWORK_EXTRAS f616fs;

    public C0247az(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.f615fr = mediationAdapter;
        this.f616fs = network_extras;
    }

    /* renamed from: a */
    private SERVER_PARAMETERS m536a(String str, int i) throws RemoteException {
        HashMap hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                HashMap hashMap2 = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap2.put(next, jSONObject.getString(next));
                }
                hashMap = hashMap2;
            } catch (Throwable th) {
                C0344cn.m731b("Could not get MediationServerParameters.", th);
                throw new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class<SERVER_PARAMETERS> serverParametersType = this.f615fr.getServerParametersType();
        SERVER_PARAMETERS server_parameters = null;
        if (serverParametersType != null) {
            SERVER_PARAMETERS server_parameters2 = (MediationServerParameters) serverParametersType.newInstance();
            server_parameters2.load(hashMap);
            server_parameters = server_parameters2;
        }
        if (server_parameters instanceof AdMobServerParameters) {
            ((AdMobServerParameters) server_parameters).tagForChildDirectedTreatment = i;
        }
        return server_parameters;
    }

    /* renamed from: a */
    public void mo4066a(C0164b bVar, C0620v vVar, String str, C0244ay ayVar) throws RemoteException {
        if (!(this.f615fr instanceof MediationInterstitialAdapter)) {
            C0344cn.m737q("MediationAdapter is not a MediationInterstitialAdapter: " + this.f615fr.getClass().getCanonicalName());
            throw new RemoteException();
        }
        C0344cn.m733m("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f615fr).requestInterstitialAd(new C0263ba(ayVar), (Activity) C0167c.m378b(bVar), m536a(str, vVar.tagForChildDirectedTreatment), C0275bb.m558e(vVar), this.f616fs);
        } catch (Throwable th) {
            C0344cn.m731b("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public void mo4067a(C0164b bVar, C0622x xVar, C0620v vVar, String str, C0244ay ayVar) throws RemoteException {
        if (!(this.f615fr instanceof MediationBannerAdapter)) {
            C0344cn.m737q("MediationAdapter is not a MediationBannerAdapter: " + this.f615fr.getClass().getCanonicalName());
            throw new RemoteException();
        }
        C0344cn.m733m("Requesting banner ad from adapter.");
        try {
            ((MediationBannerAdapter) this.f615fr).requestBannerAd(new C0263ba(ayVar), (Activity) C0167c.m378b(bVar), m536a(str, vVar.tagForChildDirectedTreatment), C0275bb.m556a(xVar), C0275bb.m558e(vVar), this.f616fs);
        } catch (Throwable th) {
            C0344cn.m731b("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.f615fr.destroy();
        } catch (Throwable th) {
            C0344cn.m731b("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    public C0164b getView() throws RemoteException {
        if (!(this.f615fr instanceof MediationBannerAdapter)) {
            C0344cn.m737q("MediationAdapter is not a MediationBannerAdapter: " + this.f615fr.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            return C0167c.m379g(((MediationBannerAdapter) this.f615fr).getBannerView());
        } catch (Throwable th) {
            C0344cn.m731b("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    public void showInterstitial() throws RemoteException {
        if (!(this.f615fr instanceof MediationInterstitialAdapter)) {
            C0344cn.m737q("MediationAdapter is not a MediationInterstitialAdapter: " + this.f615fr.getClass().getCanonicalName());
            throw new RemoteException();
        }
        C0344cn.m733m("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f615fr).showInterstitial();
        } catch (Throwable th) {
            C0344cn.m731b("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }
}
