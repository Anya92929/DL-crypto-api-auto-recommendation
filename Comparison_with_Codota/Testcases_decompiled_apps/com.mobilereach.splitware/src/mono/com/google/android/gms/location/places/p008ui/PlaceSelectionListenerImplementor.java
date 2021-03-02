package mono.com.google.android.gms.location.places.p008ui;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.p003ui.PlaceSelectionListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* renamed from: mono.com.google.android.gms.location.places.ui.PlaceSelectionListenerImplementor */
public class PlaceSelectionListenerImplementor implements IGCUserPeer, PlaceSelectionListener {
    public static final String __md_methods = "n_onError:(Lcom/google/android/gms/common/api/Status;)V:GetOnError_Lcom_google_android_gms_common_api_Status_Handler:Android.Gms.Location.Places.UI.IPlaceSelectionListenerInvoker, Xamarin.GooglePlayServices.Location\nn_onPlaceSelected:(Lcom/google/android/gms/location/places/Place;)V:GetOnPlaceSelected_Lcom_google_android_gms_location_places_Place_Handler:Android.Gms.Location.Places.UI.IPlaceSelectionListenerInvoker, Xamarin.GooglePlayServices.Location\n";
    private ArrayList refList;

    private native void n_onError(Status status);

    private native void n_onPlaceSelected(Place place);

    static {
        Runtime.register("Android.Gms.Location.Places.UI.IPlaceSelectionListenerImplementor, Xamarin.GooglePlayServices.Location, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", PlaceSelectionListenerImplementor.class, __md_methods);
    }

    public PlaceSelectionListenerImplementor() throws Throwable {
        if (getClass() == PlaceSelectionListenerImplementor.class) {
            TypeManager.Activate("Android.Gms.Location.Places.UI.IPlaceSelectionListenerImplementor, Xamarin.GooglePlayServices.Location, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onError(Status status) {
        n_onError(status);
    }

    public void onPlaceSelected(Place place) {
        n_onPlaceSelected(place);
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
