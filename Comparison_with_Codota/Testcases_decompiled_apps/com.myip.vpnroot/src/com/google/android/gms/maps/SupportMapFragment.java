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

public class SupportMapFragment extends Fragment {
    private GoogleMap aiG;
    private final C1786b ajj = new C1786b(this);

    /* renamed from: com.google.android.gms.maps.SupportMapFragment$a */
    static class C1785a implements LifecycleDelegate {

        /* renamed from: Ll */
        private final Fragment f4432Ll;
        private final IMapFragmentDelegate aiH;

        public C1785a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.aiH = (IMapFragmentDelegate) C0348n.m861i(iMapFragmentDelegate);
            this.f4432Ll = (Fragment) C0348n.m861i(fragment);
        }

        /* renamed from: mx */
        public IMapFragmentDelegate mo10477mx() {
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
            Bundle arguments = this.f4432Ll.getArguments();
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

    /* renamed from: com.google.android.gms.maps.SupportMapFragment$b */
    static class C1786b extends C0581a<C1785a> {

        /* renamed from: Ll */
        private final Fragment f4433Ll;
        protected C0598f<C1785a> aiI;

        /* renamed from: nr */
        private Activity f4434nr;

        C1786b(Fragment fragment) {
            this.f4433Ll = fragment;
        }

        /* access modifiers changed from: private */
        public void setActivity(Activity activity) {
            this.f4434nr = activity;
            mo10478my();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5498a(C0598f<C1785a> fVar) {
            this.aiI = fVar;
            mo10478my();
        }

        /* renamed from: my */
        public void mo10478my() {
            if (this.f4434nr != null && this.aiI != null && mo5499it() == null) {
                try {
                    MapsInitializer.initialize(this.f4434nr);
                    this.aiI.mo5511a(new C1785a(this.f4433Ll, C1868u.m6388R(this.f4434nr).mo10667j(C0597e.m1743k(this.f4434nr))));
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

    public final GoogleMap getMap() {
        IMapFragmentDelegate mx = mo10476mx();
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
    public IMapFragmentDelegate mo10476mx() {
        this.ajj.mo10478my();
        if (this.ajj.mo5499it() == null) {
            return null;
        }
        return ((C1785a) this.ajj.mo5499it()).mo10477mx();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.ajj.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.ajj.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.ajj.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.ajj.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.ajj.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.ajj.setActivity(activity);
        GoogleMapOptions createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.ajj.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.ajj.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.ajj.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.ajj.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.ajj.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
