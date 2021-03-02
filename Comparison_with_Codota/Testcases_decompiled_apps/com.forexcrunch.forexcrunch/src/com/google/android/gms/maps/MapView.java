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
import com.google.android.gms.dynamic.C0360a;
import com.google.android.gms.dynamic.C0371c;
import com.google.android.gms.dynamic.C0372d;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.C0621s;
import com.google.android.gms.maps.internal.C0707p;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapView extends FrameLayout {

    /* renamed from: gD */
    private final C0648b f1520gD;

    /* renamed from: gz */
    private GoogleMap f1521gz;

    /* renamed from: com.google.android.gms.maps.MapView$a */
    static class C0647a implements LifecycleDelegate {

        /* renamed from: gE */
        private final ViewGroup f1522gE;

        /* renamed from: gF */
        private final IMapViewDelegate f1523gF;

        /* renamed from: gG */
        private View f1524gG;

        public C0647a(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.f1523gF = (IMapViewDelegate) C0621s.m1890d(iMapViewDelegate);
            this.f1522gE = (ViewGroup) C0621s.m1890d(viewGroup);
        }

        /* renamed from: bj */
        public IMapViewDelegate mo5717bj() {
            return this.f1523gF;
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.f1523gF.onCreate(savedInstanceState);
                this.f1524gG = (View) C0371c.m701a(this.f1523gF.getView());
                this.f1522gE.removeAllViews();
                this.f1522gE.addView(this.f1524gG);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy() {
            try {
                this.f1523gF.onDestroy();
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
                this.f1523gF.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f1523gF.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f1523gF.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.f1523gF.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.MapView$b */
    static class C0648b extends C0360a<C0647a> {

        /* renamed from: gC */
        protected C0372d<C0647a> f1525gC;

        /* renamed from: gH */
        private final ViewGroup f1526gH;

        /* renamed from: gI */
        private final GoogleMapOptions f1527gI;
        private final Context mContext;

        C0648b(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.f1526gH = viewGroup;
            this.mContext = context;
            this.f1527gI = googleMapOptions;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4114a(C0372d<C0647a> dVar) {
            this.f1525gC = dVar;
            mo5718bi();
        }

        /* renamed from: bi */
        public void mo5718bi() {
            if (this.f1525gC != null && mo4115at() == null) {
                try {
                    this.f1525gC.mo4125a(new C0647a(this.f1526gH, C0707p.m2021i(this.mContext).mo5846a(C0371c.m702f(this.mContext), this.f1527gI)));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.f1520gD = new C0648b(this, context, (GoogleMapOptions) null);
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f1520gD = new C0648b(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f1520gD = new C0648b(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, GoogleMapOptions options) {
        super(context);
        this.f1520gD = new C0648b(this, context, options);
    }

    public final GoogleMap getMap() {
        if (this.f1521gz != null) {
            return this.f1521gz;
        }
        this.f1520gD.mo5718bi();
        if (this.f1520gD.mo4115at() == null) {
            return null;
        }
        try {
            this.f1521gz = new GoogleMap(((C0647a) this.f1520gD.mo4115at()).mo5717bj().getMap());
            return this.f1521gz;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.f1520gD.onCreate(savedInstanceState);
        if (this.f1520gD.mo4115at() == null) {
            this.f1520gD.mo4113a((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.f1520gD.onDestroy();
    }

    public final void onLowMemory() {
        this.f1520gD.onLowMemory();
    }

    public final void onPause() {
        this.f1520gD.onPause();
    }

    public final void onResume() {
        this.f1520gD.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.f1520gD.onSaveInstanceState(outState);
    }
}
