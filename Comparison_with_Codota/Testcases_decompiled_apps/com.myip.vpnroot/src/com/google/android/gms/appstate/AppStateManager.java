package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import android.support.p003v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.C1298ib;

public final class AppStateManager {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>(f335CV, f334CU, SCOPE_APP_STATE);

    /* renamed from: CU */
    static final Api.C0268c<C1298ib> f334CU = new Api.C0268c<>();

    /* renamed from: CV */
    private static final Api.C0267b<C1298ib, Api.ApiOptions.NoOptions> f335CV = new Api.C0267b<C1298ib, Api.ApiOptions.NoOptions>() {
        /* renamed from: b */
        public C1298ib mo3762a(Context context, Looper looper, ClientSettings clientSettings, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new C1298ib(context, looper, connectionCallbacks, onConnectionFailedListener, clientSettings.getAccountNameOrDefault(), (String[]) clientSettings.getScopes().toArray(new String[0]));
        }

        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    };
    public static final Scope SCOPE_APP_STATE = new Scope(Scopes.APP_STATE);

    public interface StateConflictResult extends Releasable, Result {
        byte[] getLocalData();

        String getResolvedVersion();

        byte[] getServerData();

        int getStateKey();
    }

    public interface StateDeletedResult extends Result {
        int getStateKey();
    }

    public interface StateListResult extends Result {
        AppStateBuffer getStateBuffer();
    }

    public interface StateLoadedResult extends Releasable, Result {
        byte[] getLocalData();

        int getStateKey();
    }

    public interface StateResult extends Releasable, Result {
        StateConflictResult getConflictResult();

        StateLoadedResult getLoadedResult();
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$a */
    public static abstract class C0218a<R extends Result> extends BaseImplementation.C0269a<R, C1298ib> {
        public C0218a() {
            super(AppStateManager.f334CU);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$b */
    private static abstract class C0219b extends C0218a<StateDeletedResult> {
        private C0219b() {
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$c */
    private static abstract class C0220c extends C0218a<StateListResult> {
        private C0220c() {
        }

        /* renamed from: h */
        public StateListResult mo3773c(final Status status) {
            return new StateListResult() {
                public AppStateBuffer getStateBuffer() {
                    return new AppStateBuffer((DataHolder) null);
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$d */
    private static abstract class C0222d extends C0218a<Status> {
        private C0222d() {
        }

        /* renamed from: d */
        public Status mo3773c(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$e */
    private static abstract class C0223e extends C0218a<StateResult> {
        private C0223e() {
        }

        /* renamed from: i */
        public StateResult mo3773c(Status status) {
            return AppStateManager.m312e(status);
        }
    }

    private AppStateManager() {
    }

    /* renamed from: a */
    public static C1298ib m311a(GoogleApiClient googleApiClient) {
        boolean z = true;
        C0348n.m859b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        C0348n.m852a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        C1298ib ibVar = (C1298ib) googleApiClient.mo4218a(f334CU);
        if (ibVar == null) {
            z = false;
        }
        C0348n.m852a(z, "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return ibVar;
    }

    public static PendingResult<StateDeletedResult> delete(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.mo4221b(new C0219b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1298ib ibVar) {
                ibVar.mo8802a((BaseImplementation.C0270b<StateDeletedResult>) this, stateKey);
            }

            /* renamed from: g */
            public StateDeletedResult mo3773c(final Status status) {
                return new StateDeletedResult() {
                    public int getStateKey() {
                        return stateKey;
                    }

                    public Status getStatus() {
                        return status;
                    }
                };
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static StateResult m312e(final Status status) {
        return new StateResult() {
            public StateConflictResult getConflictResult() {
                return null;
            }

            public StateLoadedResult getLoadedResult() {
                return null;
            }

            public Status getStatus() {
                return status;
            }

            public void release() {
            }
        };
    }

    public static int getMaxNumKeys(GoogleApiClient googleApiClient) {
        return m311a(googleApiClient).mo8808fs();
    }

    public static int getMaxStateSize(GoogleApiClient googleApiClient) {
        return m311a(googleApiClient).mo8807fr();
    }

    public static PendingResult<StateListResult> list(GoogleApiClient googleApiClient) {
        return googleApiClient.mo4219a(new C0220c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1298ib ibVar) {
                ibVar.mo8801a(this);
            }
        });
    }

    public static PendingResult<StateResult> load(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.mo4219a(new C0223e() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1298ib ibVar) {
                ibVar.mo8806b(this, stateKey);
            }
        });
    }

    public static PendingResult<StateResult> resolve(GoogleApiClient googleApiClient, final int stateKey, final String resolvedVersion, final byte[] resolvedData) {
        return googleApiClient.mo4221b(new C0223e() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1298ib ibVar) {
                ibVar.mo8803a(this, stateKey, resolvedVersion, resolvedData);
            }
        });
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.mo4221b(new C0222d() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1298ib ibVar) {
                ibVar.mo8805b(this);
            }
        });
    }

    public static void update(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        googleApiClient.mo4221b(new C0223e() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1298ib ibVar) {
                ibVar.mo8804a((BaseImplementation.C0270b<StateResult>) null, stateKey, data);
            }
        });
    }

    public static PendingResult<StateResult> updateImmediate(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        return googleApiClient.mo4221b(new C0223e() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3769a(C1298ib ibVar) {
                ibVar.mo8804a(this, stateKey, data);
            }
        });
    }
}
