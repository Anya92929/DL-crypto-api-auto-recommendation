package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.p000v4.app.Fragment;
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

public class SupportMapFragment extends Fragment {

    /* renamed from: pI */
    private GoogleMap f1668pI;

    /* renamed from: pT */
    private final C0647b f1669pT = new C0647b(this);

    /* renamed from: com.google.android.gms.maps.SupportMapFragment$a */
    static class C0646a implements LifecycleDelegate {

        /* renamed from: pK */
        private final IMapFragmentDelegate f1670pK;

        /* renamed from: pU */
        private final Fragment f1671pU;

        public C0646a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.f1670pK = (IMapFragmentDelegate) C0411dm.m944e(iMapFragmentDelegate);
            this.f1671pU = (Fragment) C0411dm.m944e(fragment);
        }

        /* renamed from: cD */
        public IMapFragmentDelegate mo5551cD() {
            return this.f1670pK;
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.f1671pU.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                C0706p.m2066a(savedInstanceState, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.f1670pK.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C0167c.m378b(this.f1670pK.onCreateView(C0167c.m379g(inflater), C0167c.m379g(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.f1670pK.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.f1670pK.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.f1670pK.onInflate(C0167c.m379g(activity), (GoogleMapOptions) attrs.getParcelable("MapOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.f1670pK.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f1670pK.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f1670pK.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.f1670pK.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.SupportMapFragment$b */
    static class C0647b extends C0156a<C0646a> {

        /* renamed from: fD */
        private Activity f1672fD;

        /* renamed from: pL */
        protected C0168d<C0646a> f1673pL;

        /* renamed from: pU */
        private final Fragment f1674pU;

        C0647b(Fragment fragment) {
            this.f1674pU = fragment;
        }

        /* access modifiers changed from: private */
        public void setActivity(Activity activity) {
            this.f1672fD = activity;
            mo5552cE();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3664a(C0168d<C0646a> dVar) {
            this.f1673pL = dVar;
            mo5552cE();
        }

        /* renamed from: cE */
        public void mo5552cE() {
            if (this.f1672fD != null && this.f1673pL != null && mo3665bP() == null) {
                try {
                    MapsInitializer.initialize(this.f1672fD);
                    this.f1673pL.mo3675a(new C0646a(this.f1674pU, C0707q.m2071u(this.f1672fD).mo5681f(C0167c.m379g(this.f1672fD))));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(GoogleMapOptions options) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", options);
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }

    /* access modifiers changed from: protected */
    /* renamed from: cD */
    public IMapFragmentDelegate mo5549cD() {
        this.f1669pT.mo5552cE();
        if (this.f1669pT.mo3665bP() == null) {
            return null;
        }
        return ((C0646a) this.f1669pT.mo3665bP()).mo5551cD();
    }

    public final GoogleMap getMap() {
        IMapFragmentDelegate cD = mo5549cD();
        if (cD == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = cD.getMap();
            if (map == null) {
                return null;
            }
            if (this.f1668pI == null || this.f1668pI.mo5417cu().asBinder() != map.asBinder()) {
                this.f1668pI = new GoogleMap(map);
            }
            return this.f1668pI;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f1669pT.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f1669pT.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.f1669pT.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.f1669pT.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f1669pT.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.f1669pT.setActivity(activity);
        GoogleMapOptions createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.f1669pT.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.f1669pT.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.f1669pT.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f1669pT.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.f1669pT.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
