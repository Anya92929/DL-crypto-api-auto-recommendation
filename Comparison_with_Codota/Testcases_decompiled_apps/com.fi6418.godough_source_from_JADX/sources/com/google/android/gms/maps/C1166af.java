package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.common.C0799c;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.p017b.C0597b;
import com.google.android.gms.p017b.C0608m;
import com.google.android.gms.p017b.C0609n;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.maps.af */
class C1166af extends C0597b<C1164ad> {

    /* renamed from: a */
    protected C0609n<C1164ad> f5043a;

    /* renamed from: b */
    private final ViewGroup f5044b;

    /* renamed from: c */
    private final Context f5045c;

    /* renamed from: d */
    private final StreetViewPanoramaOptions f5046d;

    /* renamed from: e */
    private final List<OnStreetViewPanoramaReadyCallback> f5047e = new ArrayList();

    C1166af(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        this.f5044b = viewGroup;
        this.f5045c = context;
        this.f5046d = streetViewPanoramaOptions;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6956a(C0609n<C1164ad> nVar) {
        this.f5043a = nVar;
        mo8175g();
    }

    /* renamed from: a */
    public void mo8174a(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        if (mo6952a() != null) {
            ((C1164ad) mo6952a()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
        } else {
            this.f5047e.add(onStreetViewPanoramaReadyCallback);
        }
    }

    /* renamed from: g */
    public void mo8175g() {
        if (this.f5043a != null && mo6952a() == null) {
            try {
                this.f5043a.mo6963a(new C1164ad(this.f5044b, zzy.zzaF(this.f5045c).zza(C0608m.m3536a(this.f5045c), this.f5046d)));
                for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.f5047e) {
                    ((C1164ad) mo6952a()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                }
                this.f5047e.clear();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            } catch (C0799c e2) {
            }
        }
    }
}
