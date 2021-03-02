package com.google.android.gms.maps;

import android.app.Activity;
import android.os.RemoteException;
import android.support.p000v4.app.Fragment;
import com.google.android.gms.common.C0799c;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.p017b.C0597b;
import com.google.android.gms.p017b.C0608m;
import com.google.android.gms.p017b.C0609n;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.maps.ai */
class C1169ai extends C0597b<C1167ag> {

    /* renamed from: a */
    protected C0609n<C1167ag> f5052a;

    /* renamed from: b */
    private final Fragment f5053b;

    /* renamed from: c */
    private Activity f5054c;

    /* renamed from: d */
    private final List<OnMapReadyCallback> f5055d = new ArrayList();

    C1169ai(Fragment fragment) {
        this.f5053b = fragment;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5058a(Activity activity) {
        this.f5054c = activity;
        mo8180g();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6956a(C0609n<C1167ag> nVar) {
        this.f5052a = nVar;
        mo8180g();
    }

    /* renamed from: a */
    public void mo8179a(OnMapReadyCallback onMapReadyCallback) {
        if (mo6952a() != null) {
            ((C1167ag) mo6952a()).getMapAsync(onMapReadyCallback);
        } else {
            this.f5055d.add(onMapReadyCallback);
        }
    }

    /* renamed from: g */
    public void mo8180g() {
        if (this.f5054c != null && this.f5052a != null && mo6952a() == null) {
            try {
                MapsInitializer.initialize(this.f5054c);
                IMapFragmentDelegate zzt = zzy.zzaF(this.f5054c).zzt(C0608m.m3536a(this.f5054c));
                if (zzt != null) {
                    this.f5052a.mo6963a(new C1167ag(this.f5053b, zzt));
                    for (OnMapReadyCallback mapAsync : this.f5055d) {
                        ((C1167ag) mo6952a()).getMapAsync(mapAsync);
                    }
                    this.f5055d.clear();
                }
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            } catch (C0799c e2) {
            }
        }
    }
}
