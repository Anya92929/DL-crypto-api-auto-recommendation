package com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import android.support.p003v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.C1586nb;
import com.google.android.gms.internal.C1595nc;

public final class Panorama {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>(f4495CV, f4494CU, new Scope[0]);

    /* renamed from: CU */
    public static final Api.C0268c<C1595nc> f4494CU = new Api.C0268c<>();

    /* renamed from: CV */
    static final Api.C0267b<C1595nc, Api.ApiOptions.NoOptions> f4495CV = new Api.C0267b<C1595nc, Api.ApiOptions.NoOptions>() {
        /* renamed from: e */
        public C1595nc mo3762a(Context context, Looper looper, ClientSettings clientSettings, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new C1595nc(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    };
    public static final PanoramaApi PanoramaApi = new C1586nb();

    private Panorama() {
    }
}
