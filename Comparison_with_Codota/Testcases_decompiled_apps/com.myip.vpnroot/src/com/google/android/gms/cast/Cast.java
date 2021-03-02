package com.google.android.gms.cast;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.support.p003v7.internal.widget.ActivityChooserView;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.C1317ij;
import java.io.IOException;

public final class Cast {
    public static final Api<CastOptions> API = new Api<>(f397CV, f396CU, new Scope[0]);

    /* renamed from: CU */
    static final Api.C0268c<C1317ij> f396CU = new Api.C0268c<>();

    /* renamed from: CV */
    private static final Api.C0267b<C1317ij, CastOptions> f397CV = new Api.C0267b<C1317ij, CastOptions>() {
        /* renamed from: a */
        public C1317ij mo3762a(Context context, Looper looper, ClientSettings clientSettings, CastOptions castOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            C0348n.m857b(castOptions, (Object) "Setting the API options is required.");
            return new C1317ij(context, looper, castOptions.f416EK, (long) castOptions.f418EM, castOptions.f417EL, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    };
    public static final CastApi CastApi = new CastApi.C0230a();
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    public interface CastApi {

        /* renamed from: com.google.android.gms.cast.Cast$CastApi$a */
        public static final class C0230a implements CastApi {
            public ApplicationMetadata getApplicationMetadata(GoogleApiClient client) throws IllegalStateException {
                return ((C1317ij) client.mo4218a(Cast.f396CU)).getApplicationMetadata();
            }

            public String getApplicationStatus(GoogleApiClient client) throws IllegalStateException {
                return ((C1317ij) client.mo4218a(Cast.f396CU)).getApplicationStatus();
            }

            public double getVolume(GoogleApiClient client) throws IllegalStateException {
                return ((C1317ij) client.mo4218a(Cast.f396CU)).mo8853fF();
            }

            public boolean isMute(GoogleApiClient client) throws IllegalStateException {
                return ((C1317ij) client.mo4218a(Cast.f396CU)).isMute();
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client) {
                return client.mo4221b(new C0242c() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3769a(C1317ij ijVar) throws RemoteException {
                        try {
                            ijVar.mo8850b((String) null, (String) null, this);
                        } catch (IllegalStateException e) {
                            mo3934V(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId) {
                return client.mo4221b(new C0242c() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3769a(C1317ij ijVar) throws RemoteException {
                        try {
                            ijVar.mo8850b(applicationId, (String) null, this);
                        } catch (IllegalStateException e) {
                            mo3934V(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId, final String sessionId) {
                return client.mo4221b(new C0242c() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3769a(C1317ij ijVar) throws RemoteException {
                        try {
                            ijVar.mo8850b(applicationId, sessionId, this);
                        } catch (IllegalStateException e) {
                            mo3934V(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId) {
                return client.mo4221b(new C0242c() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3769a(C1317ij ijVar) throws RemoteException {
                        try {
                            ijVar.mo8848a(applicationId, false, (BaseImplementation.C0270b<ApplicationConnectionResult>) this);
                        } catch (IllegalStateException e) {
                            mo3934V(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId, final LaunchOptions options) {
                return client.mo4221b(new C0242c() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3769a(C1317ij ijVar) throws RemoteException {
                        try {
                            ijVar.mo8845a(applicationId, options, (BaseImplementation.C0270b<ApplicationConnectionResult>) this);
                        } catch (IllegalStateException e) {
                            mo3934V(2001);
                        }
                    }
                });
            }

            @Deprecated
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId, boolean relaunchIfRunning) {
                return launchApplication(client, applicationId, new LaunchOptions.Builder().setRelaunchIfRunning(relaunchIfRunning).build());
            }

            public PendingResult<Status> leaveApplication(GoogleApiClient client) {
                return client.mo4221b(new C0241b() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3769a(C1317ij ijVar) throws RemoteException {
                        try {
                            ijVar.mo8851d((BaseImplementation.C0270b<Status>) this);
                        } catch (IllegalStateException e) {
                            mo3934V(2001);
                        }
                    }
                });
            }

            public void removeMessageReceivedCallbacks(GoogleApiClient client, String namespace) throws IOException, IllegalArgumentException {
                try {
                    ((C1317ij) client.mo4218a(Cast.f396CU)).mo8849aE(namespace);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void requestStatus(GoogleApiClient client) throws IOException, IllegalStateException {
                try {
                    ((C1317ij) client.mo4218a(Cast.f396CU)).mo8852fE();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> sendMessage(GoogleApiClient client, final String namespace, final String message) {
                return client.mo4221b(new C0241b() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3769a(C1317ij ijVar) throws RemoteException {
                        try {
                            ijVar.mo8847a(namespace, message, (BaseImplementation.C0270b<Status>) this);
                        } catch (IllegalArgumentException e) {
                            mo3934V(2001);
                        } catch (IllegalStateException e2) {
                            mo3934V(2001);
                        }
                    }
                });
            }

            public void setMessageReceivedCallbacks(GoogleApiClient client, String namespace, MessageReceivedCallback callbacks) throws IOException, IllegalStateException {
                try {
                    ((C1317ij) client.mo4218a(Cast.f396CU)).mo8844a(namespace, callbacks);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setMute(GoogleApiClient client, boolean mute) throws IOException, IllegalStateException {
                try {
                    ((C1317ij) client.mo4218a(Cast.f396CU)).mo8841G(mute);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setVolume(GoogleApiClient client, double volume) throws IOException, IllegalArgumentException, IllegalStateException {
                try {
                    ((C1317ij) client.mo4218a(Cast.f396CU)).mo8843a(volume);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client) {
                return client.mo4221b(new C0241b() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3769a(C1317ij ijVar) throws RemoteException {
                        try {
                            ijVar.mo8846a("", (BaseImplementation.C0270b<Status>) this);
                        } catch (IllegalStateException e) {
                            mo3934V(2001);
                        }
                    }
                });
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client, final String sessionId) {
                return client.mo4221b(new C0241b() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3769a(C1317ij ijVar) throws RemoteException {
                        if (TextUtils.isEmpty(sessionId)) {
                            mo3935e(2001, "IllegalArgument: sessionId cannot be null or empty");
                            return;
                        }
                        try {
                            ijVar.mo8846a(sessionId, (BaseImplementation.C0270b<Status>) this);
                        } catch (IllegalStateException e) {
                            mo3934V(2001);
                        }
                    }
                });
            }
        }

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static final class CastOptions implements Api.ApiOptions.HasOptions {

        /* renamed from: EK */
        final CastDevice f416EK;

        /* renamed from: EL */
        final Listener f417EL;
        /* access modifiers changed from: private */

        /* renamed from: EM */
        public final int f418EM;

        public static final class Builder {

            /* renamed from: EN */
            CastDevice f419EN;

            /* renamed from: EO */
            Listener f420EO;
            /* access modifiers changed from: private */

            /* renamed from: EP */
            public int f421EP;

            private Builder(CastDevice castDevice, Listener castListener) {
                C0348n.m857b(castDevice, (Object) "CastDevice parameter cannot be null");
                C0348n.m857b(castListener, (Object) "CastListener parameter cannot be null");
                this.f419EN = castDevice;
                this.f420EO = castListener;
                this.f421EP = 0;
            }

            public CastOptions build() {
                return new CastOptions(this);
            }

            public Builder setVerboseLoggingEnabled(boolean enabled) {
                if (enabled) {
                    this.f421EP |= 1;
                } else {
                    this.f421EP &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.f416EK = builder.f419EN;
            this.f417EL = builder.f420EO;
            this.f418EM = builder.f421EP;
        }

        public static Builder builder(CastDevice castDevice, Listener castListener) {
            return new Builder(castDevice, castListener);
        }
    }

    public static class Listener {
        /* renamed from: W */
        public void mo3928W(int i) {
        }

        /* renamed from: X */
        public void mo3929X(int i) {
        }

        public void onApplicationDisconnected(int statusCode) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    /* renamed from: com.google.android.gms.cast.Cast$a */
    protected static abstract class C0240a<R extends Result> extends BaseImplementation.C0269a<R, C1317ij> {
        public C0240a() {
            super(Cast.f396CU);
        }

        /* renamed from: V */
        public void mo3934V(int i) {
            mo4196b(mo3773c(new Status(i)));
        }

        /* renamed from: e */
        public void mo3935e(int i, String str) {
            mo4196b(mo3773c(new Status(i, str, (PendingIntent) null)));
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast$b */
    private static abstract class C0241b extends C0240a<Status> {
        private C0241b() {
        }

        /* renamed from: d */
        public Status mo3773c(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast$c */
    private static abstract class C0242c extends C0240a<ApplicationConnectionResult> {
        private C0242c() {
        }

        /* renamed from: j */
        public ApplicationConnectionResult mo3773c(final Status status) {
            return new ApplicationConnectionResult() {
                public ApplicationMetadata getApplicationMetadata() {
                    return null;
                }

                public String getApplicationStatus() {
                    return null;
                }

                public String getSessionId() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public boolean getWasLaunched() {
                    return false;
                }
            };
        }
    }

    private Cast() {
    }
}
