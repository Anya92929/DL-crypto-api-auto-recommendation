package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.dynamic.C0581a;
import com.google.android.gms.dynamic.C0597e;
import com.google.android.gms.dynamic.C0598f;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.maps.internal.C1868u;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapView extends FrameLayout {
    private GoogleMap aiG;
    private final C1777b aiJ;

    /* renamed from: com.google.android.gms.maps.MapView$a */
    static class C1776a implements LifecycleDelegate {
        private final ViewGroup aiK;
        private final IMapViewDelegate aiL;
        private View aiM;

        public C1776a(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.aiL = (IMapViewDelegate) C0348n.m861i(iMapViewDelegate);
            this.aiK = (ViewGroup) C0348n.m861i(viewGroup);
        }

        /* renamed from: mz */
        public IMapViewDelegate mo10393mz() {
            return this.aiL;
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.aiL.onCreate(savedInstanceState);
                this.aiM = (View) C0597e.m1742f(this.aiL.getView());
                this.aiK.removeAllViews();
                this.aiK.addView(this.aiM);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy() {
            try {
                this.aiL.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.aiL.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.aiL.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.aiL.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.aiL.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.MapView$b */
    static class C1777b extends C0581a<C1776a> {
        protected C0598f<C1776a> aiI;
        private final ViewGroup aiN;
        private final GoogleMapOptions aiO;
        private final Context mContext;

        C1777b(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.aiN = viewGroup;
            this.mContext = context;
            this.aiO = googleMapOptions;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5498a(C0598f<C1776a> fVar) {
            this.aiI = fVar;
            mo10394my();
        }

        /* renamed from: my */
        public void mo10394my() {
            if (this.aiI != null && mo5499it() == null) {
                try {
                    this.aiI.mo5511a(new C1776a(this.aiN, C1868u.m6388R(this.mContext).mo10663a(C0597e.m1743k(this.mContext), this.aiO)));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.aiJ = new C1777b(this, context, (GoogleMapOptions) null);
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.aiJ = new C1777b(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.aiJ = new C1777b(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, GoogleMapOptions options) {
        super(context);
        this.aiJ = new C1777b(this, context, options);
    }

    public final GoogleMap getMap() {
        if (this.aiG != null) {
            return this.aiG;
        }
        this.aiJ.mo10394my();
        if (this.aiJ.mo5499it() == null) {
            return null;
        }
        try {
            this.aiG = new GoogleMap(((C1776a) this.aiJ.mo5499it()).mo10393mz().getMap());
            return this.aiG;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.aiJ.onCreate(savedInstanceState);
        if (this.aiJ.mo5499it() == null) {
            C1777b bVar = this.aiJ;
            C1777b.m1709b((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.aiJ.onDestroy();
    }

    public final void onLowMemory() {
        this.aiJ.onLowMemory();
    }

    public final void onPause() {
        this.aiJ.onPause();
    }

    public final void onResume() {
        this.aiJ.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.aiJ.onSaveInstanceState(outState);
    }
}
