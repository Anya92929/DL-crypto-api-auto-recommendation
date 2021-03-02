package com.google.android.gms.internal;

import android.support.p009v4.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class zzpu extends GoogleApiClient {

    /* renamed from: a */
    private final UnsupportedOperationException f6812a;

    public zzpu(String str) {
        this.f6812a = new UnsupportedOperationException(str);
    }

    public ConnectionResult blockingConnect() {
        throw this.f6812a;
    }

    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        throw this.f6812a;
    }

    public PendingResult clearDefaultAccountAndReconnect() {
        throw this.f6812a;
    }

    public void connect() {
        throw this.f6812a;
    }

    public void disconnect() {
        throw this.f6812a;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        throw this.f6812a;
    }

    public ConnectionResult getConnectionResult(Api api) {
        throw this.f6812a;
    }

    public boolean hasConnectedApi(Api api) {
        throw this.f6812a;
    }

    public boolean isConnected() {
        throw this.f6812a;
    }

    public boolean isConnecting() {
        throw this.f6812a;
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        throw this.f6812a;
    }

    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw this.f6812a;
    }

    public void reconnect() {
        throw this.f6812a;
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        throw this.f6812a;
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw this.f6812a;
    }

    public void stopAutoManage(FragmentActivity fragmentActivity) {
        throw this.f6812a;
    }

    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        throw this.f6812a;
    }

    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw this.f6812a;
    }
}
