package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.p017b.C0608m;

/* renamed from: com.google.android.gms.maps.t */
class C1234t implements MapLifecycleDelegate {

    /* renamed from: a */
    private final ViewGroup f5234a;

    /* renamed from: b */
    private final IMapViewDelegate f5235b;

    /* renamed from: c */
    private View f5236c;

    public C1234t(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
        this.f5235b = (IMapViewDelegate) C1009bf.m4528a(iMapViewDelegate);
        this.f5234a = (ViewGroup) C1009bf.m4528a(viewGroup);
    }

    /* renamed from: a */
    public View mo6942a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
    }

    /* renamed from: a */
    public void mo6943a() {
        try {
            this.f5235b.onResume();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: a */
    public void mo6944a(Activity activity, Bundle bundle, Bundle bundle2) {
        throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
    }

    /* renamed from: a */
    public void mo6945a(Bundle bundle) {
        try {
            this.f5235b.onCreate(bundle);
            this.f5236c = (View) C0608m.m3537a(this.f5235b.getView());
            this.f5234a.removeAllViews();
            this.f5234a.addView(this.f5236c);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: b */
    public void mo6946b() {
        try {
            this.f5235b.onPause();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: b */
    public void mo6947b(Bundle bundle) {
        try {
            this.f5235b.onSaveInstanceState(bundle);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: c */
    public void mo6948c() {
        throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
    }

    /* renamed from: d */
    public void mo6949d() {
        try {
            this.f5235b.onDestroy();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: e */
    public void mo6950e() {
        try {
            this.f5235b.onLowMemory();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: f */
    public IMapViewDelegate mo8989f() {
        return this.f5235b;
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        try {
            this.f5235b.getMapAsync(new C1235u(this, onMapReadyCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
