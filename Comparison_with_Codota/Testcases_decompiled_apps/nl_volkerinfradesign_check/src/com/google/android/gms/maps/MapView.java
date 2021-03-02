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
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzad;
import com.google.android.gms.maps.internal.zzo;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class MapView extends FrameLayout {

    /* renamed from: a */
    private final C0820b f3355a;

    /* renamed from: b */
    private GoogleMap f3356b;

    /* renamed from: com.google.android.gms.maps.MapView$a */
    static class C0818a implements MapLifecycleDelegate {

        /* renamed from: a */
        private final ViewGroup f3357a;

        /* renamed from: b */
        private final IMapViewDelegate f3358b;

        /* renamed from: c */
        private View f3359c;

        public C0818a(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.f3358b = (IMapViewDelegate) zzx.zzz(iMapViewDelegate);
            this.f3357a = (ViewGroup) zzx.zzz(viewGroup);
        }

        /* renamed from: a */
        public IMapViewDelegate mo6273a() {
            return this.f3358b;
        }

        /* renamed from: a */
        public void mo6274a(Bundle bundle) {
            try {
                this.f3358b.onEnterAmbient(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        /* renamed from: b */
        public void mo6275b() {
            try {
                this.f3358b.onExitAmbient();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void getMapAsync(final OnMapReadyCallback onMapReadyCallback) {
            try {
                this.f3358b.getMapAsync(new zzo.zza() {
                    public void zza(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
                        onMapReadyCallback.onMapReady(new GoogleMap(iGoogleMapDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle bundle) {
            try {
                this.f3358b.onCreate(bundle);
                this.f3359c = (View) zze.zzp(this.f3358b.getView());
                this.f3357a.removeAllViews();
                this.f3357a.addView(this.f3359c);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy() {
            try {
                this.f3358b.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.f3358b.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f3358b.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f3358b.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.f3358b.onSaveInstanceState(bundle);
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
    static class C0820b extends zza<C0818a> {

        /* renamed from: a */
        protected zzf<C0818a> f3362a;

        /* renamed from: b */
        private final ViewGroup f3363b;

        /* renamed from: c */
        private final Context f3364c;

        /* renamed from: d */
        private final GoogleMapOptions f3365d;

        /* renamed from: e */
        private final List<OnMapReadyCallback> f3366e = new ArrayList();

        C0820b(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.f3363b = viewGroup;
            this.f3364c = context;
            this.f3365d = googleMapOptions;
        }

        /* renamed from: a */
        public void mo6276a() {
            if (this.f3362a != null && zztU() == null) {
                try {
                    MapsInitializer.initialize(this.f3364c);
                    IMapViewDelegate zza = zzad.zzaO(this.f3364c).zza(zze.zzC(this.f3364c), this.f3365d);
                    if (zza != null) {
                        this.f3362a.zza(new C0818a(this.f3363b, zza));
                        for (OnMapReadyCallback mapAsync : this.f3366e) {
                            ((C0818a) zztU()).getMapAsync(mapAsync);
                        }
                        this.f3366e.clear();
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }

        /* renamed from: a */
        public void mo6277a(Bundle bundle) {
            if (zztU() != null) {
                ((C0818a) zztU()).mo6274a(bundle);
            }
        }

        /* renamed from: a */
        public void mo6278a(OnMapReadyCallback onMapReadyCallback) {
            if (zztU() != null) {
                ((C0818a) zztU()).getMapAsync(onMapReadyCallback);
            } else {
                this.f3366e.add(onMapReadyCallback);
            }
        }

        /* renamed from: b */
        public void mo6279b() {
            if (zztU() != null) {
                ((C0818a) zztU()).mo6275b();
            }
        }

        /* access modifiers changed from: protected */
        public void zza(zzf<C0818a> zzf) {
            this.f3362a = zzf;
            mo6276a();
        }
    }

    public MapView(Context context) {
        super(context);
        this.f3355a = new C0820b(this, context, (GoogleMapOptions) null);
        m4138a();
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3355a = new C0820b(this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
        m4138a();
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3355a = new C0820b(this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
        m4138a();
    }

    public MapView(Context context, GoogleMapOptions googleMapOptions) {
        super(context);
        this.f3355a = new C0820b(this, context, googleMapOptions);
        m4138a();
    }

    /* renamed from: a */
    private void m4138a() {
        setClickable(true);
    }

    @Deprecated
    public final GoogleMap getMap() {
        if (this.f3356b != null) {
            return this.f3356b;
        }
        this.f3355a.mo6276a();
        if (this.f3355a.zztU() == null) {
            return null;
        }
        try {
            this.f3356b = new GoogleMap(((C0818a) this.f3355a.zztU()).mo6273a().getMap());
            return this.f3356b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        zzx.zzcD("getMapAsync() must be called on the main thread");
        this.f3355a.mo6278a(onMapReadyCallback);
    }

    public final void onCreate(Bundle bundle) {
        this.f3355a.onCreate(bundle);
        if (this.f3355a.zztU() == null) {
            zza.zzb(this);
        }
    }

    public final void onDestroy() {
        this.f3355a.onDestroy();
    }

    public final void onEnterAmbient(Bundle bundle) {
        zzx.zzcD("onEnterAmbient() must be called on the main thread");
        this.f3355a.mo6277a(bundle);
    }

    public final void onExitAmbient() {
        zzx.zzcD("onExitAmbient() must be called on the main thread");
        this.f3355a.mo6279b();
    }

    public final void onLowMemory() {
        this.f3355a.onLowMemory();
    }

    public final void onPause() {
        this.f3355a.onPause();
    }

    public final void onResume() {
        this.f3355a.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.f3355a.onSaveInstanceState(bundle);
    }
}
