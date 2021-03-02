package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.C0238aw;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.av */
public final class C0237av extends C0238aw.C0239a {

    /* renamed from: fq */
    private Map<Class<? extends NetworkExtras>, NetworkExtras> f611fq;

    /* renamed from: h */
    private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> C0241ax m522h(String str) throws RemoteException {
        try {
            MediationAdapter mediationAdapter = (MediationAdapter) Class.forName(str).newInstance();
            return new C0247az(mediationAdapter, (com.google.ads.mediation.NetworkExtras) this.f611fq.get(mediationAdapter.getAdditionalParametersType()));
        } catch (Throwable th) {
            C0344cn.m737q("Could not instantiate mediation adapter: " + str + ". " + th.getMessage());
            throw new RemoteException();
        }
    }

    /* renamed from: c */
    public void mo4061c(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.f611fq = map;
    }

    /* renamed from: g */
    public C0241ax mo4062g(String str) throws RemoteException {
        return m522h(str);
    }
}
