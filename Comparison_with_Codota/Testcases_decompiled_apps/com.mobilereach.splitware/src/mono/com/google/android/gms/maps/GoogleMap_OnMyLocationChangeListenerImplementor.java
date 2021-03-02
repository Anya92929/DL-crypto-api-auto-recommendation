package mono.com.google.android.gms.maps;

import android.location.Location;
import com.google.android.gms.maps.GoogleMap;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class GoogleMap_OnMyLocationChangeListenerImplementor implements IGCUserPeer, GoogleMap.OnMyLocationChangeListener {
    public static final String __md_methods = "n_onMyLocationChange:(Landroid/location/Location;)V:GetOnMyLocationChange_Landroid_location_Location_Handler:Android.Gms.Maps.GoogleMap/IOnMyLocationChangeListenerInvoker, Xamarin.GooglePlayServices.Maps\n";
    private ArrayList refList;

    private native void n_onMyLocationChange(Location location);

    static {
        Runtime.register("Android.Gms.Maps.GoogleMap+IOnMyLocationChangeListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", GoogleMap_OnMyLocationChangeListenerImplementor.class, __md_methods);
    }

    public GoogleMap_OnMyLocationChangeListenerImplementor() throws Throwable {
        if (getClass() == GoogleMap_OnMyLocationChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Gms.Maps.GoogleMap+IOnMyLocationChangeListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onMyLocationChange(Location location) {
        n_onMyLocationChange(location);
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
