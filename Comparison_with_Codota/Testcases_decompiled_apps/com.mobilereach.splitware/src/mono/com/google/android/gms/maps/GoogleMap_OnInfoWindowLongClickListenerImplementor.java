package mono.com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class GoogleMap_OnInfoWindowLongClickListenerImplementor implements IGCUserPeer, GoogleMap.OnInfoWindowLongClickListener {
    public static final String __md_methods = "n_onInfoWindowLongClick:(Lcom/google/android/gms/maps/model/Marker;)V:GetOnInfoWindowLongClick_Lcom_google_android_gms_maps_model_Marker_Handler:Android.Gms.Maps.GoogleMap/IOnInfoWindowLongClickListenerInvoker, Xamarin.GooglePlayServices.Maps\n";
    private ArrayList refList;

    private native void n_onInfoWindowLongClick(Marker marker);

    static {
        Runtime.register("Android.Gms.Maps.GoogleMap+IOnInfoWindowLongClickListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", GoogleMap_OnInfoWindowLongClickListenerImplementor.class, __md_methods);
    }

    public GoogleMap_OnInfoWindowLongClickListenerImplementor() throws Throwable {
        if (getClass() == GoogleMap_OnInfoWindowLongClickListenerImplementor.class) {
            TypeManager.Activate("Android.Gms.Maps.GoogleMap+IOnInfoWindowLongClickListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onInfoWindowLongClick(Marker marker) {
        n_onInfoWindowLongClick(marker);
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
