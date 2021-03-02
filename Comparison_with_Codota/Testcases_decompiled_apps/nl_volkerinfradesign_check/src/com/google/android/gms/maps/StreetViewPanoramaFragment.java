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
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzaa;
import com.google.android.gms.maps.internal.zzac;
import com.google.android.gms.maps.internal.zzad;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
public class StreetViewPanoramaFragment extends Fragment {

    /* renamed from: a */
    private final C0830b f3378a = new C0830b(this);

    /* renamed from: b */
    private StreetViewPanorama f3379b;

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaFragment$a */
    static class C0828a implements StreetViewLifecycleDelegate {

        /* renamed from: a */
        private final Fragment f3380a;

        /* renamed from: b */
        private final IStreetViewPanoramaFragmentDelegate f3381b;

        public C0828a(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.f3381b = (IStreetViewPanoramaFragmentDelegate) zzx.zzz(iStreetViewPanoramaFragmentDelegate);
            this.f3380a = (Fragment) zzx.zzz(fragment);
        }

        /* renamed from: a */
        public IStreetViewPanoramaFragmentDelegate mo6329a() {
            return this.f3381b;
        }

        public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            try {
                this.f3381b.getStreetViewPanoramaAsync(new zzaa.zza() {
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
            Bundle arguments = this.f3380a.getArguments();
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                zzac.zza(bundle, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.f3381b.onCreate(bundle);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) zze.zzp(this.f3381b.onCreateView(zze.zzC(layoutInflater), zze.zzC(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.f3381b.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.f3381b.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.f3381b.onInflate(zze.zzC(activity), (StreetViewPanoramaOptions) null, bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.f3381b.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f3381b.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f3381b.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.f3381b.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaFragment$b */
    static class C0830b extends zza<C0828a> {

        /* renamed from: a */
        protected zzf<C0828a> f3384a;

        /* renamed from: b */
        private final Fragment f3385b;

        /* renamed from: c */
        private Activity f3386c;

        /* renamed from: d */
        private final List<OnStreetViewPanoramaReadyCallback> f3387d = new ArrayList();

        C0830b(Fragment fragment) {
            this.f3385b = fragment;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m4148a(Activity activity) {
            this.f3386c = activity;
            mo6332a();
        }

        /* renamed from: a */
        public void mo6332a() {
            if (this.f3386c != null && this.f3384a != null && zztU() == null) {
                try {
                    MapsInitializer.initialize(this.f3386c);
                    this.f3384a.zza(new C0828a(this.f3385b, zzad.zzaO(this.f3386c).zzt(zze.zzC(this.f3386c))));
                    for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.f3387d) {
                        ((C0828a) zztU()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                    }
                    this.f3387d.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }

        /* renamed from: a */
        public void mo6333a(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            if (zztU() != null) {
                ((C0828a) zztU()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
            } else {
                this.f3387d.add(onStreetViewPanoramaReadyCallback);
            }
        }

        /* access modifiers changed from: protected */
        public void zza(zzf<C0828a> zzf) {
            this.f3384a = zzf;
            mo6332a();
        }
    }

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
            if (this.f3379b == null || this.f3379b.mo6285a().asBinder() != streetViewPanorama.asBinder()) {
                this.f3379b = new StreetViewPanorama(streetViewPanorama);
            }
            return this.f3379b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        zzx.zzcD("getStreetViewPanoramaAsync() must be called on the main thread");
        this.f3378a.mo6333a(onStreetViewPanoramaReadyCallback);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3378a.m4148a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3378a.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f3378a.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        this.f3378a.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f3378a.onDestroyView();
        super.onDestroyView();
    }

    @SuppressLint({"NewApi"})
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.f3378a.m4148a(activity);
        this.f3378a.onInflate(activity, new Bundle(), bundle);
    }

    public void onLowMemory() {
        this.f3378a.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.f3378a.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f3378a.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f3378a.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }

    /* access modifiers changed from: protected */
    public IStreetViewPanoramaFragmentDelegate zzzZ() {
        this.f3378a.mo6332a();
        if (this.f3378a.zztU() == null) {
            return null;
        }
        return ((C0828a) this.f3378a.zztU()).mo6329a();
    }
}
