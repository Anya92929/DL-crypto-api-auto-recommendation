package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import android.support.p003v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.C1518lt;
import com.google.android.gms.internal.C1527lu;
import com.google.android.gms.internal.C1544ly;

public class LocationServices {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>(f4421CV, f4420CU, new Scope[0]);
    /* access modifiers changed from: private */

    /* renamed from: CU */
    public static final Api.C0268c<C1544ly> f4420CU = new Api.C0268c<>();

    /* renamed from: CV */
    private static final Api.C0267b<C1544ly, Api.ApiOptions.NoOptions> f4421CV = new Api.C0267b<C1544ly, Api.ApiOptions.NoOptions>() {
        /* renamed from: d */
        public C1544ly mo3762a(Context context, Looper looper, ClientSettings clientSettings, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new C1544ly(context, looper, context.getPackageName(), connectionCallbacks, onConnectionFailedListener, "locationServices", clientSettings.getAccountName());
        }

        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    };
    public static FusedLocationProviderApi FusedLocationApi = new C1518lt();
    public static GeofencingApi GeofencingApi = new C1527lu();

    /* renamed from: com.google.android.gms.location.LocationServices$a */
    public static abstract class C1752a<R extends Result> extends BaseImplementation.C0269a<R, C1544ly> {
        public C1752a() {
            super(LocationServices.f4420CU);
        }
    }

    private LocationServices() {
    }

    /* renamed from: e */
    public static C1544ly m6243e(GoogleApiClient googleApiClient) {
        boolean z = true;
        C0348n.m859b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        C1544ly lyVar = (C1544ly) googleApiClient.mo4218a(f4420CU);
        if (lyVar == null) {
            z = false;
        }
        C0348n.m852a(z, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return lyVar;
    }
}
