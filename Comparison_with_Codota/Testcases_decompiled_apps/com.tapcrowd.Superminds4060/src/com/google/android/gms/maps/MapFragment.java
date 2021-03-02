package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.C0156a;
import com.google.android.gms.dynamic.C0167c;
import com.google.android.gms.dynamic.C0168d;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.C0411dm;
import com.google.android.gms.maps.internal.C0706p;
import com.google.android.gms.maps.internal.C0707q;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapFragment extends Fragment {

    /* renamed from: pH */
    private final C0643b f1652pH = new C0643b(this);

    /* renamed from: pI */
    private GoogleMap f1653pI;

    /* renamed from: com.google.android.gms.maps.MapFragment$a */
    static class C0642a implements LifecycleDelegate {

        /* renamed from: pJ */
        private final Fragment f1654pJ;

        /* renamed from: pK */
        private final IMapFragmentDelegate f1655pK;

        public C0642a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.f1655pK = (IMapFragmentDelegate) C0411dm.m944e(iMapFragmentDelegate);
            this.f1654pJ = (Fragment) C0411dm.m944e(fragment);
        }

        /* renamed from: cD */
        public IMapFragmentDelegate mo5535cD() {
            return this.f1655pK;
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.f1654pJ.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                C0706p.m2066a(savedInstanceState, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.f1655pK.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C0167c.m378b(this.f1655pK.onCreateView(C0167c.m379g(inflater), C0167c.m379g(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.f1655pK.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.f1655pK.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.f1655pK.onInflate(C0167c.m379g(activity), (GoogleMapOptions) attrs.getParcelable("MapOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.f1655pK.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f1655pK.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f1655pK.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.f1655pK.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.MapFragment$b */
    static class C0643b extends C0156a<C0642a> {

        /* renamed from: fD */
        private Activity f1656fD;

        /* renamed from: pJ */
        private final Fragment f1657pJ;

        /* renamed from: pL */
        protected C0168d<C0642a> f1658pL;

        C0643b(Fragment fragment) {
            this.f1657pJ = fragment;
        }

        /* access modifiers changed from: private */
        public void setActivity(Activity activity) {
            this.f1656fD = activity;
            mo5536cE();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3664a(C0168d<C0642a> dVar) {
            this.f1658pL = dVar;
            mo5536cE();
        }

        /* renamed from: cE */
        public void mo5536cE() {
            if (this.f1656fD != null && this.f1658pL != null && mo3665bP() == null) {
                try {
                    MapsInitializer.initialize(this.f1656fD);
                    this.f1658pL.mo3675a(new C0642a(this.f1657pJ, C0707q.m2071u(this.f1656fD).mo5681f(C0167c.m379g(this.f1656fD))));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(GoogleMapOptions options) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", options);
        mapFragment.setArguments(bundle);
        return mapFragment;
    }

    /* access modifiers changed from: protected */
    /* renamed from: cD */
    public IMapFragmentDelegate mo5521cD() {
        this.f1652pH.mo5536cE();
        if (this.f1652pH.mo3665bP() == null) {
            return null;
        }
        return ((C0642a) this.f1652pH.mo3665bP()).mo5535cD();
    }

    public final GoogleMap getMap() {
        IMapFragmentDelegate cD = mo5521cD();
        if (cD == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = cD.getMap();
            if (map == null) {
                return null;
            }
            if (this.f1653pI == null || this.f1653pI.mo5417cu().asBinder() != map.asBinder()) {
                this.f1653pI = new GoogleMap(map);
            }
            return this.f1653pI;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f1652pH.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f1652pH.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.f1652pH.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.f1652pH.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f1652pH.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.f1652pH.setActivity(activity);
        GoogleMapOptions createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.f1652pH.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.f1652pH.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.f1652pH.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f1652pH.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.f1652pH.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
