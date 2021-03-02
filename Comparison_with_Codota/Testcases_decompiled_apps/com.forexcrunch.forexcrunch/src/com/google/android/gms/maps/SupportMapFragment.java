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

public class SupportMapFragment extends Fragment {

    /* renamed from: gK */
    private final C0650b f1529gK = new C0650b(this);

    /* renamed from: gz */
    private GoogleMap f1530gz;

    /* renamed from: com.google.android.gms.maps.SupportMapFragment$a */
    static class C0649a implements LifecycleDelegate {

        /* renamed from: gB */
        private final IMapFragmentDelegate f1531gB;

        /* renamed from: gL */
        private final Fragment f1532gL;

        public C0649a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.f1531gB = (IMapFragmentDelegate) C0621s.m1890d(iMapFragmentDelegate);
            this.f1532gL = (Fragment) C0621s.m1890d(fragment);
        }

        /* renamed from: bh */
        public IMapFragmentDelegate mo5724bh() {
            return this.f1531gB;
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.f1532gL.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                C0706o.m2017a(savedInstanceState, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.f1531gB.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C0371c.m701a(this.f1531gB.onCreateView(C0371c.m702f(inflater), C0371c.m702f(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.f1531gB.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.f1531gB.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.f1531gB.onInflate(C0371c.m702f(activity), (GoogleMapOptions) attrs.getParcelable("MapOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.f1531gB.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f1531gB.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f1531gB.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.f1531gB.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.SupportMapFragment$b */
    static class C0650b extends C0360a<C0649a> {

        /* renamed from: bm */
        private Activity f1533bm;

        /* renamed from: gC */
        protected C0372d<C0649a> f1534gC;

        /* renamed from: gL */
        private final Fragment f1535gL;

        C0650b(Fragment fragment) {
            this.f1535gL = fragment;
        }

        /* access modifiers changed from: private */
        public void setActivity(Activity activity) {
            this.f1533bm = activity;
            mo5725bi();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4114a(C0372d<C0649a> dVar) {
            this.f1534gC = dVar;
            mo5725bi();
        }

        /* renamed from: bi */
        public void mo5725bi() {
            if (this.f1533bm != null && this.f1534gC != null && mo4115at() == null) {
                try {
                    MapsInitializer.initialize(this.f1533bm);
                    this.f1534gC.mo4125a(new C0649a(this.f1535gL, C0707p.m2021i(this.f1533bm).mo5851d(C0371c.m702f(this.f1533bm))));
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
    /* renamed from: bh */
    public IMapFragmentDelegate mo5722bh() {
        this.f1529gK.mo5725bi();
        if (this.f1529gK.mo4115at() == null) {
            return null;
        }
        return ((C0649a) this.f1529gK.mo4115at()).mo5724bh();
    }

    public final GoogleMap getMap() {
        IMapFragmentDelegate bh = mo5722bh();
        if (bh == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = bh.getMap();
            if (map == null) {
                return null;
            }
            if (this.f1530gz == null || this.f1530gz.mo5586aY().asBinder() != map.asBinder()) {
                this.f1530gz = new GoogleMap(map);
            }
            return this.f1530gz;
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
        this.f1529gK.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f1529gK.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.f1529gK.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.f1529gK.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f1529gK.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.f1529gK.setActivity(activity);
        GoogleMapOptions createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.f1529gK.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.f1529gK.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.f1529gK.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f1529gK.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.f1529gK.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
