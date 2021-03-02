package mono.com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class GoogleMap_OnCameraChangeListenerImplementor implements IGCUserPeer, GoogleMap.OnCameraChangeListener {
    public static final String __md_methods = "n_onCameraChange:(Lcom/google/android/gms/maps/model/CameraPosition;)V:GetOnCameraChange_Lcom_google_android_gms_maps_model_CameraPosition_Handler:Android.Gms.Maps.GoogleMap/IOnCameraChangeListenerInvoker, Xamarin.GooglePlayServices.Maps\n";
    private ArrayList refList;

    private native void n_onCameraChange(CameraPosition cameraPosition);

    static {
        Runtime.register("Android.Gms.Maps.GoogleMap+IOnCameraChangeListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", GoogleMap_OnCameraChangeListenerImplementor.class, __md_methods);
    }

    public GoogleMap_OnCameraChangeListenerImplementor() throws Throwable {
        if (getClass() == GoogleMap_OnCameraChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Gms.Maps.GoogleMap+IOnCameraChangeListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        n_onCameraChange(cameraPosition);
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
