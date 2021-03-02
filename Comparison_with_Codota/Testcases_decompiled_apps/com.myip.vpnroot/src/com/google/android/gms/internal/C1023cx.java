package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.C0139a;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.dynamic.C0594d;
import com.google.android.gms.dynamic.C0597e;
import com.google.android.gms.internal.C1016cu;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.cx */
public final class C1023cx extends C1016cu.C1017a {

    /* renamed from: qE */
    private final MediationAdapter f3073qE;

    public C1023cx(MediationAdapter mediationAdapter) {
        this.f3073qE = mediationAdapter;
    }

    /* renamed from: a */
    private Bundle m4171a(String str, int i, String str2) throws RemoteException {
        C1229gs.m4679W("Server parameters: " + str);
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.f3073qE instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            C1229gs.m4683d("Could not get Server Parameters Bundle.", th);
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public void mo8242a(C0594d dVar, C0924av avVar, String str, C1019cv cvVar) throws RemoteException {
        mo8243a(dVar, avVar, str, (String) null, cvVar);
    }

    /* renamed from: a */
    public void mo8243a(C0594d dVar, C0924av avVar, String str, String str2, C1019cv cvVar) throws RemoteException {
        if (!(this.f3073qE instanceof MediationInterstitialAdapter)) {
            C1229gs.m4679W("MediationAdapter is not a MediationInterstitialAdapter: " + this.f3073qE.getClass().getCanonicalName());
            throw new RemoteException();
        }
        C1229gs.m4675S("Requesting interstitial ad from adapter.");
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.f3073qE;
            mediationInterstitialAdapter.requestInterstitialAd((Context) C0597e.m1742f(dVar), new C1024cy(cvVar), m4171a(str, avVar.f2614nX, str2), new C1022cw(new Date(avVar.f2610nT), avVar.f2611nU, avVar.f2612nV != null ? new HashSet(avVar.f2612nV) : null, avVar.f2618ob, avVar.f2613nW, avVar.f2614nX), avVar.f2620od != null ? avVar.f2620od.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
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
        Bundle bundle = null;
        if (!(this.f3073qE instanceof MediationBannerAdapter)) {
            C1229gs.m4679W("MediationAdapter is not a MediationBannerAdapter: " + this.f3073qE.getClass().getCanonicalName());
            throw new RemoteException();
        }
        C1229gs.m4675S("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.f3073qE;
            C1022cw cwVar = new C1022cw(new Date(avVar.f2610nT), avVar.f2611nU, avVar.f2612nV != null ? new HashSet(avVar.f2612nV) : null, avVar.f2618ob, avVar.f2613nW, avVar.f2614nX);
            if (avVar.f2620od != null) {
                bundle = avVar.f2620od.getBundle(mediationBannerAdapter.getClass().getName());
            }
            mediationBannerAdapter.requestBannerAd((Context) C0597e.m1742f(dVar), new C1024cy(cvVar), m4171a(str, avVar.f2614nX, str2), C0139a.m20a(ayVar.width, ayVar.height, ayVar.f2622of), cwVar, bundle);
        } catch (Throwable th) {
            C1229gs.m4683d("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.f3073qE.onDestroy();
        } catch (Throwable th) {
            C1229gs.m4683d("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    public C0594d getView() throws RemoteException {
        if (!(this.f3073qE instanceof MediationBannerAdapter)) {
            C1229gs.m4679W("MediationAdapter is not a MediationBannerAdapter: " + this.f3073qE.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            return C0597e.m1743k(((MediationBannerAdapter) this.f3073qE).getBannerView());
        } catch (Throwable th) {
            C1229gs.m4683d("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    public void pause() throws RemoteException {
        try {
            this.f3073qE.onPause();
        } catch (Throwable th) {
            C1229gs.m4683d("Could not pause adapter.", th);
            throw new RemoteException();
        }
    }

    public void resume() throws RemoteException {
        try {
            this.f3073qE.onResume();
        } catch (Throwable th) {
            C1229gs.m4683d("Could not resume adapter.", th);
            throw new RemoteException();
        }
    }

    public void showInterstitial() throws RemoteException {
        if (!(this.f3073qE instanceof MediationInterstitialAdapter)) {
            C1229gs.m4679W("MediationAdapter is not a MediationInterstitialAdapter: " + this.f3073qE.getClass().getCanonicalName());
            throw new RemoteException();
        }
        C1229gs.m4675S("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f3073qE).showInterstitial();
        } catch (Throwable th) {
            C1229gs.m4683d("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }
}
