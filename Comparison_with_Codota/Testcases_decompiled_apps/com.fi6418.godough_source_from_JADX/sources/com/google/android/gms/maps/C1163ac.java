package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.RemoteException;
import com.google.android.gms.common.C0799c;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.p017b.C0597b;
import com.google.android.gms.p017b.C0608m;
import com.google.android.gms.p017b.C0609n;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.maps.ac */
class C1163ac extends C0597b<C1161aa> {

    /* renamed from: a */
    protected C0609n<C1161aa> f5034a;

    /* renamed from: b */
    private final Fragment f5035b;

    /* renamed from: c */
    private Activity f5036c;

    /* renamed from: d */
    private final List<OnStreetViewPanoramaReadyCallback> f5037d = new ArrayList();

    C1163ac(Fragment fragment) {
        this.f5035b = fragment;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5030a(Activity activity) {
        this.f5036c = activity;
        mo8172g();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6956a(C0609n<C1161aa> nVar) {
        this.f5034a = nVar;
        mo8172g();
    }

    /* renamed from: a */
    public void mo8171a(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        if (mo6952a() != null) {
            ((C1161aa) mo6952a()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
        } else {
            this.f5037d.add(onStreetViewPanoramaReadyCallback);
        }
    }

    /* renamed from: g */
    public void mo8172g() {
        if (this.f5036c != null && this.f5034a != null && mo6952a() == null) {
            try {
                MapsInitializer.initialize(this.f5036c);
                this.f5034a.mo6963a(new C1161aa(this.f5035b, zzy.zzaF(this.f5036c).zzu(C0608m.m3536a(this.f5036c))));
                for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.f5037d) {
                    ((C1161aa) mo6952a()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                }
                this.f5037d.clear();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            } catch (C0799c e2) {
            }
        }
    }
}
