package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.internal.C0621s;
import com.google.android.gms.maps.internal.C0670c;
import com.google.android.gms.maps.internal.C0707p;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
    private MapsInitializer() {
    }

    public static void initialize(Context context) throws GooglePlayServicesNotAvailableException {
        C0621s.m1890d(context);
        C0670c i = C0707p.m2021i(context);
        try {
            CameraUpdateFactory.m1930a(i.mo5848bk());
            BitmapDescriptorFactory.m2027a(i.mo5849bl());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
