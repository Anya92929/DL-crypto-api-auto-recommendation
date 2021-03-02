package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.zzpm;

public interface zzpz {
    void begin();

    void connect();

    boolean disconnect();

    void onConnected(Bundle bundle);

    void onConnectionSuspended(int i);

    void zza(ConnectionResult connectionResult, Api api, int i);

    zzpm.zza zzc(zzpm.zza zza);

    zzpm.zza zzd(zzpm.zza zza);
}
