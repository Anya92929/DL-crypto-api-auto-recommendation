package mono.com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class StreetViewPanorama_OnStreetViewPanoramaChangeListenerImplementor implements IGCUserPeer, StreetViewPanorama.OnStreetViewPanoramaChangeListener {
    public static final String __md_methods = "n_onStreetViewPanoramaChange:(Lcom/google/android/gms/maps/model/StreetViewPanoramaLocation;)V:GetOnStreetViewPanoramaChange_Lcom_google_android_gms_maps_model_StreetViewPanoramaLocation_Handler:Android.Gms.Maps.StreetViewPanorama/IOnStreetViewPanoramaChangeListenerInvoker, Xamarin.GooglePlayServices.Maps\n";
    private ArrayList refList;

    private native void n_onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation);

    static {
        Runtime.register("Android.Gms.Maps.StreetViewPanorama+IOnStreetViewPanoramaChangeListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", StreetViewPanorama_OnStreetViewPanoramaChangeListenerImplementor.class, __md_methods);
    }

    public StreetViewPanorama_OnStreetViewPanoramaChangeListenerImplementor() throws Throwable {
        if (getClass() == StreetViewPanorama_OnStreetViewPanoramaChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Gms.Maps.StreetViewPanorama+IOnStreetViewPanoramaChangeListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation) {
        n_onStreetViewPanoramaChange(streetViewPanoramaLocation);
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
