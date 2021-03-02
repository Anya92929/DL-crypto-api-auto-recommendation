package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import android.support.p003v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.wearable.internal.C2243ag;
import com.google.android.gms.wearable.internal.C2250aj;
import com.google.android.gms.wearable.internal.C2269aw;
import com.google.android.gms.wearable.internal.C2289e;
import com.google.android.gms.wearable.internal.C2290f;

public class Wearable {
    public static final Api<WearableOptions> API = new Api<>(f4655CV, f4654CU, new Scope[0]);

    /* renamed from: CU */
    public static final Api.C0268c<C2269aw> f4654CU = new Api.C0268c<>();

    /* renamed from: CV */
    private static final Api.C0267b<C2269aw, WearableOptions> f4655CV = new Api.C0267b<C2269aw, WearableOptions>() {
        /* renamed from: a */
        public C2269aw mo3762a(Context context, Looper looper, ClientSettings clientSettings, WearableOptions wearableOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            if (wearableOptions == null) {
                new WearableOptions(new WearableOptions.Builder());
            }
            return new C2269aw(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    };
    public static final DataApi DataApi = new C2290f();
    public static final MessageApi MessageApi = new C2243ag();
    public static final NodeApi NodeApi = new C2250aj();
    public static final C2226b auQ = new C2289e();

    public static final class WearableOptions implements Api.ApiOptions.Optional {

        public static class Builder {
            public WearableOptions build() {
                return new WearableOptions(this);
            }
        }

        private WearableOptions(Builder builder) {
        }
    }

    private Wearable() {
    }
}
