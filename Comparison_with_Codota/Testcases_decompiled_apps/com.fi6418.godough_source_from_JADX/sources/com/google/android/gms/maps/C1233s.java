package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.RemoteException;
import com.google.android.gms.common.C0799c;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.p017b.C0597b;
import com.google.android.gms.p017b.C0608m;
import com.google.android.gms.p017b.C0609n;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.maps.s */
class C1233s extends C0597b<C1231p> {

    /* renamed from: a */
    protected C0609n<C1231p> f5230a;

    /* renamed from: b */
    private final Fragment f5231b;

    /* renamed from: c */
    private Activity f5232c;

    /* renamed from: d */
    private final List<OnMapReadyCallback> f5233d = new ArrayList();

    C1233s(Fragment fragment) {
        this.f5231b = fragment;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5142a(Activity activity) {
        this.f5232c = activity;
        mo8988g();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6956a(C0609n<C1231p> nVar) {
        this.f5230a = nVar;
        mo8988g();
    }

    /* renamed from: a */
    public void mo8987a(OnMapReadyCallback onMapReadyCallback) {
        if (mo6952a() != null) {
            ((C1231p) mo6952a()).getMapAsync(onMapReadyCallback);
        } else {
            this.f5233d.add(onMapReadyCallback);
        }
    }

    /* renamed from: g */
    public void mo8988g() {
        if (this.f5232c != null && this.f5230a != null && mo6952a() == null) {
            try {
                MapsInitializer.initialize(this.f5232c);
                IMapFragmentDelegate zzt = zzy.zzaF(this.f5232c).zzt(C0608m.m3536a(this.f5232c));
                if (zzt != null) {
                    this.f5230a.mo6963a(new C1231p(this.f5231b, zzt));
                    for (OnMapReadyCallback mapAsync : this.f5233d) {
                        ((C1231p) mo6952a()).getMapAsync(mapAsync);
                    }
                    this.f5233d.clear();
                }
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            } catch (C0799c e2) {
            }
        }
    }
}
