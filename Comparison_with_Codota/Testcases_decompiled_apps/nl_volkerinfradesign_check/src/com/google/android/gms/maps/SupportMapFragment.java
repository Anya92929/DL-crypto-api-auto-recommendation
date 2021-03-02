package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.p001v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzac;
import com.google.android.gms.maps.internal.zzad;
import com.google.android.gms.maps.internal.zzo;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class SupportMapFragment extends Fragment {

    /* renamed from: a */
    private final C0836b f3410a = new C0836b(this);

    /* renamed from: b */
    private GoogleMap f3411b;

    /* renamed from: com.google.android.gms.maps.SupportMapFragment$a */
    static class C0834a implements MapLifecycleDelegate {

        /* renamed from: a */
        private final Fragment f3412a;

        /* renamed from: b */
        private final IMapFragmentDelegate f3413b;

        public C0834a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.f3413b = (IMapFragmentDelegate) zzx.zzz(iMapFragmentDelegate);
            this.f3412a = (Fragment) zzx.zzz(fragment);
        }

        /* renamed from: a */
        public IMapFragmentDelegate mo6376a() {
            return this.f3413b;
        }

        /* renamed from: a */
        public void mo6377a(Bundle bundle) {
            try {
                this.f3413b.onEnterAmbient(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        /* renamed from: b */
        public void mo6378b() {
            try {
                this.f3413b.onExitAmbient();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void getMapAsync(final OnMapReadyCallback onMapReadyCallback) {
            try {
                this.f3413b.getMapAsync(new zzo.zza() {
                    public void zza(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
                        onMapReadyCallback.onMapReady(new GoogleMap(iGoogleMapDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle bundle) {
            if (bundle == null) {
                try {
                    bundle = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.f3412a.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                zzac.zza(bundle, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.f3413b.onCreate(bundle);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) zze.zzp(this.f3413b.onCreateView(zze.zzC(layoutInflater), zze.zzC(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.f3413b.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.f3413b.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.f3413b.onInflate(zze.zzC(activity), (GoogleMapOptions) bundle.getParcelable("MapOptions"), bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.f3413b.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f3413b.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f3413b.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.f3413b.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.SupportMapFragment$b */
    static class C0836b extends zza<C0834a> {

        /* renamed from: a */
        protected zzf<C0834a> f3416a;

        /* renamed from: b */
        private final Fragment f3417b;

        /* renamed from: c */
        private Activity f3418c;

        /* renamed from: d */
        private final List<OnMapReadyCallback> f3419d = new ArrayList();

        C0836b(Fragment fragment) {
            this.f3417b = fragment;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m4164a(Activity activity) {
            this.f3418c = activity;
            mo6379a();
        }

        /* renamed from: a */
        public void mo6379a() {
            if (this.f3418c != null && this.f3416a != null && zztU() == null) {
                try {
                    MapsInitializer.initialize(this.f3418c);
                    IMapFragmentDelegate zzs = zzad.zzaO(this.f3418c).zzs(zze.zzC(this.f3418c));
                    if (zzs != null) {
                        this.f3416a.zza(new C0834a(this.f3417b, zzs));
                        for (OnMapReadyCallback mapAsync : this.f3419d) {
                            ((C0834a) zztU()).getMapAsync(mapAsync);
                        }
                        this.f3419d.clear();
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }

        /* renamed from: a */
        public void mo6380a(Bundle bundle) {
            if (zztU() != null) {
                ((C0834a) zztU()).mo6377a(bundle);
            }
        }

        /* renamed from: a */
        public void mo6381a(OnMapReadyCallback onMapReadyCallback) {
            if (zztU() != null) {
                ((C0834a) zztU()).getMapAsync(onMapReadyCallback);
            } else {
                this.f3419d.add(onMapReadyCallback);
            }
        }

        /* renamed from: b */
        public void mo6382b() {
            if (zztU() != null) {
                ((C0834a) zztU()).mo6378b();
            }
        }

        /* access modifiers changed from: protected */
        public void zza(zzf<C0834a> zzf) {
            this.f3416a = zzf;
            mo6379a();
        }
    }

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
        IMapFragmentDelegate zzzV = zzzV();
        if (zzzV == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = zzzV.getMap();
            if (map == null) {
                return null;
            }
            if (this.f3411b == null || this.f3411b.mo6094a().asBinder() != map.asBinder()) {
                this.f3411b = new GoogleMap(map);
            }
            return this.f3411b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        zzx.zzcD("getMapAsync must be called on the main thread.");
        this.f3410a.mo6381a(onMapReadyCallback);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3410a.m4164a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3410a.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = this.f3410a.onCreateView(layoutInflater, viewGroup, bundle);
        onCreateView.setClickable(true);
        return onCreateView;
    }

    public void onDestroy() {
        this.f3410a.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f3410a.onDestroyView();
        super.onDestroyView();
    }

    public final void onEnterAmbient(Bundle bundle) {
        zzx.zzcD("onEnterAmbient must be called on the main thread.");
        this.f3410a.mo6380a(bundle);
    }

    public final void onExitAmbient() {
        zzx.zzcD("onExitAmbient must be called on the main thread.");
        this.f3410a.mo6382b();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.f3410a.m4164a(activity);
        GoogleMapOptions createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attributeSet);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("MapOptions", createFromAttributes);
        this.f3410a.onInflate(activity, bundle2, bundle);
    }

    public void onLowMemory() {
        this.f3410a.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.f3410a.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f3410a.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f3410a.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }

    /* access modifiers changed from: protected */
    public IMapFragmentDelegate zzzV() {
        this.f3410a.mo6379a();
        if (this.f3410a.zztU() == null) {
            return null;
        }
        return ((C0834a) this.f3410a.zztU()).mo6376a();
    }
}
