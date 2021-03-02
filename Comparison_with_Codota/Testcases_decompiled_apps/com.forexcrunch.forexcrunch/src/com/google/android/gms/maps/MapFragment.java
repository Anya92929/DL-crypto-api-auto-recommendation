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
import com.google.android.gms.dynamic.C0360a;
import com.google.android.gms.dynamic.C0371c;
import com.google.android.gms.dynamic.C0372d;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.C0621s;
import com.google.android.gms.maps.internal.C0706o;
import com.google.android.gms.maps.internal.C0707p;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapFragment extends Fragment {

    /* renamed from: gy */
    private final C0646b f1513gy = new C0646b(this);

    /* renamed from: gz */
    private GoogleMap f1514gz;

    /* renamed from: com.google.android.gms.maps.MapFragment$a */
    static class C0645a implements LifecycleDelegate {

        /* renamed from: gA */
        private final Fragment f1515gA;

        /* renamed from: gB */
        private final IMapFragmentDelegate f1516gB;

        public C0645a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.f1516gB = (IMapFragmentDelegate) C0621s.m1890d(iMapFragmentDelegate);
            this.f1515gA = (Fragment) C0621s.m1890d(fragment);
        }

        /* renamed from: bh */
        public IMapFragmentDelegate mo5708bh() {
            return this.f1516gB;
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.f1515gA.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                C0706o.m2017a(savedInstanceState, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.f1516gB.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C0371c.m701a(this.f1516gB.onCreateView(C0371c.m702f(inflater), C0371c.m702f(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.f1516gB.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.f1516gB.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.f1516gB.onInflate(C0371c.m702f(activity), (GoogleMapOptions) attrs.getParcelable("MapOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.f1516gB.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f1516gB.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f1516gB.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.f1516gB.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.MapFragment$b */
    static class C0646b extends C0360a<C0645a> {

        /* renamed from: bm */
        private Activity f1517bm;

        /* renamed from: gA */
        private final Fragment f1518gA;

        /* renamed from: gC */
        protected C0372d<C0645a> f1519gC;

        C0646b(Fragment fragment) {
            this.f1518gA = fragment;
        }

        /* access modifiers changed from: private */
        public void setActivity(Activity activity) {
            this.f1517bm = activity;
            mo5709bi();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4114a(C0372d<C0645a> dVar) {
            this.f1519gC = dVar;
            mo5709bi();
        }

        /* renamed from: bi */
        public void mo5709bi() {
            if (this.f1517bm != null && this.f1519gC != null && mo4115at() == null) {
                try {
                    MapsInitializer.initialize(this.f1517bm);
                    this.f1519gC.mo4125a(new C0645a(this.f1518gA, C0707p.m2021i(this.f1517bm).mo5851d(C0371c.m702f(this.f1517bm))));
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
    /* renamed from: bh */
    public IMapFragmentDelegate mo5694bh() {
        this.f1513gy.mo5709bi();
        if (this.f1513gy.mo4115at() == null) {
            return null;
        }
        return ((C0645a) this.f1513gy.mo4115at()).mo5708bh();
    }

    public final GoogleMap getMap() {
        IMapFragmentDelegate bh = mo5694bh();
        if (bh == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = bh.getMap();
            if (map == null) {
                return null;
            }
            if (this.f1514gz == null || this.f1514gz.mo5586aY().asBinder() != map.asBinder()) {
                this.f1514gz = new GoogleMap(map);
            }
            return this.f1514gz;
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
        this.f1513gy.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f1513gy.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.f1513gy.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.f1513gy.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f1513gy.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.f1513gy.setActivity(activity);
        GoogleMapOptions createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.f1513gy.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.f1513gy.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.f1513gy.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f1513gy.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.f1513gy.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
