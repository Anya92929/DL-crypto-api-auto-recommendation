package com.google.android.gms.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.p017b.C0597b;

public class StreetViewPanoramaView extends FrameLayout {

    /* renamed from: a */
    private final C1166af f5021a;

    /* renamed from: b */
    private StreetViewPanorama f5022b;

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.f5021a = new C1166af(this, context, (StreetViewPanoramaOptions) null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5021a = new C1166af(this, context, (StreetViewPanoramaOptions) null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5021a = new C1166af(this, context, (StreetViewPanoramaOptions) null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        super(context);
        this.f5021a = new C1166af(this, context, streetViewPanoramaOptions);
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        if (this.f5022b != null) {
            return this.f5022b;
        }
        this.f5021a.mo8175g();
        if (this.f5021a.mo6952a() == null) {
            return null;
        }
        try {
            this.f5022b = new StreetViewPanorama(((C1164ad) this.f5021a.mo6952a()).mo8173f().getStreetViewPanorama());
            return this.f5022b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        C1009bf.m4535b("getStreetViewPanoramaAsync() must be called on the main thread");
        this.f5021a.mo8174a(onStreetViewPanoramaReadyCallback);
    }

    public final void onCreate(Bundle bundle) {
        this.f5021a.mo6954a(bundle);
        if (this.f5021a.mo6952a() == null) {
            C0597b.m3511b((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.f5021a.mo6961e();
    }

    public final void onLowMemory() {
        this.f5021a.mo6962f();
    }

    public final void onPause() {
        this.f5021a.mo6959c();
    }

    public final void onResume() {
        this.f5021a.mo6957b();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.f5021a.mo6958b(bundle);
    }
}
