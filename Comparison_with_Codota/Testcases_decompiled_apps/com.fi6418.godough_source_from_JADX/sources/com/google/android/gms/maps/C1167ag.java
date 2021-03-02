package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzx;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.p017b.C0608m;

/* renamed from: com.google.android.gms.maps.ag */
class C1167ag implements MapLifecycleDelegate {

    /* renamed from: a */
    private final Fragment f5048a;

    /* renamed from: b */
    private final IMapFragmentDelegate f5049b;

    public C1167ag(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
        this.f5049b = (IMapFragmentDelegate) C1009bf.m4528a(iMapFragmentDelegate);
        this.f5048a = (Fragment) C1009bf.m4528a(fragment);
    }

    /* renamed from: a */
    public View mo6942a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            return (View) C0608m.m3537a(this.f5049b.onCreateView(C0608m.m3536a(layoutInflater), C0608m.m3536a(viewGroup), bundle));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: a */
    public void mo6943a() {
        try {
            this.f5049b.onResume();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: a */
    public void mo6944a(Activity activity, Bundle bundle, Bundle bundle2) {
        try {
            this.f5049b.onInflate(C0608m.m3536a(activity), (GoogleMapOptions) bundle.getParcelable("MapOptions"), bundle2);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: a */
    public void mo6945a(Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        Bundle arguments = this.f5048a.getArguments();
        if (arguments != null && arguments.containsKey("MapOptions")) {
            zzx.zza(bundle, "MapOptions", arguments.getParcelable("MapOptions"));
        }
        this.f5049b.onCreate(bundle);
    }

    /* renamed from: b */
    public void mo6946b() {
        try {
            this.f5049b.onPause();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: b */
    public void mo6947b(Bundle bundle) {
        try {
            this.f5049b.onSaveInstanceState(bundle);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: c */
    public void mo6948c() {
        try {
            this.f5049b.onDestroyView();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: d */
    public void mo6949d() {
        try {
            this.f5049b.onDestroy();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: e */
    public void mo6950e() {
        try {
            this.f5049b.onLowMemory();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: f */
    public IMapFragmentDelegate mo8176f() {
        return this.f5049b;
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        try {
            this.f5049b.getMapAsync(new C1168ah(this, onMapReadyCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
