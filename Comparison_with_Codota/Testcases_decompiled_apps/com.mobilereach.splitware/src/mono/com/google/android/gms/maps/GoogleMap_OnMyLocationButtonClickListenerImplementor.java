package mono.com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class GoogleMap_OnMyLocationButtonClickListenerImplementor implements IGCUserPeer, GoogleMap.OnMyLocationButtonClickListener {
    public static final String __md_methods = "n_onMyLocationButtonClick:()Z:GetOnMyLocationButtonClickHandler:Android.Gms.Maps.GoogleMap/IOnMyLocationButtonClickListenerInvoker, Xamarin.GooglePlayServices.Maps\n";
    private ArrayList refList;

    private native boolean n_onMyLocationButtonClick();

    static {
        Runtime.register("Android.Gms.Maps.GoogleMap+IOnMyLocationButtonClickListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", GoogleMap_OnMyLocationButtonClickListenerImplementor.class, __md_methods);
    }

    public GoogleMap_OnMyLocationButtonClickListenerImplementor() throws Throwable {
        if (getClass() == GoogleMap_OnMyLocationButtonClickListenerImplementor.class) {
            TypeManager.Activate("Android.Gms.Maps.GoogleMap+IOnMyLocationButtonClickListenerImplementor, Xamarin.GooglePlayServices.Maps, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public boolean onMyLocationButtonClick() {
        return n_onMyLocationButtonClick();
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
