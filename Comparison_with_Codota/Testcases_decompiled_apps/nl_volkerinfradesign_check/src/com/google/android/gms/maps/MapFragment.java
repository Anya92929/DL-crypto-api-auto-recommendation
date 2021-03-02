package com.google.android.gms.maps;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
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

@TargetApi(11)
public class MapFragment extends Fragment {

    /* renamed from: a */
    private final C0817b f3345a = new C0817b(this);

    /* renamed from: b */
    private GoogleMap f3346b;

    /* renamed from: com.google.android.gms.maps.MapFragment$a */
    static class C0815a implements MapLifecycleDelegate {

        /* renamed from: a */
        private final Fragment f3347a;

        /* renamed from: b */
        private final IMapFragmentDelegate f3348b;

        public C0815a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.f3348b = (IMapFragmentDelegate) zzx.zzz(iMapFragmentDelegate);
            this.f3347a = (Fragment) zzx.zzz(fragment);
        }

        /* renamed from: a */
        public IMapFragmentDelegate mo6254a() {
            return this.f3348b;
        }

        /* renamed from: a */
        public void mo6255a(Bundle bundle) {
            try {
                this.f3348b.onEnterAmbient(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        /* renamed from: b */
        public void mo6256b() {
            try {
                this.f3348b.onExitAmbient();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void getMapAsync(final OnMapReadyCallback onMapReadyCallback) {
            try {
                this.f3348b.getMapAsync(new zzo.zza() {
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
            Bundle arguments = this.f3347a.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                zzac.zza(bundle, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.f3348b.onCreate(bundle);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) zze.zzp(this.f3348b.onCreateView(zze.zzC(layoutInflater), zze.zzC(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.f3348b.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.f3348b.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.f3348b.onInflate(zze.zzC(activity), (GoogleMapOptions) bundle.getParcelable("MapOptions"), bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.f3348b.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f3348b.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f3348b.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.f3348b.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.MapFragment$b */
    static class C0817b extends zza<C0815a> {

        /* renamed from: a */
        protected zzf<C0815a> f3351a;

        /* renamed from: b */
        private final Fragment f3352b;

        /* renamed from: c */
        private Activity f3353c;

        /* renamed from: d */
        private final List<OnMapReadyCallback> f3354d = new ArrayList();

        C0817b(Fragment fragment) {
            this.f3352b = fragment;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m4132a(Activity activity) {
            this.f3353c = activity;
            mo6259a();
        }

        /* renamed from: a */
        public void mo6259a() {
            if (this.f3353c != null && this.f3351a != null && zztU() == null) {
                try {
                    MapsInitializer.initialize(this.f3353c);
                    IMapFragmentDelegate zzs = zzad.zzaO(this.f3353c).zzs(zze.zzC(this.f3353c));
                    if (zzs != null) {
                        this.f3351a.zza(new C0815a(this.f3352b, zzs));
                        for (OnMapReadyCallback mapAsync : this.f3354d) {
                            ((C0815a) zztU()).getMapAsync(mapAsync);
                        }
                        this.f3354d.clear();
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }

        /* renamed from: a */
        public void mo6260a(Bundle bundle) {
            if (zztU() != null) {
                ((C0815a) zztU()).mo6255a(bundle);
            }
        }

        /* renamed from: a */
        public void mo6261a(OnMapReadyCallback onMapReadyCallback) {
            if (zztU() != null) {
                ((C0815a) zztU()).getMapAsync(onMapReadyCallback);
            } else {
                this.f3354d.add(onMapReadyCallback);
            }
        }

        /* renamed from: b */
        public void mo6262b() {
            if (zztU() != null) {
                ((C0815a) zztU()).mo6256b();
            }
        }

        /* access modifiers changed from: protected */
        public void zza(zzf<C0815a> zzf) {
            this.f3351a = zzf;
            mo6259a();
        }
    }

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
            if (this.f3346b == null || this.f3346b.mo6094a().asBinder() != map.asBinder()) {
                this.f3346b = new GoogleMap(map);
            }
            return this.f3346b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        zzx.zzcD("getMapAsync must be called on the main thread.");
        this.f3345a.mo6261a(onMapReadyCallback);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3345a.m4132a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3345a.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = this.f3345a.onCreateView(layoutInflater, viewGroup, bundle);
        onCreateView.setClickable(true);
        return onCreateView;
    }

    public void onDestroy() {
        this.f3345a.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f3345a.onDestroyView();
        super.onDestroyView();
    }

    public final void onEnterAmbient(Bundle bundle) {
        zzx.zzcD("onEnterAmbient must be called on the main thread.");
        this.f3345a.mo6260a(bundle);
    }

    public final void onExitAmbient() {
        zzx.zzcD("onExitAmbient must be called on the main thread.");
        this.f3345a.mo6262b();
    }

    @SuppressLint({"NewApi"})
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.f3345a.m4132a(activity);
        GoogleMapOptions createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attributeSet);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("MapOptions", createFromAttributes);
        this.f3345a.onInflate(activity, bundle2, bundle);
    }

    public void onLowMemory() {
        this.f3345a.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.f3345a.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f3345a.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f3345a.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }

    /* access modifiers changed from: protected */
    public IMapFragmentDelegate zzzV() {
        this.f3345a.mo6259a();
        if (this.f3345a.zztU() == null) {
            return null;
        }
        return ((C0815a) this.f3345a.zztU()).mo6254a();
    }
}
