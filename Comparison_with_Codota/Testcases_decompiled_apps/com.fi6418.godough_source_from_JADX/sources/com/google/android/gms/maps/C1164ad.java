package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.p017b.C0608m;

/* renamed from: com.google.android.gms.maps.ad */
class C1164ad implements StreetViewLifecycleDelegate {

    /* renamed from: a */
    private final ViewGroup f5038a;

    /* renamed from: b */
    private final IStreetViewPanoramaViewDelegate f5039b;

    /* renamed from: c */
    private View f5040c;

    public C1164ad(ViewGroup viewGroup, IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate) {
        this.f5039b = (IStreetViewPanoramaViewDelegate) C1009bf.m4528a(iStreetViewPanoramaViewDelegate);
        this.f5038a = (ViewGroup) C1009bf.m4528a(viewGroup);
    }

    /* renamed from: a */
    public View mo6942a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
    }

    /* renamed from: a */
    public void mo6943a() {
        try {
            this.f5039b.onResume();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: a */
    public void mo6944a(Activity activity, Bundle bundle, Bundle bundle2) {
        throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
    }

    /* renamed from: a */
    public void mo6945a(Bundle bundle) {
        try {
            this.f5039b.onCreate(bundle);
            this.f5040c = (View) C0608m.m3537a(this.f5039b.getView());
            this.f5038a.removeAllViews();
            this.f5038a.addView(this.f5040c);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: b */
    public void mo6946b() {
        try {
            this.f5039b.onPause();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: b */
    public void mo6947b(Bundle bundle) {
        try {
            this.f5039b.onSaveInstanceState(bundle);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: c */
    public void mo6948c() {
        throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
    }

    /* renamed from: d */
    public void mo6949d() {
        try {
            this.f5039b.onDestroy();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: e */
    public void mo6950e() {
        try {
            this.f5039b.onLowMemory();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: f */
    public IStreetViewPanoramaViewDelegate mo8173f() {
        return this.f5039b;
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        try {
            this.f5039b.getStreetViewPanoramaAsync(new C1165ae(this, onStreetViewPanoramaReadyCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
