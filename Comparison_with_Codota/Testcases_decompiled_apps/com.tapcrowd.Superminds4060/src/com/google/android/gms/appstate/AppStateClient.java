package com.google.android.gms.appstate;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.internal.C0362cw;
import com.google.android.gms.internal.C0411dm;

public final class AppStateClient implements GooglePlayServicesClient {
    public static final int STATUS_CLIENT_RECONNECT_REQUIRED = 2;
    public static final int STATUS_DEVELOPER_ERROR = 7;
    public static final int STATUS_INTERNAL_ERROR = 1;
    public static final int STATUS_NETWORK_ERROR_NO_DATA = 4;
    public static final int STATUS_NETWORK_ERROR_OPERATION_DEFERRED = 5;
    public static final int STATUS_NETWORK_ERROR_OPERATION_FAILED = 6;
    public static final int STATUS_NETWORK_ERROR_STALE_DATA = 3;
    public static final int STATUS_OK = 0;
    public static final int STATUS_STATE_KEY_LIMIT_EXCEEDED = 2003;
    public static final int STATUS_STATE_KEY_NOT_FOUND = 2002;
    public static final int STATUS_WRITE_OUT_OF_DATE_VERSION = 2000;
    public static final int STATUS_WRITE_SIZE_EXCEEDED = 2001;

    /* renamed from: io */
    private final C0362cw f328io;

    public static final class Builder {

        /* renamed from: ip */
        private static final String[] f329ip = {Scopes.APP_STATE};

        /* renamed from: iq */
        private GooglePlayServicesClient.ConnectionCallbacks f330iq;

        /* renamed from: ir */
        private GooglePlayServicesClient.OnConnectionFailedListener f331ir;

        /* renamed from: is */
        private String[] f332is = f329ip;

        /* renamed from: it */
        private String f333it = "<<default account>>";
        private Context mContext;

        public Builder(Context context, GooglePlayServicesClient.ConnectionCallbacks connectedListener, GooglePlayServicesClient.OnConnectionFailedListener connectionFailedListener) {
            this.mContext = context;
            this.f330iq = connectedListener;
            this.f331ir = connectionFailedListener;
        }

        public AppStateClient create() {
            return new AppStateClient(this.mContext, this.f330iq, this.f331ir, this.f333it, this.f332is);
        }

        public Builder setAccountName(String accountName) {
            this.f333it = (String) C0411dm.m944e(accountName);
            return this;
        }

        public Builder setScopes(String... scopes) {
            this.f332is = scopes;
            return this;
        }
    }

    private AppStateClient(Context context, GooglePlayServicesClient.ConnectionCallbacks connectedListener, GooglePlayServicesClient.OnConnectionFailedListener connectionFailedListener, String accountName, String[] scopes) {
        this.f328io = new C0362cw(context, connectedListener, connectionFailedListener, accountName, scopes);
    }

    public void connect() {
        this.f328io.connect();
    }

    public void deleteState(OnStateDeletedListener listener, int stateKey) {
        this.f328io.deleteState(listener, stateKey);
    }

    public void disconnect() {
        this.f328io.disconnect();
    }

    public int getMaxNumKeys() {
        return this.f328io.getMaxNumKeys();
    }

    public int getMaxStateSize() {
        return this.f328io.getMaxStateSize();
    }

    public boolean isConnected() {
        return this.f328io.isConnected();
    }

    public boolean isConnecting() {
        return this.f328io.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks listener) {
        return this.f328io.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        return this.f328io.isConnectionFailedListenerRegistered(listener);
    }

    public void listStates(OnStateListLoadedListener listener) {
        this.f328io.listStates(listener);
    }

    public void loadState(OnStateLoadedListener listener, int stateKey) {
        this.f328io.loadState(listener, stateKey);
    }

    public void reconnect() {
        this.f328io.disconnect();
        this.f328io.connect();
    }

    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.f328io.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.f328io.registerConnectionFailedListener(listener);
    }

    public void resolveState(OnStateLoadedListener listener, int stateKey, String resolvedVersion, byte[] resolvedData) {
        this.f328io.resolveState(listener, stateKey, resolvedVersion, resolvedData);
    }

    public void signOut() {
        this.f328io.signOut((OnSignOutCompleteListener) null);
    }

    public void signOut(OnSignOutCompleteListener listener) {
        C0411dm.m940a(listener, (Object) "Must provide a valid listener");
        this.f328io.signOut(listener);
    }

    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.f328io.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.f328io.unregisterConnectionFailedListener(listener);
    }

    public void updateState(int stateKey, byte[] data) {
        this.f328io.mo4259a((OnStateLoadedListener) null, stateKey, data);
    }

    public void updateStateImmediate(OnStateLoadedListener listener, int stateKey, byte[] data) {
        C0411dm.m940a(listener, (Object) "Must provide a valid listener");
        this.f328io.mo4259a(listener, stateKey, data);
    }
}
