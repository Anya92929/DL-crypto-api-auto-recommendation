package md5f9df3643678d96b24d7c271c54ce6e2d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ListViewMap_MapCtrl extends ViewGroup implements IGCUserPeer, OnMapReadyCallback {
    public static final String __md_methods = "n_getSuggestedMinimumHeight:()I:GetGetSuggestedMinimumHeightHandler\nn_onMeasure:(II)V:GetOnMeasure_IIHandler\nn_onLayout:(ZIIII)V:GetOnLayout_ZIIIIHandler\nn_onMapReady:(Lcom/google/android/gms/maps/GoogleMap;)V:GetOnMapReady_Lcom_google_android_gms_maps_GoogleMap_Handler:Android.Gms.Maps.IOnMapReadyCallbackInvoker, Xamarin.GooglePlayServices.Maps\n";
    private ArrayList refList;

    private native int n_getSuggestedMinimumHeight();

    private native void n_onLayout(boolean z, int i, int i2, int i3, int i4);

    private native void n_onMapReady(GoogleMap googleMap);

    private native void n_onMeasure(int i, int i2);

    static {
        Runtime.register("Listview.ListViewMap+MapCtrl, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", ListViewMap_MapCtrl.class, __md_methods);
    }

    public ListViewMap_MapCtrl(Context context) throws Throwable {
        super(context);
        if (getClass() == ListViewMap_MapCtrl.class) {
            TypeManager.Activate("Listview.ListViewMap+MapCtrl, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public ListViewMap_MapCtrl(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == ListViewMap_MapCtrl.class) {
            TypeManager.Activate("Listview.ListViewMap+MapCtrl, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public ListViewMap_MapCtrl(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == ListViewMap_MapCtrl.class) {
            TypeManager.Activate("Listview.ListViewMap+MapCtrl, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public int getSuggestedMinimumHeight() {
        return n_getSuggestedMinimumHeight();
    }

    public void onMeasure(int i, int i2) {
        n_onMeasure(i, i2);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        n_onLayout(z, i, i2, i3, i4);
    }

    public void onMapReady(GoogleMap googleMap) {
        n_onMapReady(googleMap);
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
