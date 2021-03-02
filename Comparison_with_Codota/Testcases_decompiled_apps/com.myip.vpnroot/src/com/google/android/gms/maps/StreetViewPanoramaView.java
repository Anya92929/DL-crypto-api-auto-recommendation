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
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class StreetViewPanoramaView extends FrameLayout {
    private StreetViewPanorama aiW;
    private final C1783a ajf;

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaView$a */
    static class C1783a extends C0581a<C1784b> {
        protected C0598f<C1784b> aiI;
        private final ViewGroup aiN;
        private final StreetViewPanoramaOptions ajg;
        private final Context mContext;

        C1783a(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.aiN = viewGroup;
            this.mContext = context;
            this.ajg = streetViewPanoramaOptions;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5498a(C0598f<C1784b> fVar) {
            this.aiI = fVar;
            mo10473my();
        }

        /* renamed from: my */
        public void mo10473my() {
            if (this.aiI != null && mo5499it() == null) {
                try {
                    this.aiI.mo5511a(new C1784b(this.aiN, C1868u.m6388R(this.mContext).mo10664a(C0597e.m1743k(this.mContext), this.ajg)));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaView$b */
    static class C1784b implements LifecycleDelegate {
        private final ViewGroup aiK;
        private final IStreetViewPanoramaViewDelegate ajh;
        private View aji;

        public C1784b(ViewGroup viewGroup, IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate) {
            this.ajh = (IStreetViewPanoramaViewDelegate) C0348n.m861i(iStreetViewPanoramaViewDelegate);
            this.aiK = (ViewGroup) C0348n.m861i(viewGroup);
        }

        /* renamed from: mF */
        public IStreetViewPanoramaViewDelegate mo10474mF() {
            return this.ajh;
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.ajh.onCreate(savedInstanceState);
                this.aji = (View) C0597e.m1742f(this.ajh.getView());
                this.aiK.removeAllViews();
                this.aiK.addView(this.aji);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onDestroy() {
            try {
                this.ajh.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.ajh.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.ajh.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.ajh.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.ajh.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.ajf = new C1783a(this, context, (StreetViewPanoramaOptions) null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.ajf = new C1783a(this, context, (StreetViewPanoramaOptions) null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.ajf = new C1783a(this, context, (StreetViewPanoramaOptions) null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions options) {
        super(context);
        this.ajf = new C1783a(this, context, options);
    }

    public final StreetViewPanorama getStreetViewPanorama() {
        if (this.aiW != null) {
            return this.aiW;
        }
        this.ajf.mo10473my();
        if (this.ajf.mo5499it() == null) {
            return null;
        }
        try {
            this.aiW = new StreetViewPanorama(((C1784b) this.ajf.mo5499it()).mo10474mF().getStreetViewPanorama());
            return this.aiW;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.ajf.onCreate(savedInstanceState);
        if (this.ajf.mo5499it() == null) {
            C1783a aVar = this.ajf;
            C1783a.m1709b((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.ajf.onDestroy();
    }

    public final void onLowMemory() {
        this.ajf.onLowMemory();
    }

    public final void onPause() {
        this.ajf.onPause();
    }

    public final void onResume() {
        this.ajf.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.ajf.onSaveInstanceState(outState);
    }
}
