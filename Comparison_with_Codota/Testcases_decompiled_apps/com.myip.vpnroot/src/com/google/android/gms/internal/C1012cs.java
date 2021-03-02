package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.C1013ct;
import java.util.Map;

@C1130ez
/* renamed from: com.google.android.gms.internal.cs */
public final class C1012cs extends C1013ct.C1014a {

    /* renamed from: qC */
    private Map<Class<? extends NetworkExtras>, NetworkExtras> f3063qC;

    /* renamed from: z */
    private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> C1016cu m4152z(String str) throws RemoteException {
        try {
            Class<?> cls = Class.forName(str, false, C1012cs.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                MediationAdapter mediationAdapter = (MediationAdapter) cls.newInstance();
                return new C1025cz(mediationAdapter, (com.google.ads.mediation.NetworkExtras) this.f3063qC.get(mediationAdapter.getAdditionalParametersType()));
            } else if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(cls)) {
                return new C1023cx((com.google.android.gms.ads.mediation.MediationAdapter) cls.newInstance());
            } else {
                C1229gs.m4679W("Could not instantiate mediation adapter: " + str + " (not a valid adapter).");
                throw new RemoteException();
            }
        } catch (Throwable th) {
            C1229gs.m4679W("Could not instantiate mediation adapter: " + str + ". " + th.getMessage());
            throw new RemoteException();
        }
    }

    /* renamed from: d */
    public void mo8236d(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.f3063qC = map;
    }

    /* renamed from: x */
    public C1016cu mo8237x(String str) throws RemoteException {
        return m4152z(str);
    }

    /* renamed from: y */
    public boolean mo8238y(String str) throws RemoteException {
        try {
            return CustomEvent.class.isAssignableFrom(Class.forName(str, false, C1012cs.class.getClassLoader()));
        } catch (Throwable th) {
            C1229gs.m4679W("Could not load custom event implementation class: " + str + ", assuming old implementation.");
            return false;
        }
    }
}
