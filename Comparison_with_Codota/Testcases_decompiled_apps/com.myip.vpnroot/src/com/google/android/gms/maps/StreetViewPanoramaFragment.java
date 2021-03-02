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
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class StreetViewPanoramaFragment extends Fragment {
    private final C1782b aiV = new C1782b(this);
    private StreetViewPanorama aiW;

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaFragment$a */
    static class C1781a implements LifecycleDelegate {

        /* renamed from: Sb */
        private final Fragment f4428Sb;
        private final IStreetViewPanoramaFragmentDelegate aiX;

        public C1781a(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.aiX = (IStreetViewPanoramaFragmentDelegate) C0348n.m861i(iStreetViewPanoramaFragmentDelegate);
            this.f4428Sb = (Fragment) C0348n.m861i(fragment);
        }

        /* renamed from: mB */
        public IStreetViewPanoramaFragmentDelegate mo10438mB() {
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
            Bundle arguments = this.f4428Sb.getArguments();
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

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaFragment$b */
    static class C1782b extends C0581a<C1781a> {

        /* renamed from: Sb */
        private final Fragment f4429Sb;
        protected C0598f<C1781a> aiI;

        /* renamed from: nr */
        private Activity f4430nr;

        C1782b(Fragment fragment) {
            this.f4429Sb = fragment;
        }

        /* access modifiers changed from: private */
        public void setActivity(Activity activity) {
            this.f4430nr = activity;
            mo10439my();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5498a(C0598f<C1781a> fVar) {
            this.aiI = fVar;
            mo10439my();
        }

        /* renamed from: my */
        public void mo10439my() {
            if (this.f4430nr != null && this.aiI != null && mo5499it() == null) {
                try {
                    MapsInitializer.initialize(this.f4430nr);
                    this.aiI.mo5511a(new C1781a(this.f4429Sb, C1868u.m6388R(this.f4430nr).mo10668k(C0597e.m1743k(this.f4430nr))));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public static StreetViewPanoramaFragment newInstance() {
        return new StreetViewPanoramaFragment();
    }

    public static StreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions options) {
        StreetViewPanoramaFragment streetViewPanoramaFragment = new StreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", options);
        streetViewPanoramaFragment.setArguments(bundle);
        return streetViewPanoramaFragment;
    }

    public final StreetViewPanorama getStreetViewPanorama() {
        IStreetViewPanoramaFragmentDelegate mB = mo10425mB();
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
    public IStreetViewPanoramaFragmentDelegate mo10425mB() {
        this.aiV.mo10439my();
        if (this.aiV.mo5499it() == null) {
            return null;
        }
        return ((C1781a) this.aiV.mo5499it()).mo10438mB();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aiV.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.aiV.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.aiV.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.aiV.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.aiV.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.aiV.setActivity(activity);
        this.aiV.onInflate(activity, new Bundle(), savedInstanceState);
    }

    public void onLowMemory() {
        this.aiV.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.aiV.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.aiV.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.aiV.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
