package mono.com.google.android.gms.location;

import android.location.Location;
import com.google.android.gms.location.LocationListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class LocationListenerImplementor implements IGCUserPeer, LocationListener {
    public static final String __md_methods = "n_onLocationChanged:(Landroid/location/Location;)V:GetOnLocationChanged_Landroid_location_Location_Handler:Android.Gms.Location.ILocationListenerInvoker, Xamarin.GooglePlayServices.Location\n";
    private ArrayList refList;

    private native void n_onLocationChanged(Location location);

    static {
        Runtime.register("Android.Gms.Location.ILocationListenerImplementor, Xamarin.GooglePlayServices.Location, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", LocationListenerImplementor.class, __md_methods);
    }

    public LocationListenerImplementor() throws Throwable {
        if (getClass() == LocationListenerImplementor.class) {
            TypeManager.Activate("Android.Gms.Location.ILocationListenerImplementor, Xamarin.GooglePlayServices.Location, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onLocationChanged(Location location) {
        n_onLocationChanged(location);
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
