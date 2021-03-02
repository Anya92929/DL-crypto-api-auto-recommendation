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
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapFragment extends Fragment {

    /* renamed from: a */
    private final C1233s f5002a = new C1233s(this);

    /* renamed from: b */
    private GoogleMap f5003b;

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(GoogleMapOptions googleMapOptions) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", googleMapOptions);
        mapFragment.setArguments(bundle);
        return mapFragment;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public IMapFragmentDelegate mo8039a() {
        this.f5002a.mo8988g();
        if (this.f5002a.mo6952a() == null) {
            return null;
        }
        return ((C1231p) this.f5002a.mo6952a()).mo8986f();
    }

    @Deprecated
    public final GoogleMap getMap() {
        IMapFragmentDelegate a = mo8039a();
        if (a == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = a.getMap();
            if (map == null) {
                return null;
            }
            if (this.f5003b == null || this.f5003b.mo7935a().asBinder() != map.asBinder()) {
                this.f5003b = new GoogleMap(map);
            }
            return this.f5003b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        C1009bf.m4535b("getMapAsync must be called on the main thread.");
        this.f5002a.mo8987a(onMapReadyCallback);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f5002a.m5142a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5002a.mo6954a(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a = this.f5002a.mo6951a(layoutInflater, viewGroup, bundle);
        a.setClickable(true);
        return a;
    }

    public void onDestroy() {
        this.f5002a.mo6961e();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f5002a.mo6960d();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.f5002a.m5142a(activity);
        GoogleMapOptions createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attributeSet);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("MapOptions", createFromAttributes);
        this.f5002a.mo6953a(activity, bundle2, bundle);
    }

    public void onLowMemory() {
        this.f5002a.mo6962f();
        super.onLowMemory();
    }

    public void onPause() {
        this.f5002a.mo6959c();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f5002a.mo6957b();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f5002a.mo6958b(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
