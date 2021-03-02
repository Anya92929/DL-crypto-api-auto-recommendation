package mono.android.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class LocationListenerImplementor implements IGCUserPeer, LocationListener {
    public static final String __md_methods = "n_onLocationChanged:(Landroid/location/Location;)V:GetOnLocationChanged_Landroid_location_Location_Handler:Android.Locations.ILocationListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onProviderDisabled:(Ljava/lang/String;)V:GetOnProviderDisabled_Ljava_lang_String_Handler:Android.Locations.ILocationListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onProviderEnabled:(Ljava/lang/String;)V:GetOnProviderEnabled_Ljava_lang_String_Handler:Android.Locations.ILocationListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onStatusChanged:(Ljava/lang/String;ILandroid/os/Bundle;)V:GetOnStatusChanged_Ljava_lang_String_ILandroid_os_Bundle_Handler:Android.Locations.ILocationListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onLocationChanged(Location location);

    private native void n_onProviderDisabled(String str);

    private native void n_onProviderEnabled(String str);

    private native void n_onStatusChanged(String str, int i, Bundle bundle);

    static {
        Runtime.register("Android.Locations.ILocationListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", LocationListenerImplementor.class, __md_methods);
    }

    public LocationListenerImplementor() throws Throwable {
        if (getClass() == LocationListenerImplementor.class) {
            TypeManager.Activate("Android.Locations.ILocationListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onLocationChanged(Location location) {
        n_onLocationChanged(location);
    }

    public void onProviderDisabled(String str) {
        n_onProviderDisabled(str);
    }

    public void onProviderEnabled(String str) {
        n_onProviderEnabled(str);
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        n_onStatusChanged(str, i, bundle);
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
