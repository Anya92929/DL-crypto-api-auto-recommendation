package md531f8cc8d4d39b2fa02686ee0eb368905;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ResultCallback_1 implements IGCUserPeer, ResultCallback {
    public static final String __md_methods = "n_onResult:(Lcom/google/android/gms/common/api/Result;)V:GetOnResult_Lcom_google_android_gms_common_api_Result_Handler:Android.Gms.Common.Apis.IResultCallbackInvoker, Xamarin.GooglePlayServices.Basement\n";
    private ArrayList refList;

    private native void n_onResult(Result result);

    static {
        Runtime.register("Android.Gms.Common.Apis.ResultCallback`1, Xamarin.GooglePlayServices.Basement, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", ResultCallback_1.class, __md_methods);
    }

    public ResultCallback_1() throws Throwable {
        if (getClass() == ResultCallback_1.class) {
            TypeManager.Activate("Android.Gms.Common.Apis.ResultCallback`1, Xamarin.GooglePlayServices.Basement, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onResult(Result result) {
        n_onResult(result);
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
