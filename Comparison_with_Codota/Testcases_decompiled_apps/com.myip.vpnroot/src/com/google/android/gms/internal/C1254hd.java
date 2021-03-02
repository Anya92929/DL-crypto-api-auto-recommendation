package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.support.p003v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;

/* renamed from: com.google.android.gms.internal.hd */
public final class C1254hd {

    /* renamed from: BN */
    public static final Api.C0268c<C1285hy> f3831BN = new Api.C0268c<>();

    /* renamed from: BO */
    private static final Api.C0267b<C1285hy, Api.ApiOptions.NoOptions> f3832BO = new Api.C0267b<C1285hy, Api.ApiOptions.NoOptions>() {
        /* renamed from: a */
        public C1285hy mo3762a(Context context, Looper looper, ClientSettings clientSettings, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new C1285hy(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    };

    /* renamed from: BP */
    public static final Api<Api.ApiOptions.NoOptions> f3833BP = new Api<>(f3832BO, f3831BN, new Scope[0]);

    /* renamed from: BQ */
    public static final C1276hu f3834BQ = new C1286hz();
}
