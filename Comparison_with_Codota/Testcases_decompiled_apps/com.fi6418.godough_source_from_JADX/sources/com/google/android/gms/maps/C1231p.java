package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzx;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.p017b.C0608m;

/* renamed from: com.google.android.gms.maps.p */
class C1231p implements MapLifecycleDelegate {

    /* renamed from: a */
    private final Fragment f5226a;

    /* renamed from: b */
    private final IMapFragmentDelegate f5227b;

    public C1231p(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
        this.f5227b = (IMapFragmentDelegate) C1009bf.m4528a(iMapFragmentDelegate);
        this.f5226a = (Fragment) C1009bf.m4528a(fragment);
    }

    /* renamed from: a */
    public View mo6942a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            return (View) C0608m.m3537a(this.f5227b.onCreateView(C0608m.m3536a(layoutInflater), C0608m.m3536a(viewGroup), bundle));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: a */
    public void mo6943a() {
        try {
            this.f5227b.onResume();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: a */
    public void mo6944a(Activity activity, Bundle bundle, Bundle bundle2) {
        try {
            this.f5227b.onInflate(C0608m.m3536a(activity), (GoogleMapOptions) bundle.getParcelable("MapOptions"), bundle2);
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
        Bundle arguments = this.f5226a.getArguments();
        if (arguments != null && arguments.containsKey("MapOptions")) {
            zzx.zza(bundle, "MapOptions", arguments.getParcelable("MapOptions"));
        }
        this.f5227b.onCreate(bundle);
    }

    /* renamed from: b */
    public void mo6946b() {
        try {
            this.f5227b.onPause();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: b */
    public void mo6947b(Bundle bundle) {
        try {
            this.f5227b.onSaveInstanceState(bundle);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: c */
    public void mo6948c() {
        try {
            this.f5227b.onDestroyView();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: d */
    public void mo6949d() {
        try {
            this.f5227b.onDestroy();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: e */
    public void mo6950e() {
        try {
            this.f5227b.onLowMemory();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: f */
    public IMapFragmentDelegate mo8986f() {
        return this.f5227b;
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        try {
            this.f5227b.getMapAsync(new C1232q(this, onMapReadyCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
