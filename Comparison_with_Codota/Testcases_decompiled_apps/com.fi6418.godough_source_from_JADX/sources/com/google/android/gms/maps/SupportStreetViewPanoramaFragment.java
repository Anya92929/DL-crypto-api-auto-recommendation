package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.p000v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class SupportStreetViewPanoramaFragment extends Fragment {

    /* renamed from: a */
    private final C1172al f5025a = new C1172al(this);

    /* renamed from: b */
    private StreetViewPanorama f5026b;

    public static SupportStreetViewPanoramaFragment newInstance() {
        return new SupportStreetViewPanoramaFragment();
    }

    public static SupportStreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions streetViewPanoramaOptions) {
        SupportStreetViewPanoramaFragment supportStreetViewPanoramaFragment = new SupportStreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", streetViewPanoramaOptions);
        supportStreetViewPanoramaFragment.setArguments(bundle);
        return supportStreetViewPanoramaFragment;
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        IStreetViewPanoramaFragmentDelegate l = mo8146l();
        if (l == null) {
            return null;
        }
        try {
            IStreetViewPanoramaDelegate streetViewPanorama = l.getStreetViewPanorama();
            if (streetViewPanorama == null) {
                return null;
            }
            if (this.f5026b == null || this.f5026b.mo8067a().asBinder() != streetViewPanorama.asBinder()) {
                this.f5026b = new StreetViewPanorama(streetViewPanorama);
            }
            return this.f5026b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        C1009bf.m4535b("getStreetViewPanoramaAsync() must be called on the main thread");
        this.f5025a.mo8182a(onStreetViewPanoramaReadyCallback);
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public IStreetViewPanoramaFragmentDelegate mo8146l() {
        this.f5025a.mo8183g();
        if (this.f5025a.mo6952a() == null) {
            return null;
        }
        return ((C1170aj) this.f5025a.mo6952a()).mo8181f();
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f5025a.m5073a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5025a.mo6954a(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f5025a.mo6951a(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        this.f5025a.mo6961e();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f5025a.mo6960d();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.f5025a.m5073a(activity);
        this.f5025a.mo6953a(activity, new Bundle(), bundle);
    }

    public void onLowMemory() {
        this.f5025a.mo6962f();
        super.onLowMemory();
    }

    public void onPause() {
        this.f5025a.mo6959c();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f5025a.mo6957b();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f5025a.mo6958b(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
