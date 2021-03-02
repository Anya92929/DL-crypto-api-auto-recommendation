package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import android.support.p003v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.C1512lq;
import com.google.android.gms.internal.C1544ly;

public class ActivityRecognition {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>(f4413CV, f4412CU, new Scope[0]);
    public static ActivityRecognitionApi ActivityRecognitionApi = new C1512lq();
    public static final String CLIENT_NAME = "activity_recognition";
    /* access modifiers changed from: private */

    /* renamed from: CU */
    public static final Api.C0268c<C1544ly> f4412CU = new Api.C0268c<>();

    /* renamed from: CV */
    private static final Api.C0267b<C1544ly, Api.ApiOptions.NoOptions> f4413CV = new Api.C0267b<C1544ly, Api.ApiOptions.NoOptions>() {
        /* renamed from: d */
        public C1544ly mo3762a(Context context, Looper looper, ClientSettings clientSettings, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new C1544ly(context, looper, context.getPackageName(), connectionCallbacks, onConnectionFailedListener, ActivityRecognition.CLIENT_NAME);
        }

        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    };

    /* renamed from: com.google.android.gms.location.ActivityRecognition$a */
    public static abstract class C1749a<R extends Result> extends BaseImplementation.C0269a<R, C1544ly> {
        public C1749a() {
            super(ActivityRecognition.f4412CU);
        }
    }

    private ActivityRecognition() {
    }
}
