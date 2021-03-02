package com.tapcrowd.tcanalytics.utils.geofence;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.tapcrowd.tcanalytics.utils.geofence.GeofenceUtils;
import java.util.List;

public class GeofenceRemover implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener, LocationClient.OnRemoveGeofencesResultListener {

    /* renamed from: $SWITCH_TABLE$com$tapcrowd$tcanalytics$utils$geofence$GeofenceUtils$REMOVE_TYPE */
    private static /* synthetic */ int[] f2145x982e5cd8;
    private GeoFenceRemoveListener listener;
    private Context mContext;
    private List<String> mCurrentGeofenceIds = null;
    private PendingIntent mCurrentIntent;
    private boolean mInProgress = false;
    private LocationClient mLocationClient = null;
    private GeofenceUtils.REMOVE_TYPE mRequestType;

    /* renamed from: $SWITCH_TABLE$com$tapcrowd$tcanalytics$utils$geofence$GeofenceUtils$REMOVE_TYPE */
    static /* synthetic */ int[] m2214x982e5cd8() {
        int[] iArr = f2145x982e5cd8;
        if (iArr == null) {
            iArr = new int[GeofenceUtils.REMOVE_TYPE.values().length];
            try {
                iArr[GeofenceUtils.REMOVE_TYPE.INTENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[GeofenceUtils.REMOVE_TYPE.LIST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            f2145x982e5cd8 = iArr;
        }
        return iArr;
    }

    public GeofenceRemover(Context context, GeoFenceRemoveListener listener2) {
        this.mContext = context;
        this.listener = listener2;
    }

    public void setInProgressFlag(boolean flag) {
        this.mInProgress = flag;
    }

    public boolean getInProgressFlag() {
        return this.mInProgress;
    }

    public void removeGeofencesById(List<String> geofenceIds) throws IllegalArgumentException, UnsupportedOperationException {
        if (geofenceIds == null || geofenceIds.size() == 0) {
            throw new IllegalArgumentException();
        } else if (!this.mInProgress) {
            this.mRequestType = GeofenceUtils.REMOVE_TYPE.LIST;
            this.mCurrentGeofenceIds = geofenceIds;
            requestConnection();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void removeGeofencesByIntent(PendingIntent requestIntent) {
        if (!this.mInProgress) {
            this.mRequestType = GeofenceUtils.REMOVE_TYPE.INTENT;
            this.mCurrentIntent = requestIntent;
            requestConnection();
            return;
        }
        throw new UnsupportedOperationException();
    }

    private void continueRemoveGeofences() {
        switch (m2214x982e5cd8()[this.mRequestType.ordinal()]) {
            case 1:
                this.mLocationClient.removeGeofences(this.mCurrentIntent, (LocationClient.OnRemoveGeofencesResultListener) this);
                return;
            case 2:
                this.mLocationClient.removeGeofences(this.mCurrentGeofenceIds, (LocationClient.OnRemoveGeofencesResultListener) this);
                return;
            default:
                return;
        }
    }

    private void requestConnection() {
        getLocationClient().connect();
    }

    private GooglePlayServicesClient getLocationClient() {
        if (this.mLocationClient == null) {
            this.mLocationClient = new LocationClient(this.mContext, this, this);
        }
        return this.mLocationClient;
    }

    public void onRemoveGeofencesByPendingIntentResult(int statusCode, PendingIntent requestIntent) {
        requestDisconnection();
    }

    public void onRemoveGeofencesByRequestIdsResult(int statusCode, String[] geofenceRequestIds) {
        requestDisconnection();
    }

    private void requestDisconnection() {
        this.mInProgress = false;
        getLocationClient().disconnect();
        if (this.mRequestType == GeofenceUtils.REMOVE_TYPE.INTENT) {
            this.mCurrentIntent.cancel();
        }
        this.listener.onGeofencesRemoved();
    }

    public void onConnected(Bundle arg0) {
        continueRemoveGeofences();
    }

    public void onDisconnected() {
        this.mInProgress = false;
        this.mLocationClient = null;
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.mInProgress = false;
        if (connectionResult.hasResolution()) {
            try {
                if (this.mContext instanceof Activity) {
                    connectionResult.startResolutionForResult((Activity) this.mContext, GeofenceUtils.CONNECTION_FAILURE_RESOLUTION_REQUEST);
                }
            } catch (IntentSender.SendIntentException e) {
                e.printStackTrace();
            }
        }
        this.listener.onGeofencesRemovedFailed();
    }
}
