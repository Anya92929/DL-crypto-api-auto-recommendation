package com.google.android.gms.maps;

import android.app.Activity;
import android.os.RemoteException;
import android.support.p000v4.app.Fragment;
import com.google.android.gms.common.C0799c;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.p017b.C0597b;
import com.google.android.gms.p017b.C0608m;
import com.google.android.gms.p017b.C0609n;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.maps.al */
class C1172al extends C0597b<C1170aj> {

    /* renamed from: a */
    protected C0609n<C1170aj> f5060a;

    /* renamed from: b */
    private final Fragment f5061b;

    /* renamed from: c */
    private Activity f5062c;

    /* renamed from: d */
    private final List<OnStreetViewPanoramaReadyCallback> f5063d = new ArrayList();

    C1172al(Fragment fragment) {
        this.f5061b = fragment;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5073a(Activity activity) {
        this.f5062c = activity;
        mo8183g();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6956a(C0609n<C1170aj> nVar) {
        this.f5060a = nVar;
        mo8183g();
    }

    /* renamed from: a */
    public void mo8182a(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        if (mo6952a() != null) {
            ((C1170aj) mo6952a()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
        } else {
            this.f5063d.add(onStreetViewPanoramaReadyCallback);
        }
    }

    /* renamed from: g */
    public void mo8183g() {
        if (this.f5062c != null && this.f5060a != null && mo6952a() == null) {
            try {
                MapsInitializer.initialize(this.f5062c);
                this.f5060a.mo6963a(new C1170aj(this.f5061b, zzy.zzaF(this.f5062c).zzu(C0608m.m3536a(this.f5062c))));
                for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.f5063d) {
                    ((C1170aj) mo6952a()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                }
                this.f5063d.clear();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            } catch (C0799c e2) {
            }
        }
    }
}
