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
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.dynamic.C0581a;
import com.google.android.gms.dynamic.C0597e;
import com.google.android.gms.dynamic.C0598f;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.maps.internal.C1867t;
import com.google.android.gms.maps.internal.C1868u;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapFragment extends Fragment {
    private final C1775b aiF = new C1775b(this);
    private GoogleMap aiG;

    /* renamed from: com.google.android.gms.maps.MapFragment$a */
    static class C1774a implements LifecycleDelegate {

        /* renamed from: Sb */
        private final Fragment f4425Sb;
        private final IMapFragmentDelegate aiH;

        public C1774a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.aiH = (IMapFragmentDelegate) C0348n.m861i(iMapFragmentDelegate);
            this.f4425Sb = (Fragment) C0348n.m861i(fragment);
        }

        /* renamed from: mx */
        public IMapFragmentDelegate mo10384mx() {
            return this.aiH;
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.f4425Sb.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                C1867t.m6387a(savedInstanceState, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.aiH.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C0597e.m1742f(this.aiH.onCreateView(C0597e.m1743k(inflater), C0597e.m1743k(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.aiH.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.aiH.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.aiH.onInflate(C0597e.m1743k(activity), (GoogleMapOptions) attrs.getParcelable("MapOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.aiH.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.aiH.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.aiH.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.aiH.onSaveInstanceState(outState);
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
    static class C1775b extends C0581a<C1774a> {

        /* renamed from: Sb */
        private final Fragment f4426Sb;
        protected C0598f<C1774a> aiI;

        /* renamed from: nr */
        private Activity f4427nr;

        C1775b(Fragment fragment) {
            this.f4426Sb = fragment;
        }

        /* access modifiers changed from: private */
        public void setActivity(Activity activity) {
            this.f4427nr = activity;
            mo10385my();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5498a(C0598f<C1774a> fVar) {
            this.aiI = fVar;
            mo10385my();
        }

        /* renamed from: my */
        public void mo10385my() {
            if (this.f4427nr != null && this.aiI != null && mo5499it() == null) {
                try {
                    MapsInitializer.initialize(this.f4427nr);
                    this.aiI.mo5511a(new C1774a(this.f4426Sb, C1868u.m6388R(this.f4427nr).mo10667j(C0597e.m1743k(this.f4427nr))));
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

    public final GoogleMap getMap() {
        IMapFragmentDelegate mx = mo10371mx();
        if (mx == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = mx.getMap();
            if (map == null) {
                return null;
            }
            if (this.aiG == null || this.aiG.mo10274mo().asBinder() != map.asBinder()) {
                this.aiG = new GoogleMap(map);
            }
            return this.aiG;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: mx */
    public IMapFragmentDelegate mo10371mx() {
        this.aiF.mo10385my();
        if (this.aiF.mo5499it() == null) {
            return null;
        }
        return ((C1774a) this.aiF.mo5499it()).mo10384mx();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aiF.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.aiF.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.aiF.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.aiF.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.aiF.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.aiF.setActivity(activity);
        GoogleMapOptions createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.aiF.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.aiF.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.aiF.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.aiF.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.aiF.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
