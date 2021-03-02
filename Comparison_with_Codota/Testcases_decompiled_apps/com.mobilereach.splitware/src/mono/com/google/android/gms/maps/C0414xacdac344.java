package mono.com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* renamed from: mono.com.google.android.gms.maps.StreetViewPanorama_OnStreetViewPanoramaLongClickListenerImplementor */
public class C0414xacdac344 implements IGCUserPeer, StreetViewPanorama.OnStreetViewPanoramaLongClickListener {
    public static final String __md_methods = "n_onStreetViewPanoramaLongClick:(Lcom/google/android/gms/maps/model/StreetViewPanoramaOrientation;)V:GetOnStreetViewPanoramaLongClick_Lcom_google_android_gms_maps_model_StreetViewPanoramaOrientation_Handler:Android.Gms.Maps.StreetViewPanorama/IOnStreetViewPanoramaLongClickListenerInvoker, Xamarin.GooglePlayServices.Maps\n";
    private ArrayList refList;

    private native void n_onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);

    static {
        Runtime.register("Android.Gms.Maps.StreetViewPanorama+IOnStreetViewPanoramaLongClickListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", C0414xacdac344.class, __md_methods);
    }

    public C0414xacdac344() throws Throwable {
        if (getClass() == C0414xacdac344.class) {
            TypeManager.Activate("Android.Gms.Maps.StreetViewPanorama+IOnStreetViewPanoramaLongClickListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        n_onStreetViewPanoramaLongClick(streetViewPanoramaOrientation);
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
