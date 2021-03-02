package com.google.android.gms.appstate;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.internal.C0545c;
import com.google.android.gms.internal.C0621s;

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

    /* renamed from: b */
    private final C0545c f755b;

    public static final class Builder {

        /* renamed from: c */
        private static final String[] f756c = {Scopes.APP_STATE};

        /* renamed from: d */
        private GooglePlayServicesClient.ConnectionCallbacks f757d;

        /* renamed from: e */
        private GooglePlayServicesClient.OnConnectionFailedListener f758e;

        /* renamed from: f */
        private String[] f759f = f756c;

        /* renamed from: g */
        private String f760g = "<<default account>>";
        private Context mContext;

        public Builder(Context context, GooglePlayServicesClient.ConnectionCallbacks connectedListener, GooglePlayServicesClient.OnConnectionFailedListener connectionFailedListener) {
            this.mContext = context;
            this.f757d = connectedListener;
            this.f758e = connectionFailedListener;
        }

        public AppStateClient create() {
            return new AppStateClient(this.mContext, this.f757d, this.f758e, this.f760g, this.f759f);
        }

        public Builder setAccountName(String accountName) {
            this.f760g = (String) C0621s.m1890d(accountName);
            return this;
        }

        public Builder setScopes(String... scopes) {
            this.f759f = scopes;
            return this;
        }
    }

    private AppStateClient(Context context, GooglePlayServicesClient.ConnectionCallbacks connectedListener, GooglePlayServicesClient.OnConnectionFailedListener connectionFailedListener, String accountName, String[] scopes) {
        this.f755b = new C0545c(context, connectedListener, connectionFailedListener, accountName, scopes);
    }

    public void connect() {
        this.f755b.connect();
    }

    public void deleteState(OnStateDeletedListener listener, int stateKey) {
        this.f755b.deleteState(listener, stateKey);
    }

    public void disconnect() {
        this.f755b.disconnect();
    }

    public int getMaxNumKeys() {
        return this.f755b.getMaxNumKeys();
    }

    public int getMaxStateSize() {
        return this.f755b.getMaxStateSize();
    }

    public boolean isConnected() {
        return this.f755b.isConnected();
    }

    public boolean isConnecting() {
        return this.f755b.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks listener) {
        return this.f755b.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        return this.f755b.isConnectionFailedListenerRegistered(listener);
    }

    public void listStates(OnStateListLoadedListener listener) {
        this.f755b.listStates(listener);
    }

    public void loadState(OnStateLoadedListener listener, int stateKey) {
        this.f755b.loadState(listener, stateKey);
    }

    public void reconnect() {
        this.f755b.disconnect();
        this.f755b.connect();
    }

    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.f755b.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.f755b.registerConnectionFailedListener(listener);
    }

    public void resolveState(OnStateLoadedListener listener, int stateKey, String resolvedVersion, byte[] resolvedData) {
        this.f755b.resolveState(listener, stateKey, resolvedVersion, resolvedData);
    }

    public void signOut() {
        this.f755b.signOut((OnSignOutCompleteListener) null);
    }

    public void signOut(OnSignOutCompleteListener listener) {
        C0621s.m1887b(listener, (Object) "Must provide a valid listener");
        this.f755b.signOut(listener);
    }

    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.f755b.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.f755b.unregisterConnectionFailedListener(listener);
    }

    public void updateState(int stateKey, byte[] data) {
        this.f755b.mo5096a((OnStateLoadedListener) null, stateKey, data);
    }

    public void updateStateImmediate(OnStateLoadedListener listener, int stateKey, byte[] data) {
        C0621s.m1887b(listener, (Object) "Must provide a valid listener");
        this.f755b.mo5096a(listener, stateKey, data);
    }
}
