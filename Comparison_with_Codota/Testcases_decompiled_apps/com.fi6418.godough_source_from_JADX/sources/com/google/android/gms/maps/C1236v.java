package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.common.C0799c;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.p017b.C0597b;
import com.google.android.gms.p017b.C0608m;
import com.google.android.gms.p017b.C0609n;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.maps.v */
class C1236v extends C0597b<C1234t> {

    /* renamed from: a */
    protected C0609n<C1234t> f5239a;

    /* renamed from: b */
    private final ViewGroup f5240b;

    /* renamed from: c */
    private final Context f5241c;

    /* renamed from: d */
    private final GoogleMapOptions f5242d;

    /* renamed from: e */
    private final List<OnMapReadyCallback> f5243e = new ArrayList();

    C1236v(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
        this.f5240b = viewGroup;
        this.f5241c = context;
        this.f5242d = googleMapOptions;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6956a(C0609n<C1234t> nVar) {
        this.f5239a = nVar;
        mo8991g();
    }

    /* renamed from: a */
    public void mo8990a(OnMapReadyCallback onMapReadyCallback) {
        if (mo6952a() != null) {
            ((C1234t) mo6952a()).getMapAsync(onMapReadyCallback);
        } else {
            this.f5243e.add(onMapReadyCallback);
        }
    }

    /* renamed from: g */
    public void mo8991g() {
        if (this.f5239a != null && mo6952a() == null) {
            try {
                MapsInitializer.initialize(this.f5241c);
                IMapViewDelegate zza = zzy.zzaF(this.f5241c).zza(C0608m.m3536a(this.f5241c), this.f5242d);
                if (zza != null) {
                    this.f5239a.mo6963a(new C1234t(this.f5240b, zza));
                    for (OnMapReadyCallback mapAsync : this.f5243e) {
                        ((C1234t) mo6952a()).getMapAsync(mapAsync);
                    }
                    this.f5243e.clear();
                }
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            } catch (C0799c e2) {
            }
        }
    }
}
