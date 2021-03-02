package md529e4c2c8a026201f3a493bfa20264e47;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class GPS implements IGCUserPeer, LocationListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public static final String __md_methods = "n_onLocationChanged:(Landroid/location/Location;)V:GetOnLocationChanged_Landroid_location_Location_Handler:Android.Gms.Location.ILocationListenerInvoker, Xamarin.GooglePlayServices.Location\nn_onConnected:(Landroid/os/Bundle;)V:GetOnConnected_Landroid_os_Bundle_Handler:Android.Gms.Common.Apis.GoogleApiClient/IConnectionCallbacksInvoker, Xamarin.GooglePlayServices.Basement\nn_onConnectionSuspended:(I)V:GetOnConnectionSuspended_IHandler:Android.Gms.Common.Apis.GoogleApiClient/IConnectionCallbacksInvoker, Xamarin.GooglePlayServices.Basement\nn_onConnectionFailed:(Lcom/google/android/gms/common/ConnectionResult;)V:GetOnConnectionFailed_Lcom_google_android_gms_common_ConnectionResult_Handler:Android.Gms.Common.Apis.GoogleApiClient/IOnConnectionFailedListenerInvoker, Xamarin.GooglePlayServices.Basement\n";
    private ArrayList refList;

    private native void n_onConnected(Bundle bundle);

    private native void n_onConnectionFailed(ConnectionResult connectionResult);

    private native void n_onConnectionSuspended(int i);

    private native void n_onLocationChanged(Location location);

    static {
        Runtime.register("UI.GPS, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", GPS.class, __md_methods);
    }

    public GPS() throws Throwable {
        if (getClass() == GPS.class) {
            TypeManager.Activate("UI.GPS, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onLocationChanged(Location location) {
        n_onLocationChanged(location);
    }

    public void onConnected(Bundle bundle) {
        n_onConnected(bundle);
    }

    public void onConnectionSuspended(int i) {
        n_onConnectionSuspended(i);
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        n_onConnectionFailed(connectionResult);
    }

    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    public void monodroidClearReferences() {
        if (this.refList != null) {
            this.refList.clear();
        }
    }
}
