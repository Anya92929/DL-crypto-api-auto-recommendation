package md531f8cc8d4d39b2fa02686ee0eb368905;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class GoogleApiClientConnectionCallbacksImpl implements IGCUserPeer, GoogleApiClient.ConnectionCallbacks {
    public static final String __md_methods = "n_onConnected:(Landroid/os/Bundle;)V:GetOnConnected_Landroid_os_Bundle_Handler:Android.Gms.Common.Apis.GoogleApiClient/IConnectionCallbacksInvoker, Xamarin.GooglePlayServices.Basement\nn_onConnectionSuspended:(I)V:GetOnConnectionSuspended_IHandler:Android.Gms.Common.Apis.GoogleApiClient/IConnectionCallbacksInvoker, Xamarin.GooglePlayServices.Basement\n";
    private ArrayList refList;

    private native void n_onConnected(Bundle bundle);

    private native void n_onConnectionSuspended(int i);

    static {
        Runtime.register("Android.Gms.Common.Apis.GoogleApiClientConnectionCallbacksImpl, Xamarin.GooglePlayServices.Basement, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", GoogleApiClientConnectionCallbacksImpl.class, __md_methods);
    }

    public GoogleApiClientConnectionCallbacksImpl() throws Throwable {
        if (getClass() == GoogleApiClientConnectionCallbacksImpl.class) {
            TypeManager.Activate("Android.Gms.Common.Apis.GoogleApiClientConnectionCallbacksImpl, Xamarin.GooglePlayServices.Basement, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onConnected(Bundle bundle) {
        n_onConnected(bundle);
    }

    public void onConnectionSuspended(int i) {
        n_onConnectionSuspended(i);
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
