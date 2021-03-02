package mono.com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class StreetViewPanorama_OnStreetViewPanoramaClickListenerImplementor implements IGCUserPeer, StreetViewPanorama.OnStreetViewPanoramaClickListener {
    public static final String __md_methods = "n_onStreetViewPanoramaClick:(Lcom/google/android/gms/maps/model/StreetViewPanoramaOrientation;)V:GetOnStreetViewPanoramaClick_Lcom_google_android_gms_maps_model_StreetViewPanoramaOrientation_Handler:Android.Gms.Maps.StreetViewPanorama/IOnStreetViewPanoramaClickListenerInvoker, Xamarin.GooglePlayServices.Maps\n";
    private ArrayList refList;

    private native void n_onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);

    static {
        Runtime.register("Android.Gms.Maps.StreetViewPanorama+IOnStreetViewPanoramaClickListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", StreetViewPanorama_OnStreetViewPanoramaClickListenerImplementor.class, __md_methods);
    }

    public StreetViewPanorama_OnStreetViewPanoramaClickListenerImplementor() throws Throwable {
        if (getClass() == StreetViewPanorama_OnStreetViewPanoramaClickListenerImplementor.class) {
            TypeManager.Activate("Android.Gms.Maps.StreetViewPanorama+IOnStreetViewPanoramaClickListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        n_onStreetViewPanoramaClick(streetViewPanoramaOrientation);
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
