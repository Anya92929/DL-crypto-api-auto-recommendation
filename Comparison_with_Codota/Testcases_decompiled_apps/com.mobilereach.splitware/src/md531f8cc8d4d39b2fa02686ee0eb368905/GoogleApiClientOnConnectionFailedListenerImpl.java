package md531f8cc8d4d39b2fa02686ee0eb368905;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class GoogleApiClientOnConnectionFailedListenerImpl implements IGCUserPeer, GoogleApiClient.OnConnectionFailedListener {
    public static final String __md_methods = "n_onConnectionFailed:(Lcom/google/android/gms/common/ConnectionResult;)V:GetOnConnectionFailed_Lcom_google_android_gms_common_ConnectionResult_Handler:Android.Gms.Common.Apis.GoogleApiClient/IOnConnectionFailedListenerInvoker, Xamarin.GooglePlayServices.Basement\n";
    private ArrayList refList;

    private native void n_onConnectionFailed(ConnectionResult connectionResult);

    static {
        Runtime.register("Android.Gms.Common.Apis.GoogleApiClientOnConnectionFailedListenerImpl, Xamarin.GooglePlayServices.Basement, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", GoogleApiClientOnConnectionFailedListenerImpl.class, __md_methods);
    }

    public GoogleApiClientOnConnectionFailedListenerImpl() throws Throwable {
        if (getClass() == GoogleApiClientOnConnectionFailedListenerImpl.class) {
            TypeManager.Activate("Android.Gms.Common.Apis.GoogleApiClientOnConnectionFailedListenerImpl, Xamarin.GooglePlayServices.Basement, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
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
