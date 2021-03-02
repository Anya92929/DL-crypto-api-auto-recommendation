package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.C0594d;
import com.google.android.gms.dynamic.C0597e;
import com.google.android.gms.internal.C1016cu;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.cz */
public final class C1025cz<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends C1016cu.C1017a {

    /* renamed from: qG */
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> f3075qG;

    /* renamed from: qH */
    private final NETWORK_EXTRAS f3076qH;

    public C1025cz(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.f3075qG = mediationAdapter;
        this.f3076qH = network_extras;
    }

    /* renamed from: b */
    private SERVER_PARAMETERS m4176b(String str, int i, String str2) throws RemoteException {
        HashMap hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } catch (Throwable th) {
                C1229gs.m4683d("Could not get MediationServerParameters.", th);
                throw new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class<SERVER_PARAMETERS> serverParametersType = this.f3075qG.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        SERVER_PARAMETERS server_parameters = (MediationServerParameters) serverParametersType.newInstance();
        server_parameters.load(hashMap);
        return server_parameters;
    }

    /* renamed from: a */
    public void mo8242a(C0594d dVar, C0924av avVar, String str, C1019cv cvVar) throws RemoteException {
        mo8243a(dVar, avVar, str, (String) null, cvVar);
    }

    /* renamed from: a */
    public void mo8243a(C0594d dVar, C0924av avVar, String str, String str2, C1019cv cvVar) throws RemoteException {
        if (!(this.f3075qG instanceof MediationInterstitialAdapter)) {
            C1229gs.m4679W("MediationAdapter is not a MediationInterstitialAdapter: " + this.f3075qG.getClass().getCanonicalName());
            throw new RemoteException();
        }
        C1229gs.m4675S("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f3075qG).requestInterstitialAd(new C1028da(cvVar), (Activity) C0597e.m1742f(dVar), m4176b(str, avVar.f2614nX, str2), C1040db.m4190d(avVar), this.f3076qH);
        } catch (Throwable th) {
            C1229gs.m4683d("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public void mo8244a(C0594d dVar, C0927ay ayVar, C0924av avVar, String str, C1019cv cvVar) throws RemoteException {
        mo8245a(dVar, ayVar, avVar, str, (String) null, cvVar);
    }

    /* renamed from: a */
    public void mo8245a(C0594d dVar, C0927ay ayVar, C0924av avVar, String str, String str2, C1019cv cvVar) throws RemoteException {
        if (!(this.f3075qG instanceof MediationBannerAdapter)) {
            C1229gs.m4679W("MediationAdapter is not a MediationBannerAdapter: " + this.f3075qG.getClass().getCanonicalName());
            throw new RemoteException();
        }
        C1229gs.m4675S("Requesting banner ad from adapter.");
        try {
            ((MediationBannerAdapter) this.f3075qG).requestBannerAd(new C1028da(cvVar), (Activity) C0597e.m1742f(dVar), m4176b(str, avVar.f2614nX, str2), C1040db.m4189b(ayVar), C1040db.m4190d(avVar), this.f3076qH);
        } catch (Throwable th) {
            C1229gs.m4683d("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.f3075qG.destroy();
        } catch (Throwable th) {
            C1229gs.m4683d("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    public C0594d getView() throws RemoteException {
        if (!(this.f3075qG instanceof MediationBannerAdapter)) {
            C1229gs.m4679W("MediationAdapter is not a MediationBannerAdapter: " + this.f3075qG.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            return C0597e.m1743k(((MediationBannerAdapter) this.f3075qG).getBannerView());
        } catch (Throwable th) {
            C1229gs.m4683d("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    public void pause() throws RemoteException {
        throw new RemoteException();
    }

    public void resume() throws RemoteException {
        throw new RemoteException();
    }

    public void showInterstitial() throws RemoteException {
        if (!(this.f3075qG instanceof MediationInterstitialAdapter)) {
            C1229gs.m4679W("MediationAdapter is not a MediationInterstitialAdapter: " + this.f3075qG.getClass().getCanonicalName());
            throw new RemoteException();
        }
        C1229gs.m4675S("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f3075qG).showInterstitial();
        } catch (Throwable th) {
            C1229gs.m4683d("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }
}
