package com.tapcrowd.tcanalytics.utils.geofence;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.LocationClient;
import com.tapcrowd.tcanalytics.C1271DB;
import java.util.ArrayList;
import java.util.List;

public class GeofenceRequester implements LocationClient.OnAddGeofencesResultListener, GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener {
    private final Context context;
    private ArrayList<Geofence> mCurrentGeofences;
    private PendingIntent mGeofencePendingIntent = null;
    private boolean mInProgress = false;
    private LocationClient mLocationClient = null;

    public GeofenceRequester(Context context2) {
        this.context = context2;
    }

    public void setInProgressFlag(boolean flag) {
        this.mInProgress = flag;
    }

    public boolean getInProgressFlag() {
        return this.mInProgress;
    }

    public PendingIntent getRequestPendingIntent() {
        return createRequestPendingIntent(this.context);
    }

    public void addGeofences(List<Geofence> geofences) throws UnsupportedOperationException {
        this.mCurrentGeofences = (ArrayList) geofences;
        if (!this.mInProgress) {
            this.mInProgress = true;
            requestConnection();
            return;
        }
        throw new UnsupportedOperationException();
    }

    private void requestConnection() {
        getLocationClient().connect();
    }

    private GooglePlayServicesClient getLocationClient() {
        if (this.mLocationClient == null) {
            this.mLocationClient = new LocationClient(this.context, this, this);
        }
        return this.mLocationClient;
    }

    private void continueAddGeofences() {
        this.mGeofencePendingIntent = createRequestPendingIntent(this.context);
        if (this.mCurrentGeofences.size() > 0) {
            this.mLocationClient.addGeofences(this.mCurrentGeofences, this.mGeofencePendingIntent, this);
        }
    }

    public void onAddGeofencesResult(int statusCode, String[] geofenceRequestIds) {
        requestDisconnection();
    }

    private void requestDisconnection() {
        this.mInProgress = false;
        getLocationClient().disconnect();
    }

    public void onConnected(Bundle arg0) {
        continueAddGeofences();
    }

    public void onDisconnected() {
        this.mInProgress = false;
        this.mLocationClient = null;
    }

    public static PendingIntent createRequestPendingIntent(Context context2) {
        Intent intent = new Intent("com.tapcrowd.taptarget.geofence.ACTION_RECEIVE_GEOFENCE");
        intent.putExtra("PACKAGE", C1271DB.getTapTargetBundleid(context2));
        return PendingIntent.getBroadcast(context2, 0, intent, 134217728);
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.mInProgress = false;
        if (connectionResult.hasResolution()) {
            try {
                if (this.context instanceof Activity) {
                    connectionResult.startResolutionForResult((Activity) this.context, GeofenceUtils.CONNECTION_FAILURE_RESOLUTION_REQUEST);
                }
            } catch (IntentSender.SendIntentException e) {
                e.printStackTrace();
            }
        }
    }
}
