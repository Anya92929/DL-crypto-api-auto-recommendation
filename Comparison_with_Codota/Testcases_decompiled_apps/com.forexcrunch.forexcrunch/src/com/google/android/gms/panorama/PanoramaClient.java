package com.google.android.gms.panorama;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.C0514bn;

public class PanoramaClient implements GooglePlayServicesClient {

    /* renamed from: hN */
    private final C0514bn f1649hN;

    public interface OnPanoramaInfoLoadedListener {
        void onPanoramaInfoLoaded(ConnectionResult connectionResult, Intent intent);
    }

    /* renamed from: com.google.android.gms.panorama.PanoramaClient$a */
    public interface C0745a {
        /* renamed from: a */
        void mo6307a(ConnectionResult connectionResult, int i, Intent intent);
    }

    public PanoramaClient(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener connectionFailedListener) {
        this.f1649hN = new C0514bn(context, connectionCallbacks, connectionFailedListener);
    }

    public void connect() {
        this.f1649hN.connect();
    }

    public void disconnect() {
        this.f1649hN.disconnect();
    }

    public boolean isConnected() {
        return this.f1649hN.isConnected();
    }

    public boolean isConnecting() {
        return this.f1649hN.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks listener) {
        return this.f1649hN.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        return this.f1649hN.isConnectionFailedListenerRegistered(listener);
    }

    public void loadPanoramaInfo(OnPanoramaInfoLoadedListener listener, Uri uri) {
        this.f1649hN.mo4843a(listener, uri, false);
    }

    public void loadPanoramaInfoAndGrantAccess(OnPanoramaInfoLoadedListener listener, Uri uri) {
        this.f1649hN.mo4843a(listener, uri, true);
    }

    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.f1649hN.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.f1649hN.registerConnectionFailedListener(listener);
    }

    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.f1649hN.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.f1649hN.unregisterConnectionFailedListener(listener);
    }
}
