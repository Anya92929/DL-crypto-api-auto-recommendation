package mono.com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polygon;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class GoogleMap_OnPolygonClickListenerImplementor implements IGCUserPeer, GoogleMap.OnPolygonClickListener {
    public static final String __md_methods = "n_onPolygonClick:(Lcom/google/android/gms/maps/model/Polygon;)V:GetOnPolygonClick_Lcom_google_android_gms_maps_model_Polygon_Handler:Android.Gms.Maps.GoogleMap/IOnPolygonClickListenerInvoker, Xamarin.GooglePlayServices.Maps\n";
    private ArrayList refList;

    private native void n_onPolygonClick(Polygon polygon);

    static {
        Runtime.register("Android.Gms.Maps.GoogleMap+IOnPolygonClickListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", GoogleMap_OnPolygonClickListenerImplementor.class, __md_methods);
    }

    public GoogleMap_OnPolygonClickListenerImplementor() throws Throwable {
        if (getClass() == GoogleMap_OnPolygonClickListenerImplementor.class) {
            TypeManager.Activate("Android.Gms.Maps.GoogleMap+IOnPolygonClickListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onPolygonClick(Polygon polygon) {
        n_onPolygonClick(polygon);
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
