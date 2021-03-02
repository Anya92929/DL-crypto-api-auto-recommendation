package com.google.android.gms.fitness;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.support.p003v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.C1415kj;
import com.google.android.gms.internal.C1419kk;
import com.google.android.gms.internal.C1446ku;
import com.google.android.gms.internal.C1448kw;
import com.google.android.gms.internal.C1456kx;
import com.google.android.gms.internal.C1461ky;
import com.google.android.gms.internal.C1466kz;
import com.google.android.gms.internal.C1468la;
import com.google.android.gms.internal.C1473lb;
import com.google.android.gms.internal.C1480lc;
import com.google.android.gms.internal.C1489ld;

public class Fitness {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>(f1273CV, f1272CU, new Scope[0]);
    public static final BleApi BleApi = m1754iy();

    /* renamed from: CU */
    public static final Api.C0268c<C1415kj> f1272CU = new Api.C0268c<>();

    /* renamed from: CV */
    private static final Api.C0267b<C1415kj, Api.ApiOptions.NoOptions> f1273CV = new Api.C0267b<C1415kj, Api.ApiOptions.NoOptions>() {
        /* renamed from: c */
        public C1415kj mo3762a(Context context, Looper looper, ClientSettings clientSettings, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new C1419kk(context, looper, connectionCallbacks, onConnectionFailedListener, clientSettings.getAccountNameOrDefault(), FitnessScopes.m1759d(clientSettings.getScopes()));
        }

        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    };
    public static final ConfigApi ConfigApi = new C1456kx();
    public static final HistoryApi HistoryApi = new C1461ky();
    public static final RecordingApi RecordingApi = new C1468la();
    public static final SensorsApi SensorsApi = new C1473lb();
    public static final SessionsApi SessionsApi = new C1480lc();

    /* renamed from: Sf */
    public static final C1446ku f1274Sf = new C1466kz();

    private Fitness() {
    }

    /* renamed from: iy */
    private static BleApi m1754iy() {
        return Build.VERSION.SDK_INT >= 18 ? new C1448kw() : new C1489ld();
    }
}
