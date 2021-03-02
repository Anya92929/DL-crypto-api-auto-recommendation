package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class StreetViewPanoramaFragment extends Fragment {

    /* renamed from: a */
    private final C1163ac f5009a = new C1163ac(this);

    /* renamed from: b */
    private StreetViewPanorama f5010b;

    public static StreetViewPanoramaFragment newInstance() {
        return new StreetViewPanoramaFragment();
    }

    public static StreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions streetViewPanoramaOptions) {
        StreetViewPanoramaFragment streetViewPanoramaFragment = new StreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", streetViewPanoramaOptions);
        streetViewPanoramaFragment.setArguments(bundle);
        return streetViewPanoramaFragment;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public IStreetViewPanoramaFragmentDelegate mo8092a() {
        this.f5009a.mo8172g();
        if (this.f5009a.mo6952a() == null) {
            return null;
        }
        return ((C1161aa) this.f5009a.mo6952a()).mo8168f();
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        IStreetViewPanoramaFragmentDelegate a = mo8092a();
        if (a == null) {
            return null;
        }
        try {
            IStreetViewPanoramaDelegate streetViewPanorama = a.getStreetViewPanorama();
            if (streetViewPanorama == null) {
                return null;
            }
            if (this.f5010b == null || this.f5010b.mo8067a().asBinder() != streetViewPanorama.asBinder()) {
                this.f5010b = new StreetViewPanorama(streetViewPanorama);
            }
            return this.f5010b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        C1009bf.m4535b("getStreetViewPanoramaAsync() must be called on the main thread");
        this.f5009a.mo8171a(onStreetViewPanoramaReadyCallback);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f5009a.m5030a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5009a.mo6954a(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f5009a.mo6951a(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        this.f5009a.mo6961e();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f5009a.mo6960d();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.f5009a.m5030a(activity);
        this.f5009a.mo6953a(activity, new Bundle(), bundle);
    }

    public void onLowMemory() {
        this.f5009a.mo6962f();
        super.onLowMemory();
    }

    public void onPause() {
        this.f5009a.mo6959c();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f5009a.mo6957b();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f5009a.mo6958b(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
