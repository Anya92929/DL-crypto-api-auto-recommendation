package mono.com.google.android.gms.maps;

import android.location.Location;
import com.google.android.gms.maps.LocationSource;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class LocationSource_OnLocationChangedListenerImplementor implements IGCUserPeer, LocationSource.OnLocationChangedListener {
    public static final String __md_methods = "n_onLocationChanged:(Landroid/location/Location;)V:GetOnLocationChanged_Landroid_location_Location_Handler:Android.Gms.Maps.ILocationSourceOnLocationChangedListenerInvoker, Xamarin.GooglePlayServices.Maps\n";
    private ArrayList refList;

    private native void n_onLocationChanged(Location location);

    static {
        Runtime.register("Android.Gms.Maps.ILocationSourceOnLocationChangedListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", LocationSource_OnLocationChangedListenerImplementor.class, __md_methods);
    }

    public LocationSource_OnLocationChangedListenerImplementor() throws Throwable {
        if (getClass() == LocationSource_OnLocationChangedListenerImplementor.class) {
            TypeManager.Activate("Android.Gms.Maps.ILocationSourceOnLocationChangedListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
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
