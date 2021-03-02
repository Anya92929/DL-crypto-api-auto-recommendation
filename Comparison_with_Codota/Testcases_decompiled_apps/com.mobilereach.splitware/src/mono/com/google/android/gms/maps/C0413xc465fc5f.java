package mono.com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* renamed from: mono.com.google.android.gms.maps.StreetViewPanorama_OnStreetViewPanoramaCameraChangeListenerImplementor */
public class C0413xc465fc5f implements IGCUserPeer, StreetViewPanorama.OnStreetViewPanoramaCameraChangeListener {
    public static final String __md_methods = "n_onStreetViewPanoramaCameraChange:(Lcom/google/android/gms/maps/model/StreetViewPanoramaCamera;)V:GetOnStreetViewPanoramaCameraChange_Lcom_google_android_gms_maps_model_StreetViewPanoramaCamera_Handler:Android.Gms.Maps.StreetViewPanorama/IOnStreetViewPanoramaCameraChangeListenerInvoker, Xamarin.GooglePlayServices.Maps\n";
    private ArrayList refList;

    private native void n_onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera);

    static {
        Runtime.register("Android.Gms.Maps.StreetViewPanorama+IOnStreetViewPanoramaCameraChangeListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", C0413xc465fc5f.class, __md_methods);
    }

    public C0413xc465fc5f() throws Throwable {
        if (getClass() == C0413xc465fc5f.class) {
            TypeManager.Activate("Android.Gms.Maps.StreetViewPanorama+IOnStreetViewPanoramaCameraChangeListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        n_onStreetViewPanoramaCameraChange(streetViewPanoramaCamera);
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
