package com.google.android.gms.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.p017b.C0597b;

public class MapView extends FrameLayout {

    /* renamed from: a */
    private final C1236v f5004a;

    /* renamed from: b */
    private GoogleMap f5005b;

    public MapView(Context context) {
        super(context);
        this.f5004a = new C1236v(this, context, (GoogleMapOptions) null);
        m5009a();
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5004a = new C1236v(this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
        m5009a();
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5004a = new C1236v(this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
        m5009a();
    }

    public MapView(Context context, GoogleMapOptions googleMapOptions) {
        super(context);
        this.f5004a = new C1236v(this, context, googleMapOptions);
        m5009a();
    }

    /* renamed from: a */
    private void m5009a() {
        setClickable(true);
    }

    @Deprecated
    public final GoogleMap getMap() {
        if (this.f5005b != null) {
            return this.f5005b;
        }
        this.f5004a.mo8991g();
        if (this.f5004a.mo6952a() == null) {
            return null;
        }
        try {
            this.f5005b = new GoogleMap(((C1234t) this.f5004a.mo6952a()).mo8989f().getMap());
            return this.f5005b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        C1009bf.m4535b("getMapAsync() must be called on the main thread");
        this.f5004a.mo8990a(onMapReadyCallback);
    }

    public final void onCreate(Bundle bundle) {
        this.f5004a.mo6954a(bundle);
        if (this.f5004a.mo6952a() == null) {
            C0597b.m3511b((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.f5004a.mo6961e();
    }

    public final void onLowMemory() {
        this.f5004a.mo6962f();
    }

    public final void onPause() {
        this.f5004a.mo6959c();
    }

    public final void onResume() {
        this.f5004a.mo6957b();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.f5004a.mo6958b(bundle);
    }
}
