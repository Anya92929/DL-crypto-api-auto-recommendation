package mono.com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class GoogleApiClient_OnConnectionFailedListenerImplementor implements IGCUserPeer, GoogleApiClient.OnConnectionFailedListener {
    public static final String __md_methods = "n_onConnectionFailed:(Lcom/google/android/gms/common/ConnectionResult;)V:GetOnConnectionFailed_Lcom_google_android_gms_common_ConnectionResult_Handler:Android.Gms.Common.Apis.GoogleApiClient/IOnConnectionFailedListenerInvoker, Xamarin.GooglePlayServices.Basement\n";
    private ArrayList refList;

    private native void n_onConnectionFailed(ConnectionResult connectionResult);

    static {
        Runtime.register("Android.Gms.Common.Apis.GoogleApiClient+IOnConnectionFailedListenerImplementor, Xamarin.GooglePlayServices.Basement, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", GoogleApiClient_OnConnectionFailedListenerImplementor.class, __md_methods);
    }

    public GoogleApiClient_OnConnectionFailedListenerImplementor() throws Throwable {
        if (getClass() == GoogleApiClient_OnConnectionFailedListenerImplementor.class) {
            TypeManager.Activate("Android.Gms.Common.Apis.GoogleApiClient+IOnConnectionFailedListenerImplementor, Xamarin.GooglePlayServices.Basement, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        n_onConnectionFailed(connectionResult);
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
