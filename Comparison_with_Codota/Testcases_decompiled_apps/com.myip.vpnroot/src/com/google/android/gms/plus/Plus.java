package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.C1612no;
import com.google.android.gms.internal.C1615np;
import com.google.android.gms.internal.C1616nq;
import com.google.android.gms.internal.C1617nr;
import com.google.android.gms.internal.C1626ns;
import com.google.android.gms.plus.internal.C1955e;
import com.google.android.gms.plus.internal.C1966h;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api<PlusOptions> API = new Api<>(f4497CV, f4496CU, new Scope[0]);
    public static final Account AccountApi = new C1612no();

    /* renamed from: CU */
    public static final Api.C0268c<C1955e> f4496CU = new Api.C0268c<>();

    /* renamed from: CV */
    static final Api.C0267b<C1955e, PlusOptions> f4497CV = new Api.C0267b<C1955e, PlusOptions>() {
        /* renamed from: a */
        public C1955e mo3762a(Context context, Looper looper, ClientSettings clientSettings, PlusOptions plusOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            if (plusOptions == null) {
                plusOptions = new PlusOptions();
            }
            return new C1955e(context, looper, connectionCallbacks, onConnectionFailedListener, new C1966h(clientSettings.getAccountNameOrDefault(), clientSettings.getScopesArray(), (String[]) plusOptions.akR.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), (String) null, new PlusCommonExtras()));
        }

        public int getPriority() {
            return 2;
        }
    };
    public static final Moments MomentsApi = new C1617nr();
    public static final People PeopleApi = new C1626ns();
    public static final Scope SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
    public static final Scope SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
    public static final C1944b akO = new C1616nq();
    public static final C1943a akP = new C1615np();

    public static final class PlusOptions implements Api.ApiOptions.Optional {
        final String akQ;
        final Set<String> akR;

        public static final class Builder {
            String akQ;
            final Set<String> akR = new HashSet();

            public Builder addActivityTypes(String... activityTypes) {
                C0348n.m857b(activityTypes, (Object) "activityTypes may not be null.");
                for (String add : activityTypes) {
                    this.akR.add(add);
                }
                return this;
            }

            public PlusOptions build() {
                return new PlusOptions(this);
            }

            public Builder setServerClientId(String clientId) {
                this.akQ = clientId;
                return this;
            }
        }

        private PlusOptions() {
            this.akQ = null;
            this.akR = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.akQ = builder.akQ;
            this.akR = builder.akR;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    /* renamed from: com.google.android.gms.plus.Plus$a */
    public static abstract class C1930a<R extends Result> extends BaseImplementation.C0269a<R, C1955e> {
        public C1930a() {
            super(Plus.f4496CU);
        }
    }

    private Plus() {
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.android.gms.common.api.Api$c, com.google.android.gms.common.api.Api$c<com.google.android.gms.plus.internal.e>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.plus.internal.C1955e m6516a(com.google.android.gms.common.api.GoogleApiClient r4, com.google.android.gms.common.api.Api.C0268c<com.google.android.gms.plus.internal.C1955e> r5) {
        /*
            r1 = 1
            r2 = 0
            if (r4 == 0) goto L_0x0021
            r0 = r1
        L_0x0005:
            java.lang.String r3 = "GoogleApiClient parameter is required."
            com.google.android.gms.common.internal.C0348n.m859b((boolean) r0, (java.lang.Object) r3)
            boolean r0 = r4.isConnected()
            java.lang.String r3 = "GoogleApiClient must be connected."
            com.google.android.gms.common.internal.C0348n.m852a(r0, r3)
            com.google.android.gms.common.api.Api$a r0 = r4.mo4218a(r5)
            com.google.android.gms.plus.internal.e r0 = (com.google.android.gms.plus.internal.C1955e) r0
            if (r0 == 0) goto L_0x0023
        L_0x001b:
            java.lang.String r2 = "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature."
            com.google.android.gms.common.internal.C0348n.m852a(r1, r2)
            return r0
        L_0x0021:
            r0 = r2
            goto L_0x0005
        L_0x0023:
            r1 = r2
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.plus.Plus.m6516a(com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.common.api.Api$c):com.google.android.gms.plus.internal.e");
    }
}
