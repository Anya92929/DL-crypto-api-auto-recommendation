package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.p000v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.ClientSettings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface GoogleApiClient {

    public static final class Builder {

        /* renamed from: Dd */
        private String f578Dd;

        /* renamed from: IB */
        private Looper f579IB;

        /* renamed from: IE */
        private final Set<String> f580IE;

        /* renamed from: IF */
        private int f581IF;

        /* renamed from: IG */
        private View f582IG;

        /* renamed from: IH */
        private String f583IH;

        /* renamed from: II */
        private final Map<Api<?>, Api.ApiOptions> f584II;

        /* renamed from: IJ */
        private FragmentActivity f585IJ;

        /* renamed from: IK */
        private int f586IK;

        /* renamed from: IL */
        private OnConnectionFailedListener f587IL;

        /* renamed from: IM */
        private final Set<ConnectionCallbacks> f588IM;

        /* renamed from: IN */
        private final Set<OnConnectionFailedListener> f589IN;
        private final Context mContext;

        public Builder(Context context) {
            this.f580IE = new HashSet();
            this.f584II = new HashMap();
            this.f586IK = -1;
            this.f588IM = new HashSet();
            this.f589IN = new HashSet();
            this.mContext = context;
            this.f579IB = context.getMainLooper();
            this.f583IH = context.getPackageName();
        }

        public Builder(Context context, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener) {
            this(context);
            C0348n.m857b(connectedListener, (Object) "Must provide a connected listener");
            this.f588IM.add(connectedListener);
            C0348n.m857b(connectionFailedListener, (Object) "Must provide a connection failed listener");
            this.f589IN.add(connectionFailedListener);
        }

        /* renamed from: gm */
        private GoogleApiClient m523gm() {
            C0285d a = C0285d.m570a(this.f585IJ);
            GoogleApiClient ak = a.mo4286ak(this.f586IK);
            if (ak == null) {
                ak = new C0274b(this.mContext.getApplicationContext(), this.f579IB, mo4245gl(), this.f584II, this.f588IM, this.f589IN, this.f586IK);
            }
            a.mo4284a(this.f586IK, ak, this.f587IL);
            return ak;
        }

        public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            this.f584II.put(api, (Object) null);
            List<Scope> ge = api.mo4184ge();
            int size = ge.size();
            for (int i = 0; i < size; i++) {
                this.f580IE.add(ge.get(i).mo4253gt());
            }
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> api, O options) {
            C0348n.m857b(options, (Object) "Null options are not permitted for this Api");
            this.f584II.put(api, options);
            List<Scope> ge = api.mo4184ge();
            int size = ge.size();
            for (int i = 0; i < size; i++) {
                this.f580IE.add(ge.get(i).mo4253gt());
            }
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks listener) {
            this.f588IM.add(listener);
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener listener) {
            this.f589IN.add(listener);
            return this;
        }

        public Builder addScope(Scope scope) {
            this.f580IE.add(scope.mo4253gt());
            return this;
        }

        public GoogleApiClient build() {
            C0348n.m859b(!this.f584II.isEmpty(), (Object) "must call addApi() to add at least one API");
            return this.f586IK >= 0 ? m523gm() : new C0274b(this.mContext, this.f579IB, mo4245gl(), this.f584II, this.f588IM, this.f589IN, -1);
        }

        public Builder enableAutoManage(FragmentActivity fragmentActivity, int clientId, OnConnectionFailedListener unresolvedConnectionFailedListener) {
            C0348n.m859b(clientId >= 0, (Object) "clientId must be non-negative");
            this.f586IK = clientId;
            this.f585IJ = (FragmentActivity) C0348n.m857b(fragmentActivity, (Object) "Null activity is not permitted.");
            this.f587IL = unresolvedConnectionFailedListener;
            return this;
        }

        /* renamed from: gl */
        public ClientSettings mo4245gl() {
            return new ClientSettings(this.f578Dd, this.f580IE, this.f581IF, this.f582IG, this.f583IH);
        }

        public Builder setAccountName(String accountName) {
            this.f578Dd = accountName;
            return this;
        }

        public Builder setGravityForPopups(int gravityForPopups) {
            this.f581IF = gravityForPopups;
            return this;
        }

        public Builder setHandler(Handler handler) {
            C0348n.m857b(handler, (Object) "Handler must not be null");
            this.f579IB = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(View viewForPopups) {
            this.f582IG = viewForPopups;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener extends GooglePlayServicesClient.OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    /* renamed from: a */
    <C extends Api.C0266a> C mo4218a(Api.C0268c<C> cVar);

    /* renamed from: a */
    <A extends Api.C0266a, R extends Result, T extends BaseImplementation.C0269a<R, A>> T mo4219a(T t);

    /* renamed from: a */
    boolean mo4220a(Scope scope);

    /* renamed from: b */
    <A extends Api.C0266a, T extends BaseImplementation.C0269a<? extends Result, A>> T mo4221b(T t);

    ConnectionResult blockingConnect();

    ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    /* renamed from: c */
    <L> C0282c<L> mo4224c(L l);

    void connect();

    void disconnect();

    Looper getLooper();

    boolean isConnected();

    boolean isConnecting();

    boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    void reconnect();

    void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    void stopAutoManage(FragmentActivity fragmentActivity);

    void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);
}
