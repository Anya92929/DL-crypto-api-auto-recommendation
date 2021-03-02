package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzx;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.p017b.C0608m;

/* renamed from: com.google.android.gms.maps.aa */
class C1161aa implements StreetViewLifecycleDelegate {

    /* renamed from: a */
    private final Fragment f5030a;

    /* renamed from: b */
    private final IStreetViewPanoramaFragmentDelegate f5031b;

    public C1161aa(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
        this.f5031b = (IStreetViewPanoramaFragmentDelegate) C1009bf.m4528a(iStreetViewPanoramaFragmentDelegate);
        this.f5030a = (Fragment) C1009bf.m4528a(fragment);
    }

    /* renamed from: a */
    public View mo6942a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            return (View) C0608m.m3537a(this.f5031b.onCreateView(C0608m.m3536a(layoutInflater), C0608m.m3536a(viewGroup), bundle));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: a */
    public void mo6943a() {
        try {
            this.f5031b.onResume();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: a */
    public void mo6944a(Activity activity, Bundle bundle, Bundle bundle2) {
        try {
            this.f5031b.onInflate(C0608m.m3536a(activity), (StreetViewPanoramaOptions) null, bundle2);
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
        Bundle arguments = this.f5030a.getArguments();
        if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
            zzx.zza(bundle, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
        }
        this.f5031b.onCreate(bundle);
    }

    /* renamed from: b */
    public void mo6946b() {
        try {
            this.f5031b.onPause();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: b */
    public void mo6947b(Bundle bundle) {
        try {
            this.f5031b.onSaveInstanceState(bundle);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: c */
    public void mo6948c() {
        try {
            this.f5031b.onDestroyView();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: d */
    public void mo6949d() {
        try {
            this.f5031b.onDestroy();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: e */
    public void mo6950e() {
        try {
            this.f5031b.onLowMemory();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: f */
    public IStreetViewPanoramaFragmentDelegate mo8168f() {
        return this.f5031b;
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        try {
            this.f5031b.getStreetViewPanoramaAsync(new C1162ab(this, onStreetViewPanoramaReadyCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
