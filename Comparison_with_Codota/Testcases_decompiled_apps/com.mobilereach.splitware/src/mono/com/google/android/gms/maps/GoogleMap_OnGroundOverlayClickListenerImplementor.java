package mono.com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.GroundOverlay;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class GoogleMap_OnGroundOverlayClickListenerImplementor implements IGCUserPeer, GoogleMap.OnGroundOverlayClickListener {
    public static final String __md_methods = "n_onGroundOverlayClick:(Lcom/google/android/gms/maps/model/GroundOverlay;)V:GetOnGroundOverlayClick_Lcom_google_android_gms_maps_model_GroundOverlay_Handler:Android.Gms.Maps.GoogleMap/IOnGroundOverlayClickListenerInvoker, Xamarin.GooglePlayServices.Maps\n";
    private ArrayList refList;

    private native void n_onGroundOverlayClick(GroundOverlay groundOverlay);

    static {
        Runtime.register("Android.Gms.Maps.GoogleMap+IOnGroundOverlayClickListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", GoogleMap_OnGroundOverlayClickListenerImplementor.class, __md_methods);
    }

    public GoogleMap_OnGroundOverlayClickListenerImplementor() throws Throwable {
        if (getClass() == GoogleMap_OnGroundOverlayClickListenerImplementor.class) {
            TypeManager.Activate("Android.Gms.Maps.GoogleMap+IOnGroundOverlayClickListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onGroundOverlayClick(GroundOverlay groundOverlay) {
        n_onGroundOverlayClick(groundOverlay);
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
