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
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzaa;
import com.google.android.gms.maps.internal.zzac;
import com.google.android.gms.maps.internal.zzad;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class SupportStreetViewPanoramaFragment extends Fragment {

    /* renamed from: a */
    private final C0839b f3420a = new C0839b(this);

    /* renamed from: b */
    private StreetViewPanorama f3421b;

    /* renamed from: com.google.android.gms.maps.SupportStreetViewPanoramaFragment$a */
    static class C0837a implements StreetViewLifecycleDelegate {

        /* renamed from: a */
        private final Fragment f3422a;

        /* renamed from: b */
        private final IStreetViewPanoramaFragmentDelegate f3423b;

        public C0837a(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.f3423b = (IStreetViewPanoramaFragmentDelegate) zzx.zzz(iStreetViewPanoramaFragmentDelegate);
            this.f3422a = (Fragment) zzx.zzz(fragment);
        }

        /* renamed from: a */
        public IStreetViewPanoramaFragmentDelegate mo6386a() {
            return this.f3423b;
        }

        public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            try {
                this.f3423b.getStreetViewPanoramaAsync(new zzaa.zza() {
                    public void zza(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
                        onStreetViewPanoramaReadyCallback.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
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
            Bundle arguments = this.f3422a.getArguments();
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                zzac.zza(bundle, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.f3423b.onCreate(bundle);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) zze.zzp(this.f3423b.onCreateView(zze.zzC(layoutInflater), zze.zzC(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.f3423b.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.f3423b.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.f3423b.onInflate(zze.zzC(activity), (StreetViewPanoramaOptions) null, bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.f3423b.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f3423b.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f3423b.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.f3423b.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.SupportStreetViewPanoramaFragment$b */
    static class C0839b extends zza<C0837a> {

        /* renamed from: a */
        protected zzf<C0837a> f3426a;

        /* renamed from: b */
        private final Fragment f3427b;

        /* renamed from: c */
        private Activity f3428c;

        /* renamed from: d */
        private final List<OnStreetViewPanoramaReadyCallback> f3429d = new ArrayList();

        C0839b(Fragment fragment) {
            this.f3427b = fragment;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m4171a(Activity activity) {
            this.f3428c = activity;
            mo6387a();
        }

        /* renamed from: a */
        public void mo6387a() {
            if (this.f3428c != null && this.f3426a != null && zztU() == null) {
                try {
                    MapsInitializer.initialize(this.f3428c);
                    this.f3426a.zza(new C0837a(this.f3427b, zzad.zzaO(this.f3428c).zzt(zze.zzC(this.f3428c))));
                    for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.f3429d) {
                        ((C0837a) zztU()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                    }
                    this.f3429d.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }

        /* renamed from: a */
        public void mo6388a(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            if (zztU() != null) {
                ((C0837a) zztU()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
            } else {
                this.f3429d.add(onStreetViewPanoramaReadyCallback);
            }
        }

        /* access modifiers changed from: protected */
        public void zza(zzf<C0837a> zzf) {
            this.f3426a = zzf;
            mo6387a();
        }
    }

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
        IStreetViewPanoramaFragmentDelegate zzzZ = zzzZ();
        if (zzzZ == null) {
            return null;
        }
        try {
            IStreetViewPanoramaDelegate streetViewPanorama = zzzZ.getStreetViewPanorama();
            if (streetViewPanorama == null) {
                return null;
            }
            if (this.f3421b == null || this.f3421b.mo6285a().asBinder() != streetViewPanorama.asBinder()) {
                this.f3421b = new StreetViewPanorama(streetViewPanorama);
            }
            return this.f3421b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        zzx.zzcD("getStreetViewPanoramaAsync() must be called on the main thread");
        this.f3420a.mo6388a(onStreetViewPanoramaReadyCallback);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3420a.m4171a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3420a.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f3420a.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        this.f3420a.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f3420a.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.f3420a.m4171a(activity);
        this.f3420a.onInflate(activity, new Bundle(), bundle);
    }

    public void onLowMemory() {
        this.f3420a.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.f3420a.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f3420a.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f3420a.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }

    /* access modifiers changed from: protected */
    public IStreetViewPanoramaFragmentDelegate zzzZ() {
        this.f3420a.mo6387a();
        if (this.f3420a.zztU() == null) {
            return null;
        }
        return ((C0837a) this.f3420a.zztU()).mo6386a();
    }
}
