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
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class SupportStreetViewPanoramaFragment extends Fragment {
    private StreetViewPanorama aiW;
    private final C1788b ajk = new C1788b(this);

    /* renamed from: com.google.android.gms.maps.SupportStreetViewPanoramaFragment$a */
    static class C1787a implements LifecycleDelegate {

        /* renamed from: Ll */
        private final Fragment f4435Ll;
        private final IStreetViewPanoramaFragmentDelegate aiX;

        public C1787a(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.aiX = (IStreetViewPanoramaFragmentDelegate) C0348n.m861i(iStreetViewPanoramaFragmentDelegate);
            this.f4435Ll = (Fragment) C0348n.m861i(fragment);
        }

        /* renamed from: mB */
        public IStreetViewPanoramaFragmentDelegate mo10481mB() {
            return this.aiX;
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.f4435Ll.getArguments();
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                C1867t.m6387a(savedInstanceState, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.aiX.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C0597e.m1742f(this.aiX.onCreateView(C0597e.m1743k(inflater), C0597e.m1743k(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.aiX.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.aiX.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.aiX.onInflate(C0597e.m1743k(activity), (StreetViewPanoramaOptions) null, savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.aiX.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.aiX.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.aiX.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.aiX.onSaveInstanceState(outState);
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
    static class C1788b extends C0581a<C1787a> {

        /* renamed from: Ll */
        private final Fragment f4436Ll;
        protected C0598f<C1787a> aiI;

        /* renamed from: nr */
        private Activity f4437nr;

        C1788b(Fragment fragment) {
            this.f4436Ll = fragment;
        }

        /* access modifiers changed from: private */
        public void setActivity(Activity activity) {
            this.f4437nr = activity;
            mo10482my();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5498a(C0598f<C1787a> fVar) {
            this.aiI = fVar;
            mo10482my();
        }

        /* renamed from: my */
        public void mo10482my() {
            if (this.f4437nr != null && this.aiI != null && mo5499it() == null) {
                try {
                    MapsInitializer.initialize(this.f4437nr);
                    this.aiI.mo5511a(new C1787a(this.f4436Ll, C1868u.m6388R(this.f4437nr).mo10668k(C0597e.m1743k(this.f4437nr))));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public static SupportStreetViewPanoramaFragment newInstance() {
        return new SupportStreetViewPanoramaFragment();
    }

    public static SupportStreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions options) {
        SupportStreetViewPanoramaFragment supportStreetViewPanoramaFragment = new SupportStreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", options);
        supportStreetViewPanoramaFragment.setArguments(bundle);
        return supportStreetViewPanoramaFragment;
    }

    public final StreetViewPanorama getStreetViewPanorama() {
        IStreetViewPanoramaFragmentDelegate mB = mo10480mB();
        if (mB == null) {
            return null;
        }
        try {
            IStreetViewPanoramaDelegate streetViewPanorama = mB.getStreetViewPanorama();
            if (streetViewPanorama == null) {
                return null;
            }
            if (this.aiW == null || this.aiW.mo10405mA().asBinder() != streetViewPanorama.asBinder()) {
                this.aiW = new StreetViewPanorama(streetViewPanorama);
            }
            return this.aiW;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: mB */
    public IStreetViewPanoramaFragmentDelegate mo10480mB() {
        this.ajk.mo10482my();
        if (this.ajk.mo5499it() == null) {
            return null;
        }
        return ((C1787a) this.ajk.mo5499it()).mo10481mB();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.ajk.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.ajk.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.ajk.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.ajk.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.ajk.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.ajk.setActivity(activity);
        this.ajk.onInflate(activity, new Bundle(), savedInstanceState);
    }

    public void onLowMemory() {
        this.ajk.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.ajk.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.ajk.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.ajk.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
