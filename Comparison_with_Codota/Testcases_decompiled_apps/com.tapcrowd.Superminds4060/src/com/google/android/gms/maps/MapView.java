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
import com.google.android.gms.dynamic.C0156a;
import com.google.android.gms.dynamic.C0167c;
import com.google.android.gms.dynamic.C0168d;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.C0411dm;
import com.google.android.gms.maps.internal.C0707q;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapView extends FrameLayout {

    /* renamed from: pI */
    private GoogleMap f1659pI;

    /* renamed from: pM */
    private final C0645b f1660pM;

    /* renamed from: com.google.android.gms.maps.MapView$a */
    static class C0644a implements LifecycleDelegate {

        /* renamed from: pN */
        private final ViewGroup f1661pN;

        /* renamed from: pO */
        private final IMapViewDelegate f1662pO;

        /* renamed from: pP */
        private View f1663pP;

        public C0644a(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.f1662pO = (IMapViewDelegate) C0411dm.m944e(iMapViewDelegate);
            this.f1661pN = (ViewGroup) C0411dm.m944e(viewGroup);
        }

        /* renamed from: cF */
        public IMapViewDelegate mo5544cF() {
            return this.f1662pO;
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.f1662pO.onCreate(savedInstanceState);
                this.f1663pP = (View) C0167c.m378b(this.f1662pO.getView());
                this.f1661pN.removeAllViews();
                this.f1661pN.addView(this.f1663pP);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy() {
            try {
                this.f1662pO.onDestroy();
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
                this.f1662pO.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f1662pO.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f1662pO.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.f1662pO.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.MapView$b */
    static class C0645b extends C0156a<C0644a> {
        private final Context mContext;

        /* renamed from: pL */
        protected C0168d<C0644a> f1664pL;

        /* renamed from: pQ */
        private final ViewGroup f1665pQ;

        /* renamed from: pR */
        private final GoogleMapOptions f1666pR;

        C0645b(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.f1665pQ = viewGroup;
            this.mContext = context;
            this.f1666pR = googleMapOptions;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3664a(C0168d<C0644a> dVar) {
            this.f1664pL = dVar;
            mo5545cE();
        }

        /* renamed from: cE */
        public void mo5545cE() {
            if (this.f1664pL != null && mo3665bP() == null) {
                try {
                    this.f1664pL.mo3675a(new C0644a(this.f1665pQ, C0707q.m2071u(this.mContext).mo5676a(C0167c.m379g(this.mContext), this.f1666pR)));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.f1660pM = new C0645b(this, context, (GoogleMapOptions) null);
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f1660pM = new C0645b(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f1660pM = new C0645b(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, GoogleMapOptions options) {
        super(context);
        this.f1660pM = new C0645b(this, context, options);
    }

    public final GoogleMap getMap() {
        if (this.f1659pI != null) {
            return this.f1659pI;
        }
        this.f1660pM.mo5545cE();
        if (this.f1660pM.mo3665bP() == null) {
            return null;
        }
        try {
            this.f1659pI = new GoogleMap(((C0644a) this.f1660pM.mo3665bP()).mo5544cF().getMap());
            return this.f1659pI;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.f1660pM.onCreate(savedInstanceState);
        if (this.f1660pM.mo3665bP() == null) {
            this.f1660pM.mo3663a((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.f1660pM.onDestroy();
    }

    public final void onLowMemory() {
        this.f1660pM.onLowMemory();
    }

    public final void onPause() {
        this.f1660pM.onPause();
    }

    public final void onResume() {
        this.f1660pM.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.f1660pM.onSaveInstanceState(outState);
    }
}
