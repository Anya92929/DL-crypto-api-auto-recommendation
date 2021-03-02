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
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzaa;
import com.google.android.gms.maps.internal.zzad;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaView extends FrameLayout {

    /* renamed from: a */
    private final C0833b f3398a;

    /* renamed from: b */
    private StreetViewPanorama f3399b;

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaView$a */
    static class C0831a implements StreetViewLifecycleDelegate {

        /* renamed from: a */
        private final ViewGroup f3400a;

        /* renamed from: b */
        private final IStreetViewPanoramaViewDelegate f3401b;

        /* renamed from: c */
        private View f3402c;

        public C0831a(ViewGroup viewGroup, IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate) {
            this.f3401b = (IStreetViewPanoramaViewDelegate) zzx.zzz(iStreetViewPanoramaViewDelegate);
            this.f3400a = (ViewGroup) zzx.zzz(viewGroup);
        }

        /* renamed from: a */
        public IStreetViewPanoramaViewDelegate mo6368a() {
            return this.f3401b;
        }

        public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            try {
                this.f3401b.getStreetViewPanoramaAsync(new zzaa.zza() {
                    public void zza(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
                        onStreetViewPanoramaReadyCallback.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle bundle) {
            try {
                this.f3401b.onCreate(bundle);
                this.f3402c = (View) zze.zzp(this.f3401b.getView());
                this.f3400a.removeAllViews();
                this.f3400a.addView(this.f3402c);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onDestroy() {
            try {
                this.f3401b.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.f3401b.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.f3401b.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.f3401b.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.f3401b.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaView$b */
    static class C0833b extends zza<C0831a> {

        /* renamed from: a */
        protected zzf<C0831a> f3405a;

        /* renamed from: b */
        private final ViewGroup f3406b;

        /* renamed from: c */
        private final Context f3407c;

        /* renamed from: d */
        private final StreetViewPanoramaOptions f3408d;

        /* renamed from: e */
        private final List<OnStreetViewPanoramaReadyCallback> f3409e = new ArrayList();

        C0833b(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.f3406b = viewGroup;
            this.f3407c = context;
            this.f3408d = streetViewPanoramaOptions;
        }

        /* renamed from: a */
        public void mo6369a() {
            if (this.f3405a != null && zztU() == null) {
                try {
                    this.f3405a.zza(new C0831a(this.f3406b, zzad.zzaO(this.f3407c).zza(zze.zzC(this.f3407c), this.f3408d)));
                    for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.f3409e) {
                        ((C0831a) zztU()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                    }
                    this.f3409e.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }

        /* renamed from: a */
        public void mo6370a(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            if (zztU() != null) {
                ((C0831a) zztU()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
            } else {
                this.f3409e.add(onStreetViewPanoramaReadyCallback);
            }
        }

        /* access modifiers changed from: protected */
        public void zza(zzf<C0831a> zzf) {
            this.f3405a = zzf;
            mo6369a();
        }
    }

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.f3398a = new C0833b(this, context, (StreetViewPanoramaOptions) null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3398a = new C0833b(this, context, (StreetViewPanoramaOptions) null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3398a = new C0833b(this, context, (StreetViewPanoramaOptions) null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        super(context);
        this.f3398a = new C0833b(this, context, streetViewPanoramaOptions);
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        if (this.f3399b != null) {
            return this.f3399b;
        }
        this.f3398a.mo6369a();
        if (this.f3398a.zztU() == null) {
            return null;
        }
        try {
            this.f3399b = new StreetViewPanorama(((C0831a) this.f3398a.zztU()).mo6368a().getStreetViewPanorama());
            return this.f3399b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        zzx.zzcD("getStreetViewPanoramaAsync() must be called on the main thread");
        this.f3398a.mo6370a(onStreetViewPanoramaReadyCallback);
    }

    public final void onCreate(Bundle bundle) {
        this.f3398a.onCreate(bundle);
        if (this.f3398a.zztU() == null) {
            zza.zzb(this);
        }
    }

    public final void onDestroy() {
        this.f3398a.onDestroy();
    }

    public final void onLowMemory() {
        this.f3398a.onLowMemory();
    }

    public final void onPause() {
        this.f3398a.onPause();
    }

    public final void onResume() {
        this.f3398a.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.f3398a.onSaveInstanceState(bundle);
    }
}
