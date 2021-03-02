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
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class SupportMapFragment extends Fragment {

    /* renamed from: a */
    private final C1169ai f5023a = new C1169ai(this);

    /* renamed from: b */
    private GoogleMap f5024b;

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(GoogleMapOptions googleMapOptions) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", googleMapOptions);
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }

    @Deprecated
    public final GoogleMap getMap() {
        IMapFragmentDelegate l = mo8143l();
        if (l == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = l.getMap();
            if (map == null) {
                return null;
            }
            if (this.f5024b == null || this.f5024b.mo7935a().asBinder() != map.asBinder()) {
                this.f5024b = new GoogleMap(map);
            }
            return this.f5024b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        C1009bf.m4535b("getMapAsync must be called on the main thread.");
        this.f5023a.mo8179a(onMapReadyCallback);
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public IMapFragmentDelegate mo8143l() {
        this.f5023a.mo8180g();
        if (this.f5023a.mo6952a() == null) {
            return null;
        }
        return ((C1167ag) this.f5023a.mo6952a()).mo8176f();
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f5023a.m5058a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5023a.mo6954a(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a = this.f5023a.mo6951a(layoutInflater, viewGroup, bundle);
        a.setClickable(true);
        return a;
    }

    public void onDestroy() {
        this.f5023a.mo6961e();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f5023a.mo6960d();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.f5023a.m5058a(activity);
        GoogleMapOptions createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attributeSet);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("MapOptions", createFromAttributes);
        this.f5023a.mo6953a(activity, bundle2, bundle);
    }

    public void onLowMemory() {
        this.f5023a.mo6962f();
        super.onLowMemory();
    }

    public void onPause() {
        this.f5023a.mo6959c();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f5023a.mo6957b();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f5023a.mo6958b(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
