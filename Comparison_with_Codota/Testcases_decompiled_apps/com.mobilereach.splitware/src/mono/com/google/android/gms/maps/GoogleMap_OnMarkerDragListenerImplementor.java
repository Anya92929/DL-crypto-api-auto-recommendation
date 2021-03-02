package mono.com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class GoogleMap_OnMarkerDragListenerImplementor implements IGCUserPeer, GoogleMap.OnMarkerDragListener {
    public static final String __md_methods = "n_onMarkerDrag:(Lcom/google/android/gms/maps/model/Marker;)V:GetOnMarkerDrag_Lcom_google_android_gms_maps_model_Marker_Handler:Android.Gms.Maps.GoogleMap/IOnMarkerDragListenerInvoker, Xamarin.GooglePlayServices.Maps\nn_onMarkerDragEnd:(Lcom/google/android/gms/maps/model/Marker;)V:GetOnMarkerDragEnd_Lcom_google_android_gms_maps_model_Marker_Handler:Android.Gms.Maps.GoogleMap/IOnMarkerDragListenerInvoker, Xamarin.GooglePlayServices.Maps\nn_onMarkerDragStart:(Lcom/google/android/gms/maps/model/Marker;)V:GetOnMarkerDragStart_Lcom_google_android_gms_maps_model_Marker_Handler:Android.Gms.Maps.GoogleMap/IOnMarkerDragListenerInvoker, Xamarin.GooglePlayServices.Maps\n";
    private ArrayList refList;

    private native void n_onMarkerDrag(Marker marker);

    private native void n_onMarkerDragEnd(Marker marker);

    private native void n_onMarkerDragStart(Marker marker);

    static {
        Runtime.register("Android.Gms.Maps.GoogleMap+IOnMarkerDragListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", GoogleMap_OnMarkerDragListenerImplementor.class, __md_methods);
    }

    public GoogleMap_OnMarkerDragListenerImplementor() throws Throwable {
        if (getClass() == GoogleMap_OnMarkerDragListenerImplementor.class) {
            TypeManager.Activate("Android.Gms.Maps.GoogleMap+IOnMarkerDragListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onMarkerDrag(Marker marker) {
        n_onMarkerDrag(marker);
    }

    public void onMarkerDragEnd(Marker marker) {
        n_onMarkerDragEnd(marker);
    }

    public void onMarkerDragStart(Marker marker) {
        n_onMarkerDragStart(marker);
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
